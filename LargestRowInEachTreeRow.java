// Time Complexity : O(n)
// Space Complexity : O(w) max width of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Perform BFS level-order traversal using a queue.
//   - For each level, track the maximum value.
//   - Add the maximum of each level to the result list.
//   - Return the result list after traversing all levels.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LargestRowInEachTreeRow {
    //BFS
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {  //if tree null the return empty list output
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<>();  //list for max values in each level
        Queue<TreeNode> queue = new LinkedList<>(); //queue for BFS
        queue.add(root);    //add root in queue and start BFS

        while(!queue.isEmpty()) {
            int size = queue.size();
            int currMax = Integer.MIN_VALUE;    //setup for max value in that level
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                currMax = Math.max(currMax, temp.val);  //calculate max
                //add left and right children in queue if they are not null
                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }

            ans.add(currMax);   //add max to list
        }

        return ans; //return list
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3, new TreeNode(5), new TreeNode(3));
        root.right = new TreeNode(2, null, new TreeNode(9));

        LargestRowInEachTreeRow obj = new LargestRowInEachTreeRow();
        List<Integer> result = obj.largestValues(root);

        System.out.println("Largest values in each row: " + result);
    }
}
