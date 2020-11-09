import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MapCreatorTest {

    private MapCreator test = new MapCreator();

    @Test
    void setRoads() {
        Throwable exception = assertThrows(Java_lab1.MyException.class, ()->test.setRoads(-3, false));
        assertEquals("The number is less than 1", exception.getMessage());
    }

    @Test
    void setReservoirs() {
        Throwable exception = assertThrows(Java_lab1.MyException.class, ()->test.setReservoirs(-3, false));
        assertEquals("The number is less than 1", exception.getMessage());
    }

    @Test
    void setBuildings() {
        Throwable exception = assertThrows(Java_lab1.MyException.class, ()->test.setBuildings(-3, false));
        assertEquals("The number is less than 1", exception.getMessage());
    }

    @Test
    void setLocalities() {
        Throwable exception = assertThrows(Java_lab1.MyException.class, ()->test.setLocalities(-3, false));
        assertEquals("The number is less than 1", exception.getMessage());
    }

    @Test
    void setTrees() {
        Throwable exception = assertThrows(Java_lab1.MyException.class, ()->test.setTrees(-3, false));
        assertEquals("The number is less than 1", exception.getMessage());
    }

    @Test
    void setRelief() {
        Throwable exception = assertThrows(Java_lab1.MyException.class, ()->test.setRelief(-3, false));
        assertEquals("The number is less than 1", exception.getMessage());
    }

    @Test
    void setScale() {
        assertEquals("Scale: Default\nTimezone: +3", test.setScale(Scale.SCALE_X1, 3));
        assertEquals("Scale: x10\nTimezone: +3", test.setScale(Scale.SCALE_X10, 3));
    }

    @Test
    void resultMap() {
        assertNotNull(test.resultMap());
    }
}