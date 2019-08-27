package james.volleyballrecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import Struct.GameData;
import Struct.Player;

/**
 * Created by 仁傑 on 2014/9/8.
 */
public class DataBaseHelper extends SQLiteOpenHelper{
    private final Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "VolleyBall DataBase";
    private static final String TABLE_TMP = "tmpData";
    private static final String TABLE_ALL = "allData";

    private static final String KEY_ID = "_ID";
    private static final String KEY_YEAR = "year_game";
    private static final String KEY_MONTH = "month_game";
    private static final String KEY_DAY = "day_game";
    private static final String KEY_BLUE_TEAM = "blue_team";
    private static final String KEY_RED_TEAM = "red_team";
    private static final String KEY_FORMAT = "game_format";
    private static final String KEY_BLUE_SCORE = "blue_score";
    private static final String KEY_RED_SCORE = "red_score";
    private static final String KEY_SUB_NUMBER = "sub_Number";
    private static final String KEY_L_NUMBER = "L_Number";
    private static final String KEY_PLAYER = "player_";
    private static final String KEY_NAME = "_name";
    private static final String KEY_PLACE = "_place";
    private static final String KEY_PLAYER_ATTACK = "_attack";
    private static final String KEY_PLAYER_DEFENCE = "_defence";
    private static final String KEY_PLAYER_SERVE = "_serve";
    private static final String KEY_PLAYER_BLOCK = "_block";
    private static final String KEY_PLAYER_SET = "_set";
    private static final String KEY_PLAYER_ALL = "_all";
    private static final String KEY_PLAYER_SUCCESS = "_success";
    private static final String KEY_PLAYER_MISTAKE = "_mistake";
    private static final String KEY_PLAYER_TOUCH = "_touch";



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.w("db_create","create");

        String sql_all = "CREATE TABLE IF NOT EXISTS allData " +
                "(" + "_ID INTEGER PRIMARY KEY " + ",year_game VARCHAR(5),month_game VARCHAR(10),day_game VARCHAR(3)" +
                ",blue_team VARCHAR(20),red_team VARCHAR(20)," + "game_format INTEGER," + "blue_score INTEGER,red_score INTEGER" +
                ",sub_Number INTEGER,L_Number INTEGER," +

                "player_0 INTEGER,player_1 INTEGER,player_2 INTEGER,player_3 INTEGER,player_4 INTEGER,player_5 INTEGER," +
                "player_6 INTEGER,player_7 INTEGER,player_8 INTEGER,player_9 INTEGER,player_10 INTEGER,player_11 INTEGER," +

                " player_0_name VARCHAR(20),player_1_name VARCHAR(20),player_2_name VARCHAR(20),player_3_name VARCHAR(20)," +
                " player_4_name VARCHAR(20),player_5_name VARCHAR(20),player_6_name VARCHAR(20),player_7_name VARCHAR(20)," +
                " player_8_name VARCHAR(20),player_9_name VARCHAR(20),player_10_name VARCHAR(20),player_11_name VARCHAR(20)," +

                " player_0_place VARCHAR(3),player_1_place VARCHAR(3),player_2_place VARCHAR(3),player_3_place VARCHAR(3)," +
                " player_4_place VARCHAR(3),player_5_place VARCHAR(3),player_6_place VARCHAR(3),player_7_place VARCHAR(3)," +
                " player_8_place VARCHAR(3),player_9_place VARCHAR(3),player_10_place VARCHAR(3),player_11_place VARCHAR(3)," +

                "player_0_attack_all INTEGER,player_0_attack_success INTEGER,player_0_attack_mistake INTEGER," +
                "player_0_defence_all INTEGER,player_0_defence_success INTEGER,player_0_defence_mistake INTEGER," +
                "player_0_serve_all INTEGER,player_0_serve_success INTEGER,player_0_serve_mistake INTEGER," +
                "player_0_block_all INTEGER,player_0_block_success INTEGER,player_0_block_mistake INTEGER,player_0_block_touch INTEGER," +
                "player_0_set_all INTEGER,player_0_set_success INTEGER,player_0_set_mistake INTEGER," +

                "player_1_attack_all INTEGER,player_1_attack_success INTEGER,player_1_attack_mistake INTEGER," +
                "player_1_defence_all INTEGER,player_1_defence_success INTEGER,player_1_defence_mistake INTEGER," +
                "player_1_serve_all INTEGER,player_1_serve_success INTEGER,player_1_serve_mistake INTEGER," +
                "player_1_block_all INTEGER,player_1_block_success INTEGER,player_1_block_mistake INTEGER,player_1_block_touch INTEGER," +
                "player_1_set_all INTEGER,player_1_set_success INTEGER,player_1_set_mistake INTEGER," +

                "player_2_attack_all INTEGER,player_2_attack_success INTEGER,player_2_attack_mistake INTEGER," +
                "player_2_defence_all INTEGER,player_2_defence_success INTEGER,player_2_defence_mistake INTEGER," +
                "player_2_serve_all INTEGER,player_2_serve_success INTEGER,player_2_serve_mistake INTEGER," +
                "player_2_block_all INTEGER,player_2_block_success INTEGER,player_2_block_mistake INTEGER,player_2_block_touch INTEGER," +
                "player_2_set_all INTEGER,player_2_set_success INTEGER,player_2_set_mistake INTEGER," +

                "player_3_attack_all INTEGER,player_3_attack_success INTEGER,player_3_attack_mistake INTEGER," +
                "player_3_defence_all INTEGER,player_3_defence_success INTEGER,player_3_defence_mistake INTEGER," +
                "player_3_serve_all INTEGER,player_3_serve_success INTEGER,player_3_serve_mistake INTEGER," +
                "player_3_block_all INTEGER,player_3_block_success INTEGER,player_3_block_mistake INTEGER,player_3_block_touch INTEGER," +
                "player_3_set_all INTEGER,player_3_set_success INTEGER,player_3_set_mistake INTEGER," +

