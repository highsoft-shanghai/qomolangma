import {CurrentUserFetcher} from "../../acl/CurrentUserFetcher";

export class User {
  private _id: String
  private _userAccountName: String
  private _userName: String
  private _tenantName: String
  private _accessToken: String
  private _authorities: String[]

  constructor(id: String, userAccountName: String, userName: String, tenantName: String, accessToken: String,
              authorities: String[]) {
    this._id = id;
    this._userAccountName = userAccountName;
    this._userName = userName;
    this._tenantName = tenantName;
    this._accessToken = accessToken;
    this._authorities = authorities;
  }

  get id(): String {
    return this._id;
  }

  get userAccountName(): String {
    return this._userAccountName;
  }

  get userName(): String {
    return this._userName;
  }

  get tenantName(): String {
    return this._tenantName;
  }

  get accessToken(): String {
    return this._accessToken;
  }

  get authorities(): String[] {
    return this._authorities;
  }

  static async findCurrentUser(): Promise<User> {
    return new CurrentUserFetcher().fetch()
  }
}
