import {render, screen} from '@testing-library/react';
import {Format} from '../../locales/format';
import {IntlProvider} from "react-intl";
import {messages} from '../../locales/messages';

test('should translate message as English', () => {
    render(<>
        <IntlProvider locale={"en-US"} messages={messages["en-US"]}>
            <p>{Format.format("test")}</p>
        </IntlProvider>

    </>)
    const element = screen.getByText("test translate")
    expect(element).toBeInTheDocument()
})

test('should translate message as Chinese', () => {
    render(<>
        <IntlProvider locale={"zh-CN"} messages={messages["zh-CN"]}>
            <p>{Format.format("test")}</p>
        </IntlProvider>

    </>)
    const element = screen.getByText("测试翻译")
    expect(element).toBeInTheDocument()
})
