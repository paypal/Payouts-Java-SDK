package com.paypal.payouts;

import com.paypal.TestHarness;
import com.paypal.http.Encoder;
import com.paypal.http.HttpResponse;
import com.paypal.http.exceptions.HttpException;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PayoutsItemGetTest extends TestHarness {

    private static final Encoder encoder = new Encoder();

    @Test
    public void testPayoutsItemGetRequest() throws IOException {
        HttpResponse<CreatePayoutResponse> createResponse = PayoutsPostTest.createPayouts(client(), false);
        assertEquals(createResponse.statusCode(), 201);
        assertNotNull(createResponse.result());

        HttpResponse<PayoutBatch> getResponse = PayoutsGetTest.getPayouts(client(), createResponse.result().batchHeader().payoutBatchId());
        assertEquals(getResponse.statusCode(), 200);
        assertNotNull(getResponse.result());

        PayoutsItemGetRequest request = new PayoutsItemGetRequest(getResponse.result().items().get(0).payoutItemId());

        HttpResponse<PayoutItemResponse> response = client().execute(request);
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.result());

        PayoutItemResponse responseBody = response.result();

        assertNotNull(responseBody.payoutItemId());
        assertNotNull(responseBody.transactionStatus());
        assertEquals(responseBody.payoutItem().amount().value(), "1.00");
        assertEquals(responseBody.payoutItem().amount().currency(), "USD");
        assertEquals(responseBody.payoutItem().senderItemId(), "Test_txn_1");
        assertEquals(responseBody.payoutItem().receiver(), "payout-sdk-1@paypal.com");
    }

    @Test
    public void testPayoutsItemGetRequestFailure() throws IOException {
        try {
            PayoutsItemGetRequest request = new PayoutsItemGetRequest("DUMMY");
            client().execute(request);
        } catch (HttpException e) {
            String error = e.getMessage();
            Error payoutError = encoder.deserializeResponse(new ByteArrayInputStream(error.getBytes(StandardCharsets.UTF_8)), Error.class, e.headers());
            assertNotNull(payoutError.debugId());
            assertNotNull(payoutError.name());
            assertEquals(payoutError.name(), "INVALID_RESOURCE_ID");
            assertNotNull(payoutError.message());
            assertNotNull(payoutError.informationLink());
            assertEquals(payoutError.informationLink(), "https://developer.paypal.com/docs/api/payments.payouts-batch/#errors");
        }
    }
}
