package graphs;

import java.util.ArrayList;
import java.util.LinkedList;

class DFSGraphs {
	public LinkedList<Node> edges[];
	public Integer vertices;
	DFSGraphs(int vertices){
		this.vertices=vertices;
		edges=new LinkedList[vertices];
		for(int i=0;i<vertices;i++)
			edges[i]=new LinkedList<>();
	}
	
	public void addEdge(Node u,Node v) {
		if(u!=v)
			edges[u.data].add(v);
		
	}
}

public class DepthFirstSearch {
	public DFSGraphs graph;
	public static int time=0;
	public DepthFirstSearch(DFSGraphs g) {
		graph=g;
	}
	public void dfs(Node n) {
		n.t_discovery=time++;
		n.visited=1;
		int size=graph.edges[n.data].size();
		int count=0;
		for(;count<size;count++) {
			Node v=graph.edges[n.data].get(count);
			if(v.visited==0) {
				dfs(v);
				
			}
		}
		n.t_finished=time++;
		System.out.println(n.data+" "+n.t_discovery+" "+n.t_finished);
	}
	public static void main(String[] args) {
		DFSGraphs g = new DFSGraphs(5);
		Node node0=new Node(0);
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);

		g.addEdge(node0, node1);
        g.addEdge(node0, node3);
        g.addEdge(node1, node2);
        g.addEdge(node1, node3);
        g.addEdge(node4, node1);
        g.addEdge(node4, node2);
        g.addEdge(node3, node4);
        DepthFirstSearch dfs= new DepthFirstSearch(g);
        dfs.dfs(node0);
	}
}
