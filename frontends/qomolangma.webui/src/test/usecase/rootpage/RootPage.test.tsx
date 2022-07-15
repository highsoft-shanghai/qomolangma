import {screen} from '@testing-library/react';
import Root from "../../../pages/root"
import {ENRender} from "../../ENRender";
import nock from "nock";
import {EnvironmentUrls} from '../../../frameworks/EnvironmentUrls';

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

test('should render RootPage in English', () => {
  ENRender.render(new Root(null).render())
  const linkElement = screen.getByText(/learn react/i)
  expect(linkElement).toBeInTheDocument()
  const linkElement2 = screen.getByText(/Qomolangma frontend app./i)
  expect(linkElement2).toBeInTheDocument()
})

test('should set state about user in root', async () => {
  let root = new Root(null);
  await root.componentDidMount()
  expect(root.state.id).toBe("05103212a7e2426591411ee79a6c0297")
})

afterEach(() => {
  scope.removeAllListeners()
})
