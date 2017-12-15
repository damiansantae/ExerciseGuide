package damian.eiranova.santamaria.muxcler.exercise_detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.Config;
import damian.eiranova.santamaria.muxcler.R;


public class ExerciseDetail extends Fragment implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerSupportFragment youTubePlayerFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.exercise_detail, container, false);
        youTubePlayerFragment = (YouTubePlayerSupportFragment) getChildFragmentManager().findFragmentById(R.id.video_fragment);
        loadVideo();
        return v;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    /*	nombreReceta = (TextView) getView().findViewById(R.id.nombreReceta);
		imagenDeReceta = (ImageView) getView().findViewById(R.id.imagenDeReceta);
		infoReceta = (TextView) getView().findViewById(R.id.infoReceta);*/


        AppMediador appMediador = (AppMediador) this.getActivity().getApplication();
        //appMediador.setExerciseListFragment(this);
    }


    private void loadVideo() {
        youTubePlayerFragment.initialize(Config.YOUTUBE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if(!wasRestored){
            youTubePlayer.loadVideo("3LiubyYpEUk");
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
        }
    }

}
