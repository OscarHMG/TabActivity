package oscarhmg.com.homeview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 11/06/2017.
 */
public class ExpandableMenuAdapter extends BaseExpandableListAdapter{
    private final static int OPTION_DATOS = 0;
    private final static int OPTION_MINUTOS = 1;
    private final static int OPTION_SMS = 2;

    private Context context;
    private List<String> listDataHeaders;
    private HashMap<String, List<String>> listHashMap;
    private Handler handler = new Handler();
    private int pStatus;

    private LinearLayout infoAccount;

    private ExpandableListView listView;


    public ExpandableMenuAdapter(Context context, List<String> listDataHeaders, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeaders = listDataHeaders;
        this.listHashMap = listHashMap;
    }


    public ExpandableMenuAdapter(Context context, List<String> listDataHeaders, HashMap<String, List<String>> listHashMap, ExpandableListView listView) {
        this.context = context;
        this.listDataHeaders = listDataHeaders;
        this.listHashMap = listHashMap;
        this.listView = listView;

    }

    @Override
    public int getGroupCount() {
        return listDataHeaders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listHashMap.get(listDataHeaders.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeaders.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(listDataHeaders.get(groupPosition)).get(childPosition);
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

    ///////////////////////////////// Here create the view //////////////////////////////////////////////
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String)getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_menu_group,null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.labelListHeader);
        TextView infoAccount = (TextView) convertView.findViewById(R.id.infoAccount);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        if(groupPosition == OPTION_DATOS){
            infoAccount.setText("1 GB");
        }else if(groupPosition == OPTION_MINUTOS){
            infoAccount.setText("114 minutos");
        }else if(groupPosition == OPTION_SMS){
            infoAccount.setText("35 SMS");
        }


        return convertView;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.datos_informacion, null);
        }
        TextView txt = (TextView) convertView.findViewById(R.id.txtProgress);
        Button btn = (Button) convertView.findViewById(R.id.btnAction);
        ProgressBar progressBar = (ProgressBar )convertView.findViewById(R.id.progressBarData);
        ObjectAnimator animation = null;
        if (groupPosition == OPTION_DATOS && childPosition == 0) {
            txt.setText("1 GB");
            btn.setText("Quiero mas Datos");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Quiero mas Datos", Toast.LENGTH_SHORT).show();
                }
            });
            progressBar.setProgress(40);
            animation = ObjectAnimator.ofInt (progressBar, "progress", 0, 40); // see this max value coming back here, we animale towards that value
        } else if (groupPosition == OPTION_MINUTOS && childPosition == 0) {
            txt.setText("114 MIN");
            btn.setText("Quiero mas minutos");
            progressBar.setProgress(70);
            animation = ObjectAnimator.ofInt (progressBar, "progress", 0, 70);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Quiero mas minutos", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (groupPosition == OPTION_SMS && childPosition == 0) {
            txt.setText("35 SMS");
            btn.setText("Quiero mas SMS");
            progressBar.setProgress(10);
            animation = ObjectAnimator.ofInt (progressBar, "progress", 0, 10);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Quiero mas SMS", Toast.LENGTH_SHORT).show();
                }
            });
        }
        animation.setDuration (5000); //in milliseconds
        animation.setInterpolator (new DecelerateInterpolator());
        animation.start ();


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void setTotalData(View view){
        final TextView txtProgress = (TextView) view.findViewById(R.id.txtProgress);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        //progressBar.setProgress(15);
        //txtProgress.setText("15 %");
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while (cont <= pStatus) {
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
                    cont++;
                }
            }
        }).start();*/
    }




}
