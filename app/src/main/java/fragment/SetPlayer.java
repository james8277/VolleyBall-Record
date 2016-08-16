package fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import Struct.Games_playing;
import Struct.Player;
import james.volleyballrecord.InitialSet;
import james.volleyballrecord.R;

public class SetPlayer extends Fragment {

    Games_playing game_set_player;
    Player[] player_set_player;
    String[] Position = {"S", "L", "WS", "MB"};
    String set_player_place;
    int set_tmp_player_chooice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game_set_player = ((InitialSet)getActivity()).GetGame();
        player_set_player = ((InitialSet)getActivity()).GetPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        super.onCreateView(inflater,container,savedInstanceState);

        final View view = inflater.inflate(R.layout.fragment_set_player, container, false);

        if(((InitialSet)getActivity()).GetToast_Test() == 0)
        {
            Toast.makeText(getActivity(),"Click the player to setup.",Toast.LENGTH_LONG).show();
            ((InitialSet)getActivity()).SetToast_Test();
        }

        String number_tmp;

        TextView player_number_name_1 = (TextView)view.findViewById(R.id.set_player_number_1);
        TextView player_number_name_2 = (TextView)view.findViewById(R.id.set_player_number_2);
        TextView player_number_name_3 = (TextView)view.findViewById(R.id.set_player_number_3);
        TextView player_number_name_4 = (TextView)view.findViewById(R.id.set_player_number_4);
        TextView player_number_name_5 = (TextView)view.findViewById(R.id.set_player_number_5);
        TextView player_number_name_6 = (TextView)view.findViewById(R.id.set_player_number_6);

        number_tmp = player_set_player[game_set_player.GetOnField(0)].GetNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = player_set_player[game_set_player.GetOnField(1)].GetNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = player_set_player[game_set_player.GetOnField(2)].GetNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = player_set_player[game_set_player.GetOnField(3)].GetNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = player_set_player[game_set_player.GetOnField(4)].GetNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = player_set_player[game_set_player.GetOnField(5)].GetNumber();
        player_number_name_6.setText(number_tmp);

        final Spinner place_spinner = (Spinner)view.findViewById(R.id.set_place_spinner);
        ArrayAdapter<String> place_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, Position);
        place_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        place_spinner.setAdapter(place_adapter);

        place_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
                set_player_place = Position[arg2];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        TextView textView_enter = (TextView)view.findViewById(R.id.set_enter);
        Resources res = this.getResources();
        final Drawable tmp_photo = res.getDrawable(R.drawable.player_1);


        textView_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view_1) {
                EditText set_player_name = (EditText)view.findViewById(R.id.set_name);
                EditText set_player_number = (EditText)view.findViewById(R.id.set_number);
                set_tmp_player_chooice = ((InitialSet)getActivity()).get_set_player_chooice();

                player_set_player[set_tmp_player_chooice].SetPlace(set_player_place);
                player_set_player[set_tmp_player_chooice].SetName(set_player_name.getText().toString());
                player_set_player[set_tmp_player_chooice].SetNumber(set_player_number.getText().toString());

                Log.w("player_name_set_player", set_player_name.getText().toString());

                set_player_name.setVisibility(View.INVISIBLE);
                set_player_number.setVisibility(View.INVISIBLE);
                place_spinner.setVisibility(View.INVISIBLE);

                set_player_name.setText("");
                set_player_number.setText("");

                set_player_name.setClickable(false);
                set_player_number.setClickable(false);
                place_spinner.setClickable(false);

                int tmp = ((InitialSet)getActivity()).getPre_set_player_chooice_id();
                Button button_enter = (Button)view.findViewById(tmp);
                button_enter.setBackground(tmp_photo);

                FragmentTransaction mf = getFragmentManager().beginTransaction();
                Fragment fragment_set = new SetPlayer();
                mf.replace(R.id.container_set, fragment_set);
                mf.commit();
            }
        });

        Button button_next = (Button)view.findViewById(R.id.set_date_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction mf = getFragmentManager().beginTransaction();
                mf.setCustomAnimations(R.animator.fragment_right_in,R.animator.fragment_left_out);
                Fragment fragment_set_substitute = new SetSubstitute();
                mf.replace(R.id.container_set, fragment_set_substitute);
                mf.commit();
            }
        });


        return view;
    }
}
