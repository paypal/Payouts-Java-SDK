package com.paypal;

import com.paypal.http.Encoder;
import com.paypal.http.HttpResponse;
import com.paypal.http.exceptions.HttpException;
import com.paypal.http.serializer.Json;
import com.paypal.payouts.Error;
import com.paypal.payouts.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreatePayoutsBatch extends PayPalClient {

    private static final Encoder encoder = new Encoder();

    /**
     * Creates a Payouts batch request(POST - /v1/payments/payouts) with 5 payout items
     * A maximum of 15000 payout items are supported in a single batch request
     *
     * @return Response for the create payouts call
     * @throws IOException when call to the api fails
     */
    public HttpResponse<CreatePayoutResponse> createPayout() throws IOException {

        PayoutsPostRequest request = buildRequestBody(false);

        HttpResponse<CreatePayoutResponse> response = client().execute(request);
        System.out.println("Response Body:");
        System.out.println(new JSONObject(new Json().serialize(response.result())).toString(4));

        return response;
    }

    /**
     * Creates a Payouts batch request(POST - /v1/payments/payouts) with 5 payout items
     * All the items are created with invalid amount value to simulate a validation failure
     *
     * @return Response for the create payouts call
     * @throws IOException when call to the api fails
     */
    public void createPayoutFailure() throws IOException {
        PayoutsPostRequest request = buildRequestBody(true);

        try {
            client().execute(request);
        } catch (HttpException e) {
            String error = e.getMessage();
            Error payoutError = encoder.deserializeResponse(new ByteArrayInputStream(error.getBytes(StandardCharsets.UTF_8)), Error.class, e.headers());
            System.out.println("Error Response Body:");
            System.out.println(new JSONObject(new Json().serialize(payoutError)).toString(4));
        }


    }

    /**
     * Builds a Payouts batch create request body with 5 payout items to receivers email
     *
     * @param isValidationFailure - Include validation failure in payload
     * @return Request payload for Payouts create(POST) request
     */
    private PayoutsPostRequest buildRequestBody(boolean isValidationFailure) {
        List<PayoutItem> items = IntStream
                .range(1, 6)
                .mapToObj(index -> new PayoutItem()
                        .senderItemId("Test_txn_" + index)
                        .note("Your 1$ Payout!")
                        .receiver("payout-sdk-" + index + "@paypal.com")
                        .amount(new Currency()
                                .currency("USD")
                                .value(isValidationFailure ? "1.0.0" : "1.00")))
                .collect(Collectors.toList());

        CreatePayoutRequest payoutBatch = new CreatePayoutRequest()
                .senderBatchHeader(new SenderBatchHeader()
                        .senderBatchId("Test_sdk_" + RandomStringUtils.randomAlphanumeric(7))
                        .emailMessage("SDK payouts test txn")
                        .emailSubject("This is a test transaction from SDK")
                        .note("Enjoy your Payout!!")
                        .recipientType("EMAIL"))
                .items(items);

        return new PayoutsPostRequest()
                .requestBody(payoutBatch);
    }

    /**
     * This is the driver method to execute this sample.
     * This creates a Payouts Batch with 5 items and prints the response
     *
     * @param args
     * @throws IOException when call to the api fails
     */
    public static void main(String[] args) throws IOException {
        new CreatePayoutsBatch().createPayout();
        //Simulate a failure scenario to show how to handle failure response
        new CreatePayoutsBatch().createPayoutFailure();
    }

}
