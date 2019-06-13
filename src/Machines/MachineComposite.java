package Machines;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MachineComposite extends MachineComponent implements Observer {
    private List<MachineComponent> components = new ArrayList();
    private int brokenItems = 0;

    public void addComponent(MachineComponent mc){
        components.add(mc);
        mc.addObserver(this);
        countComponent(mc);

    }

    private void countComponent(MachineComponent mc) {
        if (mc.isBroken()){
            brokenItems += 1;
            if (!broken && brokenItems == 1) notifyChange();
        }
    }

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
        return  broken || brokenItems > 0;
    }

    @Override
    public void update(Observable observable, Object o) {
        MachineComponent mc = (MachineComponent) o;
        if(mc.isBroken())
            brokenItems += 1;
        else
            brokenItems -= 1;
        if (!isBroken()) notifyChange();
    }

    private void notifyChange(){
        setChanged();
        notifyObservers();

    }
}
