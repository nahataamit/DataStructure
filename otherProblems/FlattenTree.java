package otherProblems;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */

public class FlattenTree {

    public void flatten(TreeNode root) {

        if(root == null)
            return;
        List<Integer> list = new ArrayList();
        flattenTree(root,list);

        root.left = null;
        root.right = null;
        TreeNode node = root;
        for(int i=1;i<list.size();i++){
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }



    }

    public void flattenTree(TreeNode root,  List<Integer> list){
        if(root!=null)
            list.add(root.val);
        if(root.left!=null)
            flattenTree( root.left,  list);

        if(root.right!=null)
            flattenTree( root.right,  list) ;
    }

    public static void main(String [] args){
        String test =  "barfoothefoobarma";
        int index = test.indexOf("bar")+"bar".length();
        System.out.println(test.indexOf("hgg"));
        String local = test.substring(index);

        System.out.println(local);
    }
}
