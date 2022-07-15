import {CurrentUserFetcher} from "../../acl/CurrentUserFetcher";

export class User {
  id: String | undefined
  userAccountName: String | undefined
  userName: String | undefined
  tenantName: String | undefined
  accessToken: String | undefined
  authorities: String[] | undefined

  static async findCurrentUser(): Promise<User> {
    return new CurrentUserFetcher().fetch()
  }
}
