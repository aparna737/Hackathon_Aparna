package com.example.hackathon_aparna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private List<ViewPagerModel> contents;
    private Context context;

    public ViewPagerAdapter(List<ViewPagerModel> contents, Context context) {
        this.contents = contents;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contents.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_contents, container, false);
        container.addView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        imageView.setImageResource(contents.get(position).getImages());
        TextView name, genre, imdb, plot;
        name = (TextView) view.findViewById(R.id.name);
        name.setText(contents.get(position).getName());
        genre = (TextView) view.findViewById(R.id.genre);
        genre.setText(contents.get(position).getGenre());
        imdb = (TextView) view.findViewById(R.id.imdb);
        imdb.setText(contents.get(position).getImdb());
        plot = (TextView) view.findViewById(R.id.plot);
        plot.setText(contents.get(position).getPlot());




        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