                "player_4_attack_all INTEGER,player_4_attack_success INTEGER,player_4_attack_mistake INTEGER," +
                "player_4_defence_all INTEGER,player_4_defence_success INTEGER,player_4_defence_mistake INTEGER," +
                "player_4_serve_all INTEGER,player_4_serve_success INTEGER,player_4_serve_mistake INTEGER," +
                "player_4_block_all INTEGER,player_4_block_success INTEGER,player_4_block_mistake INTEGER,player_4_block_touch INTEGER," +
                "player_4_set_all INTEGER,player_4_set_success INTEGER,player_4_set_mistake INTEGER," +

                "player_5_attack_all INTEGER,player_5_attack_success INTEGER,player_5_attack_mistake INTEGER," +
                "player_5_defence_all INTEGER,player_5_defence_success INTEGER,player_5_defence_mistake INTEGER," +
                "player_5_serve_all INTEGER,player_5_serve_success INTEGER,player_5_serve_mistake INTEGER," +
                "player_5_block_all INTEGER,player_5_block_success INTEGER,player_5_block_mistake INTEGER,player_5_block_touch INTEGER," +
                "player_5_set_all INTEGER,player_5_set_success INTEGER,player_5_set_mistake INTEGER," +

                "player_6_attack_all INTEGER,player_6_attack_success INTEGER,player_6_attack_mistake INTEGER," +
                "player_6_defence_all INTEGER,player_6_defence_success INTEGER,player_6_defence_mistake INTEGER," +
                "player_6_serve_all INTEGER,player_6_serve_success INTEGER,player_6_serve_mistake INTEGER," +
                "player_6_block_all INTEGER,player_6_block_success INTEGER,player_6_block_mistake INTEGER,player_6_block_touch INTEGER," +
                "player_6_set_all INTEGER,player_6_set_success INTEGER,player_6_set_mistake INTEGER," +

                "player_7_attack_all INTEGER,player_7_attack_success INTEGER,player_7_attack_mistake INTEGER," +
                "player_7_defence_all INTEGER,player_7_defence_success INTEGER,player_7_defence_mistake INTEGER," +
                "player_7_serve_all INTEGER,player_7_serve_success INTEGER,player_7_serve_mistake INTEGER," +
                "player_7_block_all INTEGER,player_7_block_success INTEGER,player_7_block_mistake INTEGER,player_7_block_touch INTEGER," +
                "player_7_set_all INTEGER,player_7_set_success INTEGER,player_7_set_mistake INTEGER," +

                "player_8_attack_all INTEGER,player_8_attack_success INTEGER,player_8_attack_mistake INTEGER," +
                "player_8_defence_all INTEGER,player_8_defence_success INTEGER,player_8_defence_mistake INTEGER," +
                "player_8_serve_all INTEGER,player_8_serve_success INTEGER,player_8_serve_mistake INTEGER," +
                "player_8_block_all INTEGER,player_8_block_success INTEGER,player_8_block_mistake INTEGER,player_8_block_touch INTEGER," +
                "player_8_set_all INTEGER,player_8_set_success INTEGER,player_8_set_mistake INTEGER," +

                "player_9_attack_all INTEGER,player_9_attack_success INTEGER,player_9_attack_mistake INTEGER," +
                "player_9_defence_all INTEGER,player_9_defence_success INTEGER,player_9_defence_mistake INTEGER," +
                "player_9_serve_all INTEGER,player_9_serve_success INTEGER,player_9_serve_mistake INTEGER," +
                "player_9_block_all INTEGER,player_9_block_success INTEGER,player_9_block_mistake INTEGER,player_9_block_touch INTEGER," +
                "player_9_set_all INTEGER,player_9_set_success INTEGER,player_9_set_mistake INTEGER," +

                "player_10_attack_all INTEGER,player_10_attack_success INTEGER,player_10_attack_mistake INTEGER," +
                "player_10_defence_all INTEGER,player_10_defence_success INTEGER,player_10_defence_mistake INTEGER," +
                "player_10_serve_all INTEGER,player_10_serve_success INTEGER,player_10_serve_mistake INTEGER," +
                "player_10_block_all INTEGER,player_10_block_success INTEGER,player_10_block_mistake INTEGER,player_10_block_touch INTEGER," +
                "player_10_set_all INTEGER,player_10_set_success INTEGER,player_10_set_mistake INTEGER," +

                "player_11_attack_all INTEGER,player_11_attack_success INTEGER,player_11_attack_mistake INTEGER," +
                "player_11_defence_all INTEGER,player_11_defence_success INTEGER,player_11_defence_mistake INTEGER," +
                "player_11_serve_all INTEGER,player_11_serve_success INTEGER,player_11_serve_mistake INTEGER," +
                "player_11_block_all INTEGER,player_11_block_success INTEGER,player_11_block_mistake INTEGER,player_11_block_touch INTEGER," +
                "player_11_set_all INTEGER,player_11_set_success INTEGER,player_11_set_mistake INTEGER" +

                ");";

        String sql_tmp = "CREATE TABLE IF NOT EXISTS tmpData " +
                "(" + "_ID INTEGER PRIMARY KEY" + ",year_game VARCHAR(5),month_game VARCHAR(10),day_game VARCHAR(3)" +
                ",blue_team VARCHAR(20),red_team VARCHAR(20)," + "game_format INTEGER," + "blue_score INTEGER,red_score INTEGER" +
                ",sub_Number INTEGER,L_Number INTEGER," +

