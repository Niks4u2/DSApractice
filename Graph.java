import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph 
{	
	int V;
	int E;
	LinkedList<Integer>[] adj; //adjacency list representation
	
	Graph(int nodes) 
	{
		this.V = nodes+1;
		this.E = 0;
		this.adj = new LinkedList[V];
		
		for(int i = 0; i < V; i++) 
		{
			this.adj[i] = new LinkedList<Integer>();
		}	
	}
	
	public void addEdge(int u, int v) 
	{
		this.adj[u].add(v);
		this.adj[v].add(u);
		E++;
	}
	
	public void display() 
	{
		System.out.println(V + " vertices " + E + " edges" );
		for(int i = 0; i < adj.length; i++) 
		{
			System.out.print((i) + ": ");
			for(int j : adj[i]) 
			{
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	public void bfs(int source) 
	{
		boolean[] visited = new boolean[V];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visited[source] = true;
		queue.offer(source);
		
		while(!queue.isEmpty()) 
		{
			int u = queue.poll();
			System.out.print(u + " ");
			for(int i : adj[u]) 
			{
				if(!visited[i]) 
				{
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	
	public void dfs(int source) 
	{
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(source);
		
		while(!stack.isEmpty()) 
		{
			int u = stack.pop();
			if(!visited[u]) 
			{
				visited[u] = true;
				System.out.print(u + " ");
				for(int i : adj[u]) 
				{
					if(!visited[i]) 
					{
						stack.push(i);
					}
				}
			}
		}
	}
	
	public boolean isCycle(int V)
	{
		boolean[] visited = new boolean[V+1];
		
		for(int i = 1; i <= V; i++)
		{
			if(!visited[i])
				return checkForCycle(adj, i, visited);
		}
		return false;
	}
	
	class GNode
	{
		int first;
		int second;
		
		GNode(int first, int second)
		{
			this.first=first;
			this.second=second;
		}
	}
	
	public boolean checkForCycle(LinkedList<Integer>[] adj, int s, boolean[] visited)
	{
		Queue<GNode> queue = new LinkedList<GNode>();
		
		queue.offer(new GNode(s, -1));
		visited[s] = true;

		while(!queue.isEmpty()) 
		{
			int node = queue.peek().first;
			int parent = queue.peek().second;
			queue.poll();
			
			for(int i : adj[node]) 
			{
				if(!visited[i]) 
				{
					visited[i] = true;
					queue.offer(new GNode(i, node));
				}
				else if(i != parent)
					return true;
			}
		}
		return false;
	}
	
	public void shortestDistance(int source)
	{
		Integer[] distance = new Integer[V-1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		distance[source] = 0;
		queue.offer(source);
		
		while(!queue.isEmpty()) 
		{
			int u = queue.poll();
			
			for(int i : adj[u]) 
			{
				if(distance[u] + 1 < distance[i]) 
				{
					distance[i] = distance[u] + 1;
					queue.offer(i);
				}
			}
		}
		for(int d:distance)
			System.out.print(d+" ");
	}

	public static void main(String[] args) 
	{
		Graph g = new Graph(5);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 1);
		
		g.display();
		
		g.bfs(1);
		System.out.println();
		g.dfs(1);
		
		System.out.println(g.isCycle(4));
		
		g.shortestDistance(0);
	}
}
