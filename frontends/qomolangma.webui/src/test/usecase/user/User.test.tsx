import nock from "nock";
import {User} from "../../../domain/user/User";
import {EnvironmentUrls} from "../../../frameworks/EnvironmentUrls";

const scope = nock(EnvironmentUrls['test'])

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

afterEach(() => {
  scope.removeAllListeners()
})
