package com.lala.example.hex;

public class ItemStatus {
    public static final int USABLE     = 0x01; // 00000001
    public static final int SELLABLE   = 0x02; // 00000010
    public static final int RARE       = 0x04; // 00000100
    public static final int LOCKED     = 0x08; // 00001000
    public static final int UPGRADED   = 0x10; // 00010000

    private int status = 0x00; // trạng thái ban đầu

    public void addStatus(int flag) {
        status |= flag;
    }

    public void removeStatus(int flag) {
        status &= ~flag;
    }

    public boolean hasStatus(int flag) {
        return (status & flag) != 0;
    }

    public void printStatus() {
        System.out.println("Trạng thái vật phẩm:");
        if (hasStatus(USABLE))   System.out.println("- Có thể sử dụng");
        if (hasStatus(SELLABLE)) System.out.println("- Có thể bán");
        if (hasStatus(RARE))     System.out.println("- Hiếm");
        if (hasStatus(LOCKED))   System.out.println("- Bị khóa");
        if (hasStatus(UPGRADED)) System.out.println("- Đã nâng cấp");
    }

    public static void main(String[] args) {
        ItemStatus item = new ItemStatus();

        item.addStatus(USABLE | RARE | UPGRADED); // gán nhiều trạng thái cùng lúc
        item.printStatus();

        System.out.println("\nGỡ trạng thái nâng cấp...");
        item.removeStatus(UPGRADED);
        item.printStatus();
    }
}

