import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)

class BuildingTest {
    Building test = new Building("House", "Kyiv", 35);

    @Before
    public void create(){
        test = mock(Building.class);
        when(test.printAll()).thenReturn("Name of building: House\nName of locality: Kyiv");
    }

    @Test
    void test() {
        assertEquals(test.printAll(), "Name of building: House\nName of locality: Kyiv");
    }
}