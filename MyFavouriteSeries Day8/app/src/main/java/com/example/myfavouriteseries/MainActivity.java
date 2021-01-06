package com.example.myfavouriteseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tb= findViewById(R.id.toolbar);
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("home");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("profile");
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("settings");
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(tb)
                .addDrawerItems(
                        item1,
                        item2,
                        new DividerDrawerItem(),
                        item3
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier()==1)
                        Toast.makeText(MainActivity.this,"you clicked on home",Toast.LENGTH_LONG).show();
                        else if (drawerItem.getIdentifier()==2)
                        Toast.makeText(MainActivity.this, "you clicked on profile", Toast.LENGTH_LONG).show();
                        else
                        Toast.makeText(MainActivity.this, "you clicked on settings",Toast.LENGTH_LONG).show();
                        return false;
                    }
                })
                .build();

        ArrayList<Series> myList= new ArrayList<>();
        myList.add(new Series("Payitaht Abdülhamid", 5, 131,
                4.5, R.drawable.pyitaht_poster,
                "Historical", "2017", "Turkish"));
        myList.add(new Series("Mehmedçik", 2, 33,
                4.5, R.drawable.mehmedcik_poster,
                "Historical", "2018", "Turkish"));
        myList.add(new Series("filinta", 2, 56,
                4, R.drawable.filinta_poster,
                "Action", "2014", "Turkish"));

        RecyclerView seriesList= findViewById(R.id.rv);

        seriesList.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);
        seriesList.setLayoutManager(lm);

        SeriesAdapter sv= new SeriesAdapter(myList, MainActivity.this);
        seriesList.setAdapter(sv);


    }
}