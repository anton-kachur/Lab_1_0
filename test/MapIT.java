package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class MapIT {

    private MapCreator m = new MapCreator();
    private MapCreator m_1;
    private Map m1 = new Map();
    private Map m2 = new Map();
    private Map m1_1;
    private Map m2_1;
    private ArrayList l;
    private Map.Relief r = new Map.Relief(121, "Lowland");
    private Map.Relief r1;

    @BeforeEach
    public void setUp() {
        m1_1 = Mockito.spy(m1);
        m2_1 = Mockito.spy(m2);
        r1 = Mockito.spy(r);
        m_1 = Mockito.spy(m);

        m1_1.reliefs.add(new Map.Relief(1212, "Plateau"));
        m1_1.reliefs.add(new Map.Relief(144444, "Mountain"));
        m1_1.reliefs.add(new Map.Relief(11, "Lowland"));
        m1_1.reliefs.add(new Map.Relief(654, "Plateau"));

        m2_1.reliefs.add(new Map.Relief(1212, "Plateau"));
        m2_1.reliefs.add(new Map.Relief(144444, "Mountain"));
        m2_1.reliefs.add(new Map.Relief(11, "Lowland"));
        m2_1.reliefs.add(new Map.Relief(654, "Plateau"));


        m1_1.buildings.add(new Building("Building1", "Kyiv", 12));
        m1_1.buildings.add(new Building("Building1", "Kyiv", 12));
        m1_1.buildings.add(new Building("Building2", "Kyiv", 13));
        m1_1.buildings.add(new Building("Building3", "Lviv", 14));

        m2_1.buildings.add(new Building("Building1", "Kyiv", 12));
        m2_1.buildings.add(new Building("Building1", "Kyiv", 12));
        m2_1.buildings.add(new Building("Building2", "Kyiv", 13));
        m2_1.buildings.add(new Building("Building3", "Lviv", 14));


        m1_1.localities.add(new Locality("Kyiv", "City", 12));
        m1_1.localities.add(new Locality("Kyiv", "City", 12));
        m1_1.localities.add(new Locality("Lviv", "City", 56));
        m1_1.localities.add(new Locality("Lviv", "City", 56));

        l = m1_1.localities;

        m2_1.localities.add(new Locality("Kyiv", "City", 12));
        m2_1.localities.add(new Locality("Kyiv", "City", 12));
        m2_1.localities.add(new Locality("Hostel", "Settlement", 1));
        m2_1.localities.add(new Locality("Vyshneve", "Village", 6));

        ArgumentCaptor valueCapture = ArgumentCaptor.forClass(Locality.class);

        l.sort(Comparator.comparing(Locality::getName));

        when(m2_1.printMap()).thenReturn(true);
        when(m2_1.printMap()).thenReturn(false);
        when(m1_1.findDuplicates()).thenReturn(m1_1.localities.get(1));
        when(m1_1.sumOfReliefs()).thenReturn(146321);
        when(m1_1.maxOfReliefs()).thenReturn("Mountain 144444");
        when(m1_1.averageOfReliefs()).thenReturn(" 36580.25");
        when(m2_1.findDuplicates()).thenReturn(null);

        when(r1.printAll()).thenReturn("Name of relief: " + "Lowland" + "\nMeasure of relief: " + 121);
    }

    @Test
    void listOfLocalities() {
        assertEquals(l, m1_1.listOfLocalities());
        verify(m1_1).listOfLocalities();
    }

    @Test
    void sumOfReliefs() throws Java_lab1.MyException {


        assertEquals(146321, m1_1.sumOfReliefs());
        verify(m1_1).sumOfReliefs();
    }

    @Test
    void maxOfReliefs() {
        assertEquals("Mountain 144444", m1_1.maxOfReliefs());
        verify(m1_1).maxOfReliefs();
    }

    @Test
    void averageOfReliefs() {
        assertEquals(" 36580.25", m1_1.averageOfReliefs());
        verify(m1_1).averageOfReliefs();
    }


    @Test
    void mapCondition() {
        assertNotNull(m1_1.mapCondition());
        verify(m1_1).mapCondition();
    }

    @Test
    void findDuplicates() throws Java_lab1.MyException {

        assertEquals(m1_1.localities.get(1), m1_1.findDuplicates());
        assertNull(m2_1.findDuplicates());
        verify(m1_1).findDuplicates();
        verify(m2_1).findDuplicates();
    }

    @Test
    void printMap() {
        assertFalse(m1_1.printMap());
        verify(m1_1).printMap();
    }

    @Test
    void printAll() {
        assertEquals(r1.printAll(), "Name of relief: " + "Lowland" + "\nMeasure of relief: 121");
        verify(r1).printAll();
    }
}