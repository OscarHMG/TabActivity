package oscarhmg.com.homeview;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 11/06/2017.
 */
public class ConsumosActivity extends Activity {
    private ExpandableListView listView;
    private ExpandableMenuAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHashMap;

    //Views
    private TextView txtProgress;
    private ProgressBar progressBar;
    private int pStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumos_activity);
        listView = (ExpandableListView) findViewById(R.id.expandableListView);
        initData();
        listAdapter = new ExpandableMenuAdapter(this, listDataHeader,listHashMap,listView);
        listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
        listView.expandGroup(0);

        /*listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                LinearLayout data = (LinearLayout) v.findViewById(R.id.containerData);
                data.setVisibility(View.GONE);
                return true;
            }
        });*/




    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("DATOS");
        listDataHeader.add("MINUTOS");
        listDataHeader.add("SMS");

        List<String> oscar = new ArrayList<>();
        oscar.add("This is expandable Menu");


        List<String> tmp = new ArrayList<>();
        tmp.add("1");



        List<String> tmp1 = new ArrayList<>();
        tmp1.add("a");


        listHashMap.put(listDataHeader.get(0), oscar);
        listHashMap.put(listDataHeader.get(1),tmp);
        listHashMap.put(listDataHeader.get(2),tmp1);
    }

    public void setTotalData(){
        txtProgress = (TextView) findViewById(R.id.txtProgress);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (pStatus <= 100) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(pStatus);
                            txtProgress.setText(pStatus + " %");
                        }
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pStatus++;
                }
            }
        }).start();
    }
}
