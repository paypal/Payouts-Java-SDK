// This class was generated on Mon, 16 Dec 2019 21:04:40 IST by version 0.1.0-dev+904328-dirty of Braintree SDK Generator
// PayoutBatch.java
// @version 0.1.0-dev+904328-dirty
// @type object
// @data H4sIAAAAAAAC/+wda2/cNvL7/YrB9oA0wD7cpukj33xxivquSI3YyeHgC9ZcabTimSIVDuWNcLj/fuBDWr02dpz1tkn1KdkZSpwXh/Mg5f9OLsocJ88mZ6xUhYG/MROlk+nkDdOcrQS+ZJnFTqaTf2C5/XGCFGmeG67k5NnkIkU4Y+UZE7M1StTMYAwr+yYgw0xB88l0cqw1K/1kR9PJK2Txb1KUk2cJE4QW8K7gGuMacKZVjtpwpMmzy0Ey4RdkMeo+tW7qZVpht5R3EH0ucv96PwJMygxwAo2m0BJj4BI0Uq4kIRgFrDNe47sCyczhPFUbghgN44IgURqYBJSG63qKauzeJPO80BplVPbFwTJVSNMSRA3qiyAK7wEmY/DjPAeQcMlkxJkAo5kkFtmnpkBFlAIjYLBigskIQWnLZYbSQFzg/lgko7lc9xmMtqxvWWwA+0xemlQjzqKUaRYZ1HB6/tvsu2+/+WHLfqRifPv1IlYRLbg0uNbMvmARc42RWWgks6gGz+xgWjz+KFaNLjqcykKI/01vZfeGiQJbvFaQPqMOM4VNyqMUMr5ODazw2b+Lo6MnUSHcv+h/Ce5/HUtw7KJ2ag8sciQQ/Brh6u9n/7ryK4NpBKkMmDLnEROihER7o2Bi7l+6qN7amQNijHjGRP3E8FwXL08ac1GxivkNj91CNApMqgpiMjYpDU+3qDj8WdnFjG7RWeGDLLIValBJTUguWIRhrbaNYAqECJfPmzCCmTUZsCbz9uvUmJyeLRabzWbOSc2VXi84KWdQs7aNzFOTib3Yyds7WIr3d94HDzjCGrHLEdJ9/Petdt2QpLxBTVb9GkkVOsLdi3u5HT24ztv4D/i1gVkf3kXh+yhlco1Luzm26O9i+pRXI8COqDcllueCY+ws1qScgso+lZUduupzlGiVLQe2ljZ83F/G/WXcXz73/WW3FzBqyAc0oaMHGD3A6AE+Tw/Q9AEvtFYDuTZacDu4rEEDoYxFAZeJ0pkz9odfujGuivWSxy0SG8BdpQxno1oyAacnc3hNIdSKlNYoHO2QFzpXhLTnmMtJGk589WCIoQrR5KeCtdk5lsAsYdYOWRxzv3RalQlTqaXDxff7V0XCUbT1UEH6SpAsQ0u1Jc+N8qs0YoXVxC6iP1X0uyjnRB2HWEH6lGtkFNzNfsm8S8bXWFpLweV1m+Y+sk/+61enYFQwEecI64fAWb4Vv/Iph1/OFacx3qCwNB9mk8qQiK3bWtnC+owFnLej2KFXSPfU0b2ptnbdIjkA+vSmRcbkTCOL7eNTKCR/V7QXxt7ovluwlyC23U4AjCHeGOKNId6XWkRMChlzuV7WBbrG+u+i2rZzGqM0PLGqYBDGgh9r9Y0H2rx9YWzpa56dQLCPu0Nr6/QkqPgeJbdbF2zocJ2jjFHf0ugiN2i5s981jO9z6MfNcq38ygj9rCaT92pY9Zm9Q6U0Y1wshzb3LmYgvbAj2ht9COYthwSbFKVbw4EnbjCDSGW5QIM0h2aYwH1oQHa7dYIQAjRGPOcoDR3IdD3LVKz+g5EZEMYWM6BUjwPBJW6jUSehHZKp9tuW3odk1Hr1LYKCN3b3cBVrCUzkKZNFhppH4JmGDTcpMMjYe54VGQiUa5Nar/rt06dAXK4FzlalQag32kNJv+Ziab1VS/w9VF/+pyfOyYWC/dYVBvtzktYYIb/BQ6UxLX/Q8YR93E4/QTlGlhfnCf0uOIcLzaJraq0u6VQeRTb8c66/JINZ2GZXQkXX7wplsLnbktFKrj3kpTJVlLFowsHDcv8rmHGskFwgkWsVIRHERS54xEzdy5rDaQKlKsCTXwILL7J7qn9XRwZh7i3e63LDCFwWyr0zEYwMPDmCmJU0dZDjs1PQaJcI1SEDkgmmLkPe1PJT5I4MuDSqJvyjybPRNpeRKGK35f5yfPHit+Nzu0yvfc5mw2q+5tLGKl5JjqR6/X7sjFXIlDd1GH4EaQcTt2z/cnFx1pviqQeEmEvK8MZ2DNbg0XckQ1BlJ4iYBGIJihI0Gl32JX5/9py3s9qsHaB3jG7xKilKUDZX8Q7zftbEgzFZSrms7GhQsIvumjlUVcHwDJeRUIRtn9GG9/1FbK3YGqUd2Nt97TryD0/tUro8dQU3NJ3HfPlhGyAbpQTNOZrExcg2Fl7oJHry5MlPXxG6RGD2dP794zkc157I2oskHqON2/2cnhy7Wdkdjpy3CoeWbJ4Q3AjGnpAUgd0wLqxQ6hQ10SpzKINZrjTTJaRKxP7IkEBGGB/IsXtFBBsd0lEDdSc1Bfat165Ch6bWqtc9jOIOKTONbFhiNeIT5bXCNZN/XDm97aceuL9Kfyg0j1X+jyg176WCm9TC75Rw6+MiB6x5fumV2lCZbRdsfaH2/l2AuxYKbukWhQKHm3851DraMeBOfaQPLfKxf/RH6x9tyfzVJgTNmXsEW+fStpMKstswQsw9q7pEl838g6oyOMv5QmOCGmWE9tesOlJNi69SZlAxmrknHj+8RaUakxaXATDQ0QghDxim12jg9atf53ChIGPXGDIOz3XEhJja4SsuPSZDk6q4SkU4waX10BeY5faJmffNBuNbI4Dvn/5w9NhJcw4/Kw25xtk28JhWqZ+b9OqvV1O4+vpq6uKMq8dXzfKJS2uuLK9XVfnmGss6X7S8KmlTHLdmnDKAbaM+x2NVt6FiRVbx0jjwgRaUl2lnRwmgvvJc4hnUUJfvzQ7lHay4JDoVJTHcZXLZex2NmDLHWw3l6U8//liHit89rlo3hPrGZrCuFFcXsX11wCq6kCxb8XWhChJlZ+MlzJg0PKLKqXozPEeES+dOXgUKqdPKYJI52hgRX0ubONPCPjurWOr+nL//+PbG7uj27VCE66vqpwazAVdts8G2qw6Q3Z6PS9dTKlhIJh/ecbHI8Btuym7I24bvDFV6LY1IZZlyRhESH7s8nGX4KgbY5Nm5kqpk6SGNJm4jfDaaRddcrh/oMPJ4cHw8OD6eKRjPFIxnCsaD46MHGD3A6AHGg+NjSXk8OD4W/saD42M74nc7OD5Wlceq8lhVHqvKf4Kq8u936Hx7smTPFhVK46cGsxBC7mSK+8J5j6EAHzgw0/wSUnWKtCo0h3My7ntK/rjv9vjw+HmkTz9QP5YgxhLEeLFpKKJWnY5KANzh3Lsd6aQhleEJj8IeA+dFnittCIrcOrTvjo6O4Pj8+elpI05ynuMbi5FKzrrYw11tcF287qWGCjiUnYa+X9ipgwubw3OlfawdU3XI/Kp9PeLKL7TqvPx+bhJ1GH3ps6GdNzh66VMP9eFSQs60KR++6MSEqx0ZXCaFEH2qh/Ft0k9enL168fz44sWJD8kd6Y8I6mcdY3N4ziSs0G5MBXGJRA4+Bcmja/8/9+HCEpRJUXtphFqKtJ5thUC54Mb7m4RrMlN/GcK/vxJF8+C3NqXrQdZzHsjeh6W5W4b/HCA5R012RzcNmdo3eHYPw8ea36DsM9IC348T9wqn8qDJA3KV8TgW2GerDb8fX/4dwSRfEwITpKyjIqM0QlYIw3OBzXEUcl4u1+FVRitZZjzy8mF2PTyiaevdB7rLqjHh79vBdwUa+IqfQzmiDTcCp5WDroRzQMqpSLqU16Chy4sW1ch4fgd6dc8et7D72WJ43htRxkUZzPLYmuS1VBtpM4X6Ttkd3Kif5YOGHSbtGnXWNupMVUYdxh8sU/7iblluqd4wIdDsYKlG9pnyKKtwXVWSwlMVL82LlnM4C1/rNAreoMxU4/5tFdUDg0c2an1UXbt1+Su8PodMrbhAyFMlsbrNedDrqNxgtuM26hbVKRDv6Srqvm18d5WhUSJZJoi7yicBN559GAsPY+HhSy08NNf7cGl4l98LO17niqEdPYc3HDfu4pGLE9xF91RtOrXXBykdf/CGZX2Rtn/Hsom64+VhTv6DFBtGPkaq3/FZX0XdOu6uQfRQH9cqaJ7PPjwvA18eH0T3eXJKbozd0x+SGHvWY8967FmPPes/d886BJJDh7INE8v+Dag2vK8Zh29Eb/UXNdwhvMJ9EIoKYRcQ7Tv4uIWZnK1xiJkKfjszbuSedPCX/wMAAP//
// DO NOT EDIT
package com.paypal.payouts;

