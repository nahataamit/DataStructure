package otherProblems;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTree {

    public List<TreeNode> generateTrees(int n) {

        return genenateTree(1,n);

    }


    public List<TreeNode> genenateTree(int start, int end){

        List<TreeNode> list = new ArrayList();

        if(start>end){
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;

        for(int i=start;i<=end;i++){
            left = genenateTree(start,i-1);
            right = genenateTree(i+1,end);

            for(TreeNode lNode : left){

                for(TreeNode rNode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    list.add(root);
                }
            }

        }

        return list;
    }

    public static void main(String[] args){
        UniqueBinaryTree uniqueBinaryTree = new UniqueBinaryTree();

        uniqueBinaryTree.generateTrees(5);
    }
}
