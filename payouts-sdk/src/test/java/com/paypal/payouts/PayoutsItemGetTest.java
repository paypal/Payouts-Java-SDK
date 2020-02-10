package com.paypal.payouts;

import com.paypal.TestHarness;
import com.paypal.http.HttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PayoutsItemGetTest extends TestHarness {

    @Test
    public void testPayoutsItemGetRequest() throws IOException {
        HttpResponse<CreatePayoutResponse> createResponse = PayoutsPostTest.createPayouts(client());
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
}
