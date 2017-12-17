package damian.eiranova.santamaria.muxcler.muscle_selection.muscles_list.view;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import damian.eiranova.santamaria.muxcler.R;
import damian.eiranova.santamaria.muxcler.main_activity.model.Muscle;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.FilaViewHolder> {

    private Muscle[] items;
    private SeleccionListener oyente;
    private MuscleMasterListFragment muscleMasterListFragment;


    public RecyclerViewAdapter(Object[] datos, SeleccionListener oyente, MuscleMasterListFragment parentView) {
        items = (Muscle[]) datos;
        this.oyente = oyente;
        this.muscleMasterListFragment = parentView;
    }


    public interface SeleccionListener {
        void onClick(FilaViewHolder fvh, int posicion);
    }

    @Override
    public FilaViewHolder onCreateViewHolder(ViewGroup padre, int viewType) {
        View view = LayoutInflater.from(padre.getContext())
                .inflate(R.layout.item_muscle_layout, padre, false);
        return new FilaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(FilaViewHolder fvh, int posicion) {
        fvh.muscleName.setText(items[posicion].getMuscleName());

        Resources resources = muscleMasterListFragment.getResources();
        //Inflate exerciseImage ImageView with corresponding exercise image
        String imageName = items[posicion].getMuscleImage();
        final int muscleImageId = resources.getIdentifier(imageName, "drawable", muscleMasterListFragment.getContext().getPackageName());
        fvh.muscleImage.setImageDrawable(resources.getDrawable(muscleImageId, null));


    }

    @Override
    public int getItemCount() {
        return items.length;
    }


    public class FilaViewHolder extends RecyclerView.ViewHolder {

        private TextView muscleName;
        private ImageView muscleImage;


        public FilaViewHolder(View view) {
            super(view);
            view.setClickable(true);
            muscleName = (TextView) view.findViewById(R.id.muscle_name);
            muscleImage = view.findViewById(R.id.muscle_image);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    oyente.onClick(FilaViewHolder.this, getAdapterPosition());

                }
            });
        }
    }

}
