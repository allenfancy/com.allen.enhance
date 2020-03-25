package org.com.allen.enhance.basic.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;

/**
 * 专用于api签名的工具类
 *
 * @author : 郑志升
 * Date: 14-8-13
 * Time: 下午2:05
 */
public class ApiSignHelper {

    public static boolean checkSign(Map<String, String[]> params, String appSecret, String sign) throws UnsupportedEncodingException {
        return StringUtils.isNotBlank(sign) && sign.equals(getSign(params, appSecret));
    }

    public static String getSign(List<NameValuePair> nvps, String appSecret) throws UnsupportedEncodingException {
        TreeMap<String, String> paramsTreeMap = new TreeMap<>();
        for (NameValuePair nameValuePair : nvps) {
            paramsTreeMap.put(nameValuePair.getName(), nameValuePair.getValue());
        }
        return getSign(paramsTreeMap, appSecret);
    }


    public static String getSign(Map<String, String[]> params, String appSecret) throws UnsupportedEncodingException {
        TreeMap<String, String> paramsTreeMap = new TreeMap<>();
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            if (!"sign".equals(entry.getKey()) && entry.getValue().length > 0) {
                paramsTreeMap.put(entry.getKey(), entry.getValue()[0]);
            }
        }
        return getSign(paramsTreeMap, appSecret);
    }

    public static String montage(TreeMap<String, String> paramsTreeMap) throws UnsupportedEncodingException {
        String montageCalc = "";
        for (Map.Entry<String, String> entry : paramsTreeMap.entrySet()) {
            String key = entry.getKey();
            String value = "";
            value = String.valueOf(entry.getValue());
            montageCalc = String.format("%s%s=%s&", montageCalc, key
                , encodedFix(URLEncoder.encode(value, "UTF-8")));
        }
        if (montageCalc.length() > 0) {
            montageCalc = montageCalc.substring(0, montageCalc.length() - 1);
        }
        return montageCalc;
    }

    public static String getSign(TreeMap<String, String> paramsTreeMap
        , String appSecret) throws UnsupportedEncodingException {
        String signCalc = montage(paramsTreeMap);
        signCalc = DigestUtils.md5Hex(String.format("%s%s", signCalc, appSecret));
        return signCalc;
    }


    private static String encodedFix(String encoded) {
        // required
        encoded = encoded.replace("+", "%20");
        encoded = encoded.replace("*", "%2A");
        encoded = encoded.replace("%7E", "~");

        // optional
        encoded = encoded.replace("!", "%21");
        encoded = encoded.replace("(", "%28");
        encoded = encoded.replace(")", "%29");
        encoded = encoded.replace("'", "%27");
        return encoded;
    }
}
