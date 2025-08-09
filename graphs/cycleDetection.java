import java.util.ArrayList;

public class cycleDetection {
    static class Edge{
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
                0 ------- 3
               /|         |
              / |         |
             1  |         4
              \ |
               \|
                2


         */
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
         }
         graph[0].add(new Edge(0, 1, 1));
        //  graph[0].add(new Edge(0, 2, 1));
         graph[0].add(new Edge(0, 3, 1));

         graph[1].add(new Edge(1, 0, 1));
         graph[1].add(new Edge(1, 2, 1));

         graph[2].add(new Edge(2, 1, 1));
        //  graph[2].add(new Edge(2, 0, 1));

         graph[3].add(new Edge(3, 0, 1));
         graph[3].add(new Edge(3, 4, 1));

         graph[4].add(new Edge(4, 3, 1));
        

    }

    public static boolean cycleDetect(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++){
            if (!visited[i]){
                if (cycleDetectUtil(graph, visited, i, -1)){
                    return true;
                }; 
            }
        }
        return false;
    }

    public static boolean cycleDetectUtil(ArrayList<Edge>[] graph, boolean visited[], int curr, int par){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]){
                if (cycleDetectUtil(graph, visited, e.dest, curr)){
                    return true;
                }
                }
            else if (visited[e.dest] && e.dest != par){
                return true;
            }
        }
        return false;

        
        }
    

    public static void main(String[] args) {
        int V = 7;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V]; //null -> empty ArrayList
        createGraph(graph);
        System.out.print(cycleDetect(graph));

    }
}
