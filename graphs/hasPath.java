import java.util.ArrayList;

public class hasPath {
    public static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        /*
                    1 --------3       
                  /           |  \     
                0             |   5 ----6
                  \           |  /         
                    2 --------4  
         
         */

         for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
         }

         graph[0].add(new Edge(0, 1, 1));
         graph[0].add(new Edge(0, 2, 1));

         graph[1].add(new Edge(1, 0,1));
         graph[1].add(new Edge(1, 3, 1));

         graph[2].add(new Edge(2, 0, 1));
         graph[2].add(new Edge(2, 4, 1));

         graph[3].add(new Edge(3, 4, 1));
         graph[3].add(new Edge(3, 1, 1));
         graph[3].add(new Edge(3, 5, 1));

         graph[4].add(new Edge(4, 2, 1));
         graph[4].add(new Edge(4, 5, 1));
         graph[4].add(new Edge(4, 5, 1));

         graph[5].add(new Edge(5, 3, 1));
         graph[5].add(new Edge(5, 4, 1));
         graph[5].add(new Edge(5, 6, 1));

         graph[6].add(new Edge(6, 5, 1));


    }

    public static boolean hasPathCheck(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]){
        if (src == dest) {
            return true;
        } else {
            visited[src] = true;
            for (int i = 0; i < graph[src].size(); i++){
                Edge e = graph[src].get(i);
                
                //e.dest => neighbour

                if (!visited[e.dest] && hasPathCheck(graph, e.dest, dest, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V]; //null -> empty ArrayList
        createGraph(graph);

        System.out.print(hasPathCheck(graph, 0, 5, new boolean[V]));
    }
}
