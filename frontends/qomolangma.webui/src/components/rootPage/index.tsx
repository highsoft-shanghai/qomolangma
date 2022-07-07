import React, {Component} from "react";
import logo from "../../logo.svg";
import './RootPage.css'
import {Format} from "../../locales/format";

class RootPage extends Component<any, any> {
    render() {
        return <>
            <div className="Main">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <p>
                        {Format.format("project_app")}
                    </p>
                    <a
                        className="App-link"
                        href="https://reactjs.org"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        {Format.format("learn_react")}
                    </a>
                </header>
            </div>
        </>;
    }
}

export default RootPage;
