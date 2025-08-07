import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class traverseDisconnectedComponents{
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

    public static void dfs(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++){
            if (!visited[i]){
                dfsUtil(graph, visited, i);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, boolean visited[], int curr){
        System.out.print(curr + " ");
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if (!visited[e.dest]){
                dfsUtil(graph, visited, e.dest);
            }
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++){
            if (!visited[i]){
                bfsUtil(graph, visited, i);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean visited[], int src){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while (!q.isEmpty()){
            int curr = q.remove();

            if (!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            } 
        }
    }

}