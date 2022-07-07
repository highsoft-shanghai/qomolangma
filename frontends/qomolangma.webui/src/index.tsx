import React from 'react';
import './index.css';
import App from './App';
import {createRoot} from "react-dom/client";
import {BrowserRouter} from "react-router-dom";
import {messages} from "./locales/messages";
import {IntlProvider} from "react-intl";

const root = createRoot(document.getElementById("root")!);
let lang = navigator.language
if (lang !== 'en-US' && lang !== 'zh-CN') lang = 'en-US'

root.render(
    <BrowserRouter>
        <IntlProvider locale={lang} messages={messages[lang]}>
            <App/>
        </IntlProvider>
    </BrowserRouter>
);
