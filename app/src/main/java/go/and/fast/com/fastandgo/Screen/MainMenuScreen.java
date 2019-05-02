package go.and.fast.com.fastandgo.Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.adapter.MainMenuListAdapter;
import go.and.fast.com.fastandgo.constants.AppConstants;
import go.and.fast.com.fastandgo.model.entity.Establishment;
import go.and.fast.com.fastandgo.utils.AppUtils;

public class MainMenuScreen extends AppCompatActivity {

    private ListView listView;
    private static final String TAG = "MainMenuScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_screen);
        AppUtils.changeStatusBarColorToPrimaryColorTheme(this);

        createListView();
    }

    private void createListView(){
        listView = findViewById(R.id.choices_list);

        MainMenuListAdapter adapter = new MainMenuListAdapter(getApplicationContext(), AppConstants.MAIN_MENU_CHOICES, AppConstants.MAIN_MENU_IMAGES);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:// foods services
                        Intent foodIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        foodIntent.putExtra("establishmentType", Establishment.FOOD_SERVICE_CODE);
                        foodIntent.putExtra("filters", AppConstants.FOOD_FILTERS);
                        foodIntent.putExtra("description", "Fast Food Restaurant"); // serves as establishment type
                        startActivity(foodIntent);
                        break;
                    case 1:// shopping services
                        Intent shoppingIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        shoppingIntent.putExtra("establishmentType", Establishment.SHOPPING_SERVICE_CODE);
                        shoppingIntent.putExtra("filters", AppConstants.SHOPPING_FILTERS);
                        shoppingIntent.putExtra("description", "Clothing"); // serves as establishment type
                        startActivity(shoppingIntent);
                        break;
                    case 2:// transportation services
                        Intent transpoIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        transpoIntent.putExtra("establishmentType", Establishment.TRANSPORTATION_SERVICE_CODE);
                        transpoIntent.putExtra("filters", AppConstants.TRANSPO_FILTERS);
                        transpoIntent.putExtra("description", "Bus Company"); // serves as establishment type
                        startActivity(transpoIntent);
                        break;
                    case 3:// bills payment services
                        Intent billsIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        billsIntent.putExtra("establishmentType", Establishment.BILLS_PAYMENT_CODE);
                        billsIntent.putExtra("filters", AppConstants.BILLS_FILTERS);
                        billsIntent.putExtra("description", "Telecommunication"); // serves as establishment type
                        startActivity(billsIntent);
                        break;
                    case 4:// foods services
                        Intent pharmaIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        pharmaIntent.putExtra("establishmentType", Establishment.PHARMACEUTICAL_SERVICE_CODE);
                        pharmaIntent.putExtra("filters", AppConstants.PHARMA_FILTERS);
                        pharmaIntent.putExtra("description", "Pharmacy"); // serves as establishment type
                        startActivity(pharmaIntent);
                        break;
                }
            }
        });
    }
}
