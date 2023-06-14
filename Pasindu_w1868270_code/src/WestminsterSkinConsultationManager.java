import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultaionManage{
    public static final Scanner input=new Scanner(System.in);
    // a final westminster skin consultation manager object to be used within the entire program.
    public static final SkinConsultaionManage admin=new WestminsterSkinConsultationManager();
    // array list to store all the doctors details.
    public static final ArrayList<Doctor> addDoc = new ArrayList<>();
    public static void main(String[] args){
        main:
        while (true){
            try {
                display();
                System.out.println("\nEnter Letter to continue system :");
                String option = input.next().toUpperCase(Locale.ROOT);
                // switch block for the options
                switch (option){
                    case "A":
                        admin.addDocSty();
                        break;
                    case "B":
                        deleteDoctor();
                        break;
                    case "C":
                        admin.doctorList();
                        break;
                    case "D":
                        admin.saveFileSty();
                        break;
                    case "E":
                        admin.loadFileSty();
                        break;
                    case "F":
                        viewConst();
                        break;
                    case "G":
                        dltConsult();
                        break;
                    case "H":
                        GUI.main(args);
                        break;
                    case "I":
                        System.out.println(" !.............Thank you for using the system.............! ");
                        break main;
                    default:
                        System.out.println(" | Incorrect input | ");
                }
            }catch (Exception l){
                System.out.println("| Letter is incorrect |");
            }
        }
        input.close();
    }

    private static void viewConst() {
        for (Consultation c: Consultation.bookings){
            System.out.println(c);
        }
        System.out.println("**********************************************");
        System.out.println("Num of Consultation:"+Consultation.bookings.size());
        System.out.println("**********************************************");
    }

    private static void deleteDoctor() {
        try {
            System.out.println("Enter Doctor Medical Licence Number: ");
            int medical_licence_number=input.nextInt();
            System.out.println("Delete Doctor Details: ");
            admin.printStatSyt(medical_licence_number);
            // if the doctor exists in the system.
            //the system will display details and ask the user to confirm licence number.
            System.out.println("Enter Doctor Medical Licence number to confirm :");
            int medical_licence_numbercopy=input.nextInt();
            if (medical_licence_number==medical_licence_numbercopy){
                admin.deleteDoctorSyt(medical_licence_number);
                System.out.println("");
                admin.printStatSyt(medical_licence_number);
            }
            else {
                System.out.println("Confirmation failed. Please try again.");
            }
            //input either does not match the pattern for the expected type, or is out of range.
        }catch (InputMismatchException c){
            System.out.println("Medical licence number must be a integer.");
            input.next();
        }
    }

    private static void dltConsult(){
        if(Consultation.bookings.isEmpty()){
            System.out.println("No Consultations Booked");
        }else{
            System.out.println("Please enter the Patient ID: ");
            int patientID = input.nextInt();
            for (int z=0;z<Consultation.bookings.size();z++){
                if(Consultation.bookings.get(z).getPatId()==patientID){
                    System.out.println("Patient "+Consultation.bookings.get(z).getName()+"'s Consultation deleted successfully.");
                    Consultation.bookings.remove(z);
                }
            }
        }
    }



    private static void display() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("                 |Welcome to Skin Consultation Center|                          ");
        System.out.println("Please choose an option from following.");
        System.out.println("Enter A - Add a New Doctor");
        System.out.println("Enter B - Delete a Doctor");
        System.out.println("Enter C - Sorting Doctor Name");
        System.out.println("Enter D - Save File");
        System.out.println("Enter E - Load File");
        System.out.println("Enter F - View consultation ");
        System.out.println("Enter G - Cancel consultation ");
        System.out.println("Enter H - Open GUI ");
        System.out.println("Enter I - EXIT ");

    }

    // Medical Licence Number must be an integer. If the input is not matching,then this try block will handle the exception.
    @Override
    public void addDocSty() {
        try {
            System.out.println("Enter Doctor Medical Licence Number: ");
            int medical_licence_number=input.nextInt();
            input.nextLine();
            System.out.println("Enter Doctor Name:");
            String name=input.nextLine();
            System.out.println("Enter Doctor Surname:");
            String surname=input.nextLine();
            System.out.println("Enter Doctor Mobile Number:");
            int mobile_number=input.nextInt();
            input.nextLine();
            System.out.println("Enter the Doctor's DOB (dd/mm/yyyy)");
            String date_of_birth = input.nextLine();
            System.out.println("Enter Doctor Specialisation: ");
            String specialisation=input.nextLine();
            Doctor docAd=new Doctor(medical_licence_number,name,surname,mobile_number,specialisation);
            docAd.setDate_of_birth(date_of_birth);
            if (addDoc.size() >=10){
                System.out.println("Doctor list Full!!");
            }else {
                //Each physician has their own individual Medical Licence Number.
                // checking to see if the physician has the same medical license number and is available in the system.
                // The system will display an error message if one is there.
                for (Doctor c:addDoc){
                    if (c.getMedical_licence_number() == docAd.getMedical_licence_number()) {
                        System.out.println("A doctor with same ID exists in the system.");
                        return;
                    }
                }
                addDoc.add(docAd);
                System.out.println("\nDoctor added successfully.\n");

            }
            //input either does not match the pattern for the expected type, or is out of range.
        }catch (InputMismatchException c){
            System.out.println("Enter integer!");
        }catch (ParseException c){
            System.out.println("Enter Valid Date!");

        }

    }



    @Override
    public void deleteDoctorSyt(int medical_licence_number) {
        if (addDoc.isEmpty()){
            System.out.println("Doctors are Empty.");
        }
        for (Doctor c:addDoc){
            if (c.getMedical_licence_number()==medical_licence_number){
                addDoc.remove(c);
                System.out.println("Doctor deleted successfully.");
                return;
            }
        }
        System.out.println("Doctor does not exist in the system.");
    }

    @Override
    public void printStatSyt(int medical_licence_number) {
        //using for-each loop;
        for (Doctor c:addDoc){
            if (c.getMedical_licence_number()==medical_licence_number){
                System.out.println(c);
                return;
            }
        }

    }


    @Override
    public void saveFileSty() throws IOException {
        FileWriter save = new FileWriter("DoctorList.txt");
        save.write("...................................................\n"
                +"Doctor List :");
        Collections.sort(addDoc, Doctor.docNameComparator);
        for (Doctor c:addDoc) {

            save.write("\n"+ c);
        }
        save.write("\n......................................................."
                +"\nNum of Doc:"+addDoc.size() );


        System.out.println("!!Successfully Saved Data!!");
        save.close();
        System.out.println();
    }

    @Override
    public void doctorList() {
        System.out.println("Doctor Name Sorting:");
        Collections.sort(addDoc, Doctor.docNameComparator);

        for(Doctor c: addDoc){
            System.out.println(c);

        }
        System.out.println("***************************************************");
        System.out.println("Num of Doctors:"+addDoc.size());
        System.out.println("***************************************************");
    }


    @Override
    public void loadFileSty() throws FileNotFoundException {
        FileReader save = new FileReader("DoctorList.txt");
        /** read the file which saved the details in Store arraylist */
        Scanner docEnter = new Scanner(save);
        while (docEnter.hasNextLine()) {
            String input = docEnter.nextLine();
            System.out.println(input);

        }
        System.out.println("...................................................");
        docEnter.close();
        System.out.println();
    }
}

