package james.volleyballrecord;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainMenu extends Activity {

    //TAG Name
    private static final String TAG = MainMenu.class.getSimpleName();
    private boolean MainMenu_is_Game_Playing = false;

    private String[] languageArray;

    private DataBaseHelper dataBaseHelper;

    //Check if back button is pressed in 2 sec
    private boolean exitPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        languageArray = getResources().getStringArray(R.array.languageArray);

        //Setup bundle to get flag from other activity
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            MainMenu_is_Game_Playing = bundle.getBoolean("is_game_playing");
        }
        else{
            Log.e(TAG, "No Bundle");
        }

        //Setup content for this activity
        setContentView(R.layout.activity_menu);
        //Create new Database
        dataBaseHelper = new DataBaseHelper(this);

        if (savedInstanceState == null) {
            //Go to next view
            getFragmentManager().beginTransaction().add(R.id.container_menu, new PlaceholderFragment()).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Set font for the string
        Typeface font = Typeface.createFromAsset(getResources().getAssets(),"fonts/Roboto-BlackItalic.ttf");

        //Setup all resource
        TextView headline = (TextView)findViewById(R.id.mainmenu_headline);
        headline.setTypeface(font);
        Button button_start = (Button)findViewById(R.id.mainmenu_startbutton);
        button_start.setTypeface(font);
        Button button_continue = (Button)findViewById(R.id.mainmenu_continuebutton);
        button_continue.setTypeface(font);
        Button button_record = (Button)findViewById(R.id.mainmenu_recordbutton);
        button_record.setTypeface(font);
        Button button_help = (Button)findViewById(R.id.mainmenu_help);
        button_help.setTypeface(font);
        Button button_language = (Button)findViewById(R.id.mainmenu_language);
        button_language.setTypeface(font);
        Button button_exit = (Button)findViewById(R.id.mainmenu_exitbutton);
        button_exit.setTypeface(font);

        //Set start button listener
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w("Start","On_clicked");

                //Go to InitialSet activity
                Intent intent_start = new Intent();
                intent_start.setClass(MainMenu.this,InitialSet.class);
                //Finish this activity
                MainMenu.this.finish();
                //Start new activity
                startActivity(intent_start);
                //Set change activity animation
                MainMenu.this.overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        //Set continue button listener
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w("Continue","On_clicked");

                //Check if there is a game playing
                if(!MainMenu_is_Game_Playing) {
                    Toast.makeText(MainMenu.this, R.string.NoGamePlaying,Toast.LENGTH_SHORT).show();
                }
                else {
                    //Go to PlayGame activity
                    Intent intent_play_game = new Intent();
                    intent_play_game.setClass(MainMenu.this,PlayGame.class);
                    //Finish this activity
                    MainMenu.this.finish();
                    //Start new activity
                    startActivity(intent_play_game);
                    //Set change activity animation
                    MainMenu.this.overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });

        //Set help button listener
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Go to Help activity and setup bundle to save the flag is_game_playing
                Intent intent_help = new Intent();
                Bundle bundle_help = new Bundle();
                bundle_help.putBoolean("is_game_playing",MainMenu_is_Game_Playing);
                intent_help.putExtras(bundle_help);
                intent_help.setClass(MainMenu.this,Help.class);
                //Finish this activity
                MainMenu.this.finish();
                //Start new activity
                startActivity(intent_help);
                //Set change activity animation
                MainMenu.this.overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });


        //Set record button listener
        button_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w("Record","On_clicked");
//                dataBaseHelper.getGameALl(1);

                //Go to Record activity and setup bundle to save the flag is_game_playing
                Intent intent_record = new Intent();
                Bundle bundle_record = new Bundle();
                bundle_record.putBoolean("is_game_playing",MainMenu_is_Game_Playing);
                intent_record.putExtras(bundle_record);
                intent_record.setClass(MainMenu.this,Record.class);
                //Finish this activity
                MainMenu.this.finish();
                //Start new activity
                startActivity(intent_record);
                //Set change activity animation
                MainMenu.this.overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        button_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog languageDialog = new AlertDialog.Builder(MainMenu.this)
                        .setTitle(R.string.setLanguage)
                        .setItems(languageArray, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(!changeSetLanguage(i)){
                                    return;
                                }

                                SharedPreferences language = getSharedPreferences("VolleyBall Record", MODE_PRIVATE);
                                language.edit().putInt("Language",i).commit();

                                Intent intent = new Intent(MainMenu.this, ActivityStart.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                System.exit(0);
                            }
                        }).create();

                languageDialog.show();
            }
        });


        //Set exit button listener
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.deleteTable();
//                dataBaseHelper.deleteTableAll();
//              //Finish this activity'

                if(exitPressed){
                    MainMenu.this.finish();
                }
                exitPressed = true;

                Toast.makeText(MainMenu.this,R.string.exitToast,Toast.LENGTH_SHORT).show();

                //Handler to check back is pressed in 2 sec
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        exitPressed = false;
                    }
                },2000);
            }
        });
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
            return rootView;
        }
    }

    @Override
    public void onBackPressed() {

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

    private boolean changeSetLanguage(int language){

        //Get local language, default is Chinese
        int setLanguage = getSharedPreferences("VolleyBall Record",MODE_PRIVATE)
                .getInt("Language", 0);

        if(language == setLanguage){
            return false;
        }
        else {
            return true;
        }
    }
}
