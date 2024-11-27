import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BillCalculatorFunctions {

    @Test
    void testCalculateBill_InvalidMeter() {
        // Arrange
        double lastMeter = 150;
        double currentMeter = 100;
        String billType = "WaterBill";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BillCalculatorFunctions.calculateBill(lastMeter, currentMeter, billType)
        );
        assertEquals("Current Meter ต้องมากกว่า Last Meter", exception.getMessage());
    }

    @Test
    void testCalculateBillWithRoomType_SingleBed() {
        // Arrange
        double lastMeter = 100;
        double currentMeter = 150;
        String billType = "WaterBill";
        String roomType = "Single Bed";

        // Act
        double result = BillCalculatorFunctions.calculateBillWithRoomType(lastMeter, currentMeter, billType, roomType);

        // Assert
        assertEquals(1750.0, result, 0.01, "Single Bed calculation is incorrect");
    }

    @Test
    void testCalculateBillWithRoomType_DoubleBed() {
        // Arrange
        double lastMeter = 100;
        double currentMeter = 150;
        String billType = "ElectBill";
        String roomType = "Double Bed";

        // Act
        double result = BillCalculatorFunctions.calculateBillWithRoomType(lastMeter, currentMeter, billType, roomType);

        // Assert
        assertEquals(2300.0, result, 0.01, "Double Bed calculation is incorrect");
    }
}
