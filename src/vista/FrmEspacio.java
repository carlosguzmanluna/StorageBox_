package vista;
import controlador.FrmView;
import controlador.StorageBoxController;
import modelo.Espacio;
import excepciones.DatosInvalidosException;
import excepciones.EspacioDuplicadoException;
import excepciones.EspacioOcupadoException;
import modelo.TipoEspacio;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmEspacio extends javax.swing.JFrame implements FrmView<Espacio> {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmEspacio.class.getName());
    private StorageBoxController controller;

    public FrmEspacio(StorageBoxController controller) {
        initComponents();
        cmbEspacio.addActionListener(e -> actualizarCamposAutomaticos());
        this.controller = controller;
        cargarEspacios();
        setLocationRelativeTo(null);
    }

    private void cargarEspacios() {
        DefaultTableModel modelo = (DefaultTableModel) tblEspacios.getModel();
        modelo.setRowCount(0);
        ArrayList<Espacio> lista = new ArrayList<>(controller.listarEspacios());
        for (int i = 0; i < lista.size(); i++) {
            Espacio e = lista.get(i);
            modelo.addRow(new Object[]{
                e.getNumero(),
                e.getTipo(),
                e.getMetrosCuadrados(),
                e.getPrecioMensual()  
            });
        }
    }
     
    @Override
    public void clear() {
        txtNumero.setText("");
        txtMetrosCuadrados.setText("");
        txtPrecio.setText("");
        txtEstado.setText("Disponible");
        txtNumero.setEnabled(true);
    }

    @Override
    public void showData(Espacio data) {
        txtNumero.setText(String.valueOf(data.getNumero()));
        txtMetrosCuadrados.setText(String.valueOf(data.getMetrosCuadrados()));
        txtPrecio.setText(String.valueOf(data.getPrecioMensual()));
        txtEstado.setText(data.getEstado().toString());
       
        if (data.getTipo() == TipoEspacio.PEQUENO) {
            cmbEspacio.setSelectedItem("Pequeño");
        } else if (data.getTipo() == TipoEspacio.MEDIANO) {
            cmbEspacio.setSelectedItem("Mediano");
        } else if (data.getTipo() == TipoEspacio.GRANDE) {
            cmbEspacio.setSelectedItem("Grande");
        }
        
        txtNumero.setEnabled(false);
    }

    @Override
    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "StorageBox", JOptionPane.INFORMATION_MESSAGE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblTipoEspacio = new javax.swing.JLabel();
        lblMetrosCuadrados = new javax.swing.JLabel();
        txtMetrosCuadrados = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        cmbEspacio = new javax.swing.JComboBox<>();
        btnCargar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblLista = new javax.swing.JLabel();
        scrollEspacios = new javax.swing.JScrollPane();
        tblEspacios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNumero.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblNumero.setText("Número:");

        txtNumero.addActionListener(this::txtNumeroActionPerformed);

        lblTipoEspacio.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblTipoEspacio.setText("Tipo de espacio:");

        lblMetrosCuadrados.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblMetrosCuadrados.setText("Metros Cuadrados:");

        txtMetrosCuadrados.addActionListener(this::txtMetrosCuadradosActionPerformed);

        lblPrecio.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblPrecio.setText("Precio Mensual:");

        lblEstado.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        lblEstado.setText("Estado:");

        txtPrecio.addActionListener(this::txtPrecioActionPerformed);

        txtEstado.setEditable(false);
        txtEstado.setText("Disponible");
        txtEstado.addActionListener(this::txtEstadoActionPerformed);

        btnAgregar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);

        btnActualizar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnEliminar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);

        btnLimpiar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        cmbEspacio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeño", "Mediano", "Grande" }));

        btnCargar.setText("Cargar Seleccionado");
        btnCargar.addActionListener(this::btnCargarActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblMetrosCuadrados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMetrosCuadrados, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lblTipoEspacio))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lblNumero)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCargar)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEstado)
                                        .addComponent(btnAgregar)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(btnActualizar)
                                        .addGap(63, 63, 63)
                                        .addComponent(btnEliminar)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnLimpiar)))))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoEspacio)
                    .addComponent(cmbEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetrosCuadrados)
                    .addComponent(txtMetrosCuadrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(btnCargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLista.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblLista.setText("Lista de espacios");
        lblLista.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        tblEspacios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número", "Tipo", "Metros²", "Precio"
            }
        ));
        scrollEspacios.setViewportView(tblEspacios);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(lblLista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollEspacios)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollEspacios, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTitulo.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblTitulo.setText("Espacio ");
        lblTitulo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(244, 244, 244))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void txtMetrosCuadradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMetrosCuadradosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMetrosCuadradosActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed
