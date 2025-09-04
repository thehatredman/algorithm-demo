package com.lala.example.bit;

public class UnitTest {
    public static void main(String[] args) {
//        Shift Operator
        int x = 8;        // 00001000
        int y = x << 2;   // 00100000 → y = 32
        int z = x >> 1;   // 00000100 → z = 4
//        System.out.println(1 << x);

        int flags = 0b0000;
        System.out.println(flags);
// Bật bit thứ 2
        flags |= 0b0010; // flags = 0b0010
        System.out.println(flags);
// Kiểm tra bit thứ 2
        if ((flags & 0b0010) != 0) {
            System.out.println("Bit thứ 2 đang bật");
        }
        System.out.println(flags);

// Tắt bit thứ 2
        flags &= ~0b0010; // flags = 0b0000
        System.out.println(flags);

        int mask = 0b0000;
        int col = 2;
        System.out.println(mask);
        int newMask = mask | (1 << col); // 1 << 2 = 0b0100
        System.out.println(newMask);

        // bat bit thu 3
        System.out.println("Bat bit thu 3 = " + (mask | (1 << 3)));
        printBits(13, 8); // In ra: 00001101
        printBits(8, 8); // In ra: 00001000
        System.out.println(1 << 2); // 2^2
        System.out.println(1 << 3); // 2^n = 2^3
    }

    public static void printBits(int value, int bits) {
        for (int i = bits - 1; i >= 0; i--) {
            System.out.print((value & (1 << i)) != 0 ? "1" : "0");
        }
        System.out.println();
    }

}
