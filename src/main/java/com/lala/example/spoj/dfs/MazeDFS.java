package com.lala.example.spoj.dfs;

public class MazeDFS {
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
    static boolean found = false;

    public static void dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) { // đến đích
            found = true;
            return;
        }

        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                    maze[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        visited = new boolean[n][m];
        dfs(0, 0);

        if (found) {
            System.out.println("Có đường đi tới đích!");
        } else {
            System.out.println("Không tìm thấy đường đi.");
        }
    }
}

