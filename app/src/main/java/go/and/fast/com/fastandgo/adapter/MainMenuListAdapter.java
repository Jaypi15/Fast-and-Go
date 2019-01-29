package go.and.fast.com.fastandgo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import go.and.fast.com.fastandgo.R;

/**
 * Created by Jay Paul on 29 Jan 2019.
 */

public class MainMenuListAdapter extends BaseAdapter {

    private ArrayList<String> choices;
    private ArrayList<Integer> images;
    private Context context;

    public MainMenuListAdapter(Context context, ArrayList<String> choices, ArrayList<Integer> images) {
        this.choices = choices;
        this.images = images;
        this.context = context;
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
            convertView = inflater.inflate(R.layout.main_menu_list, null);
        }

        ImageView bgImage = convertView.findViewById(R.id.bgImage);
        // set image in ImageView according to position of the item
        bgImage.setBackgroundResource(images.get(position));

        // set text for textView according to the position of the item
        TextView label = convertView.findViewById(R.id.food_text);
        label.setText(choices.get(position));

        return convertView;
    }
}
