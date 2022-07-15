import Http from "../frameworks/http";
import {User} from "../domain/user/User";

export class CurrentUserFetcher {
  async fetch(): Promise<User> {
    return Http.get("/access-tokens/current")
  }
}
