import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class AppTest {

    private MapCreator new_map = new MapCreator();
    private App app = new App(new_map);

    @BeforeEach
    public void setUp() {
        new_map = mock(MapCreator.class);
        app = mock(App.class);

        doReturn(true).when(app).createMap(new_map);
        doReturn(false).when(app).makeMap(3);
    }

    @Test
    void createMap() {
        System.out.println("What kind of map do you want?\n1->Random map;\n2->Custom map;\nYour choice: ");

        assertTrue(app.createMap(new_map));
        assertFalse(app.makeMap(3));
        verify(app).createMap(new_map);
        verify(app).makeMap(3);
    }


}