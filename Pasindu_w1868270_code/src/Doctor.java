import java.util.Comparator;

public class Doctor extends Person{
    private int medical_licence_number;
    private String specialisation;

    public Doctor(int medical_licence_number, String name, String surname, int mobile_number, String specialisation) {
        super(name,surname,mobile_number);
        this.medical_licence_number = medical_licence_number;
        this.specialisation = specialisation;
    }
    Doctor(){

    }

    public Doctor(Comparable<String> date_of_birth) {

    }
    public int getMedical_licence_number() {
        return medical_licence_number;
    }

    public void setMedical_licence_number(int medical_licence_number) {
        this.medical_licence_number = medical_licence_number;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        return "\nMedical licence number = " + this.medical_licence_number
                + "\nDoctor Name = " + this.getName()
                +"\nDoctor Surname =" +this.getSurname()
                +"\nDoctor Phone number =" +this.getMobile_number()
                +"\nDoctor Date of Birth = "+this.getDate_of_birth()
                + "\nDoctor Specialisation = " + this.specialisation;
    }
    public static Comparator<Doctor> docNameComparator= new Comparator<Doctor>() {

        public int compare(Doctor d1, Doctor d2) {
            String DoctorName1 = d1.getSurname().toUpperCase();
            String DoctorName2 = d2.getSurname().toUpperCase();

            //ascending order
            return DoctorName1.compareTo(DoctorName2);

            //descending order
            //return DoctorName2.compareTo(DoctorName1);
        }};

}

