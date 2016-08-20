package fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
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

import Struct.Games_playing;
import james.volleyballrecord.DataBaseHelper;
import james.volleyballrecord.MainMenu;
import james.volleyballrecord.R;
import james.volleyballrecord.Record;

public class RecordAllGame extends Fragment {

    DataBaseHelper dataBaseHelper;
    Games_playing[] games_playing_record;
    String[] game_information;
    private int select_number;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBaseHelper = new DataBaseHelper(getActivity());
        games_playing_record = dataBaseHelper.GetAllGame();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record, container, false);

        TextView textView_select_game = (TextView)view.findViewById(R.id.record_record_text);
        Spinner record_select_team_spinner = (Spinner)view.findViewById(R.id.record_spinner);
        TextView textView_enter = (TextView)view.findViewById(R.id.record_enter);
        Button button_back = (Button)view.findViewById(R.id.record_back_text);
        int tmp_number = dataBaseHelper.GetData_number();
//        Log.w("data_number",String.valueOf(tmp_number));

        game_information = new String[tmp_number];
        if(tmp_number != 0)
        {
            textView_select_game.setVisibility(View.VISIBLE);
            textView_enter.setVisibility(View.VISIBLE);
            textView_enter.setClickable(true);
            record_select_team_spinner.setVisibility(View.VISIBLE);
            record_select_team_spinner.setClickable(true);
        }
        else
        {
            Toast.makeText(getActivity(),R.string.No_game_data,Toast.LENGTH_SHORT).show();
        }

        for(int i=0;i<tmp_number;i++)
        {
            game_information[i] = games_playing_record[i].GetBlueName() + "  V.S.  " + games_playing_record[i].GetRedName() + "   " +
                    games_playing_record[i].GetYear() + " / " + games_playing_record[i].GetMonth() + " / " + games_playing_record[i].GetDay() + "";
        }
        ArrayAdapter<String> record_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, game_information);
        record_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        record_select_team_spinner.setAdapter(record_adapter);


        record_select_team_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select_number = i;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        textView_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((Record)getActivity()).Set_select_game(select_number);
               // Log.w("select_game_record_all_game",String.valueOf(select_number));
                FragmentTransaction mf = getFragmentManager().beginTransaction();
//                mf.setCustomAnimations(R.anim.fragment_right_in,R.anim.fragment_left_out);
                Fragment fragment_record_all_player = new RecordAllPlayer();
                mf.replace(R.id.container_record,fragment_record_all_player);
                mf.commit();
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                Bundle bundle_back = new Bundle();
                bundle_back.putBoolean("is_game_playing",((Record)getActivity()).Get_is_game_playing());
                intent.putExtras(bundle_back);
                intent.setClass(getActivity(), MainMenu.class);
                startActivity(intent);
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.left_in, R.anim.right_out);
            }
        });

        Button button_delete = (Button)view.findViewById(R.id.record_all_game_delete);
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialog_delete = new AlertDialog.Builder(getActivity());
                dialog_delete.setMessage(R.string.delete_comfirm);
                dialog_delete.setTitle(R.string.Warning);
                dialog_delete.setPositiveButton(R.string.Yes,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();

                        dataBaseHelper.deleteTableAll();
                        Intent intent = new Intent();
                        Bundle bundle_back = new Bundle();
                        bundle_back.putBoolean("is_game_playing", ((Record) getActivity()).Get_is_game_playing());
                        intent.putExtras(bundle_back);
                        intent.setClass(getActivity(), MainMenu.class);
                        startActivity(intent);
                        Toast.makeText(getActivity(), R.string.deleted_all, Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                        getActivity().overridePendingTransition(R.anim.left_in, R.anim.right_out);
                    }
                });
                dialog_delete.setNegativeButton(R.string.Cancel,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog_delete.create().show();
            }
        });


        return view;
    }

}
