package com.paypal;

import com.paypal.http.Encoder;
import com.paypal.http.HttpResponse;
import com.paypal.http.exceptions.HttpException;
import com.paypal.http.serializer.Json;
import com.paypal.payouts.Error;
import com.paypal.payouts.*;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CancelPayoutItem extends PayPalClient {

    private static final Encoder encoder = new Encoder();

    /**
     * Cancels an UNCLAIMED Payout item (POST - /v1/payments/payouts-item/{<item-id>}/cancel)
     * An item can be cancelled if it is in UNCLAIMED status and the Payouts batch is in SUCCESS status.
     * Upon cancelling an item the status changes to RETURNED and the funds are given back to the sender
     *
     * @param itemId the Id of a Payout item
     * @return the details of the Payouts Item
     * @throws IOException
     */
    public HttpResponse<PayoutItemResponse> cancelPayoutItem(String itemId) throws IOException {
        PayoutsItemCancelRequest request = new PayoutsItemCancelRequest(itemId);

        try {
            HttpResponse<PayoutItemResponse> response = client().execute(request);

            System.out.println("Response Body:");
            System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));

            return response;
        } catch (HttpException e) {
            //Server side API failure
            String error = e.getMessage();
            com.paypal.payouts.Error payoutError = encoder.deserializeResponse(new ByteArrayInputStream(error.getBytes(StandardCharsets.UTF_8)), Error.class, e.headers());
            System.out.println("Error Response Body:");
            System.out.println(new JSONObject(new Json().serialize(payoutError)).toString(4));
            throw e;
        } catch (IOException e) {
            //Client side failure
            System.out.println(e);
            throw e;
        }
    }

    /**
     * This is the driver method to execute this sample.
     * This method cancels an UNCLAIMED Payout Item.
     * To cancel a valid Payout Item, it creates a Payouts Batch with 5 items and use that id
     * to retrieve batch status. It waits till the Payouts batch status is SUCCESS and the item status is UNCLAIMED
     * to cancel the Payout item. Upon cancelling the item status changes to RETURNED
     * <p>
     * Note: This is just a sample, use WebHooks when integrating to get LIVE status updates for Payouts Batch and Payouts Item
     *
     * @param args
     * @throws IOException when call to the api fails
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpResponse<CreatePayoutResponse> createPayoutResponse = new CreatePayoutsBatch().createPayout();
        int i = 0;
        HttpResponse<PayoutBatch> getBatchResponse;
        do {
            getBatchResponse = new GetPayoutBatch().getPayoutBatch(createPayoutResponse.result().batchHeader().payoutBatchId());
            if (getBatchResponse.result().batchHeader().batchStatus().equals("SUCCESS")) {
                break;
            }
            Thread.sleep(1000);
            i++;
        } while (i <= 5);

        if (i < 5) {
            new CancelPayoutItem().cancelPayoutItem(getBatchResponse.result().items().get(0).payoutItemId());
            //Simulate a failure scenario to show how to handle failure response
            Thread.sleep(1000);
            new CancelPayoutItem().cancelPayoutItem(getBatchResponse.result().items().get(0).payoutItemId());
        } else {
            System.out.println("Payout create request is still not processed");
        }

    }
}
