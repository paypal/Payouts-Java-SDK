// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// PayoutSenderBatchHeader.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data H4sIAAAAAAAC/7xUTU8jSQy976+w+hxCtIhLblmxEmgliJaIy+4qcqqddC3VVY3tItMa8d9H1dX5IkEzMCMuLZXttt97/vhazNqGinExxTZEhXvyJTH8gWoquCYsiYtB8YBsceHoFusUWwyKv6jdPa5IDNtGbfDFuJhVBNKlOWs4PNuSSqi6TLAMDAhNLsX0FEl0WAyKCTO2GchoUPxNWN551xbjJTqhZHiKlqncGqYcGmK1JMX4ny0FUbZ+dQyXarRuXpMIrugA+2vPMZEuAvoI0AoVpthO0XUUBdYVedCKNqSsUg0m1I0jJRlCyrH520oXKVhTVsI5YDK2seRVflYHH517GfygGBIX/5PRE2LsPCe6mn3grM8MdKvQG8o02Nbk9bDxpzQ6SP0doeABXeyi0AO6pkIfa2JrIJOGtdUKEGr8YutYgyO/0grCEn6/vASxfuXobNEqgamQ0SjxZ6m/ZTHXFLgv/5HrWP+bK0i+LLYtyatdWpLN/HVKMxmyz8SfRCgv+nyR7sXclgeMjn1vHgppyCQuZeLoY70gHsKM0TzKwXb5ruXGhOg1dVpaUaqH/8bR6MIsXDCPTzEode/8NaIc/CpbboPSOJvP9+2QbU1+9WNcBhLwQaHhYEgEytg4a1A3cGQIN0toQ4QMvwXsE5lQ9hheadDX3vlzL9coEIXKRDDRdSgKFyMosZVBZ5lMb4AprUgWpD+e/ah7IObAh3dKqrDOwTvg74aHPoEyLpYkgHA9mf15N7lPa/oIGrrsge3KenSbJnWQtvv73op9L8+b/R72j17tfsQT7evZbHpU4jIbbH5532e0+xn3OYqiRoFkGXQFDHoQXJJrgUm5PVb84/S6a5e6uT2A+TB2yxu8ayF405+9D06T7YcpIbV+M0cnhT1/vTO/4mr89/LbNwAAAP//
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

/**
 * The sender-provided header for a payout request.
 */
@Model
public class PayoutSenderBatchHeader {

    // Required default constructor
    public PayoutSenderBatchHeader() {
    }

    /**
     * The email message that PayPal sends when the payout item completes. The message is the same for all recipients.
     */
    @SerializedName("email_message")
    private String emailMessage;

    public String emailMessage() {
        return emailMessage;
    }

    public PayoutSenderBatchHeader emailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
        return this;
    }

    /**
     * The subject line for the email that PayPal sends when payment for a payout item completes. The subject line is the same for all recipients. Value is an alphanumeric string with a maximum length of 255 single-byte characters.
     */
    @SerializedName("email_subject")
    private String emailSubject;

    public String emailSubject() {
        return emailSubject;
    }

    public PayoutSenderBatchHeader emailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
        return this;
    }

    /**
     * The ID type that identifies the payment receiver.
     */
    @SerializedName("recipient_type")
    private String recipientType;

    public String recipientType() {
        return recipientType;
    }

    public PayoutSenderBatchHeader recipientType(String recipientType) {
        this.recipientType = recipientType;
        return this;
    }

    /**
     * The sender-specified ID number. Tracks the payout in an accounting system.<blockquote><strong>Note:</strong> <p>PayPal does not process duplicate payouts. If you specify a <code>sender_batch_id</code> that was used in the last 30 days, the API rejects the request with an error message that shows the duplicate <code>sender_batch_id</code> and includes a HATEOAS link to the original payout with the same <code>sender_batch_id</code>.</p><p>If you receive an HTTP <code>5<i>nn</i></code> status code, you can safely retry the request with the same <code>sender_batch_id</code>. The API completes a payment only once for a <code>sender_batch_id</code> that is used within 30 days.</p></blockquote>
     */
    @SerializedName("sender_batch_id")
    private String senderBatchId;

    public String senderBatchId() {
        return senderBatchId;
    }

    public PayoutSenderBatchHeader senderBatchId(String senderBatchId) {
        this.senderBatchId = senderBatchId;
        return this;
    }
}
