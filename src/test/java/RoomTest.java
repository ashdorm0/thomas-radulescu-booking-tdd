import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void roomStoresIdAndName() {
        Room room = new Room("R1", "Study Room 1");

        assertEquals("R1", room.getId());
        assertEquals("Study Room 1", room.getName());
    }
}