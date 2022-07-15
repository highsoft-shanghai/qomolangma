import nock from "nock";
import AxiosHttp from "../../../acl/AxiosHttp";
import {User} from "../../../domain/user/User";
import {EnvironmentUrls} from "../../../frameworks/EnvironmentUrls";

const scope = nock(EnvironmentUrls['test'])
let assignMock: jest.Mock<any, any>

beforeEach(() => {
  scope.get(`/access-tokens/current`).reply(200, {
    "code": "0",
    "msg": "",
    "data": {
      "id": "05103212a7e2426591411ee79a6c0297",
      "userAccountName": "Qomolangma",
      "userName": "Neil",
      "tenantName": "qomolangma.com",
      "accessToken": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblRpbWUiOiIyMDIyLTA3LTE0VDExOjM1OjE3LjMwODg1NloiLCJub3ciOiIyMDIyLTA3LTE0VDExOjM1OjE3LjMxMzEzNVoiLCJpZCI6IjA1MTAzMjEyYTdlMjQyNjU5MTQxMWVlNzlhNmMwMjk3IiwiZXhwIjoxNjU3ODA5MzE3fQ.MDQVqCL8N9pTAOVXMaU07aHoSyZcTHCXehO5QwNDzcY",
      "authorities": [
        "api-fox"
      ]
    }
  }, {'Access-Control-Allow-Origin': '*'})
  scope.post(`/user/login`, {
    "userName": "Neil",
    "password": "123456"
  }).reply(200, {
    "code": "0",
    "msg": "",
    "data": {
      "token": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblRpbWUiOiIyMDIyLTA3LTE1VDA4OjEwOjQyLjg1MDkyNloiLCJub3ciOiIyMDIyLTA3LTE1VDA4OjEwOjQyLjg1NTIwOFoiLCJpZCI6IjQ0NzcxMjE4NzliMDRlNjhiNzRhODI5NDhhNzVmZjZlIiwiZXhwIjoxNjU3ODgzNDQyfQ.ZmvJSA3S3ZUXb8BzhKSWKNd9bAo3Eoi2gq8KRDmLPBw"
    }
  }, {'Access-Control-Allow-Origin': '*'})
  assignMock = jest.fn()
  // @ts-ignore
  delete window.location
  // @ts-ignore
  window.location = {assign: assignMock}
})

test('should fetch current user', async () => {
  let user = await User.findCurrentUser()
  expect(user.id).toBe("05103212a7e2426591411ee79a6c0297")
  expect(user.userAccountName).toBe("Qomolangma")
  expect(user.userName).toBe("Neil")
  expect(user.tenantName).toBe("qomolangma.com")
  expect(user.accessToken).toBe("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblRpbWUiOiIyMDIyLTA3LTE0VDExOjM1OjE3LjMwODg1NloiLCJub3ciOiIyMDIyLTA3LTE0VDExOjM1OjE3LjMxMzEzNVoiLCJpZCI6IjA1MTAzMjEyYTdlMjQyNjU5MTQxMWVlNzlhNmMwMjk3IiwiZXhwIjoxNjU3ODA5MzE3fQ.MDQVqCL8N9pTAOVXMaU07aHoSyZcTHCXehO5QwNDzcY")
  expect(user.authorities).toStrictEqual(["api-fox"])
})

test('should login successfully', async () => {
  let user = new User("Neil", "123456")
  await user.login()
  expect(AxiosHttp.headers).not.toBeUndefined()
  // @ts-ignore
  expect(AxiosHttp.headers.Authorization).toBe("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblRpbWUiOiIyMDIyLTA3LTE1VDA4OjEwOjQyLjg1MDkyNloiLCJub3ciOiIyMDIyLTA3LTE1VDA4OjEwOjQyLjg1NTIwOFoiLCJpZCI6IjQ0NzcxMjE4NzliMDRlNjhiNzRhODI5NDhhNzVmZjZlIiwiZXhwIjoxNjU3ODgzNDQyfQ.ZmvJSA3S3ZUXb8BzhKSWKNd9bAo3Eoi2gq8KRDmLPBw")
})

afterEach(() => {
  scope.removeAllListeners()
  AxiosHttp.reset()
  assignMock.mockClear()
})
