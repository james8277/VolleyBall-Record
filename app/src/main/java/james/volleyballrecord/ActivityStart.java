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
        setContentView(R.layout.activity_activity_start);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        Log.w("windows_size", metrics.widthPixels + " X " + metrics.heightPixels);

        Intent intent = new Intent();
        intent.setClass(this, MainMenu.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_game_playing",false);
        intent.putExtras(bundle);
        startActivity(intent);
        Log.w("Activity_Start", "finished");
        this.finish();
    }

}
