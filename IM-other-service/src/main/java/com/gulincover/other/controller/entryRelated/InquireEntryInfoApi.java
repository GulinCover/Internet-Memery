package com.gulincover.other.controller.entryRelated;

import com.gulincover.api.entity.EntryInfo;
import com.gulincover.api.httpResp.JsonReq.EntryInfosByCommentIdsAbs;
import com.gulincover.other.service.EntryInfoRelatedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Api("InquireEntryInfoApi")
@RestController
public class InquireEntryInfoApi {
    @Autowired
    private EntryInfoRelatedService entryInfoRelatedService;

    @GetMapping("/api/entryInfo/for/entryInfos/by/{id}")
    public List<EntryInfo> inquireEntryInfoByTopicId(@PathVariable("id")Long topicId) {
        return entryInfoRelatedService.inquireEntryInfoByTopicId(topicId);
    }




    @ApiOperation("/rpc/entry/entryInfos/by/topicId")
    @GetMapping("/rpc/entry/entryInfos/by/topic/{topicId}")
    public EntryInfo[] rpcGetEntryInfosByTopicId(@PathVariable("topicId")Integer topicId) {
//        return entryInfoRelatedService.inquireEntryInfosByRelated2EntryByTopicId(topicId);
        EntryInfo[] entryInfos = new EntryInfo[20];
        for (int i = 0;i < 20 ; ++i) {
//            EntryInfo entryInfo = new EntryInfo();
//            entryInfo.entryId = topicId + i;
//            entryInfo.content = "this is a entry by "+entryInfo.entryId;
//            entryInfo.likeNumber = 20+i;
//            entryInfos[i] = entryInfo;
        }
        return entryInfos;
    }

//    @ApiOperation("/rpc/entry/entryInfos/by/commentId")
//    @GetMapping("/rpc/entry/entryInfos/by/comment/{commentId}")
//    public EntryInfo[] rpcGetEntryInfosByCommentId(@PathVariable("commentId")Integer commentId) {
//        return entryInfoRelatedService.inquireEntryInfosByRelated2EntryByCommentId(commentId);
//    }

    @ApiOperation("/rpc/post/entryInfos/by/commentIds")
    @PostMapping("/rpc/post/entryInfos/by/commentIds")
    public List<List<EntryInfo>> rpcPostEntryInfosByCommentIds(EntryInfosByCommentIdsAbs commentIds) {
        List<List<EntryInfo>> entryInfoss = new LinkedList<>();
        List<EntryInfo> entryInfos = new LinkedList<>();
//        for (int i = 0;i<length;++i) {
//            EntryInfo[] entryInfos = entryInfoRelatedService.inquireEntryInfosByRelated2EntryByCommentId(commentIds[i]);
//            entryInfoss[i] = entryInfos;
//        }
        System.out.println("---------------------");
        EntryInfo entryInfo = new EntryInfo();
        entryInfo.setId(1L);
        entryInfo.setContent("this is a entry");
        entryInfos.add(entryInfo);
        entryInfoss.add(entryInfos);
        return entryInfoss;
    }
}






