package com.example.myapplication.Retrofit;

public class APIUtils {
    public static final String URL_ADDRESS = "https://apingweb.com/api/daa62f1fc782e55fb2e8418eb2bf6a1c20/";
    public static DataClient getData(){
        return RetrofitClent.getClient(URL_ADDRESS).create(DataClient.class);
    }
}
