package damian.eiranova.santamaria.muxcler.main_activity.model;


import java.util.ArrayList;

public class MuscleRepository {

    private static MuscleRepository singleton = null;
    private ArrayList<Muscle> muscleList;

    private MuscleRepository() {
        this.muscleList = new ArrayList<Muscle>();
        this.muscleList.add(new Muscle("abdominales", "Abdominales", "abdominales.png"));
        this.muscleList.add(new Muscle("abductores", "Abductores", "abductores.png"));
        this.muscleList.add(new Muscle("cuadriceps", "Cuadriceps", "abductores.png"));
        this.muscleList.add(new Muscle("biceps", "Biceps", "abductores.png"));
        this.muscleList.add(new Muscle("hombros", "Hombros", "abductores.png"));

    }

    public static MuscleRepository getInstance() {
        if (singleton == null) {
            singleton = new MuscleRepository();
        }
        return singleton;
    }

    public ArrayList<Muscle> getMuscleList() {
        return this.muscleList;
    }


}
