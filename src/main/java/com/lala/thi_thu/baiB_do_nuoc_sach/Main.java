package com.lala.thi_thu.baiB_do_nuoc_sach;

// package BaiB;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/lala/thi_thu/baiB_do_nuoc_sach/testcases.txt"));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        FastReader fr = new FastReader(br);
//        int n = fr.nextInt();
//        int m = fr.nextInt();
//        String str = fr.nextLine();

        int n;

        // BufferedReader br = new BufferedReader(new FileReader("src/BaiB/testcase.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        String[] s1 = br.readLine().split(" ");
        int[] fn = new int[n];
        int[] ln = new int[n];
        for (int i = 0; i < n; i++) {
            fn[i] = Integer.parseInt(s[i]);
            ln[i] = Integer.parseInt(s1[i]);
        }
        s = null;
        s1 = null;
        //int[] sumAtIndexArr = new int[n];
        //Arrays.fill(sumAtIndexArr, 0);
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] s2 = br.readLine().split(" ");
//            int b = sc.nextInt();
//            int a = sc.nextInt();
//            fn[b - 1] += a;
//            sumAtIndexArr[b-1] +=a;
        }
        for (int i = 0; i < n; i++) {
            //System.out.println(fn[i] + "");
            if (fn[i] > ln[i]) {
                int diff = fn[i] - ln[i];
                fn[i] = ln[i];

                if (i < n - 1) {
                    //System.out.println(aaa);
                    fn[i + 1] += diff;
                    //System.out.println(fn[i+1] + "");
                }
            }
            //System.out.println(fn[i]);
        }
        for (int i = 0; i < n; i++) {
//            bw.write(fn[i] +" ");
            System.out.print(fn[i] + " ");
        }
//        bw.flush();
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(
                new InputStreamReader(System.in));
    }

    public FastReader(BufferedReader br) {
        this.br = br;
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = "";
        try {
            if (st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
