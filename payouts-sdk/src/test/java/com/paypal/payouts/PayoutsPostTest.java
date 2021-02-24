package com.paypal.payouts;

import com.paypal.TestHarness;
import com.paypal.http.Encoder;
import com.paypal.http.HttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.http.exceptions.HttpException;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class PayoutsPostTest extends TestHarness {
    private static final Encoder encoder = new Encoder();

    private static CreatePayoutRequest buildRequestBody(boolean includeValidationFailure) throws IOException {
        List<PayoutItem> items = IntStream
                .range(1, 6)
                .mapToObj(index -> new PayoutItem()
                        .senderItemId("Test_txn_" + index)
                        .note("Your 1$ Payout!")
                        .receiver("payout-sdk-" + index + "@paypal.com")
                        .amount(new Currency()
                                .currency("USD")
                                .value(includeValidationFailure ? "1.0.0" : "1.00")))
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

    public static HttpResponse<CreatePayoutResponse> createPayouts(HttpClient client, boolean includeValidationFailure) throws IOException {
        PayoutsPostRequest request = new PayoutsPostRequest();
        request.requestBody(buildRequestBody(includeValidationFailure));
        return client.execute(request);
    }

    @Test
    public void testPayoutsPostRequest() throws IOException {
        HttpResponse<CreatePayoutResponse> response = createPayouts(client(), false);
        assertEquals(response.statusCode(), 201);
        assertNotNull(response.result());

        CreatePayoutResponse responseBody = response.result();
        assertNotNull(responseBody.batchHeader().payoutBatchId());
        assertNotNull(responseBody.batchHeader().batchStatus());
        assertEquals(responseBody.batchHeader().senderBatchHeader().emailSubject(), "This is a test transaction from SDK");
        assertEquals(responseBody.batchHeader().senderBatchHeader().emailMessage(), "SDK payouts test txn");
    }

    @Test
    public void testPayoutsPostRequestFailure() throws IOException {
        try {
            HttpResponse<CreatePayoutResponse> response = createPayouts(client(), true);
        } catch (HttpException e) {
            assertEquals(e.statusCode(), 400);
            assertNotNull(e.getMessage());

            String error = e.getMessage();

            Error payoutError = encoder.deserializeResponse(new ByteArrayInputStream(error.getBytes(StandardCharsets.UTF_8)), Error.class, e.headers());
            assertNotNull(payoutError.debugId());
            assertNotNull(payoutError.name());
            assertEquals(payoutError.name(), "VALIDATION_ERROR");
            assertNotNull(payoutError.message());
            assertNotNull(payoutError.informationLink());
            assertEquals(payoutError.informationLink(), "https://developer.paypal.com/docs/api/payments.payouts-batch/#errors");
            assertNotNull(payoutError.details());
            assertEquals(5, payoutError.details().size());
            assertNotNull(payoutError.details().get(0));
            ErrorDetails payoutErrorDetails = payoutError.details().get(0);
            assertNotNull(payoutErrorDetails.field());
            assertNotNull(payoutErrorDetails.issue());
            assertNotNull(payoutErrorDetails.location());
            assertEquals(payoutErrorDetails.location(), "body");
            assertNotNull(payoutErrorDetails);
        }

    }

}
