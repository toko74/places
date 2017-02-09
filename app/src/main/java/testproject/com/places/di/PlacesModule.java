package testproject.com.places.di;

import dagger.Module;
import dagger.Provides;
import testproject.com.places.model.api.GoogleMapsApiImpl;
import testproject.com.places.model.PlacesDataSource;
import testproject.com.places.model.PlacesRepository;
import testproject.com.places.model.remote.RemotePlacesDataSource;
import testproject.com.places.presenter.NearbyPlacesPresenter;



/**
 * @author Gilad Opher
 */
@Module
public class PlacesModule{


	@Provides
	PlacesDataSource providePlacesRemoteRepository(GoogleMapsApiImpl api){
		return new RemotePlacesDataSource(api);
	}


	@Provides
	PlacesRepository providePlacesRepository(RemotePlacesDataSource remotePlacesDataSource){
		return new PlacesRepository(remotePlacesDataSource);
	}


	@Provides
	NearbyPlacesPresenter provideNearbyPlacesPresenter(PlacesRepository repository){
		return new NearbyPlacesPresenter(repository);
	}

}
