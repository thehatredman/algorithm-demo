package com.lala.example.spoj.dfs;

import java.util.*;

class Node implements Comparable<Node> {
    int row, col;
    int gCost; // chi phí từ start đến node này
    int hCost; // heuristic (ước lượng từ node này -> đích)
    int fCost; // tổng chi phí: g + h
    Node parent;

    Node(int row, int col, int gCost, int hCost, Node parent) {
        this.row = row;
        this.col = col;
        this.gCost = gCost;
        this.hCost = hCost;
        this.fCost = gCost + hCost;
        this.parent = parent;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.fCost, other.fCost);
    }
}

public class AStarMaze {

    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1} // 4 hướng: xuống, lên, phải, trái
    };

    public static List<int[]> aStar(int[][] maze, int[] start, int[] end) {
        int rows = maze.length;
        int cols = maze[0].length;

        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Node> openSet = new PriorityQueue<>();

        Node startNode = new Node(start[0], start[1], 0,
                heuristic(start[0], start[1], end[0], end[1]), null);
        openSet.add(startNode);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.row == end[0] && current.col == end[1]) {
                return reconstructPath(current);
            }

            visited[current.row][current.col] = true;

            for (int[] dir : DIRECTIONS) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                if (isValid(newRow, newCol, maze, visited)) {
                    int gCost = current.gCost + 1; // mỗi bước = 1
                    int hCost = heuristic(newRow, newCol, end[0], end[1]);
                    Node neighbor = new Node(newRow, newCol, gCost, hCost, current);

                    openSet.add(neighbor);
                }
            }
        }

        return Collections.emptyList(); // không tìm được đường đi
    }

    private static boolean isValid(int row, int col, int[][] maze, boolean[][] visited) {
        return row >= 0 && row < maze.length &&
                col >= 0 && col < maze[0].length &&
                maze[row][col] == 0 &&
                !visited[row][col];
    }

    private static int heuristic(int r1, int c1, int r2, int c2) {
        // Manhattan distance
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    private static List<int[]> reconstructPath(Node endNode) {
        List<int[]> path = new ArrayList<>();
        Node current = endNode;
        while (current != null) {
            path.add(new int[]{current.row, current.col});
            current = current.parent;
        }
        Collections.reverse(path);
        return path;
    }

    // Demo chạy
    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int[] start = {0, 0};
        int[] end = {4, 4};

        List<int[]> path = aStar(maze, start, end);

        if (!path.isEmpty()) {
            System.out.println("Đường đi tìm được:");
            for (int[] step : path) {
                System.out.println(Arrays.toString(step));
            }
        } else {
            System.out.println("Không có đường đi!");
        }
    }
}
