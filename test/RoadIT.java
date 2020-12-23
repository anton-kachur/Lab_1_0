package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class RoadIT {
    private Road test = new Road("Dirt", 1);
    private Road test1;

    @BeforeEach
    public void setUp() {
        test1 = spy(test);
        when(test1.printAll()).thenReturn("com.Road type: Dirt\nNumber of lanes: 1");

    }

    @Test
    void printAll() {

        assertEquals("com.Road type: Dirt\nNumber of lanes: 1", test1.printAll());
        verify(test1).printAll();
    }
}