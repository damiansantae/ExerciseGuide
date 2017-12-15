package damian.eiranova.santamaria.muxcler.exercise_list.presenter;


import damian.eiranova.santamaria.muxcler.exercise_list.model.ExerciseListModel;

public class ExerciseListPresenter {
    private ExerciseListModel exerciseListModel;

    public ExerciseListPresenter (){
       this.exerciseListModel = ExerciseListModel.getInstance();

    }
public String getStarImageReference(int difficulty){
        return exerciseListModel.getStarImageReference(difficulty);
}

    public String getMachineImageReference(boolean needMachine) {
    return exerciseListModel.getMachineImageReference(needMachine);
    }
}
