package go.and.fast.com.fastandgo.Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.adapter.MainMenuListAdapter;
import go.and.fast.com.fastandgo.utils.AppUtils;

public class MainMenuScreen extends AppCompatActivity {

    private ListView listView;

    // make static data for now
    // TODO change to dynamic data if the app is already released
    private static final ArrayList<String> CHOICES = new ArrayList<>(Arrays.asList("Food Services","Shopping Services","Transportaion Services","Bills Payment Services","Pharmaceutical Services"));
    private static final ArrayList<Integer> IMAGES =new ArrayList<>(Arrays.asList(R.drawable.fastfood, R.drawable.shopping, R.drawable.transportation, R.drawable.billpayment, R.drawable.medicine));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_screen);
        AppUtils.changeStatusBarColorToPrimaryColorTheme(this);

        createListView();
    }

    private void createListView(){
        listView = findViewById(R.id.choices_list);

        MainMenuListAdapter adapter = new MainMenuListAdapter(getApplicationContext(), CHOICES, IMAGES);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
}
