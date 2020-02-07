// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// Phone.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data H4sIAAAAAAAC/9xTwWrcQAy99yvEnHbBWTfQ9uBbcXIqbEO69BJCkG3tWjDWuDMatqbk38us3Q1Zb2lLoZTcPNKT9PSe/M1shp5MYW5aJ2Qy8xk9Y2VpjV0Km8x8oOHpcUWh9twrOzGF2bQEfSoEiV1FHliANUCN4oRrtMCi5AUTHi3cXa8u372ZwCw76C0KbJ3vUO8XrWofijzf7/cr1rhi0dxTnW8ubq/Li0NpTrJcmcy89x6HkfnrzNwSNh/FDqbYog2UAl8ie2qOgRvvevLKFExxd9w5aCIxX7p2UdQPD7Vr6JkAJ4m5GBMAarQ27ZeAsCjLZfZvpIGRRFexUAOWZKctuC1oS1CWgNIcPo9TJ9u6GBTEKVQEO0+o5EFbFLh8Cw3vWMPY+bSudhI4aEgj8CnbUFAeX5MC66tyeZgeYpU0S8VTj8Wn9Z9Zqj6eOCrR2sfsl7bSVyUJ7ORhHP3M2jPJub1H0ET+b0/xN4n/EPYc73luTvvEtv/gFn/6n7zoE71/fPUdAAD//w==
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

/**
 * The phone number in its canonical international [E.164 numbering plan format](https://www.itu.int/rec/T-REC-E.164/en).
 */
@Model
public class Phone {

    // Required default constructor
    public Phone() {
    }

    /**
     * REQUIRED
     * The country calling code (CC), in its canonical international [E.164 numbering plan format](https://www.itu.int/rec/T-REC-E.164/en). The combined length of the CC and the national number must not be greater than 15 digits. The national number consists of a national destination code (NDC) and subscriber number (SN).
     */
    @SerializedName("country_code")
    private String countryCode;

    public String countryCode() {
        return countryCode;
    }

    public Phone countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * The extension number.
     */
    @SerializedName("extension_number")
    private String extensionNumber;

    public String extensionNumber() {
        return extensionNumber;
    }

    public Phone extensionNumber(String extensionNumber) {
        this.extensionNumber = extensionNumber;
        return this;
    }

    /**
     * REQUIRED
     * The national number, in its canonical international [E.164 numbering plan format](https://www.itu.int/rec/T-REC-E.164/en). The combined length of the country calling code (CC) and the national number must not be greater than 15 digits. The national number consists of a national destination code (NDC) and subscriber number (SN).
     */
    @SerializedName("national_number")
    private String nationalNumber;

    public String nationalNumber() {
        return nationalNumber;
    }

    public Phone nationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
        return this;
    }
}
