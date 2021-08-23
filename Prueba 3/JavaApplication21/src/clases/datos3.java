//Datos de los reportes
package clases;


public class datos3 {
    
    private String nomTarea, nomEncargado, fechaTarea, estadoTarea;

    public datos3(String nomTarea, String nomEncargado, String fechaTarea, String estadoTarea) {
        
        this.nomTarea = nomTarea;
        this.nomEncargado = nomEncargado;
        this.fechaTarea = fechaTarea;
        this.estadoTarea = estadoTarea;
    }

    
    public datos3(){
        
    }
    public String getNomTarea() {
        return nomTarea;
    }

    public void setNomTarea(String nomTarea) {
        this.nomTarea = nomTarea;
    }

    public String getNomEncargado() {
        return nomEncargado;
    }

    public void setNomEncargado(String nomEncargado) {
        this.nomEncargado = nomEncargado;
    }

    public String getFechaTarea() {
        return fechaTarea;
    }

    public void setFechaTarea(String fechaTarea) {
        this.fechaTarea = fechaTarea;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }
}
