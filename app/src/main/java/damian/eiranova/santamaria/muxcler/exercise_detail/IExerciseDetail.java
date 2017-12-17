package damian.eiranova.santamaria.muxcler.exercise_detail;


import damian.eiranova.santamaria.muxcler.exercise_list.model.Exercise;

public interface IExerciseDetail {
    /**
     * Method called to update the items of the detail view with the exercise
     * object given by method params
     * @param exercise
     */
    void UpdateExerciseDetail(Exercise exercise);
}
