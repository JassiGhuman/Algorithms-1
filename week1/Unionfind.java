package week1;

public class Unionfind {
	
	private int[] id;
	private int[] size;
	public Unionfind(int n) {
		id=new int[n];
		size=new int[n];
		for(int i=0;i<n;i++) {
			id[i]=i;
			size[i]=1;
		}
	}
	private int root(int i) {
		while(i!=id[i]) {
			id[i]=id[id[i]];
			i=id[i];
		}
		return i;
	}
	public boolean connected(int p,int q) {
		if(root(p)==root(q))
			return true;
		return false;
	}
	public void union(int p,int q) {
		int i=root(p);
		int j=root(q);
		if(size[i]>size[j])
		{
			id[j]=i;
			size[i]+=size[j];
		}
		else
		{
			id[i]=j;
			size[j]+=size[i];
		}
	}
	public void display() {
		for(int i=0;i<id.length;i++)
			System.out.print(id[i]+" ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unionfind uf=new Unionfind(8);
		uf.display();
		uf.union(1, 2);
		uf.union(5, 1);
		uf.union(3, 2);
		uf.union(2, 4);
		
		uf.union(6, 7);
		System.out.println(uf.connected(1,2));
		uf.display();
		 
	}

}
