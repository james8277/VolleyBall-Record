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
        textView_player_name.setText("Name: " + record_player_data[tmp_select_player].GetName());
        TextView textView_player_number = (TextView)view.findViewById(R.id.record_player_data_number);
        textView_player_number.setText("Number: " + record_player_data[tmp_select_player].GetNumber());
        TextView textView_player_place = (TextView)view.findViewById(R.id.record_player_data_place);
        textView_player_place.setText("Place: " + record_player_data[tmp_select_player].GetPlace());

        TextView textView_attack_all_number = (TextView)view.findViewById(R.id.record_attack_all_number);
        textView_attack_all_number.setText(String.valueOf(record_player_data[tmp_select_player].GetTotalAttack()));
        TextView textView_attack_success_number = (TextView)view.findViewById(R.id.record_attack_success_number);
        textView_attack_success_number.setText(String.valueOf(record_player_data[tmp_select_player].GetSuccessAttack()));
        TextView textView_attack_mistake_number = (TextView)view.findViewById(R.id.record_attack_mistake_number);
        textView_attack_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].GetMistakeAttack()));
        TextView textView_attack_rate_number = (TextView)view.findViewById(R.id.record_attack_rate_number);
        textView_attack_rate_number.setText(record_player_data[tmp_select_player].GetAttack());

        Log.w("total_attack", String.valueOf(record_player_data[tmp_select_player].GetTotalAttack()));
        Log.w("success_attack",String.valueOf(record_player_data[tmp_select_player].GetSuccessAttack()));
        Log.w("mistake_attack",String.valueOf(record_player_data[tmp_select_player].GetMistakeAttack()));

        TextView textView_defence_all_number = (TextView)view.findViewById(R.id.record_defence_all_number);
        textView_defence_all_number.setText(String.valueOf(record_player_data[tmp_select_player].GetTotalDefence()));
        TextView textView_defence_success_number = (TextView)view.findViewById(R.id.record_defence_success_number);
        textView_defence_success_number.setText(String.valueOf(record_player_data[tmp_select_player].GetSuccessDefence()));
        TextView textView_defence_mistake_number = (TextView)view.findViewById(R.id.record_defence_mistake_number);
        textView_defence_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].GetMistakeDefence()));
        TextView textView_defence_rate_number = (TextView)view.findViewById(R.id.record_defence_rate_number);
        textView_defence_rate_number.setText(record_player_data[tmp_select_player].GetDefence());

        TextView textView_serve_all_number = (TextView)view.findViewById(R.id.record_serve_all_number);
        textView_serve_all_number.setText(String.valueOf(record_player_data[tmp_select_player].GetTotalServe()));
        TextView textView_serve_success_number = (TextView)view.findViewById(R.id.record_serve_success_number);
        textView_serve_success_number.setText(String.valueOf(record_player_data[tmp_select_player].GetSuccessServe()));
        TextView textView_serve_mistake_number = (TextView)view.findViewById(R.id.record_serve_mistake_number);
        textView_serve_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].GetMistakeServe()));
        TextView textView_serve_rate_number = (TextView)view.findViewById(R.id.record_serve_rate_number);
        textView_serve_rate_number.setText(record_player_data[tmp_select_player].GetServe());

        TextView textView_set_all_number = (TextView)view.findViewById(R.id.record_set_all_number);
        textView_set_all_number.setText(String.valueOf(record_player_data[tmp_select_player].GetTotalSet()));
        TextView textView_set_success_number = (TextView)view.findViewById(R.id.record_set_success_number);
        textView_set_success_number.setText(String.valueOf(record_player_data[tmp_select_player].GetSuccessSet()));
        TextView textView_set_mistake_number = (TextView)view.findViewById(R.id.record_set_mistake_number);
        textView_set_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].GetMistakeSet()));
        TextView textView_set_rate_number = (TextView)view.findViewById(R.id.record_set_rate_number);
        textView_set_rate_number.setText(record_player_data[tmp_select_player].GetSet());

        TextView textView_block_all_number = (TextView)view.findViewById(R.id.record_block_all_number);
        textView_block_all_number.setText(String.valueOf(record_player_data[tmp_select_player].GetTotalBlock()));
        TextView textView_block_success_number = (TextView)view.findViewById(R.id.record_block_success_number);
        textView_block_success_number.setText(String.valueOf(record_player_data[tmp_select_player].GetSuccessBlock()));
        TextView textView_block_mistake_number = (TextView)view.findViewById(R.id.record_block_mistake_number);
        textView_block_mistake_number.setText(String.valueOf(record_player_data[tmp_select_player].GetMistakeBlock()));
        TextView textView_block_rate_number = (TextView)view.findViewById(R.id.record_block_rate_number);
        textView_block_rate_number.setText(record_player_data[tmp_select_player].GetBlock());

        Button Button_back = (Button)view.findViewById(R.id.record_player_data_back);
        Button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction mf = getFragmentManager().beginTransaction();
                Fragment fragment_all_player = new RecordAllPlayer();
                mf.setCustomAnimations(R.anim.fragment_left_in,R.anim.fragment_right_out);
                mf.replace(R.id.container_record,fragment_all_player);
                mf.commit();
            }
        });

        return view;
    }

}
