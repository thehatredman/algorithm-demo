package com.lala.example.spoj.dfs;

import java.util.*;

public class MazeDFSPath {
    static int[][] maze = {
            {0, 0, 1, 0},
            {1, 0, 1, 0},
            {0, 0, 0, 0},
            {1, 1, 1, 0}
    };
    static boolean[][] visited;
    static int n = 4, m = 4;
    static int[] dx = {1, -1, 0, 0}; // 4 hướng di chuyển
    static int[] dy = {0, 0, 1, -1};
    static List<int[]> path = new ArrayList<>();
    static boolean found = false;

    public static void dfs(int x, int y) {
        if (found) return; // nếu đã tìm thấy thì dừng

        visited[x][y] = true;
        path.add(new int[]{x, y}); // lưu lại bước đi

        if (x == n - 1 && y == m - 1) { // đến đích
            found = true;
            printPath();
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                    maze[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }

        // backtrack: nếu không đi tiếp được thì xoá bước này
        if (!found) {
            path.remove(path.size() - 1);
        }
    }

    public static void printPath() {
        System.out.println("Đường đi tìm được:");
        for (int[] p : path) {
            System.out.println("(" + p[0] + ", " + p[1] + ")");
        }
    }

    public static void main(String[] args) {
        visited = new boolean[n][m];
        dfs(0, 0);

        if (!found) {
            System.out.println("Không tìm thấy đường đi.");
        }
    }
}

