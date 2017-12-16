package damian.eiranova.santamaria.muxcler.exercise_list.model;


import java.io.Serializable;

public class Exercise implements Serializable {
    private static final long serialVersionUID = -344029298860190065L;
    private String exerciseID;
    private String exerciseName;
    private String exerciseImage;
    private boolean needMachine;
    private String muscleID;
    private String exerciseVideoUrl;



    private int difficulty;

    public Exercise(String exerciseID, String exerciseName, String exerciseImage, boolean needMachine,int difficulty, String muscleID, String exerciseVideoUrl) {
        super();
        this.exerciseID = exerciseID;
        this.exerciseName = exerciseName;
        this.exerciseImage = exerciseImage;
        this.needMachine = needMachine;
        this.difficulty= difficulty;
        this.muscleID = muscleID;
        this.exerciseVideoUrl = exerciseVideoUrl;
    }

    public String getExerciseID() {
        return exerciseID;
    }

    public void setExerciseID(String exerciseID) {
        this.exerciseID = exerciseID;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseImage() {
        return exerciseImage;
    }

    public void setExerciseImage(String exerciseImage) {
        this.exerciseImage = exerciseImage;
    }

    public boolean isNeedMachine() {
        return needMachine;
    }

    public int getDifficulty() {
        return difficulty;
    }
    public String getMuscleID(){
        return  this.muscleID;
    }

    public String getExerciseVideoUrl() {
        return this.exerciseVideoUrl;
    }
}
