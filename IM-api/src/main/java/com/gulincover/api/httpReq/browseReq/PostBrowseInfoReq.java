package com.gulincover.api.httpReq.browseReq;

import lombok.Data;

@Data
public class PostBrowseInfoReq {
    private Integer start;
    private Integer end;
    private Long userId;
}
