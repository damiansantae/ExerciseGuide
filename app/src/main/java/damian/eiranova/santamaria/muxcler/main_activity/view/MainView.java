package damian.eiranova.santamaria.muxcler.main_activity.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.MuxclerMenuFragment;
import damian.eiranova.santamaria.muxcler.R;
import damian.eiranova.santamaria.muxcler.exercise_detail.ExerciseDetail;
import damian.eiranova.santamaria.muxcler.exercise_list.view.ExerciseListFragment;
import damian.eiranova.santamaria.muxcler.main_activity.presenter.IMainPresenter;
import damian.eiranova.santamaria.muxcler.muscle_selection.muscles_tab_container.view.TabFragment;
import damian.eiranova.santamaria.muxcler.muscle_selection.muscles_list.view.MuscleMasterListFragment;

public class MainView extends AppCompatActivity
        implements IMainView, NavigationView.OnNavigationItemSelectedListener, MuscleMasterListFragment.ListenFragment, ExerciseListFragment.ListenExerciseFragment {


    private AppMediador appMediador;
    private IMainPresenter mainPresenter;
    private MuscleMasterListFragment fragmentoMaestro;
    private ExerciseListFragment exerciseListFragment;
    private ExerciseDetail exerciseDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        appMediador = (AppMediador) this.getApplication();
        mainPresenter = appMediador.getMainPresenter();

        appMediador.setMainView(this);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Detect if there is a smarthpone or a landscape tablet running app
        if (findViewById(R.id.main_fragment_container) != null) {
            // se crea el fragmento maestro y se añade al contenedor de fragmentos
            //fragmentoMaestro = new MuscleMasterListFragment();
            MuxclerMenuFragment musclerMenuFragment = new MuxclerMenuFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_fragment_container, musclerMenuFragment)
                    .commit();
        } else {
            // Si el layout no es de panel único (es una tableta) se permiten más de un fragmento
            // por tanto, se crean los dos fragmentos y se añaden a sus layouts según el xml sw600dp
        /*    fragmentoMaestro = new FragmentoMaestro();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedor_lista, fragmentoMaestro)
                    .commit();

            fragmentoDetalle = new FragmentoDetalle();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedor_detalle, fragmentoDetalle)
                    .commit();*/
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (findViewById(R.id.main_fragment_container) != null) {
            if (findViewById(R.id.muxcler_menu) == null) {

                if (findViewById(R.id.exercise_list_land) != null) {
                    MuxclerMenuFragment musclerMenuFragment = new MuxclerMenuFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_fragment_container, musclerMenuFragment)
                            .commit();
                } else if (findViewById(R.id.exercise_list) != null && findViewById(R.id.exercise_list).getVisibility() == View.VISIBLE) {
                    exerciseListFragment = null;

                    Fragment tabFragment = new TabFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, tabFragment)
                            .addToBackStack(null)
                            .commit();
                } else if (findViewById(R.id.exercise_detail) != null && findViewById(R.id.exercise_detail).getVisibility() == View.VISIBLE) {
                    exerciseDetailFragment = null;
                    loadExerciseListFragment();
                    mainPresenter.getExerciseListOfCurrentMuscle();

                } else {
                    MuxclerMenuFragment musclerMenuFragment = new MuxclerMenuFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_fragment_container, musclerMenuFragment)
                            .commit();
                }
            } else {
                finish();
            }

        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_guide) {
            exerciseListFragment = null;
            Fragment tabFragment = new TabFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, tabFragment)
                    .addToBackStack(null)
                    .commit();
            // Handle the camera action

        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void loadTabFragment() {
        exerciseListFragment = null;
        Fragment tabFragment = new TabFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, tabFragment)
                .addToBackStack(null)
                .commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        // TODO Solicitar al presentador que recupere los datos desde el modelo.


    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO Solicitar al presentador que recupere los datos desde el modelo.


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appMediador.removeMainPresenter();
    }

    @Override
    public void UpdateMasterMuscleList(Object data) {
        //fragmentoMaestro.createList((String[]) data);

        //TODO: Dentro del método actualizarMaestro(Object[] datos), si es una pantalla multi-panel, presentar
        // el detalle de la primera receta.
      /*  if (findViewById(R.id.contenedorDeFragmentos) == null) {
            presentadorPrincipal.obtenerDetalle(0);*/

    }

    @Override
    public void onMuscleSelected(int posicion) {
        loadExerciseListFragment();
        mainPresenter.getExerciseList(posicion);
    }

    public void onMuscleClicked(String name) {
        loadExerciseListFragment();
        mainPresenter.getExerciseListOfMuscle(name);
    }

    public void onExerciseClicked(String name) {
        loadExerciseDetailFragment();
        mainPresenter.getExerciseDetail(name);
    }

    private void loadExerciseDetailFragment() {
        if (exerciseDetailFragment == null) {
            exerciseDetailFragment = new ExerciseDetail();

            if (findViewById(R.id.exercise_detail_land) == null) {
                // se crea el fragmento maestro y se añade al contenedor de fragmentos
                //fragmentoMaestro = new MuscleMasterListFragment();

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_fragment_container, exerciseDetailFragment)
                        .addToBackStack(null)
                        .commit();
                getSupportFragmentManager().executePendingTransactions();

            }
        }
    }

    private void loadExerciseListFragment() {
        if (exerciseListFragment == null) {
            exerciseListFragment = new ExerciseListFragment();
        }
        if (findViewById(R.id.exercise_list_land) == null) {
            // se crea el fragmento maestro y se añade al contenedor de fragmentos
            //fragmentoMaestro = new MuscleMasterListFragment();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_container, exerciseListFragment)
                    .addToBackStack(null)
                    .commit();
            getSupportFragmentManager().executePendingTransactions();

        }

    }


    public void showConfirmationSnack(final String muscleName) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Desea visualizar ejercicios para " + muscleName + "?", 10000)
                .setAction("SI", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onMuscleClicked(muscleName);
                    }
                });

        snackbar.show();
    }

}
