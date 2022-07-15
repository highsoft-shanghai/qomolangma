import Root from "../../../pages/root"
import nock from "nock";
import {EnvironmentUrls} from '../../../frameworks/EnvironmentUrls';

const scope = nock(EnvironmentUrls['test'])
let assignMock: jest.Mock<any, any>

beforeEach(() => {
  scope.get(`/access-tokens/current`).reply(200, {
    "code": "1",
    "msg": "error.authority-required",
    "data": null
  }, {'Access-Control-Allow-Origin': '*'})
  assignMock = jest.fn()
  // @ts-ignore
  delete window.location
  // @ts-ignore
  window.location = {assign: assignMock}
})

test('should render to another page if authority required', async () => {
  let root = new Root(null);
  await root.componentDidMount()
  expect(root.state).toBe(undefined)
})

afterEach(() => {
  scope.removeAllListeners()
  assignMock.mockClear()
})
