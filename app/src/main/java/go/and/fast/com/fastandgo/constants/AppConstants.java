package go.and.fast.com.fastandgo.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import go.and.fast.com.fastandgo.R;

/**
 * Created by Jay Paul on 30 Jan 2019.
 */

public class AppConstants {

    /**
     * NOTE:
     * We do this for prototype demo only,
     * we will use APIs to pass data between
     * the server and app
     */
    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> MAIN_MENU_CHOICES = new ArrayList<>(Arrays.asList("Food Services","Shopping Services","Transportaion Services","Bills Payment Services","Pharmaceutical Services"));
    public static final ArrayList<Integer> MAIN_MENU_IMAGES =new ArrayList<>(Arrays.asList(R.drawable.fastfood, R.drawable.shopping, R.drawable.transportation, R.drawable.billpayment, R.drawable.medicine));

    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> FOOD_FILTERS = new ArrayList<>(Arrays.asList("Fast Food Restaurant","Buffet","Food Courts","Cafeteria"));

    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> SHOPPING_FILTERS = new ArrayList<>(Arrays.asList("Clothing","Shoes","Jeans","Caps","Swim wears"));

    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> TRANSPO_FILTERS = new ArrayList<>(Arrays.asList("Buses","Trains","Ships","Airplanes","Taxis"));

    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> BILLS_FILTERS = new ArrayList<>(Arrays.asList("Network bills","Electricity bills","Water Bills","NBI clearance"));

    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> PHARMA_FILTERS = new ArrayList<>(Arrays.asList("Medicine","Vitamins","Beauty Products","Hospital Equipments"));

    public static final ArrayList<String> JOLLIBEE_FILTERS = new ArrayList<>(Arrays.asList("Burgers","Super Meals","Drinks","Breakfast Meals", "Bucket Meals", "Chicken Joy"));
    public static final ArrayList<String> JOLLIBEE_MENU = new ArrayList<>(Arrays.asList("C1","B2","C3","A3","C2","B1"));
    public static final ArrayList<String> JOLLIBEE_DESCRIPTION = new ArrayList<>(Arrays.asList("1-pc. Chickenjoy (Solo)","1-pc. Chickenjoy with Jolly Spaghetti (Solo)","1-pc. Chickenjoy with Palabok (Solo)","Yum Cheese burger"));
    public static final ArrayList<String> JOLLIBEE_PRICES = new ArrayList<>(Arrays.asList("PHP 100","PHP 110","PHP 120","PHP 45","PHP 100","PHP 120"));
    public static final ArrayList<String> JOLLIBEE_BURGERS = new ArrayList<>(Arrays.asList("Yum Burger (Solo)", "Yum Cheese Burger"));
    private AppConstants() {
        // to prevent instantiation
    }

}
