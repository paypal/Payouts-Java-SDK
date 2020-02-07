// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// Currency.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data H4sIAAAAAAAC/6yS3WobMRCF7/sUg65SWFvuDxT2LiQU2kISWlMoriFjaWyJaqXtaBSzlLx7Wa9/40Ap5GqZI82c+Vbnj5p2LalaXRVmiqZTlfqO7HER6Aab/kRV6gt1h+KasmHfik9R1WrqCMy2FzBawCaVKLBMDAhLHzEajwGEMWY0fVcFuRgHmAFhgQGjIUgMLXYNRQFbaKwqdcmM3bDcpFJfCe1tDJ2qlxgy9cLv4pnsXrjj1BKLp6zq2R4rC/u4OocyB9wD3JF4DjkTx0Qj45DRCDF8+nY7ev/2zYcDvkmW5hfaJpO1j0Irxn6Atp7JiGbKoneXR/3lrF//F6pweUIaSwiP1T9xHzAUOmHdKeegm5MK1s4bB41fOYEF1T/LZPLOlLD50lAFP1SXETa4xJtn3yJ6yhD8L4L7z3c/7kEcCiATxCQgXesNhtDBkodQYBgPQ/Vu6hMPsGR8g2Hf8bzX9Ob6yCuXhfUP3pLtN0wgLpWM0YrLz9vpHeHHxCCOgLc/H2JpFsSQlvtF2oCG8jbpJyGoIBPB7OpYyzDqIwN9ZOYXTqTNtdbr9XrscxonXmmf0yZQo9OMjJ004UVyMn989RcAAP//
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

/**
 * The currency and amount for a financial transaction, such as a balance or payment due.
 */
@Model
public class Currency {

    // Required default constructor
    public Currency() {
    }

    /**
     * REQUIRED
     * The [three-character ISO-4217 currency code](/docs/integration/direct/rest/currency-codes/).
     */
    @SerializedName("currency")
    private String currency;

    public String currency() {
        return currency;
    }

    public Currency currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * REQUIRED
     * The value, which might be:<ul><li>An integer for currencies like `JPY` that are not typically fractional.</li><li>A decimal fraction for currencies like `TND` that are subdivided into thousandths.</li></ul>For the required number of decimal places for a currency code, see [Currency codes - ISO 4217](https://www.iso.org/iso-4217-currency-codes.html).
     */
    @SerializedName("value")
    private String value;

    public String value() {
        return value;
    }

    public Currency value(String value) {
        this.value = value;
        return this;
    }
}
