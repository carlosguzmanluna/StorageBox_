package vista;
import controlador.StorageBoxController;
public class FrmMenuPrincipal extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName());
    private final StorageBoxController controller;
    public FrmMenuPrincipal() {
        this.controller = new StorageBoxController();
        initComponents(); 
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEspacios = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        btnContratos = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEspacios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEspacios.setText("Espacios");
        btnEspacios.addActionListener(this::btnEspaciosActionPerformed);
        jPanel1.add(btnEspacios, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 349, 120, 40));

        btnClientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(this::btnClientesActionPerformed);
        jPanel1.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 130, 40));

        btnServicios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnServicios.setText("Servicios");
        btnServicios.addActionListener(this::btnServiciosActionPerformed);
        jPanel1.add(btnServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 120, 40));

        btnContratos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnContratos.setText("Contratos");
        btnContratos.addActionListener(this::btnContratosActionPerformed);
        jPanel1.add(btnContratos, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 130, 40));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setText("Salir");
        jButton10.addActionListener(this::jButton10ActionPerformed);
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, -1, -1));

        btnEmpleados.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.addActionListener(this::btnEmpleadosActionPerformed);
        jPanel1.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 140, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/storagebox.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEspaciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspaciosActionPerformed
FrmEspacio frmEspacio = new FrmEspacio(controller);
        frmEspacio.setVisible(true);
    }//GEN-LAST:event_btnEspaciosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
FrmCliente frmCliente = new FrmCliente(controller);
        frmCliente.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosActionPerformed
FrmServicio frmServicio = new FrmServicio(controller);
        frmServicio.setVisible(true);
    }//GEN-LAST:event_btnServiciosActionPerformed

    private void btnContratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContratosActionPerformed
FrmContrato frmContrato = new FrmContrato(controller);
        frmContrato.setVisible(true);
    }//GEN-LAST:event_btnContratosActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
FrmEmpleado frmEmpleado = new FrmEmpleado(controller);
        frmEmpleado.setVisible(true);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmMenuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnContratos;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnEspacios;
    private javax.swing.JButton btnServicios;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
