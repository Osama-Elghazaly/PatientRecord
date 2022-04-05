/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientrecord;

/**
 *
 * @author mariamalhogail
 */
public class PatientInfo {
    private PersonalInfo personalInfo;
    private String passportNO;
    private VaccineInfo vaccineInfo;
    //private VaccineInfo;

    public PatientInfo(PersonalInfo personalInfo, String passportNO, VaccineInfo vaccineInfo) {
        this.personalInfo = personalInfo;
        this.passportNO = passportNO;
        this.vaccineInfo = vaccineInfo;
    }

    

   

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }





    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }





    public String getPassportNO() {
        return passportNO;
    }





    public void setPassportNO(String passportNO) {
        this.passportNO = passportNO;
    }





    public VaccineInfo getVaccineInfo() {
        return vaccineInfo;
    }





    public void setVaccineInfo(VaccineInfo vaccineInfo) {
        this.vaccineInfo = vaccineInfo;
    }





    @Override
    public String toString() {
        return "PatientInfo{" +
                "personalInfo=" + personalInfo.toString() +
                ", patientNumber='" + passportNO + '\'' +
                ", vaccine info=" + vaccineInfo +
                '}';
    }
}
