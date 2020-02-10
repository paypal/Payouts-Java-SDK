// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// AlternateNotificationMethod.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data H4sIAAAAAAAC/9xTzW7TQBC+8xSjPSWSm1AJOORWuT0hQlUiLlVUTbyTeKT1rNkdEyyUd0cbuwmJiwCBEOrNO7/fz/irWbQ1mZm5ckpBUAnmXnnNBSp7gXekpbcmMx8xMK4czbFK5SYzb6k9Pq4pFoHr1GNmJsdam0AR0FpOMXQg34+tvKUI6iEQFiX4RtNDS4JABfFnChBog8GybEBLjlBjW5HoxGTmKgRsO9gvM3NHaN+La81sjS5SCnxqOJA9BG6DrykoUzSz+wPh29ILDYnVffjI7jFySnFREuwzIE21ogAswBqhQPHCBTpg6RTt6N/fTC7fvOqLE6vaocDahwp1OSpV6zibTrfb7YS1mbDoNFAxXVzc3eQX+9YpyfjvsY+aQAzpF74RDe1D4e2pCmeJoRh9ARToXOKXCmGU5+Ps30gDHYhqxUIWHMlGS/Dr/VHlOaDY/edha29b1URNtwkrgk0gVAqgJQpcvgbLG9bYTT7vK7xEjhrTCjxmLUXl7tUrML/Ox/vtsVklzVJzP2P0Yf57lmpozhyVxrld9lNb6YuSRPby0K0+sfaJ5NDeQ1EP/k9P8ReBPwr7FO5hbgj7zLb/4BZ/+J886xNd7pa7F98AAAD//w==
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

/**
 * Captures additional notification modes to reach out to the receiver regarding this payment.
 */
@Model
public class AlternateNotificationMethod {

    // Required default constructor
    public AlternateNotificationMethod() {
    }

    /**
     * The phone number in its canonical international [E.164 numbering plan format](https://www.itu.int/rec/T-REC-E.164/en).
     */
    @SerializedName("phone")
    private Phone phone;

    public Phone phone() {
        return phone;
    }

    public AlternateNotificationMethod phone(Phone phone) {
        this.phone = phone;
        return this;
    }
}
