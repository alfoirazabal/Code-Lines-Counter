/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_lines_counter.gui;

import code_lines_counter.domain.Extension;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 *
 * @author Alfonso
 */
public class FormMain extends javax.swing.JFrame {

    private final ArrayList<File> filesInFolder;
    private final ArrayList<File> codeFilesInFolder;
    private ArrayList<Extension> currentExtensions;
    
    /**
     * Creates new form FormMain
     */
    public FormMain() {
        initComponents();
        
        this.filesInFolder = new ArrayList<>();
        this.currentExtensions = new ArrayList<>();
        this.codeFilesInFolder = new ArrayList<>();
        
        this.lblCodeFolder.setText(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelectCodeFolder = new javax.swing.JButton();
        lblCodeFolder = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCodeExtensions = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCodeFilesNumber = new javax.swing.JList<>();
        btnCalculateStats = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSelectCodeFolder.setText("Select Code Folder");
        btnSelectCodeFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectCodeFolderActionPerformed(evt);
            }
        });

        lblCodeFolder.setText("lblCodeFolder");

        jLabel1.setText("Choose Extensions:");

        jScrollPane1.setViewportView(lstCodeExtensions);

        btnAdd.setText("Add");

        btnModify.setText("Modify");

        btnDelete.setText("Delete");

        jScrollPane2.setViewportView(lstCodeFilesNumber);

        btnCalculateStats.setText("Calculate Stats...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSelectCodeFolder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCodeFolder))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnModify)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDelete)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCalculateStats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectCodeFolder)
                    .addComponent(lblCodeFolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnModify)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCalculateStats)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectCodeFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectCodeFolderActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select main folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false); //No "All Files" Option
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String choosenDirectory = chooser.getCurrentDirectory().toString();
            pickFolderAndAssignFiles(choosenDirectory);
        }
    }//GEN-LAST:event_btnSelectCodeFolderActionPerformed

    private void pickFolderAndAssignFiles(String folderSource) {
        this.filesInFolder.clear();
        this.codeFilesInFolder.clear();
        getFilesRecursively(new File(folderSource));
        this.currentExtensions = 
                Extension.getFoundExtensionsInFiles(this.filesInFolder);
        DefaultListModel fifListModel = new DefaultListModel();
        fifListModel.addAll(this.currentExtensions);
        this.lstCodeExtensions.setModel(fifListModel);
        this.lblCodeFolder.setText(folderSource);
        addNOfFilesForEachExtension();
    }
    
    private void getFilesRecursively(File directory) {
        File[] filesAndDirs = directory.listFiles();
        
        if(filesAndDirs != null) {
            for(File fileOrDir : filesAndDirs) {
                if (fileOrDir.isDirectory()) {
                    getFilesRecursively(fileOrDir);
                } else {
                    System.out.println("ADD: " + fileOrDir);
                    this.filesInFolder.add(fileOrDir);
                }
            }
        }
    }
    
    private void addNOfFilesForEachExtension() {
        ArrayList<Short> nOfFiles = new ArrayList<>();
        for(short i = 0 ; i < this.currentExtensions.size() ; i++) {
            String currentExtensionLC = 
                    this.currentExtensions.get(i).getExtension().toLowerCase();
            nOfFiles.add((short)0);
            for(File file : this.filesInFolder) {
                String fileName = file.getName();
                String fileExtension = fileName.substring(
                        fileName.lastIndexOf(".") + 1
                );
                if(currentExtensionLC.equals(fileExtension.toLowerCase())) {
                    nOfFiles.set(i, (short)(nOfFiles.get(i) + 1));
                    this.codeFilesInFolder.add(file);
                }
            }
        }
        DefaultListModel lcfnListModel = new DefaultListModel();
        lcfnListModel.addAll(nOfFiles);
        this.lstCodeFilesNumber.setModel(lcfnListModel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCalculateStats;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSelectCodeFolder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodeFolder;
    private javax.swing.JList<String> lstCodeExtensions;
    private javax.swing.JList<String> lstCodeFilesNumber;
    // End of variables declaration//GEN-END:variables
}
