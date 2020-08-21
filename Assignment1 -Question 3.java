class solution{
	static void getPath(int graph[][] ,int v , int e , int src){
		
		int []dis = new int[v];
		for(int i=0 ;i<v ;i++){
			dis[i] = Integer.MAX_VALUE;
		}
		dis[src]  = 0;
		
		for(int i=0; i<v-1; i++){
			for(int j = 0; j<e; j++){
				if(dis[graph[j][0]] + graph[j][2] < dis[graph[j][1]])
					dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2];
			}
		}
		
		for (int i=0;i<e;i++){
			int x = graph[i][0];
			int y = graph[i][1];
			int weight = graph[i][2];
			if(dis[x] != Integer.MAX_VALUE && dis[x] + weight < dis[y])
				System.out.println("Graph contains negetive " + "weight cycle");
		}
		
		System.out.println("Vertex Distance from Source");
		for(int i=0 ; i<v;i++){
			System.out.println(i + "\t\t" + dis[i]);
		}
		
	}

	public static void main(String[] args){
		int vertexes = 5;
		int edges = 8;
		int graph[][] = { {0,1,-2} , {0,2,3} , {1,2,3} , {1,3,4} , {1,4,1} ,{3,2,6} , {3,1,1} , {4,3,-3} } ;

		getPath(graph ,vertexes ,edges ,0);
	}

}






