package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class TreesIT {
    private Trees test = new Trees("Thuringen Wald", "Forest");
    private Trees test1;

    @BeforeEach
    public void setUp() {
        test1 = spy(test);
        when(test1.printAll()).thenReturn("Name: Thuringen Wald\nType: Forest");

    }

    @Test
    void printAll() {
        assertEquals("Name: Thuringen Wald\nType: Forest", test1.printAll());
        verify(test1, atLeastOnce()).printAll();
    }
}