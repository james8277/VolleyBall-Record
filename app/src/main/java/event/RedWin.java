package event;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import Struct.Games_playing;
import Struct.Player;
import james.volleyballrecord.DataBaseHelper;
import james.volleyballrecord.MainMenu;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class RedWin extends Fragment {

    Games_playing games_playing_red_win;
    Player[] players_red_win;
    DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        games_playing_red_win = ((PlayGame)getActivity()).GetGame_play_game();
        players_red_win = ((PlayGame)getActivity()).GetPlayers_play_game();
        dataBaseHelper = new DataBaseHelper(getActivity());
        Log.w("total_attack_red_win", String.valueOf(players_red_win[0].GetTotalAttack()));
        Log.w("success_attack_red_win", String.valueOf(players_red_win[0].GetSuccessAttack()));
        Log.w("mistake_attack_red_win", String.valueOf(players_red_win[0].GetMistakeAttack()));
        dataBaseHelper.addAll(games_playing_red_win, players_red_win);

//        Log.w("sub_0_name_red_win",players_red_win[6].GetName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_red_win, container, false);

        TextView textView_blue = (TextView)view.findViewById(R.id.red_win);
        textView_blue.setText(games_playing_red_win.GetBlueName() + "  " + this.getResources().getText(R.string.Win));


        Button button_back = (Button)view.findViewById(R.id.red_win_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), MainMenu.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("is_game_playing",false);
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }


}
