package hnu.example.rest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Test for Java-Doc
 */
public class MainActivity extends AppCompatActivity {

    private Button mButton_Send;
    private TextView mTextView1;
    private TextView mTextView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton_Send = (Button) findViewById(R.id.button);
        mButton_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processREST_GET(); //do REST-call
            }
        });

        mTextView1 = (TextView) findViewById(R.id.editText1);
        mTextView2 = (TextView) findViewById(R.id.editText2);

    }



    //Get Request using Volley
    private void processREST_GET() {

        String zahl1Txt = mTextView1.getText().toString();
        String zahl2Txt = mTextView2.getText().toString();

        String api_key = "UNHARYHVKPC9FYDQ";
        String url = "https://api.thingspeak.com/update.json?api_key=" + api_key +
                "&field1=" + zahl1Txt + "&field2=" + zahl2Txt;

        System.out.println(url);

        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Result handling
                        System.out.println("fertig geschrieben: " + response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Error handling
                        error.printStackTrace();
                    }
        });

        // Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);

    }
}
