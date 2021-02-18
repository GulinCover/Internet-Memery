package com.gulincover.api.httpResp.topicPage;

import lombok.Data;

import java.util.List;

@Data
public class Comment1sResp {
    private List<CommentResp> commentRespList;
    private String code;
}
