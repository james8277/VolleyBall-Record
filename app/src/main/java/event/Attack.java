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

public class Attack extends Fragment {

    GameData games_attack;
    Player[] player_attack;
    //private int attack_round;
    private int attack_chooice;
    String number_tmp;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        games_attack = ((PlayGame)getActivity()).getGame_playGame();
        player_attack = ((PlayGame)getActivity()).getPlayers_playGame();
        //attack_round = ((PlayGame)getActivity()).GetRound();
        attack_chooice = ((PlayGame)getActivity()).getPlayerSelected();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_attack, container, false);

        TextView textView_blue_name = (TextView)view.findViewById(R.id.attack_blue_name);
        textView_blue_name.setText(games_attack.getBlueName());
        TextView textView_red_name = (TextView)view.findViewById(R.id.attack_red_name);
        textView_red_name.setText(games_attack.getRedName());

        TextView textView_BlueSet = (TextView)view.findViewById(R.id.BlueSetScore_attack);
        textView_BlueSet.setText(Integer.toString(games_attack.getBlueSet()));
        TextView textView_RedSet = (TextView)view.findViewById(R.id.RedSetScore_attack);
        textView_RedSet.setText(Integer.toString(games_attack.getRedSet()));

        TextView textView_attack_blue_score = (TextView)view.findViewById(R.id.attack_blue_score);
        TextView textView_attack_red_score = (TextView)view.findViewById(R.id.attack_red_score);
        textView_attack_blue_score.setText(String.valueOf(games_attack.getBlueScore()));
        textView_attack_red_score.setText(String.valueOf(games_attack.getRedScore()));

        TextView player_number_name_1 = (TextView)view.findViewById(R.id.attack_player_number_1);
        TextView player_number_name_2 = (TextView)view.findViewById(R.id.attack_player_number_2);
        TextView player_number_name_3 = (TextView)view.findViewById(R.id.attack_player_number_3);
        TextView player_number_name_4 = (TextView)view.findViewById(R.id.attack_player_number_4);
        TextView player_number_name_5 = (TextView)view.findViewById(R.id.attack_player_number_5);
        TextView player_number_name_6 = (TextView)view.findViewById(R.id.attack_player_number_6);

        number_tmp = player_attack[0].GetNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = player_attack[1].GetNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = player_attack[2].GetNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = player_attack[3].GetNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = player_attack[4].GetNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = player_attack[5].GetNumber();
        player_number_name_6.setText(number_tmp);

        Drawable attack_drawable = getResources().getDrawable(R.drawable.player_2);

        switch (attack_chooice)
        {
            case 1:
                Button attack_button_1 = (Button)view.findViewById(R.id.attack_player_1);
                attack_button_1.setBackground(attack_drawable);
                break;
            case 2:
                Button attack_button_2 = (Button)view.findViewById(R.id.attack_player_2);
                attack_button_2.setBackground(attack_drawable);
                break;
            case 3:
                Button attack_button_3 = (Button)view.findViewById(R.id.attack_player_3);
                attack_button_3.setBackground(attack_drawable);
                break;
            case 4:
                Button attack_button_4 = (Button)view.findViewById(R.id.attack_player_4);
                attack_button_4.setBackground(attack_drawable);
                break;
            case 5:
                Button attack_button_5 = (Button)view.findViewById(R.id.attack_player_5);
                attack_button_5.setBackground(attack_drawable);
                break;
            case 6:
                Button attack_button_6 = (Button)view.findViewById(R.id.attack_player_6);
                attack_button_6.setBackground(attack_drawable);
                break;
        }

        final FragmentTransaction mf = getFragmentManager().beginTransaction();

        TextView textView_attack_success = (TextView)view.findViewById(R.id.attack_success);
        textView_attack_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                games_attack.BlueScore();
                player_attack[attack_chooice-1].SuccessAttack();
                if(games_attack.getPrevious() == 2)
                {
                    games_attack.setPrevious(1);
                    ((PlayGame)getActivity()).rotate(player_attack);
                    //((PlayGame)getActivity()).SetRound();
                }
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_attack_mistake = (TextView)view.findViewById(R.id.attack_mistake);
        textView_attack_mistake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                games_attack.RedScore();
                player_attack[attack_chooice-1].MistakeAttack();
                games_attack.setPrevious(2);
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_attack_invalid = (TextView)view.findViewById(R.id.attack_invalid);
        textView_attack_invalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                player_attack[attack_chooice-1].InvalidAttack();
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_attack_back = (TextView)view.findViewById(R.id.attack_back);
        textView_attack_back.setOnClickListener(new View.OnClickListener() {
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
