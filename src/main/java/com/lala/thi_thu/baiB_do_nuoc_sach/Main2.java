package com.lala.thi_thu.baiB_do_nuoc_sach;

import java.io.*;
import java.util.*;

public class Main2 {
    static int n, q;
    static long[] f, l;
    static int[] parent;

    static int find(int x) {
        if (x > n) return n + 1; // ngoài phạm vi
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/lala/thi_thu/baiB_do_nuoc_sach/testcases.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine().trim());
        f = new long[n + 2];
        l = new long[n + 2];
        parent = new int[n + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) f[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) l[i] = Long.parseLong(st.nextToken());

        for (int i = 1; i <= n + 1; i++) parent[i] = i;

        q = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < q; t++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());

            int x = find(b);
            while (x <= n && a > 0) {
                long can = l[x] - f[x];
                long add = Math.min(can, a);
                f[x] += add;
                a -= add;
                if (f[x] == l[x]) parent[x] = find(x + 1);
                x = find(x);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(f[i]);
            if (i < n) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}

