package oscarhmg.com.homeview;

import android.widget.ImageView;

/**
 * Created by user on 12/06/2017.
 */
public class MenuIncidencia {
    private String titleMenu;
    private String date;
    private int tipo;
    private ImageView imageView;

    public MenuIncidencia(String titleMenu, String date, ImageView imageView, int tipo) {
        this.titleMenu = titleMenu;
        this.date = date;
        this.imageView = imageView;
        this.tipo = tipo;
    }

    public String getTitleMenu() {
        return titleMenu;
    }

    public void setTitleMenu(String titleMenu) {
        this.titleMenu = titleMenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
