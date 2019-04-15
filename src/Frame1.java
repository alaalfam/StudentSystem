import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Frame1 implements ActionListener {
    JFrame f ;

    JPanel panelRegistration ;
    JPanel panelRegistrationSubPanelTop ;
    JPanel panelRegistrationSubPanelUnder ;

    JPanel panelSelectUnit ;
    JPanel panelSelectUnitTop ;
    JPanel panelSelectUnitTable ;
    JPanel panelSelectUnitUnder ;
    JPanel panelSelectUnitShowStudent ;
    JPanel panelSelectUnitRemoveLesson ;
    JPanel panelSelectLesson ;

    JMenuBar mb ;

    JButton menuRegistration ;
    JButton menuSelectUnit ;
    static JTable tableCourse ;
    static JTable table ;

    static JScrollPane scrollTable ;

    String labelSFLnumber = "" ;
    String studentNumber = "" ;
    String lastStudentNumber = "a" ;

    int semester=1 ;


    boolean studentValid = false ;

    Frame1 () {
        f = new JFrame("Student system") ;
        f.setSize( 800 , 700 ) ;
        f.setLayout(new GridLayout(1, 1)) ;
        panelRegistrationSubPanelTop = new JPanel() ;
        panelRegistrationSubPanelTop.setLayout(new GridLayout(7, 2));
        panelRegistrationSubPanelTop.setBorder(new LineBorder(Color.lightGray, 5));


        panelRegistrationSubPanelUnder = new JPanel();
        panelRegistrationSubPanelUnder.setLayout(new GridLayout(1, 1));
        panelRegistrationSubPanelUnder.setBorder(new LineBorder(Color.lightGray, 5));

        panelRegistration = new JPanel();
        panelRegistration.setLayout(new GridLayout(2, 1));
        panelRegistration.add(panelRegistrationSubPanelTop);
        panelRegistration.add(panelRegistrationSubPanelUnder);


        panelSelectUnit = new JPanel();
        panelSelectUnit.setLayout(null);
        panelSelectUnitTop = new JPanel();

        panelSelectUnitTable = new JPanel();
        panelSelectUnitUnder = new JPanel();
        panelSelectUnitShowStudent = new JPanel();
        panelSelectUnitRemoveLesson = new JPanel();
        panelSelectLesson = new JPanel();

        panelSelectUnitTop.setLayout(new FlowLayout());
        panelSelectUnitShowStudent.setLayout(new GridLayout(6 , 1));
        panelSelectUnitTable.setLayout(new CardLayout());
        panelSelectUnitUnder.setLayout(new FlowLayout());
        panelSelectUnitRemoveLesson.setLayout(new FlowLayout());
        panelSelectLesson.setLayout(new GridLayout(5, 2));


        mb = new JMenuBar() ;
        mb.setLayout(new FlowLayout());

        menuRegistration = new JButton("Registration");
        menuSelectUnit = new JButton("Select Unit");

        mb.add(menuRegistration);
        mb.add(menuSelectUnit) ;
        mb.setBackground(Color.gray);
        f.add(mb);

        f.setJMenuBar(mb);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuRegistration.addActionListener(this);
        menuSelectUnit.addActionListener(this);

    }
    public boolean isInteger (String str) {
        for (int i=0 ; i<str.length() ; i++) {
            if ( (str.charAt(i) - '0') < 0 || (str.charAt(i) - '0') > 9 ) {
                return false ;
            }
        }
        return true;
    }
    public boolean isString (String str) {
        for (int i=0 ; i<str.length() ; i++) {
            if ( ( str.charAt(i) - '0' ) >=0 && ( str.charAt(i) - '0' ) <= 9 ) {
                return false ;
            }
        }
        return true ;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

        panelRegistrationSubPanelTop.removeAll();
        panelRegistrationSubPanelTop.repaint();

        panelRegistrationSubPanelUnder.removeAll();
        panelRegistrationSubPanelUnder.repaint();

        panelRegistration.removeAll();
        panelRegistration.repaint();

        panelSelectUnit.removeAll();
        panelSelectUnit.repaint();

        panelSelectUnitTop.removeAll();
        panelSelectUnitTop.repaint();

        panelSelectUnitShowStudent.removeAll();
        panelSelectUnitShowStudent.repaint();

        panelSelectUnitTable.removeAll();
        panelSelectUnitTable.repaint();

        panelSelectUnitUnder.removeAll();
        panelSelectUnitUnder.repaint();

        panelSelectUnitRemoveLesson.removeAll();
        panelSelectUnitRemoveLesson.repaint();

        panelSelectLesson.removeAll();
        panelSelectLesson.repaint();

        f.remove(panelRegistration);
        f.remove(panelSelectUnit);
        f.repaint();

        if ( arg0.getSource() == menuRegistration ) {
            panelRegistrationSubPanelTop.removeAll();
            panelRegistrationSubPanelTop.repaint();

            panelRegistrationSubPanelUnder.removeAll();
            panelRegistrationSubPanelUnder.repaint();


            JPanel stNumberLabelPanel = new JPanel();
            stNumberLabelPanel.setLayout(new BorderLayout());
            JLabel stNumberLabel = new JLabel("student number.") ;
            stNumberLabelPanel.add(stNumberLabel , BorderLayout.BEFORE_FIRST_LINE);
            panelRegistrationSubPanelTop.add(stNumberLabelPanel);

            JPanel stNumberFieldPanel = new JPanel();
            stNumberFieldPanel.setLayout(new BorderLayout());
            JTextField stNumberField = new JTextField() ;
            stNumberFieldPanel.add(stNumberField , BorderLayout.BEFORE_FIRST_LINE );
            panelRegistrationSubPanelTop.add(stNumberFieldPanel);


            JPanel fNameLabelPanel = new JPanel();
            fNameLabelPanel.setLayout(new BorderLayout());
            JLabel fNameLabel = new JLabel("First name.");
            fNameLabelPanel.add(fNameLabel , BorderLayout.BEFORE_FIRST_LINE);
            panelRegistrationSubPanelTop.add(fNameLabelPanel);

            JPanel fNameFieldPanel = new JPanel();
            fNameFieldPanel.setLayout(new BorderLayout());
            TextField fNameField = new TextField();
            fNameFieldPanel.add(fNameField , BorderLayout.BEFORE_FIRST_LINE);
            panelRegistrationSubPanelTop.add(fNameFieldPanel);


            JPanel lNameLabelPanel = new JPanel();
            lNameLabelPanel.setLayout(new BorderLayout());
            JLabel lNameLabel = new JLabel("Last name.");
            lNameLabelPanel.add(lNameLabel, BorderLayout.BEFORE_FIRST_LINE);
            panelRegistrationSubPanelTop.add(lNameLabelPanel);

            JPanel lastNameFieldPanel = new JPanel() ;
            lastNameFieldPanel.setLayout(new BorderLayout());
            JTextField lastNameField = new JTextField();
            lastNameFieldPanel.add(lastNameField , BorderLayout.BEFORE_FIRST_LINE);
            panelRegistrationSubPanelTop.add(lastNameFieldPanel);

            JPanel majorLabelPanel = new JPanel();
            majorLabelPanel.setLayout(new BorderLayout());
            JLabel majorLabel = new JLabel("Major");
            majorLabelPanel.add(majorLabel, BorderLayout.BEFORE_FIRST_LINE);
            panelRegistrationSubPanelTop.add(majorLabelPanel);

            JPanel majorFieldPanel = new JPanel();
            majorFieldPanel.setLayout(new BorderLayout());
            JTextField majorField = new JTextField();
            majorFieldPanel.add(majorField, BorderLayout.BEFORE_FIRST_LINE);
            panelRegistrationSubPanelTop.add(majorFieldPanel);

            JPanel yearLabelPanel = new JPanel();
            yearLabelPanel.setLayout(new BorderLayout());
            JLabel yearLabel = new JLabel("Year");
            yearLabelPanel.add(yearLabel , BorderLayout.BEFORE_FIRST_LINE);
            panelRegistrationSubPanelTop.add(yearLabelPanel);

            JPanel yearFieldPanel = new JPanel();
            yearFieldPanel.setLayout(new BorderLayout());
            JTextField yearField = new JTextField();
            yearFieldPanel.add(yearField, BorderLayout.BEFORE_FIRST_LINE);
            panelRegistrationSubPanelTop.add(yearFieldPanel);

            JPanel saveRegisterButtonPanel = new JPanel();
            saveRegisterButtonPanel.setLayout(new FlowLayout());
            JButton saveRegisterButton = new JButton("save");
            saveRegisterButtonPanel.add(saveRegisterButton);
            panelRegistrationSubPanelTop.add(saveRegisterButtonPanel);


            table = new JTable(Main.link.size()+1 , 6);
            panelRegistrationSubPanelUnder.add(table);
            scrollTable = new JScrollPane(table);
            panelRegistrationSubPanelUnder.add(scrollTable);


            table.setValueAt("Student Number", 0, 0);
            table.setValueAt("First name", 0, 1);
            table.setValueAt("Last name", 0, 2);
            table.setValueAt("Major", 0, 3);
            table.setValueAt("Year", 0, 4);
            table.setValueAt("Semester", 0, 5);

            Main m2 = new Main();
            m2.loadTable(table);


            saveRegisterButton.addActionListener( new ActionListener() {
                int counter=0 ;

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    lastStudentNumber = "a" ;
                    String studentNumber = stNumberField.getText() ;
                    String firstName = fNameField.getText() ;
                    String lastName = lastNameField.getText() ;
                    String major = majorField.getText() ;
                    String year = yearField.getText() ;

                    // check kardane in ke Field ha khali nabashad.
                    boolean freeBlank = false ;
                    boolean warnning = false ;


                    if ( studentNumber.equals("") ) {
                        stNumberField.setBackground(Color.yellow);
                        freeBlank = true ;
                    }
                    else {
                        stNumberField.setBackground(Color.white);
                    }
                    if ( firstName.equals("") ) {
                        fNameField.setBackground(Color.YELLOW);
                        freeBlank = true ;
                    }
                    else {
                        fNameField.setBackground(Color.white);
                    }
                    if ( lastName.equals("") ) {
                        lastNameField.setBackground(Color.YELLOW);
                        freeBlank = true ;
                    }
                    else {
                        lastNameField.setBackground(Color.white);
                    }
                    if ( major.equals("") ) {
                        majorField.setBackground(Color.YELLOW);
                        freeBlank = true ;
                    }
                    else {
                        majorField.setBackground(Color.white);
                    }
                    if ( year.equals("") ) {
                        yearField.setBackground(Color.YELLOW);
                        freeBlank = true ;
                    }
                    else {
                        yearField.setBackground(Color.white);
                    }
                    // check kardane in ke Field ha meghdare dorost dashte bashand.
                    if ( !freeBlank ) {
                        if ( !isInteger(studentNumber) ) {
                            freeBlank = true ;
                            warnning = true ;
                            if ( counter%2 == 0 ) {
                                JOptionPane.showMessageDialog(null, "Student number should be an integer. " );
                            }
                        }
                    }
                    if ( !freeBlank ) {
                        if ( !isString(firstName) ) {
                            freeBlank = true ;
                            warnning = true ;
                            if (  counter%2 == 0 ) {
                                JOptionPane.showMessageDialog(null, "First name can not have any number." );
                            }
                        }
                    }
                    if ( !freeBlank ) {
                        if ( !isString(lastName) ) {
                            freeBlank = true ;
                            warnning = true ;
                            if ( counter%2 == 0) {
                                JOptionPane.showMessageDialog(null, "Last name can not have any number." +counter);
                            }
                        }
                    }
                    if ( !freeBlank ) {
                        if ( !isString(major) ) {
                            freeBlank = true ;
                            warnning = true ;
                            if ( counter%2 == 0) {
                                JOptionPane.showMessageDialog(null, "Major can not have any number.");
                            }
                        }
                    }
                    if ( !freeBlank ) {
                        if ( !isInteger(year) ) {
                            freeBlank = true ;
                            warnning = true ;
                            if ( counter%2 == 0) {

                            }
                            JOptionPane.showMessageDialog(null, "Year should be a number.");
                        }
                    }
                    // check kardane in ke agar Field ha khali nabodand va meghdare dorost darand shomare daneshjoi tekrari nabashad.
                    if ( !freeBlank && !warnning ) {
                        Main m = new Main() ;
                        try {
                            freeBlank = m.insertStudent(studentNumber, firstName, lastName, major, year);
                        } catch (FileNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } // agar shomare daneshjoi tekrari bashad engar Field khali hast.
                        if (!freeBlank ) {

                            table = new JTable(new DefaultTableModel(new Object[]{studentNumber, firstName, lastName, major, year , semester}, Main.link.size()+1));
//							int row = Main.link.size() ;
                            panelRegistrationSubPanelUnder.remove(scrollTable);
                            panelRegistrationSubPanelUnder.repaint();
                            panelRegistrationSubPanelUnder.revalidate();
                            scrollTable = new JScrollPane(table);
                            m.loadTable ( table ) ;
                            JTableHeader header = table.getTableHeader();
                            header.setBackground(Color.yellow);
                            header.setToolTipText("hello");
                            panelRegistrationSubPanelUnder.add(scrollTable);
                            panelRegistrationSubPanelUnder.repaint();
                            panelRegistrationSubPanelUnder.revalidate();
                            panelRegistration.add(panelRegistrationSubPanelUnder);
                            panelRegistration.repaint();
                            panelRegistration.revalidate();
                            JOptionPane.showMessageDialog(null, "Operation succeesfully.");
                        }
                    }
                    else if ( !warnning ) {
                        JOptionPane.showMessageDialog(null, "Operation failed.");
                    }
                    counter++ ;

                }
            });
            panelRegistration.add(panelRegistrationSubPanelTop);
            panelRegistration.add(panelRegistrationSubPanelUnder);
            f.add(panelRegistration);
            panelRegistration.setVisible(true);
            f.setVisible(true);
        }
        else if ( arg0.getSource() == menuSelectUnit ) {
            panelSelectUnitTop.setBounds(0, 0, 700, 50);

            JLabel label = new JLabel("Enter student number.");
            panelSelectUnitTop.add(label);

            JTextField textField = new JTextField(20);
            panelSelectUnitTop.add(textField);

            JButton buttonSearchStudent = new JButton("Search Student");
            panelSelectUnitTop.add(buttonSearchStudent);
            panelSelectUnit.add(panelSelectUnitTop);
            JButton buttonRemoveStudent = new JButton("Remove Student");
            panelSelectUnitTop.add(buttonRemoveStudent);

            buttonRemoveStudent.addActionListener(new ActionListener() {
                int counter=0 ;
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    studentNumber = textField.getText() ;

//					boolean freeBlank = false ;
//					boolean warnning = false ;
                    studentValid = false ;
                    if ( !studentNumber.equals("") ) {
                        if ( !isInteger(studentNumber) ) {
//							freeBlank = true ;
//							warnning = true ;
                            if ( counter%2 == 0 ) {
                                JOptionPane.showMessageDialog(null, "Student number should be an integer. ");
                            }
                        }

                        Main m = new Main();
                        // check mokonad ke shomare daneshjoi vared shode ra ghablan zakhire karde bashad.
                        for (int i=0 ; i<Main.link.size() ; i++) {
                            if ( Main.link.get(i).getStudentNumber().equals(studentNumber) ) {
                                studentValid = true ; // shomare daneshjoi vared shode dorost boode.
                                int Question = JOptionPane.showConfirmDialog(null , "Are you sure want to remove?", "Question" , JOptionPane.YES_NO_OPTION) ;
                                if (Question == 1) {
                                    break ;
                                }
                                try {
                                    m.deleteStudent(studentNumber);
                                    tableCourse = new JTable(12 , 4);
                                    tableCourse.setValueAt("Course code", 0, 0);
                                    tableCourse.setValueAt("Course name", 0, 1);
                                    tableCourse.setValueAt("Testdate", 0, 2);
                                    tableCourse.setValueAt("date", 0, 3);

                                    panelSelectUnitTable.removeAll();
                                    panelSelectUnitTable.add(tableCourse);
                                    panelSelectUnitTable.repaint();
                                    panelSelectUnitTable.revalidate();

                                    panelSelectUnit.add(panelSelectUnitTable);

                                } catch (FileNotFoundException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                }
                            }
                        }
                        if ( !studentValid ) {
                            JOptionPane.showMessageDialog(null, "We have not any student with this student number.");
                        }

                    }
                    else {
                        tableCourse = new JTable(12 , 4);
                        tableCourse.setValueAt("Course code", 0, 0);
                        tableCourse.setValueAt("Course name", 0, 1);
                        tableCourse.setValueAt("Testdate", 0, 2);
                        tableCourse.setValueAt("date", 0, 3);

                        panelSelectUnitTable.removeAll();
                        panelSelectUnitTable.add(tableCourse);
                        panelSelectUnitTable.repaint();
                        panelSelectUnitTable.revalidate();

                        panelSelectUnit.add(panelSelectUnitTable);
                        textField.setBackground(Color.yellow);
                        JOptionPane.showMessageDialog(null, "Please Enter a student number.");
                    }
                    counter++ ;
                    f.repaint();
                }




            });


            JButton buttonAddLesson = new JButton("Add lesson");
            JButton buttonRemoveLesson = new JButton("Remove lesson");

            tableCourse = new JTable(12 , 4);
            tableCourse.setValueAt("Course code", 0, 0);
            tableCourse.setValueAt("Course name", 0, 1);
            tableCourse.setValueAt("Testdate", 0, 2);
            tableCourse.setValueAt("date", 0, 3);


            JLabel lCourseCode = new JLabel("Enter course code");
            panelSelectLesson.add(lCourseCode);
            JTextField tfCourseCode = new JTextField(10);
            panelSelectLesson.add(tfCourseCode);
            JLabel lCourseName = new JLabel("Enter course name");
            panelSelectLesson.add(lCourseName);
            JTextField tfCourseName = new JTextField(20);
            panelSelectLesson.add(tfCourseName);
            JLabel lTestDate = new JLabel("Enter test date");
            panelSelectLesson.add(lTestDate);
            JTextField tfTestDate = new JTextField(20);
            panelSelectLesson.add(tfTestDate);
            JLabel lDate = new JLabel("Enter Date");
            panelSelectLesson.add(lDate);
            JTextField tfDate = new JTextField(20);
            panelSelectLesson.add(tfDate);
            panelSelectLesson.setBounds(300, 50, 400, 150);
            panelSelectUnit.add(panelSelectLesson);
            panelSelectUnitUnder.setBounds(500, 200, 200, 50);

            panelSelectUnitUnder.add(buttonAddLesson);

            panelSelectUnit.add(panelSelectUnitUnder);

            JLabel lRemoveLesson = new JLabel("For remove a lesson just enter code course");
            panelSelectUnitRemoveLesson.add(lRemoveLesson);
            JTextField tfRemoveLesson = new JTextField(10);
            panelSelectUnitRemoveLesson.add(tfRemoveLesson);
            panelSelectUnitRemoveLesson.add(buttonRemoveLesson);


            panelSelectUnitRemoveLesson.setBounds(0, 50, 250, 60);
            panelSelectUnit.add(panelSelectUnitRemoveLesson);

            panelSelectUnitShowStudent.setBounds(0, 100, 250, 200);
            panelSelectUnit.add(panelSelectUnitShowStudent);

            JPanel panelSelectUnitNextAndBackSemester = new JPanel() ;
            JButton buttonNext = new JButton("Next semester");
            JButton buttonBack = new JButton("Back semester");

            if (semester == 1) {
                buttonBack.setEnabled(false);
                buttonBack.setVisible(false);
            }
            else {
                buttonBack.setEnabled(true);
                buttonBack.setVisible(true);
            }


            buttonNext.addActionListener(new ActionListener() {
                int counter=0 ;
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    studentNumber = textField.getText() ;
                    if (semester == 1) {
                        buttonBack.setEnabled(false);
                        buttonBack.setVisible(false);
                    }
                    else {
                        buttonBack.setEnabled(true);
                        buttonBack.setVisible(true);
                    }
                    studentValid = false ;
                    if ( !studentNumber.equals("") ) {
                        if ( !isInteger(studentNumber) ) {
                            if ( counter%2 == 0 ) {
                                JOptionPane.showMessageDialog(null, "Student number should be an integer. ");
                            }
                        }

                        Main m = new Main();
                        // check mokonad ke shomare daneshjoi vared shode ra ghablan zakhire karde bashad.
                        for (int i=0 ; i<Main.link.size() ; i++) {
                            if ( Main.link.get(i).getStudentNumber().equals(studentNumber) ) {
                                studentValid = true ; // shomare daneshjoi vared shode dorost boode.


                                panelSelectUnitTable.removeAll();
                                try {
                                    m.insertSemester(studentNumber , ++semester);
                                } catch (FileNotFoundException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                tableCourse = new JTable(12 , 4);
                                tableCourse.setValueAt("Course code", 0, 0);
                                tableCourse.setValueAt("Course name", 0, 1);
                                tableCourse.setValueAt("Testdate", 0, 2);
                                tableCourse.setValueAt("date", 0, 3);

                                try {
                                    m.loadTableCourse(studentNumber , semester , tableCourse);
                                } catch (FileNotFoundException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                                tableCourse.repaint();

                                panelSelectUnitShowStudent.removeAll();
                                JLabel labelStudentNumber = new JLabel("      Student number : "+studentNumber);
                                JLabel labelFirstName = new JLabel("      First name : " +Main.link.get(i).getFirstName());
                                JLabel labelLastName = new JLabel("      Last name : " +Main.link.get(i).getLastName());
                                JLabel labelMajor = new JLabel("      Major : " +Main.link.get(i).getMajor());
                                JLabel labelYear = new JLabel("      Year : " +Main.link.get(i).getYear());
                                JLabel labelSemester = new JLabel("      Semester : " +semester);

                                panelSelectUnitShowStudent.add(labelStudentNumber);
                                panelSelectUnitShowStudent.add(labelFirstName);
                                panelSelectUnitShowStudent.add(labelLastName);
                                panelSelectUnitShowStudent.add(labelMajor);
                                panelSelectUnitShowStudent.add(labelYear);
                                panelSelectUnitShowStudent.add(labelSemester);

                                panelSelectUnitShowStudent.repaint();
                                panelSelectUnitShowStudent.revalidate();

                                if (semester == 1) {
                                    buttonBack.setEnabled(false);
                                    buttonBack.setVisible(false);
                                }
                                else {
                                    buttonBack.setEnabled(true);
                                    buttonBack.setVisible(true);
                                }

                                panelSelectUnitTable.add(tableCourse);
                                panelSelectUnitTable.repaint();
                                panelSelectUnitTable.revalidate();

                                panelSelectUnit.add(panelSelectUnitTable);
                                panelSelectUnit.repaint();
                            }
                        }
                        if ( !studentValid ) {
                            JOptionPane.showMessageDialog(null, "We have not any student with this student number.");
                        }

                    }
                    else {
                        tableCourse = new JTable(12 , 4);
                        tableCourse.setValueAt("Course code", 0, 0);
                        tableCourse.setValueAt("Course name", 0, 1);
                        tableCourse.setValueAt("Testdate", 0, 2);
                        tableCourse.setValueAt("date", 0, 3);

                        panelSelectUnitTable.removeAll();
                        panelSelectUnitTable.add(tableCourse);
                        panelSelectUnitTable.repaint();
                        panelSelectUnitTable.revalidate();

                        panelSelectUnit.add(panelSelectUnitTable);
                        textField.setBackground(Color.yellow);
                        JOptionPane.showMessageDialog(null, "Please Enter a student number.");
                    }
                    counter++ ;
                    f.repaint();


                }
            });
            buttonBack.addActionListener(new ActionListener() {
                int counter=0 ;
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    studentNumber = textField.getText() ;

                    studentValid = false ;
                    if ( !studentNumber.equals("") ) {
                        if ( !isInteger(studentNumber) ) {
                            if ( counter%2 == 0 ) {
                                JOptionPane.showMessageDialog(null, "Student number should be an integer. ");
                            }
                        }

                        Main m = new Main();
                        // check mokonad ke shomare daneshjoi vared shode ra ghablan zakhire karde bashad.
                        for (int i=0 ; i<Main.link.size() ; i++) {
                            if ( Main.link.get(i).getStudentNumber().equals(studentNumber) ) {
                                studentValid = true ; // shomare daneshjoi vared shode dorost boode.


                                if (semester > 1) {
                                    tableCourse = new JTable(12 , 4);
                                    tableCourse.setValueAt("Course code", 0, 0);
                                    tableCourse.setValueAt("Course name", 0, 1);
                                    tableCourse.setValueAt("Testdate", 0, 2);
                                    tableCourse.setValueAt("date", 0, 3);

                                    try {
                                        m.loadTableCourse(studentNumber , --semester , tableCourse);
                                    } catch (FileNotFoundException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                    }
                                    tableCourse.repaint();

                                    panelSelectUnitShowStudent.removeAll();
                                    JLabel labelStudentNumber = new JLabel("      Student number : "+studentNumber);
                                    JLabel labelFirstName = new JLabel("      First name : " +Main.link.get(i).getFirstName());
                                    JLabel labelLastName = new JLabel("      Last name : " +Main.link.get(i).getLastName());
                                    JLabel labelMajor = new JLabel("      Major : " +Main.link.get(i).getMajor());
                                    JLabel labelYear = new JLabel("      Year : " +Main.link.get(i).getYear());
                                    JLabel labelSemester = new JLabel("      Semester : " +semester );

                                    panelSelectUnitShowStudent.add(labelStudentNumber);
                                    panelSelectUnitShowStudent.add(labelFirstName);
                                    panelSelectUnitShowStudent.add(labelLastName);
                                    panelSelectUnitShowStudent.add(labelMajor);
                                    panelSelectUnitShowStudent.add(labelYear);
                                    panelSelectUnitShowStudent.add(labelSemester);

                                    panelSelectUnitShowStudent.repaint();
                                    panelSelectUnitShowStudent.revalidate();

                                    if (semester == 1) {
                                        buttonBack.setEnabled(false);
                                        buttonBack.setVisible(false);
                                    }
                                    else {
                                        buttonBack.setEnabled(true);
                                        buttonBack.setVisible(true);
                                    }

                                    panelSelectUnitTable.removeAll();
                                    panelSelectUnitTable.add(tableCourse);
                                    panelSelectUnitTable.repaint();
                                    panelSelectUnitTable.revalidate();

                                    panelSelectUnit.add(panelSelectUnitTable);
                                    panelSelectUnit.repaint();
                                    panelSelectUnitTable.revalidate();


                                }
                            }
                        }
                        if ( !studentValid ) {
                            JOptionPane.showMessageDialog(null, "We have not any student with this student number.");
                        }

                    }
                    else {
                        tableCourse = new JTable(12 , 4);
                        tableCourse.setValueAt("Course code", 0, 0);
                        tableCourse.setValueAt("Course name", 0, 1);
                        tableCourse.setValueAt("Testdate", 0, 2);
                        tableCourse.setValueAt("date", 0, 3);

                        panelSelectUnitTable.removeAll();
                        panelSelectUnitTable.add(tableCourse);
                        panelSelectUnitTable.repaint();
                        panelSelectUnitTable.revalidate();

                        panelSelectUnit.add(panelSelectUnitTable);
                        textField.setBackground(Color.yellow);
                        JOptionPane.showMessageDialog(null, "Please Enter a student number.");
                    }
                    counter++ ;
                    f.repaint();






                }
            });

            panelSelectUnitNextAndBackSemester.setLayout( new FlowLayout() );
            panelSelectUnitNextAndBackSemester.setBounds(200, 350, 300, 50);

            panelSelectUnitNextAndBackSemester.add(buttonBack) ;
            panelSelectUnitNextAndBackSemester.add(buttonNext) ;
            panelSelectUnit.add(panelSelectUnitNextAndBackSemester);

            JPanel panelSelectUnitRemoveSemester = new JPanel();
            JButton buttonRemoveSemester = new JButton("Remove semester");
            panelSelectUnitRemoveSemester.add(buttonRemoveSemester);
            buttonRemoveSemester.addActionListener(new ActionListener() {
                int counter=0 ;
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    studentNumber = textField.getText() ;

//					boolean freeBlank = false ;
//					boolean warnning = false ;
                    studentValid = false ;
                    if ( !studentNumber.equals("") ) {
                        if ( !isInteger(studentNumber) ) {
//							freeBlank = true ;
//							warnning = true ;
                            if ( counter%2 == 0 ) {
                                JOptionPane.showMessageDialog(null, "Student number should be an integer. ");
                            }
                        }

                        Main m = new Main();
                        // check mokonad ke shomare daneshjoi vared shode ra ghablan zakhire karde bashad.
                        for (int i=0 ; i<Main.link.size() ; i++) {
                            if ( Main.link.get(i).getStudentNumber().equals(studentNumber) ) {
                                studentValid = true ; // shomare daneshjoi vared shode dorost boode.
                                int Question = JOptionPane.showConfirmDialog(null , "Are you sure want to remove?", "Question" , JOptionPane.YES_NO_OPTION) ;
                                if (Question == 1) {
                                    break ;
                                }
                                try {
                                    m.deleteSemester(studentNumber , semester--);

                                    tableCourse = new JTable(12 , 4);
                                    tableCourse.setValueAt("Course code", 0, 0);
                                    tableCourse.setValueAt("Course name", 0, 1);
                                    tableCourse.setValueAt("Testdate", 0, 2);
                                    tableCourse.setValueAt("date", 0, 3);

                                    if (semester == 0) {
                                        semester++;
                                    }
                                    if (semester == 1) {
                                        buttonBack.setEnabled(false);
                                        buttonBack.setVisible(false);
                                    }
                                    else {
                                        buttonBack.setEnabled(true);
                                        buttonBack.setVisible(true);
                                    }
                                    m.loadTableCourse(studentNumber, semester, tableCourse);
                                    tableCourse.repaint();

                                    panelSelectUnitShowStudent.removeAll();
                                    JLabel labelStudentNumber = new JLabel("      Student number : "+studentNumber);
                                    JLabel labelFirstName = new JLabel("      First name : " +Main.link.get(i).getFirstName());
                                    JLabel labelLastName = new JLabel("      Last name : " +Main.link.get(i).getLastName());
                                    JLabel labelMajor = new JLabel("      Major : " +Main.link.get(i).getMajor());
                                    JLabel labelYear = new JLabel("      Year : " +Main.link.get(i).getYear());
                                    JLabel labelSemester = new JLabel("      Semester : " +semester );

                                    panelSelectUnitShowStudent.add(labelStudentNumber);
                                    panelSelectUnitShowStudent.add(labelFirstName);
                                    panelSelectUnitShowStudent.add(labelLastName);
                                    panelSelectUnitShowStudent.add(labelMajor);
                                    panelSelectUnitShowStudent.add(labelYear);
                                    panelSelectUnitShowStudent.add(labelSemester);

                                    panelSelectUnitShowStudent.repaint();
                                    panelSelectUnitShowStudent.revalidate();



                                    panelSelectUnitTable.removeAll();
                                    panelSelectUnitTable.add(tableCourse);
                                    panelSelectUnitTable.repaint();
                                    panelSelectUnitTable.revalidate();

                                    panelSelectUnit.add(panelSelectUnitTable);

                                } catch (FileNotFoundException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                }
                            }
                        }
                        if ( !studentValid ) {
                            JOptionPane.showMessageDialog(null, "We have not any student with this student number.");
                        }

                    }
                    else {
                        tableCourse = new JTable(12 , 4);
                        tableCourse.setValueAt("Course code", 0, 0);
                        tableCourse.setValueAt("Course name", 0, 1);
                        tableCourse.setValueAt("Testdate", 0, 2);
                        tableCourse.setValueAt("date", 0, 3);

                        panelSelectUnitTable.removeAll();
                        panelSelectUnitTable.add(tableCourse);
                        panelSelectUnitTable.repaint();
                        panelSelectUnitTable.revalidate();

                        panelSelectUnit.add(panelSelectUnitTable);
                        textField.setBackground(Color.yellow);
                        JOptionPane.showMessageDialog(null, "Please Enter a student number.");
                    }
                    counter++ ;
                    f.repaint();


                }
            });
            panelSelectUnitRemoveSemester.setLayout(new FlowLayout());
            panelSelectUnitRemoveSemester.setBounds(550, 350, 150, 50);

            panelSelectUnit.add(panelSelectUnitRemoveSemester);

            panelSelectUnitTable.add(tableCourse);
            panelSelectUnitTable.setBounds(0, 400, 700, 200);

            panelSelectUnit.add(panelSelectUnitTable);


            buttonSearchStudent.addActionListener(new ActionListener() {
                int counter=0 ;
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    studentNumber = textField.getText() ;
                    tableCourse = new JTable(12 , 4);
                    tableCourse.setValueAt("Course code", 0, 0);
                    tableCourse.setValueAt("Course name", 0, 1);
                    tableCourse.setValueAt("Testdate", 0, 2);
                    tableCourse.setValueAt("date", 0, 3);
                    panelSelectUnitTable.removeAll();
                    panelSelectUnitTable.add(tableCourse);
                    panelSelectUnitTable.repaint();
                    panelSelectUnitTable.revalidate();
                    // farz mikonim Field ha khali hast. va shomare danesh joii vared shode sahih nist ta khalafe an sabet shavad.
//					boolean freeBlank = false ;
//					boolean warnning = false ;
                    studentValid = false ;
                    if ( !studentNumber.equals("") ) {
                        if ( !isInteger(studentNumber) ) {
//							freeBlank = true ;
//							warnning = true ;
                            if ( counter%2 == 0 ) {
                                JOptionPane.showMessageDialog(null, "Student number should be an integer. ");
                            }
                        }

//						Main m = new Main();
                        // check mokonad ke shomare daneshjoi vared shode ra ghablan zakhire karde bashad.
                        for (int i=0 ; i<Main.link.size() ; i++) {
                            if ( Main.link.get(i).getStudentNumber().equals(studentNumber) ) {
                                studentValid = true ; // shomare daneshjoi vared shode dorost boode.
                                panelSelectUnitShowStudent.removeAll();
                                JLabel labelStudentNumber = new JLabel("      Student number : "+studentNumber);
                                JLabel labelFirstName = new JLabel("      First name : " +Main.link.get(i).getFirstName());
                                JLabel labelLastName = new JLabel("      Last name : " +Main.link.get(i).getLastName());
                                JLabel labelMajor = new JLabel("      Major : " +Main.link.get(i).getMajor());
                                JLabel labelYear = new JLabel("      Year : " +Main.link.get(i).getYear());
                                JLabel labelSemester = new JLabel("      Semester : " +Main.link.get(i).getSemester());

                                panelSelectUnitShowStudent.add(labelStudentNumber);
                                panelSelectUnitShowStudent.add(labelFirstName);
                                panelSelectUnitShowStudent.add(labelLastName);
                                panelSelectUnitShowStudent.add(labelMajor);
                                panelSelectUnitShowStudent.add(labelYear);
                                panelSelectUnitShowStudent.add(labelSemester);

                                panelSelectUnitShowStudent.repaint();
                                panelSelectUnitShowStudent.revalidate();
                                Main m1 = new Main();
                                semester = Main.link.get(i).arrSemester.size() ;
                                if (semester == 1) {
                                    buttonBack.setEnabled(false);
                                    buttonBack.setVisible(false);
                                }
                                else {
                                    buttonBack.setEnabled(true);
                                    buttonBack.setVisible(true);
                                }

                                try {
                                    m1.loadTableCourse(studentNumber , semester , tableCourse);
                                } catch (FileNotFoundException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                textField.setBackground(Color.WHITE);
                                panelSelectUnit.add(panelSelectUnitShowStudent);
                                panelSelectUnit.repaint();
                            }
                        }
                        if ( !studentValid ) {
                            JOptionPane.showMessageDialog(null, "We have not any student with this student number.");
                        }
                    }
                    else {
                        tableCourse = new JTable(12 , 4);
                        tableCourse.setValueAt("Course code", 0, 0);
                        tableCourse.setValueAt("Course name", 0, 1);
                        tableCourse.setValueAt("Testdate", 0, 2);
                        tableCourse.setValueAt("date", 0, 3);

                        panelSelectUnitTable.removeAll();
                        panelSelectUnitTable.add(tableCourse);
                        panelSelectUnitTable.repaint();
                        panelSelectUnitTable.revalidate();

                        panelSelectUnit.add(panelSelectUnitTable);
                        textField.setBackground(Color.yellow);
                        JOptionPane.showMessageDialog(null, "Please Enter a student number.");
                    }
                    counter++ ;
                    f.repaint();
                }
            });


            buttonAddLesson.addActionListener(new ActionListener() {
                int counter=0 ;
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    // check mikonad ke aval shomare daneshjoii ke vared karde dorost hast?
                    String courseCode = tfCourseCode.getText();
                    String courseName = tfCourseName.getText();
                    String testDate = tfTestDate.getText();
                    String date = tfDate.getText();
                    boolean freeBlank = false ;
                    boolean warnning = false ;
                    if ( studentValid ) {


                        if ( courseCode.equals("") ) {
                            tfCourseCode.setBackground(Color.yellow);
                            freeBlank = true ;
                        }
                        else {
                            tfCourseCode.setBackground(Color.white);
                        }
                        if ( courseName.equals("") ) {
                            tfCourseName.setBackground(Color.YELLOW);
                            freeBlank = true ;
                        }
                        else {
                            tfCourseName.setBackground(Color.white);
                        }
                        if ( testDate.equals("") ) {
                            tfTestDate.setBackground(Color.YELLOW);
                            freeBlank = true ;
                        }
                        else {
                            tfTestDate.setBackground(Color.white);
                        }
                        if ( date.equals("") ) {
                            tfDate.setBackground(Color.YELLOW);
                            freeBlank = true ;
                        }
                        else {
                            tfDate.setBackground(Color.white);
                        }
//--------------------------------------------------------------- bayad dorost bodane meghdare field ha check beshe.
                        if ( !freeBlank ) {
                            if ( !isInteger(courseCode) ) {
                                freeBlank = true ;
                                warnning = true ;
                                if ( counter%2 == 0 ) {
                                    JOptionPane.showMessageDialog(null, "Course code should be a number. ");
                                }
                            }
                        }
                        if ( !freeBlank ) {
                            if ( !isString(courseName) ) {
                                freeBlank = true ;
                                warnning = true ;
                                if (  counter%2 == 0 ) {
                                    JOptionPane.showMessageDialog(null, "Course name can not have any number.");
                                }
                            }
                        }
                        if ( !freeBlank ) {
                            if ( isInteger(testDate) ) {
                                freeBlank = true ;
                                warnning = true ;
                                if ( counter%2 == 0 ) {
                                    JOptionPane.showMessageDialog(null, "Test date should be a String.");
                                }
                            }
                        }
                        if ( !freeBlank ) {
                            if ( isInteger(date) ) {
                                freeBlank = true ;
                                warnning = true ;
                                if ( counter%2 == 0 ) {
                                    JOptionPane.showMessageDialog(null, "Date should be a String. ");
                                }
                            }
                        }

                        if ( !freeBlank && !warnning ) {
                            Main m = new Main() ;
                            // bayad check kone ke course code tekrari ezafe nakone.
                            try {
                                freeBlank = m.selectUnit(studentNumber, semester , courseCode, courseName, testDate, date);
                            } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } // agar shomare daneshjoi tekrari bashad engar Field khali hast.
                            if (!freeBlank ) {
                                int row = 0 ;
                                for (int i=0 ; i<Main.link.size() ; i++) {
                                    if ( Main.link.get(i).getStudentNumber().equals(studentNumber) ) {
                                        row = Main.link.get(i).arrSemester.get(semester-1).courseLink.size() ;
                                    }
                                }
                                tableCourse.setValueAt(courseCode, row, 0);
                                tableCourse.setValueAt(courseName, row, 1);
                                tableCourse.setValueAt(testDate, row, 2);
                                tableCourse.setValueAt(date, row, 3);
                                tableCourse.repaint();
                                JOptionPane.showMessageDialog(null, "Operation succeesfully.");
                            }
                        }
                        else if ( !warnning ) {
                            JOptionPane.showMessageDialog(null, "Operation failed.");
                        }

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "We have not any student with this student number.");
                    }


                    counter++ ;
                }
            });
            buttonRemoveLesson.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    String courseCode = tfRemoveLesson.getText() ;
                    if ( studentValid ) {
                        if (isInteger(courseCode)) {
                            Main m1 = new Main();
                            try {
                                m1.deleteCourse(studentNumber , semester , courseCode);
                            } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            try {
                                m1.loadTableCourse(studentNumber, semester , tableCourse);
                            } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            panelSelectUnitTable.removeAll();
                            panelSelectUnitTable.add(tableCourse);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "student number should be integer");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Student number is not valid.Please enter another student number.");
                    }
                }

            });

            f.add(panelSelectUnit);
            panelSelectUnit.setVisible(true);
            f.setVisible(true);
            f.repaint();
        }
    }

}