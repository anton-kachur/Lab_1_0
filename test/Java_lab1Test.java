import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Java_lab1Test {

    @Test
    void main() {
        MapCreator new_map = new MapCreator();
        App app = new App(new_map);

        assert (app.makeMap(1));
        assert (app.makeMap(3));
        assert (app.makeMap(-3));
        }
}
