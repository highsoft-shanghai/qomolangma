import Http from "../frameworks/http";
import {User} from "../domain/user/User";

export class CurrentUserFetcher {
  async fetch() {
    let res = await Http.get("/access-tokens/current")
    return new User(
      res.data.id,
      res.data.userAccountName,
      res.data.userName,
      res.data.tenantName,
      res.data.accessToken,
      res.data.authorities
    )
  }
}
