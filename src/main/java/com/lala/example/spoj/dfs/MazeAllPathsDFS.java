package com.lala.example.spoj.dfs;

import java.util.*;

public class MazeAllPathsDFS {
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
    static int count = 0;

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        path.add(new int[]{x, y});

        if (x == n - 1 && y == m - 1) {
            count++;
            printPath();
        } else {
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        maze[nx][ny] == 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }

        // backtrack
        visited[x][y] = false;
        path.remove(path.size() - 1);
    }

    public static void printPath() {
        System.out.println("Đường đi #" + count + ":");
        for (int[] p : path) {
            System.out.print("(" + p[0] + "," + p[1] + ") ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        visited = new boolean[n][m];
        dfs(0, 0);

        if (count == 0) {
            System.out.println("Không tìm thấy đường đi nào.");
        } else {
            System.out.println("Tổng số đường đi tìm được: " + count);
        }
    }
}

