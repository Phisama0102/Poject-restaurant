import java.util.ArrayList;
import java.util.Scanner;

// คลาสสำหรับสินค้า
class MenuItem {
    private String name; // ชื่อของสินค้า
    private int price;   // ราคาของสินค้า

    public MenuItem(String name, int price) { // คอนสตรัคเตอร์ของคลาส MenuItem
        this.name = name;
        this.price = price;
    }

    public String getName() { // เมธอดสำหรับดึงชื่อสินค้า
        return name;
    }

    public int getPrice() { // เมธอดสำหรับดึงราคาสินค้า
        return price;
    }
}

// คลาสสำหรับร้านอาหาร
class Restaurant {
    private ArrayList<MenuItem> menu; // รายการเมนู
    private ArrayList<MenuItem> orderedItems; // รายการสินค้าที่ลูกค้าสั่ง
    private int totalPrice; // ราคารวมของสินค้าที่สั่ง

    public Restaurant() { // คอนสตรัคเตอร์ของคลาส Restaurant
        menu = new ArrayList<>();
        orderedItems = new ArrayList<>();
        totalPrice = 0;
        setupMenu(); // ตั้งค่าเมนูของร้าน
    }

    private void setupMenu() { // เพิ่มเมนูอาหารเข้าสู่ระบบ
        menu.add(new MenuItem("ข้าวผัด", 50));
        menu.add(new MenuItem("ผัดไทย", 60));
        menu.add(new MenuItem("ส้มตำ", 40));
        menu.add(new MenuItem("ผัดกระเผา", 50));
        menu.add(new MenuItem("หมูทอด", 30));
        menu.add(new MenuItem("ไก่ย่าง", 40));
        menu.add(new MenuItem("ไอศกรีมมะพร้าว", 10));
    }

    public void displayMenu() { // แสดงรายการเมนูให้ลูกค้าดู
        System.out.println("รายการอาหาร:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - " + menu.get(i).getPrice() + " บาท");
        }
    }

    public void orderItem(int itemNumber) { // เพิ่มสินค้าที่ลูกค้าสั่งเข้าสู่รายการ
        if (itemNumber > 0 && itemNumber <= menu.size()) {
            MenuItem item = menu.get(itemNumber - 1);
            orderedItems.add(item);
            totalPrice += item.getPrice();
        } else {
            System.out.println("หมายเลขสินค้าไม่ถูกต้อง");
        }
    }

    public void displayOrderSummary() { // แสดงรายการสินค้าที่สั่งพร้อมราคารวม
        System.out.println("รายการสินค้าที่สั่ง:");
        for (MenuItem item : orderedItems) {
            System.out.println(item.getName() + " - " + item.getPrice() + " บาท");
        }
        System.out.println("ราคารวมทั้งหมด: " + totalPrice + " บาท");
    }

    public int getTotalPrice() { // ดึงราคารวมของสินค้าที่สั่ง
        return totalPrice;
    }
}

// คลาสหลักของโปรแกรม
class Food {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Restaurant restaurant = new Restaurant(); // สร้างอ็อบเจ็กต์ Restaurant

        System.out.println("ยินดีต้อนรับสู่ร้านอาหาร");
        boolean ordering = true;

        // ลูปการสั่งซื้อ
        while (ordering) {
            restaurant.displayMenu(); // แสดงเมนูอาหาร
            System.out.print("โปรดระบุหมายเลขสินค้าที่ต้องการ: ");
            int choice = sc.nextInt(); // รับหมายเลขสินค้าที่ลูกค้าสั่ง
            restaurant.orderItem(choice); // สั่งสินค้า

            System.out.print("คุณต้องการสั่งสินค้าเพิ่มเติมหรือไม่? (ใช่/ไม่): ");
            String continueOrder = sc.next(); // รับคำตอบว่าต้องการสั่งต่อหรือไม่
            ordering = continueOrder.equalsIgnoreCase("ใช่");
        }

        restaurant.displayOrderSummary(); // แสดงสรุปรายการสั่งซื้อ

        // ประมวลผลการชำระเงิน
        System.out.print("กรุณาใส่จำนวนเงินที่ลูกค้าจ่าย: ");
        int paidAmount = sc.nextInt();
        int change = paidAmount - restaurant.getTotalPrice();

        if (change >= 0) {
            System.out.println("ลูกค้าจ่ายเงิน " + paidAmount + " บาท");
            System.out.println("เงินทอน: " + change + " บาท");
        } else {
            System.out.println("จำนวนเงินที่ลูกค้าจ่ายไม่เพียงพอ");
        }

        sc.close(); // ปิด Scanner
    }
}

