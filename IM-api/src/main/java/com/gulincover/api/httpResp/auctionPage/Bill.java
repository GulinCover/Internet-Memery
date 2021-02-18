package com.gulincover.api.httpResp.auctionPage;

import lombok.Data;

@Data
public class Bill {
    private Long id;
    private String content;
    private Long buyerId;
    private String buyerUUID;
    private String buyer;
    private String sellerUUID;
    private Long sellerId;
    private String seller;
    private String type;
    private String price;
}
