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

public class GetPayoutItem extends PayPalClient {

    private static final Encoder encoder = new Encoder();

    /**
     * Retrieves a Payouts item details. Payouts item retrieval api(GET - /v1/payments/payouts-items/<item-id>)
     *
     * @param itemId the Id of a Payout item
     * @return the details of the Payouts Item
     * @throws IOException when call to the api fails
     */
    public HttpResponse<PayoutItemResponse> getPayoutItem(String itemId) throws IOException {
        PayoutsItemGetRequest request = new PayoutsItemGetRequest(itemId);

        try {
            HttpResponse<PayoutItemResponse> response = client().execute(request);

            System.out.println("Response Body:");
            System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));

            return response;
        } catch (HttpException e) {
            String error = e.getMessage();
            com.paypal.payouts.Error payoutError = encoder.deserializeResponse(new ByteArrayInputStream(error.getBytes(StandardCharsets.UTF_8)), Error.class, e.headers());
            System.out.println("Error Response Body:");
            System.out.println(new JSONObject(new Json().serialize(payoutError)).toString(4));
            return null;
        }
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
        //Simulate a failure scenario to show how to handle failure response
        new GetPayoutItem().getPayoutItem("DUMMY");
    }
}
