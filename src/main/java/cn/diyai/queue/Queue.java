package cn.diyai.queue;

import junit.framework.TestCase;

import java.util.Stack;

//1-->public Stack()创建一个空堆栈
//2-->public boolean empty()测试堆栈是否为空;
//3-->public E pop()移除堆栈顶部的对象，并作为此函数的值返回该对象。 
//4-->public E push(E item)把项压入堆栈顶部
//5-->public E peek()查看堆栈顶部的对象，但不从堆栈中移除它。 
//6-->public boolean empty()测试堆栈是否为空

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 思路1:入队:入栈stack1；出队：pop stack1中所有元素到 stack2中,再pop 一次stack2，将剩下的值压入到stack1中，从而循环。
 */
public class Queue extends TestCase {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);

	}

	public int pop() {
		if (stack1.isEmpty()) {
			return 0;
		}

		while (!stack1.isEmpty()) {
			int val = stack1.pop();
			stack2.push(val);
		}

		int ret = stack2.pop();

		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return ret;

	}

	public static void main(String[] args) {
		Queue queue = new Queue();
		// queue.push(1);
		// queue.push(2);
		// queue.push(3);
		// queue.push(4);
		assertEquals(0, queue.pop());
	}

}
