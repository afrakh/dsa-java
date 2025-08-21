import java.util.ArrayList;

public class bellman {
    public static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.weight = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        for (int i = 0; i < graph.length; i++) {
        graph[i] = new ArrayList<>();   // initialize each ArrayList
    }
        /*
               (0)
               / \
            2 /   \ 4
             v     v
           (1)--_4->(2)
            |        |
        -1  |        | 2
            v        v
           (4)<--4--(3)

         */

         graph[0].add(new Edge(0, 1, 2)); 
         graph[0].add(new Edge(0, 2, 4)); 

         graph[1].add(new Edge(1, 2, -4)); 

         graph[2].add(new Edge(2, 3, 2)); 

         graph[3].add(new Edge(3, 4, 4)); 

         graph[4].add(new Edge(4, 1, -1)); 
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++){
            if (i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int vertices = graph.length;
        for (int i = 0; i < vertices - 1; i++){
            for (int j = 0; j < graph.length; j++){
                for (int k = 0; k < graph[j].size(); k++){
                    Edge e = graph[j].get(k);

                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
                
            }
        }

        boolean hasNegativeCycle = false;
        for (int j = 0; j < graph.length; j++) {
            for (int k = 0; k < graph[j].size(); k++) {
                Edge e = graph[j].get(k);

                int u = e.src;
                int v = e.dest;
                int wt = e.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    hasNegativeCycle = true;
                    break;
                }
            }
        }

        if (hasNegativeCycle) {
        System.out.println("Graph contains a NEGATIVE weight cycle!");
        } else {

        for (int i = 0; i < dist.length; i++){
            System.out.print(dist[i] + " ");
        }

        System.out.println();

    }
}

    public static void main(String args[]){
        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V]; //null -> empty ArrayList
        createGraph(graph);

        bellmanFord(graph, 0);

    }
}
