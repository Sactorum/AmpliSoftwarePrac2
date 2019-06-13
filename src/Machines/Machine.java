package Machines;

public class Machine extends MachineComponent {

    @Override
    public void setBroken() {
        if (!broken){
            broken = true;
            notifyChange();
        }
        else broken = true;
    }

    @Override
    public void repair() {
        if (broken){
            broken = false;
            notifyChange();
        }
        else broken = false;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    private void notifyChange(){
        setChanged();
        notifyObservers();

    }
}
