import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class MapCreatorTest {

    private MapCreator test = new MapCreator();

    @Before
    public void create() throws Java_lab1.MyException {
        test = mock(MapCreator.class);
        doThrow(Java_lab1.MyException.class).when(test).setRoads(-3, false);
        doThrow(Java_lab1.MyException.class).when(test).setReservoirs(-3, false);
        doThrow(Java_lab1.MyException.class).when(test).setBuildings(-3, false);
        doThrow(Java_lab1.MyException.class).when(test).setLocalities(-3, false);
        doThrow(Java_lab1.MyException.class).when(test).setTrees(-3, false);
        doThrow(Java_lab1.MyException.class).when(test).setRelief(-3, false);
        when(test.setScale(Scale.SCALE_X1, 3)).thenReturn("Scale: Default\nTimezone: +3");
        when(test.setScale(Scale.SCALE_X10, 3)).thenReturn("Scale: x10\nTimezone: +3");
        when(test.resultMap()).thenReturn(null);
    }

    @Test
    void setRoads() {
        Throwable exception = assertThrows(Java_lab1.MyException.class, ()->test.setRoads(-3, false));
        assertEquals("The number is less than 1", exception.getMessage());
        //verify(MapCreator).exception.getMessage();
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