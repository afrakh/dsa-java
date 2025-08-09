import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class biPartiteGraph {
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
                    0
                 /     \
                1       2
                 \     /
                  3 -  4

         */

         for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));

        // graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 2, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[2].add(new Edge(2, 0, 1));
    }

    public static boolean isBiPartite(ArrayList<Edge> graph[]){
        int color[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++){
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++){
            if (color[i] == -1){ //BFS
                q.add(i);
                color[i] = 0; //yellow

                while (!q.isEmpty()){
                   int curr = q.remove();

                   for (int j = 0; j < graph[curr].size(); j++){
                    Edge e = graph[curr].get(j);
                
                    if (color[e.dest] == -1){
                        int newColor = color[curr] == 0 ? 1: 0;
                        color[e.dest] = newColor;
                        q.add(e.dest);
                    } else if (color[e.dest] == color[curr]){
                        return false; //not bipartite
                    }
                }

            }
            }
        }
        return true;
    }

    
    

    public static void main(String[] args) {
    int V = 7;

    @SuppressWarnings("unchecked")
    ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V]; //null -> empty ArrayList
    createGraph(graph);
    System.out.print(isBiPartite(graph));

    }
    
}
    
