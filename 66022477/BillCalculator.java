public class BillCalculator {

    public static double calculateBill(double lastMeter, double currentMeter, String billType) {
        if (currentMeter <= lastMeter) {
            throw new IllegalArgumentException("Current Meter ต้องมากกว่า Last Meter");
        }

        double units = currentMeter - lastMeter;
        double bill = 0;

        if ("WaterBill".equals(billType)) {
            bill = units * 5;
        } else if ("ElectBill".equals(billType)) {
            bill = units * 6;
        } else {
            throw new IllegalArgumentException("ประเภทบิลไม่ถูกต้อง");
        }

        return bill;
    }

    public static double calculateBillWithRoomType(double lastMeter, double currentMeter, String billType, String roomType) {
        double bill = calculateBill(lastMeter, currentMeter, billType); 

        if ("Single Bed".equals(roomType)) {
            bill += 1500;
        } else if ("Double Bed".equals(roomType)) {
            bill += 2000;
        }

        return bill;
    }

    public static void resetValues() {

    }

    public static void main(String[] args) {
        try {
            double lastMeter = 200;
            double currentMeter = 150;
            String billType = "WaterBill";
            String roomType = "Single Bed";
            
            double result = calculateBillWithRoomType(lastMeter, currentMeter, billType, roomType);
            System.out.println("Total Bill: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
