package com.chkltlabs.primefinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //creates primeSieve, an array this vvvv many integers long, which contains true/false variables for all numbers.
    boolean[] primeSieve = new boolean[100000000];

    public void findThePrime(View view){

        EditText num = (EditText)findViewById(R.id.primeTest);

        int test = Integer.parseInt(num.getText().toString());
        if(test<0) {Toast.makeText(this, "Only positive numbers are prime.", Toast.LENGTH_LONG).show();
        } else if (test>primeSieve.length) {
            Toast.makeText(this, "Number too large... sorry!", Toast.LENGTH_LONG).show();
        } else
            if (primeSieve[test]) {
            Toast.makeText(this, "You found a Prime Number!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Not a Prime Number... Try again!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fills primeSieve with true values.
        Arrays.fill(primeSieve, true);
        //zero and one are not prime numbers as a rule, so they change to false.
        primeSieve[0]=primeSieve[1]=false;
        //loops through *every* value in the primeSieve array.
        for (int i=2; i<primeSieve.length; i++){
            //tests whether the value in question is currently true, and if it is, proceeds.
            if(primeSieve[i]) {
                //loops through all higher multiples of the value in question,
                // which by definition are not prime, and changes their value to false
                for(int j=2;i*j<primeSieve.length;j++){
                    primeSieve[i*j]=false;
                }
            }
        }
    }
}
