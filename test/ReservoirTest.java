import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservoirTest {

    @Test
    void test() {
        Reservoir test = new Reservoir("Swamp", 123.0);
        assertEquals("Reservoir type: Swamp\nDepth: 123.0", test.printAll());
    }
}