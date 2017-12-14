package damian.eiranova.santamaria.muxcler.main_activity.prueba_tabs;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import damian.eiranova.santamaria.muxcler.muscle_draw.MusclesDrawActivity;
import damian.eiranova.santamaria.muxcler.muscle_master_list.view.MuscleMasterListFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static int TAB_COUNT = 2;
    private MuscleMasterListFragment muscleListFragment;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                muscleListFragment= MuscleMasterListFragment.newInstance();
                return muscleListFragment;

            case 1:
                return MusclesDrawActivity.newInstance();

        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:

                return "LIST";
            case 1:
                return "GRAPH";


        }
        return super.getPageTitle(position);
    }


}