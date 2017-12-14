package damian.eiranova.santamaria.muxcler.muscle_draw;


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
import damian.eiranova.santamaria.muxcler.main_activity.prueba_tabs.MuscleListPresenter;

public class MusclesDrawActivity extends Fragment {

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

    public static MusclesDrawActivity newInstance() {
        return new MusclesDrawActivity();
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
        View v = inflater.inflate(R.layout.prueba, container, false);
      /*  imageMapViewFront = v.findViewById(R.id.front_side_img);

        imageMapViewFront.setAdapter(new MusclesAdapter(pointsFront, this.getContext()));

        // Set ImageMapView check tap location and only trigger select if visible pixel is hit
        imageMapViewFront.setAllowTransparent(false);*/
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

            }

        }


        imageMapViewNew.setAdapter(new MusclesAdapter2(pointsFront, getActivity()));

       /*   pointsBack = new ArrayList<>();

      pointsBack.add(new MuscleItem("Calves", new PointF(0.420f, 0.780f), null, null));
        pointsBack.add(new MuscleItem("Head", new PointF(0.5f, 0.074f), null, null));
        pointsBack.add(new MuscleItem("Finger", new PointF(0.82f, 0.530f), null, null));
        pointsBack.add(new MuscleItem("Wrist", new PointF(0.19f, 0.47f), null, null));
        pointsBack.add(new MuscleItem("Hand", new PointF(0.19f, 0.53f), null, null));
        pointsBack.add(new MuscleItem("Back", new PointF(0.5f, 0.35f), null, null));
        pointsBack.add(new MuscleItem("Ankle", new PointF(0.43f, 0.92f), null, null));
        pointsBack.add(new MuscleItem("Foot", new PointF(0.60f, 0.96f), null, null));
        pointsBack.add(new MuscleItem("Gluts", new PointF(0.54f, 0.48f), null, null));
  */
    }

    public void UpdateMuscleDraw(String[] data) {
        setUpData(data);
    }


}
