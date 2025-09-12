package com.lala.algorithm.dijkstra;

import java.util.*;

//             (A)
//            /   \
//            4     2
//           /       \
//          (B)---5---(C)
//           |  \       |
//           1   6      8
//           |     \    |
//          (D)---3---(E)

public class DijkstraExample {
    static class Edge {
        int to, weight;

        Edge(int t, int w) {
            to = t;
            weight = w;
        }
    }

    public static void main(String[] args) {
        int n = 5; // số đỉnh: A=0, B=1, C=2, D=3, E=4
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // thêm cạnh (undirected graph)
        graph.get(0).add(new Edge(1, 4));
        graph.get(1).add(new Edge(0, 4));
        graph.get(0).add(new Edge(2, 2));
        graph.get(2).add(new Edge(0, 2));
        graph.get(1).add(new Edge(2, 5));
        graph.get(2).add(new Edge(1, 5));
        graph.get(1).add(new Edge(3, 1));
        graph.get(3).add(new Edge(1, 1));
        graph.get(1).add(new Edge(4, 6));
        graph.get(4).add(new Edge(1, 6));
        graph.get(2).add(new Edge(4, 8));
        graph.get(4).add(new Edge(2, 8));
        graph.get(3).add(new Edge(4, 3));
        graph.get(4).add(new Edge(3, 3));

        int[] dist = dijkstra(graph, 0); // bắt đầu từ A (0)
        for (int i = 0; i < n; i++) {
            System.out.println("Khoảng cách từ A đến " + (char) ('A' + i) + " = " + dist[i]);
        }
    }

    static int[] dijkstra(List<List<Edge>> graph, int src) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist[u]) continue;

            for (Edge e : graph.get(u)) {
                int v = e.to;
                int newDist = dist[u] + e.weight;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[]{v, newDist});
                }
            }
        }
        return dist;
    }
}

