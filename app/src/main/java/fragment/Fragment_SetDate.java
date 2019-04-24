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
import james.volleyballrecord.Activity_AppMenu;
import james.volleyballrecord.Activity_InitialSet;
import james.volleyballrecord.R;

public class Fragment_SetDate extends Fragment {

    //TAG Name
    private static final String TAG = Activity_AppMenu.class.getSimpleName();
    //Game Data
    private GameData gameData_set;

    //Array for day selected
    private String dayArray[];
    //Array for month selected
    private String monthArray[] = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October"
            , "November", "December"};
    //Array for year selected
    private String yearArray[];
    //Array for format selected
    private String formatArray[];

    //Spinner for year selection
    private Spinner yearSpinner;
    //Spinner for month selection
    private Spinner monthSpinner;
    //Spinner for day selection
    private Spinner daySpinner;
    //Spinner for format selection
    private Spinner formatSpinner;
    //Button to next fragment
    private Button button_next;

    //EditText for two teams
    private EditText BlueTeamName;
    private EditText RedTeamName;

    //Adapter for year selection
    private ArrayAdapter<String> yearAdapter;
    //Adapter for month selection
    private ArrayAdapter<String> monthAdapter;
    //Adapter for day selection
    private ArrayAdapter<String> dayAdapter;
    //Adapter for format selection
    private ArrayAdapter<String> formatAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize day array
        dayArray = new String[31];
        for(int i=0;i<31;i++) {
            dayArray[i] = String.valueOf(i+1);
        }
        //Initialize year array
        yearArray = new String[30];
        for(int i=0;i<30;i++) {
            yearArray[i] = String.valueOf(i+2012);
        }
        //Initialize format array
        formatArray = new String[3];
        formatArray[0] = getString(R.string.BO1);
        formatArray[1] = getString(R.string.BO3);
        formatArray[2] = getString(R.string.BO5);


        //Get Game data from activity
        gameData_set = ((Activity_InitialSet)getActivity()).getGame();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreateView(inflater, container,savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_initial_set, container, false);

        //Initialize button and spinner
        button_next = (Button)rootView.findViewById(R.id.date_next);
        yearSpinner = (Spinner)rootView.findViewById(R.id.date_spinner_year);
        monthSpinner = (Spinner)rootView.findViewById(R.id.date_spinner_month);
        daySpinner = (Spinner)rootView.findViewById(R.id.date_spinner_day);
        formatSpinner = (Spinner)rootView.findViewById((R.id.format_spinner));

        //Initialize editText for two teams
        BlueTeamName = (EditText)rootView.findViewById(R.id.date_blue_team);
        RedTeamName = (EditText)rootView.findViewById(R.id.date_red_team);


        yearAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,yearArray);
        monthAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,monthArray);
        dayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,dayArray);
        formatAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,formatArray);

        //Change adapter style
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        formatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setup adapter for spinner
        yearSpinner.setAdapter(yearAdapter);
        monthSpinner.setAdapter(monthAdapter);
        daySpinner.setAdapter(dayAdapter);
        formatSpinner.setAdapter(formatAdapter);

        //Get selected year every time it changed
        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gameData_set.SetYear(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Get selected month every time it changed
        monthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gameData_set.SetMonth(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Get selected day every time it changed
        daySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gameData_set.SetDay(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //Get selected format every time it changed
        formatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gameData_set.SetFormat(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Setup all game data when you click next button
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Set name of two teams
                gameData_set.SetHome(BlueTeamName.getText().toString());
                gameData_set.SetAway(RedTeamName.getText().toString());
                //
                gameData_set.SetBlueName(BlueTeamName.getText().toString());
                gameData_set.SetRedName(RedTeamName.getText().toString());

                //Go to next fragment (Set Player)
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                Fragment fragment_setPlayer = new SetPlayer();
                //Set animation for fragment exchange
                fragmentTransaction.setCustomAnimations(R.animator.fragment_right_in, R.animator.fragment_left_out
                                        , R.animator.fragment_left_in, R.animator.fragment_right_out);
                fragmentTransaction.replace(R.id.container_set, fragment_setPlayer);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}
