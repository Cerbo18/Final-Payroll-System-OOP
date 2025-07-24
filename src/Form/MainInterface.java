
package Form;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MainInterface extends javax.swing.JFrame {
    
    
    
    public MainInterface() {
        initComponents();
        
        HoursWorkedTextField.setEditable(false);
        RatePerHourTextField.setEditable(false);
        
        //To toggle the overtime fields (Able to input to fields)
        OvertimeToggleButton.addActionListener(evt -> {
            boolean selected = OvertimeToggleButton.isSelected();
            HoursWorkedTextField.setEditable(selected);
            RatePerHourTextField.setEditable(selected);
            if(OvertimeToggleButton.isSelected()){
                HoursWorkedTextField.setBackground(Color.white);
                RatePerHourTextField.setBackground(Color.white);
            } else {
                HoursWorkedTextField.setBackground(Color.lightGray);
                RatePerHourTextField.setBackground(Color.lightGray);
            }
        });
        //To edit the Workers by clicking the Table
        FrontTable.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = FrontTable.getSelectedRow();
                NameTextField.setText(Employee.employee.get(row).getName());
                IDTextField.setText(Employee.employee.get(row).getID());
                PositionTextField.setText(Employee.employee.get(row).getPosition());
                ContactTextField.setText(Employee.employee.get(row).getContact());
                DaysWorkedTextField.setText(String.valueOf(Employee.employee.get(row).getDaysWorked()));
                RatePerDayTextField.setText(String.valueOf(Employee.employee.get(row).getRatePerDay()));
                HoursWorkedTextField.setText(String.valueOf(Employee.employee.get(row).getHoursWorked()));
                RatePerHourTextField.setText(String.valueOf(Employee.employee.get(row).getRatePerHour()));
                
            }
        });
        
       
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        IDTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PositionTextField = new javax.swing.JTextField();
        ContactTextField = new javax.swing.JTextField();
        RatePerDayTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DaysWorkedTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        HoursWorkedTextField = new javax.swing.JTextField();
        RatePerHourTextField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        ViewWorkerPayrollButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        OvertimeToggleButton = new javax.swing.JToggleButton();
        UpdateButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ClearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FrontTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PAYROLL MANAGER v1.02 ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        NameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Name:");

        IDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Rate/Day");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Days Worked");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Position: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Contact: ");

        HoursWorkedTextField.setBackground(new java.awt.Color(204, 204, 204));
        HoursWorkedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoursWorkedTextFieldActionPerformed(evt);
            }
        });

        RatePerHourTextField.setBackground(new java.awt.Color(204, 204, 204));

        AddButton.setBackground(new java.awt.Color(204, 204, 204));
        AddButton.setForeground(new java.awt.Color(51, 51, 51));
        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/add.png"))); // NOI18N
        AddButton.setText(" Add ");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        RemoveButton.setBackground(new java.awt.Color(255, 102, 102));
        RemoveButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RemoveButton.setForeground(new java.awt.Color(51, 51, 51));
        RemoveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/delete.png"))); // NOI18N
        RemoveButton.setText("Remove");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        ViewWorkerPayrollButton.setBackground(new java.awt.Color(204, 204, 204));
        ViewWorkerPayrollButton.setForeground(new java.awt.Color(51, 51, 51));
        ViewWorkerPayrollButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/ancient-scroll.png"))); // NOI18N
        ViewWorkerPayrollButton.setText("View Payroll Table");
        ViewWorkerPayrollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewWorkerPayrollButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Payroll Manager");

        OvertimeToggleButton.setBackground(new java.awt.Color(204, 204, 204));
        OvertimeToggleButton.setForeground(new java.awt.Color(51, 51, 51));
        OvertimeToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/clock.png"))); // NOI18N
        OvertimeToggleButton.setText("Overtime");
        OvertimeToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OvertimeToggleButtonActionPerformed(evt);
            }
        });

        UpdateButton.setBackground(new java.awt.Color(204, 204, 204));
        UpdateButton.setForeground(new java.awt.Color(51, 51, 51));
        UpdateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Form/up-arrow.png"))); // NOI18N
        UpdateButton.setText(" Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        BackButton.setBackground(new java.awt.Color(204, 204, 204));
        BackButton.setForeground(new java.awt.Color(51, 51, 51));
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Hours Worked");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Hour/Rate");

        ClearButton.setBackground(new java.awt.Color(204, 204, 204));
        ClearButton.setForeground(new java.awt.Color(51, 51, 51));
        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ViewWorkerPayrollButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BackButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(RatePerDayTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                            .addComponent(DaysWorkedTextField)))
                                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(HoursWorkedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(RatePerHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ClearButton)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ContactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(OvertimeToggleButton)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ClearButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ContactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DaysWorkedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RatePerDayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(OvertimeToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoursWorkedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RatePerHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewWorkerPayrollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        FrontTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Position", "Contact"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(FrontTable);
        if (FrontTable.getColumnModel().getColumnCount() > 0) {
            FrontTable.getColumnModel().getColumn(0).setResizable(false);
            FrontTable.getColumnModel().getColumn(1).setResizable(false);
            FrontTable.getColumnModel().getColumn(2).setResizable(false);
            FrontTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//Press the Add Button
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        try {
            String Name = NameTextField.getText();
            String ID = IDTextField.getText();
            
            for (int i = 0; i < Employee.employee.size(); i++) {
                if(ID.equals(Employee.employee.get(i).getID())){
                    JOptionPane.showMessageDialog(this, "ID already exists");
                    return;
                }
            }
            
            String Position = PositionTextField.getText();
            String Contact = ContactTextField.getText();
            double DaysWorked = Double.parseDouble(DaysWorkedTextField.getText());
            double RatePerDay = Double.parseDouble(RatePerDayTextField.getText());
            double HoursWorked = 0;
            double RatePerHour = 0;
            if(OvertimeToggleButton.isSelected()){
                HoursWorked = Double.parseDouble(HoursWorkedTextField.getText());
                RatePerHour = Double.parseDouble(RatePerHourTextField.getText());
            }
            Employee.employee.add(new Employee(Name, ID, Position, Contact, DaysWorked, RatePerDay, HoursWorked, RatePerHour));
            DefaultTableModel model = (DefaultTableModel)FrontTable.getModel();
            model.addRow(new Object[]{Name, ID, Position, Contact});  
            clearSelections();
            HoursWorkedTextField.setEditable(false);
            RatePerHourTextField.setEditable(false);
            HoursWorkedTextField.setBackground(Color.lightGray);
            RatePerHourTextField.setBackground(Color.lightGray);
            try (Connection conn = DatabaseConnection.getConnection()){
                String sql = "INSERT INTO employees (Name, ID, Position, Contact, Days_Worked, Rate_Per_Day, Hours_Worked, Rate_Per_Hour) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, ID);
                stmt.setString(2, Name);
                stmt.setString(3, Position);
                stmt.setString(4, Contact);
                stmt.setDouble(5, DaysWorked);
                stmt.setDouble(6, RatePerDay);
                stmt.setDouble(7, HoursWorked);
                stmt.setDouble(8, RatePerHour);
                stmt.executeUpdate();
            } 
            catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to save to database.");
            }
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please Fill all Fields with proper values");
        }
        
    }//GEN-LAST:event_AddButtonActionPerformed

    //How to delete??
    private void OvertimeToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OvertimeToggleButtonActionPerformed
        
    }//GEN-LAST:event_OvertimeToggleButtonActionPerformed

    //To press the view worker payroll button
    private void ViewWorkerPayrollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewWorkerPayrollButtonActionPerformed
        ViewPayroll NewFrame = new ViewPayroll();
        NewFrame.setVisible(true);
        
    }//GEN-LAST:event_ViewWorkerPayrollButtonActionPerformed

    //to Load the data from the local file ("Workers.dat")
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         try {
            DefaultTableModel model = (DefaultTableModel)FrontTable.getModel();
            for (int i = 0; i < Employee.employee.size(); i++) {
            model.addRow(new Object[]{Employee.employee.get(i).getName(),Employee.employee.get(i).getID(),
                Employee.employee.get(i).getPosition(), Employee.employee.get(i).getContact()});
            }
        } 
        catch (Exception e) {
            System.out.println("Error loading from Workers.dat");
        }
    }//GEN-LAST:event_formWindowOpened

    //To Save the data from the local file ("Workers.dat")
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      
    }//GEN-LAST:event_formWindowClosing

    //To remove a Worker
    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to Delete this Worker?");
        if(confirm == JOptionPane.YES_OPTION){
            try {
                int row  = FrontTable.getSelectedRow();
                if(row<0){
                    JOptionPane.showMessageDialog(this, "Please select a row to remove");
                    return;
                }
            Employee.employee.remove(row);
            DefaultTableModel model = (DefaultTableModel)FrontTable.getModel();
            model.removeRow(row);
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Please select a row to remove");
            }
        }    
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to edit this row?");
        if(confirm == JOptionPane.YES_OPTION){
            try {
                int row = FrontTable.getSelectedRow();
                if(row<0){
                    JOptionPane.showMessageDialog(this, "Please select a row to update");
                    return;
                }
                String Name = NameTextField.getText();
                String ID = IDTextField.getText();
                String Position = PositionTextField.getText();
                String Contact = ContactTextField.getText();
                double DaysWorked = Double.parseDouble(DaysWorkedTextField.getText());
                double RatePerDay = Double.parseDouble(RatePerDayTextField.getText());
                double HoursWorked = 0;
                double RatePerHour = 0;
                if(OvertimeToggleButton.isSelected()){
                    HoursWorked = Double.parseDouble(HoursWorkedTextField.getText());
                    RatePerHour = Double.parseDouble(RatePerHourTextField.getText());
                }
                Employee updated = new Employee(Name, ID, Position, Contact, DaysWorked, RatePerDay, HoursWorked, RatePerHour);
                Employee.employee.set(row, updated);

                DefaultTableModel model = (DefaultTableModel) FrontTable.getModel();
                model.setValueAt(Name, row, 0);
                model.setValueAt(ID, row, 1);
                model.setValueAt(Position, row, 2);
                model.setValueAt(Contact, row, 3);

                clearSelections();

            } 
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please Fill all Fields with proper values");
            }
        }    
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void NameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextFieldActionPerformed

    private void IDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDTextFieldActionPerformed

    private void HoursWorkedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoursWorkedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoursWorkedTextFieldActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        clearSelections();
    }//GEN-LAST:event_ClearButtonActionPerformed

    
    //To clear all textfields
    public void clearSelections(){
            NameTextField.setText("");
            IDTextField.setText("");
            PositionTextField.setText("");
            ContactTextField.setText("");
            DaysWorkedTextField.setText("");
            RatePerDayTextField.setText("");
            HoursWorkedTextField.setText("");
            RatePerHourTextField.setText("");
            OvertimeToggleButton.setSelected(false);
    }
    
    
    
    //DO NOT MODIFY
//    public static void main(String args[]) {
//
//        
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//         
//            public void run() {
//                new MainInterface().setVisible(true);
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JTextField ContactTextField;
    private javax.swing.JTextField DaysWorkedTextField;
    private javax.swing.JTable FrontTable;
    private javax.swing.JTextField HoursWorkedTextField;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JToggleButton OvertimeToggleButton;
    private javax.swing.JTextField PositionTextField;
    private javax.swing.JTextField RatePerDayTextField;
    private javax.swing.JTextField RatePerHourTextField;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton ViewWorkerPayrollButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
