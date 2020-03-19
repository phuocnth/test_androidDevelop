package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.RecyclerViewAdapter;
import com.example.myapplication.Model.Employee;
import com.example.myapplication.Retrofit.APIUtils;
import com.example.myapplication.Retrofit.DataClient;
import com.example.myapplication.Utils.Constants;
import com.example.myapplication.Utils.DataUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Employee> employeesList = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;
    Integer id;
    String name,age,img,salary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    public void getData() {
        DataClient data = APIUtils.getData();
        Call<Object> callback = data.getDataEmployees();
        callback.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                String strJson = DataUtil.converObjectToJsonString(response.body());
                JsonArray jsonArray = DataUtil.getJsonArrayWithMember(strJson);
                JsonObject jsonObj;
                for (JsonElement detail : jsonArray) {
                    jsonObj = detail.getAsJsonObject();
                    id = Integer.parseInt(DataUtil.getJsonString(jsonObj, Constants.ID));
                    name = DataUtil.getJsonString(jsonObj, Constants.EMPLOYEE_NAME);
                    age = DataUtil.getJsonString(jsonObj, Constants.EMPLOYEE_AGE);
                    img = DataUtil.getJsonString(jsonObj, Constants.EMPLOYEE_IMAGE);
                    salary = DataUtil.getJsonString(jsonObj, Constants.EMPLOYEE_SALARY);

                    Employee employee = new Employee(id, name, salary, age, img);
                    employeesList.add(employee);

                    recyclerViewAdapter = new RecyclerViewAdapter(employeesList, R.layout.item_view, MainActivity.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(linearLayoutManager);

                    recyclerView.setAdapter(recyclerViewAdapter);
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }
}
