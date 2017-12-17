package damian.eiranova.santamaria.muxcler.muscle_selection.muscles_list.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.R;
import damian.eiranova.santamaria.muxcler.main_activity.model.Muscle;

public class MuscleMasterListFragment extends android.support.v4.app.Fragment
        implements RecyclerViewAdapter.SeleccionListener, IMuscleMasterListFragment {

    private RecyclerView recyclerView;
    private ListenFragment listener;

    public static MuscleMasterListFragment newInstance() {
        return new MuscleMasterListFragment();
    }


    @Override
    public void onClick(RecyclerViewAdapter.FilaViewHolder fvh, int posicion) {
        listener.onMuscleSelected(posicion);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppMediador appMediador = (AppMediador) this.getActivity().getApplication();
        appMediador.setMusclerListFragment(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.muscles_list_fragment, container, false);
        recyclerView = v.findViewById(R.id.master_list);
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListenFragment) {
            listener = (ListenFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " debes implementar ListenFragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void createList(Muscle[] data) {
        if (data == null) {
            return;
        }
        // crea un adaptador
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data, this, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void UpdateMasterMuscleList(Muscle[] data) {
        createList(data);
    }

    public interface ListenFragment {
        void onMuscleSelected(int posicion);
    }


}
