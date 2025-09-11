package com.lala.example.spoj.dfs;

import java.util.*;

public class GraphAllPathsDFS {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static List<Integer> path = new ArrayList<>();
    static int count = 0;

    public static void dfs(int u, int dest) {
        visited[u] = true;
        path.add(u);

        if (u == dest) {
            count++;
            printPath();
        } else {
            for (int v : adjList.get(u)) {
                if (!visited[v]) {
                    dfs(v, dest);
                }
            }
        }

        // backtrack
        visited[u] = false;
        path.remove(path.size() - 1);
    }

    public static void printPath() {
        System.out.print("Đường đi #" + count + ": ");
        for (int node : path) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5; // số đỉnh (0..4)
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        // Thêm cạnh (đồ thị vô hướng)
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(3);
        adjList.get(3).add(4);

        visited = new boolean[n];

        int start = 0, end = 4;
        System.out.println("Tất cả các đường đi từ " + start + " đến " + end + ":");
        dfs(start, end);

        if (count == 0) {
            System.out.println("Không có đường đi.");
        } else {
            System.out.println("Tổng số đường đi tìm được: " + count);
        }
    }
}

