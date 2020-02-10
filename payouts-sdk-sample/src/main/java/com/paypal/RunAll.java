package com.paypal;

import com.paypal.http.HttpResponse;
import com.paypal.payouts.CreatePayoutResponse;
import com.paypal.payouts.PayoutBatch;
import com.paypal.payouts.PayoutItemResponse;

import java.io.IOException;

public class RunAll {

    public static void main(String[] args) throws IOException, InterruptedException {
        //Create Payout
        System.out.println("Creating Payout");
        HttpResponse<CreatePayoutResponse> createResponse = new CreatePayoutsBatch().createPayout();
        if (createResponse.statusCode() == 201) {
            String batchId = createResponse.result().batchHeader().payoutBatchId();
            //Retrieve Payout Batch
            System.out.println("Successfully created Payout batch with id: " + batchId);
            HttpResponse<PayoutBatch> getResponse = new GetPayoutBatch().getPayoutBatch(batchId);
            if (getResponse.statusCode() == 200) {
                //Retrieve Payout Item
                System.out.println("Successfully retrieved Payout batch with id: " + batchId);
                String itemId = getResponse.result().items().get(0).payoutItemId();
                HttpResponse<PayoutItemResponse> getItemResponse = new GetPayoutItem().getPayoutItem(itemId);
                if (getItemResponse.statusCode() == 200) {
                    System.out.println("Successfully retrieved payout item with id: " + itemId);
                    int i = 0;
                    //Check if Payout Batch status is SUCCESS(indicates all Payout items are processed)
                    //This is for demonstration purpose, defer using this while integrating
                    //Note: Integrate with Webhooks to get real time updates for Payouts batch and items
                    do {
                        Thread.sleep(2000);
                        getResponse = new GetPayoutBatch().getPayoutBatch(batchId);
                        if (getResponse.result().batchHeader().batchStatus().equals("SUCCESS")) {
                            //Cancel 1st unclaimed Payout item
                            System.out.println("Cancelling unclaimed Payout item with id: " + itemId);
                            HttpResponse<PayoutItemResponse> cancelResponse = new CancelPayoutItem().cancelPayoutItem(itemId);
                            if (cancelResponse.statusCode() == 200) {
                                System.out.println("Successfully cancelled unclaimed Payout item with id: " + itemId);
                            } else {
                                System.out.println("Failed to cancel unclaimed Payout item with id: " + itemId);
                            }
                            break;
                        }
                        i++;
                    } while (i < 5);
                    if (i == 5) {
                        System.out.println("Payouts batch has not processed all payments yet, couldn't cancel unclaimed payment");
                    }
                } else {
                    System.out.println("Failed to retrieve Payout item with id: " + itemId);
                }
            } else {
                System.out.println("Failed to retrieve Payout batch with id: " + batchId);
            }
        }
    }
}
