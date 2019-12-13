package com.mvdv.paradigmas;

import com.mycompany.client.GetInfo;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author ponytojas
 */
public class Interface extends javax.swing.JFrame {

    private ArrayList<String> suitcaseConveyorPosition;
    private ArrayList<JTextArea> arrayTextAreas;
    private ArrayList<JButton> employeesButtons;
    private ArrayList<Boolean> areEmployeesRunning;

    private ArrayList<Passenger> passengers;
    private ArrayList<Employee> employees;

    private String airplaneText = "";
    private int counter = 0;

    private boolean globalRunning;

    private Creator creator = new Creator();
    private Airplane airplane = new Airplane();
    private SuitcaseConveyor conveyor = new SuitcaseConveyor();
    private Stopper stopper = new Stopper();

    public Interface() throws IOException, InterruptedException {
        

        Log log = new Log();

        this.employeesButtons = new ArrayList<>();
        this.passengers = new ArrayList <>();
        this.employees = new ArrayList<>();
        
        this.areEmployeesRunning = new ArrayList<>();
        this.areEmployeesRunning.add(true);
        this.areEmployeesRunning.add(true);
        this.globalRunning = true;

        this.suitcaseConveyorPosition = new ArrayList<>();
        for(int indexArray = 0; indexArray < 8; indexArray++)
            this.suitcaseConveyorPosition.add("");
        this.arrayTextAreas = new ArrayList<>();
        
        GetInfo objGetInfo = new GetInfo(this.airplane, this.conveyor);
        Registry registry = LocateRegistry.createRegistry(1099);
        
        Naming.rebind("//127.0.0.1/objGetInfo", objGetInfo);
        System.out.println("Objeto ha sido encontrado");
        
        initComponents();
        
        this.addToFirstEmptyPosition("Probando1");
        this.addToFirstEmptyPosition("Probando2");
        this.addToFirstEmptyPosition("Probando3");
        this.addToFirstEmptyPosition("Probando4");
        this.addToFirstEmptyPosition("Probando5");
        this.addToFirstEmptyPosition("Probando6");
        this.addToFirstEmptyPosition("Probando7");
        this.addToFirstEmptyPosition("Probando8");

        this.areEmployeesRunning.set(0, true);
        this.areEmployeesRunning.set(1, true);
        
        this.employees = creator.createEmployees(2, this.conveyor, this.airplane, log, this.stopper);
        this.passengers = creator.createPassenger(40, this.conveyor, log, this.stopper);

        employees.forEach((employee) -> {
            employee.start();
        });

        passengers.forEach((passenger) -> {
            passenger.start();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        conveyorPosition2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        conveyorPosition3 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        conveyorPosition4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        conveyorPosition1 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        conveyorPosition5 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        conveyorPosition6 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        conveyorPosition7 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        airplaneContent = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        secondEmployee = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        firstEmployee = new javax.swing.JTextArea();
        GoAndComeback2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        conveyorPosition8 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        GoAndComeback1 = new javax.swing.JLabel();

        jTextArea4.setColumns(20);
        jTextArea4.setRows(1);
        jScrollPane4.setViewportView(jTextArea4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Airport");
        setBackground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Open Sans", 0, 10)); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        conveyorPosition1.setEditable(false);
        conveyorPosition1.setColumns(20);
        conveyorPosition1.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        conveyorPosition1.setForeground(new java.awt.Color(72, 72, 85));
        conveyorPosition1.setRows(1);
        conveyorPosition1.setBorder(null);
        conveyorPosition1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conveyorPosition1.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        conveyorPosition1.setSelectionColor(new java.awt.Color(0, 0, 0));
        this.arrayTextAreas.add(conveyorPosition1);
        jScrollPane5.setViewportView(conveyorPosition1);
        jScrollPane5.setVisible(true);

        conveyorPosition2.setEditable(false);
        conveyorPosition2.setColumns(20);
        conveyorPosition2.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        conveyorPosition2.setForeground(new java.awt.Color(72, 72, 85));
        conveyorPosition2.setRows(1);
        conveyorPosition2.setBorder(null);
        conveyorPosition2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conveyorPosition2.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        conveyorPosition2.setSelectionColor(new java.awt.Color(0, 0, 0));
        this.arrayTextAreas.add(conveyorPosition2);
        jScrollPane1.setViewportView(conveyorPosition2);

        conveyorPosition3.setEditable(false);
        conveyorPosition3.setColumns(20);
        conveyorPosition3.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        conveyorPosition3.setForeground(new java.awt.Color(72, 72, 85));
        conveyorPosition3.setRows(1);
        conveyorPosition3.setBorder(null);
        conveyorPosition3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conveyorPosition3.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        conveyorPosition3.setSelectionColor(new java.awt.Color(0, 0, 0));
        this.arrayTextAreas.add(conveyorPosition3);
        jScrollPane2.setViewportView(conveyorPosition3);

        conveyorPosition4.setEditable(false);
        conveyorPosition4.setColumns(20);
        conveyorPosition4.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        conveyorPosition4.setForeground(new java.awt.Color(72, 72, 85));
        conveyorPosition4.setRows(1);
        conveyorPosition4.setBorder(null);
        conveyorPosition4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conveyorPosition4.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        conveyorPosition4.setSelectionColor(new java.awt.Color(0, 0, 0));
        this.arrayTextAreas.add(conveyorPosition4);
        jScrollPane3.setViewportView(conveyorPosition4);

        conveyorPosition5.setEditable(false);
        conveyorPosition5.setColumns(20);
        conveyorPosition5.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        conveyorPosition5.setForeground(new java.awt.Color(72, 72, 85));
        conveyorPosition5.setRows(1);
        conveyorPosition5.setBorder(null);
        conveyorPosition5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conveyorPosition5.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        conveyorPosition5.setSelectionColor(new java.awt.Color(0, 0, 0));
        this.arrayTextAreas.add(conveyorPosition5);
        jScrollPane6.setViewportView(conveyorPosition5);

        conveyorPosition6.setEditable(false);
        conveyorPosition6.setColumns(20);
        conveyorPosition6.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        conveyorPosition6.setForeground(new java.awt.Color(72, 72, 85));
        conveyorPosition6.setRows(1);
        conveyorPosition6.setBorder(null);
        conveyorPosition6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conveyorPosition6.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        conveyorPosition6.setSelectionColor(new java.awt.Color(0, 0, 0));
        this.arrayTextAreas.add(conveyorPosition6);
        jScrollPane7.setViewportView(conveyorPosition6);

        conveyorPosition7.setEditable(false);
        conveyorPosition7.setColumns(20);
        conveyorPosition7.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        conveyorPosition7.setForeground(new java.awt.Color(72, 72, 85));
        conveyorPosition7.setRows(1);
        conveyorPosition7.setBorder(null);
        conveyorPosition7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conveyorPosition7.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        conveyorPosition7.setSelectionColor(new java.awt.Color(0, 0, 0));
        this.arrayTextAreas.add(conveyorPosition7);
        jScrollPane8.setViewportView(conveyorPosition7);

        airplaneContent.setEditable(false);
        airplaneContent.setColumns(20);
        airplaneContent.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        airplaneContent.setForeground(new java.awt.Color(72, 72, 85));
        airplaneContent.setRows(30);
        airplaneContent.setBorder(null);
        airplaneContent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        airplaneContent.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        airplaneContent.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane9.setViewportView(airplaneContent);

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(72, 72, 85));
        jLabel1.setText("Airplane content");

        secondEmployee.setEditable(false);
        secondEmployee.setColumns(20);
        secondEmployee.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        secondEmployee.setForeground(new java.awt.Color(72, 72, 85));
        secondEmployee.setRows(1);
        secondEmployee.setBorder(null);
        secondEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        secondEmployee.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        secondEmployee.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane11.setViewportView(secondEmployee);

        firstEmployee.setEditable(false);
        firstEmployee.setColumns(20);
        firstEmployee.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        firstEmployee.setForeground(new java.awt.Color(72, 72, 85));
        firstEmployee.setRows(1);
        firstEmployee.setBorder(null);
        firstEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        firstEmployee.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        firstEmployee.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane12.setViewportView(firstEmployee);

        GoAndComeback2.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        GoAndComeback2.setForeground(new java.awt.Color(72, 72, 85));
        GoAndComeback2.setText("<==========>");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(72, 72, 85));
        jLabel3.setText("2nd Employee ");

        jButton1.setBackground(new java.awt.Color(72, 72, 85));
        jButton1.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(250, 250, 250));
        jButton1.setText("Pausar empleado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        this.employeesButtons.add(jButton1);

        jButton2.setBackground(new java.awt.Color(72, 72, 85));
        jButton2.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(250, 250, 250));
        jButton2.setText("Pausar empleado");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        this.employeesButtons.add(jButton2);

        jButton3.setBackground(new java.awt.Color(72, 72, 85));
        jButton3.setFont(new java.awt.Font("Open Sans", 0, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(250, 250, 250));
        jButton3.setText("Pausar todo");
        jButton3.setBounds(new java.awt.Rectangle(15, 15, 15, 0));

        conveyorPosition8.setEditable(false);
        conveyorPosition8.setColumns(20);
        conveyorPosition8.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        conveyorPosition8.setForeground(new java.awt.Color(72, 72, 85));
        conveyorPosition8.setRows(1);
        conveyorPosition8.setBorder(null);
        conveyorPosition8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conveyorPosition8.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        conveyorPosition8.setSelectionColor(new java.awt.Color(0, 0, 0));
        this.arrayTextAreas.add(conveyorPosition8);
        jScrollPane10.setViewportView(conveyorPosition8);

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(72, 72, 85));
        jLabel4.setText("Suitcase conveyor content");

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(72, 72, 85));
        jLabel5.setText("1st Employee ");

