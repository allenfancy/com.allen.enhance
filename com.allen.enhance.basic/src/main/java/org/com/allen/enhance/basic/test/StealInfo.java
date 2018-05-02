package org.com.allen.enhance.basic.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.com.allen.enhance.basic.test.SystemLog.LoginInfo;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;

public class StealInfo {


    private static final CloseableHttpClient httpClient = HttpClients.createDefault();
    private static BufferedReader reader;
    private static final String url = "http://passport-mng.bilibili.co";
    private static final String uri = "/systemLog";
    private static final String params =
            "&fuzzySearch=true&fuzzy=&startIndex=0&pageSize=40&draw=1&_=1524038712622";

    private static final String STEPONE = "操作: 修改密码(PC端)，验证的方式为 => 邮箱";
    private static final String STEPTWO = "操作: 换绑邮箱(原邮箱";
    private static final String STEPTWO1 = "更换为";
    private static final String STEPTHREE = "操作: 绑定手机";
    private static final Gson GSON = new Gson();

    private static final Map<Integer, RightInfo> RIGHT_CACHE = new HashMap<Integer, RightInfo>();

    private static final Map<Integer, ErrorInfo> ERROR_CACHE = new HashMap<Integer, ErrorInfo>();

    private static final String PRE  = "delete from aso_system_log where id in ";
    
    public static void main(String[] args) throws IOException {


        /*  BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(new File("/Users/allen/Desktop/co.txt")));
       // FileOutputStream out = new FileOutputStream(new File("/Users/allen/Desktop/co.txt"));
        reader = new BufferedReader(new InputStreamReader(in));
        String mid = "";
        StringBuffer sb = new StringBuffer();
        while ((mid = reader.readLine()) != null) {
           String doGet = doGet(url,uri,"mid="+mid+params);
            SystemLog fromJson = GSON.fromJson(doGet, SystemLog.class);
            List<LoginInfo> logInfo = fromJson.getLogInfo();
            if(logInfo.size()<4) {
                continue;
            }
            LoginInfo loginInfo = logInfo.get(0);
            LoginInfo loginInfo1 = logInfo.get(1);
            LoginInfo loginInfo2 = logInfo.get(2);
            LoginInfo loginInfo3 = logInfo.get(3);
            String oldEmail = null ;
            String oldTel = null;
            if(loginInfo.getMessage().contains("修改密码(PC端)，验证的方式为 => 邮箱")) {
                String msg = loginInfo1.getMessage().substring(0,loginInfo1.getMessage().indexOf(" 更换为"));
                msg = msg.replace("操作: 换绑邮箱(原邮箱", "");
                if(!StringUtils.isEmpty(msg) && loginInfo2.getMessage().contains("绑定手机") &&loginInfo3.getMessage().contains("绑定手机 ") ) {
                    oldEmail = msg;
                    oldTel = loginInfo3.getMessage().replace("操作: 绑定手机 ", "");
                }
            }
           System.out.println(loginInfo.getMid() + oldEmail + " " + oldTel);
           if(!StringUtils.isEmpty(oldEmail) && !StringUtils.isEmpty(oldTel)) {
               out.write(new String(loginInfo.getMid() + ","+oldTel + "," +oldEmail +"\r").getBytes(Charset.forName("utf-8")));
           }
           out.flush();/
            String[] split = mid.split(",");
            Integer mids = Integer.parseInt(split[0]);
            String tel = split[1];
            String email = split[2];
            updateTel(mids, tel);
            updateEmail(mids, email);
        }
        System.out.println(sb.toString());
        
        *
        *73273
        *
        */
        updateTel(8549, "13174789063");

    }


    public static void updateEmail(Integer mid, String email) throws ParseException, IOException {
        String uri = "/account/update";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("mid", String.valueOf(mid)));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("mark", "盗号处理，恢复邮箱=?" + email));
        String doPost = doPost(url, uri, params);
        System.out.println(doPost);

    }

    public static void updateTel(Integer mid, String phone) throws ParseException, IOException {
        String uri = "/account/updatePhone";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("mid", String.valueOf(mid)));
        params.add(new BasicNameValuePair("phone", phone));
        params.add(new BasicNameValuePair("mark", "盗号处理，恢复手机=>" + phone));
        String doPost = doPost(url, uri, params);
        System.out.println(doPost);
    }


    public static String doPost(String url, String uri, List<NameValuePair> params)
            throws ParseException, IOException {
        String all = url + uri;
        HttpPost post = new HttpPost(all);
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        Header header = new BasicHeader("cookie",
                "UM_distinctid=16097001770399-039ff4d532916e-16386656-1fa400-160970017724db; _AJSESSIONID=5f84c3b0439311e897bc522233015ca2; username=wutao; menuMemory=70; JSESSIONID=D5A3A9732BE2A120772382901CBB0B6B");
        post.setHeader(header);
        CloseableHttpResponse execute = httpClient.execute(post);
        if (execute.getStatusLine().getStatusCode() == 200) {
            String str = EntityUtils.toString(execute.getEntity());
            return str;
        }
        return "";
    }

    public static String doGet(String url, String uri, String params)
            throws ParseException, IOException {
        String all = url + uri + "?" + params;
        HttpGet get = new HttpGet(all);
        Header header = new BasicHeader("cookie",
                "UM_distinctid=16097001770399-039ff4d532916e-16386656-1fa400-160970017724db; DedeUserID=38322079; DedeUserID__ckMd5=f2fc206fe36b0fcd; SESSDATA=58d505c1%2C1524045374%2C528c76c0; bili_jct=4ca63851bd6a42a6aa4a61d5b3f0df43; _AJSESSIONID=6943b55042bc11e897bc522233015ca2; username=wutao; menuMemory=70; JSESSIONID=DEB161250F02F58028ECEEFC00037610");
        get.setHeader(header);
        CloseableHttpResponse execute = httpClient.execute(get);
        if (execute.getStatusLine().getStatusCode() == 200) {
            String str = EntityUtils.toString(execute.getEntity());
            return str;
        }
        return "";
    }


    public static boolean isChinese(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;
    }

    public static boolean isChinese(Object obj) {
        if (obj == null)
            return false;
        String str = (String) obj;
        for (char c : str.toCharArray()) {
            if (isChinese(c))
                return true;
        }
        return false;
    }
}
