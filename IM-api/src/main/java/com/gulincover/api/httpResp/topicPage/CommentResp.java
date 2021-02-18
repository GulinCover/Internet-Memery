package com.gulincover.api.httpResp.topicPage;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CommentResp {
    private Long topicId;
    private Long commentId;
    private Long userId;
    private String userNickname;
    private Integer sex;
    private Integer level;
    private String content;
    private String opinion;
    private List<CommentEntry> commentEntryList;
    private Date publicTime;
}
