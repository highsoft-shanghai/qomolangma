import React, {Component} from "react";
import './Login.css'

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
        <button>Login</button>
      </div>
    </>;
  }
}

export default Login;
