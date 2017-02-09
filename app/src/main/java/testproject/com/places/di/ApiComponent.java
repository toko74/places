package testproject.com.places.di;


import dagger.Component;
import testproject.com.places.model.api.GoogleMapsApi;
import testproject.com.places.model.api.GoogleMapsApiImpl;



/**
 * @author Gilad Opher
 */
@PerApi
@Component(
		dependencies = {AppComponent.class},
		modules = {ApiModule.class}
)
public interface ApiComponent{


	GoogleMapsApiImpl googleMapsApiImpl();


}
