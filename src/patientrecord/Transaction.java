package patientrecord;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mariamalhogail
 */
public class Transaction {
 // private String updatedByHash;
    private long timestamp;
    private String transType;
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public String toString() {
        return "Transaction [timestamp=" + timestamp + ", transID=" + transID + ", transType=" + transType + "]";
    }

    public int getTransID() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID = transID;
    }

    private int transID;
    //private boolean insuranceClaimed;

    public Transaction(int transID, long timestamp, String transType) {
        this.transID = transID;
        this.timestamp = timestamp;
        this.transType = transType;
        //this.insuranceClaimed = insuranceClaimed;
    }

    


}
