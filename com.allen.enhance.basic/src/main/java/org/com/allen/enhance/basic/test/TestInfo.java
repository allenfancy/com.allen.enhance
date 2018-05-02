package org.com.allen.enhance.basic.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;


public class TestInfo {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();


    private static final String URL = "";

    private static final String ACCOUNT_OUT_URL = "";

    private static final String appKey = "";

    private static final String secret = "";

    private static final String PASSPORT = "http://127.0.0.1:8081";
    private static final String PASSPORT_INTERNAL = "";


    private static final Gson GSON = new Gson();

    public static void main(String[] args) throws ParseException, Exception {
        // testReg(); // OK
        // loginFlow(); // OK
        // testIntranet(); //OK
        // http://localhost:8081/pc/check/bindPhone?code=650961&country_code=1&tel=13122119298&type=8&sign=74707a9ee96b85825302c2e15993ccf5
        // sendSms();
        // bindNewPhone();
        // sendMail();
        // bindMail();

        // doSendSms();
        // doWebReg();
        // doUnBindPhone();
        userSource();
        // userID();

        //downloadInfo();
    }
    
    public static void userID() throws ParseException, IOException {
        String uri = "/intranet/acc/userid";
        String uri = "/intranet/acc/userid";
        String uri = "/intranet/acc/userid";
        String uri = "/intranet/acc/userid";
        String uri = "/intranet/acc/userid";String uri = "/intranet/acc/userid";
        String uri = "/intranet/acc/userid";
        String uri = "/intranet/acc/userid";
        String uri = "/intranet/acc/userid";
        String uri = "/intranet/acc/userid";


        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("mid", "322650224");
        params.put("appkey", appKey);
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        String doGet = doGet(PASSPORT, uri, getParams(params));
        System.out.println(doGet);
    }

    public static void userSource() throws ParseException, IOException {
        String uri = "/intranet/acc/user/source";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("mid", "322650224");
        params.put("appkey", appKey);
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        String doGet = doGet(PASSPORT, uri, getParams(params));
        System.out.println(doGet);
    }

    public static void doUnBindPhone() throws ParseException, IOException {
        String uri = "/api/member/unBindPhone";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("mid", "30");
        params.put("tel", "66175016");
        String doGet = doGet(URL, uri, getParams(params));
        System.out.println(doGet);
    }

    public static void doSendSms() throws ParseException, IOException {
        String uri = "/web/sms/general/send";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "12");
        params.put("tel", "13122119298");
       // params.put("captcha", "yep4y");
        params.put("cid", "1");
        String doPost = doPost(PASSPORT, uri, getParams(params));
        System.out.println(doPost);
    }

    public static void doWebReg() throws ParseException, IOException {
        String uri = "/web/reg/fast";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("tel", "13122119298");
        params.put("cid", "1");
        params.put("code", "946190");
        params.put("pwd", "123456");
        params.put("appkey", "213b4102148924a0");
        String doPost = doPost(PASSPORT, uri, getParams(params));
        System.out.println(doPost);
    }

    public static void sendSms() throws ParseException, IOException {
        String uri = "/pc/check/sendSms";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "8");
        params.put("tel", "13122119298");
        params.put("country_id", "1");
        doPost(PASSPORT, uri, getParams(params));
    }


    public static void bindNewPhone() throws ParseException, IOException {
        String uri = "/pc/check/bindPhone";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "8");
        params.put("tel", "13122119298");
        params.put("country_code", "1");
        params.put("code", "616735");
        doPost(PASSPORT, uri, getParams(params));
    }

    public static void sendMail() throws ParseException, IOException {
        String uri = "/pc/check/sendmail";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "8");
        params.put("email", "598717394@qq.com");
        doPost(PASSPORT, uri, getParams(params));
    }


    public static void bindMail() throws ParseException, IOException {
        String uri = "/pc/check/bindmail";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "8");
        params.put("email", "598717394@qq.com");
        params.put("code", "196180");
        doPost(PASSPORT, uri, getParams(params));
    }


    public static void testReg() throws ClientProtocolException, IOException, InterruptedException {

        System.out.println("==============regByTel==============");

        System.out.println("==============regV2==============");
        String uri = "/api/reg/regV2";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        doPost(URL, uri, getParams(params));

        /**
         * System.out.println("==============regV3=============="); String uri = "/api/reg/regV3";
         * for (int i = 9; i < 20; i++) { TreeMap<String, String> params = new TreeMap<String,
         * String>(); params.put("userid", "allenwu" + i); params.put("userpwd", "123456");
         * params.put("appkey", appKey); params.put("type", "json"); params.put("ts",
         * String.valueOf(System.currentTimeMillis() / 1000)); doPost(URL, uri, getParams(params));
         * TimeUnit.SECONDS.sleep(1); }
         **/
    }


    public static void downloadInfo() throws ParseException, IOException {
        String uri = "/account/listArray";

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(new File("/Users/allen/data/tel.csv"))));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(new File("/Users/allen/data/tel-mid.csv")), "UTF-8"));
        String tel = "";
        while ((tel = reader.readLine()) != null) {
            if(StringUtils.isEmpty(tel)) {
                continue;
            }
            TreeMap<String, String> params = new TreeMap<String, String>();
            params.put("fuzzySearch", "true");
            params.put("fuzzy", tel);
            params.put("startIndex", "0");
            params.put("pageSize", "20");
            params.put("draw", "2");
            params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
            params.put("appkey", appKey);
            String userInfoStr = doGet(PASSPORT_INTERNAL, uri, getParams(params));
            UserInfo fromJson = GSON.fromJson(userInfoStr, UserInfo.class);

            if (fromJson != null && fromJson.getTotal() == 1
                    && !fromJson.getUserInfoDetails().isEmpty()) {
                Integer mid = fromJson.getUserInfoDetails().get(0).getMid();
                StringBuffer sb = new StringBuffer();
                sb.append(tel).append(",").append(String.valueOf(mid)).append("\n");
                writer.write(sb.toString());
            }else {
                StringBuffer sb = new StringBuffer();
                sb.append(tel).append(",").append(String.valueOf(0)).append("\n");
                writer.write(sb.toString());
            }
        }
        writer.flush();

    }

    public static void testIntranet() throws ParseException, IOException {
        String uri = "/intranet/acc/queryByMids";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("mids", "1");
        doGet(URL, uri, getParams(params));

        uri = "/intranet/acc/queryByMid";
        params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("mid", "1");
        doGet(URL, uri, getParams(params));

        uri = "/intranet/acc/detail";
        params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("mid", "1");
        doGet(URL, uri, getParams(params));
    }

    public static void loginFlow() throws ParseException, IOException, Exception {
        for (int i = 9; i < 19; i++) {
            LoginResult doLogin = doLogin(getKey(), "allenwu" + i, "123456");
            // renewToken(doLogin);
            // apiOauth(doLogin);
            // accountMyInfo(doLogin);
        }
        // exchangeToken(doLogin);
        // String token = getTmpToken(doLogin);
        // exchangeByTmpToken(token);
    }


    private static KeyResult getKey() throws ParseException, IOException {
        String uri = "/api/login/get_key";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        String str = doGet(URL, uri, getParams(params));
        return GSON.fromJson(str, KeyResult.class);
    }

    private static LoginResult doLogin(KeyResult res, String userid, String pwd) throws Exception {
        String uri = "/api/login";
        String hash = res.getHash();
        String key = res.getKey();
        RsaHelper rsaHelper = new RsaHelper();
        rsaHelper.loadPublicKey(key);
        String enpwd = rsaHelper.encrypt(rsaHelper.getPublicKey(), hash + pwd);
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("pwd", enpwd);
        params.put("userid", userid);
        String str = doGet(URL, uri, getParams(params));
        return GSON.fromJson(str, LoginResult.class);
    }

    private static void renewToken(LoginResult result) throws ParseException, IOException {
        String uri = "/api/login/renewToken";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("access_key", result.getAccess_key());
        doGet(URL, uri, getParams(params));
    }

    private static void apiOauth(LoginResult result) throws ClientProtocolException, IOException {
        String uri = "/api/oauth";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("access_key", result.getAccess_key());
        doPost(URL, uri, getParams(params));
    }

    private static void exchangeToken(LoginResult result) throws ParseException, IOException {
        String uri = "/api/oauth/exchangeToken";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("access_key", result.getAccess_key());
        String str = doGet(URL, uri, getParams(params));
    }

    private static String getTmpToken(LoginResult result) throws ParseException, IOException {
        String uri = "/api/oauth/getTmpToken";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("target_appkey", appKey);
        params.put("access_key", result.getAccess_key());
        TmpToken fromJson = GSON.fromJson(doGet(URL, uri, getParams(params)), TmpToken.class);
        return fromJson.getToken();
    }

    private static void accountMyInfo(LoginResult result) throws ParseException, IOException {
        String uri = "/api/myinfo";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("access_key", result.getAccess_key());
        doGet(ACCOUNT_OUT_URL, uri, getParams(params));
    }

    // TODO error
    private static void exchangeByTmpToken(String token) throws ParseException, IOException {
        String uri = "/api/oauth/exchangeByTmpToken";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", "json");
        params.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        params.put("appkey", appKey);
        params.put("token", token);
        doGet(URL, uri, getParams(params));
    }

    public static String getParams(TreeMap<String, String> params) {
        try {
            return ApiSignHelper.montage(params) + "&sign=" + ApiSignHelper.getSign(params, secret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String doGet(String url, String uri, String params)
            throws ParseException, IOException {
        String all = url + uri + "?" + params;
        System.out.println(all);
        HttpGet get = new HttpGet(all);
        Header header = new BasicHeader("cookie",
                "");
        get.addHeader(header);
        CloseableHttpResponse execute = httpClient.execute(get);
        if (execute.getStatusLine().getStatusCode() == 200) {
            String str = EntityUtils.toString(execute.getEntity());
          // System.out.println(uri + ",response : " + str);
            return str;
        }
        return EntityUtils.toString(execute.getEntity());
    }

    public static String doPost(String url, String uri, String params)
            throws ClientProtocolException, IOException {
        String all = url + uri + "?" + params;
        System.out.println(all);
        HttpPost post = new HttpPost(all);
        CloseableHttpResponse execute = httpClient.execute(post);
        if (execute.getStatusLine().getStatusCode() == 200) {
            String str = EntityUtils.toString(execute.getEntity());
            return str;
        }
        return "";
    }
}
