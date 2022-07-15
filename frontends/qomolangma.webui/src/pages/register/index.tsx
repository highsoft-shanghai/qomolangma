import React, {Component} from "react";
import './Register.css'
import {User} from "../../domain/user/User";

class Register extends Component<any, any> {
  render() {
    return <>
      <div className='login-content'>
        <div className='login-label'>
          userAccountName: <input className='input' id='userAccountName'/>
        </div>
        <div className='login-label'>
          userName: <input className='input' id='userName'/>
        </div>
        <div className='login-label'>
          tenantName: <input className='input' id='tenantName'/>
        </div>
        <div className='login-label'>
          password: <input className='input' id='password' type={"password"}/>
        </div>
        <div className='login-label'>
          confirmedPassword: <input className='input' id='confirmedPassword' type={"password"}/>
        </div>
        <div className='login-label'>
          grantedAuthorities (Separate with ,):
          <input className='input' id='grantedAuthorities' type={"grantedAuthorities"}/>
        </div>
        <button onClick={this.register.bind(this)}>Register
        </button>
      </div>
    </>;
  }

  public register() {
    new User(
      // @ts-ignore
      document.getElementById('userName').value,
      // @ts-ignore
      document.getElementById('password').value,
      // @ts-ignore
      document.getElementById('userAccountName').value,
      // @ts-ignore
      document.getElementById('tenantName').value,
      // @ts-ignore
      document.getElementById('grantedAuthorities').value.split(','),
    )
      .register(
        // @ts-ignore
        document.getElementById('confirmedPassword').value
      )
      .then(res => {
        alert('Register success.')
      })
      .catch(error => alert(error.message))
  }
}

export default Register;
