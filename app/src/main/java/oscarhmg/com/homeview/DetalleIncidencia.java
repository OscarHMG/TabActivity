package oscarhmg.com.homeview;

/**
 * Created by user on 12/06/2017.
 */
public class DetalleIncidencia {
    private String title;
    private String descriptionIncidencia;

    public DetalleIncidencia(String title, String descriptionIncidencia) {
        this.title = title;
        this.descriptionIncidencia = descriptionIncidencia;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionIncidencia() {
        return descriptionIncidencia;
    }

    public void setDescriptionIncidencia(String descriptionIncidencia) {
        this.descriptionIncidencia = descriptionIncidencia;
    }
}
