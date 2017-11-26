package graphs;

public class Prims {
	Graph graph;
	public Prims(Graph g) {
		graph=g;
	}
	public int prim_mst(Node source) {
		int n=graph.vertices;
		Node u=source;
		source.distance=0;
		int dist=0;
		Min_heap heap=new Min_heap(n);
		heap.insert(u);
		u.visited=1;
		u.prev=u;
		while(heap.size!=0) {
			int i=0;
			int size=graph.edges[u.data].size();
			while(i<size) {
				
				Node v=graph.edges[u.data].get(i);
				if(v.distance>graph.distance[u.data].get(i)) {
					v.distance=graph.distance[u.data].get(i);
//					v.prev=u;	
					if(v.visited==1) {
						v.prev=u;
						heap.decrease_key(v.index_heap, v);
						//v.distance=Math.min(v.distance,v.prev.distance + graph.distance[u.data].get(i));
					}
					if(v.visited==0) {
							v.prev=u;
						//	v.distance=Math.min(v.distance,v.prev.distance + graph.distance[u.data].get(i));
							heap.insert(v);
							v.visited=1;
					}
					
				}
				i++;
			}
			heap.get_min().visited=2;
			if(heap.get_min()!=source) {
				System.out.println(heap.get_min().prev.data+"-"+heap.get_min().data);
			}
			dist+=heap.get_min().distance;
			u=heap.delete_min();			//distance or prev doesnt get update
			
		}
		 
		System.out.println(dist);
//		printPath(dest);
		return dist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(9);
		Node node0=new Node(0);
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		Node node6=new Node(6);
		Node node7=new Node(7);
		Node node8=new Node(8);
		Node node9=new Node(9);
		g.addEdge(node0, node1,4);
        g.addEdge(node0, node7,8);
        g.addEdge(node1, node2,8);
        g.addEdge(node1, node7,11);
        g.addEdge(node2, node3,7);
        g.addEdge(node2, node8,2);
        g.addEdge(node2, node5,4);
        g.addEdge(node3, node4,9);
        g.addEdge(node3, node5,14);
        g.addEdge(node4, node5,10);
        g.addEdge(node5, node6,2);
        g.addEdge(node6, node7,1);
        g.addEdge(node6, node8,6);
        g.addEdge(node7, node8,7);	
        Prims p=new Prims(g);
        p.prim_mst(node0);
	}

}
