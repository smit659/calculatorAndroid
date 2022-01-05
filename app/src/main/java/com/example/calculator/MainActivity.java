package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MainActivity extends Activity {
Button btclear,btmodulo,btm,bt7,bt6,bt8,bt9,bt1,bt2,bt3,bt4,bt5,btdot,bt0,bt00,btp,btdel,btd,bte,btminus;
EditText et;
int i;

   //Used for holding more than one digit number
    LinkedList <String> l=new LinkedList<String>();
    Stack <String> st=new Stack<>();
    Stack <String> ev=new Stack<>();
    String s="";
    String t="";
//    String u="";
    LinkedList<String>list =new LinkedList<>();
    LinkedList<String> posfixExp =new LinkedList<>();
    String o="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btclear=findViewById(R.id.btclear);
        btmodulo=findViewById(R.id.btmodulo);
        btm=findViewById(R.id.btm);
        bt7=findViewById(R.id.bt7);
        bt8=findViewById(R.id.bt8);
        bt9=findViewById(R.id.bt9);
        bt0=findViewById(R.id.bt0);
        bt00=findViewById(R.id.bt00);
        btdot=findViewById(R.id.btdot);
        btp=findViewById(R.id.btp);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        btminus=findViewById(R.id.btminus);

        bt3=findViewById(R.id.bt3);
        bt4=findViewById(R.id.bt4);
        bt5=findViewById(R.id.bt5);
        bt6=findViewById(R.id.bt6);
        btd=findViewById(R.id.btd);
        btdel=findViewById(R.id.btdel);
        bte=findViewById(R.id.bte);
        et=findViewById(R.id.et);


        btclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
                s="";
                t="";
                l.clear();
                st.clear();
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"1";
                t=t+"1";
                et.setText(s);

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"2";
                t=t+"2";
                et.setText(s);

            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"3";
                t=t+"3";
                et.setText(s);

            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"4";
                t=t+"4";
                et.setText(s);

            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"5";
                t=t+"5";
                et.setText(s);

            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"6";
                t=t+"6";
                et.setText(s);

            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"7";
                t=t+"7";
                et.setText(s);

            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"8";
                t=t+"8";
                et.setText(s);

            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"9";
                t=t+"9";
                et.setText(s);

            }
        });
        bt00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"00";
                t=t+"00";
                et.setText(s);

            }
        });
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"0";
                t=t+"0";
                et.setText(s);

            }
        });
        btp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               s=s+"+";
                l.add(t);
                t="";
                l.add("+");
                et.setText(s);

            }
        });
        btmodulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                         s=s+"%";
                l.add(t);
                  t=""; 
                l.add("%");


                et.setText(s);

            }
        });
        btd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"/";
                l.add(t);
                t="";
                l.add("/");
                et.setText(s);

            }
        });
        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"*";
                l.add(t);
                t="";
                l.add("*");
                et.setText(s);

            }
        });
        btminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+"-";
                l.add(t);
                t="";
                l.add("-");
                et.setText(s);

            }
        });
        btdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s=s+".";
                t=t+".";
                et.setText(s);

            }
        });

        btdel.setOnClickListener(new View.OnClickListener() {
            @Override


                public void onClick (View v){

                try {
                    s = s.substring(0, s.length() - 1);
                         t=t.substring(0,t.length()-1);
                    et.setText(s);


                }
                catch (Exception e){
                    
                }

            }





        });
        bte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    l.add(t);
                    t = "";
                    l.add(")");
                    s = "";
                    list = postfix(l);
                    String o = evaluation(list);


                    if (o == "error") {
                        return;
                    }


                    et.setText(o);
                    l.clear();
                    t = t + o;

                    s = s + o;
                }
                catch (Exception e) {

                    s = "";
                    t = "";
                    l.clear();
                    st.clear();
                }
            }
        });


    }
    LinkedList<String> postfix(LinkedList <String>l)
    {
        posfixExp.clear();
        //Used for Solving those problems which includes parenthesis
        st.push("(");
for(i=0;i<l.size();i++)
{


// f method checks for priority value of infix expression , present in l linked list
// g method checks for priority value of top element present in stack
    while(f(l.get(i))<g(st.peek()))
    {

posfixExp.add(st.peek());
        st.pop();
    }
    if(f(l.get(i))>g(st.peek()))
    {
        st.push(l.get(i));

    }
    if(f(l.get(i))==g(st.peek())) {
        st.pop();
    }

}

        return posfixExp;

    }
    int f(String k)
    {
        switch (k)
        {
            case "+":
            case "-":return 3;
            case "*":
            case "%":
            case "/":return 5;
            case ")":return 0;
            case "(":return 10;
            default:return 9;
        }
    }
    int g(String k)
    {
        switch (k)
        {
            case "+":
            case "-":return 4;
            case "*":
            case "%":
            case "/":return 6;
            case "(":return 0;
            default:return 8;

        }

    }
    String evaluation(LinkedList <String> posfixExp)
    {
String s1,s2,z;
double r=0;
try {
    for (i = 0; i < posfixExp.size(); i++) {
        if (posfixExp.get(i) == "+" || posfixExp.get(i) == "-" || posfixExp.get(i) == "*" || posfixExp.get(i) == "/" || posfixExp.get(i) == "%") {
            s1 = ev.pop();
            s2 = ev.pop();
            double b = Double.parseDouble(s2);
            double a = Double.parseDouble(s1);

            if (posfixExp.get(i) == "+") {
                r = a + b;
            }
            if (posfixExp.get(i) == "*") {
                r = a * b;
            }
            if (posfixExp.get(i) == "-") {
                r = b - a;
            }
            if (posfixExp.get(i) == "/") {
                r = b / a;

            }


              if (posfixExp.get(i) == "%") {
                  r = b%a;

              }                                

            z = Double.toString(r);
            ev.push(z);

        } else {
            ev.push(posfixExp.get(i));
        }

    }
    return ev.pop();


}
catch (Exception e)
{
    et.setText("Syntax Error");
      s="";        
      t="";        
      l.clear();   
      st.clear();  

     return "error";
}

    }




}