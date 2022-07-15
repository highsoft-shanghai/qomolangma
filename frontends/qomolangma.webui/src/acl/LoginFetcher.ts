import Http from "../frameworks/http";
import {User} from "../domain/user/User";

export class LoginFetcher {
  async fetch(user: User) {
    await Http.login(user)
  }
}
