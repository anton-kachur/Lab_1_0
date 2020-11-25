import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.plugins.MockMaker;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class LocalityTest {

    private Locality test = new Locality("Kyiv", "City", 13);

    @BeforeEach
    public void setUp() {
        test = mock(Locality.class);
        when(test.getName()).thenReturn("Kyiv");
        when(test.printAll()).thenReturn("Name of locality: Kyiv\nType of locality: City");
        when(test.printAll(false)).thenReturn("Name of locality: Kyiv\nType of locality: City\nName of building in locality: Default name13");
        when(test.printAll(true)).thenReturn("Name of locality: Kyiv\nType of locality: City");
    }

    @Test
    void getName() {
        assertEquals("Kyiv", test.getName());
        verify(test).getName();
    }

    @Test
    void printAll() {
        assertEquals("Name of locality: Kyiv\nType of locality: City", test.printAll());
        verify(test).printAll();
    }

    @Test
    void boolPrintAll() {
        assertEquals("Name of locality: Kyiv\nType of locality: City", test.printAll(true));
        assertEquals("Name of locality: Kyiv\nType of locality: City\nName of building in locality: Default name13", test.printAll(false));
        verify(test).printAll(true);
        verify(test).printAll(false);
    }
}