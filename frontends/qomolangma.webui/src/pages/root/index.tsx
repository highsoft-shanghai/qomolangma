import React, {Component} from "react";
import logo from "../../logo.svg";
import './Root.css'
import {Format} from "../../locales/format";
import {User} from "../../domain/user/User";
import Http from "../../frameworks/http";

class Root extends Component<any, User> {
  constructor(props: any) {
    super(props);
    this.state = new User('Not login yet.', '', '', '', [], '', '')
  }

  componentDidMount() {
    User.findCurrentUser()
      .then(user => this.setState(user))
      .catch(e => {
        if (e.message === "error.bad-token") {
          alert('Login expired.')
          Http.reset()
        }
        if (e.message === "error.authentication-required") {
          alert('Not login yet.')
        }
        if (e.message === "Network Error") alert(e.message)
      })
  }

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
          <p>
            {Format.format('current_user')}: {this.state.userName}
          </p>
          <button onClick={this.login.bind(this)}>Login
          </button>
          <button onClick={this.logout.bind(this)}>Logout
          </button>
        </header>
      </div>
    </>;
  }

  public login() {
    window.location.href = "/user/login"
  }

  public logout() {
    Http.reset()
    this.setState(new User('Not login yet.', '', '', '', [], '', ''))
  }
}

export default Root;
