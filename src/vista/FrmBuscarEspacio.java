package vista;
import controlador.StorageBoxController;
import modelo.Espacio;
import modelo.TipoEspacio;
import modelo.EstadoEspacio;
import java.util.ArrayList;

public class FrmBuscarEspacio extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmBuscarEspacio.class.getName());
    private StorageBoxController controlador;
    public FrmBuscarEspacio(StorageBoxController controlador) {
        this.controlador = controlador;
        initComponents();
        }
    
    public FrmBuscarEspacio() {
        initComponents();
    }

    public void limpiarBusqueda() {
        txtNumero.setText("");
        if (cmbTipo.getItemCount() > 0) cmbTipo.setSelectedIndex(0);
        if (cmbDisponibilidad.getItemCount() > 0) cmbDisponibilidad.setSelectedIndex(0);
        txtPrecioDesde.setText("");
        txtPrecioHasta.setText("");
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tblEspacios.getModel();
        modeloTabla.setRowCount(0); 
    }

    public void mostrarResultados(java.util.List<Espacio> lista) {
        javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tblEspacios.getModel();
        modeloTabla.setRowCount(0); 
        for (Espacio esp : lista) {
            modeloTabla.addRow(new Object[]{
                esp.getNumero(),
                esp.getTipo(),
                esp.getMetrosCuadrados(),
                esp.getPrecioMensual(),
                esp.getEstado() 
            });
        }
    }

    public String getTextoNumero() {
        return txtNumero.getText().trim();
    }

    public String getTextoPrecioDesde() {
        return txtPrecioDesde.getText().trim();
    }

    public String getTextoPrecioHasta() {
        return txtPrecioHasta.getText().trim();
    }

    public Object getTipoSeleccionado() {
        return cmbTipo.getSelectedItem();
    }

    public Object getDisponibilidadSeleccionada() {
        return cmbDisponibilidad.getSelectedItem();
    }

    public javax.swing.JButton getBtnBuscar() {
        return btnBuscar;
    }

    public javax.swing.JButton getAceptarBtn() {
        return Aceptar_btn;
    }
    public javax.swing.JButton getCancelarBtn() {
        return Cancelar_btn;
    }
    
    public javax.swing.JTable getTblEspacios() {
        return tblEspacios;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        lblDisponibilidad = new javax.swing.JLabel();
        lblPrecioDesde = new javax.swing.JLabel();
        cmbDisponibilidad = new javax.swing.JComboBox<>();
        txtPrecioHasta = new javax.swing.JTextField();
        lblPrecioHasta = new javax.swing.JLabel();
        txtPrecioDesde = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        scrollEspacios = new javax.swing.JScrollPane();
        tblEspacios = new javax.swing.JTable();
        Aceptar_btn = new javax.swing.JButton();
        Cancelar_btn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNumero.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblNumero.setText("Número:");

        txtNumero.addActionListener(this::txtNumeroActionPerformed);

        lblTipo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblTipo.setText("Tipo:");

        cmbTipo.setEditable(true);
        cmbTipo.addActionListener(this::cmbTipoActionPerformed);

        lblDisponibilidad.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblDisponibilidad.setText("Disponibilidad:");

        lblPrecioDesde.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblPrecioDesde.setText("Precio desde:");

        cmbDisponibilidad.addActionListener(this::cmbDisponibilidadActionPerformed);

        lblPrecioHasta.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblPrecioHasta.setText("Precio hasta:");

        btnBuscar.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tblEspacios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Número", "Tipo", "Metros²", "Precio Mensual", "Estado"
            }
        ));
        scrollEspacios.setViewportView(tblEspacios);

        Aceptar_btn.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        Aceptar_btn.setText("Aceptar");

        Cancelar_btn.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        Cancelar_btn.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblNumero))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblTipo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecioHasta)
                            .addComponent(lblPrecioDesde)
                            .addComponent(lblDisponibilidad))))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNumero)
                    .addComponent(cmbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDisponibilidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(txtPrecioDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(73, 73, 73))
            .addComponent(scrollEspacios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(Aceptar_btn)
                .addGap(61, 61, 61)
                .addComponent(Cancelar_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(scrollEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar_btn)
                    .addComponent(Cancelar_btn))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblTitulo.setText("Buscar espacio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void cmbDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDisponibilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDisponibilidadActionPerformed

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
try {
            String txtNum = txtNumero.getText().trim();
            Integer numero = txtNum.isEmpty() ? null : Integer.parseInt(txtNum);    
            TipoEspacio tipo = (cmbTipo.getSelectedItem() instanceof TipoEspacio) ? 
            (TipoEspacio) cmbTipo.getSelectedItem() : null;
            EstadoEspacio estado = (cmbDisponibilidad.getSelectedItem() instanceof EstadoEspacio) ? 
            (EstadoEspacio) cmbDisponibilidad.getSelectedItem() : null;                      
            String txtDesde = txtPrecioDesde.getText().trim();
            Double precioDesde = txtDesde.isEmpty() ? null : Double.parseDouble(txtDesde);           
            String txtHasta = txtPrecioHasta.getText().trim();
            Double precioHasta = txtHasta.isEmpty() ? null : Double.parseDouble(txtHasta);
            
            if (controlador != null) {
                ArrayList<Espacio> listaFiltrada = controlador.filtrarEspacios(numero, tipo, estado, precioDesde, precioHasta);
                javax.swing.table.DefaultTableModel modeloTabla = (javax.swing.table.DefaultTableModel) tblEspacios.getModel();
                modeloTabla.setRowCount(0); 
                
                for (Espacio esp : listaFiltrada) {
                    modeloTabla.addRow(new Object[]{
                        esp.getNumero(),
                        esp.getTipo(),
                        esp.getMetrosCuadrados(),
                        esp.getPrecioMensual(),
                        esp.getEstado()
                    });
                }
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, introduce números válidos en el número de espacio y los precios.", "Error de formato", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new FrmBuscarEspacio().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar_btn;
    private javax.swing.JButton Cancelar_btn;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbDisponibilidad;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDisponibilidad;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPrecioDesde;
    private javax.swing.JLabel lblPrecioHasta;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollEspacios;
    private javax.swing.JTable tblEspacios;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrecioDesde;
    private javax.swing.JTextField txtPrecioHasta;
    // End of variables declaration//GEN-END:variables
}
