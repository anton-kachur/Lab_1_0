package com;

import com.App;
import com.MapCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class Java_lab1IT {
    private MapCreator new_map = new MapCreator();
    private MapCreator new_map1;
    private App app = new App(new_map);
    private App app1;

    @BeforeEach
    public void setUp() {
        new_map1 = Mockito.spy(new_map);
        app1 = Mockito.spy(app);
        when(app1.makeMap(1)).thenReturn(true);
        when(app1.makeMap(3)).thenReturn(false);
        when(app1.makeMap(-3)).thenReturn(false);
    }

    @Test
    void main() {
        assert (app1.makeMap(1));
        assertFalse (app1.makeMap(3));
        assertFalse (app1.makeMap(-3));
        verify(app1).makeMap(3);
        verify(app1).makeMap(-3);
        }
}
