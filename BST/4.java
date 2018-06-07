//https://www.geeksforgeeks.org/transform-bst-sum-tree/
import java.util.*;

public class Solution {
    static int sum;
    static class BSTNode {
        BSTNode left;
        BSTNode right;
        Integer data;
        BSTNode(Integer data) {this.data = data;}
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode(11);
        BSTNode two = new BSTNode(2);
        BSTNode one = new BSTNode(1);
        BSTNode seven = new BSTNode(7);
        BSTNode twentynine = new BSTNode(29);
        BSTNode fifteen = new BSTNode(15);
        BSTNode forty = new BSTNode(40);
        BSTNode thirtyfive = new BSTNode(35);

        root.left = two; root.right = twentynine;
        two.left = one; two.right = seven;
        twentynine.left = fifteen; twentynine.right = forty;
        forty.left = thirtyfive;
        printPostorder(root);
        makeGreaterSumBST(root);
        System.out.println();
        printPostorder(root);
    }
    private static void makeGreaterSumBST(BSTNode root) {
        sum = 0;
        transformBST(root);
    }
    private static void transformBST(BSTNode root) {
        if(root == null) {
            return;
        }

        transformBST(root.right);

        sum += root.data;
        root.data = sum  - root.data;

        transformBST(root.left);
    } 
    
    private static void printPostorder(BSTNode node) {
        if (node == null) {
            return;
        }
        
        printPostorder(node.right);
        System.out.print(node.data + " ");
        printPostorder(node.left);
    }
}