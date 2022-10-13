/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprinttest;

import com.digitalpersona.onetouch.DPFPCaptureFeedback;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPImageQualityAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPImageQualityEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.FileDialog;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.font.TextAttribute;
import java.awt.print.PrinterException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.UIManager;
import java.sql.Blob;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AYO
 */
public class AttendanceBiometric extends javax.swing.JFrame implements javax.swing.event.DocumentListener{

    /**
     * Creates new form AttendanceBiometric
     */
    
    	private final DPFPCapture capturer = DPFPGlobal.getCaptureFactory().createCapture();
        private final DPFPCapture capturer2 = DPFPGlobal.getCaptureFactory().createCapture();
        private final DPFPCapture capturer3 = DPFPGlobal.getCaptureFactory().createCapture();
        private final DPFPCapture capturer4 = DPFPGlobal.getCaptureFactory().createCapture();
        private final DPFPCapture capturer5 = DPFPGlobal.getCaptureFactory().createCapture();
        private final DPFPCapture capturer6 = DPFPGlobal.getCaptureFactory().createCapture();
        private final DPFPEnrollment enroller = DPFPGlobal.getEnrollmentFactory().createEnrollment();
        private final DPFPEnrollment enroller2 = DPFPGlobal.getEnrollmentFactory().createEnrollment();
        private final DPFPEnrollment enroller3 = DPFPGlobal.getEnrollmentFactory().createEnrollment();
        private final DPFPEnrollment enroller4 = DPFPGlobal.getEnrollmentFactory().createEnrollment();
        private final DPFPVerification verificator = DPFPGlobal.getVerificationFactory().createVerification();
        private final DPFPVerification verificator2 = DPFPGlobal.getVerificationFactory().createVerification();
        private DPFPTemplate template;
        private DPFPTemplate template2;
        private DPFPTemplate template3;
        private DPFPTemplate template4;
        public static String TEMPLATE_PROPERTY = "template";
        public static String TEMPLATE_PROPERTYY = "template";
        public static String TEMPLATE_PROPERTIE = "template";
        public static String TEMPLATE_PROPERTIEE = "template";
        private  String lectID, lectID2, idString;
        private  String lecFirNam, lecFirNam2;
        private  String lecLasNam, lecLasNam2;
        private  String sex;
        private  String pWord, pWord2;
        private  String secuQues, secuQues2;
        private  String secuAnsw, secuAnsw2;
        private  byte[] lecPrint; 
        private  String matNo;
        private  String fName;
        private  String lName;
        private  String dept;       
        private  byte[] fPrint;
        private String genderString;
        private String[] studentMarked = new String[200];
        private int index=0;
        private SimpleDateFormat date,time;
       	protected Connection con;
        protected boolean isActivee=false;
        protected boolean isActiveee=false;
        protected boolean isActivie=false;
        protected boolean isActivee2=false;
        protected boolean lecturerVerificationIsActive=false;
        protected boolean lecturerEnrollmentIsActive=false;
        protected boolean studentVerificationIsActive=false;
        protected boolean isEdited=false;
        protected boolean isOpened = false;
        protected boolean p1=false;
        protected boolean p2=false;
        protected boolean p3=false;
        protected boolean p4=false;
        protected boolean p5=false;
        

    
    public AttendanceBiometric() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/rsz_fingerprints-fb-1.png")));
        setMinimumSize(new Dimension(1380,10));
        initComponents();
        jLabel36.setVisible(false);
        id.setVisible(false);
        showLoginPane();
        getContentPane().setBackground(new Color(6, 52, 74));
        jPanel6.setBackground(new Color(6, 52, 74));
        jLabel34.setForeground(Color.white);
        resizeColumnWidth();
        table2Width();
        table3Width();
        myFN.getDocument().addDocumentListener(this);
        myLN.getDocument().addDocumentListener(this);
        myPW.getDocument().addDocumentListener(this);
        mySA.getDocument().addDocumentListener(this);
        
