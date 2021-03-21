package net.xiaoyu233.mitemod.huya.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParamsUtil {
    /**
     * 生成开放API Websocket连接参数
     * @param appId  开发者ID（https://ext.huya.com成为开发者后自动生成）
     * @param secret 开发者密钥（https://ext.huya.com成为开发者后自动生成）
     * @param roomId 要监听主播的房间号
     */
    public static Map<String, Object> getWebSocketJwtParamsMap(String appId, String secret, long roomId){
        //获取时间戳（毫秒）
        long currentTimeMillis = System.currentTimeMillis();
        long expireTimeMillis = System.currentTimeMillis() +  10 * 1000;  //超时时间:通常设置10分钟有效，即exp=iat+600，注意不少于当前时间且不超过当前时间60分钟
        Date iat = new Date(currentTimeMillis);
        Date exp = new Date(expireTimeMillis);

        try {

            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            header.put("typ", "JWT");

            //生成JWT凭证
            Algorithm algorithm = Algorithm.HMAC256(secret);   //开发者密钥
            String sToken = JWT.create()
                    .withHeader(header)                    //JWT声明
                    .withIssuedAt(iat)                     //jwt凭证生成时间
                    .withExpiresAt(exp)                    //jwt凭证超时时间
                    .withClaim("appId", appId)             //开发者ID
                    .sign(algorithm);


            Map<String, Object> authMap = new HashMap<>();
            authMap.put("iat", currentTimeMillis / 1000);    //jwt凭证生成时间戳（秒）
            authMap.put("exp", expireTimeMillis / 1000);     //jwt凭证超时时间戳（秒）
            authMap.put("sToken", sToken);                   //jwt签名串
            authMap.put("appId",appId);                      //开发者ID
            authMap.put("do", "comm");                       //接口默认参数
            authMap.put("roomId", roomId);                   //需要监听主播的房间号

            return authMap;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String MapToUrlString(Map<String,Object> paramsMap,boolean hasQuerySymbol){
        if (null == paramsMap)
            return null;
        StringBuilder preStr = new StringBuilder(hasQuerySymbol ? "?" : "");
        for (Map.Entry<String,Object> entry:paramsMap.entrySet()){
            try {
                preStr.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(), "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return preStr.substring(0,preStr.length() - 1);
    }
}
