package com.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;

public class PayPalClient {

    /**
     * Setting up PayPal SDK environment with PayPal Access credentials. For demo
     * purpose, we are using SandboxEnvironment. In production this will be
     * LiveEnvironment.
     */
    private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
            System.getProperty("PAYPAL_CLIENT_ID") != null ? System.getProperty("PAYPAL_CLIENT_ID")
                    : "<<PAYPAL-CLIENT-ID>>",
            System.getProperty("PAYPAL_CLIENT_SECRET") != null ? System.getProperty("PAYPAL_CLIENT_SECRET")
                    : "<<PAYPAL-CLIENT-SECRET>>");

    /**
     * PayPal HTTP client instance with environment which has access credentials
     * context. This can be used invoke PayPal API's provided the credentials have
     * the access to do so.
     */
    PayPalHttpClient client = new PayPalHttpClient(environment);

    /**
     * Method to get client object
     *
     * @return PayPalHttpClient client
     */
    public PayPalHttpClient client() {
        return this.client;
    }
}