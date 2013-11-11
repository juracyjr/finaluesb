package br.uesb.finaluesb;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	EditText txtNota1, txtNota2, txtNota3, txtMedia;
	
	double nota1, nota2, nota3, impd, impd2, verif;
	int imp, imp2;
	String media, pf;
	Button btnOk, btnZeroUm;
	final String appName = "br.uesb.finaluesb";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtNota1 = (EditText)findViewById(R.id.txtNota1);
		txtNota2 = (EditText)findViewById(R.id.txtNota2);
		txtNota3 = (EditText)findViewById(R.id.txtNota3);
		txtMedia = (EditText)findViewById(R.id.txtMedia);
		btnOk = (Button)findViewById(R.id.btnCal);
		btnZeroUm = (Button)findViewById(R.id.btnZeroUm);	
		
		
		btnOk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				
				if(txtNota1.getText().toString().length() <= 0){
					txtNota1.setError("");	
					txtNota1.requestFocus();
				}
				else if(txtNota2.getText().toString().length() <= 0){
					txtNota2.setError("");	
					txtNota2.requestFocus();
					
				}
				else if(txtNota3.getText().toString().length() <= 0){
					txtNota3.setError("");	
					txtNota3.requestFocus();
					
				}
				else{							
					nota1 = Double.parseDouble(txtNota1.getText().toString());
					nota2 = Double.parseDouble(txtNota2.getText().toString());
					nota3 = Double.parseDouble(txtNota3.getText().toString());
					if(nota1 > 10){
						txtNota1.setError("");	
						txtNota1.requestFocus();						
					}
					else if(nota2 > 10){
						txtNota2.setError("");	
						txtNota2.requestFocus();						
					}
					else if(nota3 > 10){
						txtNota3.setError("");	
						txtNota3.requestFocus();							
					}
					else{
						imp = (int) (((nota1+nota2+nota3)/3) * 100);
						int x1,x2,x3;
						x1 = imp/100;
						x2 = imp%100;
						x2 = x2/10;
						x3 = imp%10;
						if(x3 > 5){
							x2++;
							x3 = 0;
						}
						imp = (x1*100) + (x2*10) + x3;
						impd = imp;		
						imp = (int)impd/10;
						impd2 = (500 -(imp * 7))/3;
						imp2 = (int) impd2*10;
						impd =imp;
						impd = (impd/10);					
						impd2 = imp2;
						imp2 = (int) impd2/10;
						impd2 = imp2 - 1;
						impd2 = impd2/10;
						if(impd <= 2.7)
							txtMedia.setText("\n" + "MÉDIA: "+ String.valueOf(impd) + "\n\n" + "REPROVADO" + "\n");
						else if(impd > 2.7 && impd < 7){
							txtMedia.setText("\n" + "MÉDIA: "+ String.valueOf(impd) + "\n\n" + "NOTA NECESSÁRIA: " + String.valueOf(impd2) + "\n");
						}
						else{
							txtMedia.setText("\n" + "MÉDIA: "+ String.valueOf(impd) + "\n\n" + "APROVADO" + "\n");
						}
					}
				}
				
				
				
			}
		});		
				
		
		btnZeroUm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {				    
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+appName)));
				
				} 				
				catch (android.content.ActivityNotFoundException anfe) {				    
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id="+appName)));
				}		
				
			}
		});
		btnZeroUm.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				String nome_Pagina = "ZeroUm-Hackspace/408652369264123";
				try {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/" + nome_Pagina)));
					//startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://pages/" + nome_Pagina)));
												
				} catch (Exception e) {
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/" + nome_Pagina)));
				}		
				return false;
			}
		});
	
	}
	
}
