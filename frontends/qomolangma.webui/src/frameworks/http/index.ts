import {AxiosRequestConfig} from "axios";
import {requestClassDecorator} from "./requestUrl";
import makeSingleton from "../makeSingleton";
import AxiosHttp from "../../acl/AxiosHttp";
import {User} from "../../domain/user/User";

@requestClassDecorator
export class Http {
  private readonly instance
  private requestUrl = ""

  public constructor() {
    this.instance = AxiosHttp
  }

  public async get(url: string, options?: AxiosRequestConfig) {
    return this.instance.get(url, this.requestUrl, options);
  }

  public async post(url: string, options: AxiosRequestConfig) {
    return this.instance.post(url, this.requestUrl, options)
  }

  public async login(user: User) {
    await this.instance.login(this.requestUrl, user)
  }
}

export default makeSingleton(Http)();
