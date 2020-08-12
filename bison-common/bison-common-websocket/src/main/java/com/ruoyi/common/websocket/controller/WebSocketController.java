package com.ruoyi.common.websocket.controller;

import com.ruoyi.common.core.web.domain.CommonResult;
import com.ruoyi.common.websocket.server.ZydWebsocketServer;
import com.ruoyi.common.websocket.util.WebSocketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/7/8 1:24
 */
@RestController
public class WebSocketController {

    private static final Logger log = LoggerFactory.getLogger(WebSocketController.class);

    @Autowired
    private ZydWebsocketServer websocketServer;

    /**
     * 发送消息通知
     *
     * @return
     */
    //@RequiresPermissions("notice")
    @PostMapping("/notice")
    //@Log(title = "通过websocket向前台用户发送通知",businessType = BusinessType.OTHER)
    @ResponseBody
    public CommonResult notice(String msg) throws UnsupportedEncodingException {
        WebSocketUtil.sendNotificationMsg(msg, websocketServer.getOnlineUsers());
        return CommonResult.success("消息发送成功");
    }
}
