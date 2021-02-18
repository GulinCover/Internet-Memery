package com.gulincover.api.httpResp.auctionPage;

import lombok.Data;

import java.util.List;

@Data
public class TopicTopTenResp {
    private List<Bill> billList;
    private String code;
}
