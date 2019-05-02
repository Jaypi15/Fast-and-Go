package go.and.fast.com.fastandgo.Screen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.willy.ratingbar.ScaleRatingBar;

import java.util.ArrayList;
import java.util.List;

import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.adapter.OrderFilterAdapter;
import go.and.fast.com.fastandgo.adapter.OrderMenuAdapter;
import go.and.fast.com.fastandgo.model.entity.Establishment;
import go.and.fast.com.fastandgo.model.entity.Filter;
import go.and.fast.com.fastandgo.model.entity.Product;
import go.and.fast.com.fastandgo.model.repository.EstablishmentRepository;
import go.and.fast.com.fastandgo.model.repository.FilterRepository;
import go.and.fast.com.fastandgo.model.repository.ProductRepository;

public class OrderingScreen extends AppCompatActivity {

    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private GridView productList;
    private RecyclerView orderFilterList;
    private String clickedType;
    private int positionClicked;
    private List<Establishment> establishments;
    private List<Filter> filters;
    private List<Product> products;

    private EstablishmentRepository establishmentRepository;
    private FilterRepository filterRepository;
    private ProductRepository productRepository;

    private ImageView establishmentImage;
    private TextView establishmentName;
    private ScaleRatingBar rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_screen);

        extractExtras();
        buildNeededData();
        createFilterListView();
        creatMenuListView();
        createEstablishmentInfoLayout();
    }

    private void createEstablishmentInfoLayout() {
        establishmentImage = findViewById(R.id.establishmentImage);
        establishmentName = findViewById(R.id.establishmentNameTxt);
        rating = findViewById(R.id.ratingBar);

        establishmentName.setText(establishments.get(positionClicked).getEstablishmentName());

        Bitmap bmp = BitmapFactory.decodeByteArray(establishments.get(positionClicked).getLogo(), 0,establishments.get(positionClicked).getLogo().length);
        establishmentImage.setImageBitmap(Bitmap.createScaledBitmap(bmp, bmp.getWidth(),
                bmp.getHeight(), false));

        rating.setRating((float) establishments.get(positionClicked).getRating());
    }

    private void createFilterListView() {

        // Calling the RecyclerView
        orderFilterList = findViewById(R.id.orderingFilterListView);
        orderFilterList.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        orderFilterList.setLayoutManager(mLayoutManager);

        filters = filterRepository.getAllFiltersByEstablishmentId(establishments.get(positionClicked).getEstablishmentId());

        mAdapter = new OrderFilterAdapter(getApplicationContext(), filters);
        orderFilterList.setAdapter(mAdapter);
    }

    private void creatMenuListView() {
        productList = findViewById(R.id.menuListView);

        filters = filterRepository.getAllFiltersByEstablishmentId(establishments.get(positionClicked).getEstablishmentId());
        products = productRepository.getAllProductsByEstablishmentId(establishments.get(positionClicked).getEstablishmentId());

        OrderMenuAdapter orderMenuAdapter = new OrderMenuAdapter(getApplicationContext(), filters, products);
        productList.setAdapter(orderMenuAdapter);

        productList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                changeMainInfoLayout(products, position);
            }

        });
    }

    private void extractExtras() {
//        orderFilters = (ArrayList<String>) getIntent().getSerializableExtra("filterMenus");
//        menus = (ArrayList<String>) getIntent().getSerializableExtra("menus");
//        prices = (ArrayList<String>) getIntent().getSerializableExtra("prices");
//        descriptions = (ArrayList<String>) getIntent().getSerializableExtra("descriptions");
//        productImages = new ArrayList<>();

        clickedType = (String) getIntent().getSerializableExtra("type");
        positionClicked = (Integer) getIntent().getSerializableExtra("positionClicked");
    }

    private void buildNeededData() {
        establishmentRepository = EstablishmentRepository.getInstance(getApplicationContext());
        filterRepository = FilterRepository.getInstance(getApplicationContext());
        productRepository = ProductRepository.getInstance(getApplicationContext());

        establishments = establishmentRepository.getAllEstablishmentsByType(clickedType);
    }

//    private void changeMainInfoLayout(List<Product> products, int position) {
//        // main info layout
//        TextView producNameParent = findViewById(R.id.productName);
//        ImageView productImageParent = findViewById(R.id.productImage);
//        TextView productPriceParent = findViewById(R.id.priceTxt);
//        TextView description = findViewById(R.id.description);
//
//        producNameParent.setText(products.get(position).getProductName());
//        productPriceParent.setText("PHP "+products.get(position).getPrice());
//
//        if (products.get(position).getProductImage() != null) {
//            Bitmap bmp = BitmapFactory.decodeByteArray(products.get(position).getProductImage(), 0, products.get(position).getProductImage().length);
//            productImageParent.setImageBitmap(Bitmap.createScaledBitmap(bmp, bmp.getWidth(),
//                    bmp.getHeight(), false));
//        }
//
//        description.setText(formatDescription(products.get(position).getDescription()));
//    }

    private String formatDescription(String description){
        if (description != null) {
            return  description.replaceAll(",","\n");
        }
        return "";

    }


}
