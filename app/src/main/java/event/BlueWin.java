package event;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
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

public class BlueWin extends Fragment {

    Games_playing games_playing_blue_win;
    Player[] players_blue_win;
    DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        games_playing_blue_win = ((PlayGame)getActivity()).GetGame_play_game();
        players_blue_win = ((PlayGame)getActivity()).GetPlayers_play_game();
        dataBaseHelper = new DataBaseHelper(getActivity());
        dataBaseHelper.addAll(games_playing_blue_win,players_blue_win);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blue_win, container, false);

        TextView textView_blue = (TextView)view.findViewById(R.id.blue_win);
        textView_blue.setText(games_playing_blue_win.GetBlueName() + "  Win");

        Button button_back = (Button)view.findViewById(R.id.blue_win_back);
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
