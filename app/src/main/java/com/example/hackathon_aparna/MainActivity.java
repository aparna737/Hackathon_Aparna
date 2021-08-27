package com.example.hackathon_aparna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewpager;
    private ViewPagerAdapter mAdapter;
    private ArrayList<ViewPagerModel> mContents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mContents = new ArrayList<>();
        int images[] = {R.drawable.okk, R.drawable.alaipayuthey,R.drawable.mounaragam };
        String names[] = {"OK Kanmani", "Alaipayuthey", "Mouna Raagam"};
        String genre[] = {"Romance", "Romantic Drama", "Romantic Drama"};
        String imdb[] = {"7.4", "8.3", "8.4"};
        String plot[] = {"O Kadhal Kanmani , also known as OK Kanmani, is a 2015 Indian Tamil-language romance film written, directed and produced by Mani Ratnam.The film stars Dulquer Salmaan and Nithya Menen, portraying a young couple in a live-in relationship in Mumbai."
        , "Alaipayuthey is a 2000 Indian Tamil-language romantic drama film,directed by Mani Ratnam, starring Madhavan and Shalini. The film explores the tensions of married life between two young people who elope and the maturing of love among urban Indians who are conflicted between tradition and modernity.",
        "Mouna Ragam  is a 1986 Indian Tamil-language romantic drama film directed by Mani Ratnam.The film stars Mohan and Revathi, with Karthik. It narrates the life of Divya (Revathi), a free-spirited college girl who is forced into an arranged marriage with Chandrakumar (Mohan) by her father. Divya, secretly mourning her former lover Manohar (Karthik) who was shot dead, did not want to be married."};

        for(int i=0; i<images.length; i++){
            ViewPagerModel viewPagerModel = new ViewPagerModel();
            viewPagerModel.images= images[i];
            viewPagerModel.name = names[i];
            viewPagerModel.genre = genre[i];
            viewPagerModel.plot = plot[i];
            viewPagerModel.imdb = imdb[i];
            mContents.add(viewPagerModel);
        }

        mAdapter = new ViewPagerAdapter(mContents, this);
        mViewpager.setPageTransformer(true, new ViewPagerStack());
        mViewpager.setAdapter(mAdapter);
    }


    private class ViewPagerStack implements ViewPager.PageTransformer {
        @Override
        public void transformPage(@NonNull View page, float position) {
            if(position>= 0){
                page.setScaleX(0.9f-0.05f* position);
                page.setScaleY(0.7f);
                page.setTranslationX(-page.getWidth()*position);
                page.setTranslationY(-30*position);
            }
        }
    }
}