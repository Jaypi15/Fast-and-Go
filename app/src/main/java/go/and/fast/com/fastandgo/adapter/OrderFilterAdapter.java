package go.and.fast.com.fastandgo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import go.and.fast.com.fastandgo.R;
import go.and.fast.com.fastandgo.model.entity.Filter;

/**
 * Created by Jay Paul on 9 Feb 2019.
 */

public class OrderFilterAdapter extends RecyclerView.Adapter<OrderFilterAdapter.ViewHolder> {

    private Context context;
    private List<Filter> filterTxt;

    public OrderFilterAdapter(Context context, List<Filter> filterTxt) {
        this.context = context;
        this.filterTxt = filterTxt;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.order_filter_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvSpecies.setText(filterTxt.get(i).getFilterDescription());


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
            tvSpecies = itemView.findViewById(R.id.orderFilterTxt);
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