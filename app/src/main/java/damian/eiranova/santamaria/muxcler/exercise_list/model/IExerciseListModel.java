package damian.eiranova.santamaria.muxcler.exercise_list.model;


public interface IExerciseListModel {
    /**
     * Request the exercises which belongs to the muscle corresponding to the giving muscle id.
     * Then send to broadcast the acquired exercises list.
     *
     * @param muscleID
     */
    void getExerciseListData(String muscleID);

    /**
     * Method that search the star image associated to the difficulty giving by params
     *
     * @param difficulty
     * @return String of the drawable name reference
     */
    String getStarImageReference(int difficulty);

    /**
     * Method that search the machine image associated to the need or not a machine
     *
     * @param needMachine
     * @return String of the drawable name reference
     */
    String getMachineImageReference(boolean needMachine);
}
