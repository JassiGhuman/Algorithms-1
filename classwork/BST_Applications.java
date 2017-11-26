package classwork;


class New_Node{
	protected New_Node left;
	protected New_Node right;
	protected New_Node parent;
	protected int data;
	protected int height;
	protected int num_nodes;
	protected int sum_nodes;
	protected int min;
	protected int max;
	protected int min_gap;
	
	New_Node(int d){
		left=null;
		right=null;
		parent=null;
		data=d;
		height=0;
		num_nodes=1;
		sum_nodes=d;
		min=d;
		max=d;
		min_gap=0;
	}
	
	public int getSum_nodes() {
		return sum_nodes;
	}

	public void setSum_nodes(int sum_nodes) {
		this.sum_nodes = sum_nodes;
	}

	public int getNum_nodes() {
		return num_nodes;
	}

	public void setNum_nodes(int num_nodes) {
		this.num_nodes = num_nodes;
	}

	public New_Node getLeft() {
		return left;
	}
	public void setLeft(New_Node left) {
		this.left = left;
	}
	public New_Node getRight() {
		return right;
	}
	public void setRight(New_Node right) {
		this.right = right;
	}
	public New_Node getParent() {
		return parent;
	}
	public void setParent(New_Node parent) {
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
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin_gap() {
		return min_gap;
	}

	public void setMin_gap(int min_gap) {
		this.min_gap = min_gap;
	}

}
public class BST_Applications {
	New_Node root;
	BST_Applications(New_Node n){
		if(n!=null){
			root=n;
			//root.setParent(null);
		}
	}
	
	 int height(New_Node N) {
	        if (N == null)
	            return -1;
	 
	        return N.getHeight();
	 }
	 int num_nodes(New_Node N){
		 if(N==null)
			 return 0;
		 return N.getNum_nodes();			
	 }
	 int sum_nodes(New_Node N){
		 if(N==null)
			 return 0;
		 return N.getSum_nodes();
	 }
	 int min_gap(New_Node n){
		 if(n==null || n.getMin_gap()==0)
			 return Integer.MAX_VALUE;
		 return n.getMin_gap();
			 
	 }
	 void find_min_gap(New_Node head){
			int a=Math.min(this.min_gap(head.getLeft()),this.min_gap(head.getRight()));
			int b=this.node_difference(head);
			head.setMin_gap(Math.min(a, b));
			if(head.getMin_gap()==Integer.MAX_VALUE)
				head.setMin_gap(0);
	 }
	 int node_difference(New_Node x){
		 if(x.getRight()== null && x.getLeft()==null)
			 return 0;
		 if(x.getLeft()==null){
			 return Math.abs(x.getData()-x.getRight().getMin());
		 }
		 if(x.getRight()==null)
			 return Math.abs(x.getData()-x.getLeft().getMax());
		 return Math.min(Math.abs(x.getData()-x.getRight().getMin()),Math.abs(x.getData()-x.getLeft().getMax()) );
	 }
	 public void LL_Rotations(New_Node n){
		 New_Node x=n.getRight();					//New_Node around which it rotates
		 //if((x.getLeft())!=null)
		 New_Node y = x.getLeft();					// if it exists keep it to right of New_Node n
		 x.setLeft(n);
		 New_Node parent=n.getParent();
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
			 
			 n.setMax(y.getMax());
			 
		 }
		 else{
			 n.setRight(null);
			 n.setMax(n.getData());
			 
		 }
			x.setMin(n.getMin());

     	int l_height=this.height(n.getLeft());
		int r_height=this.height(n.getRight());
     	n.setHeight(1+Math.max(l_height,r_height));
     	x.setHeight(1+Math.max(n.getHeight(), this.height(x.getRight())));
     	
     	n.setSum_nodes(n.getSum_nodes()-x.getSum_nodes()+sum_nodes(n.getRight()));	//rank
     	n.setNum_nodes(n.getNum_nodes()-x.getNum_nodes()+num_nodes(n.getRight()));
		//n.setNum_nodes(1+num_nodes(n.getLeft())+num_nodes(n.getRight()));
     	
     	x.setSum_nodes(x.getData()+sum_nodes(x.getLeft())+sum_nodes(x.getRight()));	//sum
     	x.setNum_nodes(1+num_nodes(x.getLeft())+num_nodes(x.getRight()));
		//System.out.println(x.getNum_nodes()+" "+n.getNum_nodes() );
     	find_min_gap(n);
     	find_min_gap(x);
     	
	 }
	 public void RR_Rotations(New_Node n){
		 New_Node x=n.getLeft();
		 New_Node y=null;
		 if(x.getRight()!=null)
		 	y=x.getRight();
		 x.setRight(n);
		 New_Node parent = n.getParent();
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

			 n.setMin(y.getMin());
		 }
		 else{
			 	n.setLeft(null);
			 	n.setMin(n.getData());
		 	}
			 x.setMax(n.getMax());

		 int l_height=this.height(n.getLeft());
		 int r_height=this.height(n.getRight());
	     n.setHeight(1+Math.max(l_height,r_height));
	     x.setHeight(1+Math.max(n.getHeight(), this.height(x.getLeft())));
	     
	     n.setNum_nodes(n.getNum_nodes()-x.getNum_nodes()+num_nodes(n.getLeft()));
		 x.setNum_nodes(1+num_nodes(x.getLeft())+num_nodes(x.getRight()));
		 
