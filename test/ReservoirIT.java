package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ReservoirIT {
    private Reservoir test = new Reservoir("Swamp", 123.0);
    private Reservoir test1;

    @BeforeEach
    public void setUp() {
        test1 = spy(test);
        when(test1.printAll()).thenReturn("com.Reservoir type: Swamp\nDepth: 123.0");
    }

    @Test
    void printAll() {
        assertEquals("com.Reservoir type: Swamp\nDepth: 123.0", test1.printAll());
        verify(test1).printAll();
    }
}