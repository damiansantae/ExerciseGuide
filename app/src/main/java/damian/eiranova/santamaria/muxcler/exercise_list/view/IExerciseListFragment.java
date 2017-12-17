package damian.eiranova.santamaria.muxcler.exercise_list.view;


import damian.eiranova.santamaria.muxcler.exercise_list.model.Exercise;

public interface IExerciseListFragment {
    /**
     * Method called to update the items of the detail view with the exercise list
     * given by method params
     *
     * @param data
     */
    void UpdateExerciseList(Exercise[] data);
}
