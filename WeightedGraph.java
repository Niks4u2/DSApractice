import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeightedGraph
{	
	int V;
	int E;
	ArrayList<ArrayList<Edge>> adj; //adjacency list representation
	
	WeightedGraph(int nodes) 
	{
		this.V = nodes+1;
		this.E = 0;
		this.adj = new ArrayList<ArrayList<Edge>>();
		
		for(int i = 0; i < V; i++) 
		{
			adj.add(new ArrayList<Edge>());
		}
	}
	
	class Edge implements Comparator<Edge>
	{
		int node;
		int weight;
		
		Edge(int node, int weight)
		{
			this.node = node;
			this.weight = weight;
		}
		
		Edge() {};
		
		int getNode() 
		{
			return node;
		}
		
		int getWeight() 
		{
			return weight;
		}

		@Override
		public int compare(Edge e1, Edge e2) {
			if(e1.weight < e2.weight)
				return -1;
			if(e1.weight > e2.weight)
				return 1;
			return 0;
		}
	}
	
	public void addEdge(int u, int v, int weight) 
	{
		adj.get(u).add(new Edge(v, weight));
		adj.get(v).add(new Edge(u, weight));
		E++;
	}	
	
	public void display() 
	{
		System.out.println(V + " vertices " + E + " edges" );
		for(int i = 1; i < adj.size(); i++) 
		{
			System.out.print((i) + ": ");
			for(Edge j : adj.get(i)) 
			{
				System.out.print("("+j.node+", "+j.weight+")");
			}
			System.out.println();
		}
	}
	
	public void dijkstra(int source)
	{
		Integer[] distance = new Integer[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		distance[source] = 0;
		queue.offer(source);
		
		while(!queue.isEmpty()) 
		{
			int u = queue.poll();
			
			for(Edge i : adj.get(u)) 
			{
				if((distance[u] + i.weight) < distance[i.node]) 
				{
					distance[i.node] = distance[u] + i.weight;
					queue.offer(i.node);
				}
			}
		}
		for(int d:distance)
			System.out.print(d+" ");
	}
	
	public void dijkstraPQ(int source)
	{
		Integer[] distance = new Integer[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		distance[source] = 0;
		pq.offer(source);
		
		while(!pq.isEmpty()) 
		{
			int u = pq.poll();
			
			for(Edge i : adj.get(u)) 
			{
				if((distance[u] + i.weight) < distance[i.node]) 
				{
					distance[i.node] = distance[u] + i.weight;
					pq.offer(i.node);
				}
			}
		}
		for(int d:distance)
			System.out.print(d+" ");
	}
	
	public void PrimsAlgo(int V)
	{
		Integer[] key = new Integer[V];
		Integer[] parent = new Integer[V];
		Boolean[] mstSet = new Boolean[V];

		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		Arrays.fill(mstSet, false);
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(V, new Edge());

		key[0]=0;
		pq.offer(new Edge(0, key[0]));
		
		for(int i = 0; i < V-1; i++)
		{
			int u = pq.poll().node;
			mstSet[u] = true;
			
			for(Edge it : adj.get(u))
			{
				if(mstSet[it.getNode()] == false && it.getWeight() < key[it.getNode()])
				{
					parent[it.getNode()] = u;
					key[it.getNode()] = it.getWeight();
					pq.offer(new Edge(it.getNode(), key[it.getNode()]));
				}
			}
		}
		
		for(int i = 1; i < V; i++)
		{
			System.out.println(parent[i]+" - "+i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeightedGraph wg = new WeightedGraph(4);
		
		wg.addEdge(0, 1, 4);
		wg.addEdge(1, 2, 5);
		wg.addEdge(2, 3, 6);
		wg.addEdge(3, 4, 7);
		wg.addEdge(4, 1, 3);
		
		wg.display();
		
		//wg.dijkstraPQ(0);
		
		wg.PrimsAlgo(5);

	}

}
