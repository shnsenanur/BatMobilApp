package com.example.batmobilapp.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.batmobilapp.R;
import com.example.batmobilapp.ui.fragment.CategoryListFragment;
import com.example.batmobilapp.ui.fragment.ChatFragment;
import com.example.batmobilapp.ui.fragment.EventListFragment;
import com.example.batmobilapp.ui.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        BottomNavigationView navigation =  findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new CategoryListFragment());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new CategoryListFragment();
                    break;
                case R.id.navigation_search:
                    selectedFragment = new EventListFragment();
                    break;
                case R.id.navigation_chat:
                    selectedFragment = new ChatFragment();
                    break;
                case R.id.navigation_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            loadFragment(selectedFragment);
            return true;
        }
    };
    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