import com.paypal.http.annotations.Model;
import com.paypal.http.annotations.SerializedName;

import java.util.List;

/**
 * The PayPal-generated batch status.
 */
@Model
public class PayoutBatch {

    // Required default constructor
    public PayoutBatch() {
    }

    /**
     * The payout header that is returned in response to a payout header request. Shows details for an entire payout request.
     */
    @SerializedName("batch_header")
    private PayoutBatchHeader batchHeader;

    public PayoutBatchHeader batchHeader() {
        return batchHeader;
    }

    public PayoutBatch batchHeader(PayoutBatchHeader batchHeader) {
        this.batchHeader = batchHeader;
        return this;
    }

    /**
     * An array of individual items.
     */
    @SerializedName(value = "items", listClass = PayoutBatchItem.class)
    private List<PayoutBatchItem> items;

    public List<PayoutBatchItem> items() {
        return items;
    }

    public PayoutBatch items(List<PayoutBatchItem> items) {
        this.items = items;
        return this;
    }

    /**
     * An array of request-related [HATEOAS links](/docs/api/reference/api-responses/#hateoas-links).
     */
    @SerializedName(value = "links", listClass = LinkDescription.class)
    private List<LinkDescription> links;

    public List<LinkDescription> links() {
        return links;
    }

    public PayoutBatch links(List<LinkDescription> links) {
        this.links = links;
        return this;
    }

    /**
     * The total number of items in the full result list.
     */
    @SerializedName("total_items")
    private Integer totalItems;

    public Integer totalItems() {
        return totalItems;
    }

    public PayoutBatch totalItems(Integer totalItems) {
        this.totalItems = totalItems;
        return this;
    }

    /**
     * The total number of pages.
     */
    @SerializedName("total_pages")
    private Integer totalPages;

    public Integer totalPages() {
        return totalPages;
    }

    public PayoutBatch totalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }
}
