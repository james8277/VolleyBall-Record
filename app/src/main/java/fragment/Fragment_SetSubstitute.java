package fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import java.util.Objects;

import Struct.GameData;
import Struct.Player;
import james.volleyballrecord.Activity_InitialSet;
import james.volleyballrecord.DataBaseHelper;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class Fragment_SetSubstitute extends Fragment {

    //Game Data
    private GameData gameData_sub;
    //Player Data
    private Player[] playerData_sub;
    //Count of sub player
    private int subPlayerCount;
    //Count of L player
    private int lCount;
    //Position array
    private String[] position;
    //Adapter for player's place
    private ArrayAdapter<String> positionAdapter;
    //Selected Place for player
    private String playerPosition;
    //DataBase
    private DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get Game data from activity
        gameData_sub = ((Activity_InitialSet)getActivity()).getGame();
        //Get Player data from activity
        playerData_sub = ((Activity_InitialSet)getActivity()).getPlayer();
        //Get Sub count
        subPlayerCount = gameData_sub.getSubCount();
        //Get L count
        lCount = gameData_sub.getLCount();
        //Create Database
        dataBaseHelper = new DataBaseHelper(getActivity());
        dataBaseHelper.deleteTable();

        //Initialize position array
        position = new String[4];
        position[0] = getString(R.string.S);
        position[1] = getString(R.string.MB);
        position[2] = getString(R.string.WS);
        position[3] = getString(R.string.L);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_set_substitute, container, false);

        //EditText for input the sub player's name and number
        final EditText editText_subPlayerName = (EditText)rootView.findViewById(R.id.set_sub_name);
        final EditText editText_subPlayerNumber = (EditText)rootView.findViewById(R.id.set_sub_number);
        //Spinner for sub Player's position
        Spinner spinner_subPlayerPosition = (Spinner)rootView.findViewById(R.id.set_sub_position);
        //Button for adding sub player
        Button button_addSubPlayer = (Button)rootView.findViewById(R.id.add_sub_button);
        //Setup position adapter
        positionAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, position);
        //Set adapter style
        positionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //setup adapter for spinner
        spinner_subPlayerPosition.setAdapter(positionAdapter);
        //Get player position every time it change
        spinner_subPlayerPosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                playerPosition = position[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Add Sub player
        button_addSubPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("Add","onClicked");
                Log.e(String.valueOf(subPlayerCount),"SubNumber");
                Log.e(String.valueOf(lCount),"LNumber");

                //Check if the sub player is less than 6 and if player's number is null ""
                if(subPlayerCount < 6 && !Objects.equals(editText_subPlayerNumber.getText().toString(), "")) {
                    //Add sub player into Player array
                    playerData_sub[subPlayerCount+6].SetName(editText_subPlayerName.getText().toString());
                    playerData_sub[subPlayerCount+6].SetNumber(editText_subPlayerNumber.getText().toString());
                    playerData_sub[subPlayerCount+6].SetPosition(playerPosition);
                    //Check if the sub player is L
                    if(playerPosition == "L") {
                        //Add L and Sub player count
                        gameData_sub.setLCount();
                        gameData_sub.setSubCount();
                        subPlayerCount++;
                        lCount++;
                    }
                    else {
                        //Add Sub player count
                        gameData_sub.setSubCount();
                        subPlayerCount++;
                    }

                    for(int i=0;i<subPlayerCount;i++) {

                        //TextView for setting all sub player's data
                        TextView tmp;

                        //Set all sub player's name, number and position
                        switch (i) {
                            case 0:
                                Log.w("player1", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_1_num);
                                tmp.setText(playerData_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_1_name);
                                tmp.setText(playerData_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_1_position);
                                tmp.setText(playerData_sub[i+6].GetPosition());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 1:
                                Log.w("player2", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_2_num);
                                tmp.setText(playerData_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_2_name);
                                tmp.setText(playerData_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_2_position);
                                tmp.setText(playerData_sub[i+6].GetPosition());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 2:
                                Log.w("player3", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_3_num);
                                tmp.setText(playerData_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_3_name);
                                tmp.setText(playerData_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_3_position);
                                tmp.setText(playerData_sub[i+6].GetPosition());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 3:
                                Log.w("player4", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_4_num);
                                tmp.setText(playerData_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_4_name);
                                tmp.setText(playerData_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_4_position);
                                tmp.setText(playerData_sub[i+6].GetPosition());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 4:
                                Log.w("player5", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_5_num);
                                tmp.setText(playerData_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_5_name);
                                tmp.setText(playerData_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_5_position);
                                tmp.setText(playerData_sub[i+6].GetPosition());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 5:
                                Log.w("player6", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_6_num);
                                tmp.setText(playerData_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_6_name);
                                tmp.setText(playerData_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_6_position);
                                tmp.setText(playerData_sub[i+6].GetPosition());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                        }
                    }
                }
                //If user didn't enter player's number
                else if(Objects.equals(editText_subPlayerNumber.getText().toString(), "")) {
                    Toast.makeText(getActivity(),R.string.set_sub_number_confirm,Toast.LENGTH_LONG).show();
                }
                //Sub player can't not be larger than 6
                else {
                    Toast.makeText(getActivity(),R.string.set_sub_player_confirm,Toast.LENGTH_SHORT).show();
                }
                //Reset the EditText
                editText_subPlayerName.setText("");
                editText_subPlayerNumber.setText("");
            }
        });

        //Button to start to record game
        Button button_sub_play = (Button)rootView.findViewById(R.id.set_sub_play);
        button_sub_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to next activity
                Intent intent = new Intent();
                intent.setClass(getActivity(), PlayGame.class);
                startActivity(intent);
                getActivity().finish();
                //Add animation
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);
                //Add temp database
                dataBaseHelper.addDataTmp(gameData_sub,playerData_sub);
            }
        });

        return rootView;
    }

}
