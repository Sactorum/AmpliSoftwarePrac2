package MachineD;

import java.util.Observable;

public abstract class MachineComponent extends Observable {
    protected boolean broken = false;
    public void setBroken(){
        if (!broken){
            broken = true;
            notifyChange();
        }
        else broken = true;

    }
    public void repair(){
        if (broken){
        broken = false;
        notifyChange();
        }
        else broken = false;
    }
    protected void notifyChange(){
        setChanged();
        notifyObservers();
    }
    public abstract boolean isBroken();

}
