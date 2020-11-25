import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class CreatorTest {

    private MapCreator new_map = new MapCreator();
    private App app = new App(new_map);

    private Map out_map(MapCreator mc) {
        return mc.resultMap();
    }

    @BeforeEach
    public void setUp() {
        new_map = mock(MapCreator.class);
        app = mock(App.class);
        when(app.createMap(new_map)).thenAnswer(i->out_map(new_map));
    }

    @Test
    void createMap() {

        System.out.println("What kind of map do you want?\n1->Random map;\n2->Custom map;\nYour choice: ");

        assert(app.createMap(new_map));
        verify(app).createMap(new_map);
    }
}