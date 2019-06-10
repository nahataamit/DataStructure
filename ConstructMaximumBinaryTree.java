package otherProblems;

import BinaryTreeProblems.TreeNode;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return generateMaxBinaryTree(nums,0,nums.length-1);

    }

    public TreeNode generateMaxBinaryTree(int[] nums,int start,int end){

        if(start==end)
            return null;

        int maxIndex = 0;
        int maxNode =0;

        for(int i=start;i<end;i++){
            if(nums[i]>maxNode){
                maxNode = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxNode);
        root.left = generateMaxBinaryTree(nums,start,maxIndex);
        root.right = generateMaxBinaryTree(nums,maxIndex+1,end);

        return root;
    }
}
