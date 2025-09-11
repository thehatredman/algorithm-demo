package com.lala.example.spoj.dfs;

import java.util.*;

public class MazeShortestPathBFS {
    static int[][] maze = {
            {0, 0, 1, 0},
            {1, 0, 1, 0},
            {0, 0, 0, 0},
            {1, 1, 1, 0}
    };
    static int n = 4, m = 4;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Cell {
        int x, y;
        Cell(int x, int y) { this.x = x; this.y = y; }
    }

    public static List<Cell> bfsShortestPath() {
        boolean[][] visited = new boolean[n][m];
        Cell[][] parent = new Cell[n][m];

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            int x = cur.x, y = cur.y;

            if (x == n - 1 && y == m - 1) {
                return reconstructPath(parent, new Cell(x, y));
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        maze[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    parent[nx][ny] = cur;
                    queue.add(new Cell(nx, ny));
                }
            }
        }
        return new ArrayList<>(); // không có đường đi
    }

    public static List<Cell> reconstructPath(Cell[][] parent, Cell end) {
        List<Cell> path = new ArrayList<>();
        for (Cell at = end; at != null; at = parent[at.x][at.y]) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        List<Cell> path = bfsShortestPath();

        if (path.isEmpty()) {
            System.out.println("Không tìm thấy đường đi.");
        } else {
            System.out.println("Đường đi ngắn nhất:");
            for (Cell c : path) {
                System.out.print("(" + c.x + "," + c.y + ") ");
            }
            System.out.println("\nĐộ dài: " + (path.size() - 1));
        }
    }
}
