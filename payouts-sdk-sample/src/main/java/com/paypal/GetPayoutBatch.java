package com.paypal;

import com.paypal.http.Encoder;
import com.paypal.http.HttpResponse;
import com.paypal.http.exceptions.HttpException;
import com.paypal.http.serializer.Json;
import com.paypal.payouts.CreatePayoutResponse;
import com.paypal.payouts.Error;
import com.paypal.payouts.PayoutBatch;
import com.paypal.payouts.PayoutsGetRequest;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GetPayoutBatch extends PayPalClient {

    private static final Encoder encoder = new Encoder();

    /**
     * Retrieves a Payouts batch details. Payouts batch retrieval api(GET - /v1/payments/payouts/<batch-id>) is a Paginated API
     * that supports retrieving a maximum of 1000 items per page. Batches having items more than that have to paginate
     * to get complete details. Check 'links' in the response for prev and next page URI's.
     * Add 'totalRequired' parameter to know the total number of pages available
     *
     * @param batchId the Id of a Payouts batch
     * @return the details of the Payouts Batch
     * @throws IOException when call to the api fails
     */
    public HttpResponse<PayoutBatch> getPayoutBatch(String batchId) throws IOException {
        PayoutsGetRequest request = new PayoutsGetRequest(batchId)
                //Optional parameters, maximum of 1000 items are retrieved by default.
                .page(1)
                .pageSize(10)
                .totalRequired(true);

        try {
            HttpResponse<PayoutBatch> response = client().execute(request);

            System.out.println("Response Body:");
            System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));
            return response;
        } catch (HttpException e) {
            //Server side API failure
            String error = e.getMessage();
            Error payoutError = encoder.deserializeResponse(new ByteArrayInputStream(error.getBytes(StandardCharsets.UTF_8)), Error.class, e.headers());
            System.out.println("Error Response Body:");
            System.out.println(new JSONObject(new Json().serialize(payoutError)).toString(4));
            return null;
        } catch (IOException e) {
            //Client side failure
            System.out.println(e);
            throw e;
        }
    }

    /**
     * This is the driver method to execute this sample.
     * This method retrieves a Payout batch details.
     * To retrieve a valid Payouts batch it creates a Payouts Batch with 5 items and use that id for retrieval
     *
     * @param args
     * @throws IOException when call to the api fails
     */
    public static void main(String[] args) throws IOException {
        HttpResponse<CreatePayoutResponse> response = new CreatePayoutsBatch().createPayout();
        new GetPayoutBatch().getPayoutBatch(response.result().batchHeader().payoutBatchId());
        //Simulate a failure scenario to show how to handle failure response
        new GetPayoutBatch().getPayoutBatch("DUMMY");
    }
}
