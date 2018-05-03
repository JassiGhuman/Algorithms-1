/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return ;
        
        TreeLinkNode p = root ;

        while(p!=null){
            TreeLinkNode q = p ;
            while(q!=null){
                if(q.left!=null){
                    if(q.right!=null){
                        q.left.next = q.right;
                        q.right.next = getNext(q);
                    }
                    else
                        q.left.next = getNext(q);
                }
                else if(q.right!=null)
                    q.right.next = getNext(q);
                q = q.next;    
            }
            
            if(p.left!=null){
                p = p.left;
            }
            else if(p.right!=null){
                p = p.right;
            }
            else {
                p = getNext(p);
            }
        }
        
    }
    public TreeLinkNode getNext(TreeLinkNode p){
        if(p.next==null){
            return null;
        }
        TreeLinkNode temp = p.next;
        while(temp!=null){
            if(temp.left!=null)
                return temp.left;
            if(temp.right!=null)
                return temp.right;
            
            temp=temp.next;
        }
        return temp;
    }
    
}
