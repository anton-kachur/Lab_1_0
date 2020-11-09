import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void createMap() {
        MapCreator new_map = new MapCreator();
        App app = new App(new_map);
        System.out.println("What kind of map do you want?\n1->Random map;\n2->Custom map;\nYour choice: ");

        assertTrue(app.createMap(new_map));
        assertFalse(app.makeMap(3));
    }


}