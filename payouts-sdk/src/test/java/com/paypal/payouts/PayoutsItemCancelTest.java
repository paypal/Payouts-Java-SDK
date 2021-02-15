package com.paypal.payouts;

import com.paypal.TestHarness;
import com.paypal.http.Encoder;
import com.paypal.http.HttpResponse;
import com.paypal.http.exceptions.HttpException;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.testng.Assert.*;

public class PayoutsItemCancelTest extends TestHarness {

    private static final Encoder encoder = new Encoder();

    @Test
    public void testPayoutsItemCancelRequest() throws IOException, InterruptedException {
        HttpResponse<CreatePayoutResponse> createResponse = PayoutsPostTest.createPayouts(client(), false);
        assertEquals(createResponse.statusCode(), 201);
        assertNotNull(createResponse.result());

        int i = 0;
        do {
            Thread.sleep(2000);
            HttpResponse<PayoutBatch> getResponse = PayoutsGetTest.getPayouts(client(), createResponse.result().batchHeader().payoutBatchId());
            assertEquals(getResponse.statusCode(), 200);
            assertNotNull(getResponse.result());
            if (getResponse.result().batchHeader().batchStatus().equals("SUCCESS")) {
                PayoutsItemCancelRequest request = new PayoutsItemCancelRequest(getResponse.result().items().get(0).payoutItemId());

                HttpResponse<PayoutItemResponse> response = client().execute(request);
                assertEquals(response.statusCode(), 200);
                assertNotNull(response.result());

                PayoutItemResponse responseBody = response.result();

                assertNotNull(responseBody.payoutItemId());
                assertNotNull(responseBody.transactionId());
                assertNotNull(responseBody.transactionStatus());
                assertEquals(responseBody.transactionStatus(), "RETURNED");
                assertEquals(responseBody.payoutItem().amount().value(), "1.00");
                assertEquals(responseBody.payoutItem().amount().currency(), "USD");
                assertEquals(responseBody.payoutItem().senderItemId(), "Test_txn_1");
                assertEquals(responseBody.payoutItem().receiver(), "payout-sdk-1@paypal.com");
                break;
            }
            i++;
        } while (i < 5);

        assertNotEquals(i, 5, "Payouts batch has not processed all the payments yet");

    }

    @Test
    public void testPayoutsItemCancelRequestFailure() throws IOException, InterruptedException {
        HttpResponse<CreatePayoutResponse> createResponse = PayoutsPostTest.createPayouts(client(), false);
        assertEquals(createResponse.statusCode(), 201);
        assertNotNull(createResponse.result());

        int i = 0;
        do {
            Thread.sleep(2000);
            HttpResponse<PayoutBatch> getResponse = PayoutsGetTest.getPayouts(client(), createResponse.result().batchHeader().payoutBatchId());
            assertEquals(getResponse.statusCode(), 200);
            assertNotNull(getResponse.result());
            if (getResponse.result().batchHeader().batchStatus().equals("SUCCESS")) {
                PayoutsItemCancelRequest request = new PayoutsItemCancelRequest(getResponse.result().items().get(0).payoutItemId());

                HttpResponse<PayoutItemResponse> response = client().execute(request);
                assertEquals(response.statusCode(), 200);
                assertNotNull(response.result());

                PayoutItemResponse responseBody = response.result();

                assertNotNull(responseBody.payoutItemId());
                assertNotNull(responseBody.transactionId());
                assertNotNull(responseBody.transactionStatus());
                assertEquals(responseBody.transactionStatus(), "RETURNED");
                assertEquals(responseBody.payoutItem().amount().value(), "1.00");
                assertEquals(responseBody.payoutItem().amount().currency(), "USD");
                assertEquals(responseBody.payoutItem().senderItemId(), "Test_txn_1");
                assertEquals(responseBody.payoutItem().receiver(), "payout-sdk-1@paypal.com");

                try {
                    client().execute(request);
                } catch (HttpException e) {
                    String error = e.getMessage();
                    Error payoutError = encoder.deserializeResponse(new ByteArrayInputStream(error.getBytes(StandardCharsets.UTF_8)), Error.class, e.headers());
                    assertNotNull(payoutError.debugId());
                    assertNotNull(payoutError.name());
                    assertEquals(payoutError.name(), "ITEM_ALREADY_CANCELLED");
                    assertNotNull(payoutError.message());
                    assertNotNull(payoutError.informationLink());
                    assertEquals(payoutError.informationLink(), "https://developer.paypal.com/docs/api/payments.payouts-batch/#errors");
                }
                break;
            }
            i++;
        } while (i < 5);

        assertNotEquals(i, 5, "Payouts batch has not processed all the payments yet");

    }
}
