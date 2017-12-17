package damian.eiranova.santamaria.muxcler.exercise_list.view;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import damian.eiranova.santamaria.muxcler.R;
import damian.eiranova.santamaria.muxcler.exercise_list.model.Exercise;
import damian.eiranova.santamaria.muxcler.exercise_list.presenter.ExerciseListPresenter;


public class RecyclerViewExerciseAdapter extends RecyclerView.Adapter<RecyclerViewExerciseAdapter.FilaViewHolder>
        {

    private Exercise[] items;
    private SelectionListener listener;
    private ExerciseListFragment exerciseListFragment;
    private ExerciseListPresenter exerciseListPresenter;


    public RecyclerViewExerciseAdapter(Object[] datos, SelectionListener listener, ExerciseListFragment parentView) {
        items = (Exercise[]) datos;
        this.listener = listener;
        this.exerciseListFragment = parentView;
    }





    public interface SelectionListener {
         void onClick(FilaViewHolder fvh, String posicion);
    }

    @Override
    public FilaViewHolder onCreateViewHolder(ViewGroup padre, int viewType) {
        View view = LayoutInflater.from(padre.getContext())
                .inflate(R.layout.item_exercise_layout, padre, false);
        return new FilaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(FilaViewHolder fvh, int posicion) {
        fvh.exerciseName.setText(items[posicion].getExerciseName());
        Resources resources = exerciseListFragment.getResources();
        //Inflate exerciseImage ImageView with corresponding exercise image
        String imageName = items[posicion].getExerciseImage();
        final int exerciseImageId = resources.getIdentifier(imageName, "drawable", exerciseListFragment.getContext().getPackageName());
        fvh.exerciseImage.setImageDrawable(resources.getDrawable(exerciseImageId, null));

        //Inflate difficulty ImageView with corresponding exercise difficulty
        if (exerciseListPresenter == null) {
            exerciseListPresenter = new ExerciseListPresenter();
        }
       String startImageName = exerciseListPresenter.getStarImageReference(items[posicion].getDifficulty());
        final int starImageId = resources.getIdentifier(startImageName, "drawable", exerciseListFragment.getContext().getPackageName());
        fvh.star.setImageDrawable(resources.getDrawable(starImageId, null));

        //Inflate machine ImageView with corresponding exercise machine need
        String machineImageName = exerciseListPresenter.getMachineImageReference(items[posicion].isNeedMachine());
        final int machineImageId = resources.getIdentifier(machineImageName, "drawable", exerciseListFragment.getContext().getPackageName());
        fvh.machine.setImageDrawable(resources.getDrawable(machineImageId, null));

    }

    @Override
    public int getItemCount() {
        return items.length;
    }


    public class FilaViewHolder extends RecyclerView.ViewHolder {

        private TextView exerciseName;
        private ImageView exerciseImage;
        private ImageView machine;
        private ImageView star;


        public FilaViewHolder(View view) {
            super(view);
            view.setClickable(true);
            exerciseName = (TextView) view.findViewById(R.id.exercise_name);
            exerciseImage = view.findViewById(R.id.exercise_image);
            star = view.findViewById(R.id.difficulty_star);
            machine = view.findViewById(R.id.machine_icon);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onClick(FilaViewHolder.this, exerciseName.getText().toString());

                }
            });
        }
    }

}
