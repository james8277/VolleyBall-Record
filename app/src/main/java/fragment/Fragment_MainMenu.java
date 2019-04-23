package fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import james.volleyballrecord.Activity_Start;
import james.volleyballrecord.Activity_AppMenu;
import james.volleyballrecord.DataBaseHelper;
import james.volleyballrecord.Activity_InitialSet;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;
import james.volleyballrecord.Record;

public class Fragment_MainMenu extends Fragment {

    //TAG Name
    private static final String TAG = Fragment_MainMenu.class.getSimpleName();
    //Check if the Game is playing
    private boolean MainMenu_isGamePlaying = false;
    //Language array
    private String[] languageArray;
    //
    private DataBaseHelper dataBaseHelper_MainMenu;
    //
    private boolean isExitPressed = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Language array
        languageArray = getResources().getStringArray(R.array.languageArray);
        //Get boolean
        MainMenu_isGamePlaying = ((Activity_AppMenu)getActivity()).isMenu_isGamePlaying();

        dataBaseHelper_MainMenu = ((Activity_AppMenu)getActivity()).getDataBaseHelper();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        //Set font for the string
        final Typeface font = Typeface.createFromAsset(getResources().getAssets(),"fonts/Roboto-BlackItalic.ttf");

        //Setup all resource
        TextView headline = (TextView)rootView.findViewById(R.id.mainmenu_headline);
        headline.setTypeface(font);
        Button button_start = (Button)rootView.findViewById(R.id.mainmenu_startbutton);
        button_start.setTypeface(font);
        Button button_continue = (Button)rootView.findViewById(R.id.mainmenu_continuebutton);
        button_continue.setTypeface(font);
        Button button_record = (Button)rootView.findViewById(R.id.mainmenu_recordbutton);
        button_record.setTypeface(font);
        Button button_help = (Button)rootView.findViewById(R.id.mainmenu_help);
        button_help.setTypeface(font);
        Button button_language = (Button)rootView.findViewById(R.id.mainmenu_language);
        button_language.setTypeface(font);
        Button button_exit = (Button)rootView.findViewById(R.id.mainmenu_exitbutton);
        button_exit.setTypeface(font);

        //Set start button listener
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w(TAG, "start clicked");

                //Go to InitialSet activity
                Intent intent_start = new Intent();
                intent_start.setClass(getActivity(), Activity_InitialSet.class);
                //Finish this activity
                getActivity().finish();
                //Start new activity
                startActivity(intent_start);
                //Set change activity animation
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        //Set continue button listener
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w(TAG,"continue clicked");

                //Check if there is a game playing
                if(!MainMenu_isGamePlaying) {
                    Toast.makeText(getActivity(), R.string.NoGamePlaying,Toast.LENGTH_SHORT).show();
                }
                else {
                    //Go to PlayGame activity
                    Intent intent_play_game = new Intent();
                    intent_play_game.setClass(getActivity(), PlayGame.class);
                    //Finish this activity
                    getActivity().finish();
                    //Start new activity
                    startActivity(intent_play_game);
                    //Set change activity animation
                    getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
                }
            }
        });

        //Set help button listener
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w(TAG,"help clicked");

                //Going to Fragment Help
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Fragment fragment_help = new Fragment_Help();
                //Add animation to go to and exit from help fragment
                fragmentTransaction.setCustomAnimations(R.animator.fragment_right_in, R.animator.fragment_left_out
                                                        , R.animator.fragment_left_in, R.animator.fragment_right_out);
                fragmentTransaction.replace(R.id.container_menu, fragment_help);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        //Set record button listener
        button_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w(TAG,"record clicked");

                //Go to Record activity and setup bundle to save the flag is_game_playing
                Intent intent_record = new Intent();
                Bundle bundle_record = new Bundle();
                bundle_record.putBoolean("is_game_playing",MainMenu_isGamePlaying);
                intent_record.putExtras(bundle_record);
                intent_record.setClass(getActivity(), Record.class);
                //Finish this activity
                getActivity().finish();
                //Start new activity
                startActivity(intent_record);
                //Set change activity animation
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        //Set language in App
        button_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Show a dialog to let user set language
                AlertDialog languageDialog = new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.setLanguage)
                        .setItems(languageArray, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                //Check if selected language is different previous
                                if(!changeSetLanguage(i)){
                                    return;
                                }
                                //Save language data for furture use
                                SharedPreferences language = getActivity().getSharedPreferences("VolleyBall Record", Context.MODE_PRIVATE);
                                //Save new selected language, apply may not complete before app restart
                                language.edit().putInt("Language",i).commit();

                                //New activity to refresh the App language
                                Intent intent = new Intent(getActivity(), Activity_Start.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                //Finish this activity
                                getActivity().finish();
                                //Restart activity Without using any animation
                                getActivity().overridePendingTransition( 0, 0);
                                startActivity(intent);
                            }
                        }).create();

                languageDialog.show();
            }
        });


        //Set exit button listener
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataBaseHelper_MainMenu.deleteTable();
//                dataBaseHelper.deleteTableAll();
//              //Finish this activity'

                if(isExitPressed){
                    getActivity().finish();
                }
                isExitPressed = true;

                Toast.makeText(getActivity(),R.string.exitToast,Toast.LENGTH_SHORT).show();

                //Handler to check back is pressed in 2 sec
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExitPressed = false;
                    }
                },2000);
            }
        });


        return rootView;
    }

    //
    private boolean changeSetLanguage(int language){

        //Get local language, default is Chinese
        int setLanguage = getActivity().getSharedPreferences("VolleyBall Record",Context.MODE_PRIVATE)
                .getInt("Language", 0);

        if(language == setLanguage){
            return false;
        }
        else {
            return true;
        }
    }

}
