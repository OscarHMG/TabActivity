package oscarhmg.com.homeview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 12/06/2017.
 */
public class RecargasAdapter extends BaseAdapter {
    private Context context;
    private List<RowConsumosRealizados> realizadosList;


    public RecargasAdapter(Context context, List<RowConsumosRealizados> realizadosList) {
        this.context = context;
        this.realizadosList = realizadosList;
    }

    @Override
    public int getCount() {
        return realizadosList.size();
    }

    @Override
    public Object getItem(int position) {
        return realizadosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_consumos, null);
        }
        TextView titulo = (TextView)convertView.findViewById(R.id.titulo);
        TextView descripcionTitulo = (TextView)convertView.findViewById(R.id.descripcion_titulo);
        TextView monto = (TextView)convertView.findViewById(R.id.monto);
        TextView detalleMonto = (TextView)convertView.findViewById(R.id.detalle_monto);
        titulo.setText(realizadosList.get(position).getTitulo());
        descripcionTitulo.setText(realizadosList.get(position).getFecha());
        monto.setText(realizadosList.get(position).getMonto());
        detalleMonto.setText(realizadosList.get(position).getDescripcionMonto());
        return convertView;
    }
}
