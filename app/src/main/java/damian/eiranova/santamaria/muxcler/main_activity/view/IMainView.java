package damian.eiranova.santamaria.muxcler.main_activity.view;

public interface IMainView {

    void loadTabFragment();


    void onMuscleClicked(String name);

    void showConfirmationSnack(String muscleName);
}
