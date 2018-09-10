package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class TelaHistorico extends AppCompatActivity {
    Button btnAtualizar, btnCancelar, btnLancamento, btnHistorico, btnRelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_historico);

        btnLancamento = (Button)findViewById(R.id.btnHistoricoLancamento);
        btnHistorico = (Button)findViewById(R.id.btnHistoricoHistorico);
        btnRelatorio = (Button)findViewById(R.id.btnHistoricoRelatorio);


        btnLancamento.setOnClickListener(lancamento);
        btnHistorico.setOnClickListener(historico);
        //btnRelatorio.setOnClickListener(relatorio);
        // GRAFICO
        GraphView graph = (GraphView) findViewById(R.id.ReceitaGraph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);

        // styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(50);

        // draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);

        //Segundo
        GraphView graphSegundo = (GraphView) findViewById(R.id.DespesaGraph);
        BarGraphSeries<DataPoint> seriesSegundo = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graphSegundo.addSeries(series);

        // styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        seriesSegundo.setSpacing(50);

        // draw values on top
        seriesSegundo.setDrawValuesOnTop(true);
        seriesSegundo.setValuesOnTopColor(Color.RED);

    }
    View.OnClickListener lancamento = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(TelaHistorico.this, Lancamentos.class));
        }
    };
    View.OnClickListener historico = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(TelaHistorico.this, Relatorio.class));
        }
    };
    /*
    View.OnClickListener relatorio = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(TelaHistorico.this, TelaHistorico.class));
        }
    };
    */
}
