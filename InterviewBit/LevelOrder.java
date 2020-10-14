/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        Queue<TreeNode>q = new LinkedList<>();
       
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int count = 1;
        q.add(A);
        while(!q.isEmpty()){
            int idx = 0;
            int count_cpy = 0;
             ArrayList<Integer>list = new ArrayList<>();
            for(idx = 0;idx < count;idx++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null)
                {
                    count_cpy++;
                    q.add(node.left);
                }
                if(node.right != null)
                {
                    count_cpy++;
                    q.add(node.right);
                }
            }
            count = count_cpy;
            result.add(list);
        }
        return result;    
    }
}