        GoAndComeback1.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        GoAndComeback1.setForeground(new java.awt.Color(72, 72, 85));
        GoAndComeback1.setText("<==========>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane7)
                            .addComponent(jScrollPane8)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                                    .addComponent(jScrollPane11)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(199, 199, 199)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GoAndComeback1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(GoAndComeback2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(1733, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(105, 105, 105)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(1849, 1849, 1849)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GoAndComeback1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(12, 12, 12)
                        .addComponent(GoAndComeback2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jLabel4)
                    .addContainerGap(759, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1064, 993);
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {        
        this.stopper.setEmployeeLock(0);
        this.areEmployeesRunning.set(0, !this.areEmployeesRunning.get(0));
        this.changeEmployeeText(0);
    }     
    
    private synchronized void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.stopper.setEmployeeLock(1);
        this.areEmployeesRunning.set(1, !this.areEmployeesRunning.get(1));
        this.changeEmployeeText(1);
    }   


    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public static void main(String[] args) throws InterruptedException, InvocationTargetException, RemoteException, MalformedURLException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Interface().setVisible(true);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        

        
                
   
        
    }
    
    private int getFirtsEmptyPosition(){
        int returnValue = -1;
        for(int indexValue = 0; indexValue < 8; indexValue++){
            if(this.suitcaseConveyorPosition.get(indexValue).equals("")){
                returnValue = indexValue;
                break;
            }
        }
        return returnValue;
    }
    
    public void addToFirstEmptyPosition(String textToAdd){
        this.suitcaseConveyorPosition.set(this.getFirtsEmptyPosition(), textToAdd);
        this.updateConveyorText();
    }
    
    public void removeFirstPosition(){
        this.suitcaseConveyorPosition.remove(0);
        this.suitcaseConveyorPosition.add("");
        this.updateConveyorText();
    }
    
    public void updateConveyorText(){
        for(int indexOfArrays = 0; indexOfArrays < 8; indexOfArrays++){
            this.arrayTextAreas.get(indexOfArrays).setText
                            (this.suitcaseConveyorPosition.get(indexOfArrays));
        }
    }
    
    public void updateEmployeeGoBack(int employee, boolean go){
        switch(employee){
            case 1:
                this.GoAndComeback1.setText((go)?"==========>": "<==========");
                break;
                
            case 2:
                this.GoAndComeback2.setText((go)?"==========>": "<==========");
                break;
        }
    }
    
    public void updateEmployeeText(int employee, boolean go, String id){
        
        String stringToSet = ((go)?"El empleado lleva la maleta: " + id 
                : "El empleado está volviendo");
        
        switch(employee){
            case 1:
                this.firstEmployee.setText(stringToSet);
                break;
            case 2:
                this.secondEmployee.setText(stringToSet);
                break;
        }
    }
    
    public void addContentToAirplane(String id){

        if (this.counter % 4 == 0 && this.counter != 0){
            this.airplaneText += "\n";
            this.counter = 0;
        }
        
        if (this.counter == 0)
            this.airplaneText += id;
        else
            this.airplaneText += "\t" + id;
        
        this.counter += 1;
        
        this.airplaneContent.setText(this.airplaneText);
    }

    public void addEmployeesAndPassengers(ArrayList <Passenger> passengers, ArrayList <Employee> employees ) throws InterruptedException{
        this.passengers = passengers;
        this. employees = employees;
        System.out.println("Tamaño de pasageros: " + this.passengers.size());
        System.out.println("Tamaño de empleados: " + this.employees.size()); 
    }

    public void changeEmployeeText(int employee){
        String textForButton = (this.areEmployeesRunning.get(employee)) ? "Pausar":"Reanudar";
        textForButton += " empleado";
        this.employeesButtons.get(employee).setText(textForButton);

    }

    public void changeGlobalText(){
        String textForButton = (this.globalRunning) ? "Pausar":"Reanudar";
        textForButton += " todo";
        jButton3.setText(textForButton);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel GoAndComeback1;
    private javax.swing.JLabel GoAndComeback2;
    private javax.swing.JTextArea airplaneContent;
    private javax.swing.JTextArea conveyorPosition1;
    private javax.swing.JTextArea conveyorPosition2;
    private javax.swing.JTextArea conveyorPosition3;
    private javax.swing.JTextArea conveyorPosition4;
    private javax.swing.JTextArea conveyorPosition5;
    private javax.swing.JTextArea conveyorPosition6;
    private javax.swing.JTextArea conveyorPosition7;
    private javax.swing.JTextArea conveyorPosition8;
    private javax.swing.JTextArea firstEmployee;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea secondEmployee;
    // End of variables declaration                   
}
