package cn.diyai.tree;

import junit.framework.TestCase;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回  :
 需要学习
 */
public class BinaryTree extends TestCase {

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

	//{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
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
