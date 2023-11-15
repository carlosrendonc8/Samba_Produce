package Samba.components;

import Samba.commons.constans.stateMaintenance.States;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceLogic {

    public String hoursMaintenance50(Integer accumulatedHours) {
        Integer interval = 50;
        if (accumulatedHours % interval == 0) {
            return States.WARNING;
        } else if ((accumulatedHours + 20) % interval == 0) {
            return States.CAUTION;
        } else {
            return States.ENABLE;
        }
    }

    public String hoursMaintenance250(Integer accumulatedHours){
        Integer interval = 250;
        if(accumulatedHours % interval == 0){
            return States.WARNING;
        } else if ((accumulatedHours + 50) % interval == 0) {
            return States.CAUTION;
        } else {
            return States.ENABLE;
        }
    }

    public String hoursMaintenance500(Integer accumulatedHours){
        Integer interval = 500;
        if(accumulatedHours % interval == 0){
            return States.WARNING;
        } else if ((accumulatedHours + 50) % interval == 0) {
            return States.CAUTION;
        } else {
            return States.ENABLE;
        }
    }

    public String hoursMaintenance1000(Integer accumulatedHours){
        Integer interval = 1000;
        if(accumulatedHours % interval == 0){
            return States.WARNING;
        } else if ((accumulatedHours + 50) % interval == 0) {
            return States.CAUTION;
        } else {
            return States.ENABLE;
        }
    }
}
