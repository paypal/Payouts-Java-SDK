package com.paypal.payouts;

import com.paypal.TestHarness;
import com.paypal.http.HttpClient;
import com.paypal.http.HttpResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PayoutsPostTest extends TestHarness {
    private static CreatePayoutRequest buildRequestBody() throws IOException {
        List<PayoutItem> items = IntStream
                .range(1, 6)
                .mapToObj(index -> new PayoutItem()
                        .senderItemId("Test_txn_" + index)
                        .note("Your 5$ Payout!")
                        .receiver("payout-sdk-" + index + "@paypal.com")
                        .amount(new Currency()
                                .currency("USD")
                                .value("1.00")))
                .collect(Collectors.toList());

        return new CreatePayoutRequest()
                .senderBatchHeader(new SenderBatchHeader()
                        .senderBatchId("Test_sdk_" + RandomStringUtils.randomAlphanumeric(7))
                        .emailMessage("SDK payouts test txn")
                        .emailSubject("This is a test transaction from SDK")
                        .note("Enjoy your Payout!!")
                        .recipientType("EMAIL"))
                .items(items);
    }

    public static HttpResponse<CreatePayoutResponse> createPayouts(HttpClient client) throws IOException {
        PayoutsPostRequest request = new PayoutsPostRequest();
        request.requestBody(buildRequestBody());

        return client.execute(request);
    }

    @Test
    public void testPayoutsPostRequest() throws IOException {
        HttpResponse<CreatePayoutResponse> response = createPayouts(client());
        assertEquals(response.statusCode(), 201);
        assertNotNull(response.result());

        CreatePayoutResponse responseBody = response.result();
        assertNotNull(responseBody.batchHeader().payoutBatchId());
        assertNotNull(responseBody.batchHeader().batchStatus());
        assertEquals(responseBody.batchHeader().senderBatchHeader().emailSubject(), "This is a test transaction from SDK");
        assertEquals(responseBody.batchHeader().senderBatchHeader().emailMessage(), "SDK payouts test txn");
    }

}
