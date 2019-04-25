package event;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import Struct.GameData;
import Struct.Player;
import fragment.Start;
import james.volleyballrecord.PlayGame;
import james.volleyballrecord.R;

public class Block extends Fragment {

    GameData games_block;
    Player[] player_block;
    private int block_round;
    private int block_chooice;
    String number_tmp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        games_block = ((PlayGame)getActivity()).getGame_playGame();
        player_block = ((PlayGame)getActivity()).getPlayers_playGame();
        block_round = ((PlayGame)getActivity()).GetRound();
        block_chooice = ((PlayGame)getActivity()).getPlayerSelected();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_block, container, false);

        TextView textView_blue_name = (TextView)view.findViewById(R.id.block_blue_name);
        textView_blue_name.setText(games_block.getBlueName());
        TextView textView_red_name = (TextView)view.findViewById(R.id.block_red_name);
        textView_red_name.setText(games_block.getRedName());

        TextView textView_block_blue_score = (TextView)view.findViewById(R.id.block_blue_score);
        TextView textView_block_red_score = (TextView)view.findViewById(R.id.block_red_score);
        textView_block_blue_score.setText(String.valueOf(games_block.getBlueScore()));
        textView_block_red_score.setText(String.valueOf(games_block.getRedScore()));

        TextView textView_BlueSet = (TextView)view.findViewById(R.id.BlueSetScore_block);
        textView_BlueSet.setText(Integer.toString(games_block.getBlueSet()));
        TextView textView_RedSet = (TextView)view.findViewById(R.id.RedSetScore_block);
        textView_RedSet.setText(Integer.toString(games_block.getRedSet()));

        TextView player_number_name_1 = (TextView)view.findViewById(R.id.block_player_number_1);
        TextView player_number_name_2 = (TextView)view.findViewById(R.id.block_player_number_2);
        TextView player_number_name_3 = (TextView)view.findViewById(R.id.block_player_number_3);
        TextView player_number_name_4 = (TextView)view.findViewById(R.id.block_player_number_4);
        TextView player_number_name_5 = (TextView)view.findViewById(R.id.block_player_number_5);
        TextView player_number_name_6 = (TextView)view.findViewById(R.id.block_player_number_6);

        number_tmp = player_block[0].GetNumber();
        player_number_name_1.setText(number_tmp);
        number_tmp = player_block[1].GetNumber();
        player_number_name_2.setText(number_tmp);
        number_tmp = player_block[2].GetNumber();
        player_number_name_3.setText(number_tmp);
        number_tmp = player_block[3].GetNumber();
        player_number_name_4.setText(number_tmp);
        number_tmp = player_block[4].GetNumber();
        player_number_name_5.setText(number_tmp);
        number_tmp = player_block[5].GetNumber();
        player_number_name_6.setText(number_tmp);

        Drawable block_drawable = getResources().getDrawable(R.drawable.player_2);

        switch (block_chooice)
        {
            case 1:
                Button block_button_1 = (Button)view.findViewById(R.id.block_player_1);
                block_button_1.setBackground(block_drawable);
                break;
            case 2:
                Button block_button_2 = (Button)view.findViewById(R.id.block_player_2);
                block_button_2.setBackground(block_drawable);
                break;
            case 3:
                Button block_button_3 = (Button)view.findViewById(R.id.block_player_3);
                block_button_3.setBackground(block_drawable);
                break;
            case 4:
                Button block_button_4 = (Button)view.findViewById(R.id.block_player_4);
                block_button_4.setBackground(block_drawable);
                break;
            case 5:
                Button block_button_5 = (Button)view.findViewById(R.id.block_player_5);
                block_button_5.setBackground(block_drawable);
                break;
            case 6:
                Button block_button_6 = (Button)view.findViewById(R.id.block_player_6);
                block_button_6.setBackground(block_drawable);
                break;
        }

        final FragmentTransaction mf = getFragmentManager().beginTransaction();

        TextView textView_block_success = (TextView)view.findViewById(R.id.block_success);
        textView_block_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                games_block.BlueScore();
                player_block[block_chooice-1].SuccessBlock();
                if(games_block.getPrevious() == 2)
                {
                    games_block.setPrevious(1);
                    ((PlayGame)getActivity()).rotate(player_block);
                    //((PlayGame)getActivity()).SetRound();
                }
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_block_mistake = (TextView)view.findViewById(R.id.block_mistake);
        textView_block_mistake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                games_block.RedScore();
                player_block[block_chooice-1].MistakeBlock();
                games_block.setPrevious(2);
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_block_invalid = (TextView)view.findViewById(R.id.block_invalid);
        textView_block_invalid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                player_block[block_chooice-1].InvalidBlock();
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_block_touch = (TextView)view.findViewById(R.id.block_touch);
        textView_block_touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                player_block[block_chooice-1].TouchBlock();
                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
                ((PlayGame)getActivity()).setPlayerSelected();
            }
        });

        TextView textView_block_back = (TextView)view.findViewById(R.id.block_back);
        textView_block_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment_start = new Start();

                mf.replace(R.id.container_play,fragment_start);
                mf.commit();
            }
        });

        return view;
    }


}
