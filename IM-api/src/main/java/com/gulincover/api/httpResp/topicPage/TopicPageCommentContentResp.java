package com.gulincover.api.httpResp.topicPage;

import com.gulincover.api.entity.EntryInfo;

import java.util.Date;

public class TopicPageCommentContentResp {
    public Integer userId;
    public String name;
    public String avatar;
    public String Content;
    public Integer likeNumber;
    public Integer commentNumber;
    public Date createDate;
    public EntryInfo[] entryInfos;
}