                "player_0 INTEGER,player_1 INTEGER,player_2 INTEGER,player_3 INTEGER,player_4 INTEGER,player_5 INTEGER," +
                "player_6 INTEGER,player_7 INTEGER,player_8 INTEGER,player_9 INTEGER,player_10 INTEGER,player_11 INTEGER," +

                " player_0_name VARCHAR(20),player_1_name VARCHAR(20),player_2_name VARCHAR(20),player_3_name VARCHAR(20)," +
                " player_4_name VARCHAR(20),player_5_name VARCHAR(20),player_6_name VARCHAR(20),player_7_name VARCHAR(20)," +
                " player_8_name VARCHAR(20),player_9_name VARCHAR(20),player_10_name VARCHAR(20),player_11_name VARCHAR(20)," +

                " player_0_place VARCHAR(3),player_1_place VARCHAR(3),player_2_place VARCHAR(3),player_3_place VARCHAR(3)," +
                " player_4_place VARCHAR(3),player_5_place VARCHAR(3),player_6_place VARCHAR(3),player_7_place VARCHAR(3)," +
                " player_8_place VARCHAR(3),player_9_place VARCHAR(3),player_10_place VARCHAR(3),player_11_place VARCHAR(3)," +

                "player_0_attack_all INTEGER,player_0_attack_success INTEGER,player_0_attack_mistake INTEGER," +
                "player_0_defence_all INTEGER,player_0_defence_success INTEGER,player_0_defence_mistake INTEGER," +
                "player_0_serve_all INTEGER,player_0_serve_success INTEGER,player_0_serve_mistake INTEGER," +
                "player_0_block_all INTEGER,player_0_block_success INTEGER,player_0_block_mistake INTEGER,player_0_block_touch INTEGER," +
                "player_0_set_all INTEGER,player_0_set_success INTEGER,player_0_set_mistake INTEGER," +

                "player_1_attack_all INTEGER,player_1_attack_success INTEGER,player_1_attack_mistake INTEGER," +
                "player_1_defence_all INTEGER,player_1_defence_success INTEGER,player_1_defence_mistake INTEGER," +
                "player_1_serve_all INTEGER,player_1_serve_success INTEGER,player_1_serve_mistake INTEGER," +
                "player_1_block_all INTEGER,player_1_block_success INTEGER,player_1_block_mistake INTEGER,player_1_block_touch INTEGER," +
                "player_1_set_all INTEGER,player_1_set_success INTEGER,player_1_set_mistake INTEGER," +

                "player_2_attack_all INTEGER,player_2_attack_success INTEGER,player_2_attack_mistake INTEGER," +
                "player_2_defence_all INTEGER,player_2_defence_success INTEGER,player_2_defence_mistake INTEGER," +
                "player_2_serve_all INTEGER,player_2_serve_success INTEGER,player_2_serve_mistake INTEGER," +
                "player_2_block_all INTEGER,player_2_block_success INTEGER,player_2_block_mistake INTEGER,player_2_block_touch INTEGER," +
                "player_2_set_all INTEGER,player_2_set_success INTEGER,player_2_set_mistake INTEGER," +

                "player_3_attack_all INTEGER,player_3_attack_success INTEGER,player_3_attack_mistake INTEGER," +
                "player_3_defence_all INTEGER,player_3_defence_success INTEGER,player_3_defence_mistake INTEGER," +
                "player_3_serve_all INTEGER,player_3_serve_success INTEGER,player_3_serve_mistake INTEGER," +
                "player_3_block_all INTEGER,player_3_block_success INTEGER,player_3_block_mistake INTEGER,player_3_block_touch INTEGER," +
                "player_3_set_all INTEGER,player_3_set_success INTEGER,player_3_set_mistake INTEGER," +

                "player_4_attack_all INTEGER,player_4_attack_success INTEGER,player_4_attack_mistake INTEGER," +
                "player_4_defence_all INTEGER,player_4_defence_success INTEGER,player_4_defence_mistake INTEGER," +
                "player_4_serve_all INTEGER,player_4_serve_success INTEGER,player_4_serve_mistake INTEGER," +
                "player_4_block_all INTEGER,player_4_block_success INTEGER,player_4_block_mistake INTEGER,player_4_block_touch INTEGER," +
                "player_4_set_all INTEGER,player_4_set_success INTEGER,player_4_set_mistake INTEGER," +

                "player_5_attack_all INTEGER,player_5_attack_success INTEGER,player_5_attack_mistake INTEGER," +
                "player_5_defence_all INTEGER,player_5_defence_success INTEGER,player_5_defence_mistake INTEGER," +
                "player_5_serve_all INTEGER,player_5_serve_success INTEGER,player_5_serve_mistake INTEGER," +
                "player_5_block_all INTEGER,player_5_block_success INTEGER,player_5_block_mistake INTEGER,player_5_block_touch INTEGER," +
                "player_5_set_all INTEGER,player_5_set_success INTEGER,player_5_set_mistake INTEGER," +

                "player_6_attack_all INTEGER,player_6_attack_success INTEGER,player_6_attack_mistake INTEGER," +
                "player_6_defence_all INTEGER,player_6_defence_success INTEGER,player_6_defence_mistake INTEGER," +
                "player_6_serve_all INTEGER,player_6_serve_success INTEGER,player_6_serve_mistake INTEGER," +
                "player_6_block_all INTEGER,player_6_block_success INTEGER,player_6_block_mistake INTEGER,player_6_block_touch INTEGER," +
                "player_6_set_all INTEGER,player_6_set_success INTEGER,player_6_set_mistake INTEGER," +

                "player_7_attack_all INTEGER,player_7_attack_success INTEGER,player_7_attack_mistake INTEGER," +
                "player_7_defence_all INTEGER,player_7_defence_success INTEGER,player_7_defence_mistake INTEGER," +
                "player_7_serve_all INTEGER,player_7_serve_success INTEGER,player_7_serve_mistake INTEGER," +
                "player_7_block_all INTEGER,player_7_block_success INTEGER,player_7_block_mistake INTEGER,player_7_block_touch INTEGER," +
                "player_7_set_all INTEGER,player_7_set_success INTEGER,player_7_set_mistake INTEGER," +

