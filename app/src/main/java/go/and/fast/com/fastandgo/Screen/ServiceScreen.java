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
import java.util.List;

import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.adapter.ServiceFilterListAdapter;
import go.and.fast.com.fastandgo.adapter.ServiceMenuListAdapter;
import go.and.fast.com.fastandgo.constants.AppConstants;
import go.and.fast.com.fastandgo.model.entity.Establishment;
import go.and.fast.com.fastandgo.model.repository.EstablishmentRepository;
import go.and.fast.com.fastandgo.utils.AppUtils;

public class ServiceScreen extends AppCompatActivity {

    private String type;
    private ListView serviceList;
    private RecyclerView filterList;
    private ImageView backBtn;
    private TextView screenTitleTxt;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    private String screenTitle;

    private List<Establishment> establishments;
    private EstablishmentRepository establishmentRepository;
    private List<String> filters;
    private String description;

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

        ServiceMenuListAdapter adapter = new ServiceMenuListAdapter(getApplicationContext(), establishments, description);

        serviceList.setAdapter(adapter);

        serviceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                
                Intent orderScreen = new Intent(getApplicationContext(), OrderingScreen.class);
//                orderScreen.putExtra("filterMenus", AppConstants.JOLLIBEE_FILTERS);
//                orderScreen.putExtra("menus", AppConstants.JOLLIBEE_MENU);
//                orderScreen.putExtra("prices", AppConstants.JOLLIBEE_PRICES);
//                orderScreen.putExtra("descripions", AppConstants.JOLLIBEE_DESCRIPTION);

                orderScreen.putExtra("type", type);
                orderScreen.putExtra("positionClicked", position);

                startActivity(orderScreen);
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

        mAdapter = new ServiceFilterListAdapter(getApplicationContext(), filters);
        filterList.setAdapter(mAdapter);
    }

    private void getExtras(){
        description = (String) getIntent().getSerializableExtra("description");
        type = (String) getIntent().getSerializableExtra("establishmentType");
        filters = (List<String>) getIntent().getSerializableExtra("filters");

        if (type != null) {
            establishmentRepository = EstablishmentRepository.getInstance(getApplicationContext());
            establishments = establishmentRepository.getAllEstablishmentsByType(type);
        }

        switch (type) {
            case Establishment.FOOD_SERVICE_CODE:
                screenTitle = Establishment.FOOD_SERVICE_TYPE;
                break;
            case  Establishment.BILLS_PAYMENT_CODE:
                screenTitle = Establishment.BILLS_PAYMENT_TYPE;
                break;
            case Establishment.PHARMACEUTICAL_SERVICE_CODE:
                screenTitle = Establishment.PHARMACEUTICAL_SERVICE_TYPE;
                break;
            case Establishment.SHOPPING_SERVICE_CODE:
                screenTitle = Establishment.SHOPPING_SERVICE_TYPE;
                break;
            case Establishment.TRANSPORTATION_SERVICE_CODE:
                screenTitle = Establishment.TRANSPORTATION_SERVICE_TYPE;
                break;
        }
    }



}
