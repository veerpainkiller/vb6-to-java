/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VbGroup.java
 *
 * Created on Aug 18, 2010, 11:15:12 AM
 */

package buggymastercode;

import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.application.Action;

/**
 *
 * @author jalvarez
 */
public class VbGroup extends javax.swing.JDialog {

    /** Creates new form VbGroup */
    public VbGroup(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProjects = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 250));
        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getActionMap(VbGroup.class, this);
        jButton1.setAction(actionMap.get("translate")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(buggymastercode.BuggyMasterCodeApp.class).getContext().getResourceMap(VbGroup.class);
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(583, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tblProjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nivel", "File", "Dll Name", "Path", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProjects.setName("tblProjects"); // NOI18N
        jScrollPane1.setViewportView(tblProjects);
        tblProjects.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblProjects.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tblProjects.columnModel.title0")); // NOI18N
        tblProjects.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblProjects.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tblProjects.columnModel.title1")); // NOI18N
        tblProjects.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblProjects.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tblProjects.columnModel.title4")); // NOI18N
        tblProjects.getColumnModel().getColumn(3).setPreferredWidth(500);
        tblProjects.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tblProjects.columnModel.title2")); // NOI18N
        tblProjects.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblProjects.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("tblProjects.columnModel.title3")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void translate() {
        DefaultTableModel model = (DefaultTableModel)this.tblProjects.getModel();

        // print the results
        for (int i = 0; i < model.getRowCount(); i++) {
            if ((Boolean)model.getValueAt(i, 4)) {
                m_projects.get(i).setSelected(true);
            }
            else {
                m_projects.get(i).setSelected(false);
            }
        }
        setVisible(false);
        dispose();
        m_caller.translateProjects(m_projects);
    }

    public void loadGrid(ArrayList<Project> projects) {
        try {
            DefaultTableModel model = (DefaultTableModel)this.tblProjects.getModel();
            model.getDataVector().removeAllElements();

            // print the results
            for (int i = 0; i < projects.size(); i++) {
                model.addRow(new Object[]{Integer.toString(projects.get(i).getLevel()),
                                          projects.get(i).getName(),
                                          projects.get(i).getDllName(),
                                          projects.get(i).getPath(),
                                          true});
            }

            m_projects = projects;
        }
        catch(Exception ex) {
            BuggyMasterCodeApp.getLogger().log(Level.WARNING, "loading projects failed", ex);
        }
    }

    public void setCaller(BuggyMasterCodeView value) {
        m_caller = value;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProjects;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Project> m_projects = null;
    private BuggyMasterCodeView m_caller = null;

}