package org.com.allen.enhance.basic.test;

import java.io.IOException;
import java.util.TreeMap;

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

public class SiteMain {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    private static final String PASSPORT = "http://passport.bilibili.com";

    private static final String appKey = "";

    private static final String secret = "";

    public static void main(String[] args) throws ParseException, IOException {

        // 1.测试绑定手机,先验证邮箱
        //testMailSend(11,"");
        //testMailCheck(11,"","369995");
       // testSmsSend(8,"13122119298");
       // testSmsCheck(8, "13122119298","135951");
       testBindTel();
    }

    public static void testBindTel() throws ClientProtocolException, IOException {
        String uri = "/web/site/bind/tel";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("oldCode","730050");
        params.put("oldType","11");
        params.put("tel","13122119298");
        params.put("cid", "1");
        params.put("type", "8");
        params.put("code", "860139");
        params.put("goUrl", "http://www.baidu.com");
        String doGet = doPost(PASSPORT, uri, getParams(params));
        
        System.out.println(doGet);
    }

    public static void testMailSend(Integer type, String mail) throws ParseException, IOException {
        String uri = "/web/mail/send";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", String.valueOf(type));
        if (!StringUtils.isEmpty(mail)) {
            params.put("email", String.valueOf(mail));
        }
        String doGet = doPost(PASSPORT, uri, getParams(params));
        System.out.println(doGet);
    }

    public static void testMailCheck(Integer type, String mail,String code) throws ParseException, IOException {
        String uri = "/web/mail/check";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", String.valueOf(type));
        if (!StringUtils.isEmpty(mail)) {
            params.put("email", String.valueOf(mail));
        }
        params.put("code", code);
        String doGet = doPost(PASSPORT, uri, getParams(params));
        System.out.println(doGet);
    }

    public static void testSmsSend(Integer type, String tel) throws ParseException, IOException {
        String uri = "/web/sms/send";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", String.valueOf(type));
        if (!StringUtils.isEmpty(tel)) {
            params.put("tel", String.valueOf(tel));
        }
        params.put("cid", "1");
        String doGet = doPost(PASSPORT, uri, getParams(params));
        System.out.println(doGet);
    }

    public static void testSmsCheck(Integer type, String tel,String code) throws ParseException, IOException {
        String uri = "/web/sms/check";
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("type", String.valueOf(type));
        params.put("code", code);
        params.put("cid", "1");
        if (!StringUtils.isEmpty(tel)) {
            params.put("tel", String.valueOf(tel));
        }
        String doGet = doPost(PASSPORT, uri, getParams(params));
        System.out.println(doGet);
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
        Header header = new BasicHeader("Cookie:",
                "fts=1522220948; buvid3=D6A42687-979E-4AFF-9657-3A7DEBE680CF12778infoc; sid=5zt7fwl6; UM_distinctid=1626fb6be79c2-06d8ee405518f3-336c7b05-1fa400-1626fb6be7a446; im_local_unread_50697896=0; im_notify_type_50697896=2; LIVE_BUVID=16ebcf8060df30fa13af3193f517a5b9; LIVE_BUVID__ckMd5=a1f268c6c24a2e98; rpdid=kmilkmximpdosiimpxwww; CURRENT_QUALITY=80; im_seqno_50697896=635; BANGUMI_SS_2543_REC=198382; pgv_pvi=8265960448; finger=14bc3c4e; _dfcaptcha=d2814cc3bb7731391d3857608bea6e2d; _jct=5e3945d04ac311e8ab9452223302806e; JSESSIONID=1C79DCE54C4FA92ED5CC897638613F05; DedeUserID=27515305; DedeUserID__ckMd5=01de35277352685a; SESSDATA=b5cf2e82%2C1527498375%2C8a6d47f3; bili_jct=07f3f9e2ca303c2cbf360905bb2c1da1");
        get.addHeader(header);
        CloseableHttpResponse execute = httpClient.execute(get);
        if (execute.getStatusLine().getStatusCode() == 200) {
            String str = EntityUtils.toString(execute.getEntity());
            System.out.println(uri + ",response : " + str);
            return str;
        }
        return EntityUtils.toString(execute.getEntity());
    }

    public static String doPost(String url, String uri, String params)
            throws ClientProtocolException, IOException {
        String all = url + uri + "?" + params;
        System.out.println(all);
        HttpPost post = new HttpPost(all);
        Header header = new BasicHeader("Cookie:",
                "fts=1522220948; buvid3=D6A42687-979E-4AFF-9657-3A7DEBE680CF12778infoc; sid=5zt7fwl6; UM_distinctid=1626fb6be79c2-06d8ee405518f3-336c7b05-1fa400-1626fb6be7a446; im_local_unread_50697896=0; im_notify_type_50697896=2; LIVE_BUVID=16ebcf8060df30fa13af3193f517a5b9; LIVE_BUVID__ckMd5=a1f268c6c24a2e98; rpdid=kmilkmximpdosiimpxwww; CURRENT_QUALITY=80; im_seqno_50697896=635; BANGUMI_SS_2543_REC=198382; pgv_pvi=8265960448; finger=14bc3c4e; _dfcaptcha=d2814cc3bb7731391d3857608bea6e2d; _jct=5e3945d04ac311e8ab9452223302806e; JSESSIONID=1C79DCE54C4FA92ED5CC897638613F05; DedeUserID=27515305; DedeUserID__ckMd5=01de35277352685a; SESSDATA=b5cf2e82%2C1527498375%2C8a6d47f3; bili_jct=07f3f9e2ca303c2cbf360905bb2c1da1");
        post.setHeader(header);
        CloseableHttpResponse execute = httpClient.execute(post);
        if (execute.getStatusLine().getStatusCode() == 200) {
            String str = EntityUtils.toString(execute.getEntity());
            return str;
        }
        return "";
    }
}
