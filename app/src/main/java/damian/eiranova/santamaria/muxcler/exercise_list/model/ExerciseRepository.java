package damian.eiranova.santamaria.muxcler.exercise_list.model;


import java.util.ArrayList;


public class ExerciseRepository {

    private static ExerciseRepository singleton = null;
    private ArrayList<Exercise> exerciseList;


    private ExerciseRepository() {
        this.exerciseList = new ArrayList<Exercise>();
        //Abdominales
        this.exerciseList.add(new Exercise("contracciones_piernas_elevadas", "Contracciones piernas elevadas", "abdominales_piernas_elevadas", false, 1, "abdominales", "gEyuIEBxwes"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "Elevación de piernas", "elevacion_piernas", false, 2, "abdominales", "4oYU_1HjbtM"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "Encogimientos polea", "encogimientos_polea", true, 1, "abdominales", "k37lE5Vf4s0"));

        //Hombros
        this.exerciseList.add(new Exercise("abdominales_suspension", "Vuelos deltoides posterior", "vuelos_deltoides", true, 3, "hombros", "oxJj5FoBycQ"));

        //Biceps
        this.exerciseList.add(new Exercise("abdominales_suspension", "Banco Scott con barra", "banco_scott", true, 2, "biceps", "4oYU_1HjbtM"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "Chin-up", "chin_up", false, 4, "biceps", "_71FpEaq-fQ"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "Curl concentrado", "curl_concentrado", true, 2, "biceps", "8B0mY3gknoc"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "Brazos en cruz con polea alta", "curl_polea_baja", true, 3, "biceps", "wimEw9mhaEI"));

        //Pecho
        this.exerciseList.add(new Exercise("abdominales_suspension", "Press de banca", "press_banca", true, 1, "pecho", "ICaZxO7RmKs"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "Flexiones diamante", "flexiones_diamante", false, 3, "pecho", "IBLAi8s-4Lg"));
        this.exerciseList.add(new Exercise("abdominales_suspension", "PButterfly (contracción)", "butterlfly", true, 0, "pecho", "M3dDJlZwxxs"));

        //Cuadriceps
        this.exerciseList.add(new Exercise("Prensa cuadriceps", "Prensa cuadriceps", "prensa_cuadicept", true, 1, "cuadriceps", "7LhtUL3VPAQ"));
        this.exerciseList.add(new Exercise("Zancadas", "Zancadas", "zancadas", true, 0, "cuadriceps", "qfKHl9_EvWc"));


    }

    public static ExerciseRepository getInstance() {
        if (singleton == null) {
            singleton = new ExerciseRepository();
        }
        return singleton;
    }

    public ArrayList<Exercise> getExerciseList(String muscleID) {
        ArrayList<Exercise> exerciseListOfMuscle = new ArrayList<>();

        for (Exercise exercise : exerciseList
                ) {
            if (exercise.getMuscleID().equals(muscleID))
                exerciseListOfMuscle.add(exercise);
        }
        return exerciseListOfMuscle;
    }


    public ArrayList<Exercise> getAllExercises() {
        return exerciseList;

    }

    public Exercise getExerciseDetail(String name) {
        for (Exercise exercise :
                exerciseList) {
            if (exercise.getExerciseName().equals(name)) {
                return exercise;

            }

        }
        return null;
    }
}
