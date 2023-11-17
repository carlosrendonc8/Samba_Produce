package Samba.components;

import org.springframework.stereotype.Component;

@Component
public class MaintenanceLogic {

    public String hoursMaintenance50State(Integer accumulatedHours, String stateCode) {
        int threshold20 = 20;
        int threshold10 = 10;
        if(stateCode == null || stateCode.isEmpty()){
            String code1 = "00";
            if(accumulatedHours % 50 == 0) {
                return code1;
            }
            else if(50 - accumulatedHours <= threshold10){
                code1 = "20";
            } else if(50 - accumulatedHours <= threshold20){
                code1 = "10";
            }
            return code1;
        } else{
            char fistCharacter = stateCode.charAt(0);
            char secondCharacter = stateCode.charAt(1);
            String code2 = Character.toString(fistCharacter)+ Character.toString(secondCharacter);
            if(accumulatedHours % 50 == 0){
                return "00";
            }
            else if(50 - accumulatedHours <= threshold10){
                code2 = "2" + secondCharacter;
            } else if(50 - accumulatedHours <= threshold20){
                code2 = "1" + secondCharacter;
            }
            return code2;
        }
    }

    public String hoursMaintenanceState(Integer accumulatedHours, String stateCode, Integer hoursToDoMaintenance) {
        int threshold50 = 50;
        int threshold10 = 10;
        if(stateCode == null || stateCode.isEmpty()){
            String code1 = "00";
            if(accumulatedHours % hoursToDoMaintenance == 0) {
                return code1;
            }
            else if(hoursToDoMaintenance - accumulatedHours <= threshold10){
                code1 = "20";
            } else if(hoursToDoMaintenance - accumulatedHours <= threshold50){
                code1 = "10";
            }
            return code1;
        } else{
            char fistCharacter = stateCode.charAt(0);
            char secondCharacter = stateCode.charAt(1);
            String code2 = Character.toString(fistCharacter)+ Character.toString(secondCharacter);
            if(accumulatedHours % hoursToDoMaintenance == 0){
                return "00";
            }
            else if(hoursToDoMaintenance - accumulatedHours <= threshold10){
                code2 = "2" + secondCharacter;
            } else if(hoursToDoMaintenance - accumulatedHours <= threshold50){
                code2 = "1" + secondCharacter;
            }
            return code2;
        }
    }

    public String addMaintenance(String codeStatus){
        char firstCharacter = codeStatus.charAt(0);
        if(codeStatus.charAt(codeStatus.length() -1) == '0'){
            return Character.toString(firstCharacter) + "1";
        } else{
            return "ya tiene mantenimiento";
        }
    }
}
