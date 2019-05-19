package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.*;
import java.util.*;
import static org.mockito.Mockito.*;


public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithMock() {

        Temperatures temperaturesMock = mock(Temperatures.class);
        HashMap<Integer, Double> temperaturesMap = new HashMap<Integer, Double>();
        temperaturesMap.put(0, 25.5);
        temperaturesMap.put(1, 26.2);
        temperaturesMap.put(2, 24.8);
        temperaturesMap.put(3, 25.2);
        temperaturesMap.put(4, 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        Assert.assertEquals(5, quantityOfSensors);
    }
}