                "player_8_attack_all INTEGER,player_8_attack_success INTEGER,player_8_attack_mistake INTEGER," +
                "player_8_defence_all INTEGER,player_8_defence_success INTEGER,player_8_defence_mistake INTEGER," +
                "player_8_serve_all INTEGER,player_8_serve_success INTEGER,player_8_serve_mistake INTEGER," +
                "player_8_block_all INTEGER,player_8_block_success INTEGER,player_8_block_mistake INTEGER,player_8_block_touch INTEGER," +
                "player_8_set_all INTEGER,player_8_set_success INTEGER,player_8_set_mistake INTEGER," +

                "player_9_attack_all INTEGER,player_9_attack_success INTEGER,player_9_attack_mistake INTEGER," +
                "player_9_defence_all INTEGER,player_9_defence_success INTEGER,player_9_defence_mistake INTEGER," +
                "player_9_serve_all INTEGER,player_9_serve_success INTEGER,player_9_serve_mistake INTEGER," +
                "player_9_block_all INTEGER,player_9_block_success INTEGER,player_9_block_mistake INTEGER,player_9_block_touch INTEGER," +
                "player_9_set_all INTEGER,player_9_set_success INTEGER,player_9_set_mistake INTEGER," +

                "player_10_attack_all INTEGER,player_10_attack_success INTEGER,player_10_attack_mistake INTEGER," +
                "player_10_defence_all INTEGER,player_10_defence_success INTEGER,player_10_defence_mistake INTEGER," +
                "player_10_serve_all INTEGER,player_10_serve_success INTEGER,player_10_serve_mistake INTEGER," +
                "player_10_block_all INTEGER,player_10_block_success INTEGER,player_10_block_mistake INTEGER,player_10_block_touch INTEGER," +
                "player_10_set_all INTEGER,player_10_set_success INTEGER,player_10_set_mistake INTEGER," +

                "player_11_attack_all INTEGER,player_11_attack_success INTEGER,player_11_attack_mistake INTEGER," +
                "player_11_defence_all INTEGER,player_11_defence_success INTEGER,player_11_defence_mistake INTEGER," +
                "player_11_serve_all INTEGER,player_11_serve_success INTEGER,player_11_serve_mistake INTEGER," +
                "player_11_block_all INTEGER,player_11_block_success INTEGER,player_11_block_mistake INTEGER,player_11_block_touch INTEGER," +
                "player_11_set_all INTEGER,player_11_set_success INTEGER,player_11_set_mistake INTEGER" +

                ");";

