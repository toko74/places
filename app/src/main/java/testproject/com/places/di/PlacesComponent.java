package testproject.com.places.di;

import dagger.Component;
import testproject.com.places.view.NearbyPlacesActivity;
import testproject.com.places.view.PresenterHolder;



/**
 * @author Gilad Opher
 */
@ActivityScoped
@Component(
		dependencies = {ApiComponent.class},
		modules = {PlacesModule.class}
)
public interface PlacesComponent{


	void inject(NearbyPlacesActivity activity);


}
