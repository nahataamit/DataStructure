package otherProblems;


public class TreeToDoublyList {

    TreeNode prev;

//    public TreeNode treeToDoublyList(TreeNode root) {
//        if (root == null) return null;
//        TreeNode dummy = new TreeNode(0);
//        prev = dummy;
//        helper(root);
//        //connect head and tail
//        prev.right = dummy.right;
//        dummy.right.left = prev;
//        return dummy.right;
//    }
//
//    private void helper (TreeNode cur) {
//        if (cur == null) return;
//        helper(cur.left);
//        prev.right = cur;
//        cur.left = prev;
//        prev = cur;
//        helper(cur.right);
//    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftHead = treeToDoublyList(root.left);
        TreeNode rightHead = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        return connect(connect(leftHead, root), rightHead);
    }

    // Used to connect two circular doubly linked lists. n1 is the head of circular DLL as well as n2.
    private TreeNode connect(TreeNode n1, TreeNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        TreeNode tail1 = n1.left;
        TreeNode tail2 = n2.left;

        tail1.right = n2;
        n2.left = tail1;
        tail2.right = n1;
        n1.left = tail2;

        return n1;
    }


    public static void main(String[] args){
        TreeNode root =  new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        root.right = new TreeNode(5);

        TreeToDoublyList treeToDoublyList = new TreeToDoublyList();
        treeToDoublyList.treeToDoublyList(root);

    }
}
