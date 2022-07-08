import nock from 'nock';
import AxiosHttp from '../../acl/AxiosHttp';
import Http from '../../frameworks/http'
import {EnvironmentUrls} from '../../frameworks/EnvironmentUrls';

const scope = nock(EnvironmentUrls['test'])

beforeEach(() => {
  scope.get(`/testHttp/ok`).reply(200, {message: 'ok'}, {'Access-Control-Allow-Origin': '*'})
  scope.get(`/testHttp/okWithParam?param=1`).reply(200, {message: 'ok'}, {'Access-Control-Allow-Origin': '*'})
  scope.get(`/testHttp/error`).reply(500, "Error", {'Access-Control-Allow-Origin': '*'})
  scope.post(`/testHttp/ok`, {param: 1}).reply(200, {message: 'ok'}, {'Access-Control-Allow-Origin': '*'})
})

test('should invoke http request', async () => {
  const res = await Http.get('/testHttp/ok');
  expect(res.message).toBe('ok')
})

test('should invoke get request with params', async () => {
  const res = await Http.get('/testHttp/okWithParam?param=1');
  expect(res.message).toBe('ok')
})

test('should invoke post request', async () => {
  const res = await Http.post('/testHttp/ok', {data: {param: 1}})
  expect(res.message).toBe('ok')
})

test('should response error throw', async () => {
  expect(() => AxiosHttp.response({
    data: 'Request failed with status code 500',
    status: 500,
    statusText: 'Request failed with status code 500',
    headers: {},
    config: {}
  })).toThrowError('')
})

afterEach(() => {
  scope.removeAllListeners()
})
