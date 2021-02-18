package com.gulincover.api.httpResp.topicPage;

import com.gulincover.api.entity.EntryInfo;

import java.util.List;

public class TopicPageTopicContentResp {
    public Long topicId;
    public String topicName;
    public String content;

    public Integer topicLikeNumber;
    public Integer topicShareNumber;
    public Integer topicBrowseNumber;
    public String opinions;

    public List<EntryInfo> entryInfos;
}
