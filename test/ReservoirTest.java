import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ReservoirTest {

    private Reservoir test = new Reservoir("Swamp", 123.0);

    @BeforeEach
    public void setUp() {
        test = mock(Reservoir.class);
        when(test.printAll()).thenReturn("Reservoir type: Swamp\nDepth: 123.0");
    }

    @Test
    void printAll() {
        assertEquals("Reservoir type: Swamp\nDepth: 123.0", test.printAll());
        verify(test).printAll();
    }
}