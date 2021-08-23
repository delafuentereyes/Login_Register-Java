//para reportes
package logica;

import clases.datos3;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class reportes {
    
    String nombreExamen, fecha;
    
    ArrayList<datos3> tarea;
    
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo, ubicacion, codigopostal;

    public reportes(String nombreExamen, String fecha, ArrayList<datos3> tarea){
        this.nombreExamen = nombreExamen;
        this.fecha = fecha;
        this.tarea = tarea;
        
        
        documento = new Document();
        titulo = new Paragraph("REPORTE DE TAREAS");
        ubicacion = new Paragraph("San José, Puriscal, Santiago");
        codigopostal = new Paragraph("Código Postal 10401");
    }
    public reportes(){
        
    }
    public void crear(){
        try {
            archivo = new FileOutputStream(nombreExamen + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            
            documento.open();
            
            titulo.setAlignment(Element.ALIGN_LEFT);
            documento.add(Chunk.NEWLINE);
            ubicacion.setAlignment(Element.ALIGN_LEFT);
            documento.add(Chunk.NEWLINE);
            codigopostal.setAlignment(Element.ALIGN_LEFT);
            documento.add(Chunk.NEWLINE);
            
            documento.add(Chunk.NEWLINE);

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            
            PdfPCell nombre = new PdfPCell(new Phrase("Nombre de la tarea"));
            nombre.setBackgroundColor(BaseColor.CYAN);
            PdfPCell encargado = new PdfPCell(new Phrase("Encargado"));
            encargado.setBackgroundColor(BaseColor.CYAN);
            PdfPCell fechat = new PdfPCell(new Phrase("Fecha de la tarea"));
            fechat.setBackgroundColor(BaseColor.CYAN);
            PdfPCell estado = new PdfPCell(new Phrase("Estado"));
            estado.setBackgroundColor(BaseColor.CYAN);
            
            tabla.addCell(nombre);
            tabla.addCell(encargado);
            tabla.addCell(fechat);
            tabla.addCell(estado);
            
            for (datos3 producto1 : tarea) {
                tabla.addCell(producto1.getNomTarea());
                tabla.addCell(producto1.getNomEncargado());
                tabla.addCell(producto1.getFechaTarea());
                tabla.addCell(producto1.getEstadoTarea());
            }
            documento.add(titulo);
            documento.add(ubicacion);
            documento.add(codigopostal);
            documento.add(Chunk.NEWLINE);
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            
            
            documento.close();
            JOptionPane.showMessageDialog(null,"El reporte se creó correctamente", "Reporte", JOptionPane.INFORMATION_MESSAGE);
        
        } catch (Exception e) {
        }
        
    }
}
