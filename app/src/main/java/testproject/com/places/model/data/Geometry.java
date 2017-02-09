package testproject.com.places.model.data;

import com.google.gson.annotations.SerializedName;



/**
 * The {@link Location} container.
 *
 * @author Gilad Opher
 */
public class Geometry{


	@SerializedName("location")
	public Location location;


	public Geometry(Location location){
		this.location = location;
	}
}
