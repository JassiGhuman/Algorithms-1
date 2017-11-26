package classwork;

class Node{
	private Node left;
	private Node right;
	private Node parent;
	private int data;
	private int height;
	Node(int d){
		left=null;
		right=null;
		parent=null;
		data=d;
		height=0;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	

}
public class AVL {
	Node root;
	AVL(Node n){
		if(n!=null){
			root=n;
			//root.setParent(null);
		}
	}
	
	 int height(Node N) {
	        if (N == null)
	            return -1;
	 
	        return N.getHeight();
	 }
	 public void LL_Rotations(Node n){
		 Node x=n.getRight();					//Node around which it rotates
		 //if((x.getLeft())!=null)
		 Node y = x.getLeft();					// if it exists keep it to right of NOde n
		 x.setLeft(n);
		 Node parent=n.getParent();
		 //System.out.println("1");
		 if(parent!=null)
		 {	
			 x.setParent(parent);
			 if(parent.getRight()!=null && parent.getRight().getData()==n.getData())
				 parent.setRight(x);
			 else
				 parent.setLeft(x);
			 
		 }
		 else{
			 x.setParent(null);
			 this.root=x;
		 }
		 n.setParent(x);
		 if(y!=null){
			 n.setRight(y);
			 y.setParent(n);
		 }
		 else{
			 n.setRight(null);
		 }
     	int l_height=this.height(n.getLeft());
		int r_height=this.height(n.getRight());
     	n.setHeight(1+Math.max(l_height,r_height));
     	x.setHeight(1+Math.max(n.getHeight(), this.height(x.getRight())));
	 }
	 public void RR_Rotations(Node n){
		 Node x=n.getLeft();
		 Node y=null;
		 if(x.getRight()!=null)
		 	y=x.getRight();
		 x.setRight(n);
		 Node parent = n.getParent();
		 if(parent!=null)
		 {	
			 x.setParent(parent);
			 if(parent.getLeft()!=null && parent.getLeft().getData()==n.getData())
			 	parent.setLeft(x);
			 else
				 parent.setRight(x);
		 }
		 else{
			 x.setParent(null);
			 this.root=x;
		 }
		 n.setParent(x);
		 if(y!=null){
			 n.setLeft(y);
			 y.setParent(n);
		 }
		 else{
			 n.setLeft(null);
		 }
		 int l_height=this.height(n.getLeft());
		 int r_height=this.height(n.getRight());
	     n.setHeight(1+Math.max(l_height,r_height));
	     x.setHeight(1+Math.max(n.getHeight(), this.height(x.getLeft())));
	     
	 }
	public void insert(Node head,Node n){
		if(root==null){
			root=n;
			return;
		}
		if(n.getData()>head.getData()){
			if(head.getRight()==null){
				head.setRight(n);
				n.setParent(head);
			}
			else{
				this.insert(head.getRight(), n);
			}
		}
		else{
			if(head.getLeft()==null){
				head.setLeft(n);
				n.setParent(head);
			}
			else{
				this.insert(head.getLeft(), n);
			}
		}
		int l_height=this.height(head.getLeft());
		int r_height=this.height(head.getRight());
		head.setHeight(1+Math.max(l_height,r_height));
		//System.out.println(head.getData());
		if(l_height-r_height<-1 && head.getRight().getData()<n.getData()){
				//System.out.println(head.getData());
				this.LL_Rotations(head);															//LL Rotation									
		}
		else if(l_height-r_height>1 && head.getLeft().getData()>n.getData())							//          4
		{																	                    //RR Rotation	   /
				this.RR_Rotations(head);																//		  3			
																										//		 /
		}																								//		2
		else if(l_height-r_height<-1 && head.getRight().getData()>n.getData()){
				
				this.RR_Rotations(head.getRight());												//RL Rotations
				this.LL_Rotations(head);
		}
		else if(l_height-r_height>1 && head.getLeft().getData()<n.getData()){					//LR Rotations
				
				this.LL_Rotations(head.getLeft());																
				this.RR_Rotations(head);
		}
	}
	public Node inorderPredecessor(Node head){
		if(head.getRight()==null)
			return head;
		else
			return this.inorderPredecessor(head.getRight());
	}
	public Node inorderSuccessor(Node head){
		if(head.getLeft()==null)
			return head;
		else
			return this.inorderSuccessor(head.getLeft());
	}
	public void balance_height(Node head){
		Node parent=head.getParent();
		int l_height=this.height(head.getLeft());
		int r_height=this.height(head.getRight());
		//System.out.println(head.getData());
		head.setHeight(1+Math.max(l_height,r_height));
		if(l_height-r_height<-1 && (height(head.getRight().getLeft())-height(head.getRight().getRight())==-1 )){
			//System.out.println(head.getData());
			this.LL_Rotations(head);															//LL Rotation									
		}
		else if(l_height-r_height>1 && (height(head.getLeft().getLeft())-height(head.getLeft().getRight())==1  ) )							//          4
		{																	                    //RR Rotation	   /
			this.RR_Rotations(head);																//		  3			
																									//		 /
		}																								//		2
		else if(l_height-r_height<-1 && (height(head.getRight().getLeft())-height(head.getRight().getRight())==1 || height(head.getRight().getLeft())-height(head.getRight().getRight())==0)){
			this.RR_Rotations(head.getRight());												//RL Rotations
			this.LL_Rotations(head);
		}
		else if(l_height-r_height>1 && (height(head.getLeft().getLeft())-height(head.getLeft().getRight())==-1|| height(head.getLeft().getLeft())-height(head.getLeft().getRight())==0)){					//LR Rotations
			this.LL_Rotations(head.getLeft());																
			this.RR_Rotations(head);
		}
 		
		if(parent==null)
			return;
		else
			balance_height(parent);
	}
	public void delete(Node head,int key){

		if(head.getData()==key){
			Node x;
			Node parent;
			if(head.getLeft()!=null){
				x=this.inorderPredecessor(head.getLeft());
				head.setData(x.getData());
				parent=x.getParent();
				if(!head.getLeft().equals(x)){
					parent.setRight(x.getLeft());
					if(x.getLeft()!=null){
						x.getLeft().setParent(parent);
					}
					//x.setParent(null);
				}
				else{
					parent.setLeft(x.getLeft());
					if(x.getLeft()!=null){
						x.getLeft().setParent(parent);
					}
				}
			}
			else if(head.getRight()!=null){
				x=this.inorderSuccessor(head.getRight());
				head.setData(x.getData());
				parent=x.getParent();
				if(!head.getRight().equals(x)){
					parent.setLeft(x.getRight());
					if(x.getRight()!=null){
						x.getRight().setParent(parent);
					}
					//x.setParent(null);
				}
				else{
					parent.setRight(x.getRight());
					if(x.getRight()!=null){
						x.getRight().setParent(parent);
					}
				}
			}
			else{
				parent=head.getParent();
				if(parent==null)
				{	
					root=null;
					return;
				}
				if(parent.getLeft()!=null && parent.getLeft().getData()==(key)){
					parent.setLeft(null);
				}
				else
					parent.setRight(null);
			}
			if(parent!=null)
				balance_height(parent);
			}
		else if(head.getData()>key){
			this.delete(head.getLeft(), key);
		}
		else{
			this.delete(head.getRight(), key);
		}
		
	}
	
