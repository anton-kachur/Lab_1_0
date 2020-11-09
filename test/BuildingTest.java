import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    @Test
    void test() {
        Building test = new Building("House", "Kyiv", 35);
        assertEquals("Name of building: House\nName of locality: Kyiv", test.printAll());
    }
}