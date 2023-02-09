package com.ocprva.salespop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ocprva.salespop.R;
import com.ocprva.salespop.adapters.ProductListener;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.fragments.CategoriesFragment;
import com.ocprva.salespop.fragments.FavsFragment;
import com.ocprva.salespop.fragments.HomeFragment;
import com.ocprva.salespop.fragments.SellFragment;
import com.ocprva.salespop.fragments.UserFragment;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity implements ProductListener {

    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        homeFragment = new HomeFragment();

        homeFragment.setProductosListener(this);

        loadFragment(homeFragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeMenu:
                        loadFragment(homeFragment);
                        break;

                    case R.id.categoriesMenu:
                        loadFragment(new CategoriesFragment());
                        break;

                    case R.id.sellMenu:
                        loadFragment(new SellFragment());
                        break;

                    case R.id.favsMenu:
                        loadFragment(new FavsFragment());
                        break;

                    case R.id.userMenu:
                        loadFragment(new UserFragment());
                        break;
                }
                return true;
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onProductoSeleccionada(Producto p) {
        Intent i = new Intent(this, DetailProductActivity.class);
        i.putExtra("producto", p);
        startActivity(i);
    }
}