import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class Java_lab1Test {
    private MapCreator new_map = new MapCreator();
    private App app = new App(new_map);

    @BeforeEach
    public void setUp() {
        new_map = mock(MapCreator.class);
        app = mock(App.class);
        when(app.makeMap(1)).thenReturn(app.createMap(new_map));
        when(app.makeMap(3)).thenReturn(app.createMap(new_map));
        when(app.makeMap(-3)).thenReturn(app.createMap(new_map));
    }

    @Test
    void main() {
        assert (app.makeMap(1));
        assertFalse (app.makeMap(3));
        assertFalse (app.makeMap(-3));
        verify(app).makeMap(3);
        verify(app).makeMap(-3);
        }
}
