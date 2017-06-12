package oscarhmg.com.homeview;

/**
 * Created by user on 12/06/2017.
 */
public class RowConsumosRealizados {
    private String titulo;
    private String fecha;
    private String monto;
    private String descripcionMonto;

    public RowConsumosRealizados(String titulo, String fecha, String monto, String descripcionMonto) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.monto = monto;
        this.descripcionMonto = descripcionMonto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getDescripcionMonto() {
        return descripcionMonto;
    }

    public void setDescripcionMonto(String descripcionMonto) {
        this.descripcionMonto = descripcionMonto;
    }
}
