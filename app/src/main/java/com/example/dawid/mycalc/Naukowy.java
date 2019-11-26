package com.example.dawid.mycalc;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static java.lang.Math.*;


public class Naukowy extends AppCompatActivity {

    private Button zero;    private Button jeden;   private Button dwa;     private Button trzy;    private Button cztery; private Button piec;
    private Button szesc;   private Button siedem;  private Button osiem;   private Button dziewiec;public Button dodaj;   private Button odejmij;
    private Button pomnoz;  private Button podziel; private Button kropka;  private Button plusminus;private Button sqrt;  private Button x_kw;
    private Button x_y;     private Button log;     private Button sin;     private Button cos;      private Button tn;    private Button ln;
    private Button procent; private Button rownasie;private Button clear;   private Button bcsp;     private TextView result;private TextView info;
    private String poczatkowydlainfo="0";
    private final char dodawanie = '+';     private final char odejmowanie = '-';        private final char mnozenie = 'x';
    private final char dzielenie = '/';     private final char pierwiastkowanie ='√';    private CharSequence oper ="";
    private final char potegaxy = '^';      private final char logarytmowanie= 'l';      private final char sinus = 's';
    private final char cosinus = 'c';       private final char tangens = 't';            private final char logarytmowanienaturalne = 'n';
    private final char procentowanie = '%'; private final char wynik ='0';               private final char zmiana=' ';
    private double x1=Double.NaN;           private double ob;  private double x2;       private char dzialanie; int clickcount=0;
    private String text="";                 private String text2="";

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_naukowy);
        setup();
        if(savedInstanceState!=null)
        {
            text = savedInstanceState.getString("text");
            text2 = savedInstanceState.getString("text2");
            dzialanie = savedInstanceState.getChar("Temp");
            x1= savedInstanceState.getDouble("aTemp");
            x2= savedInstanceState.getDouble("bTemp");
        }
        if(text != null)info.setText(text);
        if(text2 != null) result.setText(text2);
        sprawdz();
        info.setText(poczatkowydlainfo);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (info.getText().length() < 8)
                info.setText(info.getText().toString() +"0");
                procent.setClickable(true);
                wlaczznaki();
            }
        });
        jeden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                wlaczznaki();
                procent.setClickable(true);
                if (info.getText().length() < 8) {
                    info.setText(info.getText().toString() + "1");
                }
            }
        });
        dwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                wlaczznaki();
                procent.setClickable(true);
                if (info.getText().length() < 8)
                info.setText(info.getText().toString() +"2");
                wlaczznaki();

            }
        });
        trzy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (info.getText().length() < 8)
                info.setText(info.getText().toString() +"3");
                procent.setClickable(true);
                wlaczznaki();
            }
        });
        cztery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (info.getText().length() < 8)
                info.setText(info.getText().toString() +"4");
                wlaczznaki();
                procent.setClickable(true);
            }
        });
        piec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //wlaczznaki();
                procent.setClickable(true);
                if (info.getText().length() < 8)
                info.setText(info.getText().toString() +"5");
                wlaczznaki();

            }
        });
        szesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                wlaczznaki();
                procent.setClickable(true);
                if (info.getText().length() < 8)
                info.setText(info.getText().toString() +"6");
            }
        });
        siedem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (info.getText().length() < 8)
                info.setText(info.getText().toString() +"7");
                procent.setClickable(true);
                wlaczznaki();
            }
        });
        osiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                wlaczznaki();
                procent.setClickable(true);
                if (info.getText().length() < 8)
                info.setText(info.getText().toString() +"8");
            }
        });
        dziewiec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                wlaczznaki();
                procent.setClickable(true);
                if (info.getText().length() < 8)
                info.setText(info.getText().toString() +"9");
            }
        });

        kropka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (info.getText().length() < 8)
                info.setText(info.getText().toString()+".");
                sprawdz();
                kropka.setClickable(false);
                plusminus.setClickable(false);
                wylaczznaki();
            }
        });
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                obliczaj();
                sprawdz();
               // kropka.setClickable(true);
                dzialanie = dodawanie;
                kropka.setClickable(true);
                wylaczznaki();
                plusminus.setClickable(false);
                if (info.getText().length() < 9)
                result.setText(String.valueOf(fmt(x1)) + "+");
                info.setText(null);
            }
        });
        odejmij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                obliczaj();
                sprawdz();
                plusminus.setClickable(false);
                dzialanie = odejmowanie ;
                //  wylaczznaki();
                if (info.getText().length() < 9)
                result.setText(String.valueOf(fmt(x1)) + "-");
                kropka.setClickable(true);
            }
        });
        pomnoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                obliczaj();
                sprawdz();
                //  wylaczznaki();
                plusminus.setClickable(false);
                dzialanie = mnozenie;
                if (info.getText().length() < 9)
                result.setText(String.valueOf(fmt(x1)) + "*");
                info.setText(null);
                kropka.setClickable(true);
            }
        });
        podziel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                obliczaj();
                sprawdz();
                plusminus.setClickable(false);
                //  wylaczznaki();
                dzialanie = dzielenie;
                kropka.setClickable(true);
                if (info.getText().length() < 9)
                result.setText(String.valueOf(fmt(x1)) + "/");
                info.setText(null);
            }
        });
        plusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //wylaczeniedlaplusaiminusa();
                // sprawdz();
                Double x1 =Double.parseDouble(info.getText().toString())*(-1);
                if (info.getText().length() < 8)
                info.setText(String.valueOf(fmt(x1)));
            }
        });
        rownasie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.getText().length()>1)
                {
                    rownasie.setClickable(true);
                    obliczaj();
                    sprawdz();
                    plusminus.setClickable(false);
                    result.setText(result.getText().toString() + String.valueOf(fmt(x2)) + "=" + String.valueOf(fmt(x1)));

                    dzialanie = wynik;
                    kropka.setClickable(true);
                    if (info.getText().length() < 8) {
/*
                        result.setText(result.getText().toString() + String.valueOf(fmt(x2)) + "=");
*/
                        clear.setClickable(false);
                        info.setText(String.valueOf(resultFormat(ob)));
                    }
                    wylaczliczby();
                    wylaczznaki();
                }
                else sprawdzrownasie();
            }
        });
        bcsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                procent.setClickable(false);
                log.setClickable(false);
                wylaczznaki();
                clear.setClickable(true);
                wlaczliczby();
                procent.setClickable(true);
                kropka.setClickable(true);
                CharSequence name2 = info.getText().toString();
                CharSequence name_b = info.getText().toString();
                if (info.getText().length() > 0) {
                    info.setText(name2.subSequence(0, name2.length() - name2.length()));
                } else {
                    x1 = Double.NaN;
                    x2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
                if (result.getText().length() > 0) {
                    result.setText(name_b.subSequence(0, name_b.length() - name_b.length()));
                } else {
                    x1 = Double.NaN;
                    x2 = Double.NaN;
                    result.setText(null);
                    result.setText(null);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // wlaczznaki();
                wlaczliczby();
                procent.setClickable(true);
                //kropka.setClickable(true);
                clickcount=clickcount+1;
                CharSequence name = info.getText().toString();
                CharSequence name_r = result.getText().toString();
                if(clickcount==1) {
                    if (info.getText().length() > 0) {

                        info.setText(name.subSequence(0, name.length() - 1));
                     }
                        else if (result.getText().length() > 0 && info.getText().length()==0) {
                            result.setText(name_r.subSequence(0, name_r.length() - 1));
                        }
                        else {
                            x1 = Double.NaN;
                            x2 = Double.NaN;
                            info.setText(null);
                            result.setText(null);
                        }
                    }
                else{
                    x1 = Double.NaN;
                    x2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                    kropka.setClickable(true);
                    clickcount=0;
                }
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sprawdz();
                kropka.setClickable(true);
                procent.setClickable(true);
                Double x1 =Double.parseDouble((info.getText().toString()));
                if (info.getText().length() <= 8)
                result.setText("√"+ String.valueOf(fmt((x1))) + "=" + String.valueOf(fmt(pierw(x1))));
                if(x1<0)
                {
                    Toast.makeText(Naukowy.this,
                            "Nie mozna obliczyc sqrt dla liczby mniejszej od 0", Toast.LENGTH_LONG).show();
                }
                else {
                    info.setText(String.valueOf(fmt(pierw(x1))));
                }
                result.setText(null);
            }
        });
        x_kw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sprawdz();
                kropka.setClickable(true);
                procent.setClickable(true);
                Double x1 =Double.parseDouble((info.getText().toString()));
                if (info.getText().length() <= 8)
                result.setText(String.valueOf(fmt((x1)))+" ^ "+ String.valueOf(fmt((x1)))+ "= " +String.valueOf(fmt(potega(x1))));
                info.setText(String.valueOf(fmt(potega(x1))));
                result.setText(null);
            }
        });
        x_y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                obliczaj();
                sprawdz();
                procent.setClickable(true);
                kropka.setClickable(true);
                dzialanie = potegaxy;
                if (info.getText().length() <= 8)
                result.setText(String.valueOf(fmt(x1)) + "^");
                info.setText(null);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sprawdz();
                kropka.setClickable(true);
                procent.setClickable(true);
                Double x1 =Double.parseDouble((info.getText().toString()));
                if (info.getText().length() <= 8)
                result.setText("log" + String.valueOf(fmt((x1)))+"= " +String.valueOf(fmt(logarytm(x1))));
                if(x1<=0)
                {
                    Toast.makeText(Naukowy.this,
                            "Logarytm obliczamy dla liczby >0", Toast.LENGTH_LONG).show();
                }
                else {
                    info.setText(String.valueOf(fmt(logarytm(x1))));
                }
                result.setText(null);
            }
        });
        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sprawdz();
                procent.setClickable(true);
                kropka.setClickable(true);
                Double x1 =Double.parseDouble((info.getText().toString()));
                if (info.getText().length() <= 8)
                    result.setText("ln" + String.valueOf(fmt((x1)))+"= " +String.valueOf(fmt(logarytmnaturalny(x1))));
                    if(x1<0)
                    {
                        Toast.makeText(Naukowy.this,
                                "Nie mozna obliczyc ln dla liczby mniejszej od 0", Toast.LENGTH_LONG).show();
                    }
                    else {
                        info.setText(String.valueOf(fmt(logarytmnaturalny(x1))));
                    }
                result.setText(null);
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sprawdz();
                kropka.setClickable(true);
                procent.setClickable(true);
                wylaczznaki();
                Double x1 =Double.parseDouble((info.getText().toString()));
                if (info.getText().length() <= 8)
                result.setText("sin" + String.valueOf(fmt((x1)))+"= " +String.valueOf(fmt(sinus(x1))));
                info.setText(String.valueOf(fmt(sinus(x1))));
                result.setText(null);
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sprawdz();
                kropka.setClickable(true);
                procent.setClickable(true);
                wylaczznaki();
                Double x1 =Double.parseDouble((info.getText().toString()));
                if (info.getText().length() <= 8)
                result.setText("cos " + String.valueOf(fmt((x1)))+"= " +String.valueOf(fmt(cosinus(x1))));
                info.setText(String.valueOf(fmt(cosinus(x1))));
                result.setText(null);
            }
        });
        tn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sprawdz();
                kropka.setClickable(true);
                procent.setClickable(true);
                Double x1 =Double.parseDouble((info.getText().toString()));
                if (info.getText().length() <= 8)
                result.setText("tan " + String.valueOf(fmt((x1)))+"= " +String.valueOf(fmt(tangens(x1))));
                info.setText(String.valueOf(fmt(tangens(x1))));
                result.setText(null);
            }
        });
        procent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sprawdz();
                kropka.setClickable(true);
                procent.setClickable(false);
                Double x1 =Double.parseDouble(info.getText().toString())*(0.01);
                if (info.getText().length() <= 8)
                info.setText(String.valueOf(fmt(x1)));
                result.setText(null);
            }
        });
    }
    @Override
    protected void onSaveInstanceState (Bundle outState) {

        text = info.getText().toString();
        text2 = result.getText().toString();
        outState.putString("text", text);
        outState.putString("text2", text2);
        outState.putChar("Temp",dzialanie);
        outState.putDouble("aTemp",x1);
        outState.putDouble("bTemp",x2);
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState (Bundle outState)
    {
        super.onRestoreInstanceState(outState);
        text = outState.getString("text");
        text2 = outState.getString("text2");
        info.setText(text);
        result.setText(text2);
    }
    private void setup()
    {
        zero = findViewById(R.id.zero);
        jeden =findViewById(R.id.jeden);
        dwa =findViewById(R.id.dwa);
        trzy =findViewById(R.id.trzy);
        cztery =findViewById(R.id.cztery);
        piec =findViewById(R.id.piec);
        szesc =findViewById(R.id.szesc);
        siedem =findViewById(R.id.siedem);
        osiem =findViewById(R.id.osiem);
        dziewiec =findViewById(R.id.dziewiec);
        kropka =findViewById(R.id.kropka);
        rownasie =findViewById(R.id.rownasie);
        dodaj =findViewById(R.id.dodac);
        odejmij =findViewById(R.id.odjac);
        podziel =findViewById(R.id.podziel);
        pomnoz =findViewById(R.id.pomnoz);
        clear =findViewById(R.id.clear);
        result =findViewById(R.id.result);
        info = findViewById(R.id.info);
        clear = findViewById(R.id.clear);
        plusminus = findViewById(R.id.plusminus);
        sqrt =findViewById(R.id.sqrt);
        log =findViewById(R.id.log);
        ln = findViewById(R.id.ln);
        x_kw = findViewById(R.id.x_kw);
        x_y = findViewById(R.id.x_y);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tn = findViewById(R.id.tn);
        ln = findViewById(R.id.ln);
        procent=findViewById(R.id.procent);
        bcsp=findViewById(R.id.bcsp);
    }
    public static String resultFormat(Double number) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat();
        if(number<99999999.0) {
            df.setDecimalFormatSymbols(symbols);
            df.setGroupingSize(3);
            df.setMaximumFractionDigits(15);
        }else{
            df = new DecimalFormat("0.##########E0");
        }
        return df.format(number);
    }
    private void obliczaj()
    {
        if(!Double.isNaN(x1))
        {
            x2= Double.parseDouble(info.getText().toString());
            switch (dzialanie) {
                case dodawanie:
                    x1 = x1 + x2;
                    break;
                case odejmowanie:
                    x1 = x1 - x2;
                    break;
                case dzielenie:
                    x1 = x1 / x2;
                    break;
                case mnozenie:
                    x1 = x1 * x2;
                    break;
                /*case rownasiedzialanie:
                    x1=x1;
                    break;*/
                case zmiana:
                    x1 = x1 * (-1);
                    break;
                case procentowanie:  ob=x1*0.01; break;
                case potegaxy: ob = pow(x1,x2); break;
                case wynik:  break;
            }
        }
        else {
            try {
                x1 = Double.parseDouble(info.getText().toString());
            }
            catch (Exception e){}
        }
    }
    public static String fmt(double d)
    {
        if (d % 1.0 != 0)
            return String.format("%s", d);
        else
            return String.format("%.0f",d);
    }
    private void wylaczznaki()
    {
        dodaj.setClickable(false);
        odejmij.setClickable(false);
        podziel.setClickable(false);
        pomnoz.setClickable(false);
        rownasie.setClickable(false);
        kropka.setClickable(false);
        procent.setClickable(false);
        sin.setClickable(false);
        procent.setClickable(false);
        sqrt.setClickable(false);
        cos.setClickable(false);
        tn.setClickable(false);
        x_y.setClickable(false);
        x_kw.setClickable(false);
        log.setClickable(false);

    }
    private void wlaczznaki()
    {
        dodaj.setClickable(true);
        plusminus.setClickable(true);
        odejmij.setClickable(true);
        podziel.setClickable(true);
        pomnoz.setClickable(true);
        rownasie.setClickable(true);
        procent.setClickable(true);
        log.setClickable(true);
        sin.setClickable(true);
        sqrt.setClickable(true);
        cos.setClickable(true);
        tn.setClickable(true);
        x_y.setClickable(true);
        x_kw.setClickable(true);
    }
    private void wylaczeniedlaplusaiminusa()
    {
        dodaj.setClickable(true);
        odejmij.setClickable(true);
        podziel.setClickable(true);
        pomnoz.setClickable(true);
    }
    private void wylaczliczby()
    {
        jeden.setClickable(false);
        dwa.setClickable(false);
        trzy.setClickable(false);
        cztery.setClickable(false);
        piec.setClickable(false);
        szesc.setClickable(false);
        siedem.setClickable(false);
        osiem.setClickable(false);
        dziewiec.setClickable(false);
    }
    private void wlaczliczby()
    {
        jeden.setClickable(true);
        dwa.setClickable(true);
        trzy.setClickable(true);
        cztery.setClickable(true);
        piec.setClickable(true);
        szesc.setClickable(true);
        siedem.setClickable(true);
        osiem.setClickable(true);
        dziewiec.setClickable(true);
    }
    public void sprawdz() {
        CharSequence a = info.getText().toString();
        CharSequence b = result.getText().toString();
        if (!Double.isNaN(a.length() -1)) {
            wylaczznaki();
        }
        else if (!Double.isNaN(b.length() -1)) {
            wylaczznaki();
        }
    }
    public void sprawdzrownasie()
    {
            Toast.makeText(Naukowy.this,
                    "Wykonaj dzialanie", Toast.LENGTH_LONG).show();
                    rownasie.setClickable(false);
                    info.setText(info.getText().toString());
                    result.setText(null);

    }

    public double potega(double x)
    {
        return x*x;
    }
    public double pierw(double x)
    {
        return Math.sqrt(x);
    }
    public double sinus(double x)
    {
        return Math.sin(Math.toRadians(x));
    }
    public double cosinus(double x)
    {
        return Math.cos(Math.toRadians(x));
    }
    public double tangens(double x)
    {
        return Math.tan(Math.toRadians(x));
    }
    public double logarytm(double x)
    {
        return log10(x);
    }
    public double logarytmnaturalny(double x)
    {
        return log(x);
    }
}
