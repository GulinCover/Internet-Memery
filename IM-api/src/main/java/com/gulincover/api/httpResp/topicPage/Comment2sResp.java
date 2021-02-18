package com.gulincover.api.httpResp.topicPage;

import lombok.Data;

import java.util.List;

@Data
public class Comment2sResp {
    private List<Comment2Resp> commentRespList;
    private String code;
}
