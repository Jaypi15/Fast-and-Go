package go.and.fast.com.fastandgo.utils;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import go.and.fast.com.fastandgo.R;

/**
 * Created by Jay Paul on 29 Jan 2019.
 */

public final class AppUtils {

    private AppUtils() {
        // to prevent instantiation
    }

    public static void changeStatusBarColorToPrimaryColorTheme(AppCompatActivity context){
        Window appWindow = context.getWindow();

        appWindow.setStatusBarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
    }
}
