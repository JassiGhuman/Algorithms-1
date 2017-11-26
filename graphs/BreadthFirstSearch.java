package graphs;

import java.util.LinkedList;

import a10.Queue;


class Graphs {
	public LinkedList<Integer> edges[];
	public Integer vertices;
	Graphs(int vertices){
		this.vertices=vertices;
		edges=new LinkedList[vertices];
		for(int i=0;i<vertices;i++)
			edges[i]=new LinkedList<>();
	}
	
	public void addEdge(int u,int v) {
		if(u!=v)
			edges[u].add(v);
	}
}
public class BreadthFirstSearch {
	Graphs graph;
	public BreadthFirstSearch(Graphs g) {
		this.graph=g;
	}
	public void BFS(int u) {
		Queue<Integer> nodes=new Queue<>(graph.vertices);
		boolean visited[]=new boolean[graph.vertices];
		
		int n=graph.vertices;
		int bfs[]=new int[n];
		int index=0;
		int count=0;
		while(count<n) {
			if(visited[u]==true) {
				for(int i=0;i<n;i++) {
					if(visited[i]==false) {
						u=i;
						nodes.enqueue(u);
						count++;
						bfs[index++]=u;
						visited[u]=true;
						break;
					}
				}
			}
			else {
				nodes.enqueue(u);
				count++;
				bfs[index++]=u;
				visited[u]=true;
			}
			while(!nodes.isEmpty()) {
				u=nodes.dequeue();
				
				int size=graph.edges[u].size();
				int i=0;
				int v=0;
				while(i<size) {
					v=graph.edges[u].get(i);
					if(visited[v]==false) {
						nodes.enqueue(v);
						bfs[index++]=v;
						visited[v]=true;
						count++;
					}
					i++;
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(bfs[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs g = new Graphs(5);
		g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(4, 2);
        g.addEdge(3, 4);
        BreadthFirstSearch bfs=new BreadthFirstSearch(g);
        bfs.BFS(0);
	}

}
