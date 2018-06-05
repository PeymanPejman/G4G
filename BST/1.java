import java.util.*;

public class Solution {

    static int index = 0;

    static class BSTNode {
        BSTNode left;
        BSTNode right;
        int data;

        BSTNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        List<Integer> pre = Arrays.asList(10, 5, 1, 7, 40, 50);
        BSTNode root = constructBST(pre);
        printInorder(root);

    }

    private static BSTNode constructBST(List<Integer> preorder) {
        return getRootBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static BSTNode getRootBST(List<Integer> preorder, Integer min, Integer max) {
        if (index >= preorder.size())
            return null;
        
        BSTNode root = null;
        if (preorder.get(index) <= max && preorder.get(index) >= min) {
            root = new BSTNode(preorder.get(index));
            index++;

            if(index < preorder.size()) {
                root.left = getRootBST(preorder, min, root.data);
                root.right = getRootBST(preorder, root.data, max);
            }
        }

        return root;
    }

    private static void printPreorder(BSTNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printInorder(node.left);
        printInorder(node.right);
    }
}