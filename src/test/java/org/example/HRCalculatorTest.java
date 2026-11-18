package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HRCalculatorTest {
    @Test
    public void testValidMaxHR() {
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }
    @Test
    public void testInvalidMaxHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }
    @Test
    public void testInvalidMaxHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }
    @Test
    public void testInvalidBPM_Negative() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(25, -4));
    }
    @Test
    public void testInvalidBPM_Zero() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(25, 0));
    }
    @Test
    public void testValidZone_Resting(){
        var result = HRCalculator.getWorkoutZone(20, 95);
        assertEquals("Resting", result);
    }
    @Test
    public void testBoundaryZone_Recovery(){
        var result = HRCalculator.getWorkoutZone(20, 100);
        assertEquals("Recovery", result);
    }
    @Test
    public void testValidZone_Recovery(){
        var result = HRCalculator.getWorkoutZone(20, 108);
        assertEquals("Recovery", result);
    }
    @Test
    public void testBoundaryZone_FatBurn(){
        var result = HRCalculator.getWorkoutZone(20, 120);
        assertEquals("Fat Burn", result);
    }
    @Test
    public void testValidZone_FatBurn(){
        var result = HRCalculator.getWorkoutZone(20, 133);
        assertEquals("Fat Burn", result);
    }
    @Test
    public void testBoundaryZone_Aerobic(){
        var result = HRCalculator.getWorkoutZone(20, 140);
        assertEquals("Aerobic", result);
    }
    @Test
    public void testValidZone_Aerobic(){
        var result = HRCalculator.getWorkoutZone(20, 145);
        assertEquals("Aerobic", result);
    }
    @Test
    public void testBoundaryZone_Anaerobic(){
        var result = HRCalculator.getWorkoutZone(20, 160);
        assertEquals("Anaerobic", result);
    }
    @Test
    public void testValidZone_Anaerobic(){
        var result = HRCalculator.getWorkoutZone(20, 170);
        assertEquals("Anaerobic", result);
    }
    @Test
    public void testBoundaryZone_VO2Max(){
        var result = HRCalculator.getWorkoutZone(20, 180);
        assertEquals("VO2 Max", result);
    }
    @Test
    public void testValidZone_VO2Max(){
        var result = HRCalculator.getWorkoutZone(20, 199);
        assertEquals("VO2 Max", result);
    }
}
