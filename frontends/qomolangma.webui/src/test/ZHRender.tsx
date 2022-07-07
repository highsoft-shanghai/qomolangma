import {render} from "@testing-library/react";
import {IntlProvider} from "react-intl";
import {messages} from '../locales/messages'

export class ZHRender {
    public static render(ui: any) {
        render(<>
            <IntlProvider locale={"zh-CN"} messages={messages["zh-CN"]}>
                {ui}
            </IntlProvider>
        </>)
    }
}
