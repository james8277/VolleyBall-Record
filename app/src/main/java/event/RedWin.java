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

import Struct.GameData;
import Struct.Player;
import james.volleyballrecord.Activity_AppMenu;
import james.volleyballrecord.DataBaseHelper;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class RedWin extends Fragment {

    GameData gameData_red_win;
    Player[] players_red_win;
    DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameData_red_win = ((PlayGame)getActivity()).getGame_playGame();
        players_red_win = ((PlayGame)getActivity()).getPlayers_playGame();
        dataBaseHelper = new DataBaseHelper(getActivity());
        Log.w("total_attack_red_win", String.valueOf(players_red_win[0].getTotalAttack()));
        Log.w("success_attack_red_win", String.valueOf(players_red_win[0].getSuccessAttack()));
        Log.w("mistake_attack_red_win", String.valueOf(players_red_win[0].getMistakeAttack()));
        dataBaseHelper.addAll(gameData_red_win, players_red_win);

//        Log.w("sub_0_name_red_win",players_red_win[6].GetName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_red_win, container, false);

        TextView textView_blue = (TextView)view.findViewById(R.id.red_win);
        textView_blue.setText(gameData_red_win.getBlueName() + "  " + this.getResources().getText(R.string.Win));


        Button button_back = (Button)view.findViewById(R.id.red_win_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Activity_AppMenu.class);
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
