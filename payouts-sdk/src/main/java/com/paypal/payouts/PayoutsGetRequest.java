// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// PayoutsGetRequest.java
// @version 0.1.0-dev+904328-dirty
// @type request
// @data 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
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.HttpRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Shows the latest status of a batch payout. Includes the transaction status and other data for individual payout items.
 */
public class PayoutsGetRequest extends HttpRequest<PayoutBatch> {

    public PayoutsGetRequest(String payoutBatchId) {
        super("/v1/payments/payouts/{payout_batch_id}?", "GET", PayoutBatch.class);
        try {
            path(path().replace("{payout_batch_id}", URLEncoder.encode(String.valueOf(payoutBatchId), "UTF-8")));
        } catch (UnsupportedEncodingException ignored) {
        }

        header("Content-Type", "application/json");
    }

    public PayoutsGetRequest fields(String fields) {
        String params = String.valueOf(fields);
        try {
            path(path() + "fields=" + URLEncoder.encode(params, "UTF-8") + "&");
        } catch (UnsupportedEncodingException ignored) {
        }
        return this;
    }

    public PayoutsGetRequest page(Integer page) {
        String params = String.valueOf(page);
        try {
            path(path() + "page=" + URLEncoder.encode(params, "UTF-8") + "&");
        } catch (UnsupportedEncodingException ignored) {
        }
        return this;
    }

    public PayoutsGetRequest pageSize(Integer pageSize) {
        String params = String.valueOf(pageSize);
        try {
            path(path() + "page_size=" + URLEncoder.encode(params, "UTF-8") + "&");
        } catch (UnsupportedEncodingException ignored) {
        }
        return this;
    }

    public PayoutsGetRequest totalRequired(Boolean totalRequired) {
        String params = String.valueOf(totalRequired);
        try {
            path(path() + "total_required=" + URLEncoder.encode(params, "UTF-8") + "&");
        } catch (UnsupportedEncodingException ignored) {
        }
        return this;
    }

}
