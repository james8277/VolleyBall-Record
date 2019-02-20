package event;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import Struct.GameData;
import Struct.Player;
import fragment.Start;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class Defence extends Fragment {

    GameData games_defence;
    Player[] player_defence;
    private int defence_round;
    private int defence_chooice;
    String number_tmp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        games_defence = ((PlayGame)getActivity()).GetGame_play_game();
        player_defence = ((PlayGame)getActivity()).GetPlayers_play_game();
        defence_round = ((PlayGame)getActivity()).GetRound();
        defence_chooice = ((PlayGame)getActivity()).GetPlayer_chooice();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_defence, container, false);

        TextView textView_blue_name = (TextView)view.findViewById(R.id.defence_blue_name);
        textView_blue_name.setText(games_defence.GetBlueName());
        TextView textView_red_name = (TextView)view.findViewById(R.id.defence_red_name);
        textView_red_name.setText(games_defence.GetRedName());

        TextView textView_defence_blue_score = (TextView)view.findViewById(R.id.defence_blue_score);
        TextView textView_defence_red_score = (TextView)view.findViewById(R.id.defence_red_score);
        textView_defence_blue_score.setText(String.valueOf(games_defence.GetBlueScore()));
        textView_defence_red_score.setText(String.valueOf(games_defence.GetRedScore()));

        TextView textView_BlueSet = (TextView)view.findViewById(R.id.BlueSetScore_defence);
        textView_BlueSet.setText(Integer.toString(games_defence.GetBlueSet()));
        TextView textView_RedSet = (TextView)view.findViewById(R.id.RedSetScore_defence);
        textView_RedSet.setText(Integer.toString(games_defence.GetRedSet()));

        TextView player_number_name_1 = (TextView)view.findViewById(R.id.defence_player_number_1);
        TextView player_number_name_2 = (TextView)view.findViewById(R.id.defence_player_number_2);
        TextView player_number_name_3 = (TextView)view.findViewById(R.id.defence_player_number_3);
        TextView player_number_name_4 = (TextView)view.findViewById(R.id.defence_player_number_4);
        TextView player_number_name_5 = (TextView)view.findViewById(R.id.defence_player_number_5);
        TextView player_number_name_6 = (TextView)view.findViewById(R.id.defence_player_number_6);

        number_tmp = player_defence[0].GetNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = player_defence[1].GetNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = player_defence[2].GetNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = player_defence[3].GetNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = player_defence[4].GetNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = player_defence[5].GetNumber();
        player_number_name_6.setText(number_tmp);

        Drawable defence_drawable = getResources().getDrawable(R.drawable.player_2);

        switch (defence_chooice)
        {
            case 1:
                Button defence_button_1 = (Button)view.findViewById(R.id.defence_player_1);
                defence_button_1.setBackground(defence_drawable);
                break;
            case 2:
                Button defence_button_2 = (Button)view.findViewById(R.id.defence_player_2);
                defence_button_2.setBackground(defence_drawable);
                break;
            case 3:
                Button defence_button_3 = (Button)view.findViewById(R.id.defence_player_3);
                defence_button_3.setBackground(defence_drawable);
                break;
            case 4:
                Button defence_button_4 = (Button)view.findViewById(R.id.defence_player_4);
                defence_button_4.setBackground(defence_drawable);
                break;
            case 5:
                Button defence_button_5 = (Button)view.findViewById(R.id.defence_player_5);
                defence_button_5.setBackground(defence_drawable);
                break;
            case 6:
                Button defence_button_6 = (Button)view.findViewById(R.id.defence_player_6);
                defence_button_6.setBackground(defence_drawable);
                break;
        }

        final FragmentTransaction mf = getFragmentManager().beginTransaction();

        TextView textView_defence_success = (TextView)view.findViewById(R.id.defence_success);
        textView_defence_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                player_defence[defence_chooice-1].SuccessDefence();
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
            }
        });

        TextView textView_defence_mistake = (TextView)view.findViewById(R.id.defence_mistake);
        textView_defence_mistake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                games_defence.RedScore();
                player_defence[defence_chooice-1].MistakeDefence();
                games_defence.SetPrevious(2);
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
            }
        });

        TextView textView_defence_invalid = (TextView)view.findViewById(R.id.defence_invalid);
        textView_defence_invalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                player_defence[defence_chooice-1].InvalidDefence();
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
            }
        });

        TextView textView_defence_back = (TextView)view.findViewById(R.id.defence_back);
        textView_defence_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
            }
        });
        return view;
    }


}
