package com;

import com.App;
import com.Map;
import com.MapCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class CreatorIT {

    private MapCreator new_map = new MapCreator();
    private MapCreator new_map1;
    private App app = new App(new_map);
    private App app1;

    private Map out_map(MapCreator mc) {
        return mc.resultMap();
    }

    @BeforeEach
    public void setUp() {
        new_map1 = Mockito.spy(new_map);
        app1 = Mockito.spy(app);
        when(app1.createMap(new_map1)).thenAnswer(i->out_map(new_map1));
    }

    @Test
    void createMap() {
        System.out.println("What kind of map do you want?\n1->Random map;\n2->Custom map;\nYour choice: ");
        assertTrue(app1.createMap(new_map));
        verify(app1).createMap(new_map);
    }
}