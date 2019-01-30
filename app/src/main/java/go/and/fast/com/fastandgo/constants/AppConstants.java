package go.and.fast.com.fastandgo.constants;

import java.util.ArrayList;
import java.util.Arrays;

import go.and.fast.com.fastandgo.R;

/**
 * Created by Jay Paul on 30 Jan 2019.
 */

public final class AppConstants {

    private AppConstants() {
        // prevent instantiation
    }

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
    public static final ArrayList<String> FOOD_FILTERS = new ArrayList<>(Arrays.asList("Restaurants","Fast Food Chains","Buffet","Food Courts","Cafeteria"));
    public static final ArrayList<String> FOOD_CHOICES = new ArrayList<>(Arrays.asList("Jollibee","Mc Donalds","Mang Inasal","Chowking"));
    public static final ArrayList<Integer> FOOD_IMAGES = new ArrayList<>(Arrays.asList(R.drawable.jollibee_logo, R.drawable.mcdonaldlogo, R.drawable.manginasallogo, R.drawable.chowkinglogo));
    public static final ArrayList<Integer> FOOD_RATINGS = new ArrayList<>(Arrays.asList(3, 4, 5, 4));

    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> SHOPPING_FILTERS = new ArrayList<>(Arrays.asList("Clothing","Shoes","Jeans","Caps","Swim wears"));
    public static final ArrayList<String> SHOPPING_CHOICES = new ArrayList<>(Arrays.asList("Uniqlo","Bench","Folded & Hung","Tribal"));
    public static final ArrayList<Integer> SHOPPING_IMAGES = new ArrayList<>(Arrays.asList(R.drawable.uniqlo_logo, R.drawable.bench_logo, R.drawable.folded_hung_logo, R.drawable.tribal_logo));
    public static final ArrayList<Integer> SHOPPING_RATINGS = new ArrayList<>(Arrays.asList(3, 4, 5, 4));

    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> TRANSPO_FILTERS = new ArrayList<>(Arrays.asList("Buses","Trains","Ships","Airplanes","Taxis"));
    public static final ArrayList<String> TRANSPO_CHOICES = new ArrayList<>(Arrays.asList("Jac Liner","Solid North","Five Star Bus Co.","Victory Liner"));
    public static final ArrayList<Integer> TRANSPO_IMAGES = new ArrayList<>(Arrays.asList(R.drawable.jac_liner_logo, R.drawable.solid_north_logo, R.drawable.fivestart_liner_logo, R.drawable.victory_liner_logo));
    public static final ArrayList<Integer> TRANSPO_RATINGS = new ArrayList<>(Arrays.asList(3, 4, 5, 4));

    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> BILLS_FILTERS = new ArrayList<>(Arrays.asList("Network bills","Electricity bills","Water Bills","NBI clearance"));
    public static final ArrayList<String> BILLS_CHOICES = new ArrayList<>(Arrays.asList("Smart Telecom","Globe Telecom","PLDT","Converge"));
    public static final ArrayList<Integer> BILLS_IMAGES = new ArrayList<>(Arrays.asList(R.drawable.smart_logo, R.drawable.globe, R.drawable.pldt_logo, R.drawable.converge_logo));
    public static final ArrayList<Integer> BILLS_RATINGS = new ArrayList<>(Arrays.asList(3, 4, 5, 4));

    // make static data for now
    // TODO change to dynamic data if the app is already released
    public static final ArrayList<String> PHARMA_FILTERS = new ArrayList<>(Arrays.asList("Medicine","Vitamins","Beauty Products","Hospital Equipments"));
    public static final ArrayList<String> PHARMA_CHOICES = new ArrayList<>(Arrays.asList("Watsons","Mercury Drug","The Generics Pharmacy"));
    public static final ArrayList<Integer> PHARMA_IMAGES = new ArrayList<>(Arrays.asList(R.drawable.watsons_logo, R.drawable.mercury_drug_logo, R.drawable.tgp_logo));
    public static final ArrayList<Integer> PHARMA_RATINGS = new ArrayList<>(Arrays.asList(3, 4, 5, 4));
}
