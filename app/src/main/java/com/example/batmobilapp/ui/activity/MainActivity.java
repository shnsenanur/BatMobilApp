package com.example.batmobilapp.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.batmobilapp.R;
import com.example.batmobilapp.ui.fragment.CategoryListFragment;
import com.example.batmobilapp.ui.fragment.ProfileFragment;
import com.example.batmobilapp.ui.fragment.UserListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
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
                case R.id.navigation_user_list:
                    selectedFragment = new UserListFragment();
                    break;
                /*case R.id.navigation_chat:
                    selectedFragment = new ChatFragment();
                    break;*/
                case R.id.navigation_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            loadFragment(selectedFragment);
            return true;
        }
    };

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainFrameLayout, fragment)
                .addToBackStack(fragment.getTag())
                .commit();
    }

}
