package com.allen.enhance.archaius;

import java.util.concurrent.TimeUnit;

import com.netflix.config.AbstractPollingScheduler;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;

public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        startPolling();
        TimeUnit.DAYS.sleep(1);
    }

    private static void startPolling() {
        System.setProperty("archaius.fixedDelayPollingScheduler.initialDelayMills", "1000");
        System.setProperty("archaius.fixedDelayPollingScheduler.delayMills", "2000");
        PolledConfigurationSource source = new FillConfigurationSource();
        AbstractPollingScheduler scheduler = new FixedDelayPollingScheduler();
        DynamicConfiguration configuration = new DynamicConfiguration(source, scheduler);
        ConfigurationManager.install(configuration);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000 * 10);
                        DynamicStringProperty myprop = DynamicPropertyFactory.getInstance().getStringProperty("allen", "default");
                        System.out.println("-----vaule:" + myprop.getValue());
                    } catch (Exception e) {

                    }
                }
            }
        }).start();
    }
}
