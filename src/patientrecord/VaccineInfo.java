package patientrecord;

public class VaccineInfo {

    private String doseDate;
    private String doseExpiry;
    private String vaccineType;
    private int doseNO;
    private String vaccineCountry;


    public VaccineInfo(String doseDate, String doseExpiry, String vaccineType, int doseNO, String vaccineCountry) {
    this.doseDate = doseDate;
    this.doseExpiry = doseExpiry;
    this.vaccineType = vaccineType;
    this.doseNO = doseNO;
    this. vaccineCountry = vaccineCountry;
    }


    public String getDoseDate() {
        return doseDate;
    }


    public void setDoseDate(String doseDate) {
        this.doseDate = doseDate;
    }


    public String getDoseExpiry() {
        return doseExpiry;
    }


    public void setDoseExpiry(String doseExpiry) {
        this.doseExpiry = doseExpiry;
    }


    public String getVaccineType() {
        return vaccineType;
    }


    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }


    public int getDoseNO() {
        return doseNO;
    }


    public void setDoseNO(int doseNO) {
        this.doseNO = doseNO;
    }


    public String getVaccineCountry() {
        return vaccineCountry;
    }


    public void setVaccineCountry(String vaccineCountry) {
        this.vaccineCountry = vaccineCountry;
    }


    @Override
    public String toString() {
        return "VaccineInfo [doseDate=" + doseDate + ", doseExpiry=" + doseExpiry + ", doseNO=" + doseNO
                + ", vaccineCountry=" + vaccineCountry + ", vaccineType=" + vaccineType + "]";
    }

    
    
    
}
