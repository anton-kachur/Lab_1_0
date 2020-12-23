package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class AppIT {
    private MapCreator new_map = new MapCreator();
    private MapCreator new_map1;
    private App app = new App(new_map);
    private App app1;

    @BeforeEach
    public void setUp() {
        new_map1 = Mockito.spy(new_map);
        app1 = Mockito.spy(app);

        doReturn(true).when(app1).createMap(new_map1);
        doReturn(false).when(app1).makeMap(3);
    }

    @Test
    void createMap() {
        System.out.println("What kind of map do you want?\n1->Random map;\n2->Custom map;\nYour choice: ");

        assertTrue(app1.createMap(new_map1));
        assertFalse(app1.makeMap(3));
        verify(app1).createMap(new_map1);
        verify(app1).makeMap(3);
    }


}