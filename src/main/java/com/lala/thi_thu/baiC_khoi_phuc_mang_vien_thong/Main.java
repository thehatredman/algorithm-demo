package com.lala.thi_thu.baiC_khoi_phuc_mang_vien_thong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/lala/thi_thu/baiC_khoi_phuc_mang_vien_thong/testcases1.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // TODO read data
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //
        int[][] graph = new int[7][4];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find(n);
        // TODO tim duong di tu diem bat dau = 1 toi diem n
        // dieu kien la muc do nhieu nho nhat
        // do tre tin hieu nho nhat

    }

    public static void find(int n) {
        System.out.println("" + n);
    }
}
