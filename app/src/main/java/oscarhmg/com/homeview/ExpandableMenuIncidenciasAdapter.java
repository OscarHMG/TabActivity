package oscarhmg.com.homeview;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 12/06/2017.
 */
public class ExpandableMenuIncidenciasAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<MenuIncidencia> menuIncidencias;
    private HashMap<MenuIncidencia,List<DetalleIncidencia>> incidenciaListHashMap;

    private final static int INCIDENCIA_ABIERTA =0;
    private final static int INCIDENCIA_EN_PROCESO =1;
    private final static int INCIDENCIA_RESUELTA =2;


    public ExpandableMenuIncidenciasAdapter(Context context, List<MenuIncidencia> menuIncidencias, HashMap<MenuIncidencia, List<DetalleIncidencia>> incidenciaListHashMap) {
        this.context = context;
        this.menuIncidencias = menuIncidencias;
        this.incidenciaListHashMap = incidenciaListHashMap;
    }

    @Override
    public int getGroupCount() {
        return menuIncidencias.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return incidenciaListHashMap.get(menuIncidencias.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return menuIncidencias.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return incidenciaListHashMap.get(menuIncidencias.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /////////////////////////////////////////Create view of expandable menus ////////////////////////////////////////////////////
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        MenuIncidencia menuIncidencia = (MenuIncidencia)getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_menu_incidencias, null);
        }
        TextView title = (TextView)convertView.findViewById(R.id.menu_title_incidencia);
        TextView fecha = (TextView)convertView.findViewById(R.id.fecha_incidencia);


        if(menuIncidencia.getTipo() == INCIDENCIA_ABIERTA ){
            /*String titleText = "Abierta";
            Spannable spanna = new SpannableString(titleText);
            spanna.setSpan(new BackgroundColorSpan(0xeb008b), 0, titleText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            title.setText(spanna);*/
            setColorInMenu(title, "Abierta", 0xFFEB008B);
            fecha.setText("12/07/2016");
        }else if(menuIncidencia.getTipo()  == INCIDENCIA_EN_PROCESO ){
            /*String titleText = "En Proceso";
            Spannable spanna = new SpannableString(titleText);
            spanna.setSpan(new BackgroundColorSpan(0xFFCCCCCC), 0, titleText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            title.setText(spanna);*/
            setColorInMenu(title, "En Proceso", 0xFFCCCCCC);
            fecha.setText("12/01/2016");
        }else if(menuIncidencia.getTipo()  == INCIDENCIA_RESUELTA){
            /*String titleText = "En Proceso";
            Spannable spanna = new SpannableString(titleText);
            spanna.setSpan(new BackgroundColorSpan(0x5BC500),0, titleText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            title.setText(spanna);*/
            setColorInMenu(title, "Resuelta", 0xFF5BC500);
            fecha.setText("06/06/2016");
        }
        return convertView;
    }

    /////////////////////////////////////////// Creating view of the childs ///////////////////////////////////////////////////
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        DetalleIncidencia detalleIncidencia = (DetalleIncidencia) getChild(groupPosition,childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_incidencias, null);
        }
        TextView title = (TextView) convertView.findViewById(R.id.titulo_incidencia);
        TextView descirption = (TextView) convertView.findViewById(R.id.descripcion_incidencia);
        title.setText(detalleIncidencia.getTitle());
        descirption.setText(detalleIncidencia.getDescriptionIncidencia());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void setColorInMenu(TextView title, String text, int color){
        Spannable spanna = new SpannableString(text);
        spanna.setSpan(new BackgroundColorSpan(color), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        title.setText(spanna);
    }
}
