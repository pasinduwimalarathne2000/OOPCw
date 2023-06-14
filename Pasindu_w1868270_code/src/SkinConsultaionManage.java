import java.io.FileNotFoundException;
import java.io.IOException;

public interface SkinConsultaionManage {

    void deleteDoctorSyt(int medical_licence_number) ;
    void printStatSyt(int medical_licence_number);
    void saveFileSty() throws IOException;
    void loadFileSty() throws FileNotFoundException;
    void doctorList();
    void addDocSty();

}

