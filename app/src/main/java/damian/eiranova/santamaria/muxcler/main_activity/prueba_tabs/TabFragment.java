package damian.eiranova.santamaria.muxcler.main_activity.prueba_tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.R;
import damian.eiranova.santamaria.muxcler.main_activity.view.IMainView;


public class TabFragment extends Fragment implements IMainView{

    private AppMediador appMediador;
    private ViewPager mViewPager;
    private MuscleListPresenter mainPresenter;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;
    private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appMediador = (AppMediador) this.getActivity().getApplication();
        mainPresenter = appMediador.getMuscleListPresenter();
        appMediador.setMuscleView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceSta) {
        v = inflater.inflate(R.layout.tab_layout, container, false);
        setViewPager();
        return v;

    }

    private void setViewPager() {

        mViewPager = v.findViewById(R.id.muscle_selection_tab);
        mViewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

        mTabLayout = (TabLayout) v.findViewById(R.id.tab);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onStart() {
        super.onStart();
        // TODO Solicitar al presentador que recupere los datos desde el modelo.
        mainPresenter.getMuscleMasterListData();
    }

    @Override
    public void onResume() {
        super.onResume();
        // TODO Solicitar al presentador que recupere los datos desde el modelo.
        mainPresenter.getMuscleMasterListData();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       // appMediador.removeMainPresenter();
    }


    @Override
    public void UpdateMasterMuscleList(Object object) {

    }
}