private void actualizarCamposAutomaticos() {
        String seleccion = (String) cmbEspacio.getSelectedItem();
        TipoEspacio tipo = TipoEspacio.PEQUENO;
        if ("Mediano".equals(seleccion)) tipo = TipoEspacio.MEDIANO;
        if ("Grande".equals(seleccion)) tipo = TipoEspacio.GRANDE;

        txtMetrosCuadrados.setText(String.valueOf(tipo.getMetrosCuadrados()));
        txtPrecio.setText(String.valueOf(tipo.getPrecioMensual()));
    }
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
  try {
           int numero = Integer.parseInt(txtNumero.getText());
           TipoEspacio tipo = TipoEspacio.PEQUENO;
           if (cmbEspacio.getSelectedItem().equals("Mediano")) {
               tipo = TipoEspacio.MEDIANO;
           }
           if (cmbEspacio.getSelectedItem().equals("Grande")) {
               tipo = TipoEspacio.GRANDE;
           }
           
           Espacio espacio = controller.buscarPorNumero(numero);
           if (espacio != null) {
               espacio.setTipo(tipo);
     controller.actualizarEspacio(numero, tipo, espacio.getMetrosCuadrados(), espacio.getPrecioMensual());
               showMessage("Espacio actualizado correctamente");
               cargarEspacios();
               clear();
           } else {
               showError("No se encontró el espacio a actualizar");
           }
       } catch (DatosInvalidosException ex) {
           showError(ex.getMessage());
       } catch (NumberFormatException ex) {
           showError("Verifique que los valores numéricos sean válidos");
       }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            int numero = Integer.parseInt(txtNumero.getText());
            controller.eliminarEspacio(numero);
            showMessage("Espacio eliminado");
            cargarEspacios();
            clear();
        } catch (DatosInvalidosException ex) {
            showError(ex.getMessage());
        } catch (EspacioOcupadoException ex) {
            showError(ex.getMessage());
        } catch (NumberFormatException ex) {
            showError("Error: El número debe ser un valor numérico");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
     try {
            int numero = Integer.parseInt(txtNumero.getText());
            TipoEspacio tipo = TipoEspacio.PEQUENO;
            if (cmbEspacio.getSelectedItem().equals("Mediano")) {
                tipo = TipoEspacio.MEDIANO;
            }
            if (cmbEspacio.getSelectedItem().equals("Grande")) {
                tipo = TipoEspacio.GRANDE;
            } 
            
            Espacio espacio = new Espacio(numero, tipo);
            controller.agregarEspacio(espacio);
            showMessage("Espacio agregado correctamente");
            cargarEspacios();
            clear(); 
        } catch (DatosInvalidosException | EspacioDuplicadoException ex) {
            showError(ex.getMessage());
        } catch (NumberFormatException ex) {
            showError("El número debe ser un valor numérico");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       clear();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
int fila = tblEspacios.getSelectedRow();
         if (fila >= 0) {
             int numero = (int) tblEspacios.getValueAt(fila, 0);
             Espacio espacio = controller.buscarPorNumero(numero);
             if (espacio != null) {
                 showData(espacio);
             }
         } else {
             showError("Seleccione un espacio de la tabla");
         }
    }//GEN-LAST:event_btnCargarActionPerformed

    public static void main(String args[]) {
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
        StorageBoxController controller = new StorageBoxController();
        FrmEspacio frmEspacio = new FrmEspacio(controller);
        frmEspacio.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbEspacio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblLista;
    private javax.swing.JLabel lblMetrosCuadrados;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTipoEspacio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollEspacios;
    private javax.swing.JTable tblEspacios;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMetrosCuadrados;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
