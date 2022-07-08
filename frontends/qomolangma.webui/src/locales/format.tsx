import {FormattedMessage} from "react-intl";
import React from "react";

export class Format {
  public static format(id: string, values?: any) {
    return <FormattedMessage id={id} values={values}/>;
  }
}
