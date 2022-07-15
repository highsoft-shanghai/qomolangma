import React, {Component} from "react";
import './Login.css'
import {User} from "../../domain/user/User";

class Login extends Component<any, any> {
  render() {
    new User("Neil", "123456").login()
    return <>
      UserName, Password
    </>;
  }
}

export default Login;
