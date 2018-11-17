package com.app24.www.wbwp.acitivty;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.app24.www.wbwp.R;
import com.app24.www.wbwp.fragment.FavFragment;
import com.app24.www.wbwp.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private String FRAGMENT_TAG = Fragment.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(this);
        addFragment(new HomeFragment(), FRAGMENT_TAG);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                addFragment(new HomeFragment(), FRAGMENT_TAG);
                return true;
            case R.id.navigation_fav:
                addFragment(new FavFragment(), FRAGMENT_TAG);
                return true;
        }
        return false;
    }

    private void addFragment(Fragment fragment, String fragmentTag) {
        Fragment newFragment = fragment;
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, newFragment, fragmentTag)
                    .commit();
        }
    }
}
