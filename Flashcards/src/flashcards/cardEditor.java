/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import static flashcards.FileIO.*;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class cardEditor extends javax.swing.JFrame {
    Object[][] data;
    /**
     * Creates new form NewJFrame
     */
    public cardEditor() {
        initComponents();       
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        fileList = new javax.swing.JList<>();
        addSetButton = new javax.swing.JButton();
        remSetButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        Object[][] data = new Object[1][2];
        String[] headers = {"Word", "Definition"};
        cardTable = new javax.swing.JTable(data, headers);
        addButton = new javax.swing.JButton();
        remButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(824, 370));

        DefaultListModel model = new DefaultListModel();
        try {
            ArrayList<String> list = fetchSets();
            for(String n : list) {
                model.addElement(n);
            }
        }
        catch (NullPointerException e){
            model.addElement("Empty");
        }
        fileList.setModel(model);
        fileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        fileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                fileListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(fileList);

        addSetButton.setText("Add Card Set");
        addSetButton.setMaximumSize(new java.awt.Dimension(95, 32));
        addSetButton.setMinimumSize(new java.awt.Dimension(95, 32));
        addSetButton.setPreferredSize(new java.awt.Dimension(95, 32));
        addSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSetButtonActionPerformed(evt);
            }
        });

        remSetButton.setText("Remove Card Set");
        remSetButton.setMaximumSize(new java.awt.Dimension(95, 32));
        remSetButton.setMinimumSize(new java.awt.Dimension(95, 32));
        remSetButton.setPreferredSize(new java.awt.Dimension(95, 32));
        remSetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remSetButtonActionPerformed(evt);
            }
        });

        cardTable.setAutoCreateRowSorter(true);
        cardTable.setColumnSelectionAllowed(true);
        cardTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(cardTable);
        cardTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        addButton.setText("Add >>");
        addButton.setMaximumSize(new java.awt.Dimension(95, 32));
        addButton.setMinimumSize(new java.awt.Dimension(95, 32));
        addButton.setPreferredSize(new java.awt.Dimension(95, 32));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        remButton.setText("Remove >>");
        remButton.setMaximumSize(new java.awt.Dimension(95, 32));
        remButton.setMinimumSize(new java.awt.Dimension(95, 32));
        remButton.setPreferredSize(new java.awt.Dimension(95, 32));
        remButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remButtonActionPerformed(evt);
            }
        });

        applyButton.setText("Apply");
        applyButton.setMaximumSize(new java.awt.Dimension(69, 32));
        applyButton.setMinimumSize(new java.awt.Dimension(69, 32));
        applyButton.setPreferredSize(new java.awt.Dimension(69, 32));
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.setMaximumSize(new java.awt.Dimension(69, 32));
        okButton.setMinimumSize(new java.awt.Dimension(69, 32));
        okButton.setPreferredSize(new java.awt.Dimension(69, 32));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addSetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remSetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addSetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remSetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(remButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Object[][] temp = new Object[data.length+1][2];
        for (int i = 0; i < data.length; i++){
            temp[i][0] = data[i][0];
            temp[i][1] = data[i][1];
        }
        temp[data.length][0] = "[insert word]";
        temp[data.length][1] = "[insert definition]";
        
        data = temp;
        cardTable.setModel(new TableModel(data));
    }//GEN-LAST:event_addButtonActionPerformed

    private void remButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remButtonActionPerformed
        if (data.length >= 2) {
            Object[][] temp = new Object[data.length - 1][2];
            int found = 0;
            for (int i = 0, ii = 0; i < data.length; i++) {
              System.out.println("Selected row: " + cardTable.getSelectedRow());
                if (i == cardTable.getSelectedRow()){
                    found = 1;
                    continue;                
                }else{
                    temp[i - found][0] = data[i][0];
                    temp[i - found][1] = data[i][1];

                }
                /*temp[i][0] = data[ii][0];
                temp[i][1] = data[ii][1];
                temp[i][2] = data[ii][2];*/
            }

            data = temp;
            cardTable.setModel(new TableModel(data));
            for(int i = 0; i < data.length; i++){
                System.out.print(data[i][1]);
            }
        }
    }//GEN-LAST:event_remButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void fileListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_fileListValueChanged
        ArrayList<CardEntry> cards = loadSet(fileList.getSelectedValue().toString());
        data = new Object[cards.size()][2];
        for (int c = 0; c < cards.size(); c++){
            data[c][0] = cards.get(c).getWord();
            data[c][1] = cards.get(c).getDef();
        };
        cardTable.setModel(new TableModel(data));

        System.out.println("Selected index: " + fileList.getSelectedIndex());
    }//GEN-LAST:event_fileListValueChanged

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (data != null) {
            saveChanges();
            System.exit(0);
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void addSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSetButtonActionPerformed
        loadSet(JOptionPane.showInputDialog(null, "Enter a name for new set: "));
        updateList();
    }//GEN-LAST:event_addSetButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        saveChanges();
    }//GEN-LAST:event_applyButtonActionPerformed

    private void remSetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remSetButtonActionPerformed
        String remove = fileList.getSelectedValue();
        fileList.setSelectedIndex(0);
        removeSet(remove);
        updateList();
        fileList.setSelectedIndex(0);
        
    }//GEN-LAST:event_remSetButtonActionPerformed

    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cardEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cardEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cardEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cardEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cardEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addSetButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable cardTable;
    public javax.swing.JList<String> fileList;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton okButton;
    private javax.swing.JButton remButton;
    private javax.swing.JButton remSetButton;
    // End of variables declaration//GEN-END:variables

    public void updateList(){
        DefaultListModel model = new DefaultListModel();
        try {
            ArrayList<String> list = fetchSets();
            for (String n : list) {
                model.addElement(n);
            }
        } catch (NullPointerException e) {
            model.addElement("Empty");
        }
        fileList.setModel(model);
    }
    
    public void saveChanges(){
        ArrayList<CardEntry> newSet = new ArrayList<CardEntry>();
            for (int a = 0; a < cardTable.getModel().getRowCount(); a++) {
                String addWord = cardTable.getValueAt(a, 0).toString();
                String addDef = cardTable.getValueAt(a, 1).toString();
                newSet.add(new CardEntry(addWord, addDef));
            }
            updateSet(fileList.getSelectedValue(), newSet);
    }
}