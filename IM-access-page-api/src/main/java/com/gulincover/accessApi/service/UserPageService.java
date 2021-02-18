package com.gulincover.accessApi.service;

import com.gulincover.accessApi.rpcService.RpcOtherService;
import com.gulincover.accessApi.rpcService.RpcTopicService;
import com.gulincover.accessApi.rpcService.RpcUserService;
import com.gulincover.api.entity.BrowseInfo;
import com.gulincover.api.entity.EntryInfo;
import com.gulincover.api.entity.TopicInfo;
import com.gulincover.api.entity.UserInfo;
import com.gulincover.api.httpResp.userPage.BrowseHistoryEntry;
import com.gulincover.api.httpResp.userPage.BrowseHistoryResp;
import com.gulincover.utils.tools.CovertToTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class UserPageService {
    @Autowired
    private RpcTopicService rpcTopicService;

    @Autowired
    private RpcUserService rpcUserService;

    @Autowired
    private RpcOtherService rpcOtherService;

    //用户查询
    public Long findUserIdById(Long id) {
        return rpcUserService.getUserIdById(id);
    }

    //提交意见
    public boolean insertSuggestions(Long id, String content) {
        Map<String, String> map = new HashMap<>();
        map.put("userId", id.toString());
        map.put("content", content);
        Integer integer = rpcOtherService.postInsertSuggestions(map);
        return integer != null && integer == 200;
    }

    //用户信息完善
    public boolean updateUserInfo(Map<String, String> map) {
        Integer integer = rpcUserService.postPrefectUserInfo(map);
        return integer != null && integer == 200;
    }

    //历史记录
    public List<BrowseHistoryResp> selectBrowseHistory(String userId, String startPage) {
        HashMap<String, String> map = new HashMap<>();
        map.put("userId",userId);
        map.put("startPage",startPage);
        List<BrowseInfo> browseInfos = rpcOtherService.postSelectBrowseHistory(map);
        if (browseInfos == null || browseInfos.isEmpty()) return null;

        List<BrowseHistoryResp> browseHistoryList = new LinkedList<>();
        for (BrowseInfo browseInfo : browseInfos) {
            BrowseHistoryResp browseHistoryResp = new BrowseHistoryResp();
            Long topicId = browseInfo.getTopicId();
            TopicInfo topicInfo = rpcTopicService.inquireTopicInfo(topicId);
            if (topicInfo == null) continue;

            UserInfo userInfo = rpcUserService.inquireUserInfo(topicInfo.getUserId());
            if (userInfo == null) continue;

            String entryList = topicInfo.getEntryList();
            String[] split = entryList.split(";");

            List<EntryInfo> entryInfoList = rpcOtherService.getEntryByIds(CovertToTools.covertToIntegers(split));
            if (entryInfoList == null || entryInfoList.isEmpty()) continue;

            browseHistoryResp.setTopicId(topicId);
            browseHistoryResp.setTopicContent(topicInfo.getContent());
            browseHistoryResp.setTopicTitle(topicInfo.getTopicName());

            //装填BrowseEntry
            List<BrowseHistoryEntry> browseHistoryEntries = new LinkedList<>();
            for (EntryInfo entryInfo : entryInfoList) {
                BrowseHistoryEntry browseHistoryEntry = new BrowseHistoryEntry();
                browseHistoryEntry.setContent(entryInfo.getContent());
                browseHistoryEntries.add(browseHistoryEntry);
            }
            browseHistoryResp.setEntryList(browseHistoryEntries);

            browseHistoryResp.setUserAvatar(userInfo.getAvatar());
            browseHistoryResp.setUserName(userInfo.getName());
            browseHistoryResp.setUserId(topicInfo.getUserId());

            browseHistoryResp.setAccessTime(browseInfo.getUpdateDate());

        }

        return browseHistoryList;
    }
    //政策内容
    public String getPolicy() {
        return rpcOtherService.getPolicy();
    }
}
