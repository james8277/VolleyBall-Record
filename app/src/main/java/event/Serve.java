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

public class Serve extends Fragment {

    Games_playing games_serve;
    Player[] player_serve;
    private int serve_round;
    private int serve_chooice;
    String number_tmp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        games_serve = ((PlayGame)getActivity()).GetGame_play_game();
        player_serve = ((PlayGame)getActivity()).GetPlayers_play_game();
        serve_round = ((PlayGame)getActivity()).GetRound();
        serve_chooice = ((PlayGame)getActivity()).GetPlayer_chooice();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_serve, container, false);

        TextView textView_blue_name = (TextView)view.findViewById(R.id.serve_blue_name);
        textView_blue_name.setText(games_serve.GetBlueName());
        TextView textView_red_name = (TextView)view.findViewById(R.id.serve_red_name);
        textView_red_name.setText(games_serve.GetRedName());

        TextView textView_serve_blue_score = (TextView)view.findViewById(R.id.serve_blue_score);
        TextView textView_serve_red_score = (TextView)view.findViewById(R.id.serve_red_score);
        textView_serve_blue_score.setText(String.valueOf(games_serve.GetBlueScore()));
        textView_serve_red_score.setText(String.valueOf(games_serve.GetRedScore()));

        TextView textView_BlueSet = (TextView)view.findViewById(R.id.BlueSetScore_serve);
        textView_BlueSet.setText(Integer.toString(games_serve.GetBlueSet()));
        TextView textView_RedSet = (TextView)view.findViewById(R.id.RedSetScore_serve);
        textView_RedSet.setText(Integer.toString(games_serve.GetRedSet()));

        TextView player_number_name_1 = (TextView)view.findViewById(R.id.serve_player_number_1);
        TextView player_number_name_2 = (TextView)view.findViewById(R.id.serve_player_number_2);
        TextView player_number_name_3 = (TextView)view.findViewById(R.id.serve_player_number_3);
        TextView player_number_name_4 = (TextView)view.findViewById(R.id.serve_player_number_4);
        TextView player_number_name_5 = (TextView)view.findViewById(R.id.serve_player_number_5);
        TextView player_number_name_6 = (TextView)view.findViewById(R.id.serve_player_number_6);

        number_tmp = player_serve[games_serve.GetOnField((0+(serve_round%6))%6)].GetNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = player_serve[games_serve.GetOnField((1+(serve_round%6))%6)].GetNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = player_serve[games_serve.GetOnField((2+(serve_round%6))%6)].GetNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = player_serve[games_serve.GetOnField((3+(serve_round%6))%6)].GetNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = player_serve[games_serve.GetOnField((4+(serve_round%6))%6)].GetNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = player_serve[games_serve.GetOnField((5+(serve_round%6))%6)].GetNumber();
        player_number_name_6.setText(number_tmp);

        Drawable serve_drawable = getResources().getDrawable(R.drawable.player_2);

        switch (serve_chooice)
        {
            case 1:
                Button serve_button_1 = (Button)view.findViewById(R.id.serve_player_1);
                serve_button_1.setBackground(serve_drawable);
                break;
            case 2:
                Button serve_button_2 = (Button)view.findViewById(R.id.serve_player_2);
                serve_button_2.setBackground(serve_drawable);
                break;
            case 3:
                Button serve_button_3 = (Button)view.findViewById(R.id.serve_player_3);
                serve_button_3.setBackground(serve_drawable);
                break;
            case 4:
                Button serve_button_4 = (Button)view.findViewById(R.id.serve_player_4);
                serve_button_4.setBackground(serve_drawable);
                break;
            case 5:
                Button serve_button_5 = (Button)view.findViewById(R.id.serve_player_5);
                serve_button_5.setBackground(serve_drawable);
                break;
            case 6:
                Button serve_button_6 = (Button)view.findViewById(R.id.serve_player_6);
                serve_button_6.setBackground(serve_drawable);
                break;
        }

        final FragmentTransaction mf = getFragmentManager().beginTransaction();

        TextView textView_serve_success = (TextView)view.findViewById(R.id.serve_success);
        textView_serve_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                games_serve.BlueScore();
                player_serve[games_serve.GetOnField((serve_chooice-1+(serve_round%6))%6)].SuccessServe();
                if(games_serve.GetPrevious() == 2)
                {
                    games_serve.SetPrevious(1);
                    ((PlayGame)getActivity()).SetRound();
                }
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
            }
        });

        TextView textView_serve_mistake = (TextView)view.findViewById(R.id.serve_mistake);
        textView_serve_mistake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                games_serve.RedScore();
                player_serve[games_serve.GetOnField((serve_chooice-1+(serve_round%6))%6)].MistakeServe();
                games_serve.SetPrevious(2);
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
            }
        });

        TextView textView_serve_invalid = (TextView)view.findViewById(R.id.serve_invalid);
        textView_serve_invalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                player_serve[games_serve.GetOnField((serve_chooice-1+(serve_round%6))%6)].InvalidServe();
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).SetPlayer_Chooice();
            }
        });

        TextView textView_serve_back = (TextView)view.findViewById(R.id.serve_back);
        textView_serve_back.setOnClickListener(new View.OnClickListener() {
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
