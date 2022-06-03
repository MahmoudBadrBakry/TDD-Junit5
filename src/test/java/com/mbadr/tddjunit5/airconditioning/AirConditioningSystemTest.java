package com.mbadr.tddjunit5.airconditioning;

import com.mbadr.tddjunit5.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class AirConditioningSystemTest {

    @InjectMocks
    private AirConditioningSystem airConditioningSystem;

    @Mock
    private Thermometer thermometer;

    @Test
    public void testAirConditioningOpen() {
        when(thermometer.getTemperature()).thenReturn(25.0);
        airConditioningSystem.setThermometerThreshold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        assertTrue(airConditioningSystem.isOpen());
        verify(thermometer, times(1)).getTemperature();

    }
    @Test
    public void testAirConditioningClosed() {
        when(thermometer.getTemperature()).thenReturn(23.0);
        airConditioningSystem.setThermometerThreshold(24.0);
        airConditioningSystem.checkAirConditioningSystem();
        assertFalse(airConditioningSystem.isOpen());
        verify(thermometer, times(1)).getTemperature();
    }
}
