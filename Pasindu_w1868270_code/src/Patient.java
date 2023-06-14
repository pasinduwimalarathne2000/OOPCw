public class Patient extends Person {

    private int patId;
    private Doctor doctor;



    public Patient(int patId) {
        this.patId = patId;
    }

    public Patient() {
    }

    public int getPatId() {
        return patId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public void setPatId(int patId) {this.patId = patId; }

    @Override
    public String toString() {
        return "\nPatient number = " + this.patId
                +"\nPatient Name = " + this.getName()
                +"\nPatient Surname =" +this.getSurname()
                +"\nDoctor Name ="+this.getDoctor().getName()+" "+this.getDoctor().getSurname()
                +"\nPatient Phone number =" +this.getMobile_number()
                +"\nPatient Date of Birth = "+this.getDate_of_birth();
    }

}

