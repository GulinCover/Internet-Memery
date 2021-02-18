package com.gulincover.accessApi.service;

import com.gulincover.accessApi.common.UtilsTools;
import com.gulincover.accessApi.rpcService.RpcOtherService;
import com.gulincover.accessApi.rpcService.RpcTopicService;
import com.gulincover.accessApi.rpcService.RpcUserService;
import com.gulincover.api.entity.BillInfo;
import com.gulincover.api.entity.ConsumablesInfo;
import com.gulincover.api.entity.TopicInfo;
import com.gulincover.api.entity.UserInfo;
import com.gulincover.api.httpResp.auctionPage.Bill;
import com.gulincover.utils.tools.CovertToTools;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuctionPageService {
    @Autowired
    private RpcTopicService rpcTopicService;
    @Autowired
    private RpcOtherService rpcOtherService;
    @Autowired
    private RpcUserService rpcUserService;

    //获取总成交额
    public String getSumTurnover() {
        return rpcOtherService.getSumTurnover();
    }

    //获取用户信息
    public UserInfo postSelectUserInfo(Long userId) {
        return rpcUserService.inquireUserInfo(userId);
    }

    //拍卖昵称
    /*
    user_id
    consumable_id
    consumable_type
    price
     */
    public Integer postAuctionNickname(Map<String, String> map) {
        final String price = map.get("price");
        if (!CovertToTools.isDigital(price) || CovertToTools.covertToLong(price) < 50)
            return -1;

        Integer integer = rpcOtherService.postNicknameConsumableIsCorrect(map);
        if (integer != 200) return -1;
        final Long consumableId = CovertToTools.covertToLong(map.get("consumable_id"));
        final ConsumablesInfo consumablesInfo = rpcOtherService.postSelectConsumablesInfo(consumableId);
        if (consumablesInfo == null) return -1;

        Map<String, String> form = new HashMap<>();
        form.put("seller_id", map.get("user_id"));
        form.put("content_id", consumableId.toString());
        form.put("type", "nickname");
        form.put("seller_uuid", consumablesInfo.getUserUuid());
        form.put("price", price);
        form.put("content", consumablesInfo.getNickname());
        return rpcOtherService.postAuctionNicknameToBill(form);
    }

    //拍卖著述
    /*
    user_id
    topic_id
    price
     */
    public Integer postAuctionTopic(Map<String, String> map) {
        final String price = map.get("price");
        if (!CovertToTools.isDigital(price) || CovertToTools.covertToLong(price) < 200)
            return -1;

        Integer integer = rpcTopicService.postIsTopicSettlement(map);
        if (integer != 200) return -1;
        final Long topicId = CovertToTools.covertToLong(map.get("topic_id"));
        final TopicInfo topicInfo = rpcTopicService.inquireTopicInfo(topicId);
        if (topicInfo == null) return -1;

        Map<String, String> form = new HashMap<>();
        form.put("seller_id", map.get("user_id"));
        form.put("seller_uuid", topicInfo.getUserUuid());
        form.put("content_id", topicId.toString());
        form.put("type", "topic");
        form.put("price", price);
        form.put("content", topicInfo.getTopicName());
        return rpcOtherService.postAuctionTopicToBill(form);
    }

    //著述结算
    public Integer postSettlementTopic(Map<String, String> map) {
        return rpcTopicService.postSettlementTopic(map);
    }

    //竞拍昵称
    public Integer postBiddingNickname(Map<String, String> map) {
        String bill_id = map.get("bill_id");
        String price = map.get("price");
        if (!CovertToTools.isDigital(bill_id) || !CovertToTools.isDigital(price))
            return -1;

        Long billId = CovertToTools.covertToLong(bill_id);
        BillInfo billInfo = rpcOtherService.postSelectBill(billId);
        if (!"nickname".equals(billInfo.getType())) return -1;

        Long maxPrice = billInfo.getPrice();
        if (maxPrice >= CovertToTools.covertToLong(price)) return -1;

        Map<String, String> form = new HashMap<>();
        form.put("buyer_id", map.get("buyer_id"));
        form.put("price", map.get("price"));
        form.put("id", map.get("id"));
        return rpcOtherService.postUpdateMaxPrice(form);
    }

    //竞拍昵称
    /*
    user_id
    bill_id
    buyer_id
    price
     */
    public Integer postBiddingTopic(Map<String, String> map) {
        String bill_id = map.get("bill_id");
        String price = map.get("price");
        if (!CovertToTools.isDigital(bill_id) || !CovertToTools.isDigital(price))
            return -1;

        Long billId = CovertToTools.covertToLong(bill_id);
        BillInfo billInfo = rpcOtherService.postSelectBill(billId);
        if (!"topic".equals(billInfo.getType())) return -1;

        Long maxPrice = billInfo.getPrice();
        if (maxPrice >= CovertToTools.covertToLong(price)) return -1;

        Map<String, String> form = new HashMap<>();
        form.put("buyer_id", map.get("buyer_id"));
        form.put("price", map.get("price"));
        form.put("user_id", map.get("user_id"));
        return rpcOtherService.postUpdateMaxPrice(form);
    }

    //使用昵称消耗品
    /*
    user_id
    nickname
    consumable_type
    consumable_id
     */
    public Integer postUseNicknameConsumables(Map<String, String> map) {
        String consumable_type = map.get("consumable_type");
        if (!"nickname".equals(consumable_type)) return -1;
        if (!CovertToTools.isDigital(map.get("consumable_id"))) return -1;

        Long consumable_id = CovertToTools.covertToLong(map.get("consumable_id"));
        ConsumablesInfo consumablesInfo = rpcOtherService.postConsumableEffect(consumable_id);


        Map<String, String> form = new HashMap<>();
        form.put("new_name", consumablesInfo.getNickname());
        form.put("user_id", map.get("user_id"));
        Integer integer = rpcUserService.postUseNicknameConsumables(form);
        if (integer != 200) return -1;

        Integer ret = rpcOtherService.postDeleteConsumable(consumable_id);
        if (ret != 200) return -1;
        return 200;
    }

    //使用著述消耗品
    public Integer postUseTopicConsumables(Map<String, String> map) {
        String consumable_type = map.get("consumable_type");
        if (!"topic".equals(consumable_type)) return -1;
        if (CovertToTools.isDigital(map.get("consumable_id"))) return -1;

        Long consumable_id = CovertToTools.covertToLong(map.get("consumable_id"));
        ConsumablesInfo consumablesInfo = rpcOtherService.postConsumableEffect(consumable_id);

        Map<String, String> form = new HashMap<>();
        form.put("topic_id", consumablesInfo.getTopicId().toString());
        form.put("user_id", map.get("user_id"));
        Integer integer = rpcUserService.postUseTopicConsumables(form);
        if (integer != 200) return -1;

        Integer ret = rpcOtherService.postDeleteConsumable(consumable_id);
        if (ret != 200) return -1;
        return 200;
    }

    //著述热榜前十
    public List<Bill> getAuctionTopicTopTen() {
        List<BillInfo> billTopTen = rpcOtherService.getTopicBillTopTen();
        if (billTopTen == null || billTopTen.isEmpty()) return null;

        List<Bill> billList = new LinkedList<>();
        for (BillInfo billInfo : billTopTen) {
            UserInfo buyer = rpcUserService.inquireUserInfo(billInfo.getBuyer());
            UserInfo seller = rpcUserService.inquireUserInfo(billInfo.getSeller());

            Bill bill = new Bill();
            bill.setBuyer(buyer.getName());
            bill.setBuyerId(buyer.getId());
            bill.setBuyerUUID(buyer.getUuid());

            bill.setSeller(seller.getName());
            bill.setSellerId(seller.getId());
            bill.setSellerUUID(seller.getUuid());

            bill.setId(billInfo.getId());
            bill.setContent(billInfo.getContent());
            bill.setType("topic");
            bill.setPrice(billInfo.getPrice().toString());
            billList.add(bill);
        }
        return billList;
    }

    //著述热榜
    public List<Bill> getAuctionTopicTop(Integer page) {
        List<BillInfo> billTopTen = rpcOtherService.getTopicBillTop(page);
        if (billTopTen == null || billTopTen.isEmpty()) return null;

        List<Bill> billList = new LinkedList<>();
        for (BillInfo billInfo : billTopTen) {
            UserInfo buyer = rpcUserService.inquireUserInfo(billInfo.getBuyer());
            UserInfo seller = rpcUserService.inquireUserInfo(billInfo.getSeller());

            Bill bill = new Bill();
            bill.setBuyer(buyer.getName());
            bill.setBuyerId(buyer.getId());
            bill.setBuyerUUID(buyer.getUuid());

            bill.setSeller(seller.getName());
            bill.setSellerId(seller.getId());
            bill.setSellerUUID(seller.getUuid());

            bill.setId(billInfo.getId());
            bill.setContent(billInfo.getContent());
            bill.setType("topic");
            bill.setPrice(billInfo.getPrice().toString());
            billList.add(bill);
        }
        return billList;
    }

    //昵称热榜前十
    public List<Bill> getAuctionNicknameTopTen() {
        List<BillInfo> billTopTen = rpcOtherService.getNicknameBillTopTen();
        if (billTopTen == null || billTopTen.isEmpty()) return null;

        List<Bill> billList = new LinkedList<>();
        for (BillInfo billInfo : billTopTen) {
            UserInfo buyer = rpcUserService.inquireUserInfo(billInfo.getBuyer());
            UserInfo seller = rpcUserService.inquireUserInfo(billInfo.getSeller());

            Bill bill = new Bill();
            bill.setBuyer(buyer.getName());
            bill.setBuyerId(buyer.getId());
            bill.setBuyerUUID(buyer.getUuid());

            bill.setSeller(seller.getName());
            bill.setSellerId(seller.getId());
            bill.setSellerUUID(seller.getUuid());

            bill.setId(billInfo.getId());
            bill.setContent(billInfo.getContent());
            bill.setType("nickname");
            bill.setPrice(billInfo.getPrice().toString());
            billList.add(bill);
        }
        return billList;
    }

    //昵称热榜
    public List<Bill> getAuctionNicknameTop(Integer page) {
        List<BillInfo> billTopTen = rpcOtherService.getNicknameBillTop(page);
        if (billTopTen == null || billTopTen.isEmpty()) return null;

        List<Bill> billList = new LinkedList<>();
        for (BillInfo billInfo : billTopTen) {
            UserInfo buyer = rpcUserService.inquireUserInfo(billInfo.getBuyer());
            UserInfo seller = rpcUserService.inquireUserInfo(billInfo.getSeller());

            Bill bill = new Bill();
            bill.setBuyer(buyer.getName());
            bill.setBuyerId(buyer.getId());
            bill.setBuyerUUID(buyer.getUuid());

            bill.setSeller(seller.getName());
            bill.setSellerId(seller.getId());
            bill.setSellerUUID(seller.getUuid());

            bill.setId(billInfo.getId());
            bill.setContent(billInfo.getContent());
            bill.setType("topic");
            bill.setPrice(billInfo.getPrice().toString());
            billList.add(bill);
        }
        return billList;
    }
}











