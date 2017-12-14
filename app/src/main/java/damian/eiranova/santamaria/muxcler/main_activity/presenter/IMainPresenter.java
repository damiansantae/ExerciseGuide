package damian.eiranova.santamaria.muxcler.main_activity.presenter;

public interface IMainPresenter {
	
	// TODO Añadir el método obtenerDatos() de tipo void que solicita los datos de la lista maestro al modelo.
    void getMuscleMasterListData();

    void getExerciseList(int posicion);

    void getExerciseListOfMuscle(String name);


    // TODO Añadir el método obtenerDetalles() que recupera los datos de una receta dada su posición
	// en la lista maestro.
    //void obtenerDetalle(int position);


}
