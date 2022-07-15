import {CurrentUserFetcher} from "../../acl/CurrentUserFetcher";
import {LoginFetcher} from "../../acl/LoginFetcher";
import {RegisterFetcher} from "../../acl/RegisterFetcher";

export class User {
  readonly id?: String | undefined
  readonly password?: String | undefined
  readonly userAccountName?: String | undefined
  readonly userName?: String | undefined
  readonly tenantName?: String | undefined
  readonly accessToken?: String | undefined
  readonly authorities?: String[] | undefined

  constructor(userName: String, password: String, userAccountName?: String, tenantName?: String, authorities?: String[]) {
    this.password = password;
    this.userName = userName;
    this.userAccountName = userAccountName;
    this.tenantName = tenantName;
    this.authorities = authorities;
  }

  async login() {
    await new LoginFetcher().fetch(this)
    window.location.href = "/"
  }

  async register(confirmedPassword: string) {
    await new RegisterFetcher().fetch(this, confirmedPassword)
    window.location.href = "/user/login"
  }

  loginContext() {
    return {
      data: {
        "userName": this.userName,
        "password": this.password
      }
    }
  }

  registerContext(confirmedPassword: string) {
    return {
      data: {
        "userAccountName": this.userAccountName,
        "userName": this.userName,
        "tenantName": this.tenantName,
        "password": this.password,
        "confirmedPassword": confirmedPassword,
        "grantedAuthorities": this.authorities
      }
    }
  }

  static async findCurrentUser(): Promise<User> {
    return new CurrentUserFetcher().fetch()
  }
}
