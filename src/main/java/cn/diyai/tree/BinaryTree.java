package cn.diyai.tree;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,ll2,4,7,3,5,6,8}和中序遍历序列{4,7,ll2,1,5,3,8,6}，则重建二叉树并返回  :
 需要学习
 */
public class BinaryTree  {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 先序遍历
	 * 
	 * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
	 * 
	 * @param node
	 *            遍历的节点
	 */
	public static void preOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + " ");
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

	/**
	 * 中序遍历
	 * 
	 * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
	 * 
	 * @param node
	 *            遍历的节点
	 */
	public static void inOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.print(node.val + " ");
		inOrderTraverse(node.right);
	}
	
	/** 
     * 后序遍历 
     *  
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已 
     *  
     * @param node 
     *            遍历的节点 
     */  
    public static void postOrderTraverse(TreeNode node) {  
        if (node == null)  
            return;  
        postOrderTraverse(node.left);  
        postOrderTraverse(node.right);  
        System.out.print(node.val + " ");  
    }  

	private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private static List<TreeNode> nodeList = null;
	
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return null;
	}

	public TreeNode createBinTree() {
		nodeList = new LinkedList<TreeNode>();
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new TreeNode(array[nodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子
			nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
			// 右孩子
			nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = array.length / 2 - 1;
		// 左孩子
		nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
		}
		return null;

	}

	/**
	 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
	 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，
	 且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
	 * @param root
	 * @return
	 */
	public int[][] printTree(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			res.add(new ArrayList<Integer>());
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				res.get(res.size() - 1).add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		int[][] ans = new int[res.size()][];
		for (int i = 0; i < res.size(); i++) {
			ans[i] = new int[res.get(i).size()];
			for (int j = 0; j < res.get(i).size(); j++) {
				ans[i][j] = res.get(i).get(j);
			}
		}
		return ans;
	}



	//{1,ll2,4,7,3,5,6,8}和中序遍历序列{4,7,ll2,1,5,3,8,6}
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinTree();  
        // nodeList中第0个索引处的值即为根节点  
		TreeNode root = nodeList.get(0);  
  
        System.out.println("先序遍历：");  
        preOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("中序遍历：");  
        inOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("后序遍历：");  
        postOrderTraverse(root);  

	}

}
