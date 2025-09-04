package com.lala.example.bit;

public class UserPermissions {
    // Định nghĩa các quyền dưới dạng bit flags
    public static final int VIEW   = 0b0001; // 1
    public static final int EDIT   = 0b0010; // 2
    public static final int DELETE = 0b0100; // 4
    public static final int ADMIN  = 0b1000; // 8

    // Biến lưu quyền của người dùng
    private int permissions = 0;

    // Thêm quyền
    public void grant(int permission) {
        permissions |= permission;
    }

    // Gỡ quyền
    public void revoke(int permission) {
        permissions &= ~permission;
    }

    // Kiểm tra quyền
    public boolean has(int permission) {
        return (permissions & permission) != 0;
    }

    // Hiển thị quyền hiện tại
    public void printPermissions() {
        System.out.println("Quyền hiện tại:");
        if (has(VIEW))   System.out.println("- Xem");
        if (has(EDIT))   System.out.println("- Sửa");
        if (has(DELETE)) System.out.println("- Xóa");
        if (has(ADMIN))  System.out.println("- Admin");
    }

    // Demo
    public static void main(String[] args) {
        UserPermissions user = new UserPermissions();

        user.grant(VIEW);
        user.grant(EDIT);
        user.printPermissions();

        System.out.println("\nGỡ quyền Sửa...");
        user.revoke(EDIT);
        user.printPermissions();

        System.out.println("\nKiểm tra quyền Xóa: " + user.has(DELETE));
    }
}

