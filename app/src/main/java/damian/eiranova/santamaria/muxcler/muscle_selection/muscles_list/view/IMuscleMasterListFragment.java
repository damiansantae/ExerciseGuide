package damian.eiranova.santamaria.muxcler.muscle_selection.muscles_list.view;


import damian.eiranova.santamaria.muxcler.main_activity.model.Muscle;

public interface IMuscleMasterListFragment {
    /**
     * Method called to update the items recyclerList view of the muscles
     *
     * @param data Array of Muscle objects
     * @see Muscle
     */
    void UpdateMasterMuscleList(Muscle[] data);
}
