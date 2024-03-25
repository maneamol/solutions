package graph;

import java.util.ArrayList;
import java.util.List;

public class NonCyclicGraphCycle {
/*
Check for
1. child node is not visited
2. child node is not parent
 */
    public boolean checkNonDirectedCycle(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i< n; i++) graph[i] = new ArrayList<>();

        for (int[] e: edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        for (int i =0; i < n; i++) {
            System.out.print(i + " ");
            for (int k: graph[i]) {
                System.out.print(k + " ");
            }
            System.out.println();
        }


        boolean[] visited = new boolean[n];

        for (int i =0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, -1, visited)) {
                    System.out.println("Cyle detected");
                    return true;
                }
            }
        }

        return false;
    }

    // check cycle using dfs
    private boolean dfs(List<Integer>[] graph, int src, int parent, boolean[] visited) {
        visited[src] = true;

        // for (int i = 0; i < graph[src].size(); i++) {
        for (int i: graph[src]) {
            if (!visited[i]) {
                if (dfs(graph, i, src, visited)) {
                    System.out.println("Cyle detected for src = " + src + " i = " + i);
                    return true;
                }
            } else if (i != parent) {
                System.out.println("Cyle detected for src = " + src + " i = " + i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NonCyclicGraphCycle graphCycle = new NonCyclicGraphCycle();
        // non cyclic graph
        // https://leetcode.com/problems/graph-valid-tree/
        int[][] graph1 =  {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(graphCycle.checkNonDirectedCycle(5, graph1));

        // cyclic graph
        int[][] graph2 =  {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println(graphCycle.checkNonDirectedCycle(5, graph2));
    }
}
