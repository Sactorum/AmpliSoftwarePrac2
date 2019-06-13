package Tests;
import Machines.Machine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

    Machine mac;

    @Test
    void isBroken() {
        assertFalse(mac.isBroken());
        mac.setBroken();
        assertTrue(mac.isBroken());
        mac.repair();
        assertFalse(mac.isBroken());
    }
}