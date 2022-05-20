package vn.su.labdicar.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.su.labdicar.bean.AutoSteering;
import vn.su.labdicar.bean.ManualSteering;

@Configuration
public class SteeringConfig {
    @Bean
    public AutoSteering autosteering() {
        return new AutoSteering();
    }
    @Bean
    public ManualSteering manualsteering() {
        return new ManualSteering();
    }
}
