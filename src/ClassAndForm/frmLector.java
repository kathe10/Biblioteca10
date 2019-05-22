/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassAndForm;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmLector extends javax.swing.JFrame {

    private DefaultTableModel modeloLector;
    public frmLector() {
        modeloLector = new DefaultTableModel(null, getColumn());
        initComponents();
        
        
       
       
        cargarTabla();
    }
         private String[] getColumn() {
        String columnas[] = new String[]{"Id", "Nombre","Celular", "Observación"};
        return columnas;
    }

    private void cargarTabla() {
        Lector objLector = new Lector();
        ResultSet resultado = objLector.cargarTablaLector();
        try {
            Object dato[] = new Object[2];
            while (resultado.next()) {
                for (int i = 0; i < 2; i++) {
                    dato[i] = resultado.getObject(i + 1);
                }
                modeloLector.addRow(dato);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + ex.getMessage());
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtObservacion = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLector = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Goudy Old Style", 1, 36)); // NOI18N
        jLabel1.setText("LECTOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, -1));

        jLabel2.setText("DNI");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel4.setText("Celular");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel5.setText("Observacion");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 130, -1));
        getContentPane().add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 130, -1));
        getContentPane().add(txtObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 129, 94));
        getContentPane().add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 130, -1));

        tblLector.setModel(modeloLector);
        tblLector.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLectorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLector);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 345, 290));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 130, 50));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/message.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));

        btnSalir.setBackground(new java.awt.Color(255, 204, 204));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cross-remove-sign.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 40, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblLectorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLectorMouseClicked
         int seleccion=tblLector.rowAtPoint(evt.getPoint());
        txtDNI.setText(String.valueOf(tblLector.getValueAt(seleccion,0)));
        txtNombre.setText(String.valueOf(tblLector.getValueAt(seleccion,1)));
        txtCelular.setText(String.valueOf(tblLector.getValueAt(seleccion,2)));
        txtObservacion.setText(String.valueOf(tblLector.getValueAt(seleccion,3)));
        
        
       
    }//GEN-LAST:event_tblLectorMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Lector objLector= new Lector ();
        int celular= Integer.parseInt(txtCelular.getText());
        String nombre=txtNombre.getText();
        String observacion=txtObservacion.getText();

        boolean resultado=objLector.insertarLector(nombre,celular,observacion);

        if (resultado){

            JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            modeloLector.setNumRows(0);
            cargarTabla();

        }
        else{
            JOptionPane.showMessageDialog(null,"Ocurrio un error");
        }
        //**Limpio los Campos
        txtDNI.setText("");
        txtNombre.setText("");
        txtCelular.setText("");
        txtObservacion.setText("");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Lector objLector = new Lector();
        int dniLector = Integer.parseInt(txtDNI.getText());
        boolean resultado = objLector.eliminarLector(dniLector);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
            modeloLector.setNumRows(0);

            cargarTabla();

        } else {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el Sistema");
        }

        // *** Limpio los Campos ***
        txtDNI.setText("");
        txtNombre.setText("");
        txtNombre.setText("");
        txtObservacion.setText("");

    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLector;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
