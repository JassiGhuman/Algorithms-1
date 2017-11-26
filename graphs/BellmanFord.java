package graphs;

import java.util.ArrayList;

class Edge{
	public int src;
	public int dest;
	public int weight;
	public Edge(int src,int dest,int weight) {
		this.src=src;
		this.dest=dest;
		this.weight=weight;
	}
}
public class BellmanFord {
	public ArrayList<Edge>edges=new ArrayList<>();
	public int vertices;
	public BellmanFord(int v) {
		// TODO Auto-generated constructor stub
		vertices=v;
	}
	public void bellman(int src) {
		int d[]=new int[vertices];
		for(Edge e: edges) {
			int u=e.src;
			int v=e.dest;
			if(u==src)
				d[v]=e.weight;
		}
		for(int i=0;i<d.length;i++) {
			if(i==src) {
				d[i]=0;
			}
			else if(d[i]==0) {
				d[i]=Integer.MAX_VALUE;
			}
			
		}
		for(int k=2;k<vertices;k++) {
			for(Edge e: edges) {
				int u=e.src;
				int v=e.dest;
				if(d[u]!=Integer.MAX_VALUE &&  d[v]>d[u]+e.weight) {
					d[v]=d[u]+e.weight;
				}
			}
		}
		for(int i : d ) {													//print shortest distances from source to each vertex
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Edge e1=new Edge(0, 1,-1);
		Edge e2=new Edge(0, 2,4);
		Edge e3=new Edge(1, 2,3);
		Edge e4=new Edge(1,3,2);
		Edge e5=new Edge(1,4,2);
		Edge e6=new Edge(3,2,5);
		Edge e7=new Edge(3,1,1);
		Edge e8=new Edge(4,3,-3);
		BellmanFord bf =new BellmanFord(5);
		bf.edges.add(e1);
		bf.edges.add(e2);
		bf.edges.add(e3);
		bf.edges.add(e4);
		bf.edges.add(e5);
		bf.edges.add(e6);
		bf.edges.add(e7);
		bf.edges.add(e8);
		bf.bellman(0);
	}
	

}
