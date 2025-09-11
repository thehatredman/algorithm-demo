package com.lala.example.spoj.dfs;

import java.util.*;

public class GraphShortestPathBFS {
    static List<List<Integer>> adjList;

    public static List<Integer> bfsShortestPath(int start, int end, int n) {
        boolean[] visited = new boolean[n];
        int[] parent = new int[n]; // lưu cha để reconstruct đường đi
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (u == end) break;

            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.add(v);
                }
            }
        }

        // reconstruct đường đi
        List<Integer> path = new ArrayList<>();
        if (!visited[end]) return path; // không có đường đi

        for (int v = end; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int n = 6; // số đỉnh
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        // Thêm cạnh (undirected graph)
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(4).add(5);

        int start = 0, end = 5;
        List<Integer> path = bfsShortestPath(start, end, n);

        if (path.isEmpty()) {
            System.out.println("Không có đường đi từ " + start + " đến " + end);
        } else {
            System.out.println("Đường đi ngắn nhất từ " + start + " đến " + end + ": " + path);
            System.out.println("Độ dài: " + (path.size() - 1));
        }
    }
}

