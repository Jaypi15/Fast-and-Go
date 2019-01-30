package go.and.fast.com.fastandgo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.willy.ratingbar.ScaleRatingBar;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import go.and.fast.com.fastandgo.R;

/**
 * Created by Jay Paul on 30 Jan 2019.
 */

public class ServiceMenuListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> choices;
    private ArrayList<Integer> images;
    private ArrayList<Integer> ratings;
    private String description;

    public ServiceMenuListAdapter(Context context, ArrayList<String> choices, ArrayList<Integer> images, ArrayList<Integer> ratings, String description) {
        this.choices = choices;
        this.images = images;
        this.context = context;
        this.ratings = ratings;
        this.description = description;
    }

    @Override
    public int getCount() {
        return choices.size();
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
        logo.setImageResource(images.get(position));

        // set text for textView according to the position of the item
        TextView label = convertView.findViewById(R.id.establishmentNameTxt);
        label.setText(choices.get(position));

        // set scale rating according to position
        ScaleRatingBar scaleRatingBar = convertView.findViewById(R.id.ratingBar);
        scaleRatingBar.setRating(ratings.get(position));
        scaleRatingBar.setClickable(false);

        // set description
        TextView descriptionTxt = convertView.findViewById(R.id.descriptionTxt);
        descriptionTxt.setText(description);

        return convertView;
    }
}
