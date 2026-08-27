/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;
import controlador.StorageBoxController;
import modelo.Contrato;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
public class FrmBuscarContrato extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmBuscarContrato.class.getName());

private StorageBoxController storageBoxController;
private FrmContrato vistaContrato;
private Contrato contratoSeleccionado;
private List<Contrato> listaContratos;

public FrmBuscarContrato(StorageBoxController storageBoxController, FrmContrato vistaContrato) {
    initComponents();
    this.storageBoxController = storageBoxController;
    this.vistaContrato = vistaContrato;

}

public Contrato getContratoSeleccionado() {
    return contratoSeleccionado;
}
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtEspacio = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        cboEstado = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblContratos = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Contrato");

        jLabel1.setText("Numero");

        jLabel2.setText("Cliente");

        jLabel3.setText("Espacio");

        jLabel4.setText("Fecha");

        jLabel5.setText("Estado");

        txtNumero.addActionListener(this::txtNumeroActionPerformed);

        txtFecha.addActionListener(this::txtFechaActionPerformed);

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Pendiente", "Activo", "Finalizado", "Cancelado" }));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tblContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Cedula", "Fecha Inicio", "Fecha fin", "Espacio", "Estado", "Total"
            }
        ));
        jScrollPane2.setViewportView(tblContratos);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEspacio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAceptar)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnAceptar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
   String textoNumero = txtNumero.getText().trim();
    String textoCliente = txtCliente.getText().trim();
    String textoEspacio = txtEspacio.getText().trim();
    String textoFecha = txtFecha.getText().trim(); 
    String estadoSeleccionado = (String) cboEstado.getSelectedItem();

    List<Contrato> todos = storageBoxController.listarContratos();
    listaContratos = new java.util.ArrayList<>();

    for (int i = 0; i < todos.size(); i++) {
        Contrato c = todos.get(i);

        boolean coincideNumero = true;
        if (!textoNumero.isEmpty()) {
            try {
                if (c.getNumero() != Integer.parseInt(textoNumero)) {
                    coincideNumero = false;
                }
            } catch (NumberFormatException e) {
                coincideNumero = false;
            }
        }

        boolean coincideCliente = true;
        if (!textoCliente.isEmpty()) {
            String identificacionCliente = c.getCliente().getIdentificacion();
            if (!identificacionCliente.contains(textoCliente)) {
                coincideCliente = false;
            }
        }

        boolean coincideEspacio = true;
        if (!textoEspacio.isEmpty()) {
            try {
                if (c.getEspacio().getNumero() != Integer.parseInt(textoEspacio)) {
                    coincideEspacio = false;
                }
            } catch (NumberFormatException e) {
                coincideEspacio = false;
            }
        }

        boolean coincideEstado = true;
        if (!estadoSeleccionado.equals("Todos")) {
            String estadoContrato = c.getEstado().toString();
            if (!estadoContrato.equals(estadoSeleccionado)) {
                coincideEstado = false;
            }
        }

       
        boolean coincideFecha = true;
        if (!textoFecha.isEmpty()) {
            String fInicio = c.getFechaInicio() != null ? c.getFechaInicio().toString() : "";
            String fFin = c.getFechaFin() != null ? c.getFechaFin().toString() : "";
            
        
            if (!fInicio.contains(textoFecha) && !fFin.contains(textoFecha)) {
                coincideFecha = false;
            }
        }

        if (coincideNumero && coincideCliente && coincideEspacio && coincideEstado && coincideFecha) {
            listaContratos.add(c);
        }
    }

    DefaultTableModel modelo = (DefaultTableModel) tblContratos.getModel();
    modelo.setRowCount(0);

    for (int i = 0; i < listaContratos.size(); i++) {
        Contrato c = listaContratos.get(i);
        Object[] fila = {
            c.getNumero(),
            c.getCliente().getIdentificacion(),
            c.getFechaInicio(),
            c.getFechaFin(),
            c.getEspacio().getNumero(),
            c.getEstado(),
            c.calcularTotal()
        };
        modelo.addRow(fila);
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        contratoSeleccionado = null;
    dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       int filaSeleccionada = tblContratos.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un contrato de la tabla");
        return;
    }

    contratoSeleccionado = listaContratos.get(filaSeleccionada);
    
    // Le envía el contrato seleccionado a FrmContrato y la actualiza
    if (vistaContrato != null) {
        vistaContrato.cargarContrato(contratoSeleccionado); // o el método con el que lo muestras en FrmContrato
    }
    
    dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblContratos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtEspacio;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}
