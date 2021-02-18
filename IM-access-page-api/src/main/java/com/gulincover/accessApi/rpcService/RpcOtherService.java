package com.gulincover.accessApi.rpcService;

import com.gulincover.accessApi.rpcFallbackService.RpcOtherFallbackService;
import com.gulincover.api.entity.BillInfo;
import com.gulincover.api.entity.BrowseInfo;
import com.gulincover.api.entity.ConsumablesInfo;
import com.gulincover.api.entity.EntryInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(
        value = "service-other",
        fallbackFactory = RpcOtherFallbackService.class
)
public interface RpcOtherService {
    /*
    topic page
     */
    @GetMapping("/rpc/topic/page/entryInfo/for/entryInfos/by/{id}")
    List<EntryInfo> inquireEntryInfosByTopicId(@PathVariable("id")Long topicId);

    @GetMapping("/rpc/topic/page/entryInfo/for/entryInfos/by/{comment1Id}")
    List<EntryInfo> inquireEntryInfosByComment1Id(@PathVariable("comment1Id")Long comment1Id);

    /*
    user page
     */
    @PostMapping(value = "/rpc/post/userPage/suggestions",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postInsertSuggestions(@RequestBody Map<String, String> map);

    @PostMapping(value = "/rpc/post/userPage/browseHistory",produces = MediaType.APPLICATION_JSON_VALUE)
    List<BrowseInfo> postSelectBrowseHistory(@RequestBody Map<String, String> map);

    @PostMapping(value = "/rpc/post/userPage/browseHistoryEntry")
    List<EntryInfo> getEntryByIds(List<Long> ids);

    @GetMapping(value = "/rpc/get/userPage/policy")
    String getPolicy();

    /*
    auction page
     */
    @GetMapping(value = "/rpc/get/auction/topic/topTen")
    List<BillInfo> getTopicBillTopTen();
    @GetMapping(value = "/rpc/get/auction/topic/top/{page}")
    List<BillInfo> getTopicBillTop(@PathVariable("page") Integer page);
    @GetMapping(value = "/rpc/get/auction/nickname/topTen")
    List<BillInfo> getNicknameBillTopTen();
    @GetMapping(value = "/rpc/get/auction/nickname/top/{page}")
    List<BillInfo> getNicknameBillTop(@PathVariable("page") Integer page);
    //竞拍昵称
    @PostMapping(value = "/rpc/post/bidding/nickname",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postBiddingNickname(Map<String, String> map);
    //竞拍著述
    @PostMapping(value = "/rpc/post/bidding/topic",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postBiddingTopic(Map<String, String> map);
    //著述上架,生成账单
    @PostMapping(value = "/rpc/post/auction/topic",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postAuctionTopicToBill(Map<String, String> map);
    //昵称上架,生成账单
    @PostMapping(value = "/rpc/post/auction/nickname",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postAuctionNicknameToBill(Map<String, String> map);
    //严重信息正确性
    @PostMapping(value = "/rpc/post/auction/nickname",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postNicknameConsumableIsCorrect(Map<String, String> map);
    //获取消耗品信息
    @PostMapping(value = "/rpc/post/auction/nickname",produces = MediaType.APPLICATION_JSON_VALUE)
    ConsumablesInfo postSelectConsumablesInfo(Long consumableId);

    //获取消耗品信息
    @PostMapping(value = "/rpc/post/bidding/topic",produces = MediaType.APPLICATION_JSON_VALUE)
    ConsumablesInfo postConsumableEffect(Long id);

    //逻辑删除已使用的消耗品
    @PostMapping(value = "/rpc/post/bidding/topic",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postDeleteConsumable(Long id);

    //获取账单信息
    @PostMapping(value = "/rpc/post/bidding/topic",produces = MediaType.APPLICATION_JSON_VALUE)
    BillInfo postSelectBill(Long id);

    //更新竞拍者和价格
    @PostMapping(value = "/rpc/post/bidding/topic",produces = MediaType.APPLICATION_JSON_VALUE)
    Integer postUpdateMaxPrice(Map<String, String> map);

    //获取总成交额
    @GetMapping(value = "")
    String getSumTurnover();
}












