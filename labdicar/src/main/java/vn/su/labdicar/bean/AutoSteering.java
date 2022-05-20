package vn.su.labdicar.bean;

import vn.su.labdicar.interfaces.Steering;

public class AutoSteering implements Steering{

    @Override
    public String steer() {
        return "Auto Steering";
    }
    
}
