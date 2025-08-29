package com.lala.example.spoj.a_warmup;

import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s_a = scanner.next();
        String s_b = scanner.next();
        long n_1 = Long.parseLong(s_a + s_b);
        long n_2 = Long.parseLong(s_b + s_a);
        if (n_1 > n_2) {
            System.out.println(n_1);
        } else {
            System.out.println(n_2);
        }
    }
}
