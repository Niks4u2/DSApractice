public class Graphs 
{
	int V;
	int E;
	int[][] adjMatrix; // adjacency matrix representation
	
	Graphs(int nodes) 
	{
		this.V = nodes;
		this.E = 0;
		this.adjMatrix = new int[nodes + 1][nodes + 1];
	}
	
	public void addEdge(int u, int v) 
	{
		this.adjMatrix[u][v] = 1;
		this.adjMatrix[v][u] = 1;
		E++;
	}
	
	public void display() 
	{
		System.out.println(V + " vertices " + E + " edges" );
		for(int i = 1; i < adjMatrix.length; i++) 
		{
			System.out.print((i) + ": ");
			for(int j = 1; j < adjMatrix.length; j++) 
			{
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) 
	{
		Graphs g = new Graphs(4);
		
		//g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 1);
		
		g.display();
				
	}
}
