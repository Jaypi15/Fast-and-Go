package go.and.fast.com.fastandgo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import go.and.fast.com.fastandgo.R;

/**
 * Created by Jay Paul on 30 Jan 2019.
 */

public class ServiceFilterListAdapter extends RecyclerView.Adapter<ServiceFilterListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> filterTxt;

    public ServiceFilterListAdapter(Context context, ArrayList<String> filterTxt) {
        this.context = context;
        this.filterTxt = filterTxt;
    }

//    @Override
//    public int getCount() {
//        return filterTxt.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.service_menu_filter_list, null);
//        }
//
//        // set text for textView according to the position of the item
//        TextView label = convertView.findViewById(R.id.filterTxt);
//        label.setText(filterTxt.get(position));
//
//        return convertView;
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.service_menu_filter_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvSpecies.setText(filterTxt.get(i));


        viewHolder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                // TODO click action
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterTxt.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public TextView tvSpecies;
        private ItemClickListener clickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            tvSpecies = itemView.findViewById(R.id.filterTxt);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition(), true);
            return true;
        }
    }
}
