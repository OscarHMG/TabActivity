package oscarhmg.com.homeview;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabWidget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/* Tutorial Tabs Activity: http://www.mkyong.com/android/android-tablayout-example/*/
public class MainActivity extends TabActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set Up Spinner
        setUpSpinner();



        /////////////////////////////////////// SECTION TAB//////////////////////////////////

        TabHost tabHost = getTabHost();

        // Consumos Tab
        Intent intentConsumos = new Intent().setClass(this, ConsumosActivity.class);
        TabHost.TabSpec tabConsumos = tabHost.newTabSpec("CONSUMOS").setContent(intentConsumos).setIndicator("CONSUMOS");

        // Facturas tab
        Intent intentFacturas = new Intent().setClass(this, FacturasActivity.class);
        TabHost.TabSpec tabFacturas = tabHost.newTabSpec("FACTURAS").setContent(intentFacturas).setIndicator("FACTURAS");


        // Add all tabs
        tabHost.addTab(tabConsumos);
        tabHost.addTab(tabFacturas);


        //set Consumos tab as default
        tabHost.setCurrentTab(0);

        //Get tabwidget to set disable 1 tab option
        /*TabWidget tabWidget = tabHost.getTabWidget();
        tabWidget.getChildTabViewAt(1).setEnabled(false);*/

    }


    public void setUpSpinner(){
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(null);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("0980402714");
        categories.add("0980443714");
        categories.add("0980467714");
        categories.add("0980908714");
        categories.add("0912347144");
        categories.add("0980123455");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
