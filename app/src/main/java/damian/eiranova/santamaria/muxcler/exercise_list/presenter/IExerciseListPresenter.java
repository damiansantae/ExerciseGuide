package damian.eiranova.santamaria.muxcler.exercise_list.presenter;


public interface IExerciseListPresenter {
    /**
     * Bridge between View-Model to get the drawable name reference of the star image
     * associated to the exercise difficulty
     *
     * @param difficulty
     * @return
     */
    String getStarImageReference(int difficulty);

    /**
     * Bridge between View-Model to get the drawable name reference of the machine image
     * associated to the machine need of the exercise
     *
     * @param needMachine
     * @return
     */
    String getMachineImageReference(boolean needMachine);
}
