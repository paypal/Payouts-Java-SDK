package com.paypal.payouts;

import com.paypal.TestHarness;
import com.paypal.http.HttpClient;
import com.paypal.http.HttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PayoutsGetTest extends TestHarness {

    public static HttpResponse<PayoutBatch> getPayouts(HttpClient client, String batchId) throws IOException {
        PayoutsGetRequest request = new PayoutsGetRequest(batchId)
                .page(1)
                .pageSize(10)
                .totalRequired(true);

        return client.execute(request);
    }

    @Test
    public void testPayoutsGetRequest() throws IOException {
        HttpResponse<CreatePayoutResponse> createResponse = PayoutsPostTest.createPayouts(client());
        assertEquals(createResponse.statusCode(), 201);
        assertNotNull(createResponse.result());

        HttpResponse<PayoutBatch> response = getPayouts(client(), createResponse.result().batchHeader().payoutBatchId());
        assertEquals(response.statusCode(), 200);
        assertNotNull(response.result());

        PayoutBatch responseBody = response.result();

        assertEquals(responseBody.totalItems().intValue(), 5);
        assertEquals(responseBody.totalPages().intValue(), 1);
        assertNotNull(responseBody.batchHeader().payoutBatchId());
        assertNotNull(responseBody.batchHeader().batchStatus());
        assertNotNull(responseBody.batchHeader().senderBatchHeader().emailSubject());
        assertEquals(responseBody.batchHeader().senderBatchHeader().emailSubject(), "This is a test transaction from SDK");
        assertEquals(responseBody.batchHeader().senderBatchHeader().emailMessage(), "SDK payouts test txn");
        assertNotNull(responseBody.items());
        assertEquals(responseBody.items().size(), 5);
        PayoutBatchItem firstPayout = responseBody.items().get(0);
        assertNotNull(firstPayout.payoutItemId());
        assertNotNull(firstPayout.transactionStatus());
        assertEquals(firstPayout.payoutItem().amount().value(), "1.00");
        assertEquals(firstPayout.payoutItem().amount().currency(), "USD");
        assertEquals(firstPayout.payoutItem().senderItemId(), "Test_txn_1");
        assertEquals(firstPayout.payoutItem().receiver(), "payout-sdk-1@paypal.com");
    }

}
