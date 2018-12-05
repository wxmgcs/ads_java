package cn.diyai.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.

 For example, given a 3-ary tree:


 Return its postorder traversal as: [5,6,3,2,4,1].
 */
public class NAryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> postorder(Node root) {
        List<Integer> ansList = new ArrayList<>();
        if (root == null){
            return ansList;
        }
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(root);
        while (nodeList.size() > 0) {
            Node cur = nodeList.get(nodeList.size() - 1);
            nodeList.remove(nodeList.size() - 1);
            ansList.add(cur.val);
            if (cur.children != null) {
                for (Node tmp : cur.children) {
                    nodeList.add(tmp);
                }
            }
        }
        for (int i=0; i<ansList.size()/2; i++) {
            int tmp = ansList.get(i);
            int end = ansList.size() - 1 - i;
            ansList.set(i, ansList.get(end));
            ansList.set(end, tmp);

        }
        return ansList;
    }

    /**
     * 优化方法
     */
    List<Integer> result = new ArrayList();
    public List<Integer> postorder2(Node root) {
        if(root == null)
            return result;
        else {
            for (int i=0; i<root.children.size(); i++) {
                postorder(root.children.get(i));
            }
            result.add(root.val);
        }
        return result;
    }


    public List<Integer> postorder3(Node root) {
        List<Integer> ansList = new ArrayList<>();
        recursivePostorder(root, ansList);
        return ansList;
    }

    void recursivePostorder(Node root, List<Integer> ansList) {
        if (root == null){
            return;
        }
        if (root.children != null) {
            for (Node tmp : root.children) {
                recursivePostorder(tmp, ansList);
            }
        }
        ansList.add(root.val);
    }

    //{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}



}
