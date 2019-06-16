package MachineD;

public class Machine extends MachineComponent {
    public Machine () {}

    @Override
    public boolean isBroken() {
        return broken;
    }

}
