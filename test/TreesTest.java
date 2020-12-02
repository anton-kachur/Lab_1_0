import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreesTest {

    @Test
    void printAll() {
        Trees test = new Trees("Thuringen Wald", "Forest");
        assertEquals("Name: Thuringen Wald\nType: Forest", test.printAll());
    }
}
