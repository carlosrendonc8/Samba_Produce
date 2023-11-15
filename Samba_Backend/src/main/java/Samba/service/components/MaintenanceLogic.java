package Samba.service.components;

import Samba.commons.constans.stateMaintenance.States;

public class MaintenanceLogic {

    public String hoursMaintenance50(Integer accumulatedHours){
        if(accumulatedHours % 50 == 0){
            return States.WARNING;
        } else if (accumulatedHours % 50 == 20) {
            return States.CAUTION;
        } else {
            return States.ENABLE;
        }
    }
    public String hoursMaintenance(Integer accumulatedHours, Integer necessaryHoursToDoMaintenance){
        if(accumulatedHours % necessaryHoursToDoMaintenance == 0){
            return States.WARNING;
        } else if (accumulatedHours % necessaryHoursToDoMaintenance <= 50) {
            return States.CAUTION;
        } else {
            return States.ENABLE;
        }
    }
}
