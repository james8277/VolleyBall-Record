package james.volleyballrecord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;


public class ActivityStart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        intent.setClass(this, MainMenu.class);
        //Setup bundle to set is_game_playing as false
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_game_playing",false);
        intent.putExtras(bundle);
        //Start new activity
        startActivity(intent);

        Log.w("Activity_Start", "finished");

        //Finish this activity
        this.finish();
    }

}
