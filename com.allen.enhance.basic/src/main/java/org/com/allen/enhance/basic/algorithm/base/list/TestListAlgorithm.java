package org.com.allen.enhance.basic.algorithm.base.list;

import org.junit.Test;

/**
 * @author allen
 * @date 2020/3/27 1:48 下午
 **/
public class TestListAlgorithm {

    @Test
    public void testDeleteDuplicates() {
        ListAlgorithm la = generatorList();
        ListNode listNode = la.deleteDuplicates(la.head);
        la.printList(listNode);
    }

    @Test
    public void testReverseList() {
        ListAlgorithm la = generatorList();
        ListNode listNode = la.reverseList(la.head);
        la.printList(listNode);
    }

    @Test
    public void testDeleteDuplicatesV1() {
        ListAlgorithm la = generatorList();
        ListNode listNode = la.deleteDuplicatesV1(la.head);
        la.printList(listNode);
    }


    private ListAlgorithm generatorList() {
        ListAlgorithm la = new ListAlgorithm();
        la.add(1);
        la.add(2);
        la.add(3);
        la.add(3);
        la.add(4);
        la.add(4);
        la.add(5);
        return la;
    }
}
