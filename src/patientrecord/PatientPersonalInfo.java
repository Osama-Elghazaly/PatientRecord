package patientrecord;

public class PatientPersonalInfo extends PersonalInfo {

    private String nationality;
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public PatientPersonalInfo(String firstName, String lastName, participants patient, String role, String nationality, String gender) {
        super(firstName, lastName, role);

        this.gender = gender;
        this.nationality = nationality;
        
        
    }

    
}
