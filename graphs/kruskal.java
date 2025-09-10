import java.util.ArrayList;
import java.util.Collections;

public class kruskal {
    public static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int wt){
            this.src = s;
            this.dest = d;
            this.weight = wt;
        }

        @Override
        public int compareTo(Edge e2){
            return this.weight - e2.weight;
        }
    }

    public static void createGraph(ArrayList<Edge> edges){
        // add edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(3, 2, 50));
        
    }

    static int V = 4;
    static int par[] = new int[V];
    static int rank[] = new int[V];

    public static void init(){
        for (int i = 0; i < V; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if (x == par[x]){
            return x;
        } else {
            return par[x] = find(par[x]);
        }
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]){
            rank[parB]++;
        }
        else if (rank[parA] < rank[parB]){
            par[parA] = parB;
        } else{
            par[parB] = parA;
        }
        
    }

    public static int kruskalMSTGreedy(ArrayList<Edge> edges){
        init();
        Collections.sort(edges);
        int minimumCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1; i++){
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
 
            if (parA != parB){
                union(e.src, e.dest);
                count++;
                minimumCost += e.weight;
            }
        }
        return minimumCost;
    }

    public static void main(String args[]){
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        System.out.println(kruskalMSTGreedy(edges));
    }
}
