package james.volleyballrecord;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;

import fragment.help;

public class Help extends Activity {

    private boolean is_game_playing_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Bundle bundle = this.getIntent().getExtras();
        is_game_playing_help = bundle.getBoolean("is_game_playing");

        FragmentTransaction mf = getFragmentManager().beginTransaction();
        Fragment fragment_help = new help();
        mf.replace(R.id.container_help,fragment_help);
        mf.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            Intent intent = new Intent();
            intent.setClass(this,MainMenu.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_game_playing",is_game_playing_help);
            intent.putExtras(bundle);
            startActivity(intent);
            this.finish();

            this.overridePendingTransition(R.anim.left_in, R.anim.right_out);
        }
        return false;
    }

}
