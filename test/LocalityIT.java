package com;

import com.Locality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class LocalityIT {

    private Locality test = new Locality("Kyiv", "City", 13);
    private Locality test1;

    @BeforeEach
    public void setUp() {
        test1 = Mockito.spy(test);
        when(test1.getName()).thenReturn("Kyiv");
        when(test1.printAll()).thenReturn("Name of locality: Kyiv\nType of locality: City");
        when(test1.printAll(false)).thenReturn("Name of locality: Kyiv\nType of locality: City\nName of building in locality: Default name13");
        when(test1.printAll(true)).thenReturn("Name of locality: Kyiv\nType of locality: City");
    }

    @Test
    void getName() {
        assertEquals("Kyiv", test1.getName());
        verify(test1).getName();
    }

    @Test
    void printAll() {
        assertEquals("Name of locality: Kyiv\nType of locality: City", test1.printAll());
        verify(test1).printAll();
    }

    @Test
    void boolPrintAll() {
        assertEquals("Name of locality: Kyiv\nType of locality: City", test1.printAll(true));
        assertEquals("Name of locality: Kyiv\nType of locality: City\nName of building in locality: Default name13", test1.printAll(false));
        verify(test1).printAll(true);
        verify(test1).printAll(false);
    }
}