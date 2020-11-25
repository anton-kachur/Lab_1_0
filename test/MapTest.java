import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class MapTest {

    private MapCreator m = new MapCreator();
    private Map m1 = new Map();
    private Map m2 = new Map();
    private ArrayList l = m.setLocalities(6, false);
    private Map.Relief r = new Map.Relief(121, "Lowland");
    MapTest() throws Java_lab1.MyException {
    }

    @BeforeEach
    public void setUp() {
        m1 = mock(Map.class);
        m2 =  mock(Map.class);
        r = mock(Map.Relief.class);
        ArgumentCaptor valueCapture = ArgumentCaptor.forClass(Locality.class);

        m = mock(MapCreator.class);
        l.sort(Comparator.comparing(Locality::getName));
        when(m.resultMap().listOfLocalities()).thenReturn(l);

        when(m1.printMap()).thenReturn(false);
        when(m2.printMap()).thenReturn(false);
        when(m2.printMap()).thenReturn(false);
        when(m1.localities.get(1)).thenReturn(m1.findDuplicates());
        when(m2.findDuplicates()).thenReturn(null);

        when(r.printAll()).thenReturn("Name of relief: " + "Lowland" + "\nMeasure of relief: " + 121);

        doNothing().when(m1.localities).add(any(Integer.class), (Locality) valueCapture.capture());
    }

    @Test
    void createMap() {
        assertEquals(l, m.resultMap().listOfLocalities());
        verify(m).resultMap().listOfLocalities();
    }

    @Test
    void findDuplicates() throws Java_lab1.MyException {
        m1.localities.add(new Locality("Kyiv", "City", 12));
        m1.localities.add(new Locality("Kyiv", "City", 12));
        m1.localities.add(new Locality("Kyiv", "City", 12));
        m1.localities.add(new Locality("Lviv", "City", 56));

        m2.localities.add(new Locality("Kyiv", "City", 12));
        m2.localities.add(new Locality("Hostel", "Settlement", 1));
        m2.localities.add(new Locality("Vyshneve", "Village", 6));
        assertEquals(m1.localities.get(1), m1.findDuplicates());
        assertNull(m2.findDuplicates());
        verify(m1).findDuplicates();
        verify(m2).findDuplicates();
    }

    @Test
    void printMap() {
        assertFalse(m1.printMap());
        verify(m1).printMap();
    }

    @Test
    void printAll() {
        assertEquals(r.printAll(), "Name of relief: " + "Lowland" + "\nMeasure of relief: 121");
        verify(r).printAll();
    }
}