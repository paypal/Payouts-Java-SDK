package com.paypal;

import com.paypal.http.HttpResponse;
import com.paypal.http.serializer.Json;
import com.paypal.payouts.CreatePayoutResponse;
import com.paypal.payouts.PayoutBatch;
import com.paypal.payouts.PayoutItemResponse;
import com.paypal.payouts.PayoutsItemGetRequest;
import org.json.JSONObject;

import java.io.IOException;

public class GetPayoutItem extends PayPalClient {

    /**
     * Retrieves a Payouts item details. Payouts item retrieval api(GET - /v1/payments/payouts-items/<item-id>)
     *
     * @param itemId the Id of a Payout item
     * @return the details of the Payouts Item
     * @throws IOException when call to the api fails
     */
    public HttpResponse<PayoutItemResponse> getPayoutItem(String itemId) throws IOException {
        PayoutsItemGetRequest request = new PayoutsItemGetRequest(itemId);

        HttpResponse<PayoutItemResponse> response = client().execute(request);

        System.out.println("Response Body:");
        System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));

        return response;
    }

    /**
     * This is the driver method to execute this sample.
     * This method retrieves a Payout Item detail.
     * To retrieve a valid Payout Item, it creates a Payouts Batch with 5 items and use that id
     * to retrieve batch status, and use the first item id in response for retrieval
     *
     * @param args
     * @throws IOException when call to the api fails
     */
    public static void main(String[] args) throws IOException {
        HttpResponse<CreatePayoutResponse> createPayoutResponse = new CreatePayoutsBatch().createPayout();
        HttpResponse<PayoutBatch> getBatchResponse = new GetPayoutBatch().getPayoutBatch(createPayoutResponse.result().batchHeader().payoutBatchId());
        new GetPayoutItem().getPayoutItem(getBatchResponse.result().items().get(0).payoutItemId());
    }
}
