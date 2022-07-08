import {requestUrl} from '../../frameworks/http/requestUrl'

test('should return localhost in test env', () => {
    expect(requestUrl("test")).toBe('http://localhost:8080')
})

test('should return empty when incorrect env', () => {
    expect(requestUrl("incorrect")).toBe('')
})
