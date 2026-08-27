package vista;
import controlador.StorageBoxController;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Espacio;
import modelo.Servicio;
import modelo.TipoEspacio;
import modelo.EstadoContrato;
import excepciones.DatosInvalidosException;
import excepciones.FechaContratoException;
import excepciones.EstadoNoPermitidoException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FrmContrato extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmContrato.class.getName());
    private StorageBoxController storageBoxController;
    private Cliente clienteSeleccionado;
    private Espacio espacioAsignado;
    private Contrato contratoActual;
    private List<Servicio> serviciosTemporales;

    public FrmContrato(StorageBoxController storageBoxController) {
        initComponents();
        this.storageBoxController = storageBoxController;
        this.serviciosTemporales = new ArrayList<>();
        configurarTablaServicios();
        actualizarDisponibilidadEspacios();
        cmbTipo.addActionListener(e -> actualizarDisponibilidadEspacios());
        actualizarEstadoBotones();
    }

    public FrmContrato() {
        initComponents();
        this.serviciosTemporales = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNumeroContrato = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblEstadoValor = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        btnValidarCliente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        lblDiponibles = new javax.swing.JLabel();
        lblEspacioAsignado = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblFin = new javax.swing.JLabel();
        cmbDiaInicio = new javax.swing.JComboBox<>();
        cmbMesInicio = new javax.swing.JComboBox<>();
        cmbAnoInicio = new javax.swing.JComboBox<>();
        cmbDiaFin = new javax.swing.JComboBox<>();
        cmbMesInicio1 = new javax.swing.JComboBox<>();
        cmbAnoFin = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        lblServiciosAdicionales = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicioContrato = new javax.swing.JTable();
        btnAgregarServicio = new javax.swing.JButton();
        btnQuitarServicio = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblCostos = new javax.swing.JLabel();
        lblEspacio = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnCrearContrato = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscarContrato = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel1.setText("Contrato");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        lblNumeroContrato.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblNumeroContrato.setText("N° contrato");

        lblEstado.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblEstado.setText("Estado");

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel2.setText("Automatico");

        lblEstadoValor.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblEstadoValor.setText("Pendiente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNumeroContrato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstadoValor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroContrato)
                    .addComponent(jLabel2)
                    .addComponent(lblEstado)
                    .addComponent(lblEstadoValor))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Informacion Cliente");

        lblIdentificacion.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblIdentificacion.setText("Identificacion");

        btnValidarCliente.setText("Validar");
        btnValidarCliente.addActionListener(this::btnValidarClienteActionPerformed);

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setText("Nombre");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnValidarCliente)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentificacion)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setText("Espacio");

        lblTipo.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblTipo.setText("Tipo");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeño", "Mediano", "Grande" }));
        cmbTipo.addActionListener(this::cmbTipoActionPerformed);

        lblDiponibles.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblDiponibles.setText("Disponibles");

        lblEspacioAsignado.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblEspacioAsignado.setText("Espacio Asignado");

        lblInicio.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblInicio.setText("Inicio:");

        lblFin.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblFin.setText("Fin");

        cmbDiaInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbMesInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        cmbAnoInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025", "2026", "2027", "2028", "2029", "2030" }));

        cmbDiaFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cmbMesInicio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        cmbAnoFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025", "2026", "2027", "2028", "2029", "2030" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(lblDiponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEspacioAsignado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblInicio)
                        .addGap(7, 7, 7)
                        .addComponent(cmbDiaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAnoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDiaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMesInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAnoFin, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiponibles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEspacioAsignado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio)
                    .addComponent(lblFin)
                    .addComponent(cmbDiaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAnoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDiaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMesInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAnoFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblServiciosAdicionales.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblServiciosAdicionales.setText("Servicios ");

        tblServicioContrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Servicio", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblServicioContrato);

        btnAgregarServicio.setText("Agregar");
        btnAgregarServicio.addActionListener(this::btnAgregarServicioActionPerformed);

        btnQuitarServicio.setText("Quitar");
        btnQuitarServicio.addActionListener(this::btnQuitarServicioActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblServiciosAdicionales)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAgregarServicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitarServicio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblServiciosAdicionales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarServicio)
                    .addComponent(btnQuitarServicio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCostos.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblCostos.setText("Costos");

        lblEspacio.setText("Espacio");

        lblServicio.setText("Servicio");

        lblSubtotal.setText("Subtotal");

        lblTotal.setText("Total");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCostos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEspacio)
                    .addComponent(lblServicio)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubtotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCostos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEspacio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblServicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCrearContrato.setText("Crear Contrato");
        btnCrearContrato.addActionListener(this::btnCrearContratoActionPerformed);

        btnActivar.setText("Activar");
        btnActivar.addActionListener(this::btnActivarActionPerformed);

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(this::btnFinalizarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnBuscarContrato.setText("Buscar Contrato");
        btnBuscarContrato.addActionListener(this::btnBuscarContratoActionPerformed);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearContrato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActivar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarContrato)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearContrato)
                    .addComponent(btnActivar)
                    .addComponent(btnFinalizar)
                    .addComponent(btnCancelar)
                    .addComponent(btnBuscarContrato))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidarClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        String identificacion = txtIdentificacion.getText().trim();
        if (identificacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una identificación.");
            return;
        }
        clienteSeleccionado = storageBoxController.buscarPorIdentificacion(identificacion);
        if (clienteSeleccionado == null) {
            int opcion = JOptionPane.showConfirmDialog(this, 
                "Cliente no encontrado. ¿Desea ir a registrarlo?", 
                "Cliente no registrado", 
                JOptionPane.YES_NO_OPTION);
            
            if (opcion == JOptionPane.YES_OPTION) {
                FrmCliente frmCliente = new FrmCliente(this.storageBoxController);
                frmCliente.setVisible(true);
            }
            txtNombreCliente.setText("");
        } else {
            txtNombreCliente.setText(clienteSeleccionado.getNombreCompleto());
            JOptionPane.showMessageDialog(this, "Cliente encontrado: " + clienteSeleccionado.getNombreCompleto());
        }
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

        java.awt.EventQueue.invokeLater(() -> new FrmContrato().setVisible(true));
    }                                                 

    private void btnAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        if (clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe validar un cliente primero.");
            return;
        }
        if (contratoActual != null) {
            JOptionPane.showMessageDialog(this, "No se pueden agregar servicios a un contrato ya procesado.");
            return;
        }
        String textoCodigo = JOptionPane.showInputDialog(this, "Ingrese el codigo del servicio:");
        if (textoCodigo == null || textoCodigo.trim().isEmpty()) {
            return;
        }

        int codigo;
        try {
            codigo = Integer.parseInt(textoCodigo.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El codigo debe ser un valor numerico.");
            return;
        }

        Servicio servicio = storageBoxController.buscarPorCodigo(codigo);
        if (servicio == null) {
            JOptionPane.showMessageDialog(this, "No existe un servicio con ese codigo");
            return;
        }
        for (Servicio s : serviciosTemporales) {
            if (s.getCodigo() == servicio.getCodigo()) {
                JOptionPane.showMessageDialog(this, "El servicio ya esta agregado.");
                return;
            }
        }
        serviciosTemporales.add(servicio);
        DefaultTableModel modelo = (DefaultTableModel) tblServicioContrato.getModel();
        Object[] fila = {servicio.getCodigo(), servicio.getNombre(), servicio.getPrecio()};
        modelo.addRow(fila);
        actualizarCalculosVisuales();
    }                                                  

    private void btnQuitarServicioActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        int filaSeleccionada = tblServicioContrato.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un servicio de la tabla");
            return;
        }

        if (contratoActual != null) {
            JOptionPane.showMessageDialog(this, "No se puede quitar un servicio despues de creado el contrato");
            return;
        }

        serviciosTemporales.remove(filaSeleccionada);
        DefaultTableModel modelo = (DefaultTableModel) tblServicioContrato.getModel();
        modelo.removeRow(filaSeleccionada);
        actualizarCalculosVisuales();
    }                                                 

    private void btnCrearContratoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe validar un cliente antes de crear el contrato.");
            return;
        }
        if (contratoActual != null) {
            JOptionPane.showMessageDialog(this, "Ya existe un contrato creado. Finalice o cancele el actual.");
            return;
        }

        TipoEspacio tipo = obtenerTipoSeleccionado();

        int diaInicio = Integer.parseInt((String) cmbDiaInicio.getSelectedItem());
        int mesInicio = obtenerNumeroMes((String) cmbMesInicio.getSelectedItem());
        int anioInicio = Integer.parseInt((String) cmbAnoInicio.getSelectedItem());
        LocalDate fechaInicio = LocalDate.of(anioInicio, mesInicio, diaInicio);

        int diaFin = Integer.parseInt((String) cmbDiaFin.getSelectedItem());
        int mesFin = obtenerNumeroMes((String) cmbMesInicio1.getSelectedItem());
        int anioFin = Integer.parseInt((String) cmbAnoFin.getSelectedItem());
        LocalDate fechaFin = LocalDate.of(anioFin, mesFin, diaFin);

        ArrayList<Espacio> disponibles = storageBoxController.buscarEspaciosDisponibles(tipo, fechaInicio, fechaFin);
        lblDiponibles.setText("Disponibles: " + disponibles.size());

        if (disponibles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay espacios disponibles del tipo seleccionado para esas fechas.");
            return;
        }

        try {
            contratoActual = storageBoxController.crearContrato(
                    clienteSeleccionado.getIdentificacion(), tipo, fechaInicio, fechaFin);

            for (int i = 0; i < serviciosTemporales.size(); i++) {
                contratoActual.agregarServicio(serviciosTemporales.get(i));
            }

            espacioAsignado = contratoActual.getEspacio();
            actualizarDatosContrato();
            btnCrearContrato.setEnabled(false);

        } catch (DatosInvalidosException | FechaContratoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                                

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (contratoActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear el contrato");
            return;
        }
        try {
            contratoActual.activar();
            actualizarDatosContrato();
        } catch (EstadoNoPermitidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                          

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if (contratoActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear el contrato");
            return;
        }
        try {
            contratoActual.finalizar();
            actualizarDatosContrato();
            limpiarFormularioParaNuevoContrato();
        } catch (EstadoNoPermitidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                            

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (contratoActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debe crear el contrato");
            return;
        }
        try {
            contratoActual.cancelar();
            actualizarDatosContrato();
            limpiarFormularioParaNuevoContrato();
        } catch (EstadoNoPermitidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }                                           

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {                                        
        actualizarDisponibilidadEspacios();
        actualizarCalculosVisuales();
    }                                       

    private void btnBuscarContratoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        FrmBuscarContrato frmBuscar = new FrmBuscarContrato(this.storageBoxController, this);
        frmBuscar.setVisible(true);
    }                                                 

    private int obtenerNumeroMes(String nombreMes) {
        if (nombreMes.equals("Enero")) return 1;
        if (nombreMes.equals("Febrero")) return 2;
        if (nombreMes.equals("Marzo")) return 3;
        if (nombreMes.equals("Abril")) return 4;
        if (nombreMes.equals("Mayo")) return 5;
        if (nombreMes.equals("Junio")) return 6;
        if (nombreMes.equals("Julio")) return 7;
        if (nombreMes.equals("Agosto")) return 8;
        if (nombreMes.equals("Septiembre")) return 9;
        if (nombreMes.equals("Octubre")) return 10;
        if (nombreMes.equals("Noviembre")) return 11;
        if (nombreMes.equals("Diciembre")) return 12;
        return 0;
    }

    private TipoEspacio obtenerTipoSeleccionado() {
        String seleccion = (String) cmbTipo.getSelectedItem();
        switch (seleccion) {
            case "Pequeño":
                return TipoEspacio.PEQUENO;
            case "Mediano":
                return TipoEspacio.MEDIANO;
            case "Grande":
                return TipoEspacio.GRANDE;
            default:
                return null;
        }
    }

    /**
     * Carga un contrato existente (seleccionado desde FrmBuscarContrato) en
     * el formulario, mostrando sus datos y bloqueando la creacion de uno nuevo.
     *
     * NOTA: este metodo asume que Contrato tiene un metodo getServicios()
     * que devuelve un List<Servicio> (o similar). Si tu clase Contrato usa
     * otro nombre para ese getter, ajusta la linea del for-each mas abajo.
     */
    public void cargarContrato(Contrato contrato) {
        if (contrato == null) {
            return;
        }
        this.contratoActual = contrato;
        this.clienteSeleccionado = contrato.getCliente();
        this.espacioAsignado = contrato.getEspacio();

        txtIdentificacion.setText(clienteSeleccionado.getIdentificacion());
        txtNombreCliente.setText(clienteSeleccionado.getNombreCompleto());

        DefaultTableModel modelo = (DefaultTableModel) tblServicioContrato.getModel();
        modelo.setRowCount(0);
        serviciosTemporales.clear();
        for (Servicio s : contrato.getServicios()) {
            serviciosTemporales.add(s);
            Object[] fila = {s.getCodigo(), s.getNombre(), s.getPrecio()};
            modelo.addRow(fila);
        }

        actualizarDatosContrato();
        btnCrearContrato.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnAgregarServicio;
    private javax.swing.JButton btnBuscarContrato;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearContrato;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnQuitarServicio;
    private javax.swing.JButton btnValidarCliente;
    private javax.swing.JComboBox<String> cmbAnoFin;
    private javax.swing.JComboBox<String> cmbAnoInicio;
    private javax.swing.JComboBox<String> cmbDiaFin;
    private javax.swing.JComboBox<String> cmbDiaInicio;
    private javax.swing.JComboBox<String> cmbMesInicio;
    private javax.swing.JComboBox<String> cmbMesInicio1;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCostos;
    private javax.swing.JLabel lblDiponibles;
    private javax.swing.JLabel lblEspacio;
    private javax.swing.JLabel lblEspacioAsignado;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEstadoValor;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblNumeroContrato;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JLabel lblServiciosAdicionales;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblServicioContrato;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables

    private void configurarTablaServicios() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Servicio");
        modelo.addColumn("Precio");
        tblServicioContrato.setModel(modelo);
    }

    private void actualizarDisponibilidadEspacios() {
        if (storageBoxController != null) {
            TipoEspacio tipoSeleccionado = obtenerTipoSeleccionado();
            int disponibles = storageBoxController.contarEspaciosDisponiblesPorTipo(tipoSeleccionado);
            lblDiponibles.setText("Disponibles: " + disponibles);
        }
    }

    private LocalDate construirFechaInicio() {
        int dia = Integer.parseInt((String) cmbDiaInicio.getSelectedItem());
        int mes = cmbMesInicio.getSelectedIndex() + 1;
        int anio = Integer.parseInt((String) cmbAnoInicio.getSelectedItem());
        return LocalDate.of(anio, mes, dia);
    }

    private LocalDate construirFechaFin() {
        int dia = Integer.parseInt((String) cmbDiaFin.getSelectedItem());
        int mes = cmbMesInicio1.getSelectedIndex() + 1;
        int anio = Integer.parseInt((String) cmbAnoFin.getSelectedItem());
        return LocalDate.of(anio, mes, dia);
    }

    private void actualizarCalculosVisuales() {
        if (contratoActual != null) {
            return;
        }
        try {
            TipoEspacio tipo = obtenerTipoSeleccionado();
            LocalDate inicio = construirFechaInicio();
            LocalDate fin = construirFechaFin();

            Espacio espacioPrueba = storageBoxController.obtenerPrimerEspacioDisponible(tipo, inicio, fin);
            if (espacioPrueba != null) {
                espacioAsignado = espacioPrueba;
                lblEspacioAsignado.setText("Espacio Asignado: N° " + espacioAsignado.getNumero());

                Contrato temp = new Contrato(clienteSeleccionado, espacioAsignado, inicio, fin);
                for (Servicio s : serviciosTemporales) {
                    temp.agregarServicio(s);
                }

                mostrarCostos(temp);
            } else {
                lblEspacioAsignado.setText("Espacio Asignado: Sin disponibilidad");
            }
        } catch (Exception e) {
        }
    }

    private void actualizarDatosContrato() {
        if (contratoActual == null) {
            return;
        }

        lblNumeroContrato.setText("N° contrato: " + contratoActual.getNumero());
        lblEstadoValor.setText(contratoActual.getEstado().toString());

        Espacio espacio = contratoActual.getEspacio();
        lblEspacioAsignado.setText("Espacio Asignado: N° " + espacio.getNumero());

        mostrarCostos(contratoActual);
        actualizarEstadoBotones();
    }

    private void mostrarCostos(Contrato contrato) {
        lblEspacio.setText("Espacio: ₡" + contrato.calcularCostoEspacio());
        lblServicio.setText("Servicios: ₡" + contrato.calcularCostoServicios());
        lblSubtotal.setText("Subtotal: ₡" + String.format("%.2f", contrato.calcularSubtotal()));
        lblTotal.setText("Total: ₡" + String.format("%.2f", contrato.calcularTotal()));
    }

    private void actualizarEstadoBotones() {
        if (contratoActual == null) {
            btnActivar.setEnabled(false);
            btnFinalizar.setEnabled(false);
            btnCancelar.setEnabled(false);
            return;
        }
        EstadoContrato estado = contratoActual.getEstado();
        btnActivar.setEnabled(estado == EstadoContrato.Pendiente);
        btnCancelar.setEnabled(estado == EstadoContrato.Pendiente);
        btnFinalizar.setEnabled(estado == EstadoContrato.Activo);
    }

    private void limpiarFormularioParaNuevoContrato() {
        this.contratoActual = null;
        this.clienteSeleccionado = null;
        this.espacioAsignado = null;
        this.serviciosTemporales.clear();

        txtIdentificacion.setText("");
        txtNombreCliente.setText("");
        lblNumeroContrato.setText("N° contrato");
        lblEstadoValor.setText("Pendiente");
        lblEspacioAsignado.setText("Espacio Asignado");
        lblEspacio.setText("Espacio");
        lblServicio.setText("Servicio");
        lblSubtotal.setText("Subtotal");
        lblTotal.setText("Total");

        DefaultTableModel modelo = (DefaultTableModel) tblServicioContrato.getModel();
        modelo.setRowCount(0);

        btnCrearContrato.setEnabled(true);
        actualizarEstadoBotones();
        actualizarDisponibilidadEspacios();
    }
}