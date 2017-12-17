package damian.eiranova.santamaria.muxcler.exercise_detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import damian.eiranova.santamaria.muxcler.AppMediador;
import damian.eiranova.santamaria.muxcler.YoutubeApiConfig;
import damian.eiranova.santamaria.muxcler.R;
import damian.eiranova.santamaria.muxcler.exercise_list.model.Exercise;


public class ExerciseDetail extends Fragment implements YouTubePlayer.OnInitializedListener, IExerciseDetail {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerSupportFragment youTubePlayerFragment;
    private TextView exerciseName;
    private String videoUrl;
    private YouTubePlayer myoutubePlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.exercise_detail, container, false);
        youTubePlayerFragment = (YouTubePlayerSupportFragment) getChildFragmentManager().findFragmentById(R.id.video_fragment);
        exerciseName = v.findViewById(R.id.exercise_name_detail);
        return v;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AppMediador appMediador = (AppMediador) this.getActivity().getApplication();
        appMediador.setExerciseDetailFragment(this);
    }


    private void loadVideo() {
        if (myoutubePlayer != null) {
            myoutubePlayer.loadVideo(videoUrl);
        } else {
            youTubePlayerFragment.initialize(YoutubeApiConfig.YOUTUBE_API_KEY, this);

        }


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        youTubePlayer.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CUSTOM_LAYOUT);
        if (!wasRestored) {
            this.myoutubePlayer = youTubePlayer;
            myoutubePlayer.loadVideo(this.videoUrl);
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

    @Override
    public void UpdateExerciseDetail(Exercise exercise) {
        this.videoUrl = exercise.getExerciseVideoUrl();
        this.exerciseName.setText(exercise.getExerciseName());
        loadVideo();


    }
}
