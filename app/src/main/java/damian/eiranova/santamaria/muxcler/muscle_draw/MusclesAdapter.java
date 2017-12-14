package damian.eiranova.santamaria.muxcler.muscle_draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.v4.content.ContextCompat;

import com.zechassault.zonemap.adapter.NoteImageAdapter;
import com.zechassault.zonemap.listener.ItemClickListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import damian.eiranova.santamaria.muxcler.R;


public class MusclesAdapter extends NoteImageAdapter<MuscleItem> implements ItemClickListener<MuscleItem> {

    private List<MuscleItem> muscles = new ArrayList<>();
    private final Context context;
    private Paint labelPaintUnselected;
    private Paint labelPaintSelected;
    private Set<MuscleItem> selected = new HashSet<>();


    public MusclesAdapter(List<MuscleItem> muscles, Context context) {
        this.context = context;
        this.muscles = muscles;


        labelPaintUnselected = new Paint();
        labelPaintUnselected.setAntiAlias(true);
        labelPaintUnselected.setStrokeWidth(5);
        labelPaintUnselected.setPathEffect(new DashPathEffect(new float[]{10, 20}, 0));
        labelPaintUnselected.setTextSize(50);

        labelPaintSelected = new Paint();
        labelPaintSelected.setAntiAlias(true);
        labelPaintSelected.setFakeBoldText(true);
        labelPaintSelected.setTextSize(50);
        labelPaintSelected.setStrokeWidth(5);
        labelPaintSelected.setColor(ContextCompat.getColor(context, R.color.colorPrimary));

        setItemClickListener(this);

    }

    @Override
    public String getLabel(MuscleItem item) {
        return item.getText();
    }

    @Override
    public PointF getItemCoordinates(MuscleItem item) {
        return item.getCoordinate();
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
        if (selected.contains(item)) {
            return item.getBitmapSelected();
        }
        return item.getBitmapUnselected();
    }

    public Paint getLabelPaint(MuscleItem item) {
        if (selected.contains(item)) {
            return labelPaintSelected;
        }
        return labelPaintUnselected;
    }

    @Override
    public void onMapItemClick(MuscleItem item) {
        if (selected.contains(item)) {
            selected.remove(item);
        } else {
            selected.add(item);
        }
        notifyDataSetHasChanged();

    }

}
