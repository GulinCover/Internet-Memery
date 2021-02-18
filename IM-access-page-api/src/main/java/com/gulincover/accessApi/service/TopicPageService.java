package com.gulincover.accessApi.service;

import com.gulincover.api.HttpStateCode;
import com.gulincover.api.entity.CommentInfo;
import com.gulincover.api.entity.EntryInfo;
import com.gulincover.api.entity.TopicInfo;
import com.gulincover.api.entity.UserInfo;
import com.gulincover.api.httpResp.topicPage.*;
import com.gulincover.accessApi.rpcService.RpcCommentService;
import com.gulincover.accessApi.rpcService.RpcOtherService;
import com.gulincover.accessApi.rpcService.RpcTopicService;
import com.gulincover.accessApi.rpcService.RpcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TopicPageService {
    @Autowired
    private RpcOtherService rpcOtherService;

    @Autowired
    private RpcCommentService rpcCommentService;

    @Autowired
    private RpcTopicService rpcTopicService;

    @Autowired
    private RpcUserService rpcUserService;

    public TopicResp topicPage(Long id) {
        TopicResp topicResp = new TopicResp();
        Integer exist = rpcTopicService.isExist(id);
        if (exist == -1) {
            topicResp.setCode(HttpStateCode.CUSTOMIZE_RESP_IS_EMPTY.toString());
            return topicResp;
        }
        TopicInfo topicInfo = rpcTopicService.inquireTopicInfo(id);
        if (topicInfo == null) {
            topicResp.setCode(HttpStateCode.CUSTOMIZE_RESP_IS_EMPTY.toString());
            return topicResp;
        }

        UserInfo userInfo = rpcUserService.inquireUserInfo(topicInfo.getUserId());
        if (userInfo == null) {
            topicResp.setCode(HttpStateCode.CUSTOMIZE_RESP_IS_EMPTY.toString());
            return topicResp;
        }

        List<EntryInfo> entryInfos = rpcOtherService.inquireEntryInfosByTopicId(id);
        List<TopicEntry> topicEntryList = new LinkedList<>();
        for (EntryInfo entry: entryInfos) {
            TopicEntry topicEntry = new TopicEntry();
            topicEntry.setEntryId(entry.getId());
            topicEntry.setContent(entry.getContent());
            topicEntryList.add(topicEntry);
        }

        topicResp.setTopicEntryList(topicEntryList);
        System.out.println(topicEntryList);

        topicResp.setTopicId(topicInfo.getId());
        topicResp.setContent(topicInfo.getContent());
        topicResp.setTitle(topicInfo.getTopicName());
        topicResp.setLastUpdate(topicInfo.getUpdateDate());
        topicResp.setPublicTime(topicInfo.getCreateDate());

        topicResp.setLikeNumber(topicInfo.getLikeNumber());
        topicResp.setBrowseNumber(topicInfo.getBrowseNumber());
        topicResp.setCommentNumber(topicInfo.getCommentNumber());
        topicResp.setFavoritesNumber(topicInfo.getFavoritesNumber());

        topicResp.setUserId(userInfo.getId());
        topicResp.setUserNickname(userInfo.getName());
        topicResp.setAvatar(userInfo.getAvatar());
        topicResp.setLevel(userInfo.getUserLevel());
        topicResp.setSex(userInfo.getSex());

        topicResp.setCode(HttpStateCode.OK.toString());

        return topicResp;
    }

    public Comment1sResp topicPageForComment1(Long topicId) {
        Comment1sResp comment1sResp = new Comment1sResp();
        comment1sResp.setCode(HttpStateCode.OK.toString());
        List<CommentInfo> commentInfos = rpcCommentService.inquireComment1sByTopicId(topicId);
        if (commentInfos == null) {
            return comment1sResp;
        }

        List<CommentResp> commentResps = new LinkedList<>();
        for (CommentInfo commentInfo:commentInfos) {

            CommentResp commentResp = new CommentResp();
            commentResp.setCommentId(commentInfo.getId());
            commentResp.setContent(commentInfo.getCommentContent());
            commentResp.setTopicId(topicId);
            commentResp.setOpinion(commentInfo.getOpinion());
            commentResp.setPublicTime(commentInfo.getUpdateDate());

            UserInfo userInfo = rpcUserService.inquireUserInfo(commentInfo.getUserId());
            if (userInfo != null) {
                commentResp.setUserId(userInfo.getId());
                commentResp.setUserNickname(userInfo.getName());
                commentResp.setSex(userInfo.getSex());
                commentResp.setLevel(userInfo.getUserLevel());
            }

            List<EntryInfo> entryInfos = rpcOtherService.inquireEntryInfosByComment1Id(commentInfo.getId());
            if (entryInfos != null) {
                List<CommentEntry> commentEntryList = new LinkedList<>();
                for (EntryInfo entryInfo:entryInfos) {
                    CommentEntry commentEntry = new CommentEntry();
                    commentEntry.setCommentId(entryInfo.getId());
                    commentEntry.setContent(entryInfo.getContent());
                    commentEntryList.add(commentEntry);
                }

                commentResp.setCommentEntryList(commentEntryList);
            }

            commentResps.add(commentResp);
        }
        comment1sResp.setCommentRespList(commentResps);
        return comment1sResp;
    }

    public Comment2sResp topicPageForComment2(Long commentId) {
        Comment2sResp comment2sResp = new Comment2sResp();
        comment2sResp.setCode(HttpStateCode.OK.toString());
        List<CommentInfo> commentInfos = rpcCommentService.inquireComment2sByTopicId(commentId);
        if (commentInfos == null) {
            return comment2sResp;
        }

        List<Comment2Resp> comment2Resps = new LinkedList<>();
        for (CommentInfo commentInfo:commentInfos) {
            Comment2Resp comment2Resp = new Comment2Resp();
            comment2Resp.setCommentId(commentInfo.getId());
            comment2Resp.setContent(commentInfo.getCommentContent());
            comment2Resp.setTopicId(commentInfo.getTopicId());
            comment2Resp.setPublicTime(commentInfo.getUpdateDate());

            UserInfo userInfo = rpcUserService.inquireUserInfo(commentInfo.getUserId());
            if (userInfo != null) {
                comment2Resp.setUserId(userInfo.getId());
                comment2Resp.setUserNickname(userInfo.getName());
                comment2Resp.setSex(userInfo.getSex());
                comment2Resp.setLevel(userInfo.getUserLevel());
            }

            comment2Resps.add(comment2Resp);
        }
        comment2sResp.setCommentRespList(comment2Resps);
        return comment2sResp;
    }

}














