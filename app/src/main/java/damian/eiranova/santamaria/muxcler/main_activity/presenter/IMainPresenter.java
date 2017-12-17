package damian.eiranova.santamaria.muxcler.main_activity.presenter;

public interface IMainPresenter {
	
    //void getMuscleMasterListData();

    void getExerciseList(int posicion);

    void getExerciseListOfMuscle(String name);

    void getExerciseDetail(String name);

    void getExerciseListOfCurrentMuscle();


	// en la lista maestro.
    //void obtenerDetalle(int position);


}
