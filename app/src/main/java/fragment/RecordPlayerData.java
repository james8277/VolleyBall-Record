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

import Struct.Player;
import james.volleyballrecord.DataBaseHelper;
import james.volleyballrecord.R;
import james.volleyballrecord.Record;

public class RecordPlayerData extends Fragment {
    Player[] record_player_data;
    DataBaseHelper dataBaseHelper_record_all_player;
    private int select_game_number_record_player_data;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBaseHelper_record_all_player = new DataBaseHelper(getActivity());
        record_player_data = new Player[12];

        Player tmp;

        for(int i=0;i<12;i++)
        {
            tmp = new Player();
            record_player_data[i] = tmp;
        }
        select_game_number_record_player_data = ((Record)getActivity()).Get_select_game();
        record_player_data = dataBaseHelper_record_all_player.getPlayerAll(select_game_number_record_player_data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_record_player_data, container, false);

        int tmp_select_player = ((Record)getActivity()).Get_select_player();

        TextView textView_player_name = (TextView)view.findViewById(R.id.record_player_data_name);
        textView_player_name.setText("Name: " + record_player_data[tmp_select_player].getName());
        TextView textView_player_number = (TextView)view.findViewById(R.id.record_player_data_number);
        textView_player_number.setText("Number: " + record_player_data[tmp_select_player].getNumber());
        TextView textView_player_place = (TextView)view.findViewById(R.id.record_player_data_place);
        textView_player_place.setText("Place: " + record_player_data[tmp_select_player].getPosition());

        TextView textView_attack_all_number = (TextView)view.findViewById(R.id.record_attack_all_number);
        textView_attack_all_number.setText(String.valueOf(record_player_data[tmp_select_player].getTotalAttack()));
        TextView textView_attack_success_number = (TextView)view.findViewById(R.id.record_attack_success_number);
        textView_attack_success_number.setText(String.valueOf(record_player_data[tmp_select_player].getSuccessAttack()));
        TextView textView_attack_mistake_number = (TextView)view.findViewById(R.id.record_attack_mistake_number);
        textView_attack_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].getMistakeAttack()));
        TextView textView_attack_rate_number = (TextView)view.findViewById(R.id.record_attack_rate_number);
        textView_attack_rate_number.setText(record_player_data[tmp_select_player].getAttack());

        Log.w("total_attack", String.valueOf(record_player_data[tmp_select_player].getTotalAttack()));
        Log.w("success_attack",String.valueOf(record_player_data[tmp_select_player].getSuccessAttack()));
        Log.w("mistake_attack",String.valueOf(record_player_data[tmp_select_player].getMistakeAttack()));

        TextView textView_defence_all_number = (TextView)view.findViewById(R.id.record_defence_all_number);
        textView_defence_all_number.setText(String.valueOf(record_player_data[tmp_select_player].getTotalDefence()));
        TextView textView_defence_success_number = (TextView)view.findViewById(R.id.record_defence_success_number);
        textView_defence_success_number.setText(String.valueOf(record_player_data[tmp_select_player].getSuccessDefence()));
        TextView textView_defence_mistake_number = (TextView)view.findViewById(R.id.record_defence_mistake_number);
        textView_defence_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].getMistakeDefence()));
        TextView textView_defence_rate_number = (TextView)view.findViewById(R.id.record_defence_rate_number);
        textView_defence_rate_number.setText(record_player_data[tmp_select_player].getDefence());

        TextView textView_serve_all_number = (TextView)view.findViewById(R.id.record_serve_all_number);
        textView_serve_all_number.setText(String.valueOf(record_player_data[tmp_select_player].getTotalServe()));
        TextView textView_serve_success_number = (TextView)view.findViewById(R.id.record_serve_success_number);
        textView_serve_success_number.setText(String.valueOf(record_player_data[tmp_select_player].getSuccessServe()));
        TextView textView_serve_mistake_number = (TextView)view.findViewById(R.id.record_serve_mistake_number);
        textView_serve_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].getMistakeServe()));
        TextView textView_serve_rate_number = (TextView)view.findViewById(R.id.record_serve_rate_number);
        textView_serve_rate_number.setText(record_player_data[tmp_select_player].getServe());

        TextView textView_set_all_number = (TextView)view.findViewById(R.id.record_set_all_number);
        textView_set_all_number.setText(String.valueOf(record_player_data[tmp_select_player].getTotalSet()));
        TextView textView_set_success_number = (TextView)view.findViewById(R.id.record_set_success_number);
        textView_set_success_number.setText(String.valueOf(record_player_data[tmp_select_player].getSuccessSet()));
        TextView textView_set_mistake_number = (TextView)view.findViewById(R.id.record_set_mistake_number);
        textView_set_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].getMistakeSet()));
        TextView textView_set_rate_number = (TextView)view.findViewById(R.id.record_set_rate_number);
        textView_set_rate_number.setText(record_player_data[tmp_select_player].getSet());

        TextView textView_block_all_number = (TextView)view.findViewById(R.id.record_block_all_number);
        textView_block_all_number.setText(String.valueOf(record_player_data[tmp_select_player].getTotalBlock()));
        TextView textView_block_success_number = (TextView)view.findViewById(R.id.record_block_success_number);
        textView_block_success_number.setText(String.valueOf(record_player_data[tmp_select_player].getSuccessBlock()));
        TextView textView_block_mistake_number = (TextView)view.findViewById(R.id.record_block_mistake_number);
        textView_block_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].getMistakeBlock()));
        TextView textView_block_rate_number = (TextView)view.findViewById(R.id.record_block_rate_number);
        textView_block_rate_number.setText(record_player_data[tmp_select_player].getBlock());

        Button Button_back = (Button)view.findViewById(R.id.record_player_data_back);
        Button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction mf = getFragmentManager().beginTransaction();
                Fragment fragment_all_player = new RecordAllPlayer();
//                mf.setCustomAnimations(R.anim.fragment_left_in,R.anim.fragment_right_out);
                mf.replace(R.id.container_record,fragment_all_player);
                mf.commit();
            }
        });

        return view;
    }

}
