package org.com.allen.enhance.basic.javabasic;

import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.util.RamUsageEstimator;

/**
 * @author allen.wu
 * @since 2018-09-16 18:57
 * 差距一个大约是16bit的大小
 */
public class ObjectSize {


    public static void main(String[] args) {
        Map<String, String> params = new HashMap(2);
        params.put("a", "122222");
        System.out.println(params.size());
        Map<String, String> params1 = new HashMap();
        params1.put("a", "122222");
        System.out.println(params1.size());
        long l = RamUsageEstimator.sizeOf(params);
        System.out.println(l);
        long l1 = RamUsageEstimator.sizeOf(params1);
        System.out.println(l1);

    }
}
