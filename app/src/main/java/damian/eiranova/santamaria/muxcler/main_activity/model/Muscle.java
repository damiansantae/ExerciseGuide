package damian.eiranova.santamaria.muxcler.main_activity.model;

import java.io.Serializable;

public class Muscle implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -344029098860190065L;
	private String muscleID;
	private String muscleName;
	private String muscleImage;

	public Muscle(String muscleID, String muscleName, String muscleImage) {
		super();
		this.muscleID = muscleID;
		this.muscleName = muscleName;
		this.muscleImage = muscleImage;
	}

	public String getMuscleID() {
		return muscleID;
	}

	public void setMuscleID(String muscleID) {
		this.muscleID = muscleID;
	}

	public String getMuscleName() {
		return muscleName;
	}

	public void setMuscleName(String muscleName) {
		this.muscleName = muscleName;
	}

	public String getMuscleImage() {
		return muscleImage;
	}

	public void setMuscleImage(String muscleImage) {
		this.muscleImage = muscleImage;
	}
	

}
