package damian.eiranova.santamaria.muxcler.exercise_list.presenter;


import damian.eiranova.santamaria.muxcler.exercise_list.model.ExerciseListModel;

public class ExerciseListPresenter implements IExerciseListPresenter {
    private ExerciseListModel exerciseListModel;

    public ExerciseListPresenter() {
        this.exerciseListModel = ExerciseListModel.getInstance();

    }

    @Override
    public String getStarImageReference(int difficulty) {
        return exerciseListModel.getStarImageReference(difficulty);
    }

    @Override
    public String getMachineImageReference(boolean needMachine) {
        return exerciseListModel.getMachineImageReference(needMachine);
    }
}
