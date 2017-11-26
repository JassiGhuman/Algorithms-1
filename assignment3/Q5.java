package assignment3;

public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinTree b4=new BinTree(null,null,4);
		BinTree b5=new BinTree(null,null,5);
		BinTree b6=new BinTree(null,null,6);
		BinTree b7=new BinTree(null,null,7);
		BinTree b2=new BinTree(b4,b6,2);
		BinTree b3=new BinTree(b5,b7,3);
		BinTree b1=new BinTree(b2,b3,1);

		System.out.println(b1.find(b1, 6));
		System.out.println(b1.numberOfNodes(b1));
		System.out.println(b1.isDescendent(b7, b1));
		System.out.println(b1.isSibling(b4, b6, b1));
		System.out.println(b1.isCousin(b7, b5, b1));
		System.out.println(b1.totalValue(b1));
	}

}

class BinTree{
	public BinTree left;
	public BinTree right;
	public int value;
	
	BinTree(BinTree left,BinTree right,int value)
	{
		this.left=left;
		this.right=right;
		this.value=value;
	}
	public String find(BinTree head,int val) {
		String s="NO match found";
		if(val==head.value) {
			s=val+" is present";
			return s;
		}
		else if(val!=value) {
			if(head.left!=null)
				s=this.find(head.left,val);		
			if(head.right!=null && s=="NO match found")
				s=this.find(head.right, val);
		}	
		return s;
}
	public int numberOfNodes(BinTree head) {
		int a=0;
		if(head!=null)
			a++;
		if(head.left!=null)
		{
			a+=numberOfNodes(head.left);
		}

		if(head.right!=null)	
		{
			a+=numberOfNodes(head.right);
		}
		
		return a;
		
	}
	public boolean isDescendent(BinTree des,BinTree parent) {
		boolean status=false;
		if(des!=null && parent!=null) {
			if(parent.left==des || parent.right==des)
					return true;
			else
			{
				status=isDescendent(des, parent.left);
				if(status!=true)
				status=isDescendent(des, parent.right);
			}
	}
		return status;
	}
	public boolean isSibling(BinTree child1,BinTree child2,BinTree head) {
		boolean status=false;
		if(head!=null) {
			if(head.left==child1 && head.right==child2 || head.left==child2 && head.right==child1)
				return true;
			else
			{
				status=isSibling(child1, child2, head.left);
				if(status==false)
					status=isSibling(child1, child2, head.right);
			}
		}
		return status;
	}
	public boolean isCousin(BinTree cousin1,BinTree cousin2,BinTree head) {
		boolean status=false;
		int level_csn1=0;
		int level_csn2=0;
		level_csn1=nodeLevel(cousin1);
		level_csn2=nodeLevel(cousin2);
		if(isSibling(cousin1, cousin2, head)==false && level_csn1==level_csn2)
			status=true;
		return status;
		
	}
	private int nodeLevel(BinTree head) {
		int level=0;
		if(head!=null) {
			if(head.left!=null || head.right!=null)
				level=Math.max(nodeLevel(head.left), nodeLevel(head.right))+1;
		}
		return level;
	}
	
	public int totalValue(BinTree head) {
		int sum=0;
		if(head!=null) {	
		if(head.left!=null)
		{
			sum+=totalValue(head.left);
		}

		if(head.right!=null)	
		{
			sum+=totalValue(head.right);
		}
		
			sum+=head.value;
	}
		return sum;
	}
	
		
}
