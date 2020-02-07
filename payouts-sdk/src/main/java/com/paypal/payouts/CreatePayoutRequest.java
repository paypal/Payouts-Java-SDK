// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// CreatePayoutRequest.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data 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
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

import java.util.List;

/**
 * The create payout request.
 */
@Model
public class CreatePayoutRequest {

    // Required default constructor
    public CreatePayoutRequest() {
    }

    /**
     * REQUIRED
     * An array of individual payout items.
     */
    @SerializedName(value = "items", listClass = PayoutItem.class)
    private List<PayoutItem> items;

    public List<PayoutItem> items() {
        return items;
    }

    public CreatePayoutRequest items(List<PayoutItem> items) {
        this.items = items;
        return this;
    }

    /**
     * REQUIRED
     * The sender-provided payout header for a payout request.
     */
    @SerializedName("sender_batch_header")
    private SenderBatchHeader senderBatchHeader;

    public SenderBatchHeader senderBatchHeader() {
        return senderBatchHeader;
    }

    public CreatePayoutRequest senderBatchHeader(SenderBatchHeader senderBatchHeader) {
        this.senderBatchHeader = senderBatchHeader;
        return this;
    }
}
