package vn.su.labdicar.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import vn.su.labdicar.interfaces.Steering;

public class Car {
    private Engine engine;

    @Autowired
    @Qualifier("manualsteering")
    private Steering steering;

    public Car(Engine engine) {
        this.engine = engine;
    }
    @Override
    public String toString() {
        
        return "Car [engine=" + engine + ", steering=" + steering.steer() + "]";
    }
    
}
