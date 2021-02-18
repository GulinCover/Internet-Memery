package com.gulincover.api.httpResp.topicPage;

import lombok.Data;

import java.util.Date;

@Data
public class Comment2Resp {
    private Long topicId;
    private Long commentId;
    private Long userId;
    private String userNickname;
    private Integer sex;
    private Integer level;
    private String content;
    private Date publicTime;
}
