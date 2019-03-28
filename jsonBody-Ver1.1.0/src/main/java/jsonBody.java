import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;


public class jsonBody{

    //获取json内的固定信息
    public static String getTime(){
        Date now = new Date();
        SimpleDateFormat getNow = new SimpleDateFormat("yyyyMMddHHmmss");
        String newTime = getNow.format(now);

        return newTime;
    }
    public static String getRandom(){
        return UUID.randomUUID().toString().substring(0,20);
    }
    //sign加密
    public static String getSign(String apiKey,String body,String transactionid,String now){
        String signBody = transactionid+now+apiKey+body;
        try {
            return MD5Util.md5Encode(signBody).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //获取json请求head信息
    public  static String getHead(String apiId,String channelCode,String sign,String transactionid,String now) {
        JSONObject head = new JSONObject();
        head.put("apiId",apiId);
        head.put("channelCode",channelCode);
        head.put("transactionId",transactionid);
        head.put("reqTime",now);
        head.put("sign",sign);
        head.put("version","1.0");
        String changHead = head.toString();
        return changHead;
    }

    //获取订单受理json请求产品信息
    public  static JSONArray getProdinfo(String prodName,String prodId,String phone,String quantity){
        JSONObject getProd = new JSONObject();
        getProd.put("serverNum",phone);
        getProd.put("prodName",prodName);
        getProd.put("prodId",prodId);
        getProd.put("quantity",quantity);
        JSONArray prodInfo = new JSONArray();
        prodInfo.put(0,getProd);
        return prodInfo;
    }
    //获取订单受理json 支付信息
    public static JSONObject getPayinfo(String returnUrl,String salesDesc,String merchantName,String payType,String payWay,String wxOpenid,String period,String periodUnit){
        JSONObject getPay = new JSONObject();
        getPay.put("returnUrl",returnUrl);
        getPay.put("salesDesc",salesDesc);
        getPay.put("merchantName",merchantName);
        getPay.put("payType",payType);
        getPay.put("payWay",payWay);
        getPay.put("wxOpenid",wxOpenid);
        getPay.put("period",period);
        getPay.put("periodUnit",periodUnit);
        return getPay;
    }
    //获取订单受理v1接口json请求body信息
    public  static String getOrderv1body(String amount,String phone,String isPay,String salesName,String salesId,JSONArray prodInfo,String dealType,String transactionid,String now){
        JSONObject body = new JSONObject();
        body.put("amount",amount);
        body.put("phone",phone);
        body.put("isPay",isPay);
        body.put("acceptTime",now);
        body.put("salesName",salesName);
        body.put("prodInfo",prodInfo);
        body.put("dealType",dealType);
        body.put("salesId",salesId);
        body.put("channelNo",transactionid);
        String changBody = body.toString().replace("\\","");
        return changBody;
    }
    //获取订单受理v1接口json请求body信息
    public  static String getOrderv2body(String amount,String phone,String isPay,JSONObject getPayinfo,String salesName,String salesId,JSONArray prodInfo,String dealType,String transactionid,String now){
        JSONObject body = new JSONObject();
        body.put("amount",amount);
        body.put("phone",phone);
        body.put("isPay",isPay);
        body.put("payInfo",getPayinfo);
        body.put("acceptTime",now);
        body.put("salesName",salesName);
        body.put("prodInfo",prodInfo);
        body.put("dealType",dealType);
        body.put("salesId",salesId);
        body.put("channelNo",transactionid);
        String changBody = body.toString().replace("\\","");
        return changBody;
    }
    //获取订单状态查询接口信息
    public static String getChannelno(String channelNo){
        JSONObject channel = new JSONObject();
        channel.put("channelNo",channelNo);
        String setChannelno = channel.toString();
        return setChannelno;
    }
    //获取同步产品信息json请求body信息
    public static String getSalesid(String salesId){
        JSONObject sales = new JSONObject();
        sales.put("saleId",salesId);
        String setSalesid = sales.toString();
        return setSalesid;
    }
    //获取同步渠道信息json请求body信息
    public static String getChannelcode(String channelCode){
        JSONObject channel = new JSONObject();
        channel.put("channelCode",channelCode);
        String setChannelcode = channel.toString();
        return setChannelcode;
    }
    //获取H5链接回调接口信息
    public static String getH5back(String channelcode,String saleId,String h5url,String H5activityId,String h5status){
        JSONObject H5urlback = new JSONObject();
        H5urlback.put("channelCode",channelcode);
        H5urlback.put("salesid",saleId);
        H5urlback.put("h5url",h5url);
        H5urlback.put("h5activityId",H5activityId);
        H5urlback.put("h5status",h5status);
        String setH5urlback = H5urlback.toString();
        return setH5urlback;
    }
    //获取同步权益方信息list信息
    public static JSONArray getRightslist(String apId,String apCode,String apName,String uId){
        JSONObject rightsLights = new JSONObject();
        rightsLights.put("apId",apId);
        rightsLights.put("apCode",apCode);
        rightsLights.put("apName",apName);
        rightsLights.put("uId",uId);
        JSONArray setRightslist = new JSONArray();
        setRightslist.put(0,rightsLights);
        return setRightslist;
    }
   //获取同步权益方请求body信息
    public static String getRights(JSONArray rightsList){
        JSONObject rights = new JSONObject();
        rights.put("list",rightsList);
        String setRights = rights.toString().replace("\\","");
        return setRights;
    }
}

