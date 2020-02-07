package com.paypal.core.request;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.object.AccessToken;
import com.paypal.http.Headers;
import com.paypal.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

public class AccessTokenRequest extends HttpRequest<AccessToken> {

    @SuppressWarnings("unchecked")
    public AccessTokenRequest(PayPalEnvironment environment) {
        super("/v1/oauth2/token", "POST", AccessToken.class);
        header(Headers.CONTENT_TYPE, "application/x-www-form-urlencoded");
        header(Headers.AUTHORIZATION, environment.authorizationString());

        Map<String, String> body = new HashMap<String, String>() {{
            put("grant_type", "client_credentials");
        }};

        super.requestBody(body);
    }

    public AccessTokenRequest(PayPalEnvironment credentials, String refreshToken) {
        this(credentials);

        Map<String, String> body = new HashMap<String, String>() {{
            put("grant_type", "refresh_token");
            put("refresh_token", refreshToken);
        }};

        super.requestBody(body);
    }
}
