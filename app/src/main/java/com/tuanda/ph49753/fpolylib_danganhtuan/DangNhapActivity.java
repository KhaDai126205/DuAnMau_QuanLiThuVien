package com.tuanda.ph49753.fpolylib_danganhtuan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tuanda.ph49753.fpolylib_danganhtuan.dao.ThuThuDAO;

public class DangNhapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_nhap);

        EditText edtUser = findViewById(R.id.edtUser);
        EditText edtPass = findViewById(R.id.edtPass);
        Button btnDangNhap = findViewById(R.id.btnDangNhap);

        ThuThuDAO thuThuDAO = new ThuThuDAO(this);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                if (thuThuDAO.checkDangNhap(user, pass)) {
                    //lưu


                    startActivity(new Intent(DangNhapActivity.this, MainActivity.class));

                } else {
                    Toast.makeText(DangNhapActivity.this, "Username hoặc Password không đúng !", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}