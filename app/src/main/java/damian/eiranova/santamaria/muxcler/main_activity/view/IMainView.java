package damian.eiranova.santamaria.muxcler.main_activity.view;

public interface IMainView {

    void loadTabFragment();

    void UpdateMasterMuscleList(Object data);

    // TODO Añadir el método actualizarMaestro(Object[] datos) que actualiza la lista maestro con los datos
	// recibidos por parámetros. En cada entrada del vector, está el nombre de una receta.


	// TODO Añadir el método actualizarDetalle(Object[] datos) que actualiza la lista detalle con los datos
	// de una receta recibidos por parámetros. Así:
	// datos[0] = almacena el nombre de la receta y en qué se usa para realizarla (String).
	// datos[1] = almacena una imagen de la receta (Bitmap).
	// datos[2] = almacena la descripción de la receta (String).

   // void actualizarDetalle(Object[] datos);

   // void presentarAlerta(int pos);

}
