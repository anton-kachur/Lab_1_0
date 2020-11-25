import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class RoadTest {
    private Road test = new Road("Dirt", 1);

    @Before
    public void create(){
        test = mock(Road.class);
        when(test.printAll()).thenReturn("Road type: Dirt\nNumber of lanes: 1");
    }

    @Test
    void test() {
        assertEquals("Road type: Dirt\nNumber of lanes: 1", test.printAll());
    }
}