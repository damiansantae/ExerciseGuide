package damian.eiranova.santamaria.muxcler.exercise_list.model;


import java.util.ArrayList;


public class ExerciseRepository {

    private static ExerciseRepository singleton = null;
    private ArrayList<Exercise> exerciseList;

    private ExerciseRepository(){
        this.exerciseList = new ArrayList<Exercise>();
        this.exerciseList.add(new Exercise("abdominales_suspension", "Abdominales Con Piernas En Suspension","abdominales.png",false,2, "abdominales"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "Abdominales Con Piernas En Suspension","abdominales.png",false,2, "abdominales"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "Abdominales Con Piernas En Suspension","abdominales.png",false,2, "abdominales"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "Abdominales Con Piernas En Suspension","abdominales.png",false,2, "abdominales"));

    }

    public static ExerciseRepository getInstance(){
        if (singleton== null){
            singleton = new ExerciseRepository();
        }
        return singleton;
    }
    public ArrayList<Exercise> getExerciseList(String muscleID){
        ArrayList<Exercise> exerciseListOfMuscle = new ArrayList<>();

        for ( Exercise exercise: exerciseList
             ) {
            if(exercise.getMuscleID().equals(muscleID))
                exerciseListOfMuscle.add(exercise);
        }
        return exerciseListOfMuscle;
    }


}
