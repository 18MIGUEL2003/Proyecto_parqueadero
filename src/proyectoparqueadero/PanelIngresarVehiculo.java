package proyectoparqueadero;

// Importación de clases de la biblioteca iText para el manejo de PDF
import com.itextpdf.text.Document;              // Representa un documento PDF
import com.itextpdf.text.DocumentException;     // Excepción para errores en documentos PDF
import com.itextpdf.text.Element;               // Representa elementos en un documento PDF
import com.itextpdf.text.Font;                  // Representa fuentes en un documento PDF
import com.itextpdf.text.PageSize;              // Representa el tamaño de un documento PDF
import com.itextpdf.text.Paragraph;              // Representa un párrafo en un documento PDF
import com.itextpdf.text.pdf.PdfWriter;          // Escribe el documento PDF en un archivo

import java.io.File;                            // Representa un archivo o directorio
import java.io.FileNotFoundException;          // Excepción para errores de archivo no encontrado
import java.io.FileOutputStream;                // Utilizado para escribir bytes en un archivo
import java.io.IOException;                     

import java.sql.Connection;                      // Representa una conexión de base de datos
import java.sql.DriverManager;                   // Administra los controladores JDBC
import java.sql.SQLException;                     // Excepción para errores de base de datos
import java.sql.Statement;                        // Ejecuta declaraciones SQL

import java.text.DateFormat;                      // Proporciona formato de fecha
import java.text.SimpleDateFormat;               // Permite formatear fechas según un patrón

import java.util.Calendar;                        // Proporciona métodos para manipular fechas y horas
import java.util.Date;                            // Representa una instantánea específica en el tiempo
import java.util.logging.Level;
import java.util.logging.Logger;                   // Clases relacionadas con el registro (logging)

import javax.swing.JOptionPane;                   // Proporciona funcionalidad de cuadros de diálogo para interacción con el usuario

/**
 * Esta clase representa un panel para ingresar vehículos en un sistema de parqueadero.
 * Extiende la clase javax.swing.JPanel.
 */
public class PanelIngresarVehiculo extends javax.swing.JPanel {
     /**
     * Genera un archivo PDF con la información del vehículo y lo guarda en el directorio "pdf".
     */
    void pdf() {
        // Obtener la ruta de destino del archivo PDF
        String dest = "pdf/cliente " + tfPlaca.getText()+".pdf";
        try {
            // Crear una instancia de Document con tamaño de página A5
            Document document = new Document(PageSize.A5);
            
            // Crear una instancia de PdfWriter para escribir en el archivo PDF
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
            // Abrir el documento para empezar a agregar contenido
            document.open();

            // Crear un párrafo para el título del recibo de parqueadero
            Paragraph para = new Paragraph("Recibo Parqueadero", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
            para.setAlignment(Element.ALIGN_CENTER);
            para.setSpacingAfter(20f);
            // Agregar el párrafo al documento
            document.add(para);

            // Crear párrafos para mostrar los detalles del vehículo y el propietario
            Paragraph para1 = new Paragraph("Placa vehiculo: " + tfPlaca.getText());
            Paragraph para2 = new Paragraph("Nombre del propietario: " + tfPropietario.getText());
            Paragraph para3 = new Paragraph("Hora de ingreso: " + fechaHora);

             // Agregar los párrafos al documento
            document.add(para1);
            document.add(para2);
            document.add(para3);
            // Cerrar el documento
            document.close();
            
            // Mostrar un mensaje de éxito al usuario
            JOptionPane.showMessageDialog(null, "Pdf del vehiculo "+tfPlaca.getText()+" a sido creado");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
    * Limpia los campos de texto del panel.
    */
    void limpiar() {
        tfPlaca.setText("");
        tfPropietario.setText("");

    }
    /**
    * Constructor de la clase PanelIngresarVehiculo.
    * Inicializa los componentes del panel.
    */
    public PanelIngresarVehiculo() {
        initComponents();

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
        jLabel1 = new javax.swing.JLabel();
        tfPlaca = new javax.swing.JTextField();
        tfPropietario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbMoto = new javax.swing.JRadioButton();
        rbAuto = new javax.swing.JRadioButton();
        button1 = new java.awt.Button();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Modulo de Ingreso de vehiculos al parqueadero");

        tfPlaca.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N

        tfPropietario.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N

        jLabel2.setText("Placa");

        jLabel3.setText("Nombre propietario");

        jLabel4.setText("Tipo de vehiculo");

        buttonGroup1.add(rbMoto);
        rbMoto.setText("Motocicleta");

        buttonGroup1.add(rbAuto);
        rbAuto.setText("Automovil");

        button1.setBackground(new java.awt.Color(255, 51, 0));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Registrar");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(rbMoto)
                .addGap(10, 10, 10)
                .addComponent(rbAuto)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAuto)
                    .addComponent(rbMoto))
                .addGap(26, 26, 26)
                .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    String fechaHora = "";

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        // Se verifica qué tipo de vehículo está seleccionado (Automóvil o Motocicleta)
        String clasevehiculo = "";
        if (rbAuto.isSelected()) {
            clasevehiculo = "Automovil";
        }
        if (rbMoto.isSelected()) {
            clasevehiculo = "Motocicleta";
        }

        try {
            // Se establece la conexión a la base de datos
            connectar cc = new connectar();
            Connection cn = cc.conexion();

            // Se obtiene la fecha y hora actual
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            fechaHora = dateFormat.format(date);
           
            // Se crea una declaración SQL para insertar los datos del vehículo en la tabla "vehiculos"
            Statement stat = cn.createStatement();
            String sql = "INSERT INTO vehiculos (placa, propietario,tipovehiculo,horaentrada,estado) VALUES ('" + tfPlaca.getText() + "','" + tfPropietario.getText() + "','" + clasevehiculo + "','" + fechaHora + "','Disponible')";
            stat.executeUpdate(sql);
            
             // Se muestra un mensaje de éxito
            JOptionPane.showMessageDialog(null, "El vehiculo se registro exitosamente");
            
             // Se realiza una acción adicional para generar un PDF (el método pdf() debería estar definido en otro lugar del código)
            pdf();
            
            // Se limpian los campos de entrada
            limpiar();

        } catch (SQLException ex) {
             // En caso de error, se registra la excepción en el registro de errores
            Logger.getLogger(PanelIngresarVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton rbAuto;
    private javax.swing.JRadioButton rbMoto;
    private javax.swing.JTextField tfPlaca;
    private javax.swing.JTextField tfPropietario;
    // End of variables declaration//GEN-END:variables
}
