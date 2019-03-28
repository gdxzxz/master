import org.json.JSONArray;
import org.json.JSONObject;

public class main extends jsonBody{
   //
    public static void main(String[] args){


        String transactionId = jsonBody.getRandom();
        String nowTime = jsonBody.getTime();
        JSONArray rightsList = jsonBody.getRightslist("111","111","abccc","123");
        JSONArray prodInfo = jsonBody.getProdinfo("ccc","123","123","1");
        JSONObject payInfo = jsonBody.getPayinfo("null","null","null","1","WAP",null,null,null);
        String body1 = jsonBody.getOrderv1body("0","13913913901","0","cccc","123",prodInfo,"0",transactionId,nowTime);
        String body2 = jsonBody.getOrderv2body("1","123456789","1",payInfo,"ddd","1002",prodInfo,"0",transactionId,nowTime);
        //String channelNo = jsonBody.getChannelno("12345678");
        //String channelCode = jsonBody.getChannelcode("35500");
        String H5urlback = jsonBody.getH5back("35500","123","http://xxxx.com","cccc","ssss");
        String rights = jsonBody.getRights(rightsList);
        String salesId = jsonBody.getSalesid("111");
        String sign = jsonBody.getSign("105105",salesId,transactionId,nowTime);
        String head = jsonBody.getHead("105","35500",sign,transactionId,nowTime);
        //System.out.println(prodInfo);
        System.out.println(head);
        System.out.println(body1);
        System.out.println(body2);
        //System.out.println(channelNo);
        System.out.println(sign);
        System.out.println(salesId);
        //System.out.println(channelCode);
        System.out.println(H5urlback);
        //System.out.println(rightsList);
        System.out.println(rights);
    }
}
