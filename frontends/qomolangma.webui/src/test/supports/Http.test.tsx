import nock from 'nock';
import Http from '../../frameworks/http'

const scope = nock('http://localhost:8080')

beforeEach(() => {
    scope.get(`/testHttp/ok`).reply(200, {message: 'ok'}, {'Access-Control-Allow-Origin': '*'})
    scope.get(`/testHttp/okWithParam?param=1`).reply(200, {message: 'ok'}, {'Access-Control-Allow-Origin': '*'})
    scope.get(`/testHttp/error`).reply(500, "Error", {'Access-Control-Allow-Origin': '*'})
})

test('should invoke http request', async () => {
    const res = await Http.get('/testHttp/ok');
    expect(res.message).toBe('ok')
})

test('should invoke get request with params', async () => {
    const res = await Http.get('/testHttp/okWithParam?param=1');
    expect(res.message).toBe('ok')
})

test('should invoke request report error', async () => {
    try {
        await Http.get('/testHttp/error')
    } catch (e) {
        // @ts-ignore
        let actual = e.message;
        // eslint-disable-next-line jest/no-conditional-expect
        expect(actual).toBe('Request failed with status code 500')
    }
})

afterEach(() => {
    scope.removeAllListeners()
})
