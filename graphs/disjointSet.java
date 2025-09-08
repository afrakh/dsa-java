public class disjointSet {
    public static int find(int x, int par[]){
        if (par[x] == x){
            return x;
        }
        return par[x] = find(par[x], par);  // Path compression
    }

    public static void union(int par[], int rank[], int a, int b){
        int pa = find(a, par); // root of a
        int pb = find(b, par); // root of b

        if (pa == pb) return; // already in the same set

        if (rank[pa] == rank[pb]) {
            par[pb] = pa;
            rank[pa]++;
        } else if (rank[pa] < rank[pb]) {
            par[pa] = pb;
        } else {
            par[pb] = pa;
        }
    }
    public static void main(String args[]){
        int n = 8;
        int par[] = new int[n];
        int rank[] = new int[n];

        for (int i = 0; i < n; i++){
            par[i] = i;
        }

        System.out.println(find(3, par));
        union(par, rank, 1, 3);
        System.out.println(find(3, par));
        System.out.println(find(4, par));
        union(par, rank, 2, 4);
        System.out.println(find(4, par));
        union(par, rank, 3,6);
        union(par, rank, 1,4);
        System.out.println(find(3, par));
        union(par, rank, 1, 5);
    }

}
