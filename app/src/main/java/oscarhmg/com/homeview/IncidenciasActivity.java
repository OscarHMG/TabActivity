package oscarhmg.com.homeview;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 12/06/2017.
 */
public class IncidenciasActivity extends Activity {
    private ExpandableListView expandableListView;
    private ExpandableMenuIncidenciasAdapter listAdapter;
    private List<MenuIncidencia> menuIncidenciaList;
    private HashMap<MenuIncidencia, List<DetalleIncidencia>> detalleIncidenciaListHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mis_incidencias_activity);
        setToolBar();
        expandableListView = (ExpandableListView)findViewById(R.id.expandableListViewIncidencias);
        initData();
        listAdapter = new ExpandableMenuIncidenciasAdapter(this,menuIncidenciaList,detalleIncidenciaListHashMap );
        expandableListView.setAdapter(listAdapter);
    }

    private void initData() {
        menuIncidenciaList = new ArrayList<>();
        detalleIncidenciaListHashMap = new HashMap<>();


        menuIncidenciaList.add(new MenuIncidencia("Abierta","17/01/2017",null,0));
        menuIncidenciaList.add(new MenuIncidencia("En Proceso","07/05/2017",null,1));
        menuIncidenciaList.add(new MenuIncidencia("Resuelta","17/06/2017",null,2));

        List<DetalleIncidencia> detalles1 = new ArrayList<>();
        DetalleIncidencia detalleIncidencia = new DetalleIncidencia("Numero","#1231231");
        DetalleIncidencia detalleIncidencia1 = new DetalleIncidencia("Linea","+593980408714");
        DetalleIncidencia detalleIncidencia2 = new DetalleIncidencia("Tipo de problema","Cambio de Sim Card");
        DetalleIncidencia detalleIncidencia3 = new DetalleIncidencia("Solucion Estimada","17/02/2017");
        detalles1.add(detalleIncidencia);
        detalles1.add(detalleIncidencia1);
        detalles1.add(detalleIncidencia2);
        detalles1.add(detalleIncidencia3);

        List<DetalleIncidencia> detalles2 = new ArrayList<>();
        DetalleIncidencia d = new DetalleIncidencia("Numero","#9098657");
        DetalleIncidencia d1 = new DetalleIncidencia("Linea","+593980123414");
        DetalleIncidencia d2 = new DetalleIncidencia("Tipo de problema","Dano de celular");
        DetalleIncidencia d3 = new DetalleIncidencia("Solucion Estimada","17/02/2017");
        detalles2.add(d);
        detalles2.add(d1);
        detalles2.add(d2);
        detalles2.add(d3);


        List<DetalleIncidencia> detalles3 = new ArrayList<>();
        DetalleIncidencia x = new DetalleIncidencia("Numero","#1231231");
        DetalleIncidencia x1 = new DetalleIncidencia("Linea","+593980400987");
        DetalleIncidencia x2 = new DetalleIncidencia("Tipo de problema","Cambio de operadora");
        DetalleIncidencia x3 = new DetalleIncidencia("Solucion Estimada","17/02/2017");
        detalles3.add(x);
        detalles3.add(x1);
        detalles3.add(x2);
        detalles3.add(x3);

        detalleIncidenciaListHashMap.put(menuIncidenciaList.get(0), detalles1);
        detalleIncidenciaListHashMap.put(menuIncidenciaList.get(1),detalles2);
        detalleIncidenciaListHashMap.put(menuIncidenciaList.get(2),detalles3);

    }


    public void setToolBar(){
        Toolbar toolbar =  (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Mis Incidencias");
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back); // your drawable
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });
    }

}
