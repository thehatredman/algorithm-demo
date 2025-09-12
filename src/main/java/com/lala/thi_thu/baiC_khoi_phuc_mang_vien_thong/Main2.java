package com.lala.thi_thu.baiC_khoi_phuc_mang_vien_thong;

import java.io.*;
import java.util.*;

public class Main2 {
    static class Edge {
        int u, v;
        long a, d;

        Edge(int u, int v, long a, long d) {
            this.u = u;
            this.v = v;
            this.a = a;
            this.d = d;
        }
    }

    static class E {
        int to;
        long d;

        E(int to, long d) {
            this.to = to;
            this.d = d;
        }
    }

    static int[] parent, rankUF;

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (rankUF[x] < rankUF[y]) parent[x] = y;
        else if (rankUF[x] > rankUF[y]) parent[y] = x;
        else {
            parent[y] = x;
            rankUF[x]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/lala/thi_thu/baiC_khoi_phuc_mang_vien_thong/testcases1.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            edges[i] = new Edge(u, v, a, d);
        }

        // Bước 1: tìm noiseMin bằng Union-Find trên cạnh sắp xếp theo a
        Arrays.sort(edges, Comparator.comparingLong(e -> e.a));
        parent = new int[N + 1];
        rankUF = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        long noiseMin = -1;
        for (Edge e : edges) {
            union(e.u, e.v);
            if (find(1) == find(N)) {
                noiseMin = e.a;
                break;
            }
        }

        // Bước 2: Dijkstra theo delay, chỉ dùng cạnh a <= noiseMin
        List<E>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (Edge e : edges) {
            if (e.a <= noiseMin) {
                graph[e.u].add(new E(e.v, e.d));
                graph[e.v].add(new E(e.u, e.d));
            }
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x[1]));
        pq.add(new long[]{1, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long du = cur[1];
            if (du != dist[u]) continue;
            for (E ne : graph[u]) {
                if (dist[ne.to] > du + ne.d) {
                    dist[ne.to] = du + ne.d;
                    pq.add(new long[]{ne.to, dist[ne.to]});
                }
            }
        }

        long minDelay = dist[N];
        System.out.println(noiseMin + " " + minDelay);
    }
}
