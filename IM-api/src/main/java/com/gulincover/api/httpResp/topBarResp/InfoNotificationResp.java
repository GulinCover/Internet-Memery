package com.gulincover.api.httpResp.topBarResp;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class InfoNotificationResp implements Serializable {
    private List<Long> attentionTopicIds;

    private String code;
}
