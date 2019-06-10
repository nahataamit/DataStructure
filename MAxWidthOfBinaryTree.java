package otherProblems;

import BinaryTreeProblems.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MAxWidthOfBinaryTree {
    private static HashMap<Integer, Integer> lvlWidth = new HashMap<>();

    static int width = 0;
    public static int widthOfBinaryTree(TreeNode root) {
        findWidth(root,0,1);
        return width;
    }

    public static void findWidth(TreeNode root,int level,int pos){
        if(root ==null)
            return;

        if(!lvlWidth.containsKey(level)){
            lvlWidth.put(level,pos );
        }

        width = Math.max(width,pos-lvlWidth.get(level)+1);

        findWidth(root.left,level+1,2*pos);
        findWidth(root.right,level+1,2*pos+1);
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void prettyPrintTree(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            System.out.println("Empty tree");
            return;
        }

        if (node.right != null) {
            prettyPrintTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.val);

        if (node.left != null) {
            prettyPrintTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    public static void prettyPrintTree(TreeNode node) {
        prettyPrintTree(node,  "", true);
    }


    static List<Integer> list = new ArrayList<>();
    public static void widthOfBinaryTree(TreeNode root, int level, int pos){
        if(root == null){
            return;
        }
        if(list.size() == level){
            list.add(pos);
        }
        width = Math.max(pos - list.get(level) + 1, width);
        widthOfBinaryTree(root.left, level+1, 2 * pos - 1);
        widthOfBinaryTree(root.right, level+1, 2 * pos);
    }

    public static void main(String[] args){

        TreeNode root =  stringToTreeNode("[1,1,1,1,null,null,1,1,null,null,1]");
       //  root =  stringToTreeNode("[1]");
        MAxWidthOfBinaryTree mwBt =  new MAxWidthOfBinaryTree();
        mwBt.widthOfBinaryTree(root,0,1);
        System.out.print(width);


    }
}
