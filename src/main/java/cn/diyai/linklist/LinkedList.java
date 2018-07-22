package cn.diyai.linklist;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 参考：http://blog.csdn.net/u013238950/article/details/50786330 http://blog.csdn.net/a19881029/article/details/22695289
 */
public class LinkedList extends TestCase {
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ArrayList<Integer> list = new ArrayList<>();

		if (listNode == null) {
			return list;
		}

		ListNode cur = listNode;
		Stack<ListNode> stack = new Stack<ListNode>();

		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}

		while (!stack.isEmpty()) {
			list.add(stack.pop().val);
		}

		return list;

	}

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	private ListNode listNodeFirst = null;
	private ListNode listNodeLast = null;

	public void insertFirst(int val) {
		ListNode data = new ListNode(val);
		data.next = listNodeFirst;
		listNodeFirst = data;
	}

	public void insertLast(int val) {
		ListNode data = new ListNode(val);
		if (listNodeLast == null) {
			listNodeLast = data;
		} else {
			listNodeLast.next = data;

		}
		listNodeLast = data;
	}

	/**
	 * 输入一个链表，反转链表后，输出链表的所有元素。
	 * @param head
	 * @return
	 */
	public ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null) {  
            return head;
        }  
		
		ListNode reHead = null;
		while (head != null) {
			ListNode data = new ListNode(head.val);
			data.next = reHead;
			reHead = data;
			head = head.next;
		}
		
		return reHead;

    }

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();

//		ll.insertFirst(67);
//		ll.insertFirst(0);
//		ll.insertFirst(24);
//		ll.insertFirst(58);

		// ll.insertLast(67);
		// ll.insertLast(0);
		// ll.insertLast(24);
		// ll.insertLast(58);
		System.out.println("-- {58,24,0,67} --");
		System.out.println("-- printListFromTailToHead --");
		ArrayList<Integer> arr = printListFromTailToHead(ll.listNodeFirst);
		// ArrayList<Integer> arr2 = (ArrayList<Integer>)
		// Arrays.asList(1,ll2,3,4);
		// assertEquals(arr2, arr);
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}

		// assertEquals(null, printListFromTailToHead(null));
		System.out.println("-- ReverseList --");
		ListNode reverseList = ll.ReverseList(ll.listNodeFirst);
		while (reverseList != null) {
			System.out.println(reverseList.val);
			reverseList = reverseList.next;
		}
		

	}

}
