import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.Date;

public class GUI {
    static JFrame jFrame = new JFrame();
    static Font font = new Font("Roboto", Font.BOLD, 14);
    static JPanel panel1;
    static JPanel panel2;
    static JPanel panel3;
    static JPanel panel4;
    static JPanel panel5;

    static JLabel topicLab;
    static JLabel regLab;
    static JLabel doc;
    static JLabel label1;
    static JLabel label2;

    static JLabel nameLable;

    static JLabel patsort;

    static JTable tb1;
    static JTable table2;

    static JButton sortBtn;
    static JButton patBtn;
    static JButton regBtn;
    static JButton subBtn;



    static JTextField nameField;
    static JTextField patIdText;
    static JTextField surnameField;
    static JTextField bithField;
    static JTextField mobiField;
    static JTextField costField;


    static JTextArea noteTextArea;


    static JScrollPane scrollPane1;
    static JScrollPane scrollPane2;


    static JLayeredPane layeredPane;
    static JLayeredPane layeredPane1;

    static DefaultTableModel tbM1;
    static DefaultTableModel jtModel2;

    static JSpinner bookingDt;

    static JComboBox docLis;


    public static void main(String[] args) {
        buttons();
        /** Form Panel **/
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 2000, 550);

        layeredPane1 = new JLayeredPane();
        layeredPane1.setBounds(0, 0, 920, 450);

        /** Open panel **/
        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setBounds(0, 0, 1000, 700);
        panel4.setBackground(Color.BLACK);
        layeredPane.add(panel4);



        topicLab = new JLabel();
        topicLab.setText("Westminster Skin Consultation Manager");
        topicLab.setFont(new Font("Roboto", Font.BOLD, 44));
        topicLab.setForeground(new Color(99,156,217));
        topicLab.setBounds(0, 0, 1000, 100);
        topicLab.setHorizontalAlignment(JLabel.CENTER);

