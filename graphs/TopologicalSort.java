import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
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

    public static void topoSorting(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++){
            if (!visited[i]){
                topoSortingUtil(graph, s, i, visited);
            }
        }

        while (!s.empty()){
            System.out.print(s.pop() + " ");
        }

    }

    public static void topoSortingUtil(ArrayList<Edge> graph[], Stack<Integer> stack, int curr, boolean visited[]){
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if (!visited[e.dest]){
                topoSortingUtil(graph, stack, e.dest, visited);
            }
        }

        stack.add(curr);
    }

    public static void main(String[] args) {
        int V = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V]; //null -> empty ArrayList
        createGraph(graph);

        topoSorting(graph);
        
    }
}
