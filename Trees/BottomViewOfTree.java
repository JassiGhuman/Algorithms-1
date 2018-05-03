//Given a Binary Tree, we need to print the bottom view from left to right. 
//A node x is there in output if x is the bottommost node at its horizontal distance. 
//Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, 
and that of right child is horizontal distance of x plus 1.

{
// Java Program to print Bottom View of Binary Tree
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.HashMap;
import java.io.*;
import java.util.*;
 
// Tree node class
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
 
	
class BottomViewOfTree
{
	// driver function to test the above functions
    public static void main(String args[])
    {
		
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		//Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
		
            GfG g = new GfG();
            
			//g.leftView(root);
			g.bottomView(root);
			
			System.out.println();
         t--;			
        }
    }
}

}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* Tree node class
class Node {
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}*/
class Pair{
    Node node;
    int height;
    Pair(Node n,int h){
        node = n;
        height= h;
    }
}

class GfG
{
    // Should print bottom view of tree with given root
    public void bottomView(Node root)
    {
        // Your code here
        HashMap<Integer,Pair> map = new HashMap<>();
        root.hd = 0;
        bottomView(map,root,0);
        //Collections.sort(map);
         ArrayList<Integer> sortedKeys =
                    new ArrayList<Integer>(map.keySet());
         
        Collections.sort(sortedKeys); 
        for(int key : sortedKeys ){
            System.out.print(map.get(key).node.data+" ");
        }
    }
    public void bottomView(HashMap<Integer,Pair> map , Node node,int height)
    {
        //set hd first
        if(map.containsKey(node.hd)){
            if(map.get(node.hd).height <= height){
                Pair p = new Pair(node,height);
                map.put(node.hd,p);
            }
            
        }   
        else{
            Pair p = new Pair(node,height);
            map.put(node.hd,p);
        }
        
        if(node.left!=null){
            node.left.hd = node.hd - 1 ;
            bottomView(map,node.left,height+1);
        }
        if(node.right!=null){
            node.right.hd = node.hd + 1;
            bottomView(map,node.right,height+1);
        }
    }
    
}
	
