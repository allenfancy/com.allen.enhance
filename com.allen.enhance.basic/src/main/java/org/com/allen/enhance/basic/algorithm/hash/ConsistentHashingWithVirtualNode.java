package org.com.allen.enhance.basic.algorithm.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author allen.wu
 * @since 2018-09-02 14:27
 */
public class ConsistentHashingWithVirtualNode {


    private static SortedMap<Long, String> virtualNode = new TreeMap<>();

    private static int VIRTUAL_NODE_COUNT = 5;

    public static void init(List<String> servers) {
        synchronized (virtualNode) {
            for (String server : servers) {
                for (int i = 0; i < VIRTUAL_NODE_COUNT; i++) {
                    String VNNodeName = server + "&&VN" + i;
                    virtualNode.put(HashAlgorithm.KETAMA_HASH.hash(VNNodeName), VNNodeName);
                    System.out.println("[虚拟节点 " + VNNodeName + "加入集群, hash为 " + HashAlgorithm.KETAMA_HASH.hash(server) + "]");
                }
            }
        }
    }

    public static String getServer(String node) {
        synchronized (virtualNode) {
            long hash = HashAlgorithm.KETAMA_HASH.hash(node);
            SortedMap<Long, String> longStringSortedMap = virtualNode.tailMap(hash);
            Long aLong = longStringSortedMap.firstKey();
            String vn = virtualNode.get(aLong);
            System.out.println(vn);
            return vn.substring(0, vn.indexOf("&&"));
        }
    }

    public static void main(String[] args) {

        List<String> allNodes = new LinkedList<String>() {
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
        ConsistentHashingWithVirtualNode.init(allNodes);
        for (String server : nodes) {
            System.out.println("[" + server + "] 的hash值为 " +
                HashAlgorithm.KETAMA_HASH.hash(server) + " , 被路由到结点[" + getServer(server) + "]");
        }
    }
}
