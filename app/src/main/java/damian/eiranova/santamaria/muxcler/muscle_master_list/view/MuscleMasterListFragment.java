package damian.eiranova.santamaria.muxcler.muscle_master_list.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.R;
import damian.eiranova.santamaria.muxcler.muscle_master_list.RecyclerViewAdapter;
import damian.eiranova.santamaria.muxcler.muscle_master_list.SimpleItemTouchHelperCallback;

public class MuscleMasterListFragment extends android.support.v4.app.Fragment
        implements RecyclerViewAdapter.SeleccionListener {

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
        View v = inflater.inflate(R.layout.activity_fragmento_maestro, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.master_list);
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

    public void createList(String[] data) {
        if (data == null) {
            return;
        }
        // crea un adaptador
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data, this);
        recyclerView.setAdapter(adapter);
        if (data != null && data.length != 0) {
            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
            ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
            touchHelper.attachToRecyclerView(recyclerView);
        }
    }

    public void UpdateMasterMuscleList(String[] data) {
        createList(data);
    }

    public interface ListenFragment {
        void onMuscleSelected(int posicion);
    }


}
