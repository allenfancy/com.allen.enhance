package com.allen.enhance.archaius;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.google.common.collect.Maps;
import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;

public class FillConfigurationSource implements PolledConfigurationSource {

    @Override
    public PollResult poll(boolean b, Object o) throws Exception {
        System.out.println("polling .... ");
        FileInputStream in = null;
        try {
            in = new FileInputStream("/Users/allen/workspace/eclipse-workspace/com.allen.enhance/com.allen.enhance.archaius/src/main/resources/conf.properties");
            Properties properties = new Properties();
            properties.load(in);
            Set<Object> keys = properties.keySet();
            Map<String, Object> map = Maps.newHashMap();
            for (Object k : keys) {
                map.put((String) k, properties.get(k));
            }
            return PollResult.createFull(map);
        } catch (Exception e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
