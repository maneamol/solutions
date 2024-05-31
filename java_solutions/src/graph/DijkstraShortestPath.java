package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    int node;
    int distance;

    public Edge(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
class Pair {
    int destVertex;
    int distance;
    public Pair(int distance,int destVertex){
        this.destVertex = destVertex;
        this.distance = distance;
    }
}
public class DijkstraShortestPath {

    int[] dijkstra(int V, List<List<Edge>> adj, int S) {
        int[] dist = new int[V];
        for (int i = 0; i <V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);

        dist[S] =  0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().destVertex;
            pq.poll();

//            for (int i = 0; i < adj.size(); i++) {
            for (Edge e: adj.get(node)) {
                int edgeDistance = e.distance;
                int adjVertex = e.node;

                if (dis + edgeDistance < dist[adjVertex]) {
                    dist[adjVertex] = dis + edgeDistance;
                    pq.add(new Pair((dis + edgeDistance), adjVertex));
                }
            }


        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 3, E=3,S=2;
        Edge edgeZeroToOne = new Edge(1, 1);
        Edge edgeZeroToTwo = new Edge(2, 6);

        Edge edgeOneToZero = new Edge(0, 1);
        Edge edgeOneToTwo = new Edge(2, 3);

        Edge edgeTwoToZero = new Edge(0, 6);
        Edge edgeTwoToOne = new Edge(1, 3);
        List<List<Edge>> adj = new ArrayList<>();

        adj.add(List.of(edgeZeroToOne, edgeZeroToTwo));
        adj.add(List.of(edgeOneToZero, edgeOneToTwo));
        adj.add(List.of(edgeTwoToZero, edgeTwoToOne));

        DijkstraShortestPath obj= new DijkstraShortestPath();
        int[] res = obj.dijkstra(V, adj, S);
        for(int i=0;i<V;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
}
