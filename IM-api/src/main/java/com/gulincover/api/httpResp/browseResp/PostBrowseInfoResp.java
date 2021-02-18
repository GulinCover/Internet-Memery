package com.gulincover.api.httpResp.browseResp;

import com.gulincover.api.HttpStateCode;
import com.gulincover.api.entity.BrowseInfo;
import lombok.Data;

import java.util.List;

@Data
public class PostBrowseInfoResp {
    private HttpStateCode httpStateCode;
    private List<BrowseInfo> result;
}
