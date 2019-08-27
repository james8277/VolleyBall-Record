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

public class Set extends Fragment {

    GameData games_set;
    Player[] player_set;
    private int set_round;
    private int set_chooice;
    String number_tmp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        games_set = ((PlayGame)getActivity()).getGame_playGame();
        player_set = ((PlayGame)getActivity()).getPlayers_playGame();
        set_round = ((PlayGame)getActivity()).GetRound();
        set_chooice = ((PlayGame)getActivity()).getPlayerSelected();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_set, container, false);

        TextView textView_blue_name = (TextView)view.findViewById(R.id.set_blue_name);
        textView_blue_name.setText(games_set.getBlueName());
        TextView textView_red_name = (TextView)view.findViewById(R.id.set_red_name);
        textView_red_name.setText(games_set.getRedName());

        TextView textView_set_blue_score = (TextView)view.findViewById(R.id.set_blue_score);
        TextView textView_set_red_score = (TextView)view.findViewById(R.id.set_red_score);
        textView_set_blue_score.setText(String.valueOf(games_set.getBlueScore()));
        textView_set_red_score.setText(String.valueOf(games_set.getRedScore()));

        TextView textView_BlueSet = (TextView)view.findViewById(R.id.BlueSetScore_set);
        textView_BlueSet.setText(Integer.toString(games_set.getBlueSet()));
        TextView textView_RedSet = (TextView)view.findViewById(R.id.RedSetScore_set);
        textView_RedSet.setText(Integer.toString(games_set.getRedSet()));

        TextView player_number_name_1 = (TextView)view.findViewById(R.id.set_player_number_1);
        TextView player_number_name_2 = (TextView)view.findViewById(R.id.set_player_number_2);
        TextView player_number_name_3 = (TextView)view.findViewById(R.id.set_player_number_3);
        TextView player_number_name_4 = (TextView)view.findViewById(R.id.set_player_number_4);
        TextView player_number_name_5 = (TextView)view.findViewById(R.id.set_player_number_5);
        TextView player_number_name_6 = (TextView)view.findViewById(R.id.set_player_number_6);

        number_tmp = player_set[0].getNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = player_set[1].getNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = player_set[2].getNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = player_set[3].getNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = player_set[4].getNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = player_set[5].getNumber();
        player_number_name_6.setText(number_tmp);

        Drawable set_drawable = getResources().getDrawable(R.drawable.player_2);

        switch (set_chooice)
        {
            case 1:
                Button set_button_1 = (Button)view.findViewById(R.id.set_player_1);
                set_button_1.setBackground(set_drawable);
                break;
            case 2:
                Button set_button_2 = (Button)view.findViewById(R.id.set_player_2);
                set_button_2.setBackground(set_drawable);
                break;
            case 3:
                Button set_button_3 = (Button)view.findViewById(R.id.set_player_3);
                set_button_3.setBackground(set_drawable);
                break;
            case 4:
                Button set_button_4 = (Button)view.findViewById(R.id.set_player_4);
                set_button_4.setBackground(set_drawable);
                break;
            case 5:
                Button set_button_5 = (Button)view.findViewById(R.id.set_player_5);
                set_button_5.setBackground(set_drawable);
                break;
            case 6:
                Button set_button_6 = (Button)view.findViewById(R.id.set_player_6);
                set_button_6.setBackground(set_drawable);
                break;
        }

        final FragmentTransaction mf = getFragmentManager().beginTransaction();

        TextView textView_set_success = (TextView)view.findViewById(R.id.set_success);
        textView_set_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                player_set[set_chooice-1].setSuccess();
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_set_mistake = (TextView)view.findViewById(R.id.set_mistake);
        textView_set_mistake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                games_set.addRedScore();
                player_set[set_chooice-1].setFail();
                games_set.setPrevious(2);
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_set_invalid = (TextView)view.findViewById(R.id.set_invalid);
        textView_set_invalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                player_set[set_chooice-1].setInvalid();
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_set_back = (TextView)view.findViewById(R.id.set_back);
        textView_set_back.setOnClickListener(new View.OnClickListener() {
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
