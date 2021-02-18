package com.gulincover.api.httpResp.userPage;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BrowseHistoryResp {
    private Long topicId;
    private String topicTitle;
    private String topicContent;
    private Date accessTime;
    private List<BrowseHistoryEntry> entryList;
    private Long userId;
    private String userAvatar;
    private String userName;
}
