package damian.eiranova.santamaria.muxcler.main_activity.presenter;

public interface IMainPresenter {


    /**
     * this method is called when a click on a muscle of the muscle list is done
     * Link view-model to get the exercise list of the muscle clicked
     *
     * @param position
     */
    void getExerciseList(int position);

    /**
     * This method is called when a muscle is touched in the muscle graph view.
     * Link view-model to get the exercise list of the muscle clicked
     *
     * @param name
     */
    void getExerciseListOfMuscle(String name);

    /**
     * Link view-model to get the exercise detail information of the exercise clicked
     * in the exercise list
     *
     * @param name
     */
    void getExerciseDetail(String name);

    /**
     * This method is called when the exercise list needs to be reloaded,
     * for example because user press back btn being in the exercise detail
     */
    void getExerciseListOfCurrentMuscle();


}
