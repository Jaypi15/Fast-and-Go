package go.and.fast.com.fastandgo.Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.adapter.ServiceFilterListAdapter;
import go.and.fast.com.fastandgo.adapter.ServiceMenuListAdapter;
import go.and.fast.com.fastandgo.utils.AppUtils;

public class ServiceScreen extends AppCompatActivity {

    // make static data for now
    // TODO change to dynamic data if the app is already released
    private static final ArrayList<String> FILTERS = new ArrayList<>(Arrays.asList("Restaurants","Fast Food Chains","Buffet","Food Courts","Cafeteria"));
    private static final ArrayList<String> CHOICES = new ArrayList<>(Arrays.asList("Jollibee","Mc Donalds","Mang Inasal","Chowking"));
    private static final ArrayList<Integer> IMAGES = new ArrayList<>(Arrays.asList(R.drawable.jollibee_logo, R.drawable.mcdonaldlogo, R.drawable.manginasallogo, R.drawable.chowkinglogo));
    private static final ArrayList<Integer> RATINGS = new ArrayList<>(Arrays.asList(3, 4, 5, 4));
    private String description = "Fast Food Chain"; // TODO make dymanamic

    private ListView serviceList;
    private RecyclerView filterList;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_service_screen);

        AppUtils.changeStatusBarColorToPrimaryColorTheme(this);

        createFilterListView();
        createServiceListView();
    }

    private void createServiceListView(){
        serviceList = findViewById(R.id.servicesList);

        ServiceMenuListAdapter adapter = new ServiceMenuListAdapter(getApplicationContext(), CHOICES, IMAGES, RATINGS, description);

        serviceList.setAdapter(adapter);

        serviceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent foodIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        startActivity(foodIntent);
                }
            }
        });
    }

    private void createFilterListView() {
        filterList = findViewById(R.id.filterListView);

        // Calling the RecyclerView
        filterList = findViewById(R.id.filterListView);
        filterList.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        filterList.setLayoutManager(mLayoutManager);

        mAdapter = new ServiceFilterListAdapter(getApplicationContext(), FILTERS);
        filterList.setAdapter(mAdapter);
    }

}
