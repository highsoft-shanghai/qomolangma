import Http from "../frameworks/http";
import {User} from "../domain/user/User";

export class CurrentUserFetcher {
  async fetch() {
    let res = await Http.get("/access-tokens/current")
    return new User(
      res.id,
      res.userAccountName,
      res.userName,
      res.tenantName,
      res.accessToken,
      res.authorities
    )
  }
}
