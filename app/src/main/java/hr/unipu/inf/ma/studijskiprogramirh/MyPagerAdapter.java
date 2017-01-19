package hr.unipu.inf.ma.studijskiprogramirh;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Dijana on 8.11.2016..
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter { //DOHVAĆANJE ODREĐENOG FRAGMENTA U POČETNOM IZBORNIKU

    private int brojTabova;

    public MyPagerAdapter(FragmentManager fm, int brojTabova) {
        super(fm);
        this.brojTabova = brojTabova;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PodrucjeFragment tab1 = new PodrucjeFragment();
                return tab1;
            case 1:
                GradFragment tab2 = new GradFragment();
                return tab2;
            case 2:
                UcilisteFragment tab3 = new UcilisteFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return brojTabova;
    }
}