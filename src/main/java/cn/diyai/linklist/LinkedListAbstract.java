package cn.diyai.linklist;

import junit.framework.Assert;

public abstract class LinkedListAbstract {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode node;

    public void init(int[] data){
        node = null;
        for(int i = 0; i < data.length;i++){
            addNode(data[i]);
        }

    }

    /**
     * 表尾插入结点
     * @param data
     */
    private void addNode(int data) {

        ListNode newNode = new ListNode(data);
        if (node == null) {
            node = newNode;
            return;
        }

       ListNode temp = node;
        while (temp.next != null) {
            //将下一节点设置为当前节点
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void print() {
        ListNode curNode = node;
        while (curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    /**
     * 验证链表的值
     * @param except
     */
    public void verify(int[] except){
        ListNode curNode = node;
        int index = 0;
        while (curNode != null) {
            Assert.assertEquals(except[(index++)],curNode.val);
            curNode = curNode.next;
        }
    }
}