        sqLiteDatabase.execSQL(sql_all);
        sqLiteDatabase.execSQL(sql_tmp);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j) {

    }


    public void addAll(GameData games_playings, Player[] players) {
        //Log.w("db_add_all","add");
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db_2 = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        Cursor c = db_2.rawQuery("SELECT _ID FROM allData",null);
        int tmp_id_number;

        if(c.moveToLast())
        {
            tmp_id_number = c.getInt(0);
            tmp_id_number++;
        }
        else
        {
            tmp_id_number = 0;
        }

//        Log.w("id_number_add_all",String.valueOf(tmp_id_number));
        cv.put(KEY_ID,tmp_id_number);
        cv.put(KEY_YEAR,games_playings.getYear());
        cv.put(KEY_MONTH,games_playings.getMonth());
        cv.put(KEY_DAY,games_playings.getDay());
        cv.put(KEY_BLUE_TEAM,games_playings.getBlueName());
        cv.put(KEY_RED_TEAM,games_playings.getRedName());
        cv.put(KEY_FORMAT,games_playings.getFormat());
        cv.put(KEY_BLUE_SCORE,games_playings.getBlueScore());
        cv.put(KEY_RED_SCORE,games_playings.getRedScore());
        cv.put(KEY_SUB_NUMBER,games_playings.getSubCount());
        cv.put(KEY_L_NUMBER,games_playings.getLCount());

//        Log.w("sub_0_name_db",players[6].GetName());
        //Log.w("total_attack_db",String.valueOf(players[0].getTotalAttack()));
        //Log.w("success_attack_db",String.valueOf(players[0].getSuccessAttack()));
        //Log.w("mistake_attack_db",String.valueOf(players[0].getMistakeAttack()));


        for(int i=0;i<12;i++) {
            cv.put(KEY_PLAYER+i,players[i].getNumber());
            cv.put(KEY_PLAYER+i+KEY_NAME,players[i].getName());
//            Log.w("sub_all_player_name_db",players[i].GetName() + "   " + i);
            cv.put(KEY_PLAYER+i+KEY_PLACE,players[i].getPosition());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_ATTACK+KEY_PLAYER_ALL,players[i].getTotalAttack());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_ATTACK+KEY_PLAYER_SUCCESS,players[i].getSuccessAttack());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_ATTACK+KEY_PLAYER_MISTAKE,players[i].getMistakeAttack());

            cv.put(KEY_PLAYER+i+KEY_PLAYER_DEFENCE+KEY_PLAYER_ALL,players[i].getTotalDefence());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_DEFENCE+KEY_PLAYER_SUCCESS,players[i].getSuccessDefence());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_DEFENCE+KEY_PLAYER_MISTAKE,players[i].getMistakeDefence());

            cv.put(KEY_PLAYER+i+KEY_PLAYER_SERVE+KEY_PLAYER_ALL,players[i].getTotalServe());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_SERVE+KEY_PLAYER_SUCCESS,players[i].getSuccessServe());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_SERVE+KEY_PLAYER_MISTAKE,players[i].getMistakeServe());

            cv.put(KEY_PLAYER+i+KEY_PLAYER_BLOCK+KEY_PLAYER_ALL,players[i].getTotalBlock());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_BLOCK+KEY_PLAYER_SUCCESS,players[i].getSuccessBlock());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_BLOCK+KEY_PLAYER_MISTAKE,players[i].getMistakeBlock());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_BLOCK+KEY_PLAYER_TOUCH,players[i].getTouchBlock());

            cv.put(KEY_PLAYER+i+KEY_PLAYER_SET+KEY_PLAYER_ALL,players[i].getTotalSet());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_SET+KEY_PLAYER_SUCCESS,players[i].getSuccessSet());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_SET+KEY_PLAYER_MISTAKE,players[i].getMistakeSet());
        }

        db.insert(TABLE_ALL,null,cv);
    }

    public void addDataTmp(GameData games_playings, Player[] players) {
        Log.w("db_add_tmp","add");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KEY_YEAR,games_playings.getYear());
        cv.put(KEY_MONTH,games_playings.getMonth());
        cv.put(KEY_DAY,games_playings.getDay());
        cv.put(KEY_BLUE_TEAM,games_playings.getBlueName());
        cv.put(KEY_RED_TEAM,games_playings.getRedName());
        cv.put(KEY_FORMAT,games_playings.getFormat());
        cv.put(KEY_BLUE_SCORE,games_playings.getBlueScore());
        cv.put(KEY_RED_SCORE,games_playings.getRedScore());
        cv.put(KEY_SUB_NUMBER,games_playings.getSubCount());
        cv.put(KEY_L_NUMBER,games_playings.getLCount());

        Log.w("game_set_data_db", "8" + players[0].getNumber() + "7");

        for(int i=0;i<12;i++) {
            cv.put(KEY_PLAYER+i,players[i].getNumber());
            cv.put(KEY_PLAYER+i+KEY_NAME,players[i].getName());
            cv.put(KEY_PLAYER+i+KEY_PLACE,players[i].getPosition());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_ATTACK+KEY_PLAYER_ALL,players[i].getTotalAttack());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_ATTACK+KEY_PLAYER_SUCCESS,players[i].getSuccessAttack());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_ATTACK+KEY_PLAYER_MISTAKE,players[i].getMistakeAttack());

            cv.put(KEY_PLAYER+i+KEY_PLAYER_DEFENCE+KEY_PLAYER_ALL,players[i].getTotalDefence());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_DEFENCE+KEY_PLAYER_SUCCESS,players[i].getSuccessDefence());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_DEFENCE+KEY_PLAYER_MISTAKE,players[i].getMistakeDefence());

            cv.put(KEY_PLAYER+i+KEY_PLAYER_SERVE+KEY_PLAYER_ALL,players[i].getTotalServe());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_SERVE+KEY_PLAYER_SUCCESS,players[i].getSuccessServe());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_SERVE+KEY_PLAYER_MISTAKE,players[i].getMistakeServe());

            cv.put(KEY_PLAYER+i+KEY_PLAYER_BLOCK+KEY_PLAYER_ALL,players[i].getTotalBlock());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_BLOCK+KEY_PLAYER_SUCCESS,players[i].getSuccessBlock());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_BLOCK+KEY_PLAYER_MISTAKE,players[i].getMistakeBlock());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_BLOCK+KEY_PLAYER_TOUCH,players[i].getTouchBlock());

            cv.put(KEY_PLAYER+i+KEY_PLAYER_SET+KEY_PLAYER_ALL,players[i].getTotalSet());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_SET+KEY_PLAYER_SUCCESS,players[i].getSuccessSet());
            cv.put(KEY_PLAYER+i+KEY_PLAYER_SET+KEY_PLAYER_MISTAKE,players[i].getMistakeSet());
        }

        db.insert(TABLE_TMP,null,cv);
    }


    public GameData getGameTmp() {
        SQLiteDatabase db = this.getReadableDatabase();
        GameData gameData;
        gameData = new GameData();

        Cursor c = db.rawQuery("SELECT" + " year_game,month_game,day_game" +
                ",blue_team,red_team" +
                ",game_format" +
                ",sub_Number,L_Number " +
                ",blue_score,red_score " +
                "FROM tmpData",null);

        c.moveToFirst();

        gameData.setYear(c.getString(0));
        gameData.setMonth(c.getString(1));
        gameData.setDay(c.getString(2));
        gameData.setBlueName(c.getString(3));
        gameData.setRedName(c.getString(4));
        gameData.setFormat(c.getInt(5));
        gameData.setSubCount_Data(c.getInt(6));
        gameData.setLCount_Data(c.getInt(7));
        gameData.setBlueScore(c.getInt(8));
        gameData.setRedScore(c.getInt(9));

//        Log.w("blue_name_db",c.getString(3));
//        Log.w("red_name_db",c.getString(4));

        return gameData;
    }

    public Player[] getPlayerTmp() {
        Player player_tmp;
        Player[] players;
        SQLiteDatabase db = this.getReadableDatabase();

        players = new Player[12];
        for(int i=0;i<12;i++)
        {
            player_tmp = new Player();
            players[i] = player_tmp;
        }
//        Log.w("player_0_number_get_db_0",players[0].GetNumber());
//        Log.w("player_1_number_get_db_0",players[1].GetNumber());

        Cursor c = db.rawQuery("SELECT " +

                "player_0,player_1,player_2,player_3,player_4,player_5," +
                "player_6,player_7,player_8,player_9,player_10,player_11," +  //11

                "player_0_name,player_1_name,player_2_name,player_3_name," +
                "player_4_name,player_5_name,player_6_name,player_7_name," +
                "player_8_name,player_9_name,player_10_name,player_11_name," +            //23

                "player_0_place,player_1_place,player_2_place,player_3_place," +
                "player_4_place,player_5_place,player_6_place,player_7_place," +
                "player_8_place,player_9_place,player_10_place,player_11_place, " +         //35

                "player_0_attack_all ,player_0_attack_success ,player_0_attack_mistake ," +
                "player_0_defence_all ,player_0_defence_success ,player_0_defence_mistake ," +
                "player_0_serve_all ,player_0_serve_success ,player_0_serve_mistake ," +
                "player_0_block_all ,player_0_block_success ,player_0_block_mistake ,player_0_block_touch ," +
                "player_0_set_all ,player_0_set_success ,player_0_set_mistake ," +    //51

                "player_1_attack_all ,player_1_attack_success ,player_1_attack_mistake ," +
                "player_1_defence_all ,player_1_defence_success ,player_1_defence_mistake ," +
                "player_1_serve_all ,player_1_serve_success ,player_1_serve_mistake ," +
                "player_1_block_all ,player_1_block_success ,player_1_block_mistake ,player_1_block_touch ," +
                "player_1_set_all ,player_1_set_success ,player_1_set_mistake ," +  //67

                "player_2_attack_all ,player_2_attack_success ,player_2_attack_mistake ," +
                "player_2_defence_all ,player_2_defence_success ,player_2_defence_mistake ," +
                "player_2_serve_all ,player_2_serve_success ,player_2_serve_mistake ," +
                "player_2_block_all ,player_2_block_success ,player_2_block_mistake ,player_2_block_touch ," +
                "player_2_set_all ,player_2_set_success ,player_2_set_mistake ," +         //83

                "player_3_attack_all ,player_3_attack_success ,player_3_attack_mistake ," +
                "player_3_defence_all ,player_3_defence_success ,player_3_defence_mistake ," +
                "player_3_serve_all ,player_3_serve_success ,player_3_serve_mistake ," +
                "player_3_block_all ,player_3_block_success ,player_3_block_mistake ,player_3_block_touch ," +
                "player_3_set_all ,player_3_set_success ,player_3_set_mistake ," +    //99

                "player_4_attack_all ,player_4_attack_success ,player_4_attack_mistake ," +
                "player_4_defence_all ,player_4_defence_success ,player_4_defence_mistake ," +
                "player_4_serve_all ,player_4_serve_success ,player_4_serve_mistake ," +
                "player_4_block_all ,player_4_block_success ,player_4_block_mistake ,player_4_block_touch ," +
                "player_4_set_all ,player_4_set_success ,player_4_set_mistake ," +   //115

                "player_5_attack_all ,player_5_attack_success ,player_5_attack_mistake ," +
                "player_5_defence_all ,player_5_defence_success ,player_5_defence_mistake ," +
                "player_5_serve_all ,player_5_serve_success ,player_5_serve_mistake ," +
                "player_5_block_all ,player_5_block_success ,player_5_block_mistake ,player_5_block_touch ," +
                "player_5_set_all ,player_5_set_success ,player_5_set_mistake ," +          //131

                "player_6_attack_all ,player_6_attack_success ,player_6_attack_mistake ," +
                "player_6_defence_all ,player_6_defence_success ,player_6_defence_mistake ," +
                "player_6_serve_all ,player_6_serve_success ,player_6_serve_mistake ," +
                "player_6_block_all ,player_6_block_success ,player_6_block_mistake ,player_6_block_touch ," +
                "player_6_set_all ,player_6_set_success ,player_6_set_mistake ," +      //147

                "player_7_attack_all ,player_7_attack_success ,player_7_attack_mistake ," +
                "player_7_defence_all ,player_7_defence_success ,player_7_defence_mistake ," +
                "player_7_serve_all ,player_7_serve_success ,player_7_serve_mistake ," +
                "player_7_block_all ,player_7_block_success ,player_7_block_mistake ,player_7_block_touch ," +
                "player_7_set_all ,player_7_set_success ,player_7_set_mistake ," +        //163

                "player_8_attack_all ,player_8_attack_success ,player_8_attack_mistake ," +
                "player_8_defence_all ,player_8_defence_success ,player_8_defence_mistake ," +
                "player_8_serve_all ,player_8_serve_success ,player_8_serve_mistake ," +
                "player_8_block_all ,player_8_block_success ,player_8_block_mistake ,player_8_block_touch ," +
                "player_8_set_all ,player_8_set_success ,player_8_set_mistake ," +        //179

                "player_9_attack_all ,player_9_attack_success ,player_9_attack_mistake ," +
                "player_9_defence_all ,player_9_defence_success ,player_9_defence_mistake ," +
                "player_9_serve_all ,player_9_serve_success ,player_9_serve_mistake ," +
                "player_9_block_all ,player_9_block_success ,player_9_block_mistake ,player_9_block_touch ," +
                "player_9_set_all ,player_9_set_success ,player_9_set_mistake ," +           //195

                "player_10_attack_all ,player_10_attack_success ,player_10_attack_mistake ," +
                "player_10_defence_all ,player_10_defence_success ,player_10_defence_mistake ," +
                "player_10_serve_all ,player_10_serve_success ,player_10_serve_mistake ," +
                "player_10_block_all ,player_10_block_success ,player_10_block_mistake ,player_10_block_touch ," +
                "player_10_set_all ,player_10_set_success ,player_10_set_mistake ," +          //211

                "player_11_attack_all ,player_11_attack_success ,player_11_attack_mistake ," +
                "player_11_defence_all ,player_11_defence_success ,player_11_defence_mistake ," +
                "player_11_serve_all ,player_11_serve_success ,player_11_serve_mistake ," +
                "player_11_block_all ,player_11_block_success ,player_11_block_mistake ,player_11_block_touch ," +
                "player_11_set_all ,player_11_set_success ,player_11_set_mistake " +        //227

                "FROM tmpData", null);

        c.moveToFirst();

        for(int i=0;i<12;i++) {
            players[i].setNumber(c.getString(i));
            players[i].setName(c.getString(i+12));
            players[i].setPosition(c.getString(i+24));

            players[i].setAllAttack(c.getInt(36+i*16));
            players[i].setSuccessAttack(c.getInt(37+i*16));
            players[i].setMistakeAttack(c.getInt(38+i*16));
            players[i].setAllDefence(c.getInt(39+i*16));
            players[i].setSuccessBlock(c.getInt(40+i*16));
            players[i].setMistakeDefence(c.getInt(41+i*16));
            players[i].setAllServe(c.getInt(42+i*16));
            players[i].setSuccessServe(c.getInt(43+i*16));
            players[i].setMistakeServe(c.getInt(44+i*16));
            players[i].setAllBlock(c.getInt(45+i*16));
            players[i].setSuccessBlock(c.getInt(46+i*16));
            players[i].setMistakeBlock(c.getInt(47+i*16));
            players[i].setTouchBlock(c.getInt(48+i*16));
            players[i].setAllSet(c.getInt(49+i*16));
            players[i].setSuccessSet(c.getInt(50+i*16));

//            Log.w("success_attack_"+i,String.valueOf(c.getInt(37+i*16)));
        }

//        Log.w("player_sub_0_number_get_db_1",players[6].GetNumber());

        return players;
    }

    public void deleteTable() {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.w("db_delete_db_tmp","delete");
        db.delete(TABLE_TMP, null, null);
    }
    public void deleteTableAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.w("db_delete_db_all","delete");
        db.delete(TABLE_ALL, null, null);
    }

    public int GetData_number() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT _ID FROM allData",null);

        if(c.moveToLast())
        {
            return c.getInt(0)+1;
        }

