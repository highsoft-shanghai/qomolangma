import React, {Component} from "react";
import {IntlProvider} from "react-intl";
import {messages} from "../locales/messages";

class MultiLanguage extends Component<any, any> {
  render() {
    const lang = MultiLanguage.languageOrDefault(navigator.language);
    return <>
      <IntlProvider locale={lang} messages={messages[lang]}>
        {this.props.ui}
      </IntlProvider>
    </>
  }

  public static languageOrDefault(lang: string) {
    if (lang !== 'en-US' && lang !== 'zh-CN') return 'en-US'
    return lang;
  }
}

export default MultiLanguage
