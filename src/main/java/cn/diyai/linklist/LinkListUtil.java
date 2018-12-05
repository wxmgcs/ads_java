package cn.diyai.linklist;

public class LinkListUtil {

    public ListNode getHead() {
        return head;
    }

    ListNode head;
    public LinkListUtil(ListNode head){
        head = head;
    }
    public ListNode addNode(int data) {

        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return head;
        }

        ListNode temp = head;
        while (temp.next != null) {
            //将下一节点设置为当前节点
            temp = temp.next;
        }
        temp.next = newNode;
        return temp;
    }


    public void print() {
        ListNode curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public void print(ListNode curNode) {
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

}
