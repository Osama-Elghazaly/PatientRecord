/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientrecord;

/**
 *
 * @author mariamalhogail
 */
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Block {
    private long timestamp;
    private String currentHash;
    private String previousHash;
    private String patientHash;
    private PatientInfo patientInfo;
    //Medical history of a patient
    private Transaction tx;
    private int nonce;

    public Block(String previousHash, String patientHash, PatientInfo patientInfo, Transaction tx) {
        this.timestamp = System.currentTimeMillis();
        this.previousHash = previousHash;
        this.tx = tx;
        this.patientHash = patientHash;
        this.patientInfo = patientInfo;
        nonce = 0;
        currentHash = calculateHash();
    }

    private String calculateHash() {
        try {
            String data = "";
            
                data += tx.toString();
            
            String input = timestamp + previousHash + data + nonce + patientHash;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));

            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // public void addPatientRecord(Transaction patientRecordUpdate) {
    //     this.tx.add(patientRecordUpdate);
    //     this.currentHash = calculateHash();
    // }

  

    public void mineBlock(int difficulty) {
        nonce = 0;
        String target = new String(new char[difficulty]).replace('\0',
                '0');
        while (!currentHash.substring(0, difficulty).equals(target)) {
            nonce++;
            currentHash = calculateHash();
        }
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public void setCurrentHash(String currentHash) {
        this.currentHash = currentHash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getPatientHash() {
        return patientHash;
    }

    public void setPatientHash(String patientHash) {
        this.patientHash = patientHash;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

    public Transaction getTx() {
        return tx;
    }

    public void setTx(Transaction tx) {
        this.tx = tx;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "Block{" +
                "timestamp=" + timestamp +
                ", currentHash='" + currentHash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", patientHash='" + patientHash + '\'' +
                ", patientInfo=" + patientInfo.toString() +
                ", recordUpdates=" + tx +
                ", nonce=" + nonce +
                '}';
    }
}
