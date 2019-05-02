package go.and.fast.com.fastandgo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.willy.ratingbar.ScaleRatingBar;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.model.entity.Establishment;

/**
 * Created by Jay Paul on 30 Jan 2019.
 */

public class ServiceMenuListAdapter extends BaseAdapter {

    private Context context;
    private List<Establishment> establishments;
    private String description;

    public ServiceMenuListAdapter(Context context, List<Establishment> establishments, String description) {
        this.context = context;
        this.description = description;
        this.establishments = establishments;
    }

    @Override
    public int getCount() {
        return establishments.size();
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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.service_menu_list, null);
        }

        CircleImageView logo = convertView.findViewById(R.id.logo);
        // set image in ImageView according to position of the item
        Bitmap bmp = BitmapFactory.decodeByteArray(establishments.get(position).getLogo(), 0, establishments.get(position).getLogo().length);
        logo.setImageBitmap(Bitmap.createScaledBitmap(bmp, bmp.getWidth(),
                bmp.getHeight(), false));

        // set text for textView according to the position of the item
        TextView label = convertView.findViewById(R.id.establishmentNameTxt);
        label.setText(establishments.get(position).getEstablishmentName());

        // set scale rating according to position
        ScaleRatingBar scaleRatingBar = convertView.findViewById(R.id.ratingBar);
        scaleRatingBar.setRating((float)establishments.get(position).getRating());
        scaleRatingBar.setClickable(false);
        scaleRatingBar.setActivated(false);
        scaleRatingBar.setClickable(false);
        scaleRatingBar.setScrollContainer(false);

        // set description
        TextView descriptionTxt = convertView.findViewById(R.id.descriptionTxt);
        descriptionTxt.setText(description);

        return convertView;
    }
}
