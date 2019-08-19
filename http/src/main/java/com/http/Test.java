package com.http;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

public class Test {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            HttpRequest hutool_http = HttpRequest.get("http://jqzx.54heb.com/wechat/treeSelection/treeUnit/zanAdd?id=7700")
                    .header(Header.USER_AGENT, "Mozilla/5.0 (Linux; U; Android 8.1.0; zh-cn; BLA-AL00 Build/HUAWEIBLA-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/8.9 Mobile Safari/537.36");

            String body = hutool_http.execute().body();

            System.out.println(body);
        }




    }
}
