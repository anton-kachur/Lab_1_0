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
    void sumOfReliefs() throws Java_lab1.MyException {
        Map m1 = new Map();
        
        m1.reliefs.add(new Map.Relief(1212, "Plateau"));
        m1.reliefs.add(new Map.Relief(144444, "Mountain"));
        m1.reliefs.add(new Map.Relief(11, "Lowland"));
        m1.reliefs.add(new Map.Relief(654, "Plateau"));

        assertEquals(146321, m1.sumOfReliefs());
    }

    @Test
    void maxOfReliefs() {
        Map m1 = new Map();
        
        m1.reliefs.add(new Map.Relief(1212, "Plateau"));
        m1.reliefs.add(new Map.Relief(144444, "Mountain"));
        m1.reliefs.add(new Map.Relief(11, "Lowland"));
        m1.reliefs.add(new Map.Relief(654, "Plateau"));
        
        assertEquals("Mountain 144444", m1.maxOfReliefs());
    }

    @Test
    void averageOfReliefs() {
        Map m1 = new Map();
        
        m1.reliefs.add(new Map.Relief(1212, "Plateau"));
        m1.reliefs.add(new Map.Relief(144444, "Mountain"));
        m1.reliefs.add(new Map.Relief(11, "Lowland"));
        m1.reliefs.add(new Map.Relief(654, "Plateau"));
        
        assertEquals(36580.25, m1.averageOfReliefs());
    }
    
    
    @Test
    void mapCondition() {
        Map m1 = new Map();
        
        m1.reliefs.add(new Map.Relief(1212, "Plateau"));
        m1.reliefs.add(new Map.Relief(144444, "Mountain"));
        m1.reliefs.add(new Map.Relief(11, "Lowland"));
        m1.reliefs.add(new Map.Relief(654, "Plateau"));
        
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
    }
    
    @Test
    void getMostPopular() {
        Map m1 = new Map();
        
        m1.buildings.add(new Building("B1", "City", 12));
        m1.buildings.add(new Building("B1", "City", 12));
        m1.buildings.add(new Building("B2", "City", 56));

        assertEquals("B1", m1.getMostPopular());
    }
    
    
    @Test
    void createMap() {
        MapCreator m = new MapCreator();
        ArrayList l = m.setLocalities(6, false);
        assertEquals(l, m.resultMap().listOfLocalities());
    }
    
   
    
    @Test
    void printMap() {
        Map m1 = new Map();
        assertFalse(m1.printMap());
    }
}
