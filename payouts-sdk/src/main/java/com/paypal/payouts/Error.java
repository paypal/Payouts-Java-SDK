// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// Error.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data H4sIAAAAAAAC/6yTQW/bMAyF7/sVhM5esdMOvhXIDsWALSjaXYaiYCI6JiZLLiUNMIb+90GOnUTTMqxOjn4Uje/xkb/Uw9CTqtUnESeqUt9QGDeGvmCXZFWpzzQcP1bkt8J9YGdVrR5aAkqNwLZx0mHSb1SlbkVw2P/5Q6XuCfVXawZVN2g8JeElspA+CGtxPUlg8qr+fmDyQdjuSihNm7h7Zp3BnYgl5BqHNRpgG0gsGrhb3cCjJw2NE9g6ETIjO/RReufJX2rCRmNeq3y6sKKAbPzfDM2FUz+zltu5tYAJDFwDqDUnGQ1Mz0dDYY7lDxcfrx9Fw2TyHGalDMFiR4k64Y2vILQYYIsxJXEO+tLRnyNn7yNl5LNSkguhd/afs12G+fQ/oMfTejZsf+TMZbHEf7y/g+CmFSF9eqwwbn4av4PQsp/OeXaq6SeZxPwmt0Hiskw68h53eSpHrTQ21fZ7pMfyhvzCjBZTp73OkCeh5G1jh/a9EOrUXkG0/BLzw7ga99Pru98AAAD//w==
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

import java.util.List;

/**
 * The error information.
 */
@Model
public class Error {

    // Required default constructor
    public Error() {
    }

    /**
     * The PayPal internal ID. Used for correlation purposes.
     */
    @SerializedName("debug_id")
    private String debugId;

    public String debugId() {
        return debugId;
    }

    public Error debugId(String debugId) {
        this.debugId = debugId;
        return this;
    }

    /**
     * An array of additional details for the error.
     */
    @SerializedName(value = "details", listClass = ErrorDetails.class)
    private List<ErrorDetails> details;

    public List<ErrorDetails> details() {
        return details;
    }

    public Error details(List<ErrorDetails> details) {
        this.details = details;
        return this;
    }

    /**
     * REQUIRED
     * The URI to detailed information related to this error for the developer.
     */
    @SerializedName("information_link")
    private String informationLink;

    public String informationLink() {
        return informationLink;
    }

    public Error informationLink(String informationLink) {
        this.informationLink = informationLink;
        return this;
    }

    /**
     * REQUIRED
     * The message that describes the error.
     */
    @SerializedName("message")
    private String message;

    public String message() {
        return message;
    }

    public Error message(String message) {
        this.message = message;
        return this;
    }

    /**
     * REQUIRED
     * The human-readable, unique name of the error.
     */
    @SerializedName("name")
    private String name;

    public String name() {
        return name;
    }

    public Error name(String name) {
        this.name = name;
        return this;
    }
}
