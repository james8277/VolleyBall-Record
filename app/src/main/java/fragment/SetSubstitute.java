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

import Struct.Games_playing;
import Struct.Player;
import james.volleyballrecord.DataBaseHelper;
import james.volleyballrecord.InitialSet;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class SetSubstitute extends Fragment {

    Games_playing game_set_sub;
    Player[] player_set_sub;
    int SubNumber;
    int LNumber;
    String[] Position = {"S", "L", "WS", "MB"};
    ArrayAdapter<String> sub_adapter;
    String place_tmp;
    private DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game_set_sub = ((InitialSet)getActivity()).GetGame();
        player_set_sub = ((InitialSet)getActivity()).GetPlayer();
        SubNumber = game_set_sub.GetSubNumber();
        LNumber = game_set_sub.GetLnumber();
        dataBaseHelper = new DataBaseHelper(getActivity());
        dataBaseHelper.deleteTable();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_set_substitute, container, false);

        final EditText sub_player_name_editText = (EditText)view.findViewById(R.id.set_sub_name);
        final EditText sub_player_number_editText = (EditText)view.findViewById(R.id.set_sub_number);
        Spinner sub_player_place_spinner = (Spinner)view.findViewById(R.id.set_sub_place);
        Button sub_player_button = (Button)view.findViewById(R.id.set_sub_button);
        sub_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Position);
        sub_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sub_player_place_spinner.setAdapter(sub_adapter);

        sub_player_place_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                place_tmp = Position[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        sub_player_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.w("Add","onClicked");
                Log.w(String.valueOf(SubNumber),"SubNumber");
                Log.w(String.valueOf(LNumber),"LNumber");

                if(SubNumber < 6)
                {
                    player_set_sub[SubNumber+6].SetName(sub_player_name_editText.getText().toString());
                    player_set_sub[SubNumber+6].SetNumber(sub_player_number_editText.getText().toString());
                    player_set_sub[SubNumber+6].SetPlace(place_tmp);
                    if(place_tmp == "L")
                    {
                        game_set_sub.SetLnumber();
                        game_set_sub.SetSubNumber();
                        SubNumber++;
                        LNumber++;
                    }
                    else
                    {
                        game_set_sub.SetSubNumber();
                        SubNumber++;
                    }
                    for(int i=0;i<SubNumber;i++)
                    {
                        TextView tmp;

                        switch (i)
                        {
                            case 0:
                                Log.w("player1", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_1_num);
                                tmp.setText(player_set_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_1_name);
                                tmp.setText(player_set_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_1_place);
                                tmp.setText(player_set_sub[i+6].GetPlace());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 1:
                                Log.w("player2", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_2_num);
                                tmp.setText(player_set_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_2_name);
                                tmp.setText(player_set_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_2_place);
                                tmp.setText(player_set_sub[i+6].GetPlace());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 2:
                                Log.w("player3", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_3_num);
                                tmp.setText(player_set_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_3_name);
                                tmp.setText(player_set_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_3_place);
                                tmp.setText(player_set_sub[i+6].GetPlace());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 3:
                                Log.w("player4", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_4_num);
                                tmp.setText(player_set_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_4_name);
                                tmp.setText(player_set_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_4_place);
                                tmp.setText(player_set_sub[i+6].GetPlace());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 4:
                                Log.w("player5", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_5_num);
                                tmp.setText(player_set_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_5_name);
                                tmp.setText(player_set_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_5_place);
                                tmp.setText(player_set_sub[i+6].GetPlace());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                            case 5:
                                Log.w("player6", "set");
                                tmp = (TextView)getActivity().findViewById(R.id.sub_6_num);
                                tmp.setText(player_set_sub[i+6].GetNumber());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_6_name);
                                tmp.setText(player_set_sub[i+6].GetName());
                                tmp.setVisibility(View.VISIBLE);
                                tmp = (TextView)getActivity().findViewById(R.id.sub_6_place);
                                tmp.setText(player_set_sub[i+6].GetPlace());
                                tmp.setVisibility(View.VISIBLE);
                                break;
                        }
                    }
                }
                else
                {
                    Toast.makeText(getActivity(),"You can't add more than 6 player.",Toast.LENGTH_SHORT).show();
                }

                sub_player_name_editText.setText("");
                sub_player_number_editText.setText("");
            }
        });

        Button button_sub_play = (Button)view.findViewById(R.id.set_sub_next);

        button_sub_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setClass(getActivity(), PlayGame.class);
                startActivity(intent);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.right_in, R.anim.left_out);

                dataBaseHelper.addDataTmp(game_set_sub,player_set_sub);
            }
        });

        return view;
    }

}
