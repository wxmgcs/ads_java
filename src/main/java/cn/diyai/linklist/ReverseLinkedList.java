package cn.diyai.linklist;

import org.junit.Test;

/**
 * Example:
 Input: 1->2->3->4->5->NULL
 Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
    /**
     * 反转单链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
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
        ListNode list = new ListNode();
        LinkListUtil linkListUtil = new LinkListUtil(list);
        linkListUtil.addNode(1);
        linkListUtil.addNode(2);
        linkListUtil.addNode(3);
        linkListUtil.addNode(4);
        linkListUtil.addNode(5);

        linkListUtil.print();

        ListNode  re = reverseList(linkListUtil.getHead());

        linkListUtil.print(re);

    }

}
