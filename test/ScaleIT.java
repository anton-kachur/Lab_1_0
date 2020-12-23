package com;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ScaleIT {

    private Scale test;

    @BeforeEach
    public void setUp() {
        test = Mockito.mock(Scale.class);
        when(test.setTimeZone(1)).thenReturn("Timezone: +1");
        when(test.setTimeZone(-2)).thenReturn("Timezone: -2");
    }

    @Test
    void setTimeZone() {
        assertEquals(test.setTimeZone(1), "Timezone: +1");
        assertEquals(test.setTimeZone(-2), "Timezone: -2");
        verify(test).setTimeZone(1);
        verify(test).setTimeZone(-2);
    }
}