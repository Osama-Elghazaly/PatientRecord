package patientrecord;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mariamalhogail
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlockChainRunner {

    public static void main(String[] args) {
        System.out.println("*************************** Hayyakum GCC Connected Vaccine ***************************");
        BlockChain blockChain = new BlockChain();
        Wallet employeeWallet = createEmployeeWallet(blockChain);

        if(employeeWallet.getPublicKey()==null){
            System.out.println("Faliure to add employee check role");
            System.exit(0);
        }

        else
        System.out.println("You're logged in with the Wallet : " + employeeWallet.getPublicKey());

        int choice = 0;
        do {
            choice = getChoice();
            switch (choice) {
                case 1:
                    PatientInfo patientInfo = CreateRecord();// creates patient record + first dose :)
                    Wallet patientWallet = new Wallet(patientInfo.getPersonalInfo(), participants.PATIENT, blockChain);
                    System.out.println("Patient is created with the Wallet Id: " + patientWallet.getPublicKey());
                    Transaction patientMedicalRecord = setTransaction(employeeWallet,"Creating record for patient: "+patientWallet.getPersonalInfo().getFirstName()+patientWallet.getPersonalInfo().getLastName());
                   // List<Transaction> updateList = new ArrayList<>();
                   // updateList.add(patientMedicalRecord);
                    Block block = new Block(blockChain.getLastHash(), patientWallet.getPublicKey(), patientInfo, patientMedicalRecord);
                    blockChain.addBlock(block);// a block is added to the blockchain
                    break;
                    
                case 2:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please Enter Patient number: ");
                    String patientNumber = scanner.nextLine();
                    List<Block> blocks = blockChain.blockExits(patientNumber);
                    if (!blocks.isEmpty()) {
                        Transaction medicalRecord = getPatientMedicalRecord(employeeWallet);
                        blocks.get(0).addPatientRecord(medicalRecord);
                        blockChain.setLastHash(blocks.get(0).getCurrentHash());
                    } else {
                        System.err.println("Patient does not exits!");
                    }
                    break;
                case 3:
                    scanner = new Scanner(System.in);
                    System.out.println("Please Enter Patient number: ");
                    patientNumber = scanner.nextLine();
                    List<Block> blocks1 = blockChain.blockExits(patientNumber);
                    if (!blocks1.isEmpty()) {
                        System.out.println("Patient name: " + blocks1.get(0).getPatientInfo().getPersonalInfo().getFirstName() + " " + blocks1.get(0).getPatientInfo().getPersonalInfo().getLastName());
                        for (Block block1 : blocks1) {
                            for (Transaction patientRecordUpdate : block1.getRecordUpdates()) {
                                System.out.println("********** Patient Medical History ************");
                                System.out.println("Timestamp: " + patientRecordUpdate.getTimestamp());
                                System.out.println("Updated By: " + patientRecordUpdate.getUpdatedByHash());
                                System.out.println("Patient Condition: " + patientRecordUpdate.getPatientCondition());
                                System.out.println("Insurance Claimed: " + (patientRecordUpdate.isInsuranceClaimed() ? "Yes" : "No"));
                            }
                        }
                    } else {
                        System.err.println("Patient does not exits!");
                    }
                    break;
                    
                case 4:
                    for (Block block1 : blockChain.getBlocks()) {
                        System.out.println(block1.toString());
                    }
                    break;
                case 5:
                    System.out.println("Block Chain is " + (blockChain.isChainValid() ? "Valid" : "Invalid"));
                    break;
            }
        } while (choice >= 1 && choice <= 5);
    }

    /* creates a transaction object for any transaction */
    private static Transaction setTransaction(Wallet wallet, String transactionType) {
        int transID =(int)(Math.random()*999) + wallet.hashCode();//generates a transaction ID
        return new Transaction(transID, System.currentTimeMillis(), transactionType );
    }

    private static int getChoice() {
        System.out.println("Please choose the following actions: ");
        System.out.println("1 - Create Patient Record");
        System.out.println("2 - Add Patient dose");
        System.out.println("3 - View patient Record History");
        System.out.println("4 - View All Patients (BlockChain)");
        System.out.println("5 - Check if BlockChain is valid");
        System.out.println("6 - Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static Wallet createEmployeeWallet(BlockChain blockChain) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********** Creating Employee Wallet *************");
        System.out.println("***** Personal Information *****");
        System.out.println("Please Enter FirstName: ");
        String firstName = scanner.nextLine();
        System.out.println("Please Enter LastName: ");
        String lastName = scanner.nextLine();
        // phone removed 
        System.out.println("Please Enter Role starting with H/I/F: ");
        String role = scanner.nextLine().toUpperCase();
        

        

        PersonalInfo personalInfo = new PersonalInfo(firstName, lastName, role);
        switch(role.charAt(0)){
            case 'H':
            return new Wallet(personalInfo, participants.MOH, blockChain);
            
            case 'I':
            return new Wallet(personalInfo, participants.MOI, blockChain);

            case 'F':
            return new Wallet(personalInfo, participants.MOFA, blockChain);

            default:
            return new Wallet();
            

        }
    }

    private static PatientInfo CreateRecord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user record:");

        System.out.println("Please Enter FirstName: ");
        String firstName = scanner.nextLine();
        System.out.println("Please Enter LastName: ");
        String lastName = scanner.nextLine();
        System.out.println("Please Enter Brith date: ");
        String BirthDate = scanner.nextLine();
        System.out.println("Please Enter Passport Number: ");
        String passportNO = scanner.nextLine();
        System.out.println("Please enter nationality: ");
        String nationality = scanner.nextLine();
        System.out.println("Please enter gender: ");
        String gender = scanner.nextLine();
        System.out.println("**********  Vaccine details ************");
        System.out.println("Please enter vaccination date DD/MM/YY: ");
        String doseDate = scanner.nextLine();
        System.out.println("Please enter vaccination expiry date (if applicable) DD/MM/YY: ");
        String doseExpiry = scanner.nextLine();
        System.out.println("Please enter vaccine type: ");
        String vaccineType = scanner.nextLine();
        System.out.println("Please enter doese number : ");
        int doseNO = scanner.nextInt();
        System.out.println("Enter country of vaccine");
        String vaccineCountry = scanner.next();
        
        
       
        // System.out.println("Please Enter Patient Number: ");
        // String patientNumber = scanner.nextLine();

        // double age = Double.valueOf(ageStr);

        //AddressInfo addressInfo = new AddressInfo(street, city, state, country, postcode);
        // here we should replace the attributes with the ones we had in our code
        PatientPersonalInfo personalInfo = new PatientPersonalInfo(firstName, lastName,participants.PATIENT,BirthDate,nationality,gender);
        VaccineInfo vaccineInfo = new VaccineInfo(doseDate,doseExpiry,vaccineType,doseNO,vaccineCountry);
        PatientInfo patientInfo = new PatientInfo(personalInfo, passportNO, vaccineInfo);

        return patientInfo;

    }
}