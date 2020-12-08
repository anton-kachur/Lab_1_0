import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        when(m1.sumOfReliefs()).thenReturn(146321);
        when(m1.maxOfReliefs()).thenReturn("Mountain 144444");
        when(m1.averageOfReliefs()).thenReturn(" 36580.25");
        doNothing().when(m1.mapCondition());
        when(m1.getMostPopular()).thenReturn("B1");
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
    void sumOfReliefs() throws Java_lab1.MyException {
        m1.reliefs.add(new Map.Relief(1212, "Plateau"));
        m1.reliefs.add(new Map.Relief(144444, "Mountain"));
        m1.reliefs.add(new Map.Relief(11, "Lowland"));
        m1.reliefs.add(new Map.Relief(654, "Plateau"));

        assertEquals(146321, m1.sumOfReliefs());
        verify(m1).sumOfReliefs();
    }

    @Test
    void maxOfReliefs() {
        Map.Relief r = m1.reliefs.stream().max(Comparator.comparing(Map.Relief::getHeight)).orElseThrow(NoSuchElementException::new);

        assertEquals("Mountain 144444", m1.maxOfReliefs());
        verify(m1).maxOfReliefs();
    }

    @Test
    void averageOfReliefs() {
        assertEquals(36580.25, m1.reliefs.stream().mapToInt((x) -> x.getHeight()).summaryStatistics().getAverage());
        verify(m1).averageOfReliefs();
    }


    @Test
    void mapCondition() {
        List<Map.Relief> result = m1.reliefs.stream().map(temp -> {
            Map.Relief obj = new Map.Relief(temp.getHeight(), temp.getType());
            if ("Mountain".equals(temp.getType())) {
                obj.setMessage("High relief");
            }
            else {
                obj.setMessage("Low relief");
            }

            return obj;
        }).collect(Collectors.toList());

        assertEquals(result, m1.mapCondition());
        verify(m1).mapCondition();
    }

    @Test
    void getMostPopular() {
        m1.buildings.add(new Building("B1", "City", 12));
        m1.buildings.add(new Building("B1", "City", 12));
        m1.buildings.add(new Building("B2", "City", 56));

        assertEquals("B1", m1.getMostPopular());
        verify(m1).getMostPopular();
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
