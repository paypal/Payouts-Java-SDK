package com.paypal.core.object;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

@Model
public class RefreshToken {

    @SerializedName("refresh_token")
    private String refreshToken;

    public String refreshToken() {
        return refreshToken;
    }
}
