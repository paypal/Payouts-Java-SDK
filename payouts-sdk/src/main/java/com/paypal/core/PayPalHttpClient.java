package com.paypal.core;

import com.paypal.core.object.AccessToken;
import com.paypal.core.request.AccessTokenRequest;
import com.paypal.core.request.RefreshTokenRequest;
import com.paypal.http.HttpClient;
import com.paypal.http.HttpRequest;

import java.io.IOException;

import static com.paypal.core.UserAgent.USER_AGENT;
import static com.paypal.http.Headers.ACCEPT_ENCODING;
import static com.paypal.http.Headers.AUTHORIZATION;

public class PayPalHttpClient extends HttpClient {

    private String refreshToken;

    public PayPalHttpClient(PayPalEnvironment environment) {
        super(environment);
        this.addInjector(this::addGzipHeader);
        this.addInjector(this::signRequest);
        this.addInjector(this::addFPTIHeaders);

    }

    public PayPalHttpClient(PayPalEnvironment environment, String refreshToken) {
        this(environment);
        this.refreshToken = refreshToken;
    }

    @Override
    protected String getUserAgent() {
        return USER_AGENT;
    }

    private void signRequest(HttpRequest request) throws IOException {
        if (!hasAuthHeader(request) && !isAuthRequest(request)) {
            AccessToken accessToken = AuthorizationProvider.sharedInstance().authorize(this, refreshToken);
            request.header(AUTHORIZATION, accessToken.authorizationString());
        }
    }

    private void addFPTIHeaders(HttpRequest request) throws IOException {
        request.header("sdk_name", "Payouts SDK");
        request.header("sdk_version", "1.1.1");
        request.header("sdk_tech_stack", "Java " + System.getProperty("java.version"));
        request.header("api_integration_type", "PAYPALSDK");
    }

    private void addGzipHeader(HttpRequest request) throws IOException {
        request.headers().headerIfNotPresent(ACCEPT_ENCODING, "gzip");
    }

    private boolean isAuthRequest(HttpRequest request) {
        return request instanceof AccessTokenRequest || request instanceof RefreshTokenRequest;
    }

    private boolean hasAuthHeader(HttpRequest request) {
        return request.headers().header(AUTHORIZATION) != null;
    }

    PayPalEnvironment getPayPalEnvironment() {
        return (PayPalEnvironment) super.getEnvironment();
    }
}
