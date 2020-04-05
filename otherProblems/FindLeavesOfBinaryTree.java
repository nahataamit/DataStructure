package otherProblems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root ==null)
            return null;

        List<List<Integer>> leaves = new ArrayList();
        HashMap<TreeNode, Boolean> visited =  new HashMap<>();

        while(root.left !=null || root.right != null){
            List<Integer> leave = new ArrayList();
            getLeaves(root,leave,visited);
            leaves.add(leave);
        }

        List<Integer> lastLeave = new ArrayList();
        lastLeave.add(root.val);
        leaves.add(lastLeave);

        return leaves;

    }

    public void getLeaves(TreeNode root, List<Integer> leaves,HashMap<TreeNode,Boolean> visited){

        if(root ==null)
            return;


        if(root.left ==null && root.right ==null){
            leaves.add(root.val);
            visited.put(root,true );
            return;
        }

        getLeaves(root.left,leaves,visited);
        getLeaves(root.right,leaves,visited);

        if(visited.getOrDefault(root.left,false))
        root.left = null;
        if(visited.getOrDefault(root.right,false))
        root.right = null;



    }

    public static void main(String[] args){
          TreeNode root = new TreeNode(1);
          root.left = new TreeNode(2);
          root.left.left = new TreeNode(4);

          root.left.right = new TreeNode(5);

          root.right =  new TreeNode(3);

          FindLeavesOfBinaryTree findLeavesOfBinaryTree = new FindLeavesOfBinaryTree();
          List<List<Integer>> leaves =  findLeavesOfBinaryTree.findLeaves(root);

          for(List<Integer> list : leaves){
              System.out.println();
              for(int val : list){
                  System.out.print(val);
              }
          }
    }
}
