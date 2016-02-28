package com.example.cameron.foursquaretest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.example.cameron.foursquaretest.R;
import com.example.cameron.foursquaretest.View.Description;

import java.util.List;
import java.util.Map;

/**
 * Created by Cameron on 28/02/2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.TrendViewHolder> {

    List<Map> trendlist;

    Context context;
    int loaderimg;
    private RequestQueue requestQueue;

    public MyAdapter(List dv, Context c)
    {
        trendlist =dv;
        context=c;
        Log.d("list in adapter", trendlist.toString());
    }

    public class TrendViewHolder extends RecyclerView.ViewHolder {

        FrameLayout frameLayout ;
        TextView tvName, tvRestaurant , tvDesc, tvloc;
        ImageView imgmain;
        TrendViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.name);
            tvRestaurant = (TextView) itemView.findViewById(R.id.restaurants);
            tvDesc = (TextView) itemView.findViewById(R.id.description);
            tvloc = (TextView) itemView.findViewById(R.id.loc);
            imgmain = (ImageView) itemView.findViewById(R.id.imageViewmain);
            frameLayout = (FrameLayout) itemView.findViewById(R.id.framemain);

        }
    }

    @Override
    public TrendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        TrendViewHolder cvh = new TrendViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(final TrendViewHolder holder, final int position) {

        final String name = trendlist.get(position).get("name").toString();
        final String restaurant = trendlist.get(position).get("restaurant").toString();
        final String location = trendlist.get(position).get("location").toString();

        holder.tvName.setText(name);
        holder.tvRestaurant.setText(restaurant);
        holder.tvloc.setText(location);

        holder.frameLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context , Description.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return trendlist.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
