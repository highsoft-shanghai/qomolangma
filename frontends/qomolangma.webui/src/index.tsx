import React from 'react';
import './index.css';
import App from './App';
import ReactDOM from "react-dom/client";
import {BrowserRouter} from "react-router-dom";
import MultiLanguage from "./components/MultiLanguage";

const root = ReactDOM.createRoot(document.getElementById("root") as HTMLElement);

root.render(
    <BrowserRouter>
        <MultiLanguage ui={<App/>}/>
    </BrowserRouter>
);
