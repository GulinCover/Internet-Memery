//package com.gulincover.home.controller.commentRelated;
//
//import com.gulincover.api.entity.CommentInfo;
//import com.gulincover.api.entity.EntryInfo;
//import com.gulincover.api.entity.UserInfo;
//import com.gulincover.api.httpResp.topicPage.TopicPageCommentContentResp;
//import com.gulincover.home.controller.otherRelated.InquireEntryInfoApi;
//import com.gulincover.home.controller.userRelated.InquireUserInfoApi;
//import com.gulincover.home.service.commentRelated.CommentInfoRelatedService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@Api("InquireEntryInfoApi")
//@RestController
//public class InquireCommentInfoApi {
//    @Autowired
//    private CommentInfoRelatedService commentInfoRelatedService;
//
//    @ApiOperation("topic page comment1 content api")
//    @GetMapping("/api/topic/page/{topicId}/comment1")
//    public TopicPageCommentContentResp[] inquireTopicPageComment1ContentViewApi(
//            @PathVariable("topicId")Integer topicId
//    ) {
//        CommentInfo[] commentInfos = commentInfoRelatedService.inquireCommentInfo1sByCommentInfoByTopicId(topicId);
//        int length = commentInfos.length;
//        TopicPageCommentContentResp[] topicPageCommentContentResps = new TopicPageCommentContentResp[length];
//        Integer[] userIds = new Integer[length];
//        Integer[] commentIds = new Integer[length];
//        for (int i = 0;i<length;++i) {
//            userIds[i] = commentInfos[i].userId;
//            commentIds[i] = commentInfos[i].commentId;
//        }
//
//        UserInfo[] userInfos = rpcGetUserInfosByUserIds(userIds);
//        EntryInfo[][] entryInfos = rpcGetEntryInfosByCommentId(commentIds);
//
//        for (int i = 0;i<length;++i) {
//            topicPageCommentContentResps[i].userId = userInfos[i].userId;
//            topicPageCommentContentResps[i].name = userInfos[i].name;
//            topicPageCommentContentResps[i].avatar = userInfos[i].avatar;
//            topicPageCommentContentResps[i].Content = commentInfos[i].commentContent;
//            topicPageCommentContentResps[i].createDate = commentInfos[i].createDate;
//            topicPageCommentContentResps[i].commentNumber = commentInfos[i].lastCommentNumber;
//            topicPageCommentContentResps[i].likeNumber = commentInfos[i].likeNumber;
//            topicPageCommentContentResps[i].entryInfos = entryInfos[i];
//        }
//        return topicPageCommentContentResps;
//    }
//
//    @ApiOperation("topic page comment2 content api")
//    @GetMapping("/api/topic/page/{topicId}/comment2/{commentId}")
//    public TopicPageCommentContentResp[] inquireTopicPageComment2ContentViewApi(
//            @PathVariable("topicId")Integer topicId,
//            @PathVariable("commentId")Integer commentId
//    ) {
//        CommentInfo[] commentInfo2s = commentInfoRelatedService.inquireCommentInfo2sByCommentInfoByCommentId(commentId);
//        int length = commentInfo2s.length;
//        TopicPageCommentContentResp[] topicPageCommentContentResps = new TopicPageCommentContentResp[length];
//
//        Integer[] userIds = new Integer[length];
//        for (int i = 0;i<length;++i) {
//            userIds[i] = commentInfo2s[i].userId;
//        }
//        UserInfo[] userInfos = rpcGetUserInfosByUserIds(userIds);
//
//        for (int i = 0;i<length;++i) {
//            topicPageCommentContentResps[i].userId = userInfos[i].userId;
//            topicPageCommentContentResps[i].name = userInfos[i].name;
//            topicPageCommentContentResps[i].avatar = userInfos[i].avatar;
//            topicPageCommentContentResps[i].Content = commentInfo2s[i].commentContent;
//            topicPageCommentContentResps[i].createDate = commentInfo2s[i].createDate;
//            topicPageCommentContentResps[i].commentNumber = commentInfo2s[i].lastCommentNumber;
//            topicPageCommentContentResps[i].likeNumber = commentInfo2s[i].likeNumber;
//            topicPageCommentContentResps[i].entryInfos = null;
//        }
//
//        return topicPageCommentContentResps;
//    }
//
//    /*
//    rpc
//     */
//    @Autowired
//    private InquireUserInfoApi inquireUserInfoApi;
//    public UserInfo[] rpcGetUserInfosByUserIds(Integer[] userIds) {
//        return inquireUserInfoApi.rpcGetUserInfosByUserIds(userIds);
//    }
//
//    @Autowired
//    private InquireEntryInfoApi inquireEntryInfoApi;
//    public EntryInfo[][] rpcGetEntryInfosByCommentId(Integer[] commentIds) {
//        return inquireEntryInfoApi.rpcGetEntryInfosByCommentIds(commentIds);
//    }
//}
