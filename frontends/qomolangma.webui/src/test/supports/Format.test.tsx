import {screen} from '@testing-library/react';
import {Format} from '../../locales/format';
import {ENRender} from "../ENRender";
import {ZHRender} from "../ZHRender";

test('should translate message as English', () => {
    ENRender.render(<p>{Format.format("test")}</p>)
    const element = screen.getByText("test translate")
    expect(element).toBeInTheDocument()
})

test('should translate message as Chinese', () => {
    ZHRender.render(<p>{Format.format("test")}</p>)
    const element = screen.getByText("测试翻译")
    expect(element).toBeInTheDocument()
})