		 n.setSum_nodes(n.getSum_nodes()-x.getSum_nodes()+sum_nodes(n.getLeft()));
		 x.setSum_nodes(x.getData()+sum_nodes(x.getLeft())+sum_nodes(x.getRight()));
		 //System.out.println(n.getSum_nodes()+" "+x.getSum_nodes());
	    	find_min_gap(n);
	     	find_min_gap(x);

	 }
	public void insert(New_Node head,New_Node n){
		if(root==null){
			root=n;
			root.setMax(n.getData());
			root.setMin(n.getData());
			return;
		}
		head.setNum_nodes(head.getNum_nodes()+1);
		head.setSum_nodes(head.getSum_nodes()+n.getData());
		
		
		if(n.getData()>head.getData()){
			if(head.getMax()<n.getData()){
				head.setMax(n.getData());
			}
			if(head.getRight()==null){
				head.setRight(n);
				n.setParent(head);
			}
			else{
				this.insert(head.getRight(), n);
			}
		}
		else{

			if(head.getMin()>n.getData()){
				head.setMin(n.getData());
			}
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
		find_min_gap(head);
		//head.setNum_nodes(1+num_nodes(head.getLeft())+num_nodes(head.getRight()));
	}
	public New_Node inorderPredecessor(New_Node head){
		if(head.getRight()==null)
			return head;
		else
			return this.inorderPredecessor(head.getRight());
	}
	public New_Node inorderSuccessor(New_Node head){
		if(head.getLeft()==null)
			return head;
		else
			return this.inorderSuccessor(head.getLeft());
	}
	public void balance_height(New_Node head,int key){
		New_Node parent=head.getParent();
		int l_height=this.height(head.getLeft());
		int r_height=this.height(head.getRight());
		
		head.setNum_nodes(head.getNum_nodes()-1);			//rank
		head.setSum_nodes(head.getSum_nodes()-key);			//sum
		find_min_gap(head);
		//System.out.println(head.getData()+" "+head.getMin()+" "+head.getMax()+" "+ head.getMin_gap());
		if(parent!=null){
			if(parent.getLeft()!=null && parent.getLeft().getData()==head.getData()){
					parent.setMin(parent.getLeft().getMin());
			}
			else if(parent.getRight()!=null && parent.getRight().getData()==head.getData()){
					parent.setMax(parent.getRight().getMax());
			}
			else{
				parent.setMax(parent.getData());
				parent.setMin(parent.getData());
			}
			
		}
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
		else{
			find_min_gap(parent);
			balance_height(parent,key);
		}
	}
	public void delete(New_Node head,int key){
		
		if(head.getData()==key){
			New_Node x;
			New_Node parent;
			if(head.getLeft()!=null){
				x=this.inorderPredecessor(head.getLeft());
				head.setData(x.getData());
				parent=x.getParent();
				if(!head.getLeft().equals(x)){			//not just immediate left
					parent.setRight(x.getLeft());
					
					if(x.getLeft()!=null){
						x.getLeft().setParent(parent);
						parent.setMax(parent.getRight().getMax());
					}
					else
						parent.setMax(parent.getData());
					//x.setParent(null);
				}
				else{									//immediate left
					parent.setLeft(x.getLeft());
					if(x.getLeft()!=null){
						x.getLeft().setParent(parent);
						parent.setMin(parent.getLeft().getMin());
					}
					else
						parent.setMin(parent.getData());
				}
			}
			else if(head.getRight()!=null){
				x=this.inorderSuccessor(head.getRight());
				head.setData(x.getData());
				parent=x.getParent();
				if(!head.getRight().equals(x)){						//not Immediate right...doesn't and shouldn't work in this case
					parent.setLeft(x.getRight());					//I.E. Obselete case
					if(x.getRight()!=null){							
						x.getRight().setParent(parent);
					}
					//x.setParent(null);
				}
				else{												//Immediate right	
					parent.setMax(parent.getData());
					parent.setRight(x.getRight());
					if(x.getRight()!=null){
						System.out.println("Shouldn't print");
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
					System.out.println("1");
					parent.setMin(parent.getData());
				}
				else{
					parent.setRight(null);
					parent.setMax(parent.getData());
				}
			}
			if(parent!=null){
				find_min_gap(parent);
				balance_height(parent,key);
			
			}
		}
		else if(head.getData()>key){
			this.delete(head.getLeft(), key);
		}
		else{
			this.delete(head.getRight(), key);
		}
		find_min_gap(head);
	}
	public void inorder(New_Node head){
		if(head==null){
			return;
		}
		if(head.getLeft()!=null)
			this.inorder(head.getLeft());
		System.out.println(head.getData()+" "+head.getHeight());
		if(head.getRight()!=null)
			this.inorder(head.getRight());
	}
	public void preorder(New_Node head){
		if(head==null){
			return;
		}
		System.out.println(head.getData()+" "+head.getHeight()+" "+head.getMin()+" "+head.getMax()+" "+ head.getMin_gap());
		if(head.getLeft()!=null)
			this.preorder(head.getLeft());
//		System.out.println(head.getData()+" "+head.getHeight());
		if(head.getRight()!=null)
			this.preorder(head.getRight());
		
	}
}


