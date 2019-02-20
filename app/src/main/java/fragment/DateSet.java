package fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
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

import Struct.GameData;
import Struct.Player;
import james.volleyballrecord.InitialSet;
import james.volleyballrecord.R;

public class DateSet extends Fragment {

    GameData game_set_date;
    Player[] player_set_date;
    String tmp;

    String day_Array[];
    String month_Array[] = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October"
            , "November", "December"};
    String year_Array[];
    String format_Array[];


    Spinner year_spinner;
    Spinner month_spinner;
    Spinner day_spinner;
    Spinner format_spinner;
    Button button_next;

    EditText BlueTeamName;
    EditText RedTeamName;

    ArrayAdapter<String> year_adapter;
    ArrayAdapter<String> month_adapter;
    ArrayAdapter<String> day_adapter;
    ArrayAdapter<String> format_adapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        day_Array = new String[31];
        for(int i=0;i<31;i++)
        {
            day_Array[i] = String.valueOf(i+1);
        }
        year_Array = new String[30];
        for(int i=0;i<30;i++)
        {
            year_Array[i] = String.valueOf(i+2012);
        }

        game_set_date = ((InitialSet)getActivity()).getGame();

        format_Array = new String[3];
        format_Array[0] = getString(R.string.BO1);
        format_Array[1] = getString(R.string.BO3);
        format_Array[2] = getString(R.string.BO5);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        super.onCreateView(inflater, container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_initial_set, container, false);

        button_next = (Button)view.findViewById(R.id.date_next);
        year_spinner = (Spinner)view.findViewById(R.id.date_spinner_year);
        month_spinner = (Spinner)view.findViewById(R.id.date_spinner_month);
        day_spinner = (Spinner)view.findViewById(R.id.date_spinner_day);
        format_spinner = (Spinner)view.findViewById((R.id.format_spinner));

        BlueTeamName = (EditText)view.findViewById(R.id.date_blue_team);
        RedTeamName = (EditText)view.findViewById(R.id.date_red_team);

        year_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,year_Array);
        month_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,month_Array);
        day_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,day_Array);
        format_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,format_Array);

        year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        month_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        format_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        year_spinner.setAdapter(year_adapter);
        month_spinner.setAdapter(month_adapter);
        day_spinner.setAdapter(day_adapter);
        format_spinner.setAdapter(format_adapter);

        year_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                tmp = adapterView.getSelectedItem().toString();
                game_set_date.SetYear(tmp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        month_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tmp = adapterView.getSelectedItem().toString();
                game_set_date.SetMonth(tmp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        day_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tmp = adapterView.getSelectedItem().toString();
                game_set_date.SetDay(tmp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        format_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tmp = adapterView.getSelectedItem().toString();
                game_set_date.SetFormat(tmp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                game_set_date.SetHome(BlueTeamName.getText().toString());
                game_set_date.SetAway(RedTeamName.getText().toString());


                FragmentTransaction mf = getFragmentManager().beginTransaction();
                Fragment fragment_setplayer = new SetPlayer();

                String Date = game_set_date.GetYear() + " " + game_set_date.GetMonth() + " " + game_set_date.GetDay();
                Log.w("Date",Date);

                String Team = game_set_date.GetHomeName() + " " + game_set_date.GetAwayName();
                Log.w("Team", Team);

                int tmp = game_set_date.GetFormat();
                String tmp_string = Integer.toString(tmp);
                Log.w("Format_DateSet", tmp_string);


                EditText editText_blue = (EditText) getActivity().findViewById(R.id.date_blue_team);
                EditText editText_red = (EditText) getActivity().findViewById(R.id.date_red_team);

                game_set_date.SetBlueName(editText_blue.getText().toString());
                game_set_date.SetRedName(editText_red.getText().toString());
                mf.setCustomAnimations(R.animator.fragment_right_in, R.animator.fragment_left_out);
                mf.replace(R.id.container_set, fragment_setplayer);
                mf.commit();
            }
        });

        return view;
    }
}
