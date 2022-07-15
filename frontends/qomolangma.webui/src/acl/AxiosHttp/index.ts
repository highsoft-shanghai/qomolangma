import axios, {AxiosInstance, AxiosRequestConfig, AxiosResponse} from "axios";
import {User} from "../../domain/user/User";
import makeSingleton from "../../frameworks/makeSingleton";

export class AxiosHttp {
  private readonly impl: AxiosInstance
  private _headers: { Authorization: string } | undefined

  public constructor() {
    this.impl = axios.create({
      timeout: 10 * 1000,
      headers: this._headers
    });
  }

  public async get(url: string, requestUrl: string, options?: AxiosRequestConfig) {
    const response = await this.impl.get(
      url,
      Object.assign(options || {}, {baseURL: requestUrl})
    );
    return this.response(response)
  }

  public async post(url: string, requestUrl: string, options: AxiosRequestConfig) {
    const response = await this.impl.post(requestUrl + url, options.data);
    return this.response(response);
  }

  async login(requestUrl: string, user: User) {
    let res = await this.post("/user/login", requestUrl, user.loginContext())
    this._headers = {Authorization: res.token}
  }

  get headers(): { Authorization: string } | undefined {
    return this._headers;
  }

  public response(response: AxiosResponse<any>) {
    if (response.status !== 200) throw new Error("Error, server exception.")
    if (response.data.code === "0") return response.data.data
    else throw new Error(response.data.msg)
  }

  public reset() {
    this._headers = undefined
  }
}

export default makeSingleton(AxiosHttp)();
