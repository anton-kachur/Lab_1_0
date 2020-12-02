import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void listOfLocalities() throws Java_lab1.MyException {
        MapCreator m = new MapCreator();
        ArrayList l = m.setLocalities(6, false);
        l.sort(Comparator.comparing(Locality::getName));
        assertEquals(l, m.resultMap().listOfLocalities());
    }

    @Test
    void findDuplicates() {
        Map m1 = new Map();
        Map m2 = new Map();

        m1.localities.add(new Locality("Kyiv", "City", 12));
        m1.localities.add(new Locality("Kyiv", "City", 12));
        m1.localities.add(new Locality("Lviv", "City", 56));

        m2.localities.add(new Locality("Kyiv", "City", 12));
        m2.localities.add(new Locality("Hostel", "Settlement", 1));
        m2.localities.add(new Locality("Vyshneve", "Village", 6));

        assertEquals(m1.localities.get(1), m1.findDuplicates());
        assertNull(m2.findDuplicates());
    }

    @Test
    void printMap() {
        Map m1 = new Map();
        assertFalse(m1.printMap());
    }
}
