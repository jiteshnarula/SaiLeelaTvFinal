package com.devicedisk.saileelatv.AboutUs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.devicedisk.saileelatv.R;

public class AboutusActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView textView,whoweareTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        TextView mTitle = (TextView) mToolbar.findViewById(R.id.aboutusTextView);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Gabriola.ttf");
        mTitle.setTypeface(typeface);

        whoweareTextView = (TextView) findViewById(R.id.whoweareTextView);
        whoweareTextView.setText("" +
                "Saileela is India’s first devotional plus entertainment TV channel (#devotainment) purely dedicated to Saibaba (which includes Guru Parampara, Nath Parampara & Gurubhakti) and saibhakti.\n" +
                "\n" +
                "The very purpose of launching this channel is to spread & propagate the teachings and philosophy of Saibaba, which is a need of time being Baba is the symbol of world integration.\n" +
                "\n" +
                "The TV channel aims to redefine the socio spiritual television programs with unique features that combine mythology, history, music, debate and devotion.\n" +
                "\n" +
                "The TV channel will produce & telecast such programs which will explore and discover the history of Sai Darbar.\n" +
                "\n" +
                "The main object of the channel is to spread uncover the baba’s preaching and untold stories, promulgate Saibaba’s philosophy through visual media, which includes daily Darshan of baba.");
        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"fonts/Gabriola.ttf");
        whoweareTextView.setTypeface(typeface1);
    }
}
