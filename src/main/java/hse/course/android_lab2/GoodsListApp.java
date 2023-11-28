package hse.course.android_lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hse.course.android_lab2.adapter.GoodsAdapter;

public class GoodsListApp extends AppCompatActivity {

    private GoodsAdapter goodsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.goods_list_app_layout);

        RecyclerView recyclerView = findViewById(R.id.goodsRecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        goodsAdapter = new GoodsAdapter(new ArrayList<>());
        recyclerView.setAdapter(goodsAdapter);

        super.onCreate(savedInstanceState);
    }

    public void save(View view) {
        EditText goodEditText = findViewById(R.id.goodEditText);
        String productName = goodEditText.getText().toString();
        goodEditText.setText("");

        goodsAdapter.save(productName);
    }

    public void clear(View view) {
        goodsAdapter.clear();
    }
}
