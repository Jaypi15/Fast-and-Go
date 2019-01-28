package go.and.fast.com.fastandgo.mainMenu.foodMenu;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import go.and.fast.com.fastandgo.R;

public class FoodScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food_screen);

        changeStatusBarColor();
    }

    private void changeStatusBarColor(){
        Window window = this.getWindow();

        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
    }
}
