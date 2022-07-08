export function requestClassDecorator<T extends { new(...args: any[]): any }>(
    constructor: T
) {
    return class extends constructor {
        requestUrl = 'http://localhost:8080'
    };
}
