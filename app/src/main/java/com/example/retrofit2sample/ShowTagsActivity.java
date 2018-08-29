package com.example.retrofit2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class ShowTagsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tags);

        Intent intent = getIntent();
        ArrayList<String> followTags = intent.getStringArrayListExtra("followTags");
        ArrayList<String> followTags2 = intent.getStringArrayListExtra("followTags2");

        Log.d("THISISDEBUG1", String.valueOf(followTags.size()));
        Log.d("THISISDEBUG2", String.valueOf(followTags2.size()));
        String followTagString = String.valueOf(followTags);

        // TableLayoutのグループを取得
        ViewGroup vg = (ViewGroup)findViewById(R.id.TableLayout1);

        for (int i = 0; i < followTags.size(); i++) {
            // 行を追加
            getLayoutInflater().inflate(R.layout.table_row, vg);
            // 文字設定
            TableRow tr = (TableRow)vg.getChildAt(i);
            ((TextView)(tr.getChildAt(0))).setText(followTags.get(i));
        }

        String followTag2String = String.valueOf(followTags2);
        TextView response2 = (TextView)findViewById(R.id.textView);
        response2.setText(followTag2String);
    }
}
