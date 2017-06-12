package oscarhmg.com.homeview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OscarHMG on 12/06/2017.
 */
public class RecargasActivity extends Activity{
    private ListView listview;
    private RecargasAdapter adapter;
    private List<RowConsumosRealizados> realizadosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recargas_activity);
        listview = (ListView) findViewById(R.id.lstConsumosRealizados);
        initData();
        adapter = new RecargasAdapter(this, realizadosList);
        listview.setAdapter(adapter);
        TextView textView = new TextView(this);
        textView.setText("Ultimos consumos realizados");
        listview.addHeaderView(textView);
    }


    public void initData(){
        realizadosList = new ArrayList<>();
        RowConsumosRealizados row1 = new RowConsumosRealizados("Llamada - Voz - Nacional", "04/06/2017 - 11:30:12","$0.17","01m 59s");
        RowConsumosRealizados row2 = new RowConsumosRealizados("SMS - Internacional", "04/03/2017 - 11:30:12","$0.11","1");
        RowConsumosRealizados row3 = new RowConsumosRealizados("Llamada - Voz - Nacional", "23/06/2017 - 11:30:12","$0.03","59s");

        realizadosList.add(row1);
        realizadosList.add(row2);
        realizadosList.add(row3);
    }
}
