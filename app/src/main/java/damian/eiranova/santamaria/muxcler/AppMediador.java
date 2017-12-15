package damian.eiranova.santamaria.muxcler;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

import damian.eiranova.santamaria.muxcler.exercise_list.view.ExerciseListFragment;
import damian.eiranova.santamaria.muxcler.main_activity.presenter.IMainPresenter;
import damian.eiranova.santamaria.muxcler.main_activity.presenter.MainPresenter;
import damian.eiranova.santamaria.muxcler.muscle_selection.muscles_tab_container.presenter.MuscleListPresenter;
import damian.eiranova.santamaria.muxcler.main_activity.view.IMainView;
import damian.eiranova.santamaria.muxcler.muscle_selection.muscles_draw.view.MusclesDrawFragment;
import damian.eiranova.santamaria.muxcler.muscle_selection.muscles_list.view.MuscleMasterListFragment;

@SuppressWarnings("rawtypes")
public class AppMediador extends Application {
	private static AppMediador singleton;

	// variables correspondientes a los presentadores, vistas y modelo
	private IMainPresenter mainPresenter;
    private MuscleListPresenter muscleListPresenter;
    private MuscleMasterListFragment musclerListFragment;
	private MusclesDrawFragment muscleDrawFragment;

	private ExerciseListFragment exerciseListFragment;
    private IMainView mainView;
	private IMainView muscleView;

    // constantes de comunicación, almacenamiento y petición
    public static final String MUSCLE_LIST_KEY = "muscleList";
    public static final String NOTIFY_DATA_MUSCLELIST_READY = "damian.eiranova.santamaria.NOTIFY_DATA_MUSCLELIST_READY";
    public static final String EXERCISE_LIST_KEY = "exerciseList";
    public static final String NOTIFY_DATA_EXERCISE_LIST_READY = "damian.eiranova.santamaria.NOTIFY_DATA_EXERCISE_LIST_READY";
    public static final String NOTIFY_DATA_MUSCLELIST_READY2 = "damian.eiranova.santamaria.NOTIFY_DATA_MUSCLELIST_READY2";


	public static AppMediador getInstance(){
		return singleton;
	}

	// Métodos accessor de los presentadores, vistas y modelo
	public IMainPresenter getMainPresenter() {
		if (mainPresenter == null)
			mainPresenter = new MainPresenter();
		return mainPresenter;
	}

    public MuscleListPresenter getMuscleListPresenter() {
        if (muscleListPresenter == null)
            muscleListPresenter = new MuscleListPresenter();
        return muscleListPresenter;
    }

	public void removeMainPresenter(){
		mainPresenter = null;
	}

	public IMainView getMainView() {
		return  mainView;
	}

	public IMainView getMuscleView() {
	    return muscleView;
    }

	public void setMainView(IMainView mainView){
		this.mainView = mainView;
	}
    public void setMuscleView(IMainView muscleView){
        this.muscleView = muscleView;
    }
	// Métodos destinados a la navegación en la aplicación y a la definición de servicios

		
	// Métodos de manejo de los componentes de Android
	public void launchActivity(Class actividadInvocada, Object invocador, Bundle extras) {
		Intent i = new Intent(this, actividadInvocada);
		if (extras != null)
			i.putExtras(extras);	
		if (!invocador.getClass().equals(Activity.class))
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(i);
	}
	
	public void launchActivityForResult(Class actividadInvocada,
                                        Activity actividadInvocadora, int requestCode, Bundle extras) {
		Intent i = new Intent(actividadInvocadora, actividadInvocada);
		if (extras != null)
			i.putExtras(extras);
		actividadInvocadora.startActivityForResult(i, requestCode);
	}
	
	public void launchService(Class servicioInvocado, Bundle extras) {
		Intent i = new Intent(this, servicioInvocado);
		if (extras != null)
			i.putExtras(extras);
        startService(i);
	}
	
	public void stopService(Class servicioInvocado) {
		Intent i = new Intent(this, servicioInvocado);
        stopService(i);
	}
	
	public void registerReceiver(BroadcastReceiver receptor, String accion) {
		LocalBroadcastManager.getInstance(this).registerReceiver(receptor, new IntentFilter(accion));
	}	
	
	public void unRegisterReceiver(BroadcastReceiver receptor) {
		LocalBroadcastManager.getInstance(this).unregisterReceiver(receptor);
	}
	
	public void sendBroadcast(String accion, Bundle extras) {
		Intent intent = new Intent();
		intent.setAction(accion);
		if (extras != null)
			intent.putExtras(extras);
		LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
	}

	/*public Class getVistaParaAgregacion(){
	    return VistaAgregacion.class;
    }*/

	@Override
	public void onCreate() {
		super.onCreate();
		mainPresenter = null;
		singleton = this;
		//presentadorAgregacion = null;
	}


    public void setMusclerListFragment(MuscleMasterListFragment muscleMasterListFragment) {
	    this.musclerListFragment = muscleMasterListFragment;
    }
	public void setMuscleDrawFragment(MusclesDrawFragment muscleDrawFragment) {
		this.muscleDrawFragment = muscleDrawFragment;
	}
    public MuscleMasterListFragment getMusclerListFragment (){
	    return this.musclerListFragment;
    }

	public MusclesDrawFragment getMuscleDrawFragment (){
		return this.muscleDrawFragment;
	}


	public void setExerciseListFragment(ExerciseListFragment exerciseListFragment) {
        this.exerciseListFragment = exerciseListFragment;
    }

    public ExerciseListFragment getExerciseListFragment (){
        return this.exerciseListFragment;
    }

}
