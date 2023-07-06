package proyectoparqueadero;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class PanelListarVehiculos extends javax.swing.JPanel {

    DefaultTableModel model;

    void cargar() {
        String tipoVehiculo = "", estado = "";

        if (cbAuto.isSelected()) {
            tipoVehiculo = "Automovil";
        } else if (cbMoto.isSelected()) {
            tipoVehiculo = "Motocicleta";

        }
        if (rbFueraParq.isSelected()) {
            estado = "No Disponible";
        }
        if (rbEnParq.isSelected()) {
            estado = "Disponible";
        }

        try {
            connectar cc = new connectar();
            Connection cn = cc.conexion();
            String[] titulos = {"ID", "PLACA", "PROPIETARIO", "TIPO", "HORA ENTRADA", "HORA SALIDA", "ESTADO", "VALOR PAGADO"};

            String[] registros = new String[8];
            String sql = "SELECT * FROM vehiculos WHERE estado='" + estado + "' AND tipovehiculo ='" + tipoVehiculo + "' AND placa LIKE '%" + tfPlaca.getText() + "%' AND propietario LIKE '%" + tfPropietario.getText() + "%'";

            model = new DefaultTableModel(null, titulos);

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Agregar los resultados al modelo de la tabla
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("placa");
                registros[2] = rs.getString("propietario");
                registros[3] = rs.getString("tipovehiculo");
                registros[4] = rs.getString("horaentrada");
                String horasalida = rs.getString("horasalida");
                String pago = "";
                if (horasalida == null) {
                    horasalida = "No ha salido";
                    pago = "0";
                } else {
                    horasalida = rs.getString("horasalida");
                    pago = rs.getString("valorpagado");

                }
                registros[5] = horasalida;
                registros[6] = rs.getString("estado");
                registros[7] = pago;

                model.addRow(registros);
            }

            tblVehiculos.setModel(model);

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
            e.printStackTrace(); // Agrega esta línea para imprimir el seguimiento de la pila de errores
        }
    }

    
     void cargar2() {
     

        try {
            connectar cc = new connectar();
            Connection cn = cc.conexion();
            String[] titulos = {"ID", "PLACA", "PROPIETARIO", "TIPO", "HORA ENTRADA", "HORA SALIDA", "ESTADO", "VALOR PAGADO"};

            String[] registros = new String[8];
            String sql = "SELECT * FROM vehiculos";

            model = new DefaultTableModel(null, titulos);

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Agregar los resultados al modelo de la tabla
            while (rs.next()) {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("placa");
                registros[2] = rs.getString("propietario");
                registros[3] = rs.getString("tipovehiculo");
                registros[4] = rs.getString("horaentrada");
                String horasalida = rs.getString("horasalida");
                String pago = "";
                if (horasalida == null) {
                    horasalida = "No ha salido";
                    pago = "0";
                } else {
                    horasalida = rs.getString("horasalida");
                    pago = rs.getString("valorpagado");

                }
                registros[5] = horasalida;
                registros[6] = rs.getString("estado");
                registros[7] = pago;

                model.addRow(registros);
            }

            tblVehiculos.setModel(model);

            rs.close();
            st.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión con la base de datos");
            e.printStackTrace(); // Agrega esta línea para imprimir el seguimiento de la pila de errores
        }
    }
     
    public PanelListarVehiculos() {
        initComponents();
        rbEnParq.setSelected(true);
        cargar2();
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        btlimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfPlaca = new javax.swing.JTextField();
        tfPropietario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        rbEnParq = new javax.swing.JRadioButton();
        rbFueraParq = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cbAuto = new javax.swing.JCheckBox();
        cbMoto = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        btlimpiar.setText("Limpiar");
        btlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlimpiarActionPerformed(evt);
            }
        });
        add(btlimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jLabel1.setText("Buscar Vehiculos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 10, -1, -1));
        add(tfPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 50, 100, -1));
        add(tfPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 100, -1));

        jLabel2.setText("Placa");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 30, -1, -1));

        jLabel3.setText("Propietario");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, -1, -1));

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVehiculos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 660, 168));

        jLabel5.setText("Tipo Vehiculo");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 81, -1, -1));

        buttonGroup3.add(rbEnParq);
        rbEnParq.setText("En parqueadero");
        add(rbEnParq, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 97, -1, -1));

        buttonGroup3.add(rbFueraParq);
        rbFueraParq.setText("Fuera de parqueadero");
        rbFueraParq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFueraParqActionPerformed(evt);
            }
        });
        add(rbFueraParq, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 97, -1, -1));

        jLabel6.setText("Ubicacion del vehiculo");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 81, -1, -1));

        cbAuto.setText("Automovil");
        cbAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAutoActionPerformed(evt);
            }
        });
        add(cbAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 97, -1, -1));

        cbMoto.setText("Motocicleta");
        cbMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMotoActionPerformed(evt);
            }
        });
        add(cbMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 97, -1, -1));

        jButton3.setText("Reporte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    private void rbFueraParqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFueraParqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFueraParqActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        cargar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlimpiarActionPerformed
        // Supongamos que tienes un JDateChooser llamado dateChooser

        tfPlaca.setText("");
        tfPropietario.setText("");
        // Supongamos que tienes un JCheckBox llamado checkBox
        cbAuto.setSelected(false);
        cbMoto.setSelected(false);
        cargar2();


    }//GEN-LAST:event_btlimpiarActionPerformed

    private void cbAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAutoActionPerformed
        cbMoto.setSelected(false);
    }//GEN-LAST:event_cbAutoActionPerformed

    private void cbMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMotoActionPerformed
        cbAuto.setSelected(false);
    }//GEN-LAST:event_cbMotoActionPerformed

    private void tblVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVehiculosMouseClicked
        int selectedRow = tblVehiculos.getSelectedRow();
        if (selectedRow != -1) {
            Object value2 = tblVehiculos.getValueAt(selectedRow, 1);
            tfPlaca.setText(value2.toString());
            // ...
        }
    }//GEN-LAST:event_tblVehiculosMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = tblVehiculos.getSelectedRow();
        if (selectedRow != -1) {
            int columnCount = tblVehiculos.getColumnCount();
            Object[] rowData = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                rowData[i] = tblVehiculos.getValueAt(selectedRow, i);
            }

            String dest = "pdf/cliente " + tfPlaca.getText() + "-reporte.pdf";
            try {
                Document document = new Document(PageSize.A5);
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
                document.open();

                Paragraph para = new Paragraph("Recibo Parqueadero", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
                para.setAlignment(Element.ALIGN_CENTER);
                para.setSpacingAfter(20f);
                document.add(para);

                Paragraph para0 = new Paragraph("ID vehiculo: " + rowData[0]);
                Paragraph para1 = new Paragraph("Placa vehiculo: " + rowData[1]);
                Paragraph para2 = new Paragraph("Tipo vehiculo: " + rowData[3]);
                Paragraph para3 = new Paragraph("Nombre del propietario: " + rowData[2]);
                Paragraph para4 = new Paragraph("Hora de ingreso: " + rowData[4]);
                Paragraph para5 = new Paragraph("Hora de salida: " + rowData[5]);
                Paragraph para6 = new Paragraph("Estado: " + rowData[6]);
                Paragraph para7 = new Paragraph("Valor pagado: " + rowData[7]);

                document.add(para0);
                document.add(para1);
                document.add(para2);
                document.add(para3);
                document.add(para4);
                document.add(para5);
                document.add(para6);
                document.add(para7);

                document.close();
                JOptionPane.showMessageDialog(null, "Reporte del vehiculo " + tfPlaca.getText() + " a sido creado");

                if (Desktop.isDesktopSupported()) {
                    try {
                        File pdfFile = new File(dest);
                        Desktop.getDesktop().open(pdfFile);
                    } catch (IOException ex) {
                        // Manejar cualquier excepción de apertura del archivo
                        ex.printStackTrace();
                    }
                }
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBox cbAuto;
    private javax.swing.JCheckBox cbMoto;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbEnParq;
    private javax.swing.JRadioButton rbFueraParq;
    private javax.swing.JTable tblVehiculos;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfPropietario;
    // End of variables declaration//GEN-END:variables
}
