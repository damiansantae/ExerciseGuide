package damian.eiranova.santamaria.muxcler.main_activity.view;

public interface IMainView {

    void loadTabFragment();

    void UpdateMasterMuscleList(Object data);

    // TODO A�adir el m�todo actualizarMaestro(Object[] datos) que actualiza la lista maestro con los datos
	// recibidos por par�metros. En cada entrada del vector, est� el nombre de una receta.


	// TODO A�adir el m�todo actualizarDetalle(Object[] datos) que actualiza la lista detalle con los datos
	// de una receta recibidos por par�metros. As�:
	// datos[0] = almacena el nombre de la receta y en qu� se usa para realizarla (String).
	// datos[1] = almacena una imagen de la receta (Bitmap).
	// datos[2] = almacena la descripci�n de la receta (String).

   // void actualizarDetalle(Object[] datos);

   // void presentarAlerta(int pos);

}
