package Machines;

import java.util.*;

public class MachineComposite extends MachineComponent implements Observer {
    private List<MachineComponent> components = new ArrayList();
    private int brokenItems = 0;

    public MachineComposite () {}

    public void addComponent( MachineComponent ma){
        Optional<MachineComponent> mc = Optional.of(ma);
        components.add(mc.get());
        mc.get().addObserver(this);
        countComponent(mc.get());

    }

    private void countComponent(MachineComponent ma) {
        Optional<MachineComponent> mc = Optional.of(ma);
        if (mc.get().isBroken()){
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
        MachineComponent mc = (MachineComponent) observable;
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
