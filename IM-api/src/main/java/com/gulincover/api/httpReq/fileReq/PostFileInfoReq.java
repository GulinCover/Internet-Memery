package com.gulincover.api.httpReq.fileReq;

import lombok.Data;

@Data
public class PostFileInfoReq {
    private Long userId;
    private String fileName;
    private String accessPath;
}
