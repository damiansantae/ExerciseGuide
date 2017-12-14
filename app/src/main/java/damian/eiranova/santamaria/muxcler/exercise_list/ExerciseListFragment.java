package damian.eiranova.santamaria.muxcler.exercise_list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.R;
import damian.eiranova.santamaria.muxcler.exercise_list.model.Exercise;

public class ExerciseListFragment extends Fragment implements RecyclerViewExerciseAdapter.SelectionListener {

    private RecyclerView recyclerView;
    private ListenExerciseFragment listener;




	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
	    View v = inflater.inflate(R.layout.exercise_list_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.exercise_list);
        return v;

    }
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	/*	nombreReceta = (TextView) getView().findViewById(R.id.nombreReceta);
		imagenDeReceta = (ImageView) getView().findViewById(R.id.imagenDeReceta);
		infoReceta = (TextView) getView().findViewById(R.id.infoReceta);*/


        AppMediador appMediador = (AppMediador) this.getActivity().getApplication();
        appMediador.setExerciseListFragment(this);
	}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListenExerciseFragment) {
            listener = (ListenExerciseFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " debes implementar ListenExerciseFragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void createList(Exercise[] data) {
        if (data == null) {
            return;
        }
        // crea un adaptador
        RecyclerViewExerciseAdapter adapter = new RecyclerViewExerciseAdapter(data, this);
        recyclerView.setAdapter(adapter);
        if (data != null && data.length != 0) {
            ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
            ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
            touchHelper.attachToRecyclerView(recyclerView);
        }
    }


    public void UpdateExerciseList(Exercise[] data) {
        createList(data);
    }

    @Override
    public void onClick(RecyclerViewExerciseAdapter.FilaViewHolder fvh, int posicion) {
	    listener.onExerciseClicked(posicion);

    }

    public interface ListenExerciseFragment {
        void onExerciseClicked(int posicion);
    }
}
