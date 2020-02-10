// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// PayoutItem.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data H4sIAAAAAAAC/9xY3W7buBK+P08x0FUK2FbS03MK5M5wsljvtq7RBAWKbOCMqbFFlCJVctRUWPTdFxQlW7Kc1OsEwWKvEs4Myfm++eHIf0bXZU7ReTTH0hQMU6YsGkSf0EpcKpph5pXRIPqdyu3igpywMmdpdHQeXacEjnRCdigsIVMCeTiNDSBYEjKXpHkUDaKxtViGK08H0UfC5INWZXS+QuXIC74W0lKyEcytycmyJBed32ycHSsmq5EJZoblSgr0rsB74tQkffexMV/olvkia8y32H5m2QU+wZwLSw4wSaSXoYL2PshMQs6zYAlFCjUlnJInheQ3smBpjTaReg2cSueJy56VqnlqNPUpyWvxFnoj6ce20oAusiVZkBokOxCojZYCFUgdKAvwby5HZ/9/Uxt7VLlCDStjM+Tbk5Q5d+dxfH9/P5JcjKTm2JKIr4cfLyfDamtM+tXzoXfsnejDF6bQbMuFMEmXhR1Fn4zaAAQq5fF5QziZTF4NXoYaCE5kS6kpAUV6zSmYVZVUkwmgTqp/N7fWYcsKxz43YUmwrorUAqeo4ex/kMi1ZBdO3t0njHbSsfNX4FabkGMZVjUDs4vJq+p2Vyw9Z35zfcbJ1ezvhZRtsRNRXSj1Y/DTsNJ3Ju18xYarO6Hdo+yHd2NUO//UVDzQ8YbYfX73dX23d8L2D8jFB+vkX52itz9uW9GeFNaSFuWeFynz9HSfnka0p+fU51TOBzsfK0BYSY1aSFTAFrVD4XcNwBUiBXSAsESFWhAY2zwtkBT0RKgH9Nct8lZv3Qr7GG84tURDkaJF4UM/vfowfPP67O0WvY/i7UmcGOFin85rW0U3TqQl4TPUcdwYD72xi1+o73xDVXTfkUbSB1ppBnCfSpFCJtepT/jzP4rT0/+KQlV/KayUDKuxrqp3TbaKeg1RkgMlvxDc/Tb/fOcrhQEtVRXEZe6LXpWwsiEnUI3CoXFz6s4dkJCQGarNjv13Xc8uWne5YpnIbzKhxHvoJxtTONQJp27/dXGD8Bdj6zkokN8UolltHMkVCnJ1oneSYACOCG4mbZmDoU8Z8Cmz08GcGRm7jqUzVUINuzkySjlTz1T8BzR6w91EqQUPTtQuJyFX0jNkmCo22iOmG8FVkefGsoMi99Plm9PTUxhfTaZT2BSTqzrHmddoo4e72hd65JqZt4O/JexzsJmS60elmY5hYqwllxuduGaivtt8Zyy4zOkuFJp/CJs8I8cjeI/fa41Z1YydvX4LTuq1ouGyZDqWmKO7R9fxXXa6qr0cBRNf9TSCTwG2e7SlhFXeXvhiCOvL9+Ppu7pet9Lw+BaatLBl7j/yKEOpthcCQkB4ELP1+R0XHuhNjzo7//XD7PIAZ9sfMXsvXyojvnwtDFNb6tgavQ6SmeGmUcdteXXXHMs5KvDdb2m+Q2LIVa3YheqskvAw33cjWhvs9+8oysaf5+N3i+nFA7RtSatBoaimucfYe6jP19zaOCynq71EhF63WCKLdJESJmT7tEgtVFF9T+85oVso/c3IbOWyYBo0v01IpsxB4eio88zxQAZQaEXO10vLFUjRVSO7udfHoxvBUxg2mXfgifRWv3S0gVVzfR28oxFWLfvl3qnal3tUiviBjrxRPtaTg9ELOV4H2bO+kN0ftnqqAwaO6UVT8XBtUXxxzRtchVYD6qYz+KbvSseUPQvS2x//+QsAAP//
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

/**
 * The sender-created payout to a recipient.
 */
@Model
public class PayoutItem {

    // Required default constructor
    public PayoutItem() {
    }

    /**
     * Captures additional notification modes to reach out to the receiver regarding this payment.
     */
    @SerializedName("alternate_notification_method")
    private AlternateNotificationMethod alternateNotificationMethod;

    public AlternateNotificationMethod alternateNotificationMethod() {
        return alternateNotificationMethod;
    }

    public PayoutItem alternateNotificationMethod(AlternateNotificationMethod alternateNotificationMethod) {
        this.alternateNotificationMethod = alternateNotificationMethod;
        return this;
    }

    /**
     * REQUIRED
     * The currency and amount for a financial transaction, such as a balance or payment due.
     */
    @SerializedName("amount")
    private Currency amount;

    public Currency amount() {
        return amount;
    }

    public PayoutItem amount(Currency amount) {
        this.amount = amount;
        return this;
    }

    /**
     * The sender-specified note for notifications. Supports up to 4000 ASCII characters and 1000 non-ASCII characters.
     */
    @SerializedName("note")
    private String note;

    public String note() {
        return note;
    }

    public PayoutItem note(String note) {
        this.note = note;
        return this;
    }

    /**
     * REQUIRED
     * The receiver of the payment. Corresponds to the `recipient_type` value in the request. Max value of up to 127 single-byte characters.
     */
    @SerializedName("receiver")
    private String receiver;

    public String receiver() {
        return receiver;
    }

    public PayoutItem receiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    /**
     * The recipient type. Value is:<ul><li><p><code>EMAIL</code>. The unencrypted email. Value is a string of up to 127 single-byte characters.</p></li><li><p><code>PHONE</code>. The unencrypted phone number.</p><blockquote><strong>Note:</strong> The PayPal sandbox does not support the <code>PHONE</code> recipient type.</blockquote></li><li><p><code>PAYPAL_ID</code>. The encrypted PayPal account number.</p></li></ul><br/>If the <code>sender_batch_header</code> includes the <code>recipient_type</code> attribute, payout items use the <code>recipient_type</code> of the <code>sender_batch_header</code>, unless a payout item has its own <code>recipient_type</code> attribute. If the <code>sender_batch_header</code> omits the <code>recipient_type</code> attribute, each payout item must include its own <code>recipient_type</code> value.
     */
    @SerializedName("recipient_type")
    private String recipientType;

    public String recipientType() {
        return recipientType;
    }

    public PayoutItem recipientType(String recipientType) {
        this.recipientType = recipientType;
        return this;
    }

    /**
     * The recipient wallet.
     */
    @SerializedName("recipient_wallet")
    private String recipientWallet;

    public String recipientWallet() {
        return recipientWallet;
    }

    public PayoutItem recipientWallet(String recipientWallet) {
        this.recipientWallet = recipientWallet;
        return this;
    }

    /**
     * The sender-specified ID number. Tracks the payout in an accounting system.
     */
    @SerializedName("sender_item_id")
    private String senderItemId;

    public String senderItemId() {
        return senderItemId;
    }

    public PayoutItem senderItemId(String senderItemId) {
        this.senderItemId = senderItemId;
        return this;
    }
}
