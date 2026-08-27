package vista;
import modelo.Empleado;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controlador.FrmView;
import controlador.StorageBoxController;

public class BuscarEmpleado extends javax.swing.JFrame
        implements FrmView<Empleado> {

    private StorageBoxController controller;
    private FrmView<Empleado> view;

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(
                    BuscarEmpleado.class.getName());

    public BuscarEmpleado(StorageBoxController controller,
            FrmView<Empleado> view) {
        
        initComponents();
         this.controller = controller;
        this.view = view;
        cargarEmpleados();
        
        
    }
   private void cargarEmpleados() {
    DefaultTableModel modelo =
   (DefaultTableModel) Tablita_tbl.getModel();
    modelo.setRowCount(0);
    ArrayList<Empleado> lista =
    new ArrayList<>(controller.listarEmpleados());
    for (int i = 0; i < lista.size(); i++) {
        Empleado empleado = lista.get(i);
        modelo.addRow(new Object[]{
            empleado.getIdentificacion(),
            empleado.getNombreCompleto(),
            empleado.getTelefono(),
            empleado.getPuesto(),
            empleado.getSalario()
        });
    }
}
   @Override
public void clear() {
    ID_txt.setText("");
    Nombre_txt.setText("");
}
@Override
public void showData(Empleado data) {
}

@Override
public void showError(String error) {
    JOptionPane.showMessageDialog(this,error,"Error",JOptionPane.ERROR_MESSAGE);
}

@Override
public void showMessage(String message) {
    JOptionPane.showMessageDialog(this,message,"StorageBox",JOptionPane.INFORMATION_MESSAGE
    );
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ID_lbl = new javax.swing.JLabel();
        Nombre_lbl = new javax.swing.JLabel();
        Buscar_btn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tablita_tbl = new javax.swing.JTable();
        ID_txt = new javax.swing.JTextField();
        Nombre_txt = new javax.swing.JTextField();
        BuscarEmpleado_lbl = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ID_lbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ID_lbl.setText("Identificación");

        Nombre_lbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Nombre_lbl.setText("Nombre Completo");

        Buscar_btn.setText("Buscar");
        Buscar_btn.addActionListener(this::Buscar_btnActionPerformed);

        Tablita_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Teléfono", "Puesto", "Salario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(Tablita_tbl);

        ID_txt.addActionListener(this::ID_txtActionPerformed);

        Nombre_txt.addActionListener(this::Nombre_txtActionPerformed);

        BuscarEmpleado_lbl.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        BuscarEmpleado_lbl.setText("Buscar Empleado");

        btnAceptar.setText("Aceptar ");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BuscarEmpleado_lbl)
                        .addGap(282, 282, 282))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID_lbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre_lbl)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Nombre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Buscar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(btnAceptar)
                        .addGap(64, 64, 64)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BuscarEmpleado_lbl)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_lbl)
                    .addComponent(Nombre_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ID_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_txtActionPerformed

    private void Nombre_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_txtActionPerformed

    private void Buscar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_btnActionPerformed
   try {
        String identificacion = ID_txt.getText();
        String nombre = Nombre_txt.getText();
        ArrayList<Empleado> resultados =
                new ArrayList<>();
        if (!identificacion.isEmpty()) {
            Empleado empleado =
                    controller.buscarEmpleadoPorIdentificacion(
                            identificacion);
            if (empleado != null) {
                resultados.add(empleado);
            }
        } else if (!nombre.isEmpty()) {
            resultados =
       controller.buscarEmpleadosPorNombre(nombre);
        } else {
        resultados =new ArrayList<>(controller.listarEmpleados());
        }
        DefaultTableModel modelo =
                (DefaultTableModel) Tablita_tbl.getModel();
        modelo.setRowCount(0);
        for (int i = 0; i < resultados.size(); i++) {
            Empleado empleado = resultados.get(i);
            modelo.addRow(new Object[]{
                empleado.getIdentificacion(),
                empleado.getNombreCompleto(),
                empleado.getTelefono(),
                empleado.getPuesto(),
                empleado.getSalario()
            });
        }
        if (resultados.isEmpty()) {
            showMessage("No se encontró ningún empleado");
        }
    } catch (Exception ex) {

        showError(ex.getMessage());
    }
    }//GEN-LAST:event_Buscar_btnActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

    try {
        int fila = Tablita_tbl.getSelectedRow();
        if (fila == -1) {
            throw new Exception(
                    "Debe seleccionar un empleado");
        }
        String identificacion =
                Tablita_tbl.getValueAt(fila, 0).toString();
        Empleado empleado =controller.buscarEmpleadoPorIdentificacion(identificacion);
        if (empleado == null) {
            throw new Exception("No se pudo obtener el empleado");
        }
        view.showData(empleado);
        setVisible(false);
    } catch (Exception ex) {
        showError(ex.getMessage());
    }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
      StorageBoxController controller =
      new StorageBoxController();
    BuscarEmpleado buscarEmpleado =
    new BuscarEmpleado(controller, null);
    buscarEmpleado.setVisible(true);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuscarEmpleado_lbl;
    private javax.swing.JButton Buscar_btn;
    private javax.swing.JLabel ID_lbl;
    private javax.swing.JTextField ID_txt;
    private javax.swing.JLabel Nombre_lbl;
    private javax.swing.JTextField Nombre_txt;
    private javax.swing.JTable Tablita_tbl;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}