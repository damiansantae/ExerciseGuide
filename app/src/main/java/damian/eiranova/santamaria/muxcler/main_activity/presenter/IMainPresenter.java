package damian.eiranova.santamaria.muxcler.main_activity.presenter;

public interface IMainPresenter {
	
	// TODO A�adir el m�todo obtenerDatos() de tipo void que solicita los datos de la lista maestro al modelo.
    void getMuscleMasterListData();

    void getExerciseList(int posicion);

    void getExerciseListOfMuscle(String name);


    // TODO A�adir el m�todo obtenerDetalles() que recupera los datos de una receta dada su posici�n
	// en la lista maestro.
    //void obtenerDetalle(int position);


}
