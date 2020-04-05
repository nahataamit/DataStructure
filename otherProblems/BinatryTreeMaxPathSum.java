package otherProblems;


import java.util.Stack;

public class BinatryTreeMaxPathSum {

    int maxValue;

    public int maxPathSum(TreeNode root) {

        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;

//        int max = 0;
//        Stack<TreeNode> stack = new Stack();
//        stack.push(root);
//
//        while(!stack.isEmpty()){
//            TreeNode cureentNode = stack.pop();
//
//            int leftSum = findLeftTreePathSum(cureentNode.left,0);
//            int rightSum = findRightTreePathSum(cureentNode.right,0);
//            int currentWeight = leftSum+rightSum+cureentNode.val;
//            max = Math.max(max, currentWeight);
//
//            if(cureentNode.left!=null)
//                stack.push(cureentNode.left);
//
//            if(cureentNode.right !=null)
//                stack.push(cureentNode.right);
//        }


    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;

    }

    public int findLeftTreePathSum(TreeNode node,int sum){

        if(node ==null){
            return sum;
        }
        sum+=node.val;
        if(node.left!=null)
        sum +=findLeftTreePathSum(node.left,sum);
        return sum;

    }

    public int findRightTreePathSum(TreeNode node,int sum){

        if(node ==null){
            return sum;
        }

        if(node.right!=null)
        sum += findRightTreePathSum(node.right,sum);

        return sum;

    }

    public static void main(String[] args){

        // [-10,9,20,null,null,15,7]

//        TreeNode root = new TreeNode(-10);
////        TreeNode child =  new TreeNode(9);
////        root.left =  child;
////        child =  new TreeNode(20);
////        child.left =  new TreeNode(15);
////        child.right =  new TreeNode(7);
////        root.right = child;
////
////
////        BinatryTreeMaxPathSum binatryTreeMaxPathSum = new BinatryTreeMaxPathSum();
////        int max = binatryTreeMaxPathSum.maxPathSum(root);
////
////        System.out.println(max);

        String test =  "test";
        String sample = "hjchvsjhctes";

//        System.out.println(test.substring(0,test.length()-1));
//        System.out.println(sample.indexOf(test.substring(0,test.length()-1)));
//        sample = "esthjchvsjhc";
//        System.out.println(sample.indexOf(test.substring(1,test.length())));
//        System.out.println(test.substring(test.length()-1));

        System.out.println(test.substring(1,test.length()));

    }
}
