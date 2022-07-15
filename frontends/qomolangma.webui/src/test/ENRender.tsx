import {render} from "@testing-library/react";
import {IntlProvider} from "react-intl";
import {messages} from '../locales/messages'

export class ENRender {
  public static render(ui: any) {
    return render(<>
      <IntlProvider locale={"en-US"} messages={messages["en-US"]}>
        {ui}
      </IntlProvider>
    </>)
  }
}
