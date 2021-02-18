package com.gulincover.api.httpResp.userPage;

import lombok.Data;

import java.util.List;

@Data
public class BrowseHistoryListResp {
    private List<BrowseHistoryResp> browseHistoryRespList;
    private String code;
}
