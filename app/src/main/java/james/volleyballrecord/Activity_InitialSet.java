package james.volleyballrecord;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import Struct.GameData;
import Struct.Player;
import fragment.Fragment_SetDate;


public class Activity_InitialSet extends Activity {


    private static final String TAG = Activity_InitialSet.class.getSimpleName();
    //GameData at set activity
    private GameData gameData_set;
    //Player Data at set activity
    private Player[] player_set;

    private boolean isToast = false;

    public boolean getToasted(){
        //check if it is the first time to toast
        return isToast;
    }

    public void setToasted(){
        //it was already toasted
        isToast = true;
    }

    public void initGame() {
        //Initialize the Game Data
        gameData_set = new GameData();
    }

    //Initialize player data
    public void initPlayer() {

        //Initial 12 player
        player_set = new Player[12];
        Player tmp;
        for(int i=0;i<12;i++) {
            tmp = new Player();
            player_set[i] = tmp;
        }

        //Set default player's number
//        for(int i=0;i<12;i++) {
//            player_set[i].SetNumber(String.valueOf(i));
//        }
    }

    //Get Game Data
    public GameData getGame() {
        return gameData_set;
    }
    //Get Player Data
    public Player[] getPlayer() {
        return player_set;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set content View
        setContentView(R.layout.activity_initial_set);

        if (savedInstanceState == null) {
            //Go to next fragment
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            Fragment fragment_SetDate = new Fragment_SetDate();
            //Add animation to go to and exit from help fragment
            fragmentTransaction.setCustomAnimations(0, 0
                            , R.animator.fragment_left_in, R.animator.fragment_right_out);
            fragmentTransaction.replace(R.id.container_set,fragment_SetDate);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        /*ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Information");
        }*/

        //Initialize Game Data
        initGame();
        //Initialize Player Data
        initPlayer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    //Previous Selected Player
    private int player_preSelected = 0;
    //Current Selected Player
    private int player_currentSelected;
    //Get Current Selected Player
    public int getPlayer_currentSelected() {
        return player_currentSelected;
    }
    //Get Previous Selected Player
    public int getPlayer_preSelected() {
        return player_preSelected;
    }


    //Function to change player picture
    public void set_player_function(View view) {

        //Player drawable (unselected & selected)
        Drawable drawable_player = getDrawable(R.drawable.player_1);
        Drawable drawable_player_selected = getDrawable(R.drawable.player_2);

        //Change picture to unselected
        if(player_preSelected != 0) {
            Button pre_player_button = (Button)findViewById(player_preSelected);
            pre_player_button.setBackground(drawable_player);
        }

        //Get clicked player
        int player_selected = view.getId();
        //Get Player Button by using button ID
        Button button_player_selected = (Button)findViewById(player_selected);

        //Initialize editText and other object
        EditText set_player_name = (EditText)findViewById(R.id.set_name);
        EditText set_player_number = (EditText)findViewById(R.id.set_number);
        Spinner set_player_spinner = (Spinner)findViewById(R.id.set_place_spinner);
        TextView textView_enter = (TextView)findViewById(R.id.set_enter);

        //Set Object to be visible
        set_player_name.setVisibility(View.VISIBLE);
        set_player_number.setVisibility(View.VISIBLE);
        set_player_spinner.setVisibility(View.VISIBLE);
        textView_enter.setVisibility(View.VISIBLE);

        //Set Object as clickable
        set_player_name.setClickable(true);
        set_player_number.setClickable(true);
        set_player_spinner.setClickable(true);
        textView_enter.setClickable(true);


        //Change player picture based on clicked or not
        switch (player_selected) {
            case R.id.set_player_1_data:
                button_player_selected.setBackground(drawable_player_selected);
                player_currentSelected = 0;
                break;
            case R.id.set_player_2_data:
                button_player_selected.setBackground(drawable_player_selected);
                player_currentSelected = 1;
                break;
            case R.id.set_player_3_data:
                button_player_selected.setBackground(drawable_player_selected);
                player_currentSelected = 2;
                break;
            case R.id.set_player_4_data:
                button_player_selected.setBackground(drawable_player_selected);
                player_currentSelected = 3;
                break;
            case R.id.set_player_5_data:
                button_player_selected.setBackground(drawable_player_selected);
                player_currentSelected = 4;
                break;
            case R.id.set_player_6_data:
                button_player_selected.setBackground(drawable_player_selected);
                player_currentSelected = 5;
                break;
        }
        player_preSelected = player_selected;

        //Change player name and number
//        set_player_name.setText(player_set[player_currentSelected].GetName());
//        set_player_number.setText(player_set[player_currentSelected].GetNumber());
    }


    @Override
    public void onBackPressed() {

        //Check if this is the only fragment
        if(getFragmentManager().getBackStackEntryCount() == 1){
            //Go back to AppMenu
            Intent intent = new Intent();
            intent.setClass(this, Activity_AppMenu.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_game_playing",false);
            intent.putExtras(bundle);
            startActivity(intent);
            this.finish();

            this.overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        else {
            //Go back to previous fragment
            getFragmentManager().popBackStack();
        }
    }
}
