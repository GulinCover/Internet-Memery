package com.gulincover.api.httpResp.JsonReq;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EntryInfosByCommentIdsAbs implements Serializable {
    public static final long serialVersionUID = 8706843673978981262L;
    public List<Integer> commentIds;
}
