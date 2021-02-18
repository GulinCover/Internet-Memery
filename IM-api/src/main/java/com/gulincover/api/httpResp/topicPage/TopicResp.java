package com.gulincover.api.httpResp.topicPage;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TopicResp implements Serializable {
    private Long topicId;
    private String title;
    private String content;
    private Long userId;
    private String userNickname;
    private Integer sex;
    private Integer level;
    private String avatar;
    private Date publicTime;
    private Date lastUpdate;
    private List<TopicEntry> topicEntryList;
    private Integer likeNumber;
    private Integer commentNumber;
    private Integer favoritesNumber;
    private Integer browseNumber;

    private String code;
}
