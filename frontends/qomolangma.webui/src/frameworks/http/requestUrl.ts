import {EnvironmentUrls} from "../EnvironmentUrls";

export function requestClassDecorator<T extends { new(...args: any[]): any }>(
    constructor: T
) {
    return class extends constructor {
        requestUrl = requestUrl(process.env.NODE_ENV)
    };
}

export function requestUrl(env: string) {
    // @ts-ignore
    return EnvironmentUrls[env] === undefined ? '' : EnvironmentUrls[env]
}

