package otherProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class ReduntantConnection2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return null;
        }
        int[] c1 = new int[]{0, 0};
        int[] c2 = new int[]{0, 0};
        int[] parent = new int[edges.length + 1];
        for (int[] e : edges) {
            if (parent[e[1]] != 0) {
                c1 = new int[]{parent[e[1]], e[1]};
                c2 = new int[]{e[0], e[1]};
                break;
            }
            parent[e[1]] = e[0];
        }

        UnionFind uf = new UnionFind(edges.length);
        for (int[] e : edges) {

            if ((e[0] == c1[0] && e[1] == c1[1]) || (e[0] == c2[0] && e[1] == c2[1])) continue;
            if (!uf.union(e[0], e[1])) return e;
        }

        if (!uf.union(c1[0], c1[1])) return c1;
        return c2;
    }



    public static void main(String[] args) {
        ReduntantConnection2 reduntantConnection = new ReduntantConnection2();
        //[[2,1],[3,1],[4,2],[1,4]]

        int[] out = reduntantConnection.findRedundantDirectedConnection(new int[][]{{2, 1}, {3, 1}, {4, 2},{1,4}});
        System.out.println(out);

        String temp =  "SomeString";
        StringBuilder builder = new StringBuilder(temp);
        builder.replace(0,1 ,"0" );
        builder.insert(0,"rr" );
        builder.delete(3,4 );
        System.out.println(builder.toString());

        Random random = new Random();
        for (int i = 0;i<10;i++)
        System.out.println(random.nextInt(62));

        Queue<String> queue = new LinkedList<>();

    }
}
class UnionFind{
    int[] parent;
    int[] rank;
    UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;
        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else {
            parent[pb] = pa;
            if (rank[pa] == rank[pb]) {
                rank[pa]++;
            }
        }
        return true;
    }

    public int find(int a) {
        while (a != parent[a]) {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }
}
