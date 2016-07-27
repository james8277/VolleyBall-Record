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

import Struct.Games_playing;
import Struct.Player;
import fragment.Start;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class Attack extends Fragment {

    Games_playing games_attack;
    Player[] player_attack;
    private int attack_round;
    private int attack_chooice;
    String number_tmp;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        games_attack = ((PlayGame)getActivity()).GetGame_play_game();
        player_attack = ((PlayGame)getActivity()).GetPlayers_play_game();
        attack_round = ((PlayGame)getActivity()).GetRound();
        attack_chooice = ((PlayGame)getActivity()).GetPlayer_chooice();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_attack, container, false);

        TextView textView_blue_name = (TextView)view.findViewById(R.id.attack_blue_name);
        textView_blue_name.setText(games_attack.GetBlueName());
        TextView textView_red_name = (TextView)view.findViewById(R.id.attack_red_name);
        textView_red_name.setText(games_attack.GetRedName());

        TextView textView_BlueSet = (TextView)view.findViewById(R.id.BlueSetScore_attack);
        textView_BlueSet.setText(Integer.toString(games_attack.GetBlueSet()));
        TextView textView_RedSet = (TextView)view.findViewById(R.id.RedSetScore_attack);
        textView_RedSet.setText(Integer.toString(games_attack.GetRedSet()));

        TextView textView_attack_blue_score = (TextView)view.findViewById(R.id.attack_blue_score);
        TextView textView_attack_red_score = (TextView)view.findViewById(R.id.attack_red_score);
        textView_attack_blue_score.setText(String.valueOf(games_attack.GetBlueScore()));
        textView_attack_red_score.setText(String.valueOf(games_attack.GetRedScore()));

        TextView player_number_name_1 = (TextView)view.findViewById(R.id.attack_player_number_1);
        TextView player_number_name_2 = (TextView)view.findViewById(R.id.attack_player_number_2);
        TextView player_number_name_3 = (TextView)view.findViewById(R.id.attack_player_number_3);
        TextView player_number_name_4 = (TextView)view.findViewById(R.id.attack_player_number_4);
        TextView player_number_name_5 = (TextView)view.findViewById(R.id.attack_player_number_5);
        TextView player_number_name_6 = (TextView)view.findViewById(R.id.attack_player_number_6);

        number_tmp = player_attack[games_attack.GetOnField((0+(attack_round%6))%6)].GetNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = player_attack[games_attack.GetOnField((1+(attack_round%6))%6)].GetNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = player_attack[games_attack.GetOnField((2+(attack_round%6))%6)].GetNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = player_attack[games_attack.GetOnField((3+(attack_round%6))%6)].GetNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = player_attack[games_attack.GetOnField((4+(attack_round%6))%6)].GetNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = player_attack[games_attack.GetOnField((5+(attack_round%6))%6)].GetNumber();
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
                player_attack[games_attack.GetOnField((attack_chooice-1+(attack_round%6))%6)].SuccessAttack();
                if(games_attack.GetPrevious() == 2)
                {
                    games_attack.SetPrevious(1);
                    ((PlayGame)getActivity()).SetRound();
                }
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
            }
        });

        TextView textView_attack_mistake = (TextView)view.findViewById(R.id.attack_mistake);
        textView_attack_mistake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                games_attack.RedScore();
                player_attack[games_attack.GetOnField((attack_chooice-1+(attack_round%6))%6)].MistakeAttack();
                games_attack.SetPrevious(2);
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
            }
        });

        TextView textView_attack_invalid = (TextView)view.findViewById(R.id.attack_invalid);
        textView_attack_invalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                player_attack[games_attack.GetOnField((attack_chooice-1+(attack_round%6))%6)].InvalidAttack();
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
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
