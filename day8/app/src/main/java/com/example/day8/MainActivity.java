package com.example.day8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.squareup.picasso.Picasso;

import info.hoang8f.android.segmented.SegmentedGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SegmentedGroup group= findViewById(R.id.segmented2);
        group.setTintColor(Color.parseColor("#FD9A9A"),Color.BLACK);

        LinearLayout l1= findViewById(R.id.ll);

        ImageView im1= findViewById(R.id.im2); ImageView im2= findViewById(R.id.im3);
        ImageView im3= findViewById(R.id.im4); ImageView im4= findViewById(R.id.im5);

        Picasso.with(this).load("https://wallup.net/wp-content/uploads/2015/12/147772-Argentina-landscape-nature-glaciers.jpg")
                .into(im1);
        Picasso.with(this).load("https://3.bp.blogspot.com/-WVVpQBUFo4s/VB9lUYaHXcI/AAAAAAAAAL4/2y-E5ppDFeY/s1600/Incahuasi-Volcano-Argentina%2Benjoy%2Btravel.jpg")
                .into(im2);
        Picasso.with(this).load("https://wallup.net/wp-content/uploads/2016/01/196625-fall-mountain-forest-Patagonia-trees-snowy_peak-Argentina-nature-landscape.jpg")
                .into(im3);
        Picasso.with(this).load("https://66.media.tumblr.com/2ca1dcde154f05e297c95ca91732650d/tumblr_pmeep4XpgS1w01i9ao1_1280.jpg")
                .into(im4);

        Toolbar toolbar= findViewById(R.id.toolbar);
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("home").withIcon(R.drawable.ic_baseline_home_24);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("profile").withIcon(R.drawable.ic_baseline_person_24);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("settings");
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        new DividerDrawerItem(),
                        item3
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        //if (drawerItem.getIdentifier()==1)
                        //Toast.makeText(MainActivity.this,"you clicked on home",Toast.LENGTH_LONG).show();
                        //else if (drawerItem.getIdentifier()==2)
                            //Toast.makeText(MainActivity.this, "you clicked on profile", Toast.LENGTH_LONG).show();
                        //else
                            //Toast.makeText(MainActivity.this, "you clicked on settings",Toast.LENGTH_LONG).show();

                        //snackbar takes its layout as the first argument, message as the 2nd, and LENGTH long ro short as third.
                        //then it sets an action (if exists), and th last thing it does is to show.
                        //declare and initialise the linear layout (have a look at line 31).

                        //Snackbar.make(l1, "Hello user", Snackbar.LENGTH_LONG).show();//example without any action
                            Snackbar.make(l1, "DO YOU MEAN CLICKING ME?!!!😡",Snackbar.LENGTH_LONG)
                                    .setAction("Undo", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Toast.makeText(MainActivity.this,
                                                    "Don't terrify, it is undone", Toast.LENGTH_LONG).show();
                                        }
                                    }).show();
                        return false;
                    }
                })
                .build();


    }
}