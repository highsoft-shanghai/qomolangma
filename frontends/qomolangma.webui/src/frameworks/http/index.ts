import axios, {AxiosInstance, AxiosRequestConfig, AxiosResponse} from "axios";
import {requestClassDecorator} from "./requestUrl";
import makeSingleton from "../makeSingleton";

@requestClassDecorator
export class Http {
    private readonly instance: AxiosInstance
    private requestUrl = ""

    public constructor() {
        this.instance = axios.create({
            timeout: 10 * 1000
        });
    }

    public async get(url: string, options?: AxiosRequestConfig) {
        const response = await this.instance.get(
            url,
            Object.assign(options || {}, {baseURL: this.requestUrl})
        );
        return this.response(response)
    }

    public async post(url: string, options: AxiosRequestConfig) {
        const response = await this.instance.post(
            this.requestUrl + url,
            options.data
        );
        return this.response(response);
    }

    response(response: AxiosResponse<any>) {
        if (response.status === 200) return response.data
        else {
            throw new Error()
        }
    }
}

export default makeSingleton(Http)();
