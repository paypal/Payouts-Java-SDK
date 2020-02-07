// This class was generated on Tue, 17 Dec 2019 16:22:06 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// PayoutCurrencyConversion.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data H4sIAAAAAAAC/+yU32sUMRDH3/0rhjxV2LutP0C4t9IiqNAWLYLUo51L5i7BbLJOJj0X6f8uu9u73nZrURRB6NOSyWRmPjPfne/qrKlJzdQpNjELHGZmCroBHcMVcXIxqEJ9RHa48HSMVeurCvWOmtvDESXNrpbWeabOLIEehwGmFDNrmqpCHTBj02feL9R7QnMSfKNmS/SJWsPX7JjM1nDKsSYWR0nNzrc1J2EXVuP66Ju2GFZ0wSg0KPbuzbjyjQe0HiAWBVwCrGvvyMAyMoh1CequXX+KErL318WWZ9P8MdGSY3WBVcxBBjxD+wNzwGCg9+sYEJYuYNAOPQhjSKjbVwWkrC1gAoQFegyaIHILW1EQMPkfDE/fNuGWc8c4hjwXy0QTbZFRCzG8+XAyefn82atdGRqa75Um6lS6ILRibAOUxjFpKZmSlBvnSeucyqe/hSqcH57tz3Cv0OehRjeWMWh3U8DaOm2hcisrsKDZ57y//0Jn332pP3nXnw4CdLjE3dhvEB0l8O4LweXb00+XvciRCUIUkKZ2Gr1vYMm9KNBP+6DlJuqdHGBIuwr99sX9uc6Oj3Zypbww7soZMm2FEcTGnDAYsen+dOWG8HX3DxLwTfMh5GpBDHG5LaT2qCndKH0gggISEZwf7toSTFrJQCuZ+Z4VqdOsLNfr9dSlOI28Kl2KnaAmQ41MrVT+r+hk/ktbQOJ9O2DX+rgBHjfA4wb4PzfA/PrJDwAAAP//
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

/**
 * The currency conversion resource.
 */
@Model
public class PayoutCurrencyConversion {

    // Required default constructor
    public PayoutCurrencyConversion() {
    }

    /**
     * The exchange rate that is applied for this payout.
     */
    @SerializedName("exchange_rate")
    private String exchangeRate;

    public String exchangeRate() {
        return exchangeRate;
    }

    public PayoutCurrencyConversion exchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }

    /**
     * The currency and amount for a financial transaction, such as a balance or payment due.
     */
    @SerializedName("from_amount")
    private Currency fromAmount;

    public Currency fromAmount() {
        return fromAmount;
    }

    public PayoutCurrencyConversion fromAmount(Currency fromAmount) {
        this.fromAmount = fromAmount;
        return this;
    }

    /**
     * The currency and amount for a financial transaction, such as a balance or payment due.
     */
    @SerializedName("to_amount")
    private Currency toAmount;

    public Currency toAmount() {
        return toAmount;
    }

    public PayoutCurrencyConversion toAmount(Currency toAmount) {
        this.toAmount = toAmount;
        return this;
    }
}
