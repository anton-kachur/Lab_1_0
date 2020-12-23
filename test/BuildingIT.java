package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)

class BuildingIT {
    private Building test = new Building("House", "Kyiv", 35);
    private Building test1;

    @BeforeEach
    public void setUp() {
        test1 = Mockito.spy(test);
        when(test1.printAll()).thenReturn("Name of building: House\nName of locality: Kyiv");
    }

    @Test
    void printAll() {
        assertEquals(test1.printAll(), "Name of building: House\nName of locality: Kyiv");
        verify(test1).printAll();
    }
}