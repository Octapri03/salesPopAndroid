package com.ocprva.salespop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ocprva.salespop.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeMenu:

                        break;

                    case R.id.categoriesMenu:
                        // Handle icon 2 click
                        break;

                    case R.id.sellMenu:
                        // Handle
                        break;

                    case R.id.favsMenu:
                    // Handle
                    break;

                    case R.id.userMenu:
                        // Handle
                        break;
                }
                return true;
            }
        });


}
}