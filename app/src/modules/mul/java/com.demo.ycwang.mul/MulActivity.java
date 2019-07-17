package com.demo.ycwang.mul;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.ycwang.ycwangdemo.R;


/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/2 16:16
 */
public class MulActivity extends Activity {

    EditText edxRate;
    EditText edxAmount;
    EditText edxN;
    TextView txwResult;
    Button btnIn;
    Button btnQu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul);
        edxRate = findViewById(R.id.edx_rate);
        edxAmount = findViewById(R.id.edx_amount);
        edxN = findViewById(R.id.edx_n);
        txwResult = findViewById(R.id.txw_result);
        btnIn = findViewById(R.id.btn_in);
        btnQu = findViewById(R.id.btn_qu);


        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] d = JavaTest.getComplexAmount(getAmount(), getRate(), getN());
                txwResult.setText("CAP:" + d[1] + "   ALL:" + d[0]);
            }
        });


        btnQu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double[] d = JavaTest.getOneComplexAmount(getAmount(), getRate(), getN());
                txwResult.setText("CAP:" + d[1] + "   ALL:" + d[0]);
            }
        });
    }

    public double getRate() {
        String rate = edxRate.getText().toString().trim().replaceAll(" ", "");
        if (!TextUtils.isEmpty(rate)) {
            double d = Double.parseDouble(rate);
            return d / 100;
        }
        return 0;
    }


    public double getAmount() {
        String amount = edxAmount.getText().toString().trim().replaceAll(" ", "");
        if (!TextUtils.isEmpty(amount)) {
            return Double.parseDouble(amount);
        }
        return 0D;
    }

    public int getN() {
        String N = edxN.getText().toString().trim().replaceAll(" ", "");
        if (!TextUtils.isEmpty(N)) {
            return Integer.parseInt(N);
        }
        return 0;
    }
}
