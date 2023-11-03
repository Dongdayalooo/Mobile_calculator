package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private String input, answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
    }

    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();

        switch (data){
            // "AC", chuỗi nhập sẽ được thiết lập lại thành chuỗi rỗng.
            case "AC":
                input = "";
                break;
            //nút "C" (xóa), một ký tự cuối cùng của chuỗi nhập sẽ bị xóa.
            case "C":
                if (input.length() > 0){
                    String newText = input.substring(0,input.length()-1);
                    input = newText;
                }
                break;
            case "=":
                Solve();
                answer = input;
                break;
            case "x":
                Solve();
                input+="*";
                break;
            default:
                if(input == null){
                    input="";
                }
                if (data.equals("+") || data.equals("-")||data.equals("/")){
                    Solve();
                    //in ket qua
                }
                input+=data;
        }
        tv.setText(input);
    }

    private void Solve() {
        if(input.split("\\*").length==2){
            String number[] = input.split("\\*");
            try{
                double mul = Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input = mul+""; // Kết quả của phép nhân được chuyển sang chuỗi và lưu lại trong biến input.
            }catch (Exception e){

            }
        }
        if(input.split("\\/").length==2){
            String number[] = input.split("\\/");
            try{
                double div = Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input = div+"";
            }catch (Exception e){

            }
        }
        if(input.split("\\+").length==2){
            String number[] = input.split("\\+");
            try{
                double sum = Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input = sum+"";
            }catch (Exception e){

            }
        }
        if(input.split("\\-").length==2){
            String number[] = input.split("\\-");
            try{
                double sub = Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input = sub+"";
            }catch (Exception e){

            }
        }

        String n[] = input.split("\\.");
        if (n.length > 1){
            if (n[1].equals("0")){
                input = n[0];
            }
        }
    }


}