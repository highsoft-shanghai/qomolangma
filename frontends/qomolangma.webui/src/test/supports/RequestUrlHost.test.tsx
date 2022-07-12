import {requestUrl} from '../../frameworks/http/requestUrl'

test('should return test url in test env', () => {
  expect(requestUrl("test")).toBe('https://test')
})

test('should return localhost in dev env', () => {
  expect(requestUrl("development")).toBe('http://localhost:8080')
})

test('should return empty when incorrect env', () => {
  expect(requestUrl("incorrect")).toBe('')
})
