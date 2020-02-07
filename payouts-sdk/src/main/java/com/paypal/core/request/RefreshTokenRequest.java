package com.paypal.core.request;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.object.RefreshToken;
import com.paypal.http.Headers;
import com.paypal.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

public class RefreshTokenRequest extends HttpRequest<RefreshToken> {

    public RefreshTokenRequest(PayPalEnvironment credentials, String authorizationCode) {
        super("/v1/identity/openidconnect/tokenservice", "POST", RefreshToken.class);
        header(Headers.CONTENT_TYPE, "application/x-www-form-urlencoded");
        header(Headers.AUTHORIZATION, credentials.authorizationString());

        Map<String, String> params = new HashMap<String, String>() {{
            put("grant_type", "authorization_code");
            put("code", authorizationCode);
        }};

        requestBody(params);
    }
}
