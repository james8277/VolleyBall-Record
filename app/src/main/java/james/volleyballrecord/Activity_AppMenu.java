package james.volleyballrecord;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import fragment.Fragment_MainMenu;


public class Activity_AppMenu extends Activity {

    //TAG Name
    private static final String TAG = Activity_AppMenu.class.getSimpleName();
    //Check if the game is playing
    private boolean AppMenu_isGamePlaying = false;
    //
    private DataBaseHelper dataBaseHelper;
    //Check if back button is pressed in 2 sec
    private boolean exitPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setup bundle to get flag from other activity
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            AppMenu_isGamePlaying = bundle.getBoolean("is_game_playing");
        }
        else{
            Log.e(TAG, "No Bundle");
        }

        //Setup content for this activity
        setContentView(R.layout.activity_menu);
        //Create new Database
        dataBaseHelper = new DataBaseHelper(this);

        if (savedInstanceState == null) {
            //Go to MainMenu Fragment
            Fragment fragment_MainMenu = new Fragment_MainMenu();
            getFragmentManager().beginTransaction().add(R.id.container_menu, fragment_MainMenu).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public boolean isMenu_isGamePlaying() {
        return AppMenu_isGamePlaying;
    }

    public DataBaseHelper getDataBaseHelper() {
        return dataBaseHelper;
    }

    //Setup top-right setting button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    //Selected item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if(getFragmentManager().getBackStackEntryCount() == 0){
            if(exitPressed){
                super.onBackPressed();
                return;
            }

            exitPressed = true;
            Toast.makeText(this,R.string.exitToast,Toast.LENGTH_SHORT).show();

            //Handler to check back is pressed in 2 sec
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exitPressed = false;
                }
            },2000);
        }
        else {
            Log.w(TAG, "Help back pressed");
            getFragmentManager().popBackStack();
        }
    }


}
