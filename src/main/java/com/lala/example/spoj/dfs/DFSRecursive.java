package com.lala.example.spoj.dfs;

import java.util.*;

public class DFSRecursive {
    private static List<List<Integer>> adjList;
    private static boolean[] visited;

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " "); // xử lý node

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // số đỉnh (0..4)
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        // Thêm cạnh (undirected graph)
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(1).add(4);

        visited = new boolean[n];

        System.out.println("DFS từ đỉnh 0:");
        dfs(0);
    }
}

