package james.volleyballrecord;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.Locale;


public class Activity_Start extends Activity {

    private static final String TAG = Activity_Start.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set Language
        changeSetLanguage();

        //Setup the content of first activity
        setContentView(R.layout.activity_activity_start);

        //DisplayMetric for the device
        DisplayMetrics metrics = new DisplayMetrics();
        //Get the Metric of the device
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.w("windows_size", metrics.widthPixels + " X " + metrics.heightPixels);

        //Setup intent to go to next activity
        Intent intent = new Intent();
        //Go to MainMenu activity
        intent.setClass(this, Activity_AppMenu.class);
        //Setup bundle to set is_game_playing as false
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_game_playing",false);
        intent.putExtras(bundle);
        //Start new activity
        startActivity(intent);

        Log.w(TAG, "finished");

        //Finish this activity
        this.finish();
    }

    private void changeSetLanguage(){

        //Get local language, default is Chinese
        int setLanguage = getSharedPreferences("VolleyBall Record",MODE_PRIVATE)
                .getInt("Language", 0);

//        Log.e(TAG, "language = " + setLanguage);

        Configuration configuration =    getBaseContext().getResources().getConfiguration();

        switch (setLanguage){
            case 0:
                configuration.setLocale(Locale.TRADITIONAL_CHINESE);
                break;
            case 1:
                configuration.setLocale(Locale.ENGLISH);
                break;
        }

        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
//        getBaseContext().createConfigurationContext(configuration);
    }

}
