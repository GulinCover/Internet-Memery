package com.gulincover.home.controller.otherRelated;

import com.gulincover.api.entity.EntryInfo;
import com.gulincover.home.service.otherRelated.EntryInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("InquireEntryInfoApi")
@RestController
public class InquireEntryInfoApi {
    @Autowired
    private EntryInfoRelatedService entryInfoRelatedService;

    @ApiOperation("/rpc/entry/entryInfos/by/topicId")
    @GetMapping("/rpc/entry/entryInfos/by/{topicId}")
    public EntryInfo[] rpcGetEntryInfosByTopicId(@PathVariable("topicId")Integer topicId) {
        return entryInfoRelatedService.inquireEntryInfosByRelated2EntryByTopicId(topicId);
    }

    @ApiOperation("/rpc/entry/entryInfos/by/commentId")
    @GetMapping("/rpc/entry/entryInfos/by/{commentId}")
    public EntryInfo[] rpcGetEntryInfosByCommentId(@PathVariable("commentId")Integer commentId) {
        return entryInfoRelatedService.inquireEntryInfosByRelated2EntryByCommentId(commentId);
    }

    @ApiOperation("/rpc/entry/entryInfos/by/commentIds")
    @PostMapping("/rpc/entry/entryInfos/by/commentIds")
    public EntryInfo[][] rpcPostEntryInfosByCommentIds(Integer[] commentIds) {
        int length = commentIds.length;
        EntryInfo[][] entryInfoss = new EntryInfo[length][];
        for (int i = 0;i<length;++i) {
            EntryInfo[] entryInfos = entryInfoRelatedService.inquireEntryInfosByRelated2EntryByCommentId(commentIds[i]);
            entryInfoss[i] = entryInfos;
        }
        return entryInfoss;
    }
}
