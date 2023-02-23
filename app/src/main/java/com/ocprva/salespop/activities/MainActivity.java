package com.ocprva.salespop.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ocprva.salespop.R;
import com.ocprva.salespop.adapters.ProductListener;
import com.ocprva.salespop.api.pojo.Product;
import com.ocprva.salespop.api.pojo.Usuario;
import com.ocprva.salespop.fragments.CategoriesFragment;
import com.ocprva.salespop.fragments.FavsFragment;
import com.ocprva.salespop.fragments.HomeFragment;
import com.ocprva.salespop.fragments.SellFragment;
import com.ocprva.salespop.fragments.UserFragment;


public class MainActivity extends AppCompatActivity implements ProductListener {

    HomeFragment homeFragment;
    UserFragment userFragment;
    CategoriesFragment categoriesFragment;
    SellFragment sellFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        Usuario user = (Usuario) this.getIntent().getSerializableExtra("usuario");

        homeFragment = HomeFragment.newInstance(user);
        userFragment = UserFragment.newInstance(user);
        categoriesFragment = CategoriesFragment.newInstance(user);
        sellFragment = SellFragment.newInstance(user);

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
                        loadFragment(categoriesFragment);
                        break;

                    case R.id.sellMenu:
                        loadFragment(sellFragment);
                        break;

                    case R.id.favsMenu:
                        loadFragment(new FavsFragment());
                        break;

                    case R.id.userMenu:
                        loadFragment(userFragment);
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
    public void onProductoSeleccionada(Product p) {
        Intent i = new Intent(this, DetailProductActivity.class);
        i.putExtra("producto", p);
        startActivity(i);
    }
}