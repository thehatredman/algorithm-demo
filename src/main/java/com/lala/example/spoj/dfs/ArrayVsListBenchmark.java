package com.lala.example.spoj.dfs;

import java.util.*;

public class ArrayVsListBenchmark {
    public static void main(String[] args) {
        int size = 10_000_000; // 10 triệu phần tử
        Random rand = new Random();

        // ===== Array =====
        int[] arr = new int[size];
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100);
        }
        long end = System.nanoTime();
        System.out.println("Array: Gán giá trị = " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        long sumArr = 0;
        for (int i = 0; i < size; i++) {
            sumArr += arr[i];
        }
        end = System.nanoTime();
        System.out.println("Array: Duyệt và cộng = " + (end - start) / 1_000_000 + " ms");

        // ===== ArrayList =====
        ArrayList<Integer> list = new ArrayList<>(size);
        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(100));
        }
        end = System.nanoTime();
        System.out.println("ArrayList: Thêm phần tử = " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        long sumList = 0;
        for (int i = 0; i < size; i++) {
            sumList += list.get(i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList: Duyệt và cộng = " + (end - start) / 1_000_000 + " ms");

        // Kiểm tra tổng để tránh tối ưu JIT bỏ qua vòng lặp
        System.out.println("Kết quả kiểm tra: sumArr=" + sumArr + ", sumList=" + sumList);
    }
}