//        Log.w("_id_number_db",String.valueOf(c.getInt(0)));
        else
        {
            return 0;
        }

    }

    public GameData[] GetAllGame() {
        SQLiteDatabase db = this.getReadableDatabase();
        GameData[] tmp_gameData;

        Cursor c = db.rawQuery("SELECT" + " _ID,year_game,month_game,day_game" +
                ",blue_team,red_team" +
                ",game_format" +
                ",sub_Number,L_Number " +
                ",blue_score,red_score " +
                "FROM allData",null);


        int tmp_number = GetData_number();
        GameData tmp_game;
        tmp_gameData = new GameData[tmp_number];

        for(int i=0;i<tmp_number;i++) {
            tmp_game = new GameData();
            tmp_gameData[i] = tmp_game;
        }

        if(tmp_number != 0) {
            c.moveToFirst();
            for(int i=0;i<tmp_number;i++) {
                tmp_gameData[i].setYear(c.getString(1));
                tmp_gameData[i].setMonth(c.getString(2));
                tmp_gameData[i].setDay(c.getString(3));
                tmp_gameData[i].setBlueName(c.getString(4));
                tmp_gameData[i].setRedName(c.getString(5));
                tmp_gameData[i].setFormat(c.getInt(6));
                tmp_gameData[i].setSubCount_Data(c.getInt(7));
                tmp_gameData[i].setLCount_Data(c.getInt(8));
                tmp_gameData[i].setBlueScore(c.getInt(9));
                tmp_gameData[i].setRedScore(c.getInt(10));

                c.moveToNext();
            }
        }

        return tmp_gameData;
    }

    public Player[] getPlayerAll(int x) {
        Player player_tmp;
        Player[] players;
        SQLiteDatabase db = this.getReadableDatabase();

        players = new Player[12];
        for(int i=0;i<12;i++) {
            player_tmp = new Player();
            players[i] = player_tmp;
        }

        Cursor c = db.rawQuery("SELECT " +

                "player_0,player_1,player_2,player_3,player_4,player_5," +
                "player_6,player_7,player_8,player_9,player_10,player_11," +

                "player_0_name,player_1_name,player_2_name,player_3_name," +
                "player_4_name,player_5_name,player_6_name,player_7_name," +
                "player_8_name,player_9_name,player_10_name,player_11_name," +

                "player_0_place,player_1_place,player_2_place,player_3_place," +
                "player_4_place,player_5_place,player_6_place,player_7_place," +
                "player_8_place,player_9_place,player_10_place,player_11_place, " +         //35

                "player_0_attack_all ,player_0_attack_success ,player_0_attack_mistake ," +
                "player_0_defence_all ,player_0_defence_success ,player_0_defence_mistake ," +
                "player_0_serve_all ,player_0_serve_success ,player_0_serve_mistake ," +
                "player_0_block_all ,player_0_block_success ,player_0_block_mistake ,player_0_block_touch ," +
                "player_0_set_all ,player_0_set_success ,player_0_set_mistake ," +    //51

                "player_1_attack_all ,player_1_attack_success ,player_1_attack_mistake ," +
                "player_1_defence_all ,player_1_defence_success ,player_1_defence_mistake ," +
                "player_1_serve_all ,player_1_serve_success ,player_1_serve_mistake ," +
                "player_1_block_all ,player_1_block_success ,player_1_block_mistake ,player_1_block_touch ," +
                "player_1_set_all ,player_1_set_success ,player_1_set_mistake ," +  //67

                "player_2_attack_all ,player_2_attack_success ,player_2_attack_mistake ," +
                "player_2_defence_all ,player_2_defence_success ,player_2_defence_mistake ," +
                "player_2_serve_all ,player_2_serve_success ,player_2_serve_mistake ," +
                "player_2_block_all ,player_2_block_success ,player_2_block_mistake ,player_2_block_touch ," +
                "player_2_set_all ,player_2_set_success ,player_2_set_mistake ," +         //83

                "player_3_attack_all ,player_3_attack_success ,player_3_attack_mistake ," +
                "player_3_defence_all ,player_3_defence_success ,player_3_defence_mistake ," +
                "player_3_serve_all ,player_3_serve_success ,player_3_serve_mistake ," +
                "player_3_block_all ,player_3_block_success ,player_3_block_mistake ,player_3_block_touch ," +
                "player_3_set_all ,player_3_set_success ,player_3_set_mistake ," +    //99

                "player_4_attack_all ,player_4_attack_success ,player_4_attack_mistake ," +
                "player_4_defence_all ,player_4_defence_success ,player_4_defence_mistake ," +
                "player_4_serve_all ,player_4_serve_success ,player_4_serve_mistake ," +
                "player_4_block_all ,player_4_block_success ,player_4_block_mistake ,player_4_block_touch ," +
                "player_4_set_all ,player_4_set_success ,player_4_set_mistake ," +   //115

                "player_5_attack_all ,player_5_attack_success ,player_5_attack_mistake ," +
                "player_5_defence_all ,player_5_defence_success ,player_5_defence_mistake ," +
                "player_5_serve_all ,player_5_serve_success ,player_5_serve_mistake ," +
                "player_5_block_all ,player_5_block_success ,player_5_block_mistake ,player_5_block_touch ," +
                "player_5_set_all ,player_5_set_success ,player_5_set_mistake ," +          //131

                "player_6_attack_all ,player_6_attack_success ,player_6_attack_mistake ," +
                "player_6_defence_all ,player_6_defence_success ,player_6_defence_mistake ," +
                "player_6_serve_all ,player_6_serve_success ,player_6_serve_mistake ," +
                "player_6_block_all ,player_6_block_success ,player_6_block_mistake ,player_6_block_touch ," +
                "player_6_set_all ,player_6_set_success ,player_6_set_mistake ," +      //147

                "player_7_attack_all ,player_7_attack_success ,player_7_attack_mistake ," +
                "player_7_defence_all ,player_7_defence_success ,player_7_defence_mistake ," +
                "player_7_serve_all ,player_7_serve_success ,player_7_serve_mistake ," +
                "player_7_block_all ,player_7_block_success ,player_7_block_mistake ,player_7_block_touch ," +
                "player_7_set_all ,player_7_set_success ,player_7_set_mistake ," +        //163

                "player_8_attack_all ,player_8_attack_success ,player_8_attack_mistake ," +
                "player_8_defence_all ,player_8_defence_success ,player_8_defence_mistake ," +
                "player_8_serve_all ,player_8_serve_success ,player_8_serve_mistake ," +
                "player_8_block_all ,player_8_block_success ,player_8_block_mistake ,player_8_block_touch ," +
                "player_8_set_all ,player_8_set_success ,player_8_set_mistake ," +        //179

                "player_9_attack_all ,player_9_attack_success ,player_9_attack_mistake ," +
                "player_9_defence_all ,player_9_defence_success ,player_9_defence_mistake ," +
                "player_9_serve_all ,player_9_serve_success ,player_9_serve_mistake ," +
                "player_9_block_all ,player_9_block_success ,player_9_block_mistake ,player_9_block_touch ," +
                "player_9_set_all ,player_9_set_success ,player_9_set_mistake ," +           //195

                "player_10_attack_all ,player_10_attack_success ,player_10_attack_mistake ," +
                "player_10_defence_all ,player_10_defence_success ,player_10_defence_mistake ," +
                "player_10_serve_all ,player_10_serve_success ,player_10_serve_mistake ," +
                "player_10_block_all ,player_10_block_success ,player_10_block_mistake ,player_10_block_touch ," +
                "player_10_set_all ,player_10_set_success ,player_10_set_mistake ," +          //211

                "player_11_attack_all ,player_11_attack_success ,player_11_attack_mistake ," +
                "player_11_defence_all ,player_11_defence_success ,player_11_defence_mistake ," +
                "player_11_serve_all ,player_11_serve_success ,player_11_serve_mistake ," +
                "player_11_block_all ,player_11_block_success ,player_11_block_mistake ,player_11_block_touch ," +
                "player_11_set_all ,player_11_set_success ,player_11_set_mistake,_ID " +        //228

                "FROM allData", null);

        c.moveToFirst();

//        while(c.getInt(228) != x && c.moveToNext()) {
//            Log.w("_id_number_match", x + " " + c.getInt(228));
//        }

//        Log.w("sub_0_name_get_all_db",c.getString(18) + " db");
        for(int i=0;i<12;i++) {
            players[i].setNumber(c.getString(i));
            players[i].setName(c.getString(i+12));
            players[i].setPosition(c.getString(i+24));

            players[i].setAllAttack(c.getInt(36+i*16));
            players[i].setSuccessAttack(c.getInt(37+i*16));
            players[i].setMistakeAttack(c.getInt(38+i*16));
            players[i].setAllDefence(c.getInt(39+i*16));
            players[i].setSuccessDefence(c.getInt(40+i*16));
            players[i].setMistakeDefence(c.getInt(41+i*16));
            players[i].setAllServe(c.getInt(42+i*16));
            players[i].setSuccessServe(c.getInt(43+i*16));
            players[i].setMistakeServe(c.getInt(44+i*16));
            players[i].setAllBlock(c.getInt(45+i*16));
            players[i].setSuccessBlock(c.getInt(46+i*16));
            players[i].setMistakeBlock(c.getInt(47+i*16));
            players[i].setTouchBlock(c.getInt(48+i*16));
            players[i].setAllSet(c.getInt(49+i*16));
            players[i].setSuccessSet(c.getInt(50+i*16));
            players[i].setMistakeSet(c.getInt(51+i*16));
        }

        return players;
    }
}
