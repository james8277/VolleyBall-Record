package fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import Struct.Player;
import james.volleyballrecord.Activity_InitialSet;
import james.volleyballrecord.R;

public class Fragment_SetPlayer extends Fragment {

    private static final String TAG = Fragment_SetPlayer.class.getSimpleName();

    //Player Data
    private Player[] player_setPlayer;
    //Position Array
    private String[] position;
    //Player place
    private String playerPlace;
    //Current selected player
    private int currentSelectedPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Player Data from activity
        player_setPlayer = ((Activity_InitialSet)getActivity()).getPlayer();

        //Initialize position array
        position = new String[4];
        position[0] = getString(R.string.S);
        position[1] = getString(R.string.MB);
        position[2] = getString(R.string.WS);
        position[3] = getString(R.string.L);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);

        final View rootView = inflater.inflate(R.layout.fragment_set_player, container, false);

        //If this is the first time go into this activity
        if(!((Activity_InitialSet)getActivity()).getToasted()) {
            Toast.makeText(getActivity(),R.string.click_player,Toast.LENGTH_SHORT).show();
            ((Activity_InitialSet)getActivity()).setToasted();
        }

        //Set Player number
        TextView player_number_name_1 = (TextView)rootView.findViewById(R.id.set_player_number_1);
        TextView player_number_name_2 = (TextView)rootView.findViewById(R.id.set_player_number_2);
        TextView player_number_name_3 = (TextView)rootView.findViewById(R.id.set_player_number_3);
        TextView player_number_name_4 = (TextView)rootView.findViewById(R.id.set_player_number_4);
        TextView player_number_name_5 = (TextView)rootView.findViewById(R.id.set_player_number_5);
        TextView player_number_name_6 = (TextView)rootView.findViewById(R.id.set_player_number_6);

        player_number_name_1.setText(player_setPlayer[0].getNumber());
        player_number_name_2.setText(player_setPlayer[1].getNumber());
        player_number_name_3.setText(player_setPlayer[2].getNumber());
        player_number_name_4.setText(player_setPlayer[3].getNumber());
        player_number_name_5.setText(player_setPlayer[4].getNumber());
        player_number_name_6.setText(player_setPlayer[5].getNumber());

        //Spinner for player place
        final Spinner place_spinner = (Spinner)rootView.findViewById(R.id.set_place_spinner);
        //Adapter for player spinner
        ArrayAdapter<String> placeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, position);
        placeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        place_spinner.setAdapter(placeAdapter);

        //Get Selected place from spinner
        place_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                playerPlace = position[arg2];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //Player picture
        final Drawable drawable_player = getActivity().getDrawable(R.drawable.player_1);

        //Initialize enter TextView
        TextView textView_enter = (TextView)rootView.findViewById(R.id.set_enter);
        textView_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_1) {

//                Log.e(TAG, "Enter Clicked");

                //Get Object for input player data
                EditText set_player_name = (EditText)rootView.findViewById(R.id.set_name);
                EditText set_player_number = (EditText)rootView.findViewById(R.id.set_number);

                //Get current selected player
                currentSelectedPlayer = ((Activity_InitialSet)getActivity()).getPlayer_currentSelected();

                //Update player data
                player_setPlayer[currentSelectedPlayer].setPosition(playerPlace);
                player_setPlayer[currentSelectedPlayer].setName(set_player_name.getText().toString());
                player_setPlayer[currentSelectedPlayer].setNumber(set_player_number.getText().toString());

//                Log.e(TAG, set_player_number.getText().toString());

                //Get selected player's textView ID
                TextView textView_playerNumber;
                switch (currentSelectedPlayer){
                    case 0:
                        textView_playerNumber = (TextView)rootView.findViewById(R.id.set_player_number_1);
                        break;
                    case 1:
                        textView_playerNumber = (TextView)rootView.findViewById(R.id.set_player_number_2);
                        break;
                    case 2:
                        textView_playerNumber = (TextView)rootView.findViewById(R.id.set_player_number_3);
                        break;
                    case 3:
                        textView_playerNumber = (TextView)rootView.findViewById(R.id.set_player_number_4);
                        break;
                    case 4:
                        textView_playerNumber = (TextView)rootView.findViewById(R.id.set_player_number_5);
                        break;
                    default:
                        textView_playerNumber = (TextView)rootView.findViewById(R.id.set_player_number_6);
                        break;
                }
                //Change selected player's number
                textView_playerNumber.setText(set_player_number.getText().toString());

                //Set All Object to Invisible
                set_player_name.setVisibility(View.INVISIBLE);
                set_player_number.setVisibility(View.INVISIBLE);
                place_spinner.setVisibility(View.INVISIBLE);

                //Reset player name and number
                set_player_name.setText("");
                set_player_number.setText("");

                //Reset object to not clickable
                set_player_name.setClickable(false);
                set_player_number.setClickable(false);
                place_spinner.setClickable(false);

                //Reset player picture as unselected
                int tmp = ((Activity_InitialSet)getActivity()).getPlayer_preSelected();
                Button button_enter = (Button)rootView.findViewById(tmp);
                button_enter.setBackground(drawable_player);
            }
        });

        //Button for going to next fragment (Set substitute)
        Button button_next = (Button)rootView.findViewById(R.id.set_date_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to next fragment
                FragmentTransaction mf = getFragmentManager().beginTransaction();
                mf.setCustomAnimations(R.animator.fragment_right_in,R.animator.fragment_left_out);
                Fragment fragment_setSubstitute = new Fragment_SetSubstitute();
                mf.replace(R.id.container_set, fragment_setSubstitute);
                mf.commit();
            }
        });


        return rootView;
    }
}
