package fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import Struct.GameData;
import Struct.Player;
import james.volleyballrecord.DataBaseHelper;
import james.volleyballrecord.R;
import james.volleyballrecord.Record;

public class RecordAllPlayer extends Fragment {

    Player[] record_all_player_player;
    DataBaseHelper dataBaseHelper_record_all_player;
    private int select_game_number_record_all_player;
    String[] player_list;
    GameData[] record_all_player_game;
    private int SubNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBaseHelper_record_all_player = new DataBaseHelper(getActivity());
        record_all_player_player = new Player[12];

        player_list = new String[12];
        Player tmp;

        for(int i=0;i<12;i++) {
            tmp = new Player();
            record_all_player_player[i] = tmp;
        }

        select_game_number_record_all_player = ((Record)getActivity()).Get_select_game();
//        Log.w("select_game_all_player",String.valueOf(select_game_number_record_all_player));

        record_all_player_player = dataBaseHelper_record_all_player.getPlayerAll(select_game_number_record_all_player);
        record_all_player_game = dataBaseHelper_record_all_player.GetAllGame();
        SubNumber = record_all_player_game[select_game_number_record_all_player].getSubCount();

//        Log.w("SubNumber",Integer.toString(SubNumber));

        for (int i=0;i<12;i++) {
            player_list[i] = record_all_player_player[i].getNumber()
                    + "    " + record_all_player_player[i].getName()
                    + "    " + record_all_player_player[i].getPosition();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_record_all_player, container, false);

//        Log.w("sub_0_name_record_all_player",record_all_player_player[6].GetName() + "all_player");

        TextView textView_player_0 = (TextView)view.findViewById(R.id.record_player_0);
        TextView textView_player_1 = (TextView)view.findViewById(R.id.record_player_1);
        TextView textView_player_2 = (TextView)view.findViewById(R.id.record_player_2);
        TextView textView_player_3 = (TextView)view.findViewById(R.id.record_player_3);
        TextView textView_player_4 = (TextView)view.findViewById(R.id.record_player_4);
        TextView textView_player_5 = (TextView)view.findViewById(R.id.record_player_5);
        TextView textView_player_6 = (TextView)view.findViewById(R.id.record_player_6);
        TextView textView_player_7 = (TextView)view.findViewById(R.id.record_player_7);
        TextView textView_player_8 = (TextView)view.findViewById(R.id.record_player_8);
        TextView textView_player_9 = (TextView)view.findViewById(R.id.record_player_9);
        TextView textView_player_10 = (TextView)view.findViewById(R.id.record_player_10);
        TextView textView_player_11 = (TextView)view.findViewById(R.id.record_player_11);

        Button button_record_back = (Button)view.findViewById(R.id.record_all_player_back);
        button_record_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction mf = getFragmentManager().beginTransaction();
                Fragment fragment_all_game_record = new RecordAllGame();
//                mf.setCustomAnimations(R.anim.fragment_left_in,R.anim.fragment_right_out);
                mf.replace(R.id.container_record,fragment_all_game_record);
                mf.commit();
            }
        });


        for(int i=0;i<6+SubNumber;i++) {
            switch (i) {
                case 0:
                    textView_player_0.setText(player_list[i]);
                    textView_player_0.setVisibility(View.VISIBLE);
                    textView_player_0.setClickable(true);
                    break;
                case 1:
                    textView_player_1.setText(player_list[i]);
                    textView_player_1.setVisibility(View.VISIBLE);
                    textView_player_1.setClickable(true);
                    break;
                case 2:
                    textView_player_2.setText(player_list[i]);
                    textView_player_2.setVisibility(View.VISIBLE);
                    textView_player_2.setClickable(true);
                    break;
                case 3:
                    textView_player_3.setText(player_list[i]);
                    textView_player_3.setVisibility(View.VISIBLE);
                    textView_player_3.setClickable(true);
                    break;
                case 4:
                    textView_player_4.setText(player_list[i]);
                    textView_player_4.setVisibility(View.VISIBLE);
                    textView_player_4.setClickable(true);
                    break;
                case 5:
                    textView_player_5.setText(player_list[i]);
                    textView_player_5.setVisibility(View.VISIBLE);
                    textView_player_5.setClickable(true);
                    break;
                case 6:
                    textView_player_6.setText(player_list[i]);
                    textView_player_6.setVisibility(View.VISIBLE);
                    textView_player_6.setClickable(true);
                    break;
                case 7:
                    textView_player_7.setText(player_list[i]);
                    textView_player_7.setVisibility(View.VISIBLE);
                    textView_player_7.setClickable(true);
                    break;
                case 8:
                    textView_player_8.setText(player_list[i]);
                    textView_player_8.setVisibility(View.VISIBLE);
                    textView_player_8.setClickable(true);
                    break;
                case 9:
                    textView_player_9.setText(player_list[i]);
                    textView_player_9.setVisibility(View.VISIBLE);
                    textView_player_9.setClickable(true);
                    break;
                case 10:
                    textView_player_10.setText(player_list[i]);
                    textView_player_10.setVisibility(View.VISIBLE);
                    textView_player_10.setClickable(true);
                    break;
                case 11:
                    textView_player_11.setText(player_list[i]);
                    textView_player_11.setVisibility(View.VISIBLE);
                    textView_player_11.setClickable(true);
                    break;
            }
        }


        return view;
    }

}
