package com.paypal.core.object;

import com.paypal.core.Authorization;
import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

import java.util.Date;

@Model
public class AccessToken implements Authorization {

    private final transient Date createDate = new Date();

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType = "Bearer";

    @SerializedName("expires_in")
    private Integer expiresIn;

    public boolean isExpired() {
        Date expireDate = new Date(createDate.getTime() + (expiresIn * 1000));
        return new Date().after(expireDate);
    }

    public String accessToken() {
        return accessToken;
    }

    public String tokenType() {
        return tokenType;
    }

    public Integer expiresIn() {
        return expiresIn;
    }

    public Date createDate() {
        return createDate;
    }

    @Override
    public String authorizationString() {
        return String.format("Bearer %s", accessToken);
    }
}
