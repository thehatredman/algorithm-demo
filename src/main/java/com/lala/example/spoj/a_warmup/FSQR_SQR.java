package com.lala.example.spoj.a_warmup;

import java.util.Scanner;

/**
 * So chinh phuong
 */
public class FSQR_SQR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long a = -1; // a la so chinh phuong lon nhat nho hon n
        long b = -1; // b la so chinh phuong nho nhat lon hon n
        long i = 0;

        boolean checkA = true;
        boolean checkB = true;

        while (true) {
            if (!checkA && !checkB) {
                break;
            }
            if (checkA) {
                if (n - i < 0) {
                    checkA = false;
                }
                if (Math.sqrt(n * 1.0 - i) % 1 == 0) {
                    a = n - i;
                    if (a == n) {
                        a = -1;
                    } else if (a == 0) {
//                        System.out.println("a=0");
                        checkA = false;
                    } else {
//                        System.out.println("a=" + a);
                        checkA = false;
                    }
                }
            }
            if (checkB) {
                if (Math.sqrt(n * 1.0 + i) % 1 == 0) {
                    b = n + i;
                    if (b == n) {
                        b = -1;
                    } else {
//                        System.out.println("b=" + b);
                        checkB = false;
                    }
                }
            }
            i++;
        }
        System.out.println(a + " " + b);
    }
}