	public void inorder(Node head){
		if(head==null){
			return;
		}
		if(head.getLeft()!=null)
			this.inorder(head.getLeft());
		System.out.println(head.getData()+" "+head.getHeight());
		if(head.getRight()!=null)
			this.inorder(head.getRight());
		
	}
	public void preorder(Node head){
		if(head==null){
			return;
		}
		System.out.println(head.getData()+" "+head.getHeight());
		if(head.getLeft()!=null)
			this.preorder(head.getLeft());
//		System.out.println(head.getData()+" "+head.getHeight());
		if(head.getRight()!=null)
			this.preorder(head.getRight());
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n=new Node(3);
		AVL tree=new AVL(n);
		Node i1=new Node(6);
		Node i2=new Node(5);
//		Node i3=new Node(10);
//		Node i4=new Node(25);
//		Node i5=new Node(50);
		tree.insert(tree.root,i1);
		tree.insert(tree.root,i2);
//		tree.insert(tree.root,i3);
//		tree.insert(tree.root,i4);
//		tree.insert(tree.root,i5);
//        tree.delete(tree.root, 50);
//		tree.delete(tree.root,40);
//		tree.delete(tree.root, 30);
//		tree.delete(tree.root, 20);
//		tree.delete(tree.root, 10);
		//tree.delete(tree.root, 25);
		//tree.inorder(tree.root);
		System.out.println("Preorder :");
		tree.preorder(tree.root);
		//System.out.println("Root is "+tree.root.getData());
	}

}
