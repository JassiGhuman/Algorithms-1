package classwork;

import java.util.Arrays;

public class Applications extends BST_Applications {
	Applications(New_Node n){
		super(n);
	}
	public int rank(int x){					//Find  nos of elements >=x
		New_Node r=root;
		int rank=0;
		while(true){
			if(r==null){
				return -1;
			}
			if(r.getData()==x){
				return 1+rank+num_nodes(r.getRight());
			}
			else if(r.getData()>x){
				rank+=1+num_nodes(r.getRight());
				r=r.getLeft();
			}
			else{
				r=r.getRight();
			}
		}
	}
	public int num_nodes_range(int x,int y){					//no of elements between range x and y inclusively
		return rank(x)-rank(y);
	}
	public int suffix_sum(int x){
		New_Node r=root;
		int sum=0;
		while(true){
			if(r==null){
				return -1;
			}
			if(r.getData()==x){
				return x+sum+sum_nodes(r.getRight());
			}
			else if(r.getData()>x){
				sum+=r.getData()+sum_nodes(r.getRight());
				r=r.getLeft();
			}
			else{
				r=r.getRight();
			}
		}
	}
	public int sum_nodes_range(int x,int y){					//sum of elements between x & y inclusively
		return suffix_sum(x)-suffix_sum(y)+y;
	}
	public int min_gap(int x,int y){
		New_Node r=root;
		int gap=0;
		while(true){
				char a[]={'a','d','c'};
				Arrays.sort(a);	
		}
		//return gap;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		New_Node n=new New_Node(5);
		Applications tree=new Applications(n);
		New_Node i1=new New_Node(3);
		New_Node i2=new New_Node(15);
		New_Node i3=new New_Node(2);
		New_Node i4=new New_Node(4);
		New_Node i5=new New_Node(10);
		tree.insert(tree.root,i1);
		tree.insert(tree.root,i2);
		tree.insert(tree.root,i3);
		tree.insert(tree.root,i4);
		tree.insert(tree.root,i5);
		tree.insert(tree.root, new New_Node(18));
		tree.insert(tree.root, new New_Node(1));
		tree.insert(tree.root, new New_Node(8));
		tree.insert(tree.root, new New_Node(14));
		tree.insert(tree.root, new New_Node(16));
		tree.insert(tree.root, new New_Node(20));
		tree.insert(tree.root, new New_Node(12));
        tree.delete(tree.root, 3);
//		tree.delete(tree.root, 1);
//		tree.delete(tree.root, 10);
//		tree.delete(tree.root, 20);
//		tree.delete(tree.root, 6);
//		tree.delete(tree.root, 2);
//		tree.delete(tree.root, 25);
//		tree.delete(tree.root, 11);
//		tree.delete(tree.root, 7);
		//tree.inorder(tree.root);
//        System.out.println("Rank: "+tree.suffix_sum(5)+" "+tree.suffix_sum(20));
//        System.out.println("Number of nodes in range :" + tree.sum_nodes_range(5, 25) );
		System.out.println("Preorder :");
		tree.preorder(tree.root);
		System.out.println("Min gap : "+tree.root.getMin_gap());
		System.out.println("Max gap : "+(tree.root.getMax()-tree.root.getMin()));
		//System.out.println("Root is "+tree.root.getData());
	}

}