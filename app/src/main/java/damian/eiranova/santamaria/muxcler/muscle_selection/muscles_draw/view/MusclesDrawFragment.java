package damian.eiranova.santamaria.muxcler.muscle_selection.muscles_draw.view;


import android.graphics.PointF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zechassault.zonemap.util.BitmapUtils;
import com.zechassault.zonemap.view.ImageMapView;
import com.zechassault.zonemap.view.NoteImageView;

import java.util.ArrayList;
import java.util.List;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.R;
import damian.eiranova.santamaria.muxcler.muscle_selection.muscles_draw.model.MuscleItem;
import damian.eiranova.santamaria.muxcler.muscle_selection.muscles_tab_container.presenter.MuscleListPresenter;

public class MusclesDrawFragment extends Fragment {

    /**
     * Front view items
     */
    private List<MuscleItem> pointsFront;

    /**
     * Back view items
     */
    private List<MuscleItem> pointsBack;

    /**
     * Back image map view
     */
    private NoteImageView imageMapViewBack;

    /**
     * Front image map view
     */
    private NoteImageView imageMapViewFront;

    private ImageMapView imageMapViewNew;

    private MuscleListPresenter musclePresenter;


    private AppMediador appMediador;

    public static MusclesDrawFragment newInstance() {
        return new MusclesDrawFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppMediador appMediador = (AppMediador) this.getActivity().getApplication();
        appMediador.setMuscleDrawFragment(this);


     /*   imageMapViewBack = (NoteImageView) findViewById(R.id.imageMapView);
        imageMapViewBack.setAdapter(new MusclesAdapter(pointsBack, this));
        // Set ImageMapView check tap location and only trigger select if visible pixel is hit
        imageMapViewBack.setAllowTransparent(false);
*/


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.muscles_draw_fragment, container, false);
        imageMapViewNew = v.findViewById(R.id.front_side_img);
        imageMapViewNew.setAllowTransparent(false);


        return v;
    }

    private void setUpData(String[] muscles) {

        pointsFront = new ArrayList<>();

        for (String muscle :
                muscles) {
            switch (muscle) {
                case "Abdominales":
                    pointsFront.add(new MuscleItem("Abdominales", new PointF(0.493f, 0.385f),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.abs_col)),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.abs))));
                    break;
                case "Abductores":
                    pointsFront.add(new MuscleItem("Abductores", new PointF(0.505f, 0.54f),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.adductor_col)),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.adductor))));
                    break;
                case "Cuadriceps":
                    pointsFront.add(new MuscleItem("Cuadriceps", new PointF(0.658f, 0.575f),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.quad_col)),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.quad))));
                    break;
                case "Biceps":

                    pointsFront.add(new MuscleItem("Biceps", new PointF(0.513f, 0.273f),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.arm_col)),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.arms))));
                    break;
                case "Hombros":

                    pointsFront.add(new MuscleItem("Hombros", new PointF(0.405f, 0.209f),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.shoulders_col)),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.shoulders))));
                    break;

                case "Pecho":

                    pointsFront.add(new MuscleItem("Pecho", new PointF(0.500f, 0.230f),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.chest_col)),
                            BitmapUtils.resAsBitmap(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.chest))));
                    break;

            }

        }


        imageMapViewNew.setAdapter(new MusclesDrawAdapter(pointsFront, getActivity()));

    }

    public void UpdateMuscleDraw(String[] data) {
        setUpData(data);
    }


}
