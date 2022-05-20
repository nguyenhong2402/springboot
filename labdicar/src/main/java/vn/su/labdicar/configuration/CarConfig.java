package vn.su.labdicar.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.su.labdicar.LabdicarApplication;
import vn.su.labdicar.bean.Car;
import vn.su.labdicar.bean.Engine;

@Configuration
public class CarConfig {

    @Value("${engineType}")
    private String engineType;
    
    @Bean
    public Car car() {
        
        Engine engine;
        switch (engineType) {
            case "gas":
                engine = (Engine) context.getBean("gasEngine");
                break;
            case "electric":
                engine = (Engine) context.getBean("eletricEngine");
                break;
            case "hybrid":
                engine = (Engine) context.getBean("hybridEngine");
                break;
            default:
                engine = (Engine) context.getBean("gasEngine");
        }
        return new Car(engine);
    }
}
