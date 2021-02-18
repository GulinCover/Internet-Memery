package com.gulincover.accessApi.rpcService;

import com.gulincover.api.entity.CommentInfo;
import com.gulincover.accessApi.rpcFallbackService.RpcCommentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "service-comment",
        fallbackFactory = RpcCommentFallbackService.class
)
public interface RpcCommentService {
    @GetMapping("/rpc/topic/page/for/comment1s/by/{topicId}")
    List<CommentInfo> inquireComment1sByTopicId(@PathVariable("topicId") Long topicId);

    @GetMapping("/rpc/topic/page/for/comment2s/by/{commentId}")
    List<CommentInfo> inquireComment2sByTopicId(@PathVariable("commentId") Long commentId);
}
