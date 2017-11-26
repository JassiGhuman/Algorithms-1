package graphs;

import java.util.Arrays;
import java.util.LinkedList;



class Node {
	int data;
	int distance;
	Node prev;
	public int t_discovery;
	public int t_finished;
	int visited;
	int index_heap;//for decrease key
	Node(int x){
		data=x;
		distance=Integer.MAX_VALUE;
		visited=0;						//0 for unvisited 	1 for still being in heap  2. for getting deleted permanently
		t_discovery=0;
		t_finished=Integer.MAX_VALUE;
	}
}
class Min_heap {
	Node heap[];
	int capacity;
	int size;
	public Min_heap(int cap) {
		// TODO Auto-generated constructor stub
		capacity=cap;
		size=0;
		heap=new Node [capacity];
	}
	public Node get_min() {
		if(size==0) {
			System.out.println("Heap empty");
			return null;
		}
		else
			return heap[0];
	}
	
	public void insert(Node k) {
		if(size==capacity) {
			System.out.println("Overflow");
		}
		
		int i=size++;
		heap[i]=k;
		int parent=(i-1)/2;
		while(i!=0 && heap[parent].distance>heap[i].distance) {
			Node temp=heap[parent];
			heap[parent]=heap[i];
			heap[i]=temp;
			heap[i].index_heap=i;
			heap[parent].index_heap=parent;
			i=parent;
			parent=(i-1)/2;
			
		}
		
	}
	public Node delete_min() {
		if(size==0) {
			System.out.println("Heap empty");
			return null;
		}
		else {
			Node min=heap[0];
			heap[0]=heap[size-1];
			heap[0].index_heap=0;
			size--;
			heapify(0);
			return min;
		}
	}
	public void heapify(int i) {
		int l=2*i+1;
		int r=2*i+2;
		int smallest=i;
		if(l<size && heap[i].distance>heap[l].distance) {
			smallest=l;
		}
		if(r<size && heap[smallest].distance>heap[r].distance) {
			smallest=r;
			
		}
		if(smallest!=i) {
			Node temp=heap[smallest];
			heap[smallest]=heap[i];
			heap[i]=temp;
			heap[smallest].index_heap=smallest;
			heap[i].index_heap=i;
			heapify(smallest);
			
		}
	}
	public void decrease_key(int index,Node n) {
		int parent=(index-1)/2;
		
		while(index!=0 && heap[index].distance<heap[parent].distance) {
			Node temp=heap[parent];
			heap[parent]=heap[index];
			heap[index]=temp;
			heap[index].index_heap=index;
			heap[parent].index_heap=parent;
			index=parent;
			parent=(index-1)/2;
		}
	}

}

class Graph{
	public LinkedList<Node> edges[];
	public LinkedList<Integer>distance[];
	public Integer vertices;
	Graph(int vertices){
		this.vertices=vertices;
		edges=new LinkedList[vertices];
		distance=new LinkedList[vertices];
		for(int i=0;i<vertices;i++) {
			edges[i]=new LinkedList<>();
			distance[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(Node u,Node v,int d) {
		if(u!=v) {
			edges[u.data].add(v);
			distance[u.data].add(d);
			
			//for directed
			edges[v.data].add(u);
			distance[v.data].add(d);

		}
	}
	
}
public class Dijkstra {
	Graph graph;
	public Dijkstra(Graph g)  {
		this.graph=g;
	}
	public void dijkstra(Node source,Node dest) {
		int n=graph.vertices;
		
		source.distance=0;
		Node u=source;
		Min_heap heap=new Min_heap(n);
		int result[]=new int[graph.vertices];
        Arrays.fill(result,-1);
		heap.insert(u);
		u.visited=1;
		u.prev=u;
		
		while(heap.size!=0) {
			int i=0;
			int size=graph.edges[u.data].size();
			while(i<size) {
				
				Node v=graph.edges[u.data].get(i);
				if(v.distance>u.distance + graph.distance[u.data].get(i)) {
					v.distance=u.distance + graph.distance[u.data].get(i);
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
				result[v.data]=v.distance;
				i++;
			}
			System.out.println("size"+heap.size);
			heap.get_min().visited=2;
			result[u.data]=u.distance;
			heap.delete_min();			//distance or prev doesnt get update
			u=heap.get_min();
		}
        for(int i:result){
		//  if(i!=source.data)
            System.out.println(i);
        }
		System.out.println(dest.distance);
		printPath(dest);
	}
	public void printPath( Node n) {
		String result="";
		result+=n.data;
		n=n.prev;
		while(n.prev!=n ) {
			result=n.data+" --> "+result;
			n=n.prev;
		}
		System.out.println(n.data+" --> "+result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(4);
		Node node0=new Node(0);
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		g.addEdge( node0, node1,24);
        g.addEdge(node1, node2,3);
        g.addEdge(node2, node3,12);
        g.addEdge(node1, node3,20);
//        g.addEdge(node4, node1,2);
//        g.addEdge(node4, node2,1);
//        g.addEdge(node3, node4,4);
        Dijkstra dj=new Dijkstra(g);
        dj.dijkstra(node0, node3);
	}

}
