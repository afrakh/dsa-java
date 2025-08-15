import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSortBFS {
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

        public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        /*
                5 ------> 0 <------- 4
                |                    |
                |                    |
                |                    |
                v                    v
                2 ------> 3 -------> 1



         */

         graph[2].add(new Edge(2, 3, 1));
         graph[3].add(new Edge(3, 1, 1));

         
         graph[4].add(new Edge(4, 1, 1));
         
         graph[4].add(new Edge(4, 0, 1));
         
         graph[5].add(new Edge(5, 0, 1));
         
         graph[5].add(new Edge(5, 2, 1));
    }

    public static void indegree(ArrayList<Edge> graph[], int indeg[]){
        for (int i = 0; i < graph.length; i++){
            for (int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void topologicalSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        indegree(graph, indeg);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++){
            if (indeg[i] == 0){
                q.add(i);
            }
        }

        //bfs

        while (!q.isEmpty()){
            int curr = q.remove();

            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if (indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V]; //null -> empty ArrayList
        createGraph(graph);

        topologicalSort(graph);
        
    }
}
