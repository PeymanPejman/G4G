//https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/

import java.util.*;

public class Solution {
    static class BSTNode {
        BSTNode left;
        BSTNode right;
        Integer data;
        BSTNode(Integer data) {this.data = data;}
    }

    public static void main(String[] args) {
        List<BSTNode> possibilities = constructAllBST(1, 1);
        System.out.println(possibilities.size());
    }

    private static List<BSTNode> constructAllBST(int start, int end) {
        List<BSTNode> res = new ArrayList<>();
        res.add(null);
        if(start > end) {
            return res;
        }

        for(int i=start; i<=end; i++) {
            List<BSTNode> leftList = constructAllBST(start, i-1);
            List<BSTNode> rightList = constructAllBST(i+1, end);

            BSTNode root = new BSTNode(i);

            for(BSTNode leftNode : leftList) {
                for(BSTNode rightNode : rightList) {
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}