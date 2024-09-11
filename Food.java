import java.util.Scanner; // นำเข้าคลาส Scanner จากแพ็คเกจ java.util

public class Food { // สร้างคลาส Projact3
    public static void main(String[] args) { // สร้างเมธอด main เป็นจุดเริ่มต้นของโปรแกรม
        Scanner sc = new Scanner(System.in); // สร้างอ็อบเจ็กต์ Scanner เพื่อรับข้อมูลที่ผู้ใช้ป้อนผ่านคีย์บอร์ด
        int totalPrice = 0; // กำหนดตัวแปร totalPrice เพื่อเก็บราคารวมของสินค้าที่สั่ง
        String orderedItems = ""; // กำหนดตัวแปร orderedItems เพื่อเก็บรายการสินค้าที่สั่ง

        System.out.println("ยินดีต้อนรับสู่ร้านอาหาร"); // แสดงข้อความ "ยินดีต้อนรับสู่ร้านอาหาร"
        System.out.println("รายการอาหาร:"); // แสดงข้อความ "รายการอาหาร:"
        System.out.println("1. ข้าวผัด - 50 บาท"); // แสดงข้อความ "1. ข้าวผัด - 50 บาท"
        System.out.println("2. ผัดไทย - 60 บาท"); // แสดงข้อความ "2. ผัดไทย - 60 บาท"
        System.out.println("3. ส้มตำ - 40 บาท"); // แสดงข้อความ "3. ส้มตำ - 40 บาท"
        System.out.println("4. ผัดกระเผา - 50 บาท"); // แสดงข้อความ "4. ผัดกระเผา - 50 บาท"
        System.out.println("5. หมูทอด - 30 บาท"); // แสดงข้อความ "5. หมูทอด - 30 บาท"
        System.out.println("6. ไก่ย่าง - 40 บาท"); // แสดงข้อความ "6. ไก่ย่าง - 40 บาท"
        System.out.println("7. ไอศกรีมมะพร้าว - 10 บาท"); // แสดงข้อความ "7. ไอศกรีมมะพร้าว - 10 บาท"

        boolean ordering = true; // กำหนดตัวแปร ordering เป็น true เพื่อควบคุมการสั่งซื้อสินค้า
        while (ordering) { // เริ่มลูปการสั่งซื้อ
            System.out.print("โปรดระบุหมายเลขสินค้าที่ต้องการ: "); // แสดงข้อความ "โปรดระบุหมายเลขสินค้าที่ต้องการ:"
            int choice = sc.nextInt(); // อ่านข้อมูลที่ผู้ใช้ป้อนเป็นหมายเลขสินค้า

            // ประมวลผลสินค้าที่ผู้ใช้เลือก
            switch (choice) {
                case 1:
                    totalPrice += 50; // เพิ่มราคาของ ข้าวผัด ไปยัง totalPrice
                    orderedItems += "ข้าวผัด, "; // เพิ่ม ข้าวผัด ไปยัง orderedItems
                    break;
                case 2:
                    totalPrice += 60; // เพิ่มราคาของ ผัดไทย ไปยัง totalPrice
                    orderedItems += "ผัดไทย, "; // เพิ่ม ผัดไทย ไปยัง orderedItems
                    break;
                case 3:
                    totalPrice += 40; // เพิ่มราคาของ ส้มตำ ไปยัง totalPrice
                    orderedItems += "ส้มตำ, "; // เพิ่ม ส้มตำ ไปยัง orderedItems
                    break;
                case 4:
                    totalPrice += 50; // เพิ่มราคาของ ผัดกระเผา ไปยัง totalPrice
                    orderedItems += "ผัดกระเผา, "; // เพิ่ม ผัดกระเผา ไปยัง orderedItems
                    break;
                case 5:
                    totalPrice += 30; // เพิ่มราคาของ หมูทอด ไปยัง totalPrice
                    orderedItems += "หมูทอด, "; // เพิ่ม หมูทอด ไปยัง orderedItems
                    break;
                case 6:
                    totalPrice += 40; // เพิ่มราคาของ ไก่ย่าง ไปยัง totalPrice
                    orderedItems += "ไก่ย่าง, "; // เพิ่ม ไก่ย่าง ไปยัง orderedItems
                    break;
                case 7:
                    totalPrice += 10; // เพิ่มราคาของ ไอศกรีมมะพร้าว ไปยัง totalPrice
                    orderedItems += "ไอศกรีมมะพร้าว, "; // เพิ่ม ไอศกรีมมะพร้าว ไปยัง orderedItems
                    break;
                default:
                    System.out.println("หมายเลขสินค้าไม่ถูกต้อง"); // แจ้งให้ผู้ใช้ทราบว่าหมายเลขสินค้าไม่ถูกต้อง
            }

            System.out.print("คุณต้องการสั่งสินค้าเพิ่มเติมหรือไม่? (ใช่/ไม่): "); // ถามผู้ใช้ว่าต้องการสั่งสินค้าเพิ่มเติมหรือไม่
            String continueOrder = sc.next(); // อ่านคำตอบจากผู้ใช้
            ordering = continueOrder.equalsIgnoreCase("ใช่"); // กำหนดให้ทำการสั่งซื้อเพิ่มเติมหากผู้ใช้ตอบว่า "ใช่"
        }

        // แสดงสรุปรายการสั่งซื้อ
        System.out.println("คุณได้สั่งสินค้าเรียบร้อยแล้ว");
        System.out.println("รายการสินค้าที่สั่ง: " + orderedItems.substring(0, orderedItems.length() - 2));
        System.out.println("ราคารวมทั้งหมด: " + totalPrice + " บาท");

        // ประมวลผลการชำระเงินและคำนวณเงินทอน
        System.out.print("กรุณาใส่จำนวนเงินที่ลูกค้าจ่าย: ");
        int paidAmount = sc.nextInt();
        int change = paidAmount - totalPrice;

        // แสดงรายละเอียดการชำระเงิน
        if (change >= 0) {
            System.out.println("ลูกค้าจ่ายเงิน " + paidAmount + " บาท");
            System.out.println("ราคารวมทั้งหมด: " + totalPrice + " บาท");
            System.out.println("รายการสินค้าที่สั่ง: " + orderedItems.substring(0, orderedItems.length() - 2));
            System.out.println("เงินทอน: " + change + " บาท");
        } else {
            System.out.println("จำนวนเงินที่ลูกค้าจ่ายไม่เพียงพอ");
        }

        sc.close(); // ปิดอ็อบเจ็กต์ Scanner
    }
}