        /** Main topic panal**/
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.BLACK);
        panel1.setPreferredSize(new Dimension(2000, 150));
        panel1.add(topicLab);
        panel1.add(sortBtn);
        panel1.add(patBtn);
        panel1.add(regBtn);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(68,62,89));
        panel2.setPreferredSize(new Dimension(1000, 450));
        panel2.add(layeredPane);

        /**  Frame  **/
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle(" Skin Consultaion Manage ");
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(1000, 730);
        jFrame.setForeground(Color.BLACK);
        jFrame.setBackground(Color.BLACK);
        jFrame.setVisible(true);
        jFrame.add(panel1, BorderLayout.NORTH);
        jFrame.add(panel2, BorderLayout.CENTER);
    }


    public static void buttons() {
        sortBtn = new JButton("SORT TABLE");
        sortBtn.setBounds(100, 110, 200, 25);
        sortBtn.setFont(font);
        sortBtn.setForeground(Color.RED);
        sortBtn.setBackground(Color.black);
        sortBtn.addActionListener(e -> {
            try {
                sortTable();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            panel3.add(nameLable);
            panel3.add(scrollPane1);
        });
        patBtn = new JButton("Patient");
        patBtn.setBounds(400, 110, 200, 25);
        patBtn.setFont(font);
        patBtn.setForeground(Color.RED);
        patBtn.setBackground(Color.black);
        patBtn.setOpaque(true);
        patBtn.addActionListener(e -> {
            patientDet();
            panel4.add(patsort);
            panel4.add(scrollPane2);
        });
        regBtn = new JButton("Registration Form");
        regBtn.setBounds(700, 110, 200, 25);
        regBtn.setFont(font);
        regBtn.setForeground(Color.RED);
        regBtn.setBackground(Color.black);
        regBtn.setOpaque(true);
        regBtn.addActionListener(e -> {
            regForm();
            panel5.add(label2);
        });

    }

    public static void regForm() {
        panel5 = new JPanel();
        panel5.setBounds(0, 0, 1000, 700);
        panel5.setBackground(Color.BLACK);
        panel5.setLayout(null);
        layeredPane.add(panel5);
        panelSwitcher(panel5);

        label2 = new JLabel();
        label2.setBounds(0, 0, 1000, 700);
        label2.setBackground(Color.BLACK);
        label2.setOpaque(true);


        regLab = new JLabel("Registration Form");
        regLab.setFont(new Font("Arial", Font.BOLD, 30));
        regLab.setForeground(Color.BLUE);
        regLab.setSize(300, 70);
        regLab.setLocation(300, 30);
        label2.add(regLab);

        label1 = new JLabel("Petient ID  :");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setSize(150, 20);
        label1.setLocation(100, 100);
        label2.add(label1);


        patIdText = new JTextField();
        patIdText.setFont(new Font("Arial", Font.BOLD, 15));
        patIdText.setSize(190, 20);
        patIdText.setLocation(300, 100);
        label2.add(patIdText);

        doc = new JLabel("Available Doctors :");
        doc.setFont(new Font("Arial", Font.BOLD, 20));
        doc.setForeground(Color.WHITE);
        doc.setSize(250, 20);
        doc.setLocation(550, 100);
        label2.add(doc);


        docLis = new JComboBox();
        docLis.setFont(new Font("Arial", Font.BOLD, 15));
        docLis.setSize(190, 20);
        docLis.setLocation(750, 100);
        label2.add(docLis);
        for (Doctor doctor : WestminsterSkinConsultationManager.addDoc) {
            docLis.addItem(doctor.getName() + " " + doctor.getSurname());
        }

        label1 = new JLabel("Petient Name :");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setSize(150, 20);
        label1.setLocation(100, 150);
        label2.add(label1);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.BOLD, 15));
        nameField.setSize(190, 20);
        nameField.setLocation(300, 150);
        label2.add(nameField);

        label1 = new JLabel("Petient Surname :");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setSize(170, 20);
        label1.setLocation(100, 200);
        label2.add(label1);

        surnameField = new JTextField();
        surnameField.setFont(new Font("Arial", Font.BOLD, 15));
        surnameField.setSize(190, 20);
        surnameField.setLocation(300, 200);
        label2.add(surnameField);

        label1 = new JLabel("DOB  :");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setSize(100, 20);
        label1.setLocation(100, 250);
        label2.add(label1);

        bithField = new JTextField();
        bithField.setFont(new Font("Arial", Font.BOLD, 15));
        bithField.setSize(190, 20);
        bithField.setLocation(300, 250);
        label2.add(bithField);

        label1 = new JLabel("Mobile :");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setSize(100, 20);
        label1.setLocation(100, 300);
        label2.add(label1);

        mobiField = new JTextField();
        mobiField.setFont(new Font("Arial", Font.BOLD, 15));
        mobiField.setSize(190, 20);
        mobiField.setLocation(300, 300);
        label2.add(mobiField);


        label1 = new JLabel("Booking date: ");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setSize(200, 22);
        label1.setLocation(100, 350);
        label2.add(label1);

        Date initialDate = new Date();
        Date minimumDate = new Date(0);
        Date maximumDate = new Date(Long.MAX_VALUE);
        SpinnerDateModel dateModel = new SpinnerDateModel(initialDate, minimumDate, maximumDate, Calendar.MINUTE);
        /** Using JSpinner to create date model **/
        bookingDt=new JSpinner(dateModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(bookingDt, "dd-MM-yyyy HH:mm");
        bookingDt.setSize(190,20);
        bookingDt.setLocation(300,350);
        bookingDt.setEditor(editor);
        label2.add(bookingDt);


        label1 = new JLabel("Note :");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setSize(100, 20);
        label1.setLocation(100, 400);
        label2.add(label1);

        noteTextArea = new JTextArea();
        noteTextArea.setFont(new Font("Arial", Font.BOLD, 15));
        noteTextArea.setSize(200, 75);
        noteTextArea.setLocation(300, 400);
        noteTextArea.setLineWrap(true);
        label2.add(noteTextArea);

        label1 = new JLabel("Cost :");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setSize(100, 20);
        label1.setLocation(100, 500);
        label2.add(label1);

        costField = new JTextField();
        costField.setFont(new Font("Arial", Font.BOLD, 15));
        costField.setSize(190, 20);
        costField.setLocation(300, 500);
        label2.add(costField);

        subBtn = new JButton("Submit");
        subBtn.setFont(new Font("Arial", Font.BOLD, 25));
        subBtn.setSize(150, 30);
        subBtn.setLocation(650, 250);
        subBtn.setOpaque(true);

        label2.add(subBtn);
        subBtn.addActionListener(e -> {
            Date bookDate = (Date) bookingDt.getValue();
            for (int i = 0; i < WestminsterSkinConsultationManager.addDoc.size(); i++) {
                if (Objects.requireNonNull(docLis.getSelectedItem()).toString().contains(WestminsterSkinConsultationManager.addDoc.get(i).getName())) {
                    Consultation c1 = new Consultation();
                    c1.setDoctor(WestminsterSkinConsultationManager.addDoc.get(i));
                    c1.setName(nameField.getText());
                    c1.setSurname(surnameField.getText());
                    try {
                        c1.setDate_of_birth(bithField.getText());
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Enter Valid date ");
                        throw new RuntimeException(ex);

                    }
                    c1.setMobile_number(Integer.parseInt(mobiField.getText()));
                    c1.setCost(Double.parseDouble(costField.getText()));

                    c1.setPatId(Integer.parseInt(patIdText.getText()));
                    c1.setBookDateTime(bookDate);
                    try {
                        Consultation.bookings.add(c1);
                        JOptionPane.showMessageDialog(null, "Consultation Added with Doctor " + WestminsterSkinConsultationManager.addDoc.get(i).getName());
                    } catch (Exception n) {
                        Consultation.bookings.add(c1);
                        JOptionPane.showMessageDialog(null, "Consultation Added with Doctor " + WestminsterSkinConsultationManager.addDoc.get(i).getName());
                    }


                }
            }

        });
    }

    //Using table row show the patient details.

    public static void patientDet() {
        //patient table settings
        panel4 = new JPanel();
        panel4.setBounds(0, 0, 1000, 700);
        panel4.setLayout(null);
        panel4.setBackground(Color.BLACK);
        layeredPane.add(panel4);
        panelSwitcher(panel4);

        patsort = new JLabel();
        patsort.setBounds(10, -30, 920, 35);
        patsort.setBackground(Color.BLACK);
        patsort.setOpaque(true);

        String [] colname={"Patient name","Patient Id","DOB","Mobile number","Doc Name","Date/Time","Cost"};
        jtModel2 = new DefaultTableModel(colname, 0);  //creating the Default Table Model
        table2 = new JTable(jtModel2);
        for (int i=0; i <Consultation.bookings.size();i++){
            String surname =Consultation.bookings.get(i).getName()+" "+Consultation.bookings.get(i).getSurname();
            int patId=Consultation.bookings.get(i).getPatId();
            String date_of_birth= String.valueOf(Consultation.bookings.get(i).getDate_of_birth());
            int mobile_number=Consultation.bookings.get(i).getMobile_number();
            String docName=Consultation.bookings.get(i).getDoctor().getSurname();
            String bkDate=String.valueOf(Consultation.bookings.get(i).getBookDateTime());
            Double cost=Consultation.bookings.get(i).getCost();
            Object[] objs ={surname,patId,date_of_birth,mobile_number,docName,bkDate,cost};
            jtModel2.addRow(objs);

        }
        scrollPane2=new JScrollPane(table2);
        scrollPane2.setBounds(20, 70, 920, 300);
    }

     //Using table row sorter it sorts by doctor's surname.
    public static void sortTable() throws IOException {
        //sort table settings
        panel3 = new JPanel();
        panel3.setBounds(0, 0, 1000, 700);
        panel3.setLayout(null);
        panel3.setBackground(Color.BLACK);
        layeredPane.add(panel3);
        panelSwitcher(panel3);

        nameLable = new JLabel();
        nameLable.setBounds(20, 10, 920, 35);
        nameLable.setBackground(Color.BLACK);
        nameLable.setOpaque(true);

        String [] colname={"Surname","Medical Licence Number","Specialisation","DOB"};
        tbM1 = new DefaultTableModel(colname, 0);  //creating the Default Table Model
        tb1 = new JTable(tbM1);
        //doctor.loadFileSty();
        for (int i=0; i< WestminsterSkinConsultationManager.addDoc.size(); i++){
            Collections.sort(WestminsterSkinConsultationManager.addDoc, Doctor.docNameComparator);
            String surname =WestminsterSkinConsultationManager.addDoc.get(i).getSurname();
            int medical_licence_number=WestminsterSkinConsultationManager.addDoc.get(i).getMedical_licence_number();
            String specialisation=WestminsterSkinConsultationManager.addDoc.get(i).getSpecialisation();
            String date_of_birth= String.valueOf(WestminsterSkinConsultationManager.addDoc.get(i).getDate_of_birth());

            Object[] objs ={surname,medical_licence_number,specialisation,date_of_birth};
            tbM1.addRow(objs);

        }
        scrollPane1=new JScrollPane(tb1);
        scrollPane1.setBounds(20, 70, 920, 300);
    }


    public static void panelSwitcher(JPanel panel)
    {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }
}


