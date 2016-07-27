package james.volleyballrecord;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
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


public class MainMenu extends Activity {

    private boolean MainMenu_is_Game_Playing = false;

    private DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getIntent().getExtras();
        MainMenu_is_Game_Playing = bundle.getBoolean("is_game_playing");

        setContentView(R.layout.activity_menu);
        dataBaseHelper = new DataBaseHelper(this);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container_menu, new PlaceholderFragment()).commit();
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Typeface font = Typeface.createFromAsset(getResources().getAssets(),"fonts/Roboto-BlackItalic.ttf");

        TextView headline = (TextView)findViewById(R.id.mainmenu_headline);
        headline.setTypeface(font);
        Button button_start = (Button)findViewById(R.id.mainmenu_startbutton);
        button_start.setTypeface(font);
        Button button_continue = (Button)findViewById(R.id.mainmenu_continuebutton);
        button_continue.setTypeface(font);
        Button button_record = (Button)findViewById(R.id.mainmenu_recordbutton);
        button_record.setTypeface(font);
        Button button_exit = (Button)findViewById(R.id.mainmenu_exitbutton);
        button_exit.setTypeface(font);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w("Start","On_clicked");

                Intent intent_start = new Intent();
                intent_start.setClass(MainMenu.this,InitialSet.class);

                MainMenu.this.finish();

                startActivity(intent_start);
                MainMenu.this.overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w("Continue","On_clicked");

                if(!MainMenu_is_Game_Playing)
                {
                    Toast.makeText(MainMenu.this,"There are no game playing",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent_play_game = new Intent();
                    intent_play_game.setClass(MainMenu.this,PlayGame.class);
                    MainMenu.this.finish();

                    startActivity(intent_play_game);
                    MainMenu.this.overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });

        button_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w("Record","On_clicked");
//                dataBaseHelper.getGameALl(1);
                Intent intent_record = new Intent();
                Bundle bundle_record = new Bundle();
                bundle_record.putBoolean("is_game_playing",MainMenu_is_Game_Playing);
                intent_record.putExtras(bundle_record);
                intent_record.setClass(MainMenu.this,Record.class);
                MainMenu.this.finish();

                startActivity(intent_record);
                MainMenu.this.overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper.deleteTable();
//                dataBaseHelper.deleteTableAll();
                MainMenu.this.finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

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
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            this.finish();
        }
        return false;
    }
}
