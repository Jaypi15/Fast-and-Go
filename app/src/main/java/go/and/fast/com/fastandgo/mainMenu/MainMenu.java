package go.and.fast.com.fastandgo.mainMenu;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.mainMenu.foodMenu.FoodScreen;

public class MainMenu extends AppCompatActivity {

    private RelativeLayout foodLayout;
    private TextView foodText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        changeStatusBarColor();

        foodLayout = findViewById(R.id.food_layout);
        foodText = findViewById(R.id.food_text);

        foodLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodMenu = new Intent(MainMenu.this, FoodScreen.class);
                startActivity(foodMenu);
            }
        });

        foodText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent foodMenu = new Intent(MainMenu.this, FoodScreen.class);
                startActivity(foodMenu);
            }
        });
    }

    private void changeStatusBarColor(){
        Window window = this.getWindow();

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
    }

}
