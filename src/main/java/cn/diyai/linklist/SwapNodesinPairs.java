package cn.diyai.linklist;

import org.junit.Test;

/**
 * Example:

 Given 1->2->3->4, you should return the list as 2->1->4->3.
 Note:
 Your algorithm should use only constant extra space.
 You may not modify the values in the list's nodes, only nodes itself may be changed.

 交换两个相邻的元素
 */
public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        //头结点
        ListNode curNode = head;
        //前一个结点
        ListNode preNode = null;
        while(curNode != null){
            //保留下一个结点
            ListNode nextNode = curNode.next;
            //指针反转
            curNode.next = preNode;
            //前结点后移
            preNode = curNode;

            //当前结点后移
            curNode = nextNode;
        }
        head = preNode;
        return head;
    }

    @Test
    public void test(){

    }

}
