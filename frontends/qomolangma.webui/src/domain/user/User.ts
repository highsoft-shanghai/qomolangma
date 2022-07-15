import {CurrentUserFetcher} from "../../acl/CurrentUserFetcher";
import {LoginFetcher} from "../../acl/LoginFetcher";

export class User {
  readonly id?: String | undefined
  readonly password?: String | undefined
  readonly userAccountName?: String | undefined
  readonly userName?: String | undefined
  readonly tenantName?: String | undefined
  readonly accessToken?: String | undefined
  readonly authorities?: String[] | undefined

  constructor(userName: String | undefined, password: String | undefined) {
    this.password = password;
    this.userName = userName;
  }

  async login() {
    await new LoginFetcher().fetch(this)
  }

  loginData() {
    return {
      data: {
        "userName": this.userName,
        "password": this.password
      }
    }
  }


  static async findCurrentUser(): Promise<User> {
    return new CurrentUserFetcher().fetch()
  }
}
