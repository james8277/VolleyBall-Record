package james.volleyballrecord;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import Struct.GameData;
import Struct.Player;
import fragment.DateSet;


public class InitialSet extends Activity {

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
        setContentView(R.layout.activity_initial_set);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container_set, new DateSet()).commit();
        }
        /*ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Information");
        }*/

        initGame();
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


    private int pre_set_player_chooice = 0;
    private int player_set_current;
    public int get_set_player_chooice()
    {
        return player_set_current;
    }
    public int getPre_set_player_chooice_id()
    {
        return pre_set_player_chooice;
    }


    public void set_player_function(View view)
    {
        Resources res = this.getResources();
        Drawable tmp_photo = res.getDrawable(R.drawable.player_1);
        Drawable tmp_photo_2 = res.getDrawable(R.drawable.player_2);

        if(pre_set_player_chooice != 0)
        {
            Button pre_player_button = (Button)findViewById(pre_set_player_chooice);
            pre_player_button.setBackground(tmp_photo);
        }

        int player_chooice = view.getId();
//        Log.w("view id", Integer.toString(player_chooice));
        Button button_player_chooice;
        button_player_chooice = (Button)findViewById(player_chooice);

        EditText set_player_name = (EditText)findViewById(R.id.set_name);
        EditText set_player_number = (EditText)findViewById(R.id.set_number);
        Spinner set_player_spinner = (Spinner)findViewById(R.id.set_place_spinner);
        TextView textView_enter = (TextView)findViewById(R.id.set_enter);

        set_player_name.setVisibility(View.VISIBLE);
        set_player_number.setVisibility(View.VISIBLE);
        set_player_spinner.setVisibility(View.VISIBLE);
        textView_enter.setVisibility(View.VISIBLE);

        set_player_name.setClickable(true);
        set_player_number.setClickable(true);
        set_player_spinner.setClickable(true);
        textView_enter.setClickable(true);


        switch (player_chooice)
        {
            case R.id.set_player_1_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 0;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_player_2_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 1;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_player_3_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 2;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_player_4_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 3;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_player_5_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 4;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_player_6_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 5;
                pre_set_player_chooice = player_chooice;
                break;
        }

        set_player_name.setText(player_set[player_set_current].GetName());
        set_player_number.setText(player_set[player_set_current].GetNumber());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent();
            intent.setClass(this,MainMenu.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_game_playing",false);
            intent.putExtras(bundle);
            startActivity(intent);
            this.finish();

            this.overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        return false;
    }
}
