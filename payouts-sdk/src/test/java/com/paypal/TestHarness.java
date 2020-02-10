package com.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpClient;
import org.testng.annotations.BeforeMethod;


public class TestHarness {

    private HttpClient client;
    private PayPalEnvironment environment;

    @BeforeMethod
    public void setup() {
        environment = new PayPalEnvironment.Sandbox(
                "AdV4d6nLHabWLyemrw4BKdO9LjcnioNIOgoz7vD611ObbDUL0kJQfzrdhXEBwnH8QmV-7XZjvjRWn0kg",
                "EPKoPC_haZMTq5uM9WXuzoxUVdgzVqHyD5avCyVC1NCIUJeVaNNUZMnzduYIqrdw-carG9LBAizFGMyK");
        client = new PayPalHttpClient(environment);
    }

    protected HttpClient client() {
        return client;
    }

    protected PayPalEnvironment environment() {
        return environment;
    }
}
