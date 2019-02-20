package fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
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
import android.widget.Toast;

import Struct.GameData;
import Struct.Player;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class SetPlayer_2 extends Fragment {

    GameData game_set_player_2;
    Player[] player_set_player_2;
    Player[] player_tmp;
    Player[] player_spinner;

    String[] Player_Array;

    int set_2_tmp_player_chooice;

    int spinner_number;

    int player_set;

    int player_select;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game_set_player_2 =  ((PlayGame)getActivity()).GetGame_play_game();
        player_set_player_2 = ((PlayGame)getActivity()).GetPlayers_play_game();


        //Log.w("setplayer_2", "open");
        player_tmp = new Player[12];
        player_spinner = new Player[12];

        spinner_number = 0;
        player_set = 0;

        Player_Array = new String[6+game_set_player_2.GetSubNumber()-player_set];

        for(int i=0;i<12;i++)
        {
            player_spinner[i] = new Player();
            player_spinner[i] = player_set_player_2[i];
            player_tmp[i] = new Player();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        super.onCreateView(inflater,container,savedInstanceState);

        final View view = inflater.inflate(R.layout.fragment_set_player_2, container, false);


        for(int i=0;i<6+game_set_player_2.GetSubNumber()-player_set;i++)
        {
            Player_Array[i] = player_spinner[i].GetName() + "   " + player_spinner[i].GetNumber();
        }

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
                player_select = arg2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Resources res = this.getResources();
        final Drawable tmp_photo = res.getDrawable(R.drawable.player_1);

        final TextView textView_Enter_2 = (TextView)view.findViewById(R.id.set_2_enter);
        textView_Enter_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(6+game_set_player_2.GetSubNumber()-player_set != 0)
                {
                    place_spinner.setVisibility(View.INVISIBLE);
                }

                set_2_tmp_player_chooice = ((PlayGame)getActivity()).get_set_2_player_chooice();

                boolean change = false;
//                Log.w("player_name", player_tmp[set_2_tmp_player_chooice].GetNumber());
                if(player_tmp[set_2_tmp_player_chooice].GetName() != "")
                {
//                    Log.w("change","true");
                    Player tmp;
                    tmp = player_tmp[set_2_tmp_player_chooice];
                    player_tmp[set_2_tmp_player_chooice] = player_spinner[player_select];
                    player_spinner[player_select] = tmp;

                    change = true;
                    player_set--;
                    ((PlayGame)getActivity()).set_player_number_less();
                }
                else
                {
                    player_tmp[set_2_tmp_player_chooice] = player_spinner[player_select];
                }

                switch (set_2_tmp_player_chooice) {
                    case 0:
                        player_number_name_1.setText(player_tmp[set_2_tmp_player_chooice].GetNumber());
                        break;
                    case 1:
                        player_number_name_2.setText(player_tmp[set_2_tmp_player_chooice].GetNumber());
                        break;
                    case 2:
                        player_number_name_3.setText(player_tmp[set_2_tmp_player_chooice].GetNumber());
                        break;
                    case 3:
                        player_number_name_4.setText(player_tmp[set_2_tmp_player_chooice].GetNumber());
                        break;
                    case 4:
                        player_number_name_5.setText(player_tmp[set_2_tmp_player_chooice].GetNumber());
                        break;
                    case 5:
                        player_number_name_6.setText(player_tmp[set_2_tmp_player_chooice].GetNumber());
                        break;
                }

                if(!change)
                {
                    for(int i=player_select;i<6+game_set_player_2.GetSubNumber()-player_set-1;i++)
                    {
//                    Log.w("i",Integer.toString(i));
                        player_spinner[i] = player_spinner[i+1];
                    }
                }
                player_set++;
                ((PlayGame)getActivity()).set_player_number();
//                Log.w("player_set",Integer.toString(player_set));

                Player_Array = new String[6+game_set_player_2.GetSubNumber()-player_set];
                for(int i=0;i<6+game_set_player_2.GetSubNumber()-player_set;i++)
                {
                    Player_Array[i] = player_spinner[i].GetName() + "   " + player_spinner[i].GetNumber();
                }

                ArrayAdapter<String> place_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Player_Array);
                place_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                place_spinner.setAdapter(place_adapter);

//                int tmp = ((PlayGame)getActivity()).get_pre_set_player();
//                Button button_enter = (Button)view.findViewById(tmp);
//                Log.w("tmp",Integer.toString(tmp));
//                button_enter.setBackground(tmp_photo);

                textView_Enter_2.setVisibility(View.INVISIBLE);
            }
        });


        Button button_Next = (Button)view.findViewById(R.id.set_2_date_next);
        button_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                for(int i=0;i<6;i++)
//                {
//                    Log.w("player_tmp",player_tmp[i].GetNumber());
//                }
                boolean AllSet = true;
                for(int i=0;i<6;i++)
                {
                    if(player_tmp[i].GetNumber() == "")
                    {
//                        Log.w("all_set","false");
                        AllSet = false;
                        break;
                    }
                }

                for(int i=0;i<game_set_player_2.GetSubNumber();i++)
                {
                    player_tmp[6+i] = player_spinner[i];
                }

                if(AllSet)
                {
                    ((PlayGame)getActivity()).SetPlayer_Chooice();
                    ((PlayGame)getActivity()).reset_set_player_number();
                    ((PlayGame)getActivity()).Set_Player_2(player_tmp);
                    FragmentTransaction mf = getFragmentManager().beginTransaction();
                    Fragment fragment_start = new Start();
                    mf.replace(R.id.container_play,fragment_start);
                    mf.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),R.string.set_player_2_all,Toast.LENGTH_LONG).show();
                }
            }
        });



        return view;
    }
}
