package testproject.com.places;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.squareup.leakcanary.LeakCanary;

import testproject.com.places.di.*;



/**
 * The PLaces {@link Application}. Initiate and save the {@link AppComponent}.
 *
 * @author Gilad Opher
 */
public class NearbyPlacesApplication extends Application{


	/**
	 * The {@link AppComponent}.
 	 */
	private AppComponent appComponent;


	@Override
	public void onCreate(){
		super.onCreate();

		if (LeakCanary.isInAnalyzerProcess(this)) {
			// This process is dedicated to LeakCanary for heap analysis.
			// You should not init your app in this process.
			return;
		}
		LeakCanary.install(this);

		this.appComponent = DaggerAppComponent.builder().appModule(new AppModule(getApplicationContext())).build();
	}


	/**
	 * static access to {@link NearbyPlacesApplication}.
	 */
	public static NearbyPlacesApplication getNearbyPlacesApplication(@NonNull Context context){
		return ((NearbyPlacesApplication)context.getApplicationContext());
	}


	/**
	 * Return {@link AppComponent}.
	 */
	public AppComponent getAppComponent(){
		return appComponent;
	}


	/**
	 * Create and return {@link ApiComponent}.
	 */
	public ApiComponent getApiComponent(){
		return DaggerApiComponent.builder().appComponent(appComponent).apiModule(new ApiModule()).build();
	}


}
