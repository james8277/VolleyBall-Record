package james.volleyballrecord;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import Struct.Games_playing;
import Struct.Player;
import event.Attack;
import event.Block;
import event.Change;
import event.Defence;
import event.Serve;
import event.Set;
import fragment.Start;


public class PlayGame extends Activity {

    private boolean start_event_chooice = false;
    private boolean start_player_chooice = false;
    private int start_pre_player_chooice = R.id.start_player_1;
    private int start_player_chooice_next;
    DataBaseHelper dataBaseHelper;
    private boolean is_Initial_Set = false;


    private int pre_set_player_chooice = 0;
    private int player_set_current;

    Player[] players_play_game;
    Games_playing game_play_game;

    private int play_round = 0;

    public int GetRound()
    {
        return  play_round;
    }

    public Games_playing GetGame_play_game()
    {
        return game_play_game;
    }
    public Player[] GetPlayers_play_game()
    {
        return players_play_game;
    }
    public int GetPlayer_chooice()
    {
        return start_player_chooice_next;
    }
    public void SetRound()
    {
        play_round++;
    }
    public void SetPlayer_Chooice()
    {
        start_player_chooice = false;
    }



    public int get_set_2_player_chooice()
    {
        return player_set_current;
    }
    public int get_pre_set_player()
    {
        return pre_set_player_chooice;
    }
    public void set_2_player_function(View view)
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
        Button button_player_chooice;
        button_player_chooice = (Button)findViewById(player_chooice);

        Spinner set_player_spinner = (Spinner)findViewById(R.id.set_2_place_spinner);
        TextView textView_enter = (TextView)findViewById(R.id.set_2_enter);

        set_player_spinner.setVisibility(View.VISIBLE);
        textView_enter.setVisibility(View.VISIBLE);

        set_player_spinner.setClickable(true);
        textView_enter.setClickable(true);

        switch (player_chooice)
        {
            case R.id.set_2_player_1_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 0;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_2_player_2_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 1;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_2_player_3_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 2;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_2_player_4_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 3;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_2_player_5_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 4;
                pre_set_player_chooice = player_chooice;
                break;
            case R.id.set_2_player_6_data:
                button_player_chooice.setBackground(tmp_photo_2);
                player_set_current = 5;
                pre_set_player_chooice = player_chooice;
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        dataBaseHelper = new DataBaseHelper(this);

        if (!is_Initial_Set)
        {
            game_play_game = dataBaseHelper.getGameTmp();
            players_play_game = dataBaseHelper.getPlayerTmp();
//            is_Initial_Set = true;
//            Log.w("play_game_initial_set",String.valueOf(is_Initial_Set));

            dataBaseHelper.deleteTable();
        }

        FragmentTransaction mf = getFragmentManager().beginTransaction();
        Fragment fragment_start = new Start();
        mf.replace(R.id.container_play,fragment_start);
        mf.commit();


//        Log.w("player_sub_0_number_play_game",players_play_game[6].GetNumber());

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

    public void start_player_function(View view)
    {
        Resources res = this.getResources();
        Drawable tmp_photo = res.getDrawable(R.drawable.player_1);
        Drawable tmp_photo_2 = res.getDrawable(R.drawable.player_2);

        if(!start_event_chooice)
        {
            Button button_player_before = (Button)findViewById(start_pre_player_chooice);
            button_player_before.setBackground(tmp_photo);

            int player_current_id = view.getId();
            Button button_player_current = (Button)findViewById(player_current_id);

            switch (player_current_id)
            {
                case R.id.start_player_1:
                    button_player_current.setBackground(tmp_photo_2);
                    start_player_chooice = true;
                    start_player_chooice_next = 1;
                    start_pre_player_chooice = player_current_id;
                    break;
                case R.id.start_player_2:
                    button_player_current.setBackground(tmp_photo_2);
                    start_player_chooice = true;
                    start_player_chooice_next = 2;
                    start_pre_player_chooice = player_current_id;
                    break;
                case R.id.start_player_3:
                    button_player_current.setBackground(tmp_photo_2);
                    start_player_chooice = true;
                    start_player_chooice_next = 3;
                    start_pre_player_chooice = player_current_id;
                    break;
                case R.id.start_player_4:
                    button_player_current.setBackground(tmp_photo_2);
                    start_player_chooice = true;
                    start_player_chooice_next = 4;
                    start_pre_player_chooice = player_current_id;
                    break;
                case R.id.start_player_5:
                    button_player_current.setBackground(tmp_photo_2);
                    start_player_chooice = true;
                    start_player_chooice_next = 5;
                    start_pre_player_chooice = player_current_id;
                    break;
                case R.id.start_player_6:
                    button_player_current.setBackground(tmp_photo_2);
                    start_player_chooice = true;
                    start_player_chooice_next = 6;
                    start_pre_player_chooice = player_current_id;
                    break;
            }
        }

//        Log.w("start_player_chooice",String.valueOf(start_player_chooice));
    }
    TextView textView_lchange;

    public void start_event_function(View view)
    {
        int start_event_current_id = view.getId();
        FragmentTransaction mf = getFragmentManager().beginTransaction();


//        if (start_player_chooice_next == 1 || start_player_chooice_next == 5 || start_player_chooice_next == 6)
//        {
//            TextView textView_lchange = (TextView)findViewById(R.id.start_lchange);
//            textView_lchange.setVisibility(View.VISIBLE);
//            textView_lchange.setClickable(true);
//        }

        if(start_player_chooice)
        {
            switch (start_event_current_id)
            {
                case R.id.start_attack:
                    Fragment start_fragment_attack = new Attack();
                    mf.replace(R.id.container_play, start_fragment_attack);
                    mf.commit();
                    break;
                case R.id.start_defence:
                    Fragment start_fragment_defence = new Defence();
                    mf.replace(R.id.container_play,start_fragment_defence);
                    mf.commit();
                    break;
                case R.id.start_set:
                    Fragment start_fragment_set = new Set();
                    mf.replace(R.id.container_play,start_fragment_set);
                    mf.commit();
                    break;
                case R.id.start_serve:
                    Fragment start_fragment_serve = new Serve();
                    mf.replace(R.id.container_play,start_fragment_serve);
                    mf.commit();
                    break;
                case R.id.start_block:
                    Fragment start_fragment_block = new Block();
                    mf.replace(R.id.container_play,start_fragment_block);
                    mf.commit();
                    break;
                case R.id.start_change:
                    Fragment start_fragment_change = new Change();
                    mf.replace(R.id.container_play,start_fragment_change);
                    mf.commit();
                    break;
//                case R.id.start_lchange:
//                    Fragment start_fragment_lchange = new LChange();
//                    mf.replace(R.id.container_play,start_fragment_lchange);
//                    mf.commit();
//                    textView_lchange.setClickable(false);
//                    textView_lchange.setVisibility(View.INVISIBLE);
//                    break;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent();
            intent.setClass(this,MainMenu.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_game_playing",true);
            intent.putExtras(bundle);
            startActivity(intent);
            this.finish();

            dataBaseHelper.addDataTmp(game_play_game,players_play_game);
            this.overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        return false;
    }

    public void rotate(Player[] x)
    {
        Player tmp;
        tmp = x[0];

        for(int i=0;i<5;i++)
        {
            x[i] = x[i+1];
        }
        x[5] = tmp;
    }

    public void rerotate(Player[] x)
    {
        Player tmp;
        tmp = x[5];

        for(int i=5;i>0;i--)
        {
            x[i] = x[i-1];
        }
        x[0] = tmp;
    }
}