        jList1.setSelectionModel(new DefaultListSelectionModel(){
            @Override
            public void setSelectionInterval(int index0, int index1){
                if (super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }else{
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        
        jList2.setSelectionModel(new DefaultListSelectionModel(){
            @Override
            public void setSelectionInterval(int index0, int index1){
                if (super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }else{
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        signupPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lecIDTxt = new javax.swing.JTextField();
        lecFirNamTxt = new javax.swing.JTextField();
        lecLasNamTxt = new javax.swing.JTextField();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        pWordTxt = new javax.swing.JPasswordField();
        conPwordTxt = new javax.swing.JPasswordField();
        jLabel22 = new javax.swing.JLabel();
        secuQuesTxt = new javax.swing.JComboBox<>();
        secuAnswTxt = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lectFingerSample = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jDialog2 = new javax.swing.JDialog();
        jLabel26 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jDialog3 = new javax.swing.JDialog();
        pic3 = new javax.swing.JLabel();
        sampLeft2 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        matTextBox1 = new javax.swing.JTextField();
        jComboBox8 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jDialog4 = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jDialog5 = new javax.swing.JDialog();
        pic1 = new javax.swing.JLabel();
        prompt1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        report1 = new javax.swing.JTextArea();
        sampLeft1 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bck1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        report = new javax.swing.JTextArea();
        sampLeft = new javax.swing.JLabel();
        matTextBox = new javax.swing.JTextField();
        fNameTextBox = new javax.swing.JTextField();
        lNameTextBox = new javax.swing.JTextField();
        deptTextBox = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        pic = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        id = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        pic2 = new javax.swing.JLabel();
        prompt2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        veriReport = new javax.swing.JTextArea();
        farStat = new javax.swing.JLabel();
        scanBtn = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        myFN = new javax.swing.JTextField();
        myLN = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        myPW = new javax.swing.JPasswordField();
        myCP = new javax.swing.JPasswordField();
        mySQ = new javax.swing.JComboBox<>();
        mySA = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        myID = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        txtUser = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jComboBox7 = new javax.swing.JComboBox<>();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        matCustom = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        totalClass = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();

        jDialog1.setTitle("Sign Up");
        jDialog1.setBackground(new java.awt.Color(255, 255, 250));
        jDialog1.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/rsz_fingerprints-fb-1.png")));
        jDialog1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jDialog1ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jDialog1ComponentShown(evt);
            }
        });
        jDialog1.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                jDialog1WindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                jDialog1WindowLostFocus(evt);
            }
        });
        jDialog1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialog1WindowClosed(evt);
            }
        });

        signupPanel.setBackground(new java.awt.Color(255, 255, 255));
        signupPanel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sign Up");

        lecIDTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lecIDTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lecturer ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        lecFirNamTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lecFirNamTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        lecLasNamTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lecLasNamTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        radioMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radioMale);
        radioMale.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        radioMale.setSelected(true);
        radioMale.setText("Male");
        radioMale.setBorder(null);

        radioFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(radioFemale);
        radioFemale.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        radioFemale.setText("Female");
        radioFemale.setBorder(null);

        pWordTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pWordTxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pWordTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        conPwordTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        conPwordTxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        conPwordTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirm Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Security Question");

        secuQuesTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        secuQuesTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your middle name?", "What is your grandmother's maiden name?", "What primary school did you attend?", "Where did you live as a child?" }));

        secuAnswTxt.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        secuAnswTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Security Answer", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(51, 102, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setText("Sign Up");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        lectFingerSample.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lectFingerSample.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lectFingerSample.setText("Fingerprint samples needed: ");

        javax.swing.GroupLayout signupPanelLayout = new javax.swing.GroupLayout(signupPanel);
        signupPanel.setLayout(signupPanelLayout);
        signupPanelLayout.setHorizontalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addComponent(pWordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lecIDTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(lecLasNamTxt))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(signupPanelLayout.createSequentialGroup()
                                .addComponent(lecFirNamTxt)
                                .addContainerGap())
                            .addGroup(signupPanelLayout.createSequentialGroup()
                                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(signupPanelLayout.createSequentialGroup()
                                        .addComponent(radioMale, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioFemale))
                                    .addComponent(conPwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(155, 155, 155))
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lectFingerSample, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(secuAnswTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(signupPanelLayout.createSequentialGroup()
                                    .addGap(55, 55, 55)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(signupPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(secuQuesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        signupPanelLayout.setVerticalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(33, 33, 33)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lecIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lecFirNamTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lecLasNamTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioMale)
                    .addComponent(radioFemale))
                .addGap(18, 18, 18)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conPwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pWordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secuQuesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secuAnswTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lectFingerSample, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(signupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(signupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jDialog2.setTitle("Forget Password");
        jDialog2.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/rsz_fingerprints-fb-1.png")));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Enter New Password");

        jPasswordField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jPasswordField2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirm Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton7.setText("Close");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton8.setText("Change");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setText("Lecturer ID: ");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel30.setText("Lecturer Name: ");

        jCheckBox2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jCheckBox2.setText("Show");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 478, Short.MAX_VALUE))
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jCheckBox2))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jButton7)
                        .addGap(54, 54, 54)
                        .addComponent(jButton8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(222, 222, 222))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(104, 104, 104))))
        );

        jDialog3.setTitle("Update Template");
        jDialog3.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/rsz_fingerprints-fb-1.png")));
        jDialog3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jDialog3ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jDialog3ComponentShown(evt);
            }
        });
        jDialog3.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                jDialog3WindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                jDialog3WindowLostFocus(evt);
            }
        });
        jDialog3.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialog3WindowClosed(evt);
            }
        });

        pic3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        sampLeft2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        sampLeft2.setText("Fingerprint Sample Left: ");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel41.setText("Reset Sample");
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });

        matTextBox1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        matTextBox1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matric Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        matTextBox1.setPreferredSize(new java.awt.Dimension(13, 50));

        jComboBox8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton14.setText("Update Template");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("f");
        jLabel42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(sampLeft2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(matTextBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel41))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton14)
                .addGap(158, 158, 158))
            .addGroup(jDialog3Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(pic3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog3Layout.createSequentialGroup()
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(pic3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jDialog3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sampLeft2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matTextBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jDialog4.setTitle("List of Student");
        jDialog4.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/rsz_fingerprints-fb-1.png")));

        jTable3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "Name", "Department", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(25);
        jScrollPane6.setViewportView(jTable3);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("jLabel21");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("jLabel21");

        javax.swing.GroupLayout jDialog4Layout = new javax.swing.GroupLayout(jDialog4.getContentPane());
        jDialog4.getContentPane().setLayout(jDialog4Layout);
        jDialog4Layout.setHorizontalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialog4Layout.setVerticalGroup(
            jDialog4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jDialog5.setTitle("Change Fingerprint");
        jDialog5.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/rsz_fingerprints-fb-1.png")));
        jDialog5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jDialog5ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jDialog5ComponentShown(evt);
            }
        });
        jDialog5.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                jDialog5WindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                jDialog5WindowLostFocus(evt);
            }
        });
        jDialog5.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                jDialog5WindowClosed(evt);
            }
        });

        pic1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        prompt1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        prompt1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        report1.setEditable(false);
        report1.setColumns(20);
        report1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        report1.setRows(5);
        report1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane7.setViewportView(report1);

        sampLeft1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        sampLeft1.setText("Fingerprint Sample Left: ");

        jButton12.setText("Close");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Change");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel37.setText("Reset Sample");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel37MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jDialog5Layout = new javax.swing.GroupLayout(jDialog5.getContentPane());
        jDialog5.getContentPane().setLayout(jDialog5Layout);
        jDialog5Layout.setHorizontalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(sampLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pic1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prompt1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37)
                        .addGap(89, 89, 89)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addGap(188, 188, 188))
        );
        jDialog5Layout.setVerticalGroup(
            jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDialog5Layout.createSequentialGroup()
                        .addComponent(prompt1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sampLeft1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jDialog5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Attendance Biometric");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(4400, 3000));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(555, 353));
        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel2FocusLost(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        bck1.setBackground(new java.awt.Color(255, 255, 255));
        bck1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn.png"))); // NOI18N
        bck1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bck1.setOpaque(true);
        bck1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bck1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bck1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bck1MouseExited(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_logout.png"))); // NOI18N
        jLabel28.setText("   Sign Out");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.setOpaque(true);
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_class-control-panel.png"))); // NOI18N
        jLabel1.setText("   Class Control Panel");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_profile.png"))); // NOI18N
        name.setText("   Profile");
        name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        name.setOpaque(true);
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nameMouseExited(evt);
            }
        });

        jLabel40.setBackground(new java.awt.Color(255, 255, 255));
        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_attendance-record.png"))); // NOI18N
        jLabel40.setText("   Attendance Report");
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel40.setOpaque(true);
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
        });

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_mark-attendance.png"))); // NOI18N
        jLabel25.setText("   Mark Attendance");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.setOpaque(true);
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_1enroll-students.png"))); // NOI18N
        jLabel6.setText("   Enroll Student");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(bck1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bck1)
                .addGap(90, 90, 90)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        report.setEditable(false);
        report.setColumns(20);
        report.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        report.setRows(5);
        report.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane1.setViewportView(report);

        sampLeft.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        sampLeft.setText("Fingerprint Sample Left: ");

        matTextBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        matTextBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matric Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        matTextBox.setPreferredSize(new java.awt.Dimension(13, 50));

        fNameTextBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        fNameTextBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First Name", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        fNameTextBox.setPreferredSize(new java.awt.Dimension(13, 50));

        lNameTextBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lNameTextBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        deptTextBox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        deptTextBox.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Department", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        deptTextBox.setPreferredSize(new java.awt.Dimension(13, 50));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setText("Enroll Student");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        pic.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel35.setText("Reset Sample");
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
        });

        jComboBox5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        jList2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jList2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jList2.setEnabled(false);
        jScrollPane9.setViewportView(jList2);

        jCheckBox4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jCheckBox4.setText("Enroll to Specific Course");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Students Enrollment");

        id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id.setText("id");

        jButton15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton15.setText("Update Student");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(matTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lNameTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(deptTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(sampLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel35))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(id)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(491, 491, 491))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton15)
                        .addGap(473, 473, 473))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sampLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(matTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deptTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel4ComponentShown(evt);
            }
        });

        pic2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        prompt2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        prompt2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        veriReport.setEditable(false);
        veriReport.setColumns(20);
        veriReport.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        veriReport.setRows(5);
        veriReport.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jScrollPane2.setViewportView(veriReport);

        farStat.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        farStat.setText("False Accept Rate = 0");

        scanBtn.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        scanBtn.setText("Take Attendance");
        scanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanBtnActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jComboBox6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Mark Attendance");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scanBtn)
                .addGap(352, 352, 352))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(pic2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(farStat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prompt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prompt2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pic2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(farStat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(scanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel8ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel8ComponentShown(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Class Control Panel");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Update  Course");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("View Student");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add  Course");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "Course Code", "Course Title", "Classes Held", "Last Held"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.setRowHeight(30);
        jScrollPane3.setViewportView(jTable2);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/empty-school-class-background_52683-47680.jpg"))); // NOI18N
        jLabel39.setText("jLabel39");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(382, 382, 382))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator3))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(219, 219, 219)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(324, Short.MAX_VALUE)))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel5ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel5ComponentShown(evt);
            }
        });

        myFN.setEditable(false);
        myFN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        myFN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "First Name", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        myLN.setEditable(false);
        myLN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        myLN.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Last Name", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/upt.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setEnabled(false);
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton9MouseExited(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        myPW.setEditable(false);
        myPW.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        myPW.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        myCP.setEditable(false);
        myCP.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        myCP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirm Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        mySQ.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        mySQ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your middle name?", "What is your grandmother's maiden name?", "What primary school did you attend?", "Where did you live as a child?" }));
        mySQ.setEnabled(false);

        mySA.setEditable(false);
        mySA.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        mySA.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Security Answer", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Change Fingerprint");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_pencil-vector-icon.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_pencil-vector-icon.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_pencil-vector-icon.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rsz_pencil-vector-icon.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });

        myID.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        myID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jList1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jList1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jScrollPane5.setViewportView(jList1);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Create Class");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Update Class");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Profile");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator7)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(myID, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(309, 309, 309))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mySQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myPW, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(27, 27, 27)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(mySA, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                        .addComponent(myCP))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(myLN, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane5)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                            .addComponent(myFN, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(153, 153, 153)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(400, 400, 400))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addGap(375, 375, 375))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(myID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myFN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myLN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(myPW, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(myCP, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mySA, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mySQ, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jButton9)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel6ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel6ComponentShown(evt);
            }
        });
        jPanel6.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(555, 353));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sign Up");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Forget Password");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Sign In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setText("Quit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtPass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtPass.setText("harabb00");
        txtPass.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        txtUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtUser.setText("FPOG/REG/PF/8000");
        txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lecturer ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jCheckBox1.setText("show");
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sign In");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtUser, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox1)
                        .addGap(105, 105, 105))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel1);
        jPanel1.setBounds(300, 160, 555, 353);

        jLabel34.setFont(new java.awt.Font("Georgia", 0, 28)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("ATTENDANCE BIOMETRIC");
        jPanel6.add(jLabel34);
        jLabel34.setBounds(340, 10, 440, 40);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Biometric-2.v4.png"))); // NOI18N
        jPanel6.add(jLabel31);
        jLabel31.setBounds(0, 50, 1120, 600);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel7ComponentHidden(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel7ComponentShown(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Select Class");

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S/N", "Matric Number", "Class Present", "Class Absent", "Class Held", "Percentage (%)", "Course"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jScrollPane4.setViewportView(jTable1);

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Search Mode");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Clear Table");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Overall");

        jComboBox7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jRadioButton2.setText("Custom");
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton2ItemStateChanged(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Select Course");

        matCustom.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        matCustom.setToolTipText("Enter student matriculation number");
        matCustom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matric Number", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N
        matCustom.setEnabled(false);

        totalClass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        totalClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalClass.setText("Total no. of class held: NA");

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton10.setText("Veiw Report");
        jButton10.setToolTipText("Click to display attendance report in a tabular form");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton11.setText("Print Report");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Attendance Report");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Percentage: ");
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jRadioButton1)
                        .addGap(47, 47, 47)
                        .addComponent(jRadioButton2)
                        .addGap(40, 40, 40)
                        .addComponent(matCustom, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel14)))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(totalClass, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 994, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(467, 467, 467))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(473, 473, 473))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(483, 483, 483))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(matCustom, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalClass, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(5362, 1480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    jDialog2.dispose();
    idString = "";
        char [] a = txtPass.getPassword();
            String pass = new String(a);
            boolean isCorrect = false;
            
        if (txtUser.getText().isBlank() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(jPanel1, "Enter Lecturer ID and Password");
            return;
        } 
             try {
            ResultSet rs;
            Statement st = connect().createStatement();
            rs = st.executeQuery("SELECT l.lecturerID, l.firstName, l.lastName, lo.fingerPrint, lo.password from lecturer_info"
                    + " l left join login_info lo using(lecturerID)");
               while (rs.next()) {
                   
                if (rs.getString("lecturerID").equalsIgnoreCase(txtUser.getText()) && rs.getString("password").equals(pass)) {
                    
                    id.setText(rs.getString("lecturerID").toUpperCase());
                    String na,me;
                    na=rs.getString("firstName");
                    me=rs.getString("lastName");
                    name.setText("   "+na.substring(0, 1).toUpperCase()+""+na.substring(1).toLowerCase()+" "
                            +me.substring(0, 1).toUpperCase()+""+me.substring(1));
                    txtPass.setText("");
                    
                    allPanelInvisible();
                    jDialog1.dispose();
                    getContentPane().setBackground(Color.WHITE);
                    showEnrollPane();
                    isCorrect = true;
                    break;
                }                
            }
                if (!isCorrect){
                    JOptionPane.showMessageDialog(jPanel1, "Password or Lecturer ID is incorrect");
                    return;
                }
                st.close();
                rs.close();
        } catch (SQLException | NullPointerException e) {
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (matTextBox.getText().isBlank() || null == enroller2.getTemplate() || fNameTextBox.getText().isBlank()
                || lNameTextBox.getText().isBlank() || deptTextBox.getText().isBlank() || jComboBox1.getSelectedIndex()==-1
                 || jComboBox5.getSelectedItem().equals("Select Class")) {
                JOptionPane.showMessageDialog(jPanel3, "Enroll student fingerprint, Select a class and enter student details\nto save record.",
                        "Enroll Student", JOptionPane.ERROR_MESSAGE);
                return;
            }
        
        getEnrollmentInput();
        
        if(jCheckBox4.isSelected()){
            String c = jComboBox5.getSelectedItem().toString();
            if(jList2.getSelectedIndex()==-1){
                infoMessage(jPanel3, "Select course(s) from the list.", "Enroll Student");
                return;
            }
            insertStudent(matNo, fName, lName, dept, genderString, fPrint, c);
            for(String a : jList2.getSelectedValuesList()){
            String b [] = a.split("-");
            insertStudentCourse(matNo, c, b[0]);
        }
        report.append("Student enrolled successfully.\n");
        jList2.clearSelection();
        clearTextbox();
        enroller2.clear();
        updateSampleLeft();
        
        if(!capturer2.isStarted()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
          
        }
            return;
        }
        String c = jComboBox5.getSelectedItem().toString();
        insertStudentInfo(matNo, fName, lName, dept, genderString, fPrint, c);
        
        clearTextbox();
        enroller2.clear();
        updateSampleLeft();
        
        if(!capturer2.isStarted()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
          
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown
        if (jPanel3.isVisible()) {
            jLabel6.setBackground(new Color(100,149,237));
            p1=true;
        }
        if (isActivee) {
            
        }else{
            studentEnrollment();
            isActivee=true;
        }
        getClass(jComboBox5, jPanel3);
        updateSampleLeft();
        if(!capturer2.isStarted()){
            stopAllCapturer();
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
            
        }
    }//GEN-LAST:event_jPanel3ComponentShown

    private void jPanel3ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentHidden
        jLabel6.setBackground(Color.white);
        p1=false;
        capturer2.stopCapture();
    }//GEN-LAST:event_jPanel3ComponentHidden

    private void jPanel4ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel4ComponentShown
        if (jPanel4.isVisible()) {
            jLabel25.setBackground(new Color(100,149,237));
            p2=true;
        }
        if (studentVerificationIsActive) {
            
        }else{
            studentVerification();
            studentVerificationIsActive=true;
        }
           updateStatus(0);
           prompt2.setText("Using the fingerprint reader, scan your fingerprint.");
           getClass(jComboBox2, jPanel4);
    }//GEN-LAST:event_jPanel4ComponentShown

    private void jPanel4ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel4ComponentHidden
        jLabel25.setBackground(Color.white);
        p2=false;
        capturer3.stopCapture();
        jComboBox2.removeAllItems();
        jComboBox2.setEnabled(true);
        pic2.setIcon(null);
        Arrays.fill(studentMarked, null);
        updateStatus(0);
        scanBtn.setText("Take Attendance");
    }//GEN-LAST:event_jPanel4ComponentHidden

    private void bck1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bck1MouseClicked
       if(jPanel2.getWidth()==56){
        jPanel2.setSize(290,729);
       }else{
          jPanel2.setSize(56, 729);
        }
    }//GEN-LAST:event_bck1MouseClicked

    private void scanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanBtnActionPerformed
        if (jComboBox2.getSelectedItem().equals("Select Class") || jComboBox6.getSelectedItem().equals("Select Course")) {
            JOptionPane.showMessageDialog(jPanel4, "Choose a Class and Course before taking attendance", "Attendance Marking", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(capturer3.isStarted()){
            int a = JOptionPane.showConfirmDialog(jPanel4, "Are you sure want to want to end attendance marking?\n"
                    + "NOTE: Any student who hasn't been marked will be\nabsent for this class.", 
                    "Attendance Marking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (a==JOptionPane.YES_OPTION) {
                Arrays.fill(studentMarked, null);
                capturer3.stopCapture();
                scanBtn.setText("Take Attendance");
                jComboBox2.setEnabled(true);
                jComboBox6.setEnabled(true);
            }
        }else{
            int a = JOptionPane.showConfirmDialog(jPanel4, "Are you sure you want to mark attendance for\n"
                    + "course "+jComboBox6.getSelectedItem().toString()+"? \nThis will increase total class by +1", 
                    "Attendance Marking", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (a==JOptionPane.YES_OPTION) {
                jComboBox2.setEnabled(false);
                jComboBox6.setEnabled(false);
                scanBtn.setText("End Attendance");
                stopAllCapturer();
                capturer3.startCapture();
                prompt2.setText("Using the fingerprint reader, scan your fingerprint.");
            
            try {
                Statement st = connect().createStatement();
                st.executeUpdate("update courses set classHeld = classHeld+1, lastHeld = '"+dateTime()+"'"
                        + " where lecturerID = '"+id.getText()+"' "
                        + "and className = '"+jComboBox2.getSelectedItem().toString()+"' "
                                + "and courseCode = '"+jComboBox6.getSelectedItem().toString()+"'");
                
                ResultSet res;
                int classesHeld=0;
                try {
            Statement sa = connect().createStatement();
            res = sa.executeQuery("Select * from courses where lecturerID = '"+id.getText()+"' "
                    + "and className='"+jComboBox2.getSelectedItem().toString()+"' and"
                            + " courseCode = '"+jComboBox6.getSelectedItem().toString()+"' limit 1");
            while(res.next()){
                classesHeld = res.getInt("classHeld");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanel4, e.getMessage());
            return;
        }
                
                 Statement statement = connect().createStatement();
                 statement.executeUpdate("update attendance set classHeld ="+classesHeld+", classAbsent = classHeld - classPresent, "
                         + "attendancePercentage= classPresent/classHeld * 100 where lecturerID = '"+id.getText()+"' "
                        + "and className='"+jComboBox2.getSelectedItem().toString()+"'"
                                + " and courseCode = '"+jComboBox6.getSelectedItem().toString()+"'");
                
                ResultSet rs;
                Statement s = connect().createStatement();
                rs = s.executeQuery("select * from courses where lecturerID = '"+id.getText()+"' "
                        + "and className = '"+jComboBox2.getSelectedItem().toString()+"' and courseCode= '"+jComboBox6.getSelectedItem().toString()+"'");
                while (rs.next()) {
                    veriReport.append("Attendance for "+rs.getString("courseCode")+", class No. "+rs.getInt("classHeld")+" has started. \n");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jPanel4, e.getMessage(), "Attendance Marking", JOptionPane.ERROR_MESSAGE);
            }

            }
            
        }
    }//GEN-LAST:event_scanBtnActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        stop();
        jDialog1.setSize(new Dimension(550, 610));
        jDialog1.setLocationRelativeTo(null);
        jDialog1.getContentPane().setBackground(new java.awt.Color(255,255,255));
        openDialog(jDialog1);
        jDialog1.pack();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        capturer4.stopCapture();
        showLoginPane();
        signupPanel.revalidate();
        enroller.clear();
        jDialog1.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

            @SuppressWarnings("unchecked")
    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel3MouseEntered

            @SuppressWarnings("unchecked")
    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel3MouseExited

            @SuppressWarnings("unchecked")
    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel4MouseEntered

            @SuppressWarnings("unchecked")
    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        Font font = jLabel4.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        jLabel4.setFont(font.deriveFont(attributes));
        jLabel4.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel4MouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(lecIDTxt.getText().isBlank() || lecFirNamTxt.getText().isBlank() || lecLasNamTxt.getText().isBlank()
                || secuAnswTxt.getText().isBlank() || pWordTxt.getPassword().length==0){
            JOptionPane.showMessageDialog(jDialog1, "Enter all details", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
            return;
                }
        
        if (pWordTxt.getPassword().length<6) {
            JOptionPane.showMessageDialog(null, "Password must be at least 6 characters", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!Arrays.equals(pWordTxt.getPassword(), conPwordTxt.getPassword())){
            JOptionPane.showMessageDialog(jDialog1, "Password confirmation not the same", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
             
        switch (enroller.getTemplateStatus()){
            case TEMPLATE_STATUS_INSUFFICIENT:
            infoMessage(jDialog1, "Fingerprint sample needed is not complete\nSamples left: "+enroller.getFeaturesNeeded()+"", "Sign Up");
            return;
        }
        
        getSignUpInfo();
        
        ResultSet rs; 
        try {
            Statement st = connect().createStatement();
            rs = st.executeQuery("Select * from lecturer_info where lecturerID = '"+lectID+"'");
            while(rs.next()){
                infoMessage(signupPanel, "User with ID: "+lectID+" already exist.", "Sign Up");
                return;
            }
        } catch (SQLException e) {
            errorMessage(signupPanel, e.getMessage(), "Existing User");
        }
        
        lecturerInfoInsertStatement(lectID, lecFirNam, lecLasNam, sex, secuQues, secuAnsw, pWord, lecPrint);
        enroller.clear();
        clearTextbox();
        if (!capturer4.isStarted()) {
            try {
                capturer4.startCapture();
            } catch (RuntimeException e) {
            }
            
        }
        updateSample();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jDialog1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDialog1ComponentShown
        capturer.stopCapture();
        if (lecturerEnrollmentIsActive) {
            
        }else{
            lecturerEnrollment();
            lecturerEnrollmentIsActive=true;
        }
        if(!capturer4.isStarted()){
            try {
                capturer4.startCapture();
            } catch (RuntimeException e) {
            }
        }
        updateSample();
        
    }//GEN-LAST:event_jDialog1ComponentShown

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      idString = JOptionPane.showInputDialog(jPanel1, "Enter Lecturer ID", "Forget password", JOptionPane.QUESTION_MESSAGE);
      
       ResultSet rs;
       String ques,ans,nam,nam2;
                        try (Statement st = connect().createStatement()) {
                            rs = st.executeQuery("select * from lecturer_info where lecturerID = '"+idString+"'");
                            
                            if(rs.next()){
                                 ques = rs.getString("securityQuestion");
                                 ans = rs.getString("securityAnswer");
                                 nam = rs.getString("firstName");
                                 nam2 = rs.getString("lastName");
                            }else{
                                JOptionPane.showMessageDialog(jPanel1, "Lecturer ID: "+idString.toUpperCase()+" not found");
                                return;
                            }
                            
                            String an = JOptionPane.showInputDialog(jPanel1, ques, "Answer the security answer", JOptionPane.INFORMATION_MESSAGE);
                            
                            if (an.equalsIgnoreCase(ans)) {
                                jLabel30.setText(nam.substring(0,1).toUpperCase()+nam.substring(1)+" "+nam2.substring(0,1).toUpperCase()
                                        +nam2.substring(1));
                                jLabel29.setText(idString.toUpperCase());
                                openDialog(jDialog2);
                            }else{
                                JOptionPane.showMessageDialog(jPanel1, "Security question is incorrect");
                            }
                            
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(jPanel1, ex.getMessage());
                }catch (NullPointerException ex){}
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            if (jPasswordField1.getPassword().length==0) {
            JOptionPane.showMessageDialog(jDialog2, "Enter your password", "Change Password", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (jPasswordField1.getPassword().length<6) {
            JOptionPane.showMessageDialog(jDialog2, "Password must be at least 6 characters", "Change Password", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!Arrays.equals(jPasswordField1.getPassword(), jPasswordField2.getPassword())){
            JOptionPane.showMessageDialog(jDialog2, "Password confirmation not the same", "Change Password", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        char[] pass = jPasswordField1.getPassword();
         String   passString = new String(pass);
        try {
            Statement sta = connect().createStatement();
            sta.executeUpdate("Update login_info Set password= '"+passString+"' where lecturerID= '"+idString+"'");
            JOptionPane.showMessageDialog(jDialog2, "Password changed sucessfully");
            idString = null;
            jPasswordField1.setText("");
            jPasswordField2.setText("");
            allPanelInvisible();
            jLabel29.setText("Lecturer ID: ");
            jLabel30.setText("Lecturer Name: ");
            showLoginPane();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jDialog2, e.getMessage());
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        allPanelInvisible();
        showLoginPane();
        jDialog2.dispose();
        idString=null;
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        enroller2.clear();
        pic.setIcon(null);
        updateSampleLeft();
        if(!capturer2.isStarted()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
            
        }
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jDialog1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDialog1ComponentHidden
         capturer4.stopCapture();
         enroller.clear();
    }//GEN-LAST:event_jDialog1ComponentHidden
                @SuppressWarnings("unchecked")
    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        Font font = jLabel35.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel35.setFont(font.deriveFont(attributes));
        jLabel35.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel35MouseEntered
                @SuppressWarnings("unchecked")
    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
        Font font = jLabel35.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        jLabel35.setFont(font.deriveFont(attributes));
        jLabel35.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel35MouseExited
               @SuppressWarnings("unchecked")
    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        Font font = jLabel8.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel8.setFont(font.deriveFont(attributes));
        jLabel8.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel8MouseEntered
               @SuppressWarnings("unchecked")
    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        Font font = jLabel8.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        jLabel8.setFont(font.deriveFont(attributes));
        jLabel8.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel8MouseExited
       @SuppressWarnings({"unchecked", "unchecked", "unchecked", "unchecked", "unchecked", "unchecked"})
    private void jPanel5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel5ComponentShown
        if (jPanel5.isVisible()) {
            name.setBackground(new Color(100,149,237));
            p4=true;
        }
        if (isEdited) {
            jButton9.setEnabled(false);
        }else{
            jButton9.setEnabled(false);
        }
               DefaultListModel listModel = new DefaultListModel();
               listModel.removeAllElements();
               jList1.setModel(listModel);
        ResultSet rs;
        try(Statement st = connect().createStatement()) {
            rs= st.executeQuery("SELECT l.lecturerID, l.firstName, l.lastName, l.securityQuestion, l.securityAnswer,"
                    + " cg.className, lo.password from lecturer_info l left join login_info lo on lo.lecturerID=l.lecturerID"
                    + " left join class_group cg on cg.lecturerID=l.lecturerID  where l.lecturerID='"+id.getText()+"'");
            while(rs.next()){
               myID.setText(rs.getString("lecturerID").toUpperCase());
               myFN.setText(rs.getString("firstName"));
               myLN.setText(rs.getString("lastName"));
               myPW.setText(rs.getString("password"));
               myCP.setText(rs.getString("password"));
               listModel.addElement(rs.getString("className"));
               mySQ.setSelectedItem(rs.getString("securityQuestion"));
               mySA.setText(rs.getString("securityAnswer"));
              
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanel5, e.getMessage());
        }catch(NullPointerException e){
            
        }
    }//GEN-LAST:event_jPanel5ComponentShown

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       if (myID.getText().isBlank() || myFN.getText().isBlank() || myLN.getText().isBlank() || mySA.getText().isBlank()) {
            JOptionPane.showMessageDialog(jPanel5, "Field(s) can't be left blank", "Profile Update", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       if (myPW.getPassword().length==0) {
            JOptionPane.showMessageDialog(jPanel5, "Enter your password", "Profile Update", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (myPW.getPassword().length<6) {
            JOptionPane.showMessageDialog(jPanel5, "Password must be at least 6 characters", "Profile Update", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if(!Arrays.equals(myPW.getPassword(), myCP.getPassword())){
            JOptionPane.showMessageDialog(jPanel5, "Password confirmation not the same", "Profile Update", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        getProfileUpdateDetails();
        try {
            Statement st = connect().createStatement();
            st.executeUpdate("update lecturer_info left join login_info on lecturer_info.lecturerID = login_info.lecturerID"
                    + " set lecturer_info.firstName ='"+lecFirNam2.trim()+"', lecturer_info.lastName = '"+lecLasNam2.trim()+"',"
                            + " lecturer_info.securityQuestion ='"+secuQues2+"', lecturer_info.securityAnswer = '"+secuAnsw2.trim()+"',"
                                    + " login_info.password = '"+pWord2+"' where lecturer_info.lecturerID = '"+lectID2.toUpperCase().trim()+"'");
            
            JOptionPane.showMessageDialog(jPanel5, "Record successfully updated", "Profile Update", JOptionPane.INFORMATION_MESSAGE);
            myFN.setEditable(false);
            myLN.setEditable(false);
            myPW.setEditable(false);
            myCP.setEditable(false);
            mySA.setEditable(false);
            mySQ.setEditable(false);
            jButton9.setEnabled(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanel5, e.getMessage(), "Profile Update", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        if (!myFN.isEditable()) {
            myFN.setEditable(true);
        }
        
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        if (!myLN.isEditable()) {
            myLN.setEditable(true);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        if (!myPW.isEditable()) {
            myPW.setEditable(true);
            myCP.setEditable(true);
        }
        
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        if (!mySA.isEditable()) {
             mySA.setEditable(true);
             mySQ.setEnabled(true);
        }
       
    }//GEN-LAST:event_jLabel16MouseClicked
       @SuppressWarnings("unchecked")
    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        Font font = jLabel11.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel11.setFont(font.deriveFont(attributes));
        jLabel11.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel11MouseEntered
        @SuppressWarnings("unchecked")
    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        Font font = jLabel11.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        jLabel11.setFont(font.deriveFont(attributes));
        jLabel11.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel11MouseExited
        @SuppressWarnings("unchecked")
    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        Font font = jLabel12.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel12.setFont(font.deriveFont(attributes));
        jLabel12.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel12MouseEntered
        @SuppressWarnings("unchecked")
    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        Font font = jLabel12.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        jLabel12.setFont(font.deriveFont(attributes));
        jLabel12.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel12MouseExited
       @SuppressWarnings("unchecked")
    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        Font font = jLabel15.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel15.setFont(font.deriveFont(attributes));
        jLabel15.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel15MouseEntered
        @SuppressWarnings("unchecked")
    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        Font font = jLabel15.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        jLabel15.setFont(font.deriveFont(attributes));
        jLabel15.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel15MouseExited
        @SuppressWarnings("unchecked")
    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        Font font = jLabel16.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        jLabel16.setFont(font.deriveFont(attributes));
        jLabel16.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel16MouseEntered
        @SuppressWarnings("unchecked")
    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        Font font = jLabel16.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        jLabel16.setFont(font.deriveFont(attributes));
        jLabel16.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
            if (jButton9.isEnabled()) {
                try {
                    jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/upt2.png")));
                } catch (Exception e) {
                }
  
            }
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseExited
        if (jButton9.isEnabled()) {
            try {
                jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/upt.png")));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton9MouseExited

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (jComboBox3.getSelectedIndex() == 0 || jComboBox7.getSelectedIndex() == 0 ) {
            JOptionPane.showMessageDialog(jPanel7, "Choose a class and course", "Attendance Report", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (jRadioButton1.isSelected()) {
            jTable1.setPreferredScrollableViewportSize(new Dimension(500, 70));
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                 },
                new String [] {
                                "S/N", "Matric Number", "Class Present", "Class Absent", "Class Held", "Percentage (%)", "Course"
                }
            ){
    boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
            });
            jLabel36.setVisible(false);
            resizeColumnWidth();
            showStudentsReport();
        }else if (jRadioButton2.isSelected()){
            if(matCustom.getText().isBlank()){
                infoMessage(jPanel7, "Enter Student Matric Number", "Custom Search");
                    return;
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
            "S/N", "Name", "Department", "Sex", "Date", "Lesson", "Course"
            }
            ){
    boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }});
            resizeColumnWidth2();
            ResultSet rs;
            try {
                boolean isFound = false;
                Statement st = connect().createStatement();
                rs = st.executeQuery("SELECT s.matricNumber, s.firstName, s.lastName, s.department, a.lesson, " +
                       " s.sex, a.courseCode, DATE_FORMAT(a.date, '%D %b %Y') d,"
                        + " TIME_FORMAT(a.time, '%h:%i %p') t, b.courseTitle, b.classHeld from student_info s left join attendance_details" +
                            " a on s.matricNumber = a.matricNumber left join courses b on a.courseCode = b.courseCode where" +
                                " a.lecturerID= '"+id.getText()+"' and a.courseCode='"+jComboBox7.getSelectedItem().toString()+"'" +
                                    " and a.className = '"+jComboBox3.getSelectedItem().toString()+"'"
                                            + " and s.matricNumber='"+matCustom.getText()+"';");
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                int i =1;
                
                while(rs.next()){
                    model.addRow(new Object[]{i, rs.getString("firstName")+"  "+rs.getString("lastName"),
                     rs.getString("department"), rs.getString("sex"), rs.getString("t")+", "+rs.getString("d"), 
                    rs.getString("lesson"), rs.getString("courseCode")+" - "+rs.getString("courseTitle")});
                    totalClass.setText("Total no. of class held: "+rs.getInt("classHeld"));
                    i++;
                 isFound = true;   
                }
                jLabel36.setVisible(true);
                jLabel36.setText("Percentage: "+getPercentage(matCustom.getText())+"%");
                if(!isFound){
                    infoMessage(jPanel7, "Student not found", "Custom Search");
                    return;
                }
               jTable1.setModel(model);
            } catch (SQLException e) {
                errorMessage(jPanel7, e.getMessage(), "Attendance Details");
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (jComboBox3.getSelectedItem().equals("Select Class" ) || jComboBox7.getSelectedItem().equals("Select Course")) {
            JOptionPane.showMessageDialog(jPanel7, "Choose a class and course", "Attendance Report", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(jTable1.getRowCount()==0){
            return;
        }
        MessageFormat header=null;
        MessageFormat footer=null;
        
        if(jRadioButton2.isSelected()){
            header = new MessageFormat(jComboBox7.getSelectedItem().toString()+" Attendance Report  "+jLabel36.getText());
            footer = new MessageFormat("Lecturer: "+name.getText());
        }else{
            header = new MessageFormat(jComboBox7.getSelectedItem().toString()+" Attendance Report");
            footer = new MessageFormat("Lecturer: "+name.getText());}
        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException e) {
            errorMessage(jPanel7, "An Error occured while trying to print", "Print Report");
        }
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
       try{     
        Arrays.fill(studentMarked, null);
        getCourse(jComboBox6, jPanel4, jComboBox2.getSelectedItem().toString());
       }catch (NullPointerException e){}
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
            if (evt.getStateChange()==ItemEvent.SELECTED) {
            matCustom.setEnabled(true);
        }else{
                matCustom.setEnabled(false);
            }
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        try{
        String clas = JOptionPane.showInputDialog(jPanel5, "Enter class name", "New Class", JOptionPane.INFORMATION_MESSAGE);
        if(!(clas.isBlank())){
        try {
            PreparedStatement ps = connect().prepareStatement("insert into class_group (className, lecturerID) VALUES(?, ?)");
            ps.setString(1, clas);
            ps.setString(2, id.getText());
            ps.executeUpdate();
            updateClass(jList1);
        } catch (SQLException e) {
            errorMessage(jPanel5, e.getMessage(), "New Class");
        }
        }
        }catch (NullPointerException e){}
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        try {
            JCheckBox c = (JCheckBox) evt.getSource();
        if (jCheckBox1.isSelected()) {
            txtPass.setEchoChar(c.isSelected() ? '\u0000' : (Character)
        UIManager.get("PasswordField.echoChar"));
        }else{
            txtPass.setEchoChar(!c.isSelected() ? '*' :(Character) 
        UIManager.get("PasswordField.echoChar"));
        }     
        } catch (NullPointerException e) {
        }
           
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        if (jList1.getSelectedIndex()<0) {
            JOptionPane.showMessageDialog(jPanel5, "Select a class to update", "Update Class", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (jList1.getSelectedIndices().length>1) {
            JOptionPane.showMessageDialog(jPanel5, "You can't update multiple classes at once \n only one at a time", "Update Class", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String className = jList1.getSelectedValue();
        
        try{
            Statement st = connect().createStatement();
            
        String nameString = JOptionPane.showInputDialog(jPanel5, "Enter new class name", className);
        if(!(nameString == null)){
        st.executeUpdate("Update class_group set className = '"+nameString+"' where lecturerID ='"+id.getText()+"' and className ='"+className+"'");
        JOptionPane.showMessageDialog(jPanel5, "Updated successfully");
        updateClass(jList1);
        }
        }catch(SQLException e){
            errorMessage(jPanel5, e.getMessage(), "Update Class");
        }catch(NullPointerException ex){}
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jPanel5ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel5ComponentHidden
        name.setBackground(Color.white);
        p4=false;
        clearProfileBoxes();
    }//GEN-LAST:event_jPanel5ComponentHidden

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
                try {
            JCheckBox c = (JCheckBox) evt.getSource();
        if (jCheckBox2.isSelected()) {
            jPasswordField1.setEchoChar(c.isSelected() ? '\u0000' : (Character)
        UIManager.get("PasswordField.echoChar"));
            jPasswordField2.setEchoChar(c.isSelected() ? '\u0000' : (Character)
        UIManager.get("PasswordField.echoChar"));
        }else{
            jPasswordField1.setEchoChar(!c.isSelected() ? '*' :(Character) 
        UIManager.get("PasswordField.echoChar"));
            jPasswordField2.setEchoChar(!c.isSelected() ? '*' :(Character) 
        UIManager.get("PasswordField.echoChar"));
        }     
        } catch (NullPointerException e) {
        }

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        refreshCourseTable();
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if(jComboBox4.getSelectedItem() == "Select Class"){
            infoMessage(jPanel8, "Select a class before adding course(s)", "Add New Course");
            return;
        }
        String c = "";
        String t = "";
        try{
        c = JOptionPane.showInputDialog(jPanel8, "Enter course code", "Add New Course", JOptionPane.INFORMATION_MESSAGE);
        
        if(!(c.isBlank())){
        t = JOptionPane.showInputDialog(jPanel8, "Enter course title", "Add New Course", JOptionPane.INFORMATION_MESSAGE);
        }
        if(t.isBlank()){
            return;
        }
        }catch (NullPointerException e){return;}
        if(!(c.isBlank()) && !(t.isBlank())){
        String[] code = c.split(",");
        String[] title = t.split(",");
        
        if(!(code.length == title.length)){
            infoMessage(jPanel8, "Course code and course title\n does not match respectively", "Add New Course");
            return;
        }
            for (int i = 0; i < code.length; i++) {
                try {
                    PreparedStatement ps = connect().prepareStatement("Insert into courses (courseCode, courseTitle, "
                            + "classHeld, className, lecturerID) VALUES (?, ?, ?, ?, ?)");
                    ps.setString(1, code[i].trim().toUpperCase());
                    ps.setString(2, title[i].trim());
                    ps.setInt(3, 0);
                    ps.setString(4, jComboBox4.getSelectedItem().toString());
                    ps.setString(5, id.getText());
                    ps.executeUpdate();
                    refreshCourseTable();
                } catch (SQLException e) {
                    errorMessage(jPanel8, e.getMessage(), "Add New Course");
                }
                
            }
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        if(jComboBox4.getSelectedItem() == "Select Class"){
            infoMessage(jPanel8, "Select a class", "Update Course");
            return;
        }
        if (jTable2.getSelectedRow()==-1) {
            infoMessage(jPanel8, "Select a course from the table to\nupdate that course", "Update Course");
            return;
        }
        if(jTable2.getSelectedRowCount() == 1){
           String code = jTable2.getModel().getValueAt(jTable2.convertRowIndexToModel(jTable2.getSelectedRow()),1).toString();
           String title = jTable2.getModel().getValueAt(jTable2.convertRowIndexToModel(jTable2.getSelectedRow()),2).toString();
           String titl = "";
           String cod ="";
           try{
           cod = JOptionPane.showInputDialog(jPanel8, "Enter course code", code);
           if(!(cod.isBlank())){
            titl = JOptionPane.showInputDialog(jPanel8, "Enter course title", title);
           }
           if(titl.isBlank()){
               return;
           }
           }catch (NullPointerException e){return;}
           try{
        PreparedStatement ps = connect().prepareStatement("Update courses set courseCode = '"+cod.trim().toUpperCase()+"', "
                + "courseTitle = '"+titl.trim()+"' where lecturerID = '"+id.getText()+"' "
                        + "and className = '"+jComboBox4.getSelectedItem().toString()+"' and courseCode = '"+code+"' and "
                                + "courseTitle = '"+title+"'");
        ps.executeUpdate();
        refreshCourseTable();
           }catch (SQLException e){
               errorMessage(jPanel8, e.getMessage(), "Update Course");
           }
           }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jLabel18.setForeground(Color.BLUE);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
            jLabel18.setForeground(Color.BLACK);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if(jComboBox4.getSelectedItem() == "Select Class"){
            infoMessage(jPanel8, "Select a class", "List of Students");
            return;
        }
        if (jTable2.getSelectedRow()==-1) {
            infoMessage(jPanel8, "Select a course from the table to\nview students registered in that course", "List of Student");
            return;
        }
        if(jTable2.getSelectedRowCount() == 1){
            openDialog(jDialog4);
            
            ResultSet rs;
            try {
                String code = jTable2.getModel().getValueAt(jTable2.convertRowIndexToModel(jTable2.getSelectedRow()),1).toString();
                String titl = jTable2.getModel().getValueAt(jTable2.convertRowIndexToModel(jTable2.getSelectedRow()),2).toString();
                Statement st = connect().createStatement();
                rs = st.executeQuery("SELECT s.matricNumber, s.firstName, s.lastName,"
                        + " s.department, s.sex, a.courseCode from student_info s"
                        + " left join attendance a on s.matricNumber = a.matricNumber"
                        + " where a.lecturerID= '"+id.getText()+"' and"
                        + " a.courseCode='"+code+"' and a.className = '"+jComboBox4.getSelectedItem().toString()+"'");
                DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
                model.setRowCount(0);
                int i =1;
                while(rs.next()){
                    model.addRow(new Object[]{i, rs.getString("firstName")+" "+rs.getString("lastName"), rs.getString("department"), rs.getString("sex")});
                    i++;
                }
                jLabel23.setText("Class: "+jComboBox4.getSelectedItem().toString());
                jLabel21.setText("Course: "+code+" - "+titl);
                jTable3.setModel(model);
            } catch (SQLException e) {
                errorMessage(jDialog4, e.getMessage(), "List of Student");
            }
        }
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        Arrays.fill(studentMarked, null);
    }//GEN-LAST:event_jComboBox6ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        try{
        getCourse(jComboBox7, jPanel7, jComboBox3.getSelectedItem().toString());
        }catch (NullPointerException e){}
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
         if(jCheckBox4.isSelected()){
             jList2.setEnabled(true);
         }else{
             jList2.setEnabled(false);
         }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        try {
            getCourses(jList2);
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        enroller3.clear();
        updateSampleLeft2();
        if(!capturer5.isStarted()){
            try {
                capturer5.startCapture();
            } catch (RuntimeException e) {
            }
            
        }
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseEntered
            jLabel37.setForeground(Color.blue);
    }//GEN-LAST:event_jLabel37MouseEntered

    private void jLabel37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseExited
        jLabel37.setForeground(Color.black);
    }//GEN-LAST:event_jLabel37MouseExited

    private void jDialog5ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDialog5ComponentShown
        stopAllCapturer();
        if (isActiveee) {
            
        }else{
            lecturerEnrollment2();
            isActiveee=true;
        }
        updateSampleLeft2();
        capturer5.startCapture();
        prompt1.setText("Using the fingerprint reader, scan your fingerprint.");
    }//GEN-LAST:event_jDialog5ComponentShown

    private void jDialog5ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDialog5ComponentHidden
        capturer5.stopCapture();
        report1.setText("");
        pic1.setIcon(null);
        enroller2.clear();
    }//GEN-LAST:event_jDialog5ComponentHidden

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        openDialog(jDialog5);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jDialog5.dispose();
        capturer5.stopCapture();
        if(!capturer2.isStarted() && jPanel3.isVisible()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
            }
        else if(!capturer3.isStarted() && jPanel4.isVisible() && scanBtn.getText().equals("End Attendance")){
            try {
                capturer3.startCapture();
            } catch (RuntimeException e) {
            }
            }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (null == enroller3.getTemplate()) {
            infoMessage(jDialog5, "Fingerprint enrollment is not complete", "Change Fingerprint");
            return;
        }
        byte[] print = null;
        try{
        DPFPTemplate temp = enroller3.getTemplate();
        
        print = temp.serialize();
        
        }catch(NullPointerException e){
            
        }
        PreparedStatement ps;
        try {
            ps = connect().prepareStatement("Update login_info set fingerPrint = ? where lecturerID = '"+id.getText()+"'");
            ps.setBytes(1, print);
            ps.executeUpdate();
            report1.append("Fingerprint Changed Successfully\n");
            enroller3.clear();
        if (!capturer5.isStarted()) {
            try {
                capturer5.startCapture();
            } catch (RuntimeException e) {
            }
            
        }
        updateSampleLeft2();
        } catch (SQLException e) {
            errorMessage(jDialog5, e.getMessage(), "Change Fingerprint");
            enroller3.clear();
        if (!capturer5.isStarted()) {
            try {
                capturer5.startCapture();
            } catch (RuntimeException ex) {
            }
            
        }
        updateSampleLeft2();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jPanel7ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel7ComponentShown
        if (jPanel7.isVisible()) {
            jLabel40.setBackground(new Color(100,149,237));
            p3=true;
        }
        jTable2.setVisible(true);
        jTable1.setPreferredScrollableViewportSize(new Dimension(500, 70));
        resizeColumnWidth();
        getClass(jComboBox3, jPanel7);
    }//GEN-LAST:event_jPanel7ComponentShown

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel36MouseClicked

    private void jPanel8ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel8ComponentShown
        if (jPanel8.isVisible()) {
            jLabel1.setBackground(new Color(100,149,237));
            p5=true;
        }
        getClass(jComboBox4, jPanel8);
    }//GEN-LAST:event_jPanel8ComponentShown

    private void jPanel6ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel6ComponentShown
        if (lecturerVerificationIsActive) {
            
        }else{
            lecturerVerification();
            lecturerVerificationIsActive=true;
        }
        start();
    }//GEN-LAST:event_jPanel6ComponentShown

    private void jPanel6ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel6ComponentHidden
        stop();
    }//GEN-LAST:event_jPanel6ComponentHidden

    private void jPanel2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusLost
        System.out.println("lost");
    }//GEN-LAST:event_jPanel2FocusLost

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        if (jPanel4.isVisible() && capturer3.isStarted()) {
            int a = JOptionPane.showConfirmDialog(jPanel4, "Attendance Marking is in progress.\nDo you want to stop"
                    + " it?\nNOTE: Any student who hasn't been marked will be\nabsent for this class.",
                    "Mark Attendance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (a==JOptionPane.YES_OPTION) {
                capturer3.stopCapture();
                jComboBox2.removeAllItems();
                jComboBox2.setEnabled(true);
                jComboBox6.setEnabled(true);
                pic2.setIcon(null);
                Arrays.fill(studentMarked, null);
                updateStatus(0);
                scanBtn.setText("Take Attendance");
                
                showClassControlPanel();
            }else{}
        }else{
        showClassControlPanel();}
    }//GEN-LAST:event_jLabel1MouseClicked

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        if (jPanel4.isVisible() && capturer3.isStarted()) {
            int a = JOptionPane.showConfirmDialog(jPanel4, "Attendance Marking is in progress.\nDo you want to stop"
                    + " it?\nNOTE: Any student who hasn't been marked will be\nabsent for this class.",
                    "Mark Attendance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (a==JOptionPane.YES_OPTION) {
                capturer3.stopCapture();
                jComboBox2.removeAllItems();
                jComboBox2.setEnabled(true);
                jComboBox6.setEnabled(true);
                pic2.setIcon(null);
                Arrays.fill(studentMarked, null);
                updateStatus(0);
                scanBtn.setText("Take Attendance");
                
                allPanelInvisible();
                jPanel2.setVisible(true);
                jPanel5.setVisible(true);
            }else{}
        }else{
            allPanelInvisible();
            jPanel2.setVisible(true);
            jPanel5.setVisible(true);}
        // TODO add your handling code here:
    }//GEN-LAST:event_nameMouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
        if (jPanel4.isVisible() && capturer3.isStarted()) {
            int a = JOptionPane.showConfirmDialog(jPanel4, "Attendance Marking is in progress.\nDo you want to stop"
                    + " it?\nNOTE: Any student who hasn't been marked will be\nabsent for this class.",
                    "Mark Attendance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (a==JOptionPane.YES_OPTION) {
                capturer3.stopCapture();
                jComboBox2.removeAllItems();
                jComboBox2.setEnabled(true);
                jComboBox6.setEnabled(true);
                pic2.setIcon(null);
                Arrays.fill(studentMarked, null);
                updateStatus(0);
                scanBtn.setText("Take Attendance");
                
                showAttendanceReport();
            }else{}
        }else{
        showAttendanceReport();}
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
                // TODO add your handling code here:
        showAttendancePane();
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        capturer6.stopCapture();
        jDialog3.dispose();
        if (jPanel4.isVisible() && capturer3.isStarted()) {
            int a = JOptionPane.showConfirmDialog(jPanel4, "Attendance Marking is in progress.\nDo you want to stop"
                    + " it?\nNOTE: Any student who hasn't been marked will be\nabsent for this class.",
                    "Mark Attendance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (a==JOptionPane.YES_OPTION) {
                capturer3.stopCapture();
                jComboBox2.removeAllItems();
                jComboBox2.setEnabled(true);
                jComboBox6.setEnabled(true);
                pic2.setIcon(null);
                Arrays.fill(studentMarked, null);
                updateStatus(0);
                scanBtn.setText("Take Attendance");
                
                allPanelInvisible();
                jPanel2.setVisible(true);
                showEnrollPane();
            }else{}
        }else{
       allPanelInvisible();
       jPanel2.setVisible(true);
       showEnrollPane();
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        if (jPanel4.isVisible() && capturer3.isStarted()) {
            int a = JOptionPane.showConfirmDialog(jPanel4, "Attendance Marking is in progress.\nDo you want to stop"
                    + " it?\nNOTE: Any student who hasn't been marked will be\nabsent for this class.",
                    "Mark Attendance", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (a==JOptionPane.YES_OPTION) {
                capturer3.stopCapture();
                jComboBox2.removeAllItems();
                jComboBox2.setEnabled(true);
                jComboBox6.setEnabled(true);
                pic2.setIcon(null);
                Arrays.fill(studentMarked, null);
                updateStatus(0);
                scanBtn.setText("Take Attendance");
                getContentPane().setBackground(new Color(6, 52, 74));
                showLoginPane();
                txtPass.setText("");
                wipeClean();
            }else{}
        }else{
            wipeClean();
            getContentPane().setBackground(new Color(6, 52, 74));
            showLoginPane();
            txtPass.setText("");}
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        if (!p1) {
            jLabel6.setBackground(new Color(198,215,235));
        }
        jPanel2.setSize(290,729);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        if (!p1) {
            jLabel6.setBackground(Color.white);
        }
        jPanel2.setSize(56, 729);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jPanel2.setSize(56, 729);
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        jPanel2.setSize(290,729);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        if (!p2) {
          jLabel25.setBackground(new Color(198,215,235));
        }
        jPanel2.setSize(290,729);
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
        if (!p2) {
            jLabel25.setBackground(Color.white);
        }
        jPanel2.setSize(56, 729);
    }//GEN-LAST:event_jLabel25MouseExited

    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        if (!p3) {
        jLabel40.setBackground(Color.white);            
        }
        jPanel2.setSize(56, 729);
    }//GEN-LAST:event_jLabel40MouseExited

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        if (!p3) {
        jLabel40.setBackground(new Color(198,215,235));         
        }
        jPanel2.setSize(290,729);
    }//GEN-LAST:event_jLabel40MouseEntered

    private void nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseEntered
        if (!p4) {
        name.setBackground(new Color(198,215,235));            
        }
        jPanel2.setSize(290,729);
    }//GEN-LAST:event_nameMouseEntered

    private void nameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseExited
        if (!p4) {
        name.setBackground(Color.white);            
        }
        jPanel2.setSize(56, 729);
    }//GEN-LAST:event_nameMouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        if (!p5) {
        jLabel1.setBackground(new Color(198,215,235));            
        }
        jPanel2.setSize(290,729);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        if (!p5) {
        jLabel1.setBackground(Color.white);            
        }
        jPanel2.setSize(56, 729);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        jLabel28.setBackground(new Color(198,215,235));
        jPanel2.setSize(290,729);
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        jLabel28.setBackground(Color.white);
        jPanel2.setSize(56, 729);
    }//GEN-LAST:event_jLabel28MouseExited

    private void bck1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bck1MouseEntered
        bck1.setBackground(new Color(198,215,235));
        jPanel2.setSize(290,729);
    }//GEN-LAST:event_bck1MouseEntered

    private void bck1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bck1MouseExited
        bck1.setBackground(Color.WHITE);
        jPanel2.setSize(56, 729);
    }//GEN-LAST:event_bck1MouseExited

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        enroller4.clear();
        updateSampleLeft4();
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jDialog3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDialog3ComponentShown
        stopAllCapturer();
        getClass(jComboBox8, jDialog3);
        if (isActivie) {
            
        }else{
            studentEnrollmentUpd();
            isActivie=true;
        }
        updateSampleLeft4();
        if(!capturer6.isStarted()){
            try {
                capturer6.startCapture();
            } catch (RuntimeException e) {
            }
        }
    }//GEN-LAST:event_jDialog3ComponentShown

    private void jDialog3ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDialog3ComponentHidden
        capturer6.stopCapture();
        pic3.setIcon(null);
        enroller4.clear();
        if(!capturer2.isStarted() && jPanel3.isVisible()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
        }
    }//GEN-LAST:event_jDialog3ComponentHidden

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        openDialog(jDialog3);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jDialog3.dispose();
        capturer6.stopCapture();
        if(!capturer2.isStarted() && jPanel3.isVisible()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
        }else if(!capturer3.isStarted() && jPanel4.isVisible() && scanBtn.getText().equals("End Attendance")){
            try {
                capturer3.startCapture();
            } catch (RuntimeException e) {
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (matTextBox1.getText().isBlank()) {
            infoMessage(jDialog3, "Enter student matric number", "Change Fingerprint");
            return;
        }else if(jComboBox8.getSelectedItem()== "Select Class"){
            infoMessage(jDialog3, "Select a Class", "Change Fingerprint");
            return;
        }
        if (null == enroller4.getTemplate()) {
            infoMessage(jDialog3, "Sample needed is not complete.\nSample left: "+enroller4.getFeaturesNeeded(), "Change Fingerprint");
            return;
        }
        if (!checkStudent(matTextBox1.getText(), id.getText(), jComboBox8.getSelectedItem().toString())) {
            return;
        }
        
        byte[] print = null;
        try{
        DPFPTemplate temp = enroller4.getTemplate();
        
        print = temp.serialize();
        
        }catch(NullPointerException e){
            
        }
        PreparedStatement ps;
        try {
            ps = connect().prepareStatement("Update student_info set fingerprint = ? where lecturerID = '"+id.getText()+"' "
                    + "and matricNumber='"+matTextBox1.getText().trim()+"' and className='"+jComboBox8.getSelectedItem().toString()+"'");
            ps.setBytes(1, print);
            ps.executeUpdate();
            infoMessage(jDialog3, "Fingerprint Changed Successfully.", "Changee Fingerprint");
            enroller4.clear();
        if (!capturer6.isStarted()) {
            try {
                capturer6.startCapture();
            } catch (RuntimeException e) {
            }
            
        }
        updateSampleLeft4();
        } catch (SQLException e) {
            errorMessage(jDialog3, e.getMessage(), "Change Fingerprint");
            enroller4.clear();
        if (!capturer6.isStarted()) {
            try {
                capturer6.startCapture();
            } catch (RuntimeException ex) {
            }
            
        }
        updateSampleLeft4();
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jDialog3WindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog3WindowLostFocus
        capturer6.stopCapture();
        if(!capturer2.isStarted() && jPanel3.isVisible()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
        }
        else if(!capturer3.isStarted() && jPanel4.isVisible() && scanBtn.getText().equals("End Attendance")){
            try {
                capturer3.startCapture();
            } catch (RuntimeException e) {
            }
        }
    }//GEN-LAST:event_jDialog3WindowLostFocus

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jDialog3WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog3WindowClosed
        capturer6.stopCapture();
        if(!capturer2.isStarted() && jPanel3.isVisible()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
        }
        else if(!capturer3.isStarted() && jPanel4.isVisible() && scanBtn.getText().equals("End Attendance")){
            try {
                capturer3.startCapture();
            } catch (RuntimeException e) {
            }
        }
    }//GEN-LAST:event_jDialog3WindowClosed

    private void jDialog5WindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog5WindowLostFocus
        capturer5.stopCapture();
        if(!capturer2.isStarted() && jPanel3.isVisible()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
        }
        else if(!capturer3.isStarted() && jPanel4.isVisible() && scanBtn.getText().equals("End Attendance")){
            try {
                capturer3.startCapture();
            } catch (RuntimeException e) {
            }
        }
    }//GEN-LAST:event_jDialog5WindowLostFocus

    private void jDialog5WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog5WindowClosed
        capturer5.stopCapture();
        if(!capturer2.isStarted() && jPanel3.isVisible()){
            try {
                capturer2.startCapture();
            } catch (RuntimeException e) {
            }
        }
        else if(!capturer3.isStarted() && jPanel4.isVisible() && scanBtn.getText().equals("End Attendance")){
            try {
                capturer3.startCapture();
            } catch (RuntimeException e) {
            }
        }
    }//GEN-LAST:event_jDialog5WindowClosed

    private void jDialog1WindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowLostFocus
        capturer4.stopCapture();
        if(!capturer.isStarted() && jPanel1.isVisible()){
            try {
                capturer.startCapture();
            } catch (RuntimeException e) {
            }
        }        
    }//GEN-LAST:event_jDialog1WindowLostFocus

    private void jDialog1WindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowClosed
        capturer4.stopCapture();
        if(!capturer.isStarted() && jPanel1.isVisible()){
            try {
                capturer.startCapture();
            } catch (RuntimeException e) {
            }
        }    
    }//GEN-LAST:event_jDialog1WindowClosed

    private void jDialog1WindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog1WindowGainedFocus
        stopAllCapturer();
        if (!capturer4.isStarted()) {
            try {
                capturer4.startCapture();
            } catch (RuntimeException e) {
            }
            
        }
    }//GEN-LAST:event_jDialog1WindowGainedFocus

    private void jDialog5WindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog5WindowGainedFocus
        stopAllCapturer();
        capturer5.startCapture();
    }//GEN-LAST:event_jDialog5WindowGainedFocus

    private void jDialog3WindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog3WindowGainedFocus
        stopAllCapturer();
        capturer6.startCapture();
    }//GEN-LAST:event_jDialog3WindowGainedFocus

    private void jPanel7ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel7ComponentHidden
        jLabel40.setBackground(Color.white);
        p3=false;
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_jPanel7ComponentHidden

    private void jPanel8ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel8ComponentHidden
        jLabel1.setBackground(Color.white);
        p5=false;
    }//GEN-LAST:event_jPanel8ComponentHidden
   
    private void openDialog(JDialog jDialog){
        jDialog.dispose();
        jDialog.getContentPane().setBackground(Color.WHITE);
        jDialog.setLocation(300, 80);
        jDialog.setVisible(true);
        jDialog.pack();
    }
    
    private void stopAllCapturer(){
        capturer.stopCapture();
        capturer2.stopCapture();
        capturer3.stopCapture();
        capturer4.stopCapture();
        capturer5.stopCapture();
        capturer6.stopCapture();
    }
    
    private void showEnrollPane(){
       allPanelInvisible();
       jPanel2.setVisible(true);
       jPanel3.setVisible(true);
    }

    private void allPanelInvisible(){
       jPanel6.setVisible(false);
       jPanel2.setVisible(false);
       jPanel3.setVisible(false);
       jPanel4.setVisible(false);
       jPanel8.setVisible(false);
       jPanel5.setVisible(false);
       jPanel7.setVisible(false);
    }
    
    private void showAttendancePane(){
       allPanelInvisible();
       jPanel4.setVisible(true);
    }
    
    private void showLoginPane(){
        allPanelInvisible();
        jPanel1.setBackground(new java.awt.Color(255, 255, 255, 236));
        txtUser.setBackground(new java.awt.Color(255, 255, 255, 236));
        txtPass.setBackground(new java.awt.Color(255, 255, 255, 236));
        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255, 236));
        jLabel3.setBackground(new java.awt.Color(255, 255, 255, 236));
        jLabel4.setBackground(new java.awt.Color(255, 255, 255, 236));
        jPanel6.setVisible(true);
    }
    
    protected void showOptionPane(){
        allPanelInvisible();
        jPanel2.setVisible(true);
        setLocation(400, 150);
    }
    
    protected void showAttendanceReport(){
        allPanelInvisible();
        jPanel2.setVisible(true);
        jPanel7.setVisible(true);
    }
    
    protected void showClassControlPanel(){
        allPanelInvisible();
        jPanel2.setVisible(true);
        jPanel8.setVisible(true);
    }
    
    private String dateTime(){
        Date dt = new Date();
    
      SimpleDateFormat  dat = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat  tim = new SimpleDateFormat("kk:mm:ss");
      String date = dat.format(dt);
      String time = tim.format(dt);
      String dateTimeString = date+" "+time;
      return dateTimeString;
    }
    
    private void updateSampleLeft()
	{
		// Show number of samples needed.
		sampLeft.setText(String.format("Fingerprint samples needed: %1$s", enroller2.getFeaturesNeeded()));
	}
    
    private void updateSampleLeft2()
	{
		// Show number of samples needed.
		sampLeft1.setText(String.format("Fingerprint samples needed: %1$s", enroller3.getFeaturesNeeded()));
	}
    
    private void updateSampleLeft4()
	{
		// Show number of samples needed.
		sampLeft2.setText(String.format("Fingerprint samples needed: %1$s", enroller4.getFeaturesNeeded()));
	}
    
    private void updateSample(){
        lectFingerSample.setText(String.format("Fingerprint samples needed: %1$s", enroller.getFeaturesNeeded()));
    }
    
    protected void lecturerEnrollment(){
        capturer4.addDataListener(new DPFPDataAdapter() {
			@Override public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					lecturerEnrollmentProcess(e.getSample());
				}});
			}
		});
        capturer4.addImageQualityListener(new DPFPImageQualityAdapter() {
			@Override public void onImageQuality(final DPFPImageQualityEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					if (e.getFeedback().equals(DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD))
						JOptionPane.showMessageDialog(jDialog1,"The quality of the fingerprint sample is good.",
                                                        "Fingerprint Enrollment", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(jDialog1,"The quality of the fingerprint sample is poor.",
                                                        "Fingerprint Enrollment",JOptionPane.INFORMATION_MESSAGE);
				}});
			}
		});
    }
    
    protected void lecturerEnrollmentProcess(DPFPSample sample){
        DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

		// Check quality of the sample and add to enroller if it's good
		if (features != null) try
		{
			enroller.addFeatures(features);		// Add feature set to template.
		}
		catch (DPFPImageQualityException ex) { }
		finally {
			updateSample();

			// Check if template has been created.
			switch(enroller.getTemplateStatus())
			{
				case TEMPLATE_STATUS_READY:	// report success and stop capturing
					capturer4.stopCapture();
					setTemplate(enroller.getTemplate());
					lectFingerSample.setText("Fingerprint sample needed is complete.");
					break;

				case TEMPLATE_STATUS_FAILED:	// report failure and restart capturing
					enroller.clear();
					capturer4.stopCapture();
					updateSample();
					setTemplate(null);
					JOptionPane.showMessageDialog(jDialog1, "The fingerprint template is not valid. Repeat fingerprint enrollment.",
                                                "Fingerprint Enrollment", JOptionPane.ERROR_MESSAGE);
					capturer4.startCapture();
					break;
			default:
				break;
			}
		}
    }
    
    protected void studentEnrollment(){
        capturer2.addDataListener(new DPFPDataAdapter() {
			@Override public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					report.append("The fingerprint sample was captured.\n");
                                        
					studentEnrollmentProcess(e.getSample());
				}});
			}
		});
		capturer2.addReaderStatusListener(new DPFPReaderStatusAdapter() {
			@Override public void readerConnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
		 			report.append("The fingerprint reader was connected.\n");
				}});
			}
			@Override public void readerDisconnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					report.append("The fingerprint reader was disconnected.\n");
				}});
			}
		});
		capturer2.addImageQualityListener(new DPFPImageQualityAdapter() {
			@Override public void onImageQuality(final DPFPImageQualityEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					if (e.getFeedback().equals(DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD))
						report.append("The quality of the fingerprint sample is good.\n");
					else
						report.append("The quality of the fingerprint sample is poor.\n");
				}});
			}
		});
    }
   
    protected void studentEnrollmentProcess(DPFPSample sample)
	{
		// Draw fingerprint sample image.
		drawPicture(convertSampleToBitmap(sample));
                DPFPFeatureSet featureSet = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

		// Check quality of the sample and add to enroller if it's good
		if (featureSet != null) try
		{
                    enroller2.addFeatures(featureSet);		// Add feature set to template.
		}
		catch (DPFPImageQualityException ex) { }
		finally {
			updateSampleLeft();

			// Check if template has been created.
			switch(enroller2.getTemplateStatus())
			{
				case TEMPLATE_STATUS_READY:	// report success and stop capturing
					capturer2.stopCapture();
					setTemplate2(enroller2.getTemplate());
					break;

				case TEMPLATE_STATUS_FAILED:	// report failure and restart capturing
					enroller2.clear();
					capturer2.stopCapture();
					updateSampleLeft();
					setTemplate2(null);
					JOptionPane.showMessageDialog(this, "The fingerprint template is not valid. Repeat fingerprint enrollment.",
                                                "Fingerprint Enrollment", JOptionPane.ERROR_MESSAGE);
					capturer2.startCapture();
					break;
			default:
				break;
			}
		}
	}
    
    protected void studentEnrollmentUpd(){
        capturer6.addDataListener(new DPFPDataAdapter() {
			@Override public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {                                        
					studentEnrollmentUpdProcess(e.getSample());
				}});
			}
		});
		capturer6.addReaderStatusListener(new DPFPReaderStatusAdapter() {
                        @Override public void readerConnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
		 			jLabel42.setText("Fingerprint reader was connected.\n");
				}});
			}
			@Override public void readerDisconnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					jLabel42.setText("Fingerprint reader was disconnected.");
				}});
			}
		});
		capturer6.addImageQualityListener(new DPFPImageQualityAdapter() {
			@Override public void onImageQuality(final DPFPImageQualityEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					if (e.getFeedback().equals(DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD))
						infoMessage(jDialog3, "The quality of the fingerprint sample is good.", "Update Template");
					else
						infoMessage(jDialog3, "The quality of the fingerprint sample is poor.", "Update Template");
				}});
			}
		});
    }
    
    protected void studentEnrollmentUpdProcess(DPFPSample sample)
	{
		// Draw fingerprint sample image.
		drawPicture4(convertSampleToBitmap(sample));
                DPFPFeatureSet featureSet = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

		// Check quality of the sample and add to enroller if it's good
		if (featureSet != null) try
		{
                    enroller4.addFeatures(featureSet);		// Add feature set to template.
		}
		catch (DPFPImageQualityException ex) { }
		finally {
			updateSampleLeft4();

			// Check if template has been created.
			switch(enroller4.getTemplateStatus())
			{
				case TEMPLATE_STATUS_READY:	// report success and stop capturing
					capturer6.stopCapture();
					setTemplate4(enroller4.getTemplate());
					break;

				case TEMPLATE_STATUS_FAILED:	// report failure and restart capturing
					enroller4.clear();
					capturer6.stopCapture();
					updateSampleLeft4();
					setTemplate4(null);
					JOptionPane.showMessageDialog(jDialog3, "The fingerprint template is not valid. Repeat fingerprint enrollment.",
                                                "Fingerprint Enrollment", JOptionPane.ERROR_MESSAGE);
					capturer6.startCapture();
					break;
			default:
				break;
			}
		}
	}
    
    protected void lecturerEnrollment2(){
        capturer5.addDataListener(new DPFPDataAdapter() {
			@Override public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					report1.append("The fingerprint sample was captured.\n");
                                        prompt1.setText("Scan the same fingerprint again.");
					lecturerEnrollmentProcess2(e.getSample());
				}});
			}
		});
		capturer5.addReaderStatusListener(new DPFPReaderStatusAdapter() {
			@Override public void readerConnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
		 			report1.append("The fingerprint reader was connected.\n");
				}});
			}
			@Override public void readerDisconnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					report1.append("The fingerprint reader was disconnected.\n");
				}});
			}
		});
		capturer5.addImageQualityListener(new DPFPImageQualityAdapter() {
			@Override public void onImageQuality(final DPFPImageQualityEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					if (e.getFeedback().equals(DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD))
						report1.append("The quality of the fingerprint sample is good.\n");
					else
						report1.append("The quality of the fingerprint sample is poor.\n");
				}});
			}
		});
    }
    
    protected void lecturerEnrollmentProcess2(DPFPSample sample)
	{
		// Draw fingerprint sample image.
		drawPicture3(convertSampleToBitmap(sample));
                DPFPFeatureSet featureSet = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

		// Check quality of the sample and add to enroller if it's good
		if (featureSet != null) try
		{
                    enroller3.addFeatures(featureSet);		// Add feature set to template.
		}
		catch (DPFPImageQualityException ex) { }
		finally {
			updateSampleLeft2();

			// Check if template has been created.
			switch(enroller3.getTemplateStatus())
			{
				case TEMPLATE_STATUS_READY:	// report success and stop capturing
					capturer5.stopCapture();
					setTemplate3(enroller3.getTemplate());
					prompt1.setText("Fingerprint sample needed is complete.");
					break;

				case TEMPLATE_STATUS_FAILED:	// report failure and restart capturing
					enroller3.clear();
					capturer5.stopCapture();
					updateSampleLeft2();
					setTemplate3(null);
					JOptionPane.showMessageDialog(this, "The fingerprint template is not valid. Repeat fingerprint enrollment.",
                                                "Fingerprint Enrollment", JOptionPane.ERROR_MESSAGE);
					capturer5.startCapture();
					break;
			default:
				break;
			}
		}
	}    
    
    protected void start(){
        try{
        capturer.startCapture();        
        }catch(IllegalStateException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    protected void stop(){
        capturer.stopCapture();
    }
    
    public void setTemplate(DPFPTemplate template) {
		DPFPTemplate old = this.template;
		this.template = template;
		firePropertyChange(TEMPLATE_PROPERTY, old, template);
	}
    
    public void setTemplate3(DPFPTemplate template) {
		DPFPTemplate old = this.template3;
		this.template3 = template;
		firePropertyChange(TEMPLATE_PROPERTIE, old, template);
	}
    
    public void setTemplate2(DPFPTemplate template) {
		DPFPTemplate old = this.template2;
		this.template2 = template;
		firePropertyChange(TEMPLATE_PROPERTYY, old, template);
	}
    
    public void setTemplate4(DPFPTemplate template) {
		DPFPTemplate old = this.template4;
		this.template4 = template;
		firePropertyChange(TEMPLATE_PROPERTIEE, old, template);
	}
    
    protected void getProfileUpdateDetails(){
        this.lectID2 = myID.getText();
        String n1=myFN.getText(),n2=myLN.getText();
        this.lecFirNam2 = n1.substring(0, 1).toUpperCase()+""+n1.substring(1);
        this.lecLasNam2 = n2.substring(0, 1).toUpperCase()+""+n2.substring(1);
        this.secuQues2 = mySQ.getSelectedItem().toString();
        this.secuAnsw2 = mySA.getText();
        char[] pass = myPW.getPassword();
        this.pWord2 = new String(pass);
    }
    
    protected void getSignUpInfo(){
        try{
            
        DPFPTemplate temp = enroller.getTemplate();
        this.lectID = lecIDTxt.getText();
        this.lecFirNam = lecFirNamTxt.getText();
        this.lecLasNam = lecLasNamTxt.getText();
        
        radioFemale.setActionCommand("Female");
        radioMale.setActionCommand("Male");
        this.sex = buttonGroup1.getSelection().getActionCommand();
        this.secuQues = secuQuesTxt.getSelectedItem().toString();
        this.secuAnsw = secuAnswTxt.getText();
        this.lecPrint = temp.serialize();
        char[] pass = pWordTxt.getPassword();
        this.pWord = new String(pass);
        
        }catch(NullPointerException e){
            
        }
    }
    
    /**
     *
     * @param sample
     */
        
    protected void studentVerification(){
        capturer3.addDataListener(new DPFPDataAdapter() {
			@Override public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					veriReport.append("The fingerprint sample was captured.\n");
                                        prompt2.setText("Scan the same fingerprint again.");
					studentVerificationProcess(e.getSample());
				}});
			}
		});
		capturer3.addReaderStatusListener(new DPFPReaderStatusAdapter() {
			@Override public void readerConnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
		 			veriReport.append("The fingerprint reader was connected.\n");
				}});
			}
			@Override public void readerDisconnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					veriReport.append("The fingerprint reader was disconnected.\n");
				}});
			}
		});
		capturer3.addImageQualityListener(new DPFPImageQualityAdapter() {
			@Override public void onImageQuality(final DPFPImageQualityEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					if (e.getFeedback().equals(DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD))
						veriReport.append("The quality of the fingerprint sample is good.\n");
					else
						veriReport.append("The quality of the fingerprint sample is poor.\n");
				}});
			}
		});
    }
    
    /**
     *
     * @param sample
     */
    protected void studentVerificationProcess(DPFPSample sample) {
                drawPicture2(convertSampleToBitmap(sample));
                   boolean isNothing = false;
		// Process the sample and create a feature set for the enrollment purpose.
		DPFPFeatureSet featureSet = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
                
                DPFPVerificationResult result=null;
		// Check quality of the sample and start verification if it's good
		if (featureSet != null)
		{
                    try{
                        ResultSet rs;
                        try (Statement st = connect().createStatement()) {
                            rs = st.executeQuery("SELECT s.matricNumber, s.firstName, s.lastName,"
                                    + " s.fingerprint, a.courseCode from student_info s left join"
                                    + " attendance a on s.matricNumber = a.matricNumber where"
                                    + " a.lecturerID= '"+id.getText()+"' and a.courseCode='"+jComboBox6.getSelectedItem().toString()+"'"
                                    + " and a.className = '"+jComboBox2.getSelectedItem().toString()+"'"
                                    + " and fingerprint is not null");
                            
                            while (rs.next()) {
                                
                                Blob blob = rs.getBlob("fingerprint");
                                int l = (int) blob.length();
                                byte[] tplate = blob.getBytes(1, l);
                                DPFPTemplate temp = DPFPGlobal.getTemplateFactory().createTemplate();
                                temp.deserialize(tplate);
                                
                                // Compare the feature set with our template
                                result =
                                        verificator2.verify(featureSet, temp);
                                verificator2.setFARRequested(DPFPVerification.MEDIUM_SECURITY_FAR);
                                updateStatus(result.getFalseAcceptRate());
                                if (result.isVerified() && !checkArray(studentMarked, rs.getString("matricNumber"))){
                                    
                                    try {
                                        Statement sta = connect().createStatement();
                                        
                                        veriReport.append("Student VERIFIED.\n");
                                        veriReport.append(rs.getString("matricNumber")+" - "+rs.getString("firstName")+"\n");
                                        String mat=rs.getString("matricNumber");
                                        sta.executeUpdate("Update attendance Set classPresent= classPresent + 1, "
                                                + "attendancePercentage = classPresent/classHeld *100, classAbsent= classAbsent-1 "
                                                +"where matricNumber= '"+mat+"' and lecturerID= '"+id.getText()+"' and"
                                                        + " className='"+jComboBox2.getSelectedItem().toString()+"' "
                                                        + "and courseCode = '"+jComboBox6.getSelectedItem().toString()+"'");
                                        insertAttendaceDetails(mat, jComboBox6, date, time, id, jComboBox2.getSelectedItem().toString());
                                        studentMarked[index]= rs.getString("matricNumber");
                                        index++;
                                        isNothing=true;
                                        break;
                                        
                                    }catch (SQLException e) {
                                        JOptionPane.showMessageDialog(jPanel4, e.getMessage(),"Update Attendance Score",JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                }else if(result.isVerified() && checkArray(studentMarked, rs.getString("matricNumber"))){
                                    JOptionPane.showMessageDialog(jPanel4, rs.getString("firstName")+" "+rs.getString("lastName")+
                                            "\nhas been marked present already", "Attendance Registry", JOptionPane.ERROR_MESSAGE);
                                    isNothing=true;
                                    break;
                                }
                            }
                            
                            if (!isNothing) {
                                veriReport.append("Student not registered \n");
                                return;
                                }
                        }
		rs.close();		
                		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(jPanel4, e.getMessage(), "Get Student Fingerprint", JOptionPane.ERROR_MESSAGE);
	}
			
		}
	}
    
    /**
     *
     * @param matricString
     * @param cCode
     * @param date
     * @param time
     * @param idString
     * @param clas
     */
    protected void insertAttendaceDetails(String matricString, JComboBox cCode, SimpleDateFormat date, SimpleDateFormat time, JLabel idString, String clas){
        Date dt = new Date();
        date = new SimpleDateFormat("yyyy-MM-dd");
        time = new SimpleDateFormat("kk:mm:ss");
        String dat = date.format(dt);
        String tim = time.format(dt);
        
        PreparedStatement st;
        try {
            st = connect().prepareStatement("Insert into attendance_details (matricNumber, courseCode, "
                    + "date, time, lecturerID, className, lesson) VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, matricString);
            st.setString(2, cCode.getSelectedItem().toString());
            st.setString(3, dat);
            st.setString(4, tim);
            st.setString(5, idString.getText());
            st.setString(6, clas);
            st.setString(7, getClassHeld());
            st.executeUpdate();
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanel4, e.getMessage(), "Attendance Details", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    protected void lecturerVerification(){
        capturer.addDataListener(new DPFPDataAdapter() {
			@Override public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					lecturerVerificationProcess(e.getSample());
				}});
			}
		});
    }
    
    private void lecturerVerificationProcess(DPFPSample sample){
        
		DPFPFeatureSet featureSet = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
                
		if (featureSet != null)
		{
                    try{
                        ResultSet rs;
                        DPFPVerificationResult result=null;
                            Statement st = connect().createStatement();
                            rs = st.executeQuery("SELECT l.lecturerID, l.firstName, l.lastName, lo.fingerPrint, lo.password from"
                                    + " lecturer_info l left join login_info lo using(lecturerID) where lo.fingerPrint is not null");
                           
                            while (rs.next()){
                            Blob blob = rs.getBlob("fingerPrint");
                            int l = (int) blob.length();
                            byte[] tplate = blob.getBytes(1l, l);
                            DPFPTemplate temp = DPFPGlobal.getTemplateFactory().createTemplate();
                            temp.deserialize(tplate);
                            result = verificator.verify(featureSet, temp);

                                if (result.isVerified()){
                                    
                                    allPanelInvisible();
                                    jDialog1.dispose();
                                    getContentPane().setBackground(Color.WHITE);
                                    showEnrollPane();
                                    id.setText(rs.getString("lecturerID").toUpperCase());
                            
                                    String na,me;
                                    na=rs.getString("firstName");
                                    me=rs.getString("lastName");
                                    name.setText("   "+na.substring(0, 1).toUpperCase()+""+na.substring(1).toLowerCase()+
                                            " "+me.substring(0, 1).toUpperCase()+""+me.substring(1));
                                    break;
                                } 
                            }
                            if (!result.isVerified()){
                                    JOptionPane.showMessageDialog(jPanel1, "Fingerprint match not found", "Sign In",
                                            JOptionPane.INFORMATION_MESSAGE);
                                
                            }
                            
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(jPanel1, e.getMessage(), "An Error Occured", JOptionPane.ERROR_MESSAGE);
          
	}catch(NullPointerException e){
        }	
		}
        
    }
    
    private void updateStatus(int FAR)
	{
		// Show "False accept rate" value
		farStat.setText(String.format("False Accept Rate (FAR) = %1$s", FAR));
	}
    
    public void drawPicture(Image image) {
		pic.setIcon(new ImageIcon(
			image.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_DEFAULT)));
	}
	
    public void drawPicture2(Image image) {
		pic2.setIcon(new ImageIcon(
			image.getScaledInstance(pic2.getWidth(), pic2.getHeight(), Image.SCALE_DEFAULT)));
	}
    
    public void drawPicture3(Image image) {
		pic1.setIcon(new ImageIcon(
			image.getScaledInstance(pic1.getWidth(), pic1.getHeight(), Image.SCALE_DEFAULT)));
	}
    
    public void drawPicture4(Image image) {
		pic3.setIcon(new ImageIcon(
			image.getScaledInstance(pic3.getWidth(), pic3.getHeight(), Image.SCALE_DEFAULT)));
	}
    
    protected Image convertSampleToBitmap(DPFPSample sample) {
		return DPFPGlobal.getSampleConversionFactory().createImage(sample);
	}

    protected DPFPFeatureSet extractFeatures(DPFPSample sample, DPFPDataPurpose purpose)
	{
		DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
		try {
			return extractor.createFeatureSet(sample, purpose);
		} catch (DPFPImageQualityException e) {
			return null;
		}
	}

    private void errorMessage(Component parentComponent, String msg, String title){
            JOptionPane.showMessageDialog(parentComponent, msg, title, JOptionPane.ERROR_MESSAGE);
        }
    
    private void infoMessage(Component parentComponent, String msg, String title){
            JOptionPane.showMessageDialog(parentComponent, msg, title, JOptionPane.INFORMATION_MESSAGE);
        }
        
    private void getEnrollmentInput(){ 
            DPFPTemplate temp;
            try{
            temp =enroller2.getTemplate();
            this.matNo=matTextBox.getText().toUpperCase().trim();
            this.fName=fNameTextBox.getText().substring(0,1).toUpperCase()+""+fNameTextBox.getText().substring(1);
            this.lName=lNameTextBox.getText().substring(0,1).toUpperCase()+""+lNameTextBox.getText().substring(1);
            this.dept=deptTextBox.getText();
            this.genderString = jComboBox1.getSelectedItem().toString();
            this.fPrint=temp.serialize();
            }catch(NullPointerException e){                
            }
            
        }
    
    public Connection connect() throws SQLException {
		 Connection conn;
		try { Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "ayo_db", "Harabb0.");
		} catch(ClassNotFoundException| NullPointerException | SQLException e) {
                    JOptionPane.showMessageDialog(null, "Failed to connect to the server.\nCheck your connection"
                            + " and try again.", "Error in server connection", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
		
		return conn;
	}
	
    public void insertStudentInfo(String matNo, String fName, String lName, String dept, String genderString, byte[] fPrint, String className){
		PreparedStatement st;
		try { 
			st = connect().prepareStatement("Insert into student_info (matricNumber, firstName, lastName, department,"
                                + " sex, fingerprint, lecturerID, className) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, matNo.toUpperCase().trim());
			st.setString(2, fName);
                        st.setString(3, lName);
                        st.setString(4, dept);
                        st.setString(5, genderString);
                        st.setBytes(6, fPrint);
                        st.setString(7, id.getText());
                        st.setString(8, className);
			st.executeUpdate();
                        
                        ResultSet rs;
        try {
            Statement sta = connect().createStatement();
            rs = sta.executeQuery("Select * from courses where lecturerID = '"+id.getText().trim()+"' and className='"+className+"'");
            while (rs.next()) {
              try {
                    PreparedStatement s = connect().prepareStatement("Insert into attendance (matricNumber, courseCode, classPresent, classAbsent, "
                            + "classHeld, attendancePercentage, lecturerID, className) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                    s.setString(1, matNo.toUpperCase().trim());
                    s.setString(2, rs.getString("courseCode"));
                    s.setInt(3, 0);
                    s.setInt(4, 0);
                    s.setInt(5, rs.getInt("classHeld"));
                    s.setInt(6, 0);
                    s.setString(7, id.getText());
                    s.setString(8, className);
                    s.executeUpdate();
                    
                } catch (SQLException e) {
                    errorMessage(jPanel3, e.getMessage(), "Course Registration");
                    return;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanel3, e.getMessage());
            return;
        }                        
                        report.append("Student enrolled successfully\n");
		} catch (SQLException e) { 
                    JOptionPane.showMessageDialog(jPanel3, e.getMessage());
                }catch(IllegalStateException | NullPointerException ex){} 
	}
        
    /**
     *
     * @param matNo
     * @param lecID
     * @param fName
     * @param lName
     * @param sex
     * @param sQuestion
     * @param sAnswer
     * @param courseCode
     * @param courseTitle
     * @param pWord
     * @param fingerprint
     */
    protected void insertStudent(String matNo, String fName, String lName, String dept, 
            String genderString, byte[] fPrint, String className){
        PreparedStatement st;
		try { 
			st = connect().prepareStatement("Insert into student_info (matricNumber, firstName, lastName, department,"
                                + " sex, fingerprint, lecturerID, className) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, matNo.toUpperCase().trim());
			st.setString(2, fName);
                        st.setString(3, lName);
                        st.setString(4, dept);
                        st.setString(5, genderString);
                        st.setBytes(6, fPrint);
                        st.setString(7, id.getText());
                        st.setString(8, className);
			st.executeUpdate();
                } catch (SQLException e) { 
                    JOptionPane.showMessageDialog(jPanel3, e.getMessage());
                }catch(IllegalStateException | NullPointerException ex){}
    }
    
    public void insertStudentCourse(String matNo, String className, String cod){
         
                        ResultSet rs;
                        
                try {
            Statement sta = connect().createStatement();
            rs = sta.executeQuery("Select * from courses where lecturerID = '"+id.getText().trim()+"' and className='"+className+"'"
                    + " and courseCode = '"+cod+"'");
            while (rs.next()) {
              try {
                    PreparedStatement s = connect().prepareStatement("Insert into attendance (matricNumber, courseCode, classPresent, classAbsent, "
                            + "classHeld, attendancePercentage, lecturerID, className) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                    s.setString(1, matNo.toUpperCase().trim());
                    s.setString(2, rs.getString("courseCode"));
                    s.setInt(3, 0);
                    s.setInt(4, 0);
                    s.setInt(5, rs.getInt("classHeld"));
                    s.setInt(6, 0);
                    s.setString(7, id.getText());
                    s.setString(8, className);
                    s.executeUpdate();
                    
                } catch (SQLException e) {
                    errorMessage(jPanel3, e.getMessage(), "Course Registration");
                    return;
                }catch(IllegalStateException | NullPointerException ex){return;}
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jPanel3, e.getMessage());
            return;
        }catch(IllegalStateException | NullPointerException ex){return;}
    
    }
    
    protected void lecturerInfoInsertStatement(String lecID, String fName, String lName, String sex, String sQuestion,
            String sAnswer, String pWord, byte[] fingerprint){
        
            PreparedStatement st;
            char[] pass = pWordTxt.getPassword();
            pWord = new String(pass);
            
		try { 
			st = connect().prepareStatement("Insert into lecturer_info (lecturerID, firstName, lastName, sex,"
                                + " securityQuestion, securityAnswer) "+ "VALUES (?, ?, ?, ?, ?, ?)");
			st.setString(1, lecID.toUpperCase());
                        st.setString(2, fName.substring(0,1).toUpperCase()+fName.substring(1));
                        st.setString(3, lName.substring(0,1).toUpperCase()+lName.substring(1));
                        st.setString(4, sex);
                        st.setString(5, sQuestion);
                        st.setString(6, sAnswer);
                        st.executeUpdate();
                        
                        st = connect().prepareStatement("Insert into login_info (lecturerID, password, fingerPrint) "+ "VALUES (?, ?, ?)");
                        st.setString(1, lecID.toUpperCase());
                        st.setString(2, pWord);
                        st.setBytes(3, fingerprint);
                        st.executeUpdate();
                        
                        
                      JOptionPane.showMessageDialog(jDialog1, "Account created successfully");
		} catch (SQLException e) { 
                    JOptionPane.showMessageDialog(jDialog1, e.getMessage());
                }catch(IllegalStateException | NullPointerException ex){
                } 
        }
    
    protected void lecturerLoginInfoInsertStatement(String lecturerID, String pWord, byte[] fingerPrint){
        char[] pass = pWordTxt.getPassword();
        pWord = new String(pass);
        
        PreparedStatement st;
		try { 
			st = connect().prepareStatement("Insert into login_info (lecturerID, password, fingerPrint) "+ "VALUES (?, ?, ?)");
			st.setString(1, lecturerID);
                        st.setString(2, pWord);
                        st.setBytes(3, fingerPrint);
			st.executeUpdate();
                 } catch (SQLException e) { 
                    JOptionPane.showMessageDialog(jDialog1, e.getMessage());
                }catch(IllegalStateException | NullPointerException ex){
                }  
    }
    
    protected void coursesInsertStatement(String cCode, String cTitle, int cHeld, String lecID){
        PreparedStatement st;
		try { 
			st = connect().prepareStatement("Insert into courses (courseCode, courseTitle, classHeld, lecturerID) "+
                                "VALUES (?, ?, ?, ?)");
			st.setString(1, cCode);
                        st.setString(2, cTitle);
                        st.setInt(3, 0);
                        st.setString(4, lecID);
			st.executeUpdate();
                        JOptionPane.showMessageDialog(jDialog1, "Course saved successfully");
		} catch (SQLException e) { 
                    JOptionPane.showMessageDialog(jDialog1, e.getMessage());
                }catch(IllegalStateException | NullPointerException ex){
                }  
    }
         
    public int countRows() throws SQLException{
           connect();
           ResultSet rs;
           Statement stmt = connect().createStatement();
              String query = "select count(*) from users";
              rs = stmt.executeQuery(query);
              rs.next();
              int count = rs.getInt(1);
			return count;
        }
        
    @SuppressWarnings("unchecked")
    public void clearTextbox(){
            matTextBox.setText("");
            fNameTextBox.setText("");
            lNameTextBox.setText("");
            deptTextBox.setText("");
            jComboBox1.setSelectedItem("Female");
            
            lecIDTxt.setText("");
            lecFirNamTxt.setText("");
            lecLasNamTxt.setText("");
           
            secuQuesTxt.setSelectedIndex(0);
            secuAnswTxt.setText("");
            pWordTxt.setText("");
            conPwordTxt.setText("");  
            
        }
    
            @SuppressWarnings("unchecked")
    private void clearProfileBoxes(){
        myID.setText("");
            myFN.setText("");
            myLN.setText("");
            myPW.setText("");
            myCP.setText("");
            mySQ.setSelectedIndex(1);
            mySA.setText("");
            DefaultListModel listModel = new DefaultListModel();
            listModel.removeAllElements();
            jList1.setModel(listModel);
    }
        
    private void wipeClean(){
        matCustom.setText("");
        veriReport.setText("");
        pic2.setIcon(null);
        deptTextBox.setText("");
        lNameTextBox.setText("");
        fNameTextBox.setText("");
        matTextBox.setText("");
        pic.setIcon(null);
        report.setText("");
        pic1.setIcon(null);
        report1.setText("");
        matTextBox1.setText("");
        tableReset();
        totalClass.setText("Total no. of class held: NA");
        jLabel36.setText("Percentage: ");
        jLabel36.setVisible(false);
        jRadioButton1.setSelected(true);
        
    }
    
    private static boolean checkArray(String[] arr, String matToCheck) {
	 
	boolean check = Arrays.asList(arr).contains(matToCheck);
	
	return check;
}
        
    private void printPanel(){
        Toolkit tkp = jPanel2.getToolkit();
        PrintJob pjp = tkp.getPrintJob(this, null, null);
        Graphics g = pjp.getGraphics();
        jPanel2.printAll(g);
        g.dispose();
        pjp.end();
        }
     
    private ArrayList<AttendanceReport> studentList(){
           ArrayList<AttendanceReport> studentsList = new ArrayList<>(); 
           ResultSet rs;
           int sn=1;
            try {
                Statement st = connect().createStatement();
                AttendanceReport attendanceReport;
                rs = st.executeQuery("SELECT s.firstName, s.lastName, s.matricNumber," +
                            " co.courseCode, co.courseTitle, co.classHeld, a.classPresent, a.classAbsent, a.attendancePercentage" +
                                    " from student_info s left join attendance a on a.matricNumber=s.matricNumber" +
                                        " left join courses co on co.courseCode=a.courseCode" +
                                                " where co.className='"+jComboBox3.getSelectedItem().toString()+"'"
                                                        + " and co.courseCode = '"+jComboBox7.getSelectedItem().toString()+"'"
                                                        + " and co.lecturerID='"+id.getText()+"'");
                while(rs.next()){
                        attendanceReport = new AttendanceReport(rs.getInt("classHeld"), sn, rs.getInt("classPresent"),
                                rs.getInt("classAbsent"), rs.getInt("attendancePercentage"), rs.getString("matricNumber")+"              ",
                                rs.getString("courseCode")+" - "+rs.getString("courseTitle"));
                        studentsList.add(attendanceReport);
                        totalClass.setText("Total no. of class held: "+rs.getInt("classHeld"));
                        sn++;
                    }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jPanel7, e.getMessage(), "Attendance Report", JOptionPane.ERROR_MESSAGE);
            }
        return studentsList;
        }
        
    public void showStudentsReport(){
            ArrayList<AttendanceReport> list = studentList();
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            Object[] row = new Object[7];
            model.setRowCount(0);
            for (int i = 0; i < list.size(); i++) {
               row[0] = list.get(i).getId();
               row[1] = list.get(i).getMatricNumber();
               row[2] = list.get(i).getClassPresent();
               row[3] = list.get(i).getClassAbsent();
               row[4] = list.get(i).getClassHeld();
               row[5] = list.get(i).getAttendancePercentage();
               row[6] = list.get(i).getCourseCode();
               model.addRow(row);
                jScrollPane4.setVisible(true);
            }
            
        }
        
    public void cellRenderCenter(JTable jTable1){
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(JLabel.CENTER);
            jTable1.setDefaultRenderer(String.class, cellRenderer);
        }
        
    public void resizeColumnWidth(){
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(68);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(170);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(350);            
        }
    
    public void resizeColumnWidth2(){
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(268);            
        } 
    
    private void table2Width(){
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(112);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(150);
    }
    
    private void table3Width(){
        jTable3.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable3.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable3.getColumnModel().getColumn(2).setPreferredWidth(180);
        jTable3.getColumnModel().getColumn(3).setPreferredWidth(80);
    }
        
    private String getPercentage(String matric){
        ResultSet rs;
        String result="";
        try {
            Statement st = connect().createStatement();
            rs = st.executeQuery("select attendancePercentage from attendance where matricNumber = '"+matric+"' "
                    + "and lecturerID = '"+id.getText()+"' and className = '"+jComboBox3.getSelectedItem().toString()+"' "
                            + "and courseCode = '"+jComboBox7.getSelectedItem().toString()+"'");
            while(rs.next()){
            result = rs.getString("attendancePercentage");
            }
        } catch (SQLException e) {
            errorMessage(null, e.getMessage(), "Get Percentage");
        }
        return result;
    }
    
    private String getClassHeld(){
        ResultSet rs;
        String result="";
        try {
            Statement st = connect().createStatement();
            rs = st.executeQuery("select classHeld from courses where "
                    + "lecturerID = '"+id.getText()+"' and className = '"+jComboBox2.getSelectedItem().toString()+"' "
                            + "and courseCode = '"+jComboBox6.getSelectedItem().toString()+"'");
            while(rs.next()){
            result = rs.getString("classHeld");
            }
        } catch (SQLException e) {
            errorMessage(null, e.getMessage(), "Get Class Day");
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    protected void updateClass(JList list){
            ResultSet rs;
            DefaultListModel listModel = new DefaultListModel();
               list.setModel(listModel);
            try {
                Statement st = connect().createStatement();
                rs = st.executeQuery("select * from class_group where lecturerID='"+id.getText()+"'");
                while(rs.next()){
                    listModel.addElement(rs.getString("className"));

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jPanel5, e.getMessage());
            }
        }
    
    @SuppressWarnings("unchecked")
    protected void getCourses(JList list){
            ResultSet rs;
            DefaultListModel listModel = new DefaultListModel();
               list.setModel(listModel);
            try {
                Statement st = connect().createStatement();
                rs = st.executeQuery("select * from courses where lecturerID='"+id.getText()+"'"
                        + " and className='"+jComboBox5.getSelectedItem().toString()+"'");
                while(rs.next()){
                    listModel.addElement(rs.getString("courseCode")+" - "+rs.getString("courseTitle"));

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jPanel3, e.getMessage());
            }
        }
        
            @SuppressWarnings("unchecked")
    private void getClass(JComboBox box, Component parent){
        ResultSet rs;
        try {
            Statement st = connect().createStatement();
            rs = st.executeQuery("Select className from class_group where lecturerID = '"+id.getText()+"'");
            box.removeAllItems();
            box.addItem("Select Class");
            while(rs.next()){
                box.addItem(rs.getString("className"));
            }
        } catch (SQLException e) {
            errorMessage(parent, e.getMessage(), "Get Classes");
        }
    }
    
            @SuppressWarnings("unchecked")
    private void getCourse(JComboBox box, Component parent, String clas){
        ResultSet rs;
        try {
            Statement st = connect().createStatement();
            rs = st.executeQuery("Select courseCode from courses where lecturerID = '"+id.getText()+"' and className = '"+clas+"'");
            box.removeAllItems();
            box.addItem("Select Course");
            while(rs.next()){
                box.addItem(rs.getString("courseCode"));
            }
        } catch (SQLException e) {
            errorMessage(parent, e.getMessage(), "Get Course");
        }
    }
    
    private void refreshCourseTable(){
        ResultSet rs;
        try {
            Statement st = connect().createStatement();
            rs = st.executeQuery("select courseCode, courseTitle, classHeld, DATE_FORMAT(lastHeld, '%a %d %b %y,  %h:%i %p') "
                    + "as lastSeen from courses where lecturerID ="
                    + " '"+id.getText()+"' and className = '"+jComboBox4.getSelectedItem().toString()+"'");
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            int i =1;
            while(rs.next()){
                model.addRow(new Object[]{i, rs.getString("courseCode"), rs.getString("courseTitle"),
                rs.getString("classHeld"), rs.getString("lastSeen")});
                i++;
            }
            jTable2.setModel(model);
        } catch (SQLException e) {
            errorMessage(jPanel8, e.getMessage(), "Get Courses");
        }catch (NullPointerException e){}
    }
    
    private void tableReset(){
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                 },
                new String [] {
                                "S/N", "Matric Number", "Class Present", "Class Absent", "Class Held", "Percentage (%)", "Course"
                }
            ){
    boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
    };

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
            });
    }
    
    private boolean checkStudent(String matric, String lecturerID, String className){
        ResultSet rs;
        boolean isFound=false;
        try {
            Statement st = connect().createStatement();
            rs= st.executeQuery("Select matricNumber, lecturerID, className from student_info where "
                    + "matricNumber='"+matric+"' and lecturerID='"+lecturerID+"' and className='"+className+"'");
            if (rs.next()) {
                isFound = true;
            }else{
                infoMessage(jDialog3, "Student with matric number: "+matric+"\nwas not registered to class: "
                        + ""+className+" or Incorrect.\nCheck matric number and try again", "Change Fingerprint");
                isFound = false;
            }
        } catch (SQLException e) {
            errorMessage(jDialog3, e.getMessage(), "Change Fingerprint");
        }
        return isFound;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttendanceBiometric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                //</editor-fold>
                //</editor-fold>
                
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttendanceBiometric().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bck1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPasswordField conPwordTxt;
    private javax.swing.JTextField deptTextBox;
    private javax.swing.JTextField fNameTextBox;
    private javax.swing.JLabel farStat;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JDialog jDialog4;
    private javax.swing.JDialog jDialog5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField lNameTextBox;
    private javax.swing.JTextField lecFirNamTxt;
    private javax.swing.JTextField lecIDTxt;
    private javax.swing.JTextField lecLasNamTxt;
    private javax.swing.JLabel lectFingerSample;
    private javax.swing.JTextField matCustom;
    private javax.swing.JTextField matTextBox;
    private javax.swing.JTextField matTextBox1;
    private javax.swing.JPasswordField myCP;
    private javax.swing.JTextField myFN;
    private javax.swing.JLabel myID;
    private javax.swing.JTextField myLN;
    private javax.swing.JPasswordField myPW;
    private javax.swing.JTextField mySA;
    private javax.swing.JComboBox<String> mySQ;
    private javax.swing.JLabel name;
    private javax.swing.JPasswordField pWordTxt;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel pic1;
    private javax.swing.JLabel pic2;
    private javax.swing.JLabel pic3;
    private javax.swing.JLabel prompt1;
    private javax.swing.JLabel prompt2;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTextArea report;
    private javax.swing.JTextArea report1;
    private javax.swing.JLabel sampLeft;
    private javax.swing.JLabel sampLeft1;
    private javax.swing.JLabel sampLeft2;
    private javax.swing.JButton scanBtn;
    private javax.swing.JTextField secuAnswTxt;
    private javax.swing.JComboBox<String> secuQuesTxt;
    private javax.swing.JPanel signupPanel;
    private javax.swing.JLabel totalClass;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextArea veriReport;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (myFN.isEditable() || myLN.isEditable() || myPW.isEditable() || mySA.isEditable()) {
             isEdited=true;
             jButton9.setEnabled(true);
        }else{
            jButton9.setEnabled(false);
        }

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        isEdited=true;
        jButton9.setEnabled(true);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        isEdited=true;
        jButton9.setEnabled(true);
    }
}
