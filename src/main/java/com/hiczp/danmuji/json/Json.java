package com.hiczp.danmuji.json;

import com.hiczp.danmuji.Config;
import com.hiczp.danmuji.rest.Msg;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by czp on 16-8-20.
 * Parse json
 */
public class Json {
    public static JSONArray getDanMu() {
        try {
            String jsonString = Msg.getData(Config.roomId);

            if (jsonString != null) {
                JSONObject jsonObject = new JSONObject(jsonString).getJSONObject("data");
                return jsonObject.getJSONArray("room");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
