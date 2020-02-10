package com.paypal;

import com.paypal.http.HttpResponse;
import com.paypal.http.serializer.Json;
import com.paypal.payouts.CreatePayoutResponse;
import com.paypal.payouts.PayoutBatch;
import com.paypal.payouts.PayoutItemResponse;
import com.paypal.payouts.PayoutsItemCancelRequest;
import org.json.JSONObject;

import java.io.IOException;

public class CancelPayoutItem extends PayPalClient {

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

        HttpResponse<PayoutItemResponse> response = client().execute(request);

        System.out.println("Response Body:");
        System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));

        return response;
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
        } else {
            System.out.println("Payout create request is still not processed");
        }

    }
}
