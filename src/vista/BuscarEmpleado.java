package vista;
import controlador.EmpleadoController;
import modelo.Empleado;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class BuscarEmpleado extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(BuscarEmpleado.class.getName());
    private EmpleadoController empleadoController;
    public BuscarEmpleado(EmpleadoController empleadoController) {
        this.empleadoController = empleadoController;
        initComponents();
        mostrarEmpleados(empleadoController.listarEmpleados());
    }
    public BuscarEmpleado() {
        this.empleadoController = new EmpleadoController();
        initComponents();
    }
    
    public void mostrarEmpleadosEnLaTabla(java.util.List<Object[]> listEmpleados) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) Tablita_tbl.getModel();
        modelo.setRowCount(0);
        for (Object[] empleado : listEmpleados) {
            modelo.addRow(empleado);
        }
    }
   private void mostrarEmpleados(ArrayList<Empleado> listaEmpleados) {
        DefaultTableModel modelo = (DefaultTableModel) Tablita_tbl.getModel();
        modelo.setRowCount(0);
        
        for (Empleado emp : listaEmpleados) {
            Object[] fila = {
                emp.getIdentificacion(),
                emp.getNombreCompleto(),
                emp.getTelefono(),
                emp.getPuesto().toString(),
                emp.getSalario()    
            };
            modelo.addRow(fila);
        }
    }
    @SuppressWarnings("unchecked")
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(Buscar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BuscarEmpleado_lbl)
                        .addGap(282, 282, 282))))
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
String idIngresado = ID_txt.getText().trim();
        String nombreIngresado = Nombre_txt.getText().trim();
        
        ArrayList<Empleado> resultados = new ArrayList<>();
        if (!idIngresado.isEmpty()) {
            Empleado encontrado = empleadoController.buscarPorIdentificacion(idIngresado);
            if (encontrado != null) {
                resultados.add(encontrado);
            }
        } 
        else if (!nombreIngresado.isEmpty()) {
            for (Empleado emp : empleadoController.listarEmpleados()) {
                if (emp.getNombreCompleto().toLowerCase().contains(nombreIngresado.toLowerCase())) {
                    resultados.add(emp);
                }
            }
        } 
        else {
            resultados = empleadoController.listarEmpleados();
        }
        mostrarEmpleados(resultados);
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "No se encontró ningún empleado con los datos ingresados.", 
                "Sin resultados :( ", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Buscar_btnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new BuscarEmpleado().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuscarEmpleado_lbl;
    private javax.swing.JButton Buscar_btn;
    private javax.swing.JLabel ID_lbl;
    private javax.swing.JTextField ID_txt;
    private javax.swing.JLabel Nombre_lbl;
    private javax.swing.JTextField Nombre_txt;
    private javax.swing.JTable Tablita_tbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}