package com.gulincover.accessApi.controller;

import com.gulincover.accessApi.service.UserManagerPageService;
import com.gulincover.api.HttpStateCode;
import com.gulincover.api.httpResp.topBarResp.InfoNotificationResp;
import com.gulincover.api.httpResp.userManagerPage.CoinInfoResp;
import com.gulincover.api.httpResp.userManagerPage.UploadUserAvatarResp;
import com.gulincover.api.httpResp.userManagerPage.UserLoginInfo;
import com.gulincover.api.httpResp.userManagerPage.UserLoginInfoResp;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//用户管理页
@Api("UserManagerPageController")
@RestController
public class UserManagerPageController {
    @Autowired
    private UserManagerPageService userManagerPageService;
    //图片上传
    /*
    需要提供:user_id,user_uuid,图片
    返回:图片url
     */
    public UploadUserAvatarResp postUpdateUploadUserAvatarApi(@RequestHeader("userId") Long userId, HttpServletRequest request) {
        UploadUserAvatarResp resp = new UploadUserAvatarResp();
        MultipartFile user_avatar = ((MultipartHttpServletRequest)request).getFile("");
        String url = userManagerPageService.postUpdateUploadUserAvatar(user_avatar);
        if (Objects.isNull(url) || url.isEmpty()) {
            resp.setCode(HttpStateCode.CUSTOMIZE_FILE_UPLOAD_FAILURE.toString());
            return resp;
        }
        resp.setAvatarUrl(url);
        resp.setCode(HttpStateCode.OK.toString());
        return resp;
    }

    //#常规设置
    //更改头项
    /*
    需要提供:user_id,user_uuid,user_avatar
     */

    //更改普通信息
    /*
    需要提供:user_id,user_uuid,及需要的信息
     */

    //#账户安全
    //更改密码
    //更改Email
    //更改Phone
    /*
    需要提供:user_id,user_uuid,及需要的信息
     */

    //查看登陆信息
    /*
    需要提供:user_id,user_uuid
    返回:登陆IP,login_mark,login_mode
     */
    public UserLoginInfoResp postSelectUserLoginInfoApi(@RequestHeader("userId") Long userId) {
        UserLoginInfoResp resp = new UserLoginInfoResp();

        List<UserLoginInfo> userLoginInfos = userManagerPageService.postSelectUserLoginInfo(userId);
        if (Objects.isNull(userLoginInfos) || userLoginInfos.isEmpty()) {
            resp.setCode(HttpStateCode.CUSTOMIZE_SELECT_FAILURE.toString());
            return resp;
        }

        resp.setUserLoginInfoList(userLoginInfos);
        resp.setCode(HttpStateCode.OK.toString());
        return resp;
    }

    //剔除某个登陆
    /*
    需要提供:user_id,user_uuid,登陆IP,login_mark,login_mode
     */
    public String postDeleteSingleUserLoginInfoApi(@RequestHeader("userId") Long userId, @RequestBody Map<String, String> form) {
        if (userManagerPageService.postDeleteSingleUserLoginInfo(userId, form) != 200)
            return HttpStateCode.CUSTOMIZE_OPERATION_FAILURE.toString();

        return HttpStateCode.OK.toString();
    }

    //#账单设置
    //获取钱包信息
    /*
    需要提供:user_id,user_uuid
    返回:剩余coin数量
     */
    public CoinInfoResp postSelectUserCoinNumberApi(@RequestHeader("userId") Long userId) {
        CoinInfoResp resp = new CoinInfoResp();

        Long coins = userManagerPageService.postSelectUserCoinNumber(userId);
        resp.setCoinSum(coins);
        resp.setCode(HttpStateCode.OK.toString());
        return resp;
    }

    //获取购买信息
    /*
    需要提供:user_id,user_uuid
    返回:购买nick账单s,购买topic账单s
    购买nick账单s:bill_id,售卖者信息,账单成交价格,账单成交时间,nickname
    购买topic账单s:bill_id,售卖者信息,账单成交价格,账单成交时间,topic_id,topic_title,topic_desc
     */

    //获取已经售卖信息
    /*
    需要提供:user_id,user_uuid
    返回:售卖nick账单s,售卖topic账单s
    售卖nick账单s:bill_id,bill_buyer,账单成交价格,账单成交时间,nickname
    售卖topic账单s:bill_id,bill_buyer,账单成交价格,账单成交时间,topic_id,topic_title,topic_desc
     */

    //获取正在售卖信息
    /*
    需要提供:user_id,user_uuid
    返回:售卖nick账单s,售卖topic账单s
    售卖nick账单s:bill_id,当前最高价,历史价,售卖时间,剩余时间,nickname
    售卖topic账单s:bill_id,当前最高价,历史价,售卖时间,剩余时间,topic_id,topic_title,topic_desc
     */

    //#通知信息
    //获取关注人最新发布信息
    /*
    
     */

    //获取最新回复信息
    /*

     */

    //#官方认证

    //#黑名单
    //查看黑名单
    /*
    需要提供:user_id,user_uuid
    返回:black_users
    black_users:user_uuid,username,user_level,user_sex,user_avatar
     */

    //#仓库
    //获取消耗品信息
    /*
    需要提供:user_id,user_uuid
    返回:昵称消耗品s,著述消耗品s
    昵称消耗品s:nickname,消耗品_id,消耗品_type
    著述消耗品s:topic_id,消耗品_id,topic_title,topic_desc,消耗品_type
     */

    //使用昵称消耗品
    /*
    需要提供:user_id,user_uuid,消耗品_id,nickname,消耗品_type
     */

    //使用著述消耗品
    /*
    需要提供:user_id,user_uuid,消耗品_id,topic_id,消耗品_type
     */


}












