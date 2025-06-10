package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testPunchIn_and_PunchOut_should_calculate_hours_correctly() {
        // Arrange: Employee punches in at 8:00 AM
        employee.punchIn(8.0);

        // Act: Employee punches out at 5:00 PM (17:00)
        employee.punchOut(17.0);

        // Assert: Hours worked should be 9
        assertEquals(9.0, employee.getHoursWorked(), "Punching in at 8:00 and out at 17:00 should result in 9 hours worked");
    }

    @Test
    void testPunchIn_and_PunchOut_with_fractions_of_hours() {
        // Arrange: Employee punches in at 7:30 AM (7.5)
        employee.punchIn(7.5);

        // Act: Employee punches out at 12:45 PM (12.75)
        employee.punchOut(12.75);

        // Assert: Hours worked should be 5.25
        assertEquals(5.25, employee.getHoursWorked(), "Punching in at 7:30 and out at 12:45 should result in 5.25 hours worked");
    }

    @Test
    void testPunchIn_multiple_times_before_punchOut() {
        employee.punchIn(8.0);
        employee.punchIn(9.0); // second punch in should not do anything
        employee.punchOut(17.0);
        assertEquals(9.0, employee.getHoursWorked(), "multiple punchIn before punchOut should be ignored.");
    }

    @Test
    void testPunchOut_without_punchIn() {
        employee.punchOut(17.0);
        assertEquals(0.0, employee.getHoursWorked(), "punchOut without punchIn should not increase hoursWorked");
    }

}