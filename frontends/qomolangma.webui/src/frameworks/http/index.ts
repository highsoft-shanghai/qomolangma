import {AxiosRequestConfig} from "axios";
import {requestClassDecorator} from "./requestUrl";
import makeSingleton from "../makeSingleton";
import {AxiosHttp} from "../../acl/AxiosHttp";

@requestClassDecorator
export class Http {
    private readonly instance: AxiosHttp
    private requestUrl = ""

    public constructor() {
        this.instance = new AxiosHttp()
    }

    public async get(url: string, options?: AxiosRequestConfig) {
        return this.instance.get(url, this.requestUrl, options);
    }

    public async post(url: string, options: AxiosRequestConfig) {
        return this.instance.post(url, this.requestUrl, options)
    }
}

export default makeSingleton(Http)();
