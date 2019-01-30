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
import go.and.fast.com.fastandgo.utils.AppUtils;

public class MainMenuScreen extends AppCompatActivity {

    private ListView listView;

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
                        foodIntent.putExtra("choices", AppConstants.FOOD_CHOICES);
                        foodIntent.putExtra("images", AppConstants.FOOD_IMAGES);
                        foodIntent.putExtra("filters", AppConstants.FOOD_FILTERS);
                        foodIntent.putExtra("ratings", AppConstants.FOOD_RATINGS);
                        foodIntent.putExtra("description", "Fast Food Chain");
                        startActivity(foodIntent);
                        break;
                    case 1:// shopping services
                        Intent shoppingIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        shoppingIntent.putExtra("choices", AppConstants.SHOPPING_CHOICES);
                        shoppingIntent.putExtra("images", AppConstants.SHOPPING_IMAGES);
                        shoppingIntent.putExtra("filters", AppConstants.SHOPPING_FILTERS);
                        shoppingIntent.putExtra("ratings", AppConstants.SHOPPING_RATINGS);
                        shoppingIntent.putExtra("description", "Clothing");
                        startActivity(shoppingIntent);
                        break;
                    case 2:// foods services
                        Intent transpoIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        transpoIntent.putExtra("choices", AppConstants.TRANSPO_CHOICES);
                        transpoIntent.putExtra("images", AppConstants.TRANSPO_IMAGES);
                        transpoIntent.putExtra("filters", AppConstants.TRANSPO_FILTERS);
                        transpoIntent.putExtra("ratings", AppConstants.TRANSPO_RATINGS);
                        transpoIntent.putExtra("description", "Bus Company");
                        startActivity(transpoIntent);
                        break;
                    case 3:// foods services
                        Intent billsIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        billsIntent.putExtra("choices", AppConstants.BILLS_CHOICES);
                        billsIntent.putExtra("images", AppConstants.BILLS_IMAGES);
                        billsIntent.putExtra("filters", AppConstants.BILLS_FILTERS);
                        billsIntent.putExtra("ratings", AppConstants.BILLS_RATINGS);
                        billsIntent.putExtra("description", "Network company");
                        startActivity(billsIntent);
                        break;
                    case 4:// foods services
                        Intent pharmaIntent = new Intent(getApplicationContext(), ServiceScreen.class);
                        pharmaIntent.putExtra("choices", AppConstants.PHARMA_CHOICES);
                        pharmaIntent.putExtra("images", AppConstants.PHARMA_IMAGES);
                        pharmaIntent.putExtra("filters", AppConstants.PHARMA_FILTERS);
                        pharmaIntent.putExtra("ratings", AppConstants.PHARMA_RATINGS);
                        pharmaIntent.putExtra("description", "Medicine");
                        startActivity(pharmaIntent);
                        break;
                }
            }
        });
    }
}
