import makeSingleton from "../../frameworks/makeSingleton";

test('should make singleton when require one singleton object', () => {
  let makeSingletonFunction = makeSingleton(String);
  expect(makeSingletonFunction.apply({})).toStrictEqual(makeSingletonFunction.apply({}))
})
