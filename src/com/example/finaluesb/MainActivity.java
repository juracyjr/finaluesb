package com.example.finaluesb;

import java.math.BigDecimal;
import java.math.RoundingMode;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	private EditText n1text,n2text,n3text,result;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
	
	public void Calcular1(View v){
		Calc();
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
	
	
	
	
	
	public void Calc(){
		
		float nf,n1,n2,n3;
		n1text =(EditText) findViewById(R.id.editTextn1);
		n2text =(EditText) findViewById(R.id.EditTextn2);
		n3text =(EditText) findViewById(R.id.editTextn3);
		n1 = Float.valueOf(n1text.getText().toString());
		n2 = Float.valueOf(n2text.getText().toString());
		n3 = Float.valueOf(n3text.getText().toString());
		
		nf = (float) ((float) (50-(((n1+n2+n3)/3)*7))/3-0.1);
		BigDecimal valorExato = new BigDecimal(nf).setScale(1, RoundingMode.FLOOR);
		//BigDecimal valorExato = new BigDecimal(txtValorPHDouble).setScale(2, RoundingMode.FLOOR);
	//	ef = (50  - (mg *7))/3;
		result = (EditText) findViewById(R.id.editTextresultado);
		result.setText(String.valueOf(valorExato));
		
			
	}
	
	
	



    
}
