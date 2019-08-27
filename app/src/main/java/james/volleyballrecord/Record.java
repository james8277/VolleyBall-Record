package james.volleyballrecord;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

import fragment.RecordAllGame;
import fragment.RecordPlayerData;


public class Record extends Activity {

    private int select_game;
    public int Get_select_game()
    {
        return select_game;
    }
    public void Set_select_game(int x)
    {
        select_game = x;
    }
    private boolean is_game_playing_record;
    public boolean Get_is_game_playing()
    {
        return is_game_playing_record;
    }
    private int select_player;
    public int Get_select_player()
    {
        return select_player;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        Bundle bundle = this.getIntent().getExtras();
        is_game_playing_record = bundle.getBoolean("is_game_playing");

        FragmentTransaction mf = getFragmentManager().beginTransaction();
        Fragment fragment_record_all_game = new RecordAllGame();
        mf.replace(R.id.container_record,fragment_record_all_game);
        mf.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent();
            intent.setClass(this, Activity_AppMenu.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_game_playing",is_game_playing_record);
            intent.putExtras(bundle);
            startActivity(intent);
            this.finish();

            this.overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        return false;
    }

    public void record_player_function(View view) {
        int tmp_click_id = view.getId();
        FragmentTransaction mf = getFragmentManager().beginTransaction();
//        mf.setCustomAnimations(R.anim.fragment_right_in,R.anim.fragment_left_out);

        switch (tmp_click_id) {
            case R.id.record_player_0:
                select_player = 0;
                break;
            case R.id.record_player_1:
                select_player = 1;
                break;
            case R.id.record_player_2:
                select_player = 2;
                break;
            case R.id.record_player_3:
                select_player = 3;
                break;
            case R.id.record_player_4:
                select_player = 4;
                break;
            case R.id.record_player_5:
                select_player = 5;
                break;
            case R.id.record_player_6:
                select_player = 6;
                break;
            case R.id.record_player_7:
                select_player = 7;
                break;
            case R.id.record_player_8:
                select_player = 8;
                break;
            case R.id.record_player_9:
                select_player = 9;
                break;
            case R.id.record_player_10:
                select_player = 10;
                break;
            case R.id.record_player_11:
                select_player = 11;
                break;
        }
        Fragment fragment_all_player_data = new RecordPlayerData();
        mf.replace(R.id.container_record,fragment_all_player_data);
        mf.commit();
    }
}
