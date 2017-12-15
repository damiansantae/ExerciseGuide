package damian.eiranova.santamaria.muxcler.muscle_selection.muscles_draw.view;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;

import com.zechassault.zonemap.adapter.MapAdapter;
import com.zechassault.zonemap.listener.ItemClickListener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import damian.eiranova.santamaria.muxcler.main_activity.view.MainView;
import damian.eiranova.santamaria.muxcler.muscle_selection.muscles_draw.model.MuscleItem;

public class MusclesDrawAdapter extends MapAdapter<MuscleItem> implements ItemClickListener<MuscleItem> {

    private final List<MuscleItem> muscles;
    private Context mContext;
    private Set<MuscleItem> muscleClicked = new HashSet<>();

    public MusclesDrawAdapter(List<MuscleItem> muscles, Context context) {

        this.muscles = muscles;
        this.mContext = context;
        setItemClickListener(this);
    }

    @Override
    public PointF getItemCoordinates(MuscleItem item) {
        return new PointF(item.x, item.y);
    }

    @Override
    public MuscleItem getItemAtPosition(int position) {
        return muscles.get(position);
    }

    @Override
    public int getCount() {
        return muscles.size();
    }

    @Override
    public Bitmap getItemBitmap(MuscleItem item) {
        if (muscleClicked.contains(item)) {
            return item.getBitmapSelected();
        }
        return item.getBitmapUnselected();
    }


    @Override
    public void onMapItemClick(MuscleItem item) {
        if (muscleClicked.contains(item)) {
            showConfirmationSnack(item.getText());
        } else {
            muscleClicked.clear();
            showConfirmationSnack(item.getText());
            muscleClicked.add(item);
        }
        notifyDataSetHasChanged();

    }
    private void showConfirmationSnack(String muscleName){
        if(this.mContext instanceof MainView){
            ((MainView)mContext).showConfirmationSnack(muscleName);
        }

    }
}
