package com.gulincover.accessApi.rpcFallbackService;

import com.gulincover.api.entity.BillInfo;
import com.gulincover.api.entity.BrowseInfo;
import com.gulincover.api.entity.ConsumablesInfo;
import com.gulincover.api.entity.EntryInfo;
import com.gulincover.accessApi.rpcService.RpcOtherService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RpcOtherFallbackService implements FallbackFactory<RpcOtherService> {
    @Override
    public RpcOtherService create(Throwable cause) {
        return null;
//        return new RpcOtherService() {
//            @Override
//            public List<EntryInfo> inquireEntryInfosByTopicId(Long topicId) {
//                return null;
//            }
//
//            @Override
//            public List<EntryInfo> inquireEntryInfosByComment1Id(Long comment1Id) {
//                return null;
//            }
//
//            @Override
//            public Integer postInsertSuggestions(Map<String, String> map) {
//                return null;
//            }
//
//            @Override
//            public List<BrowseInfo> postSelectBrowseHistory(Long userId, Integer startPage) {
//                return null;
//            }
//
//            @Override
//            public List<EntryInfo> getEntryByIds(List<Long> ids) {
//                return null;
//            }
//
//            @Override
//            public String getPolicy() {
//                return null;
//            }
//
//            @Override
//            public List<BillInfo> getTopicBillTopTen() {
//                return null;
//            }
//
//            @Override
//            public List<BillInfo> getTopicBillTop(Integer page) {
//                return null;
//            }
//
//            @Override
//            public List<BillInfo> getNicknameBillTopTen() {
//                return null;
//            }
//
//            @Override
//            public List<BillInfo> getNicknameBillTop(Integer page) {
//                return null;
//            }
//
//            @Override
//            public Integer postBiddingNickname(Map<String, String> map) {
//                return null;
//            }
//
//            @Override
//            public Integer postBiddingTopic(Map<String, String> map) {
//                return null;
//            }
//
//            @Override
//            public Integer postAuctionTopicToBill(Map<String, String> map) {
//                return null;
//            }
//
//            @Override
//            public Integer postAuctionNicknameToBill(Map<String, String> map) {
//                return null;
//            }
//
//            @Override
//            public ConsumablesInfo postConsumableEffect(Long id) {
//                return null;
//            }
//
//            @Override
//            public Integer postDeleteConsumable(Long id) {
//                return null;
//            }
//
//            @Override
//            public BillInfo postSelectBill(Long id) {
//                return null;
//            }
//
//            @Override
//            public Integer postUpdateMaxPrice(Map<String, String> map) {
//                return null;
//            }
//        };
    }
}
