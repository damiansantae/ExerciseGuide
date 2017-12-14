  package damian.eiranova.santamaria.muxcler.exercise_list;

  import android.support.v7.widget.RecyclerView;
  import android.view.LayoutInflater;
  import android.view.View;
  import android.view.ViewGroup;
  import android.widget.ImageView;
  import android.widget.TextView;

  import damian.eiranova.santamaria.muxcler.R;
  import damian.eiranova.santamaria.muxcler.exercise_list.model.Exercise;


  public class RecyclerViewExerciseAdapter extends RecyclerView.Adapter<RecyclerViewExerciseAdapter.FilaViewHolder>
          implements IItemTouchHelperAdapter {

      private Exercise[] items;
      private SelectionListener listener;



      public RecyclerViewExerciseAdapter(Object[] datos, SelectionListener listener) {
          items = (Exercise[])datos;
          this.listener = listener;
      }


      @Override
      public void onItemDismiss(int position) {
          //Log.d("adaptador longitud"," "+ items.length);
           for (int i=position; i<items.length-1; i++){
               items[i]=items[i+1];
           }
           items[items.length-1]=null;
          notifyItemRemoved(position);
      }


      public interface SelectionListener {
          public void onClick(FilaViewHolder fvh, int posicion);
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


      }

      @Override
      public int getItemCount() {
          return items.length;
      }


      public class FilaViewHolder extends RecyclerView.ViewHolder  {

          private TextView exerciseName;
          private ImageView exerciseImage;
          private ImageView machine;
          private ImageView start;



          public FilaViewHolder(View view) {
              super(view);
              view.setClickable(true);
              exerciseName = (TextView) view.findViewById(R.id.exercise_name);
              view.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                      listener.onClick(FilaViewHolder.this, getAdapterPosition());

                  }
              });
          }
      }

  }
