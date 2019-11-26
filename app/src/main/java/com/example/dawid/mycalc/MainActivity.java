package com.example.dawid.mycalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button zero;
    private Button jeden;
    private Button dwa;
    private Button trzy;
    private Button cztery;
    private Button piec;
    private Button szesc;
    private Button siedem;
    private Button osiem;
    private Button dziewiec;
    public Button dodaj;
    private Button odejmij;
    private Button pomnoz;
    private Button podziel;
    private Button kropka;
    private Button plusminus;
    private Button rownasie;
    private Button clear;
    private Button bcsp;
    private TextView result;
    private TextView info;
    private String poczatkowydlainfo = "0";
    private final char dodawanie = '+';
    private final char odejmowanie = '-';
    private final char mnozenie = 'x';
    private final char dzielenie = '/';
    private final char rownasiedzialanie = '=';
    private CharSequence oper = "";
    private final char wynik = '0';
    private final char zmiana = ' ';
    private double x1 = Double.NaN;
    private double ob;
    private double x2;
    private char dzialanie;
    int clickcount = 0;
    private String text = "";
    private String text2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        setup();

        if (savedInstanceState != null) {
            text = savedInstanceState.getString("text");
            text2 = savedInstanceState.getString("text2");
            dzialanie = savedInstanceState.getChar("Temp");
            x1 = savedInstanceState.getDouble("aTemp");
            x2 = savedInstanceState.getDouble("bTemp");
        }
        if (text != null) info.setText(text);
        if (text2 != null) result.setText(text2);
        sprawdz();
        info.setText(poczatkowydlainfo);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "0");
                wlaczznaki();

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "0");
                wlaczznaki();

            }
        });
        jeden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wlaczznaki();
                if (info.getText().length() < 8) {
                    info.setText(info.getText().toString() + "1");
                }
            }
        });

        dwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wlaczznaki();
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "2");
            }
        });
        trzy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "3");
                wlaczznaki();
            }
        });
        cztery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "4");
                wlaczznaki();
            }
        });
        piec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //wlaczznaki();
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "5");
                wlaczznaki();
            }
        });
        szesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wlaczznaki();
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "6");
                wlaczznaki();
            }
        });
        siedem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "7");
                wlaczznaki();
            }
        });
        osiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wlaczznaki();
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "8");
            }
        });
        dziewiec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wlaczznaki();
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + "9");
            }
        });

        kropka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (info.getText().length() < 8)
                    info.setText(info.getText().toString() + ".");
                sprawdz();
                kropka.setClickable(false);
                plusminus.setClickable(false);
                wylaczznaki();
            }
        });
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obliczaj();
                sprawdz();
                // kropka.setClickable(true);
                dzialanie = dodawanie;
                kropka.setClickable(true);
                // wylaczznaki();
                plusminus.setClickable(false);
                if (info.getText().length() < 9)
                    result.setText(String.valueOf(fmt(x1)) + "+");
                info.setText(null);
            }
        });
        odejmij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obliczaj();
                sprawdz();
                dzialanie = odejmowanie;
                plusminus.setClickable(false);
                //  wylaczznaki();
                if (info.getText().length() < 9)
                    result.setText(String.valueOf(fmt(x1)) + "-");
                kropka.setClickable(true);
                info.setText(null);

            }
        });
        pomnoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            public void onClick(View v) {
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
                //
                // sprawdz();
                Double x1 = Double.parseDouble(info.getText().toString()) * (-1);
                if (info.getText().length() < 8)
                    info.setText(String.valueOf(fmt(x1)));
            }
        });
        rownasie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result.getText().length() > 1) {
                    rownasie.setClickable(true);
                    // wylaczznaki();
                    obliczaj();
                    sprawdz();
                    result.setText(result.getText().toString() + String.valueOf(fmt(x2)) + "=" + String.valueOf(fmt(x1)));

                    plusminus.setClickable(false);
                    //kropka.setClickable(true);
                    // kropka.setClickable(true);
                    wylaczliczby();
                    dzialanie = wynik;
                    kropka.setClickable(true);
                    if (info.getText().length() < 8) {
/*
                        result.setText(result.getText().toString() + String.valueOf(fmt(x2)) + "=" + String.valueOf(fmt(ob)));
*/
                        info.setText(null);
                    }
                } else sprawdzrownasie();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // wlaczznaki();
                wlaczliczby();

                //kropka.setClickable(true);
                clickcount = clickcount + 1;
                CharSequence name = info.getText().toString();
                CharSequence name_r = result.getText().toString();
                if (clickcount == 1) {
                    if (info.getText().length() > 0) {

                        info.setText(name.subSequence(0, name.length() - 1));
                    } else if (result.getText().length() > 0 && info.getText().length() == 0) {
                        result.setText(name_r.subSequence(0, name_r.length() - 1));
                    } else {
                        x1 = Double.NaN;
                        x2 = Double.NaN;
                        info.setText(null);
                        result.setText(null);
                    }
                } else {
                    x1 = Double.NaN;
                    x2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                    kropka.setClickable(true);
                    clickcount = 0;
                }
            }
        });

        bcsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wlaczliczby();
                kropka.setClickable(true);
                CharSequence name2 = info.getText().toString();
                if (info.getText().length() > 0) {
                    info.setText(name2.subSequence(0, name2.length() - name2.length()));
                } else {
                    x1 = Double.NaN;
                    x2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        text = info.getText().toString();
        text2 = result.getText().toString();
        outState.putString("text", text);
        outState.putString("text2", text2);
        outState.putChar("Temp", dzialanie);
        outState.putDouble("aTemp", x1);
        outState.putDouble("bTemp", x2);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        text = outState.getString("text");
        text2 = outState.getString("text2");
        info.setText(text);
        result.setText(text2);
    }

    private void setup() {
        zero = findViewById(R.id.zero);
        jeden = findViewById(R.id.jeden);
        dwa = findViewById(R.id.dwa);
        trzy = findViewById(R.id.trzy);
        cztery = findViewById(R.id.cztery);
        piec = findViewById(R.id.piec);
        szesc = findViewById(R.id.szesc);
        siedem = findViewById(R.id.siedem);
        osiem = findViewById(R.id.osiem);
        dziewiec = findViewById(R.id.dziewiec);
        kropka = findViewById(R.id.kropka);
        rownasie = findViewById(R.id.rownasie);
        dodaj = findViewById(R.id.dodac);
        odejmij = findViewById(R.id.odjac);
        podziel = findViewById(R.id.podziel);
        pomnoz = findViewById(R.id.pomnoz);
        clear = findViewById(R.id.clear);
        result = findViewById(R.id.result);
        info = findViewById(R.id.info);
        clear = findViewById(R.id.clear);
        plusminus = findViewById(R.id.plusminus);
        bcsp = findViewById(R.id.bcsp);
    }

    private void obliczaj() {
        if (!Double.isNaN(x1)) {
            x2 = Double.parseDouble(info.getText().toString());
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
                case wynik:
                    break;
            }
        } else {
            try {
                x1 = Double.parseDouble(info.getText().toString());
            } catch (Exception e) {
            }
        }
    }

    public static String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }


    private void wylaczznaki() {
        dodaj.setClickable(false);
        plusminus.setClickable(false);
        odejmij.setClickable(false);
        podziel.setClickable(false);
        pomnoz.setClickable(false);
        rownasie.setClickable(false);
        kropka.setClickable(false);
    }

    private void wlaczznaki() {
        dodaj.setClickable(true);
        plusminus.setClickable(true);
        odejmij.setClickable(true);
        podziel.setClickable(true);
        pomnoz.setClickable(true);
        rownasie.setClickable(true);
    }

    private void wylaczeniedlaplusaiminusa() {
        dodaj.setClickable(true);
        plusminus.setClickable(true);
        odejmij.setClickable(true);
        podziel.setClickable(true);
        pomnoz.setClickable(true);
    }

    private void wylaczliczby() {
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

    private void wlaczliczby() {
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
        if (!Double.isNaN(a.length() - 1)) {
            wylaczznaki();
        } else if (!Double.isNaN(b.length() - 1)) {
            wylaczznaki();
        }
    }

    public void sprawdzrownasie() {
        Toast.makeText(MainActivity.this,
                "Wykonaj dzialanie", Toast.LENGTH_LONG).show();
        rownasie.setClickable(false);
        info.setText(info.getText().toString());
        result.setText(null);
    }
}
