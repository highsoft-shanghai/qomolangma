import {User} from "../domain/user/User";
import Http from "../frameworks/http";

export class RegisterFetcher {
  async fetch(user: User, confirmedPassword: string) {
    await Http.post("/user/register", user.registerContext(confirmedPassword))
  }
}
