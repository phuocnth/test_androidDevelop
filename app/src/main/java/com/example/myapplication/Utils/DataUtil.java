package com.example.myapplication.Utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class DataUtil {
    public static String converObjectToJsonString(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static String getJsonString(JsonObject json, String memberName) {
        return json.get(memberName).getAsString().trim();
    }

    public static JsonArray getJsonArrayWithMember(String strJson) {
        JsonObject jsonObject = new Gson().fromJson(strJson, JsonObject.class);
        return jsonObject.getAsJsonArray("data");
    }
}
