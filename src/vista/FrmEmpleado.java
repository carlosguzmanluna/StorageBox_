package vista;
import controlador.FrmView;
import controlador.StorageBoxController;
import excepciones.DatosInvalidosException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.PuestoEmpleado;

public class FrmEmpleado extends javax.swing.JFrame 
    implements FrmView<Empleado> {
    private StorageBoxController controller;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmEmpleado.class.getName());
    public FrmEmpleado(StorageBoxController controller) {
        this.controller = controller;
        initComponents();
        cargarEmpleados();
    }

    private void cargarEmpleados() {
        DefaultTableModel modelo = (DefaultTableModel) Empleados_tbl.getModel();
        modelo.setRowCount(0);
        ArrayList<Empleado> lista = new ArrayList<>(controller.listarEmpleados());
        for (int i = 0; i < lista.size(); i++) {
            Empleado empleado = lista.get(i);
            modelo.addRow(new Object[]{
                empleado.getIdentificacion(),
                empleado.getNombreCompleto(),
                empleado.getTelefono(),
                empleado.getPuesto() != null ? empleado.getPuesto().name() : "",
                empleado.getPuesto() != null ? empleado.getPuesto().getSalario() : 0.0
            });
        }
    }

    @Override
    public void clear() {
        Id_txt.setText("");
        Nombre_txt.setText("");
        Telefono_txt.setText("");
        Puesto_cbx.setSelectedIndex(0);
        jTextField1.setText("");
        Id_txt.setEditable(true);
    }

    @Override
    public void showData(Empleado data) {
        Id_txt.setText(data.getIdentificacion());
        Nombre_txt.setText(data.getNombreCompleto());
        Telefono_txt.setText(data.getTelefono());
        Puesto_cbx.setSelectedItem(data.getPuesto());
        jTextField1.setText(String.valueOf(data.getSalario()));
        Id_txt.setEditable(false);
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

        jLabel1 = new javax.swing.JLabel();
        Id_lbl = new javax.swing.JLabel();
        Id_txt = new javax.swing.JTextField();
        Nombre_lbl = new javax.swing.JLabel();
        Nombre_txt = new javax.swing.JTextField();
        Telefono_lbl = new javax.swing.JLabel();
        Telefono_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Empleados_tbl = new javax.swing.JTable();
        Puesto_lbl = new javax.swing.JLabel();
        Puesto_cbx = new javax.swing.JComboBox<>();
        Salario_lbl = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Agregar_btn = new javax.swing.JButton();
        Actualizar_btn = new javax.swing.JButton();
        Eliminar_btn = new javax.swing.JButton();
        Limpiar_btn = new javax.swing.JButton();
        Buscar_btn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Empleado");

        Id_lbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Id_lbl.setText("Identificación");

        Id_txt.addActionListener(this::Id_txtActionPerformed);

        Nombre_lbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Nombre_lbl.setText("Nombre Completo");

        Nombre_txt.addActionListener(this::Nombre_txtActionPerformed);

        Telefono_lbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Telefono_lbl.setText("Teléfono");

        Telefono_txt.addActionListener(this::Telefono_txtActionPerformed);

        Empleados_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Identificación", "Nombre Completo", "Teléfono", "Puesto", "Salario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Empleados_tbl);

        Puesto_lbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Puesto_lbl.setText("Puesto");

        Puesto_cbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija su puesto :)", "Administrador", "Encargado de Bodega", "Mantenimiento", "Recepcionista", "Operario de Carga" }));
        Puesto_cbx.addActionListener(this::Puesto_cbxActionPerformed);

        Salario_lbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Salario_lbl.setText("Salario");

        jTextField1.setEditable(false);
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        Agregar_btn.setText("Agregar");
        Agregar_btn.addActionListener(this::Agregar_btnActionPerformed);

        Actualizar_btn.setText("Actualizar");
        Actualizar_btn.addActionListener(this::Actualizar_btnActionPerformed);

        Eliminar_btn.setText("Eliminar");
        Eliminar_btn.addActionListener(this::Eliminar_btnActionPerformed);

        Limpiar_btn.setText("Limpiar");
        Limpiar_btn.addActionListener(this::Limpiar_btnActionPerformed);

        Buscar_btn.setText("Buscar");
        Buscar_btn.addActionListener(this::Buscar_btnActionPerformed);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Puesto_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Id_lbl)
                            .addComponent(Id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Puesto_lbl))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Salario_lbl)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(Limpiar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(Actualizar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(Buscar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Agregar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Eliminar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 60, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre_lbl)
                                    .addComponent(Nombre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Telefono_lbl)
                                    .addComponent(Telefono_txt))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre_lbl)
                    .addComponent(Telefono_lbl)
                    .addComponent(Id_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Telefono_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Puesto_lbl)
                    .addComponent(Salario_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Puesto_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Agregar_btn)
                    .addComponent(Eliminar_btn)
                    .addComponent(Buscar_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Limpiar_btn)
                    .addComponent(Actualizar_btn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Id_txtActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void Nombre_txtActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void Telefono_txtActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void Puesto_cbxActionPerformed(java.awt.event.ActionEvent evt) {
        String puestoStr = Puesto_cbx.getSelectedItem().toString();
        if (puestoStr.startsWith("Elija")) {
            jTextField1.setText("");
            return;
        }
        
        try {
            PuestoEmpleado puestoEnum = switch (puestoStr) {
                case "Administrador" -> PuestoEmpleado.Administrador;
                case "Recepcionista" -> PuestoEmpleado.Recepcionista;
                case "Encargado de Bodega" -> PuestoEmpleado.EncargadoBodega;
                case "Mantenimiento" -> PuestoEmpleado.Mantenimiento;
                case "Operario de Carga" -> PuestoEmpleado.OperarioCarga;
                default -> null;
            };
            
            if (puestoEnum != null) {
                jTextField1.setText(String.valueOf(puestoEnum.getSalario()));
            }
        } catch (Exception e) {
            jTextField1.setText("");
        }
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void Agregar_btnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = Id_txt.getText().trim();
            String nombre = Nombre_txt.getText().trim();
            String telefono = Telefono_txt.getText().trim();
            int selectedIndex = Puesto_cbx.getSelectedIndex();

            if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || selectedIndex == 0) {
                showError("Complete todos los campos y seleccione un puesto.");
                return;
            }

            String puestoStr = Puesto_cbx.getSelectedItem().toString();
            PuestoEmpleado puestoEnum = switch (puestoStr) {
                case "Administrador" -> PuestoEmpleado.Administrador;
                case "Recepcionista" -> PuestoEmpleado.Recepcionista;
                case "Encargado de Bodega" -> PuestoEmpleado.EncargadoBodega;
                case "Mantenimiento" -> PuestoEmpleado.Mantenimiento;
                case "Operario de Carga" -> PuestoEmpleado.OperarioCarga;
                default -> null;
            };
            
            if (puestoEnum == null) {
                showError("Debe seleccionar un puesto válido.");
                return;
            }

            Empleado nuevoEmpleado = new Empleado(id, nombre, telefono, puestoEnum);
            controller.agregarEmpleado(nuevoEmpleado);
            showMessage("Empleado agregado correctamente.");
            cargarEmpleados();
            clear();

        } catch (DatosInvalidosException e) {
            showError(e.getMessage());
        } catch (Exception e) {
            showError("Ocurrió un error al agregar: " + e.getMessage());
        }
    }

    private void Actualizar_btnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = Id_txt.getText().trim();
            String nombre = Nombre_txt.getText().trim();
            String telefono = Telefono_txt.getText().trim();
            int selectedIndex = Puesto_cbx.getSelectedIndex();

            if (id.isEmpty()) {
                showError("Debe ingresar la identificación del empleado a actualizar.");
                return;
            }

            if (selectedIndex == 0) {
                showError("Debe seleccionar un puesto válido.");
                return;
            }

            String puestoStr = Puesto_cbx.getSelectedItem().toString();
            PuestoEmpleado puestoEnum = switch (puestoStr) {
                case "Administrador" -> PuestoEmpleado.Administrador;
                case "Recepcionista" -> PuestoEmpleado.Recepcionista;
                case "Encargado de Bodega" -> PuestoEmpleado.EncargadoBodega;
                case "Mantenimiento" -> PuestoEmpleado.Mantenimiento;
                case "Operario de Carga" -> PuestoEmpleado.OperarioCarga;
                default -> null;
            };

            controller.actualizarEmpleado(id, nombre, telefono, puestoEnum);
            showMessage("Empleado actualizado correctamente.");
            cargarEmpleados();
            clear();

        } catch (DatosInvalidosException e) {
            showError(e.getMessage());
        } catch (Exception e) {
            showError("Error al actualizar: " + e.getMessage());
        }
    }

    private void Eliminar_btnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String id = Id_txt.getText().trim();
            if (id.isEmpty()) {
                showError("Ingrese la identificación del empleado que desea eliminar.");
                return;
            }
            controller.eliminarEmpleado(id);
            showMessage("Empleado eliminado correctamente.");
            cargarEmpleados();
            clear();

        } catch (DatosInvalidosException e) {
            showError(e.getMessage());
        } catch (Exception e) {
            showError("Excepción de Negocio: " + e.getMessage());
        }
    }

    private void Limpiar_btnActionPerformed(java.awt.event.ActionEvent evt) {
        clear();
    }

    private void Buscar_btnActionPerformed(java.awt.event.ActionEvent evt) {
        BuscarEmpleado buscarEmpleado = new BuscarEmpleado(controller, this);
        buscarEmpleado.setVisible(true);
    }

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

        java.awt.EventQueue.invokeLater(() -> {
            StorageBoxController controller = new StorageBoxController();
            new FrmEmpleado(controller).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar_btn;
    private javax.swing.JButton Agregar_btn;
    private javax.swing.JButton Buscar_btn;
    private javax.swing.JButton Eliminar_btn;
    private javax.swing.JTable Empleados_tbl;
    private javax.swing.JLabel Id_lbl;
    private javax.swing.JTextField Id_txt;
    private javax.swing.JButton Limpiar_btn;
    private javax.swing.JLabel Nombre_lbl;
    private javax.swing.JTextField Nombre_txt;
    private javax.swing.JComboBox<String> Puesto_cbx;
    private javax.swing.JLabel Puesto_lbl;
    private javax.swing.JLabel Salario_lbl;
    private javax.swing.JLabel Telefono_lbl;
    private javax.swing.JTextField Telefono_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}