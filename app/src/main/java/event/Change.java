package event;

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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import Struct.Games_playing;
import Struct.Player;
import fragment.Start;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class Change extends Fragment {

    Games_playing games_change;
    Player[] player_change;
    private int change_round;
    private int change_chooice;
    String number_tmp;

    String[] player_list_change;
    private int subNumber_change;

    String tmp_change;
    int sub_chooice = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        games_change = ((PlayGame)getActivity()).GetGame_play_game();
        player_change = ((PlayGame)getActivity()).GetPlayers_play_game();
        change_round = ((PlayGame)getActivity()).GetRound();
        change_chooice = ((PlayGame)getActivity()).GetPlayer_chooice();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_change, container, false);

        TextView textView_blue_name = (TextView)view.findViewById(R.id.change_blue_name);
        textView_blue_name.setText(games_change.GetBlueName());
        TextView textView_red_name = (TextView)view.findViewById(R.id.change_red_name);
        textView_red_name.setText(games_change.GetRedName());

        TextView textView_change_blue_score = (TextView)view.findViewById(R.id.change_blue_score);
        TextView textView_change_red_score = (TextView)view.findViewById(R.id.change_red_score);
        textView_change_blue_score.setText(String.valueOf(games_change.GetBlueScore()));
        textView_change_red_score.setText(String.valueOf(games_change.GetRedScore()));

        TextView textView_BlueSet = (TextView)view.findViewById(R.id.BlueSetScore_change);
        textView_BlueSet.setText(Integer.toString(games_change.GetBlueSet()));
        TextView textView_RedSet = (TextView)view.findViewById(R.id.RedSetScore_change);
        textView_RedSet.setText(Integer.toString(games_change.GetRedSet()));

        TextView player_number_name_1 = (TextView)view.findViewById(R.id.change_player_number_1);
        TextView player_number_name_2 = (TextView)view.findViewById(R.id.change_player_number_2);
        TextView player_number_name_3 = (TextView)view.findViewById(R.id.change_player_number_3);
        TextView player_number_name_4 = (TextView)view.findViewById(R.id.change_player_number_4);
        TextView player_number_name_5 = (TextView)view.findViewById(R.id.change_player_number_5);
        TextView player_number_name_6 = (TextView)view.findViewById(R.id.change_player_number_6);

        number_tmp = player_change[0].GetNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = player_change[1].GetNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = player_change[2].GetNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = player_change[3].GetNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = player_change[4].GetNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = player_change[5].GetNumber();
        player_number_name_6.setText(number_tmp);

        Drawable change_drawable = getResources().getDrawable(R.drawable.player_2);

        switch (change_chooice)
        {
            case 1:
                Button change_button_1 = (Button)view.findViewById(R.id.change_player_1);
                change_button_1.setBackground(change_drawable);
                break;
            case 2:
                Button change_button_2 = (Button)view.findViewById(R.id.change_player_2);
                change_button_2.setBackground(change_drawable);
                break;
            case 3:
                Button change_button_3 = (Button)view.findViewById(R.id.change_player_3);
                change_button_3.setBackground(change_drawable);
                break;
            case 4:
                Button change_button_4 = (Button)view.findViewById(R.id.change_player_4);
                change_button_4.setBackground(change_drawable);
                break;
            case 5:
                Button change_button_5 = (Button)view.findViewById(R.id.change_player_5);
                change_button_5.setBackground(change_drawable);
                break;
            case 6:
                Button change_button_6 = (Button)view.findViewById(R.id.change_player_6);
                change_button_6.setBackground(change_drawable);
                break;
        }

        subNumber_change = games_change.GetSubNumber();
        player_list_change = new String[subNumber_change];

        for(int i=0;i<subNumber_change;i++)
        {
            player_list_change[i] = player_change[games_change.GetSub(i)].GetNumber() + "      " +
                    player_change[games_change.GetSub(i)].GetName() + "      " +
                    player_change[games_change.GetSub(i)].GetPlace();
        }

        if(subNumber_change > 0)
        {
            Spinner change_spinner = (Spinner)view.findViewById(R.id.change_spinner);
            change_spinner.setVisibility(View.VISIBLE);
            ArrayAdapter<String> change_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, player_list_change);
            change_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            change_spinner.setAdapter(change_adapter);

            change_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                    tmp_change = player_list_change[arg2];

                    sub_chooice = arg2;

//                    Log.w("change_player_change", tmp_change);
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {

                }
            });


            Button button_change = (Button)view.findViewById(R.id.change_button_enter);
            button_change.setVisibility(View.VISIBLE);
            button_change.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    for(int i=0;i<subNumber_change;i++)
                    {
                        if(player_list_change[i].equals(tmp_change))
                        {
                            Player tmp;
                            tmp = player_change[6+sub_chooice];
                            player_change[6+sub_chooice] = player_change[change_chooice-1];
                            player_change[change_chooice-1] = tmp;
                            //games_change.Changeplayer(((change_chooice-1)+(change_round%6))%6, sub_chooice);
                        }
                    }
                    Fragment fragment_start = new Start();
                    FragmentTransaction mf = getFragmentManager().beginTransaction();
                    mf.replace(R.id.container_play, fragment_start);
                    mf.commit();
                    ((PlayGame)getActivity()).SetPlayer_Chooice();
                }
            });
        }
        else
        {
            Toast.makeText(getActivity(), R.string.NoplayerChange , Toast.LENGTH_SHORT).show();
        }

        TextView textView_back = (TextView)view.findViewById(R.id.change_back);
        textView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();
                FragmentTransaction mf = getFragmentManager().beginTransaction();
                mf.replace(R.id.container_play, fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
            }
        });

        return view;
    }

}
