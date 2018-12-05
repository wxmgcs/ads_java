package cn.diyai.linklist;

import org.junit.Test;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given list will be between 1 and 100.
 */

//確定链表的中间位置,并返回后半部分,如果中间有2个结点,从第2个开始，
// 比如[1,2,3,4,5,6],中间节点是[3,4],则后半部分是[4,5,6]
public class MiddleOfTheLinkedList extends  LinkedListAbstract{


    public ListNode middleNode(ListNode head) {

        if(head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        int cnt = 1; //链表长度
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            cnt++;
        }
        int mid = 0; //中间节点
        if (cnt % 2 != 0){  //为奇数
            mid = (cnt - 1) / 2;
        }else {             //为偶数
            mid = cnt / 2 - 1;
        }
        cur = head;
        while (mid != 0){
            cur = cur.next;
            mid --;
        }
        return cur;
    }

    //优化 快慢指针
    public ListNode middleNode2(ListNode head) {

        if(head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    @Test
    public void test() {
        super.init(new int[]{1,2,3,4,5});
        super.print();
        super.node = middleNode(super.node);
        super.print();
        super.verify(new int[]{3,4,5});

        super.init(new int[]{1,2,3,4,5});
        super.print();
        super.node = middleNode2(super.node);
        super.print();
        super.verify(new int[]{3,4,5});

        super.init(new int[]{1,2,3,4,5,6});
        super.print();
        super.node = middleNode(super.node);
        super.print();
        super.verify(new int[]{4,5,6});

    }
}
