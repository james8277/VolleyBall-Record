package fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Struct.Games_playing;
import Struct.Player;
import event.BlueWin;
import event.RedWin;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class Start extends Fragment {

    Games_playing game_start;
    Player[] players_start;
    private int tmp_round;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tmp_round = ((PlayGame)getActivity()).GetRound();

        players_start = new Player[12];
        Player tmp;
        for(int i=0;i<12;i++)
        {
            tmp = new Player();
            players_start[i] = tmp;
        }
        game_start = new Games_playing();


        game_start =  ((PlayGame)getActivity()).GetGame_play_game();
        players_start = ((PlayGame)getActivity()).GetPlayers_play_game();


//        Log.w("Format",Integer.toString(game_start.GetFormat()));
 //       Log.w("Format+1/1", Integer.toString(game_start.GetFormat() + 1));

//        Log.w("start_player_0_success_attack",String.valueOf(players_start[0].GetSuccessAttack()));

//        Log.w("blue score", String.valueOf(game_start.GetBlueScore()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_start, container, false);

        String number_tmp;

        TextView textView_blue_name = (TextView)view.findViewById(R.id.start_blue_name);
        textView_blue_name.setText(game_start.GetBlueName());
        TextView textView_red_name = (TextView)view.findViewById(R.id.start_red_name);
        textView_red_name.setText(game_start.GetRedName());

        TextView textView_start_blue_score = (TextView)view.findViewById(R.id.start_blue_score);
        TextView textView_start_red_score = (TextView)view.findViewById(R.id.start_red_score);
        textView_start_blue_score.setText(String.valueOf(game_start.GetBlueScore()));
        textView_start_red_score.setText(String.valueOf(game_start.GetRedScore()));


        TextView textView_BlueSet = (TextView)view.findViewById(R.id.BlueSetScore_start);
        textView_BlueSet.setText(Integer.toString(game_start.GetBlueSet()));
        TextView textView_RedSet = (TextView)view.findViewById(R.id.RedSetScore_start);
        textView_RedSet.setText(Integer.toString(game_start.GetRedSet()));

        textView_start_blue_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog_blue_score = new AlertDialog.Builder(getActivity());
                dialog_blue_score.setMessage("Set Blue Score");
                dialog_blue_score.setNegativeButton("+1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        game_start.BlueScore();

                        FragmentTransaction mf = getFragmentManager().beginTransaction();

                        Fragment fragment_start = new Start();
                        mf.replace(R.id.container_play, fragment_start);
                        mf.commit();
                    }
                });
                dialog_blue_score.setNeutralButton("-1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                        if(game_start.GetBlueScore() != 0)
                        {
                            game_start.BlueScoreMinus();

                            FragmentTransaction mf = getFragmentManager().beginTransaction();

                            Fragment fragment_start = new Start();
                            mf.replace(R.id.container_play, fragment_start);
                            mf.commit();
                        }

                    }
                });
                dialog_blue_score.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                dialog_blue_score.create().show();
            }
        });

        textView_start_red_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog_blue_score = new AlertDialog.Builder(getActivity());
                dialog_blue_score.setMessage("Set Red Score");
                dialog_blue_score.setNegativeButton("+1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        game_start.RedScore();

                        FragmentTransaction mf = getFragmentManager().beginTransaction();

                        Fragment fragment_start = new Start();
                        mf.replace(R.id.container_play, fragment_start);
                        mf.commit();
                    }
                });
                dialog_blue_score.setNeutralButton("-1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                        if(game_start.GetRedScore() != 0)
                        {
                            game_start.RedScoreMinus();

                            FragmentTransaction mf = getFragmentManager().beginTransaction();

                            Fragment fragment_start = new Start();
                            mf.replace(R.id.container_play, fragment_start);
                            mf.commit();
                        }
                    }
                });
                dialog_blue_score.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                dialog_blue_score.create().show();
            }
        });


        TextView player_number_name_1 = (TextView)view.findViewById(R.id.start_player_number_1);
        TextView player_number_name_2 = (TextView)view.findViewById(R.id.start_player_number_2);
        TextView player_number_name_3 = (TextView)view.findViewById(R.id.start_player_number_3);
        TextView player_number_name_4 = (TextView)view.findViewById(R.id.start_player_number_4);
        TextView player_number_name_5 = (TextView)view.findViewById(R.id.start_player_number_5);
        TextView player_number_name_6 = (TextView)view.findViewById(R.id.start_player_number_6);

        number_tmp = players_start[game_start.GetOnField((0+(tmp_round%6))%6)].GetNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = players_start[game_start.GetOnField((1+(tmp_round%6))%6)].GetNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = players_start[game_start.GetOnField((2+(tmp_round%6))%6)].GetNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = players_start[game_start.GetOnField((3+(tmp_round%6))%6)].GetNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = players_start[game_start.GetOnField((4+(tmp_round%6))%6)].GetNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = players_start[game_start.GetOnField((5+(tmp_round%6))%6)].GetNumber();
        player_number_name_6.setText(number_tmp);

        FragmentTransaction mf = getFragmentManager().beginTransaction();

        if(game_start.GetBlueScore() >= 25 || game_start.GetRedScore() >= 25)
        {
            if(game_start.GetBlueScore() - game_start.GetRedScore() >= 2)
            {
                game_start.SetRedScore(0);
                game_start.SetBlueScore(0);
                game_start.SetBlueSet();

                    /*Fragment fragment_Blue_Set = new SetPlayer_2();
                    mf.replace(R.id.container_play,fragment_Blue_Set);
                    mf.commit();*/
            }
            if(game_start.GetRedScore() - game_start.GetBlueScore() >= 2)
            {
                game_start.SetRedScore(0);
                game_start.SetBlueScore(0);
                game_start.SetRedSet();
            }
        }

        if(game_start.GetBlueSet() == (game_start.GetFormat()+1)/2)
        {
            Fragment fragment_blue_win = new BlueWin();
            mf.replace(R.id.container_play,fragment_blue_win);
            mf.commit();
        }
        else if(game_start.GetRedSet() ==( game_start.GetFormat()+1)/2)
        {
            Fragment fragment_red_win = new RedWin();
            mf.replace(R.id.container_play,fragment_red_win);
            mf.commit();
        }

        /*String Date = game_start.GetYear() + " " + game_start.GetMonth() + " " + game_start.GetDay();
        Log.w("Date_Start",Date);

        Log.w("BlueSet",Integer.toString(game_start.GetBlueSet()));
        Log.w("RedSet", Integer.toString(game_start.GetRedSet()));
        Log.w("Format_Start",Integer.toString(game_start.GetFormat()));
        Log.w("(Format+1)/2", Integer.toString((game_start.GetFormat() + 1)/2));*/

        return view;
    }

}
