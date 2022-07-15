import axios, {AxiosInstance, AxiosRequestConfig, AxiosResponse} from "axios";
import {User} from "../../domain/user/User";
import makeSingleton from "../../frameworks/makeSingleton";

export class AxiosHttp {
  public buildAxios(): AxiosInstance {
    return axios.create({
      timeout: 10 * 1000,
      headers: this.headers
    });
  }

  public async get(url: string, requestUrl: string, options?: AxiosRequestConfig) {
    const response = await this.buildAxios().get(
      url,
      Object.assign(options || {}, {baseURL: requestUrl})
    );
    return this.response(response)
  }

  public async post(url: string, requestUrl: string, options: AxiosRequestConfig) {
    const response = await this.buildAxios().post(requestUrl + url, options.data);
    return this.response(response);
  }

  async login(requestUrl: string, user: User) {
    let res = await this.post("/user/login", requestUrl, user.loginContext())
    localStorage.setItem("Qomolangma Token", res.token)
  }

  get headers(): { Authorization: string } | undefined {
    if (localStorage.getItem("Qomolangma Token") === null) return undefined
    // @ts-ignore
    return {Authorization: localStorage.getItem("Qomolangma Token")}
  }

  public response(response: AxiosResponse<any>) {
    if (response.status !== 200) throw new Error("Error, server exception.")
    if (response.data.code === "0") return response.data.data
    else throw new Error(response.data.msg)
  }

  public reset() {
    localStorage.removeItem("Qomolangma Token")
  }
}

export default makeSingleton(AxiosHttp)();
