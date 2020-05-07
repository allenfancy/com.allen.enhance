package org.com.allen.enhance.basic.algorithm.base.list;

import javax.swing.*;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author allen
 * @date 2020/3/25 10:02 上午
 * 链表经典面试算法题
 **/
public class ListAlgorithm {

    public ListNode head;

    /**
     * add node
     *
     * @param x x
     * @return List Node
     */
    public void add(int x) {
        ListNode newNode = new ListNode(x);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     * 1. 求单链表中节点的个数
     *
     * @param node node
     * @return length
     */
    public int getLength(ListNode node) {
        if (node == null) {
            return 0;
        }
        int length = 0;
        ListNode cur = node;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第k个结点
     * 两个指针：即两个结点型的变量first和second，首先让first和second都指向第一个结点，然后让second结点往后挪k-1个位置，此时first和second就间隔了k-1个位置，然后整体向后移动这两个节点，直到second节点走到最后一个结点的时候，此时first节点所指向的位置就是倒数第k个节点的位置
     *
     * @param head head
     * @param k    k
     * @return listNode
     */
    public ListNode get_last_k_node(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode f = head;
        ListNode sec = head;
        for (int i = 0; i < k - 1; i++) {
            sec = sec.next;
            if (sec == null) {
                return null;
            }
        }
        while (sec.next != null) {
            f = f.next;
            sec = sec.next;
        }
        return f;
    }


    /**
     * 删除到处第n个节点
     *
     * @param head head
     * @param n    n
     * @return ListNode
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * 查找单链表中的中间结点
     * 俩个指针同时向前走，sec指针每次走俩步，f指针每次走一步，sec每次走俩步，当sec为最后一个节点时，f就是中间的节点.
     *
     * @param head head
     * @return node
     */
    public ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode f = head;
        ListNode sec = head;
        while (sec.next != null && sec.next.next != null) {
            f = f.next;
            sec = sec.next.next;
        }
        return f;
    }

    /**
     * 链表合并
     *
     * @param h1 h1
     * @param h2 h2
     * @return list node
     */
    public ListNode mergeLinkList(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        ListNode nh = new ListNode(-1);
        ListNode tmp = nh;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                tmp.next = h1;
                h1 = h1.next;
            } else {
                tmp.next = h2;
                h2 = h2.next;
            }
            tmp = tmp.next;
        }
        if (h1 != null) {
            tmp.next = h1;
        }
        if (h2 != null) {
            tmp.next = h2;
        }
        return nh.next;
    }

    /**
     * 链表翻转
     *
     * @param head head
     * @return node
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //新链表
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }

    /**
     * @param head head
     * @param k    k
     * @return listnode
     */
    public ListNode rotateRight(ListNode head, int k) {
        return null;
    }

    /**
     * 链表反转打印。
     *
     * @param head
     */
    public void reversePrintByStack(ListNode head) {
        if (head == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head.next != null) {
            stack.add(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + "->");
        }
        System.out.println();
    }

    /**
     * hasCycle 判断链表是否有环.
     *
     * @param head head
     * @return true or false.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode f = head;
        ListNode sec = head;
        while (sec != null && sec.next != null) {
            f = f.next;
            sec = sec.next.next;
            if (f == sec) {
                return true;
            }
        }
        return false;
    }

    /**
     * 环的长度,通过快慢指针来搞. o(n)
     *
     * @param head head.
     * @return true or false
     */
    public int getCycleLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        ListNode f = head;
        ListNode sec = head;
        while (sec != null && sec.next != null) {
            f = f.next;
            sec = sec.next.next;
            len++;
            if (f == sec) {
                return len;
            }
        }
        return 0;
    }

    /**
     * 获取环的起点：从相遇节点开始，设置一个节点从头节点开始，然后最终相遇的环就是环的起点.
     *
     * @param head 头
     * @return listNode
     */
    public ListNode getCycleStart(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode f = head;
        ListNode sec = head;
        while (sec.next != null && sec.next.next != null) {
            f = f.next;
            sec = sec.next.next;
            if (f == sec) {
                ListNode tmp = head;
                while (tmp != sec) {
                    tmp = tmp.next;
                    sec = sec.next;
                }
                return sec;
            }
        }
        return null;
    }

    public void printList(ListNode node) {
        if (node == null) {
            System.out.println("empty list");
            return;
        }
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    /**
     * 删除重复的链表
     *
     * @param head head
     * @return ListNode
     * 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    /**
     * LeetCode-83
     *
     * @param head head
     * @return listNode
     */
    public ListNode deleteDuplicatesV1(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
