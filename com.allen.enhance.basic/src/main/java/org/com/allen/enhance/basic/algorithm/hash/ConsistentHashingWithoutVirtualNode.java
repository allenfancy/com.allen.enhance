package org.com.allen.enhance.basic.algorithm.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author allen.wu
 * @since 2018-09-02 11:47
 * 缺点：
 * 负载分布不均匀
 */
public class ConsistentHashingWithoutVirtualNode {

    private static SortedMap<Long, String> map = new TreeMap<>();


    public static void init(List<String> servers) {
        synchronized (map) {
            for (String server : servers) {
                map.put(HashAlgorithm.KETAMA_HASH.hash(server), server);
                System.out.println("[服务器 " + server + "加入集群, hash为 " + HashAlgorithm.KETAMA_HASH.hash(server) + "]");
            }
        }
    }

    public static String getServer(String node) {
        synchronized (map) {
            long hash = HashAlgorithm.KETAMA_HASH.hash(node);
            SortedMap<Long, String> longStringSortedMap = map.tailMap(hash);
            Long aLong = longStringSortedMap.firstKey();
            return map.get(aLong);
        }
    }

    public static void main(String[] args) {

        List<String> allNodes = new ArrayList() {
            {
                add("192.168.0.1:111");
                add("192.168.0.2:111");
                add("192.168.0.3:111");
                add("192.168.0.4:111");
                add("192.168.0.5:111");
                add("192.168.0.6:111");
                add("192.168.0.7:111");
                add("192.168.0.8:111");
                add("192.168.0.9:111");
            }
        };
        List<String> nodes = new ArrayList() {
            {
                add("127.0.0.1:1111");
                add("221.226.0.1:2222");
                add("10.211.0.1:3333");
            }
        };
        ConsistentHashingWithoutVirtualNode.init(allNodes);
        for (String server : nodes) {
            System.out.println("[" + server + "] 的hash值为 " +
                HashAlgorithm.KETAMA_HASH.hash(server) + " , 被路由到结点[" + getServer(server) + "]");
        }
    }
}