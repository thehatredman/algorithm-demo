package com.lala.example.bit;

/**
 * Mục tiêu:
 * Mỗi file có 3 nhóm quyền: owner, group, others
 * <p>
 * Mỗi nhóm có 3 quyền: read (r), write (w), execute (x)
 * <p>
 * Tổng cộng: 9 bit → giống như rwxr-xr-x (755)
 */
public class FilePermission {
    // Các quyền cơ bản
    public static final int READ = 0b100;
    public static final int WRITE = 0b010;
    public static final int EXECUTE = 0b001;

    // Quyền cho từng nhóm
    private int ownerPermissions;
    private int groupPermissions;
    private int othersPermissions;

    // Khởi tạo với mã chmod kiểu Linux (ví dụ: 755)
    public FilePermission(int chmod) {
        ownerPermissions = (chmod / 100) % 10;
        groupPermissions = (chmod / 10) % 10;
        othersPermissions = chmod % 10;
    }

    // Hiển thị quyền dưới dạng rwx
    private String toRwx(int perm) {
        StringBuilder sb = new StringBuilder();
        sb.append((perm & READ) != 0 ? "r" : "-");
        sb.append((perm & WRITE) != 0 ? "w" : "-");
        sb.append((perm & EXECUTE) != 0 ? "x" : "-");
        return sb.toString();
    }

    public void printPermissions() {
        System.out.println("Phân quyền: " +
                toRwx(ownerPermissions) +
                toRwx(groupPermissions) +
                toRwx(othersPermissions));
    }

    public static void main(String[] args) {
        FilePermission file = new FilePermission(755);
        file.printPermissions(); // Kết quả: rwxr-xr-x

        FilePermission file2 = new FilePermission(644);
        file2.printPermissions(); // Kết quả: rw-r--r--
    }
}

