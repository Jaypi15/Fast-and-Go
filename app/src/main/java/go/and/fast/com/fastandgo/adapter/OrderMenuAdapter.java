package go.and.fast.com.fastandgo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.model.entity.Filter;
import go.and.fast.com.fastandgo.model.entity.Product;

/**
 * Created by Jay Paul on 9 Feb 2019.
 */

public class OrderMenuAdapter extends BaseAdapter {

    private Context context;
    private static List<Product> products;
    private static List<Filter> filters;

    public OrderMenuAdapter(Context context, List<Filter> filters, List<Product> products) {
        this.context = context;
        this.products = products;
        this.filters = filters;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.product_list, null);
        }

        // set text for textView according to the position of the item
        TextView productName = convertView.findViewById(R.id.productNameTxt);
        productName.setText(products.get(position).getProductName());

        // set text for textView according to the position of the item
        TextView productPrice = convertView.findViewById(R.id.priceTxt);
        DecimalFormat priceFormat = new DecimalFormat("#.00");
        productPrice.setText(priceFormat.format(products.get(position).getPrice()));



        ImageView productImage = convertView.findViewById(R.id.productImage);

        if (products.get(position).getProductImage() == null) {
            productImage.setBackground(ContextCompat.getDrawable(context, R.drawable.foodplaceholder));
        } else {
            Bitmap bmp = BitmapFactory.decodeByteArray(products.get(position).getProductImage(), 0, products.get(position).getProductImage().length);
            productImage.setImageBitmap(Bitmap.createScaledBitmap(bmp, bmp.getWidth(),
                    bmp.getHeight(), false));
        }


        return convertView;
    }


}
