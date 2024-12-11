public class Main {
    public static void main(String[] args) {

        // รับค่าเด็กคนที่ 1 , 2 , 3
        HealthRecord student1 = new HealthRecord(120);
        HealthRecord student2 = new HealthRecord(55);
        HealthRecord student3 = new HealthRecord(180);

        // โชวฺค่าความสูงเด็กคนที่ 1 , 2 , 3
        student1.displayDetails(); // 120
        student2.displayDetails(); // 55
        student3.displayDetails(); // 180 ไม่ได้ จะใช้ค่าเริ่มต้น
        HealthRecord.displayClassDetails(); // สูงสุด = 120, ต่ำสุด = 55
    }
}

class HealthRecord {

    // กำหนดตัวแปร + เงื่อนไขที่กำหนด
    private int height;
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    // ทำค่าไว้รับเด็กสูงสุด ต่ำสุด

    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    // tallestHeight ตั้งค่าเป็น MIN_PERMITTED_HEIGHT:
    // การกำหนดค่าเริ่มต้นให้ tallestHeight เป็นค่าต่ำสุด (MIN_PERMITTED_HEIGHT)
    // ทำให้แน่ใจว่าความสูง ที่มากกว่าจะสามารถอัปเดตได้ในการเปรียบเทียบครั้งแรก

    private static int shortestHeight = MAX_PERMITTED_HEIGHT;
    //shortestHeight ตั้งค่าเป็น MAX_PERMITTED_HEIGHT:
    // การกำหนดค่าเริ่มต้นให้ shortestHeight เป็นค่าสูงสุด (MAX_PERMITTED_HEIGHT)
    // ทำให้แน่ใจว่าความสูงใด ๆ ที่น้อยกว่าจะสามารถอัปเดตได้ในการเปรียบเทียบครั้งแรก

    // นับเด็ก [เซ็ตไว้ที่ 0]
    private static int counter = 0;

    // คิดค่าเฉลี่ย [เซ็ตไว้ที่ 0]
    private static double averageHeight = 0;

    // เซ็ตค่าความสูง
    public HealthRecord(int height) {

        // เรียกเด็กเข้าก่อนนับ
        counter++;
        setHeight(height);
    }

    // เงื่อนไขความสูง
    public void setHeight(int height) {

        // ถ้าอยู่ในเกณฑ์จะรับค่า ถ้าไม่จะใช้ค่าเริ่มต้น
        if (height>=MIN_PERMITTED_HEIGHT && height<=MAX_PERMITTED_HEIGHT)
            height = height;
        else
            height = DEFAULT_HEIGHT;

        // คำนวณค่าเฉลี่ย
        averageHeight = (averageHeight * (counter - 1) + height) / counter;

        // ค่าความสูงใหม่ [ไปใช้กับค่าเฉลี่ย]
        this.height = height;

        // อัพเดทค่าความสูง [สูงสุด,เตี้ยสุด]
        if (this.height > tallestHeight)
            tallestHeight = this.height;
        if (this.height < shortestHeight)
            shortestHeight = this.height;
    }

    // รับ+ส่งค่าความสูง
    public int getHeight() {
        return this.height;
    }

    // รับ+ส่งค่าสูงสุด
    public static int getTallestHeight() {
        return tallestHeight;
    }

    // รับ+ส่งค่าเตี้ยสุด
    public static int getShortestHeight() {
        return shortestHeight;
    }

    // รับ+ส่งค่าเฉลี่ยความสูง
    public static double getAverageHeight() {
        return averageHeight;
    }

    // โชว์ค่าความสูงเด็ก
    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }

    // โชว์ค่าเด็กที่สูงสุด ,เด็กที่เตี้ยสุด และค่าเฉลี่ยความสูง
    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.println("The average height (cm): " + getAverageHeight());
    }
}