package com.gulincover.api.httpReq.displeasureReq;

import lombok.Data;

@Data
public class PostDispleasureInfoReq {
    private Long userId;
    private Long TopicId;
    private Long commentId;
}
