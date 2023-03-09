package melvincarl.pote.n01483399.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class PoteActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {

    ViewPager2 viewPager2;
    TabLayout tabLayout;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);
        titles = new ArrayList<String>();
        titles.add(getString(R.string.home));
        titles.add(getString(R.string.settings));
        titles.add(getString(R.string.favourites));
        //tabLayout.getTabAt(0).setIcon(R.drawable.panda_dunk_1);
        setViewPagerAdapter();
        new TabLayoutMediator(tabLayout,viewPager2,this).attach();
    }
    public void setViewPagerAdapter () {
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new SettingsFragment());
        fragmentList.add(new FavouritesFragment());
        viewPager2Adapter.setData(fragmentList);
        viewPager2.setAdapter(viewPager2Adapter);
    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }
}