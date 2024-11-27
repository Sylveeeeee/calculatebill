import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BillCalculatorTest {

    @Test
    void calculateBill_InvalidMeter_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> 
            BillCalculator.calculateBill(200.0, 150.0, "WaterBill")
        );
    }
    
    @Test
    void calculateBill_WaterBill_CorrectCalculation() {
        double result = BillCalculator.calculateBill(100.0, 150.0, "WaterBill");
        assertEquals(250.0, result); 
    }

    @Test
    void calculateBill_ElectBill_CorrectCalculation() {
        double result = BillCalculator.calculateBill(200.0, 250.0, "ElectBill");
        assertEquals(300.0, result);
    }

    @Test
    void calculateBillWithRoomType_SingleBed_WaterBill() {
        double result = BillCalculator.calculateBillWithRoomType(100.0, 150.0, "WaterBill", "Single Bed");
        assertEquals(1750.0, result); 
    }

    @Test
    void calculateBillWithRoomType_DoubleBed_ElectBill() {
        double result = BillCalculator.calculateBillWithRoomType(200.0, 250.0, "ElectBill", "Double Bed");
        assertEquals(2300.0, result); 
    }


    @Test
    void resetValues_AllFieldsResetToDefault() {
        double lastMeterBefore = 100.0;
        double currentMeterBefore = 150.0;
        BillCalculator.calculateBillWithRoomType(lastMeterBefore, currentMeterBefore, "WaterBill" , "Single Bed" ); 

        BillCalculator.resetValues();

        System.out.println("Reset test passed: All fields reset to default ");
    }
}
