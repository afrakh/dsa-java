import java.util.ArrayList;
import java.util.Stack;

public class kosarajuAlgorithm {
    public static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topologicalSort(int curr, boolean[] visited, ArrayList<Edge>[] graph, Stack<Integer> s){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]){
                topologicalSort(e.dest, visited, graph, s);
            }
        }
        s.add(curr);
    }

    public static void transposeGraph(ArrayList<Edge>[] graphT, ArrayList<Edge>[] graph){
        
        for (int i = 0; i < graphT.length; i++){
            graphT[i] = new ArrayList<>();
        }

        for (int i = 0; i < graph.length; i++){
            for (int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                graphT[e.dest].add(new Edge(e.dest, e.src));
            }
        }
    }

    // DFS utility to print SCC
    public static void dfsUtil(ArrayList<Edge>[] graphT, int curr, boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");
        for (Edge e : graphT[curr]) {
            if (!visited[e.dest]) {
                dfsUtil(graphT, e.dest, visited);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph, int V){
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];

        // 1st DFS (topological sort)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, graph, s);
            }
        }

        // Transpose graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graphT = (ArrayList<Edge>[]) new ArrayList[V];
        transposeGraph(graphT, graph);

        // Reset visited
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // 2nd DFS (on transposed graph)
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!visited[curr]) {
                dfsUtil(graphT, curr, visited);
                System.out.println();  // each SCC on new line
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V]; //null -> empty ArrayList
        createGraph(graph);
        kosaraju(graph, V);

    }
}
