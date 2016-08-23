package fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        final Drawable right_arrow = this.getResources().getDrawable(R.drawable.sortright24);
        final Drawable left_arrow = this.getResources().getDrawable(R.drawable.sortleft24);

        final Button button_Serve_Team = (Button)view.findViewById(R.id.serve_team);

        if(game_start.GetPrevious() == 1)
        {
            button_Serve_Team.setBackground(left_arrow);
        }
        if(game_start.GetPrevious() == 2)
        {
            button_Serve_Team.setBackground(right_arrow);
        }

        button_Serve_Team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog_serve_Team= new AlertDialog.Builder(getActivity());
                dialog_serve_Team.setMessage("Set Serve Team");
                dialog_serve_Team.setNegativeButton( game_start.GetBlueName() + " ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();

                        button_Serve_Team.setBackground(left_arrow);
                        game_start.SetPrevious(1);

                        FragmentTransaction mf = getFragmentManager().beginTransaction();
                        Fragment fragment_start = new Start();
                        mf.replace(R.id.container_play, fragment_start);
                        mf.commit();
                    }
                });

                dialog_serve_Team.setPositiveButton(game_start.GetRedName() + " " , new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();

                        button_Serve_Team.setBackground(right_arrow);
                        game_start.SetPrevious(2);

                        FragmentTransaction mf = getFragmentManager().beginTransaction();
                        Fragment fragment_start = new Start();
                        mf.replace(R.id.container_play, fragment_start);
                        mf.commit();
                    }
                });

                dialog_serve_Team.create().show();
            }
        });

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

                        if(game_start.GetPrevious() == 2)
                        {
                            game_start.SetPrevious(1);
                            ((PlayGame)getActivity()).rotate(players_start);
                            //((PlayGame)getActivity()).SetRound();
                        }

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

                        game_start.SetPrevious(2);

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

        number_tmp = players_start[0].GetNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = players_start[1].GetNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = players_start[2].GetNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = players_start[3].GetNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = players_start[4].GetNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = players_start[5].GetNumber();
        player_number_name_6.setText(number_tmp);

        FragmentTransaction mf = getFragmentManager().beginTransaction();
        Fragment fragment_Blue_win = new BlueWin();
        Fragment fragment_Red_win = new RedWin();
        Fragment fragment_set_player_2 = new SetPlayer_2();


//        Log.w("Format_Start", Integer.toString(game_start.GetFormat()) );

        if(game_start.GetFormat() == 3 && game_start.GetBlueSet() == 1 && game_start.GetRedSet() == 1)
        {
            if(game_start.GetBlueScore() >= 15 || game_start.GetRedScore() >= 15)
            {
                if (game_start.GetBlueScore() - game_start.GetRedScore() >= 2)
                {
                    mf.replace(R.id.container_play,fragment_Blue_win);
                    mf.commit();
                }
            }
            if(game_start.GetBlueScore() >= 15 || game_start.GetRedScore() >= 15)
            {
                if (game_start.GetRedScore() - game_start.GetBlueScore() >= 2)
                {
                    mf.replace(R.id.container_play,fragment_Red_win);
                }
            }
        }

        if(game_start.GetFormat() == 5 && game_start.GetBlueSet() == 2 && game_start.GetRedSet() == 2)
        {
            if(game_start.GetBlueScore() >= 15 || game_start.GetRedScore() >= 15)
            {
                if (game_start.GetBlueScore() - game_start.GetRedScore() >= 2)
                {
                    mf.replace(R.id.container_play,fragment_Blue_win);
                    mf.commit();
                }
            }
            if(game_start.GetBlueScore() >= 15 || game_start.GetRedScore() >= 15)
            {
                if (game_start.GetRedScore() - game_start.GetBlueScore() >= 2)
                {
                    mf.replace(R.id.container_play,fragment_Red_win);
                }
            }
        }


        if(game_start.GetBlueScore() >= 25 || game_start.GetRedScore() >= 25) {


            if (game_start.GetBlueScore() - game_start.GetRedScore() >= 2)
            {
                Log.w("Blue - Red","2");
                game_start.SetBlueSet();
                game_start.SetBlueScore(0);
                game_start.SetRedScore(0);

                Log.w("BlueSet", Integer.toString(game_start.GetBlueSet()));
                Log.w("RedSet", Integer.toString(game_start.GetRedSet()));
                Log.w("Format_Start", Integer.toString(((game_start.GetFormat()+1)/2)) );

                if(game_start.GetBlueSet() == ((game_start.GetFormat()+1)/2) )
                {
                    Log.w("Blue Win","true");
                    mf.replace(R.id.container_play,fragment_Blue_win);
                    mf.commit();
                }
                else
                {
                    mf.replace(R.id.container_play,fragment_set_player_2);
                    mf.commit();
                }
            }
            if (game_start.GetRedScore() - game_start.GetBlueScore() >= 2)
            {
                Log.w("Red - Blue","2");

                game_start.SetRedSet();
                game_start.SetBlueScore(0);
                game_start.SetRedScore(0);

                Log.w("BlueSet", Integer.toString(game_start.GetBlueSet()));
                Log.w("RedSet", Integer.toString(game_start.GetRedSet()));
                Log.w("Format_Start", Integer.toString(((game_start.GetFormat()+1)/2)) );

                if(game_start.GetRedSet() == ((game_start.GetFormat()+1)/2) )
                {
                    Log.w("Red Win","true");
                    mf.replace(R.id.container_play,fragment_Red_win);
                    mf.commit();
                }
                else
                {
                    mf.replace(R.id.container_play,fragment_set_player_2);
                    mf.commit();
                }

            }
        }

        TextView textView_re_rotate = (TextView)view.findViewById(R.id.re_rotate);
        textView_re_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Log.w("previous","clicked");
                ((PlayGame)getActivity()).rerotate(players_start);

                FragmentTransaction mf = getFragmentManager().beginTransaction();
                Fragment fragment_rotate = new Start();
                mf.replace(R.id.container_play, fragment_rotate);
                mf.commit();
            }
        });

        TextView textView_rotate = (TextView)view.findViewById(R.id.rotate);
        textView_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Log.w("previous","clicked");
                ((PlayGame)getActivity()).rotate(players_start);

                FragmentTransaction mf = getFragmentManager().beginTransaction();
                Fragment fragment_rotate = new Start();
                mf.replace(R.id.container_play, fragment_rotate);
                mf.commit();
            }
        });

        return view;
    }

}
