import React from 'react';
import './index.css';
import App from './App';
import {createRoot} from "react-dom/client";
import {BrowserRouter} from "react-router-dom";
import MultiLanguage from "./components/MultiLanguage";

const root = createRoot(document.getElementById("root")!);

root.render(
    <BrowserRouter>
        <MultiLanguage ui={<App/>}/>
    </BrowserRouter>
);
