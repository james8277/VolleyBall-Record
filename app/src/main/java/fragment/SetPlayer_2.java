package fragment;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import Struct.Games_playing;
import Struct.Player;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class SetPlayer_2 extends Fragment {

    Games_playing game_set_player_2;
    Player[] player_set_player_2;
    Player[] player_tmp;
    int player_number;
    String[] Player_Array;

    String set_2_player_place;
    int set_2_tmp_player_chooice;

    int player_select;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game_set_player_2 =  ((PlayGame)getActivity()).GetGame_play_game();
        player_set_player_2 = ((PlayGame)getActivity()).GetPlayers_play_game();

        player_number = game_set_player_2.GetSubNumber() + 6;
        Player_Array = new String[player_number];

        //Log.w("setplayer_2", "open");
        player_tmp = new Player[12];

        //Player tmp;
        for(int i=0;i<player_number;i++)
        {
            Player_Array[i] = player_set_player_2[i].GetNumber() + "  " + player_set_player_2[i].GetName();

            //tmp = new Player();
            //player_tmp[i] = tmp;
            player_tmp[i] = player_set_player_2[i];
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        super.onCreateView(inflater,container,savedInstanceState);

        final View view = inflater.inflate(R.layout.fragment_set_player_2, container, false);

        String number_tmp;

        final TextView player_number_name_1 = (TextView)view.findViewById(R.id.set_2_player_number_1);
        final TextView player_number_name_2 = (TextView)view.findViewById(R.id.set_2_player_number_2);
        final TextView player_number_name_3 = (TextView)view.findViewById(R.id.set_2_player_number_3);
        final TextView player_number_name_4 = (TextView)view.findViewById(R.id.set_2_player_number_4);
        final TextView player_number_name_5 = (TextView)view.findViewById(R.id.set_2_player_number_5);
        final TextView player_number_name_6 = (TextView)view.findViewById(R.id.set_2_player_number_6);


        final Spinner place_spinner = (Spinner)view.findViewById(R.id.set_2_place_spinner);
        ArrayAdapter<String> place_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Player_Array);
        place_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        place_spinner.setAdapter(place_adapter);


        place_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                set_2_player_place = Player_Array[arg2];
                player_select = arg2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        TextView textView_Enter_2 = (TextView)view.findViewById(R.id.set_2_enter);
        Resources res = this.getResources();
        final Drawable tmp_photo = res.getDrawable(R.drawable.player_1);

        textView_Enter_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                set_2_tmp_player_chooice = ((PlayGame)getActivity()).get_set_2_player_chooice();

                player_set_player_2[set_2_tmp_player_chooice] = player_tmp[player_select];

                place_spinner.setVisibility(View.INVISIBLE);

                int tmp = ((PlayGame)getActivity()).get_pre_set_player();
                switch (set_2_tmp_player_chooice) {
                    case 0:
                        player_number_name_1.setText(player_tmp[player_select].GetNumber());
                        Button button_tmp;
                        //button_tmp = (Button)view.findViewById(R.id.set_2_player_1_data);
                        //button_tmp.setBackground(tmp_photo);
                        break;
                    case 1:
                        player_number_name_2.setText(player_tmp[player_select].GetNumber());
                        //button_tmp = (Button) view.findViewById(tmp);
                        //button_tmp.setBackground(tmp_photo);
                        break;
                    case 2:
                        player_number_name_3.setText(player_tmp[player_select].GetNumber());
                        //button_tmp = (Button) view.findViewById(tmp);
                        //button_tmp.setBackground(tmp_photo);
                        break;
                    case 3:
                        player_number_name_4.setText(player_tmp[player_select].GetNumber());
                        //button_tmp = (Button) view.findViewById(tmp);
                        //button_tmp.setBackground(tmp_photo);
                        break;
                    case 4:
                        player_number_name_5.setText(player_tmp[player_select].GetNumber());
                        //button_tmp = (Button) view.findViewById(tmp);
                        //button_tmp.setBackground(tmp_photo);
                        break;
                    case 5:
                        player_number_name_6.setText(player_tmp[player_select].GetNumber());
                        //button_tmp = (Button) view.findViewById(tmp);
                        //button_tmp.setBackground(tmp_photo);
                        break;
                }

                player_number--;
            }
        });

        Button button_Next = (Button)view.findViewById(R.id.set_2_date_next);
        button_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        return view;
    }
}
