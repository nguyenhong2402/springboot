package vn.su.labdicar.bean;

import vn.su.labdicar.interfaces.Steering;

public class ManualSteering implements Steering{

    @Override
    public String steer() {
        
        return "Manual Steering";
    }
    
}
