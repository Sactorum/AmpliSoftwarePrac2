package MachinesTests;
import Machines.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineCompositeTest {

    MachineComposite mc;
    Machine mac1, mac2, mac3;

    @BeforeEach
    void setMc () {
        mc = new MachineComposite();
        mac1 = new Machine();
        mac2 = new Machine();
        mac3 = new Machine();
    }

    @Test
    void addComponent() {
        mc.addComponent(mac1);
        assertFalse(mc.isBroken());
        mac2.setBroken();
        mc.addComponent(mac2);
        assertTrue(mc.isBroken());
        assertThrows(NullPointerException.class,()-> mc.addComponent(null));
    }

    @Test
    void setBroken() {
        mc.addComponent(mac1);
        assertFalse(mc.isBroken());
        mc.setBroken();
        assertTrue(mc.isBroken());
    }

    @Test
    void repair() {
        mc.addComponent(mac1);
        assertFalse(mc.isBroken());
        mc.setBroken();
        mc.repair();
        assertFalse(mc.isBroken());
    }

    @Test
    void isBroken() {
        mc.addComponent(mac1);
        assertFalse(mc.isBroken());
        mc.addComponent(mac2);
        mac2.setBroken();
        assertTrue(mc.isBroken());
        mac2.repair();
        assertFalse(mc.isBroken());
        mc.addComponent(mac3);
    }
}