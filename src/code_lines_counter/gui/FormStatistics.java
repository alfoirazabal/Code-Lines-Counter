/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_lines_counter.gui;

import code_lines_counter.domain.Extension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alfonso
 */
public class FormStatistics extends javax.swing.JFrame {

    /**
     * Creates new form FormStatistics
     */
    
    private final ArrayList<FilesOfExtensions> filesOfExtensions;
    
    public FormStatistics(
            ArrayList<File> codeFilesInFolder,
            ArrayList<Extension> currentExtensions
    ) {
        initComponents();
        
        this.filesOfExtensions = 
                getFilesOfExtensions(codeFilesInFolder, currentExtensions);
        
        int[] totalLinesData = new int[2];  //Total lines and lines of code
        for(FilesOfExtensions fOfExt : this.filesOfExtensions) {
            totalLinesData[0] += fOfExt.sumOfLines;
            totalLinesData[1] += fOfExt.sumOfLinesOfCode;
        }
        
        this.lblTotalLines.setText(String.valueOf(totalLinesData[0]));
        this.lblLinesOfCode.setText(String.valueOf(totalLinesData[1]));
        
        Collections.sort(filesOfExtensions);
        
        DefaultTableModel tableModel = 
                (DefaultTableModel)this.tableStats.getModel();
        filesOfExtensions.forEach((fOfExt) -> {
            Object[] newRow = {
                fOfExt.extension.getExtension().toLowerCase(),
                fOfExt.getNumberOfFiles(),
                fOfExt.sumOfLines,
                fOfExt.sumOfLinesOfCode + " - " + 
                        fOfExt.getCodeToLinesPercentage() + "%", 
                fOfExt.avgLengthOfCodeLine};
            tableModel.addRow(newRow);
            System.out.println(fOfExt);
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

        jLabel1 = new javax.swing.JLabel();
        lblLinesOfCode = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalLines = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStats = new javax.swing.JTable();
        btnExamineForFileType = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Total Lines of Code: ");

        lblLinesOfCode.setText("jLabel2");

        jLabel2.setText("Total Lines:");

        lblTotalLines.setText("jLabel3");

        jLabel3.setText("Lines of code segregated by file type:");

        tableStats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Type", "Number of Files", "Total Lines", "Total Lines of Code", "Average Length of Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableStats);

        btnExamineForFileType.setText("Examine from selected File Type");

        jMenu1.setText("File");

        jMenu2.setText("Export");

        jMenuItem1.setText("Aggregated");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Disaggregated");
        jMenu2.add(jMenuItem2);

        jMenu1.add(jMenu2);

        jMenuItem3.setText("Exit");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblLinesOfCode))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTotalLines)))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExamineForFileType)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblTotalLines))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblLinesOfCode))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExamineForFileType)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private ArrayList<FilesOfExtensions> getFilesOfExtensions(
            ArrayList<File> codeFilesInFolder,
            ArrayList<Extension> currentExtensions
    ) {
        ArrayList<FilesOfExtensions> fOfExt = new ArrayList<>();
        currentExtensions.forEach((ext) -> {
            ArrayList<File> foundFiles = new ArrayList<>();
            codeFilesInFolder.forEach((file) -> {
                String fileName = file.getName();
                short fileNameLastDotPos = (short)fileName.lastIndexOf(".");
                String fileExtensionLC = 
                        fileName.substring(fileNameLastDotPos + 1);
                if (fileExtensionLC.toLowerCase().equals(ext.getExtension())) {
                    foundFiles.add(file);
                }
            });
            fOfExt.add(new FilesOfExtensions(ext, foundFiles));
        });
        return fOfExt;
    }
    
    static class FilesOfExtensions implements Comparable<FilesOfExtensions> {
        
        protected final Extension extension;
        protected final ArrayList<File> files;
        protected int sumOfLines;
        protected int sumOfLinesOfCode;
        protected int avgLengthOfCodeLine;
        
        public FilesOfExtensions(
                Extension extension,
                ArrayList<File> files
        ) {
            this.extension = extension;
            this.files = files;
            int sumAvgLengthOfCodeLines = 0;
            for(File file : files) {
                int[] linesData = countLinesOfFile(file);
                this.sumOfLines += linesData[0];
                this.sumOfLinesOfCode += linesData[1];
                sumAvgLengthOfCodeLines += linesData[2];
            }
            this.avgLengthOfCodeLine = sumAvgLengthOfCodeLines / files.size();
        }
        
        
        /**
         * 
         * @param file: The File to check number of lines of code
         * @return int[] with position 0 indicating the total lines of the file,
         * index 1 indicating the total lines of code, and index 2 indicating
         * the average length of a code line
         */
        private int[] countLinesOfFile(File file) {
            int[] linesOfCode = new int[3];
            int totalCodeLength = 0;
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    linesOfCode[0]++;
                    line = reader.readLine();
                    try 
                    {
                        if (!line.replace("\t", "").replace(" ", "").equals("")) {
                            linesOfCode[1]++;
                            totalCodeLength += line.length();
                        }
                    } 
                    catch (NullPointerException ex) {}
                }
                reader.close();
                linesOfCode[2] = totalCodeLength / linesOfCode[1];
            } 
            catch (IOException e) 
            {
                System.out.println("File Deleted: " + file.getName());
            }
            return linesOfCode;
        }
        
        protected int getNumberOfFiles() {
            return files.size();
        }
        
        protected int getCodeToLinesPercentage() {
            return (int)(((float)this.sumOfLinesOfCode / (float)this.sumOfLines) * 100);
        }
        
        @Override
        public String toString() {
            return this.extension + " - " + this.getNumberOfFiles() + " - " + 
                    this.sumOfLines + " - " + this.sumOfLinesOfCode + " - " +
                    this.avgLengthOfCodeLine;
        }

        @Override
        public int compareTo(FilesOfExtensions t) {
            return t.sumOfLinesOfCode - this.sumOfLinesOfCode;
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExamineForFileType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLinesOfCode;
    private javax.swing.JLabel lblTotalLines;
    private javax.swing.JTable tableStats;
    // End of variables declaration//GEN-END:variables
}
