package com.lala.example.spoj.dfs;

import java.util.*;

public class MazeShortestPathDijkstra {
    static int[][] maze = {
            {1, 3, 1, 2},
            {2, 1, 5, 3},
            {4, 2, 1, 1},
            {3, 2, 2, 1}
    };
    static int n = 4, m = 4;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Cell {
        int x, y, dist;
        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static List<Cell> dijkstra() {
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        Cell[][] parent = new Cell[n][m];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.dist));

        dist[0][0] = maze[0][0];
        pq.add(new Cell(0, 0, maze[0][0]));

        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            int x = cur.x, y = cur.y;

            if (x == n - 1 && y == m - 1) {
                return reconstructPath(parent, new Cell(x, y, dist[x][y]));
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int newDist = dist[x][y] + maze[nx][ny];
                    if (newDist < dist[nx][ny]) {
                        dist[nx][ny] = newDist;
                        parent[nx][ny] = cur;
                        pq.add(new Cell(nx, ny, newDist));
                    }
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
        List<Cell> path = dijkstra();

        if (path.isEmpty()) {
            System.out.println("Không tìm thấy đường đi.");
        } else {
            System.out.println("Đường đi ngắn nhất (theo trọng số):");
            int totalCost = 0;
            for (Cell c : path) {
                totalCost += maze[c.x][c.y];
                System.out.print("(" + c.x + "," + c.y + ") ");
            }
            System.out.println("\nTổng chi phí: " + totalCost);
        }
    }
}

