import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadTest {

    @Test
    void test() {
        Road test = new Road("Dirt", 1);
        assertEquals("Road type: Dirt\nNumber of lanes: 1", test.printAll());
    }
}