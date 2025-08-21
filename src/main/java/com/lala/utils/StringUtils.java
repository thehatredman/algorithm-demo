package com.lala.utils;

import java.util.Scanner;

public class StringUtils {

    public static boolean isValidIPv4(String ip) {
        String regex =
                "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}" +
                        "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        return ip.matches(regex);
    }

    public static void main(String[] args) {

        String input = "000.12.12.034\n" +
                "121.234.12.12\n" +
                "23.45.12.56\n" +
                "00.12.123.123123.123\n" +
                "122.23\n" +
                "Hello.IP";

        String[] listIP = input.split("\n");

        String regex =
                "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}" +
                        "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
//        String[] listIP = new String[10];
        int length = listIP.length;
        for (int i = 0; i < length; i++) {
            System.out.println(listIP[i].matches(regex));
        }

        System.out.println("Hello, World.");
        System.out.println("Hello, Java.");

        Scanner scanner = new Scanner(System.in);
        String myString = scanner.next();
        int myInt = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        scanner.close();

        System.out.println("myString is: " + myString);
        System.out.println("myInt is: " + myInt);

        System.out.printf("%15s %3d%n", "abc", 1);
    }
}
