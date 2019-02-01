package go.and.fast.com.fastandgo.Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.adapter.ServiceFilterListAdapter;
import go.and.fast.com.fastandgo.adapter.ServiceMenuListAdapter;
import go.and.fast.com.fastandgo.constants.AppConstants;
import go.and.fast.com.fastandgo.utils.AppUtils;

public class ServiceScreen extends AppCompatActivity {

    private String description;
    private String screenTitle;
    private ArrayList<String> choices, filtrers;
    private ArrayList<Integer> images;
    private ArrayList<Integer> ratings;

    private ListView serviceList;
    private RecyclerView filterList;
    private ImageView backBtn;
    private TextView screenTitleTxt;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_service_screen);

        AppUtils.changeStatusBarColorToPrimaryColorTheme(this);

        getExtras();
        createFilterListView();
        createServiceListView();

        screenTitleTxt = findViewById(R.id.screenTitleTxt);
        screenTitleTxt.setText(screenTitle);

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenuIntent = new Intent(getApplicationContext(), MainMenuScreen.class);
                startActivity(mainMenuIntent);
            }
        });
    }

    private void createServiceListView(){
        serviceList = findViewById(R.id.servicesList);

        ServiceMenuListAdapter adapter = new ServiceMenuListAdapter(getApplicationContext(), choices, images, ratings, description);

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

        mAdapter = new ServiceFilterListAdapter(getApplicationContext(), filtrers);
        filterList.setAdapter(mAdapter);
    }

    private void getExtras(){
        choices = (ArrayList<String>) getIntent().getSerializableExtra("choices");
        images = (ArrayList<Integer>) getIntent().getSerializableExtra("images");
        ratings = (ArrayList<Integer>) getIntent().getSerializableExtra("ratings");
        filtrers = (ArrayList<String>) getIntent().getSerializableExtra("filters");
        description = (String) getIntent().getSerializableExtra("description");
        screenTitle = (String) getIntent().getSerializableExtra("screen title");
    }



}
