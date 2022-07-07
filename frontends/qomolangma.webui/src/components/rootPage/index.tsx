import React, {Component} from "react";
import logo from "../../logo.svg";
import './RootPage.css'

class RootPage extends Component<any, any> {
    render() {
        return <>
            <div className="Main">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <p>
                        Qomolangma frontend app.
                    </p>
                    <p>
                        Edit <code>src/App.tsx</code> and save to reload.
                    </p>
                    <a
                        className="App-link"
                        href="https://reactjs.org"
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        Learn React
                    </a>
                </header>
            </div>
        </>;
    }
}

export default RootPage;
