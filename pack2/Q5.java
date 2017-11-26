package pack2;

public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinTree b4=new BinTree(null,null,"Chris Evans");
		BinTree b5=new BinTree(null,null,"Scarlet Johannson");
		BinTree b6=new BinTree(null,null,"Johnny Depp");
		
		BinTree b8=new BinTree(null,null,"Leonardo DiCaprio");
		BinTree b7=new BinTree(b8,null,"Leonardo DiCaprio");
		BinTree b2=new BinTree(b4,b6,"Salman");
		BinTree b3=new BinTree(b5,b7,"Shahrukh");
		BinTree b1=new BinTree(b2,b3,"Amitabh");

		System.out.println(b1.find(b1,"Amitabh"));
		System.out.println(b1.numberOfNodes(b1));
		System.out.println(b1.isDescendent(b7, b1));
		System.out.println(b1.isSibling(b4, b6, b1));
		System.out.println(b1.isCousin(b7, b5, b1));
	///	System.out.println(b1.findPath(b1, b8));
		System.out.println(b1.commonAncestor(b7, b5, b1));
	}

}

class BinTree{
	public BinTree left;
	public BinTree right;
	public String name;
	String []path=new String[100];
	int p=0;
	BinTree(BinTree left,BinTree right,String name)
	{
		this.left=left;
		this.right=right;
		this.name=name;
	}
	public String find(BinTree head,String val) {
		String s="NO match found";
		if(val==head.name) {
			s=val+" is present";
			return s;
		}
		else if(val!=name) {
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
	public String commonAncestor(BinTree t1,BinTree t2,BinTree head) {
		String path1=findPath(head,t1);
		String path2=findPath(head,t2);
		System.out.println(path1+path2);
		int size=0;
		String ancestor="";
		if(path1.length()>path2.length())
			size=path1.length();
		else
			size=path2.length();
		for(int i=0;i<size;i++) {
			if(path1.charAt(i)==path2.charAt(i))
				ancestor=""+path1.charAt(i)+path1.charAt(i+1);
			else {
				break;
			}
			i++;
			
		}
		if(ancestor=="") {
			ancestor="node";
		}
		return ancestor;
	}
	
	
	
	public String findPath(BinTree head,BinTree node) {
	String a="";
	String temp="";
	if(head==null) {
		return "";
	}
	if(head==node) {
		return "found";
	}
	if(head.left != null) {
		a="L"+nodeLevel(head.left);
		temp=a;
		a+=findPath(head.left, node);
		
	}
	if(a.matches("[0-9LR]*found") ){
		return a;
	}
	if(head.right!=null) {
		a="R"+nodeLevel(head.right);
		
		a+=findPath(head.right, node);
	}
	if(a.matches("[0-9LR]*found") ){
		return a;
	}
	else
		return "not found";
	
	
	}
}