import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalityTest {

    private Locality test = new Locality("Kyiv", "City", 13);

    @Test
    void getName() {
        assertEquals("Kyiv", test.getName());
    }

    @Test
    void printAll() {
        assertEquals("Name of locality: Kyiv\nType of locality: City", test.printAll());
    }

    @Test
    void testPrintAll() {
        assertEquals("Name of locality: Kyiv\nType of locality: City", test.printAll(true));
        assertEquals("Name of locality: Kyiv\nType of locality: City\nName of building in locality: Default name13", test.printAll(false));
    }
}