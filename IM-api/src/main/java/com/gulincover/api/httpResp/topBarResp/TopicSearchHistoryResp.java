package com.gulincover.api.httpResp.topBarResp;

import lombok.Data;

import java.util.List;

@Data
public class TopicSearchHistoryResp {
    private Long userId;
    private List<TopicSearchHistoryAbs> searchHistoryList;

    private String code;
}
