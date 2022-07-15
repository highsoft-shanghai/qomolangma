import {CurrentUserFetcher} from "../../acl/CurrentUserFetcher";

export class User {
  readonly id: String | undefined
  readonly userAccountName: String | undefined
  readonly userName: String | undefined
  readonly tenantName: String | undefined
  readonly accessToken: String | undefined
  readonly authorities: String[] | undefined

  static async findCurrentUser(): Promise<User> {
    return new CurrentUserFetcher().fetch()
  }
}
