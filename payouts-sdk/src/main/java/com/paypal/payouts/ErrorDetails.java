// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// ErrorDetails.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data H4sIAAAAAAAC/6zQQUvzQBDG8fv7KYY55y0ePOUm1JOgUooUROjYfWIGtrtxZnMI0u8uTWil5iCCx/3vMPx2P3g9dOCab82y0RJFNDpX/CSm8hpxL/vjNVd8h+HrsITvTLuiOXHN6xaEcUGYFixohfdeDYGabLSLilT+uwbQ9nqz2U7TvuCKb8xkmBBXFa8g4SHFgetGouMYpj3n8Gi5gxWFc/185nsxTW9zd6OI4QJ/KvMXJNmDckOlBY1TVFoptJPeEcY6qn+FLtZ/M6c+xkP1I1zde1zAT2UON4jnNP70nypfDv8+AQAA//8=
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

/**
 * The error details. Required for client-side `4XX` errors.
 */
@Model
public class ErrorDetails {

    // Required default constructor
    public ErrorDetails() {
    }

    /**
     * REQUIRED
     * The name of the field that caused the error.
     */
    @SerializedName("field")
    private String field;

    public String field() {
        return field;
    }

    public ErrorDetails field(String field) {
        this.field = field;
        return this;
    }

    /**
     * REQUIRED
     * The reason for the error.
     */
    @SerializedName("issue")
    private String issue;

    public String issue() {
        return issue;
    }

    public ErrorDetails issue(String issue) {
        this.issue = issue;
        return this;
    }

    /**
     * REQUIRED
     * The reason for the error.
     */
    @SerializedName("location")
    private String location;

    public String location() {
        return location;
    }

    public ErrorDetails location(String location) {
        this.location = location;
        return this;
    }
}
