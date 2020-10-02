package cl.inacap.misconciertos.dto;

public class Evento {
    private String nombreAr;
    private String calendario;
    private String genero;
    private int valor;
    private int calificacion;

    public String getNombreAr() {
        return nombreAr;
    }

    public void setNombreAr(String nombreAr) {
        this.nombreAr = nombreAr;
    }

    public String getCalendario() {
        return calendario;
    }

    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Fecha:" + calendario + " " + "Nombre: " + nombreAr + " " +
                "Valor: " + valor + " " + "Calificado con: " + calificacion;
    }


}
