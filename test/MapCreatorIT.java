package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class MapCreatorIT {

    private MapCreator test = new MapCreator();
    private MapCreator test1;
    private Throwable exception = new Throwable();
    private Throwable exception1;

    @BeforeEach
    public void setUp() throws Java_lab1.MyException {
        test1 = Mockito.spy(test);
        exception1 = Mockito.spy(exception);
        doThrow(Java_lab1.MyException.class).when(test1).setRoads(-3, false);
        doThrow(Java_lab1.MyException.class).when(test1).setReservoirs(-3, false);
        doThrow(Java_lab1.MyException.class).when(test1).setBuildings(-3, false);
        doThrow(Java_lab1.MyException.class).when(test1).setLocalities(-3, false);
        doThrow(Java_lab1.MyException.class).when(test1).setTrees(-3, false);
        doThrow(Java_lab1.MyException.class).when(test1).setRelief(-3, false);
        when(test1.setScale(Scale.SCALE_X1, 3)).thenReturn("com.Scale: Default\nTimezone: +3");
        when(test1.setScale(Scale.SCALE_X10, 3)).thenReturn("com.Scale: x10\nTimezone: +3");
        when(test1.resultMap()).thenReturn(null);
    }

    @Test
    void setRoads() {
        exception1 = assertThrows(Java_lab1.MyException.class, ()->test1.setRoads(-3, false));
        assertNull(exception1.getMessage());

    }

    @Test
    void setReservoirs() {
        exception1 = assertThrows(Java_lab1.MyException.class, ()->test1.setReservoirs(-3, false));
        assertNull(exception1.getMessage());
    }

    @Test
    void setBuildings() {
        exception1 = assertThrows(Java_lab1.MyException.class, ()->test1.setBuildings(-3, false));
        assertNull(exception1.getMessage());
    }

    @Test
    void setLocalities() {
        exception1 = assertThrows(Java_lab1.MyException.class, ()->test1.setLocalities(-3, false));
        assertNull(exception1.getMessage());
    }

    @Test
    void setTrees() {
        exception1 = assertThrows(Java_lab1.MyException.class, ()->test1.setTrees(-3, false));
        assertNull(exception1.getMessage());
    }

    @Test
    void setRelief() {
        exception1 = assertThrows(Java_lab1.MyException.class, ()->test1.setRelief(-3, false));
        assertNull(exception1.getMessage());
    }

    @Test
    void setScale() {
        assertEquals("com.Scale: Default\nTimezone: +3", test1.setScale(Scale.SCALE_X1, 3));
        assertEquals("com.Scale: x10\nTimezone: +3", test1.setScale(Scale.SCALE_X10, 3));
        verify(test1).setScale(Scale.SCALE_X1, 3);
        verify(test1).setScale(Scale.SCALE_X10, 3);
    }

    @Test
    void resultMap() {
        assertEquals(test1.resultMap(), null);
        verify(test1).resultMap();
    }
}