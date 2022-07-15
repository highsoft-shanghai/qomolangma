import React, {Component} from "react";
import './Login.css'
import {User} from "../../domain/user/User";

class Login extends Component<any, any> {
  render() {
    return <>
      <div className='login-content'>
        <div className='login-label'>
          UserName: <input className='input' id='userName'/>
        </div>
        <div className='login-label'>
          Password: <input className='input' id='password' type="password"/>
        </div>
        <button onClick={this.login.bind(this)}>Login
        </button>
      </div>
    </>;
  }

  public login() {
    new User(
      // @ts-ignore
      document.getElementById('userName').value,
      // @ts-ignore
      document.getElementById('password').value)
      .login()
      .catch(error => alert(error.message))
  }
}

export default Login;
