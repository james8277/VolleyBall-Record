package event;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
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

public class BlueWin extends Fragment {

    GameData gameData_blue_win;
    Player[] players_blue_win;
    DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameData_blue_win = ((PlayGame)getActivity()).getGame_playGame();
        players_blue_win = ((PlayGame)getActivity()).getPlayers_playGame();
        dataBaseHelper = new DataBaseHelper(getActivity());
        dataBaseHelper.addAll(gameData_blue_win,players_blue_win);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blue_win, container, false);

        TextView textView_blue = (TextView)view.findViewById(R.id.blue_win);
        textView_blue.setText(gameData_blue_win.getBlueName() +"  " + this.getResources().getText(R.string.Win));

        Button button_back = (Button)view.findViewById(R.id.blue_win_back);
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
