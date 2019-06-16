package MachinesDTests;

import Machines.Machine;
import Machines.MachineComposite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MachineTest {

    static Machine mac;
    static MachineComposite mc;

    @BeforeEach
    void setMac() {
        mac = new Machine();
    }

    @Test
    void isBroken() {
        assertFalse(mac.isBroken());
        mac.setBroken();
        assertTrue(mac.isBroken());
        mac.repair();
        assertFalse(mac.isBroken());
    }
}