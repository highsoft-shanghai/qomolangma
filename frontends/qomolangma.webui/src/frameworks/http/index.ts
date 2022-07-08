import axios, {AxiosInstance, AxiosRequestConfig} from "axios";
import {requestClassDecorator} from "./requestUrl";
import makeSingleton from "../makeSingleton";

@requestClassDecorator
export class Http {
    private readonly instance: AxiosInstance;
    private requestUrl = "";

    public constructor(props: AxiosRequestConfig) {
        this.instance = axios.create({
            timeout: (props && props.timeout) || 10 * 1000
        });
    }

    public async get(url: string, options?: AxiosRequestConfig) {
        const response = await this.instance.get(
            url,
            Object.assign(options || {}, {baseURL: this.requestUrl})
        );
        //eslint-disable-next-line
        if (response.status == 200) {
            return response.data;
        } else {
            throw new Error();
        }
    }

    public async post(url: string, options: AxiosRequestConfig) {
        const response = await this.instance.post(
            this.requestUrl + url,
            options.data
        );

        //eslint-disable-next-line
        if (response.status == 200) {
            return response.data.data;
        } else {
            throw new Error();
        }
    }

    public getInstance() {
        return this.instance;
    }
}

export default makeSingleton(Http)();
