package Samba.commons.domains.DTO.registerActivity;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RegisterActivityDTO implements Serializable {
    public int registerActivityId;
    public LocalDate registerActivityDate;
    public int registerActivityHours;
    public int registerActivityKilometers;
    public int registerActivityAccumulatedKilometers;
    public int registerActivityAccumulatedHours;
    public String registerActivityWorkRealized;
    public String registerActivitySiteWork;
    public String registerActivityEventualities;
    public String registerActivityImplementMachine;
    public int registerActivityGallons;


    public int getRegisterActivityId() {return registerActivityId;}
    public void setRegisterActivityId(int registerActivityId) {this.registerActivityId = registerActivityId;}

    public LocalDate getRegisterActivityDate() {return registerActivityDate;}
    public void setRegisterActivityDate(LocalDate registerActivityDate) {this.registerActivityDate = registerActivityDate;}

    public int getRegisterActivityHours() {return registerActivityHours;}
    public void setRegisterActivityHours(int registerActivityHours) {this.registerActivityHours = registerActivityHours;}

    public int getRegisterActivityKilometers() {return registerActivityKilometers;}
    public void setRegisterActivityKilometers(int registerActivityKilometers) {this.registerActivityKilometers = registerActivityKilometers;}

    public int getRegisterActivityAccumulatedKilometers() {return registerActivityAccumulatedKilometers;}
    public void setRegisterActivityAccumulatedKilometers(int registerActivityAccumulatedKilometers) {this.registerActivityAccumulatedKilometers = registerActivityAccumulatedKilometers;}

    public int getRegisterActivityAccumulatedHours() {return registerActivityAccumulatedHours;}
    public void setRegisterActivityAccumulatedHours(int registerActivityAccumulatedHours) {this.registerActivityAccumulatedHours = registerActivityAccumulatedHours;}

    public String getRegisterActivityWorkRealized() {return registerActivityWorkRealized;}
    public void setRegisterActivityWorkRealized(String registerActivityWorkRealized) {this.registerActivityWorkRealized = registerActivityWorkRealized;}

    public String getRegisterActivitySiteWork() {return registerActivitySiteWork;}
    public void setRegisterActivitySiteWork(String registerActivitySiteWork) {this.registerActivitySiteWork = registerActivitySiteWork;}

    public String getRegisterActivityEventualities() {return registerActivityEventualities;}
    public void setRegisterActivityEventualities(String registerActivityEventualities) {this.registerActivityEventualities = registerActivityEventualities;}

    public String getRegisterActivityImplementMachine() {return registerActivityImplementMachine;}
    public void setRegisterActivityImplementMachine(String registerActivityImplementMachine) {this.registerActivityImplementMachine = registerActivityImplementMachine;}

    public int getRegisterActivityGallons() {return registerActivityGallons;}
    public void setRegisterActivityGallons(int registerActivityGallons) {this.registerActivityGallons = registerActivityGallons;}
}