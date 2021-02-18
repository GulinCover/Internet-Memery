package com.gulincover.api.httpReq;

import lombok.Data;

import java.io.Serializable;

@Data
public class PublicTopicInfoAbs implements Serializable {
    private Long userId;
    private String topicName;
    private String topicContent;
}
