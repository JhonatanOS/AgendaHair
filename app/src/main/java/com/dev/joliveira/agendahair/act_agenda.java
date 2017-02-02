package com.dev.joliveira.agendahair;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.dev.joliveira.agendahair.database.DataBase;
import com.dev.joliveira.agendahair.dominio.RepositorioComercio;
import com.dev.joliveira.agendahair.dominio.entidades.Comercio;
import com.dev.joliveira.agendahair.notifica.MsgBox;

public class act_agenda extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button btn_ir;
    private ListView lst_verComercio;

    private ArrayAdapter<Comercio> adpComercio;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioComercio repositorioComercio;

    public static final String PAR_CONTATO = "COMERCIO";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_agenda);

        btn_ir = (Button) findViewById(R.id.btn_ir);
        btn_ir.setOnClickListener(this);

        lst_verComercio = (ListView)findViewById(R.id.lst_verComercio);

        try { // tenta uma conexão com o banco de dados

            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();

            repositorioComercio = new RepositorioComercio(conn);
            adpComercio = repositorioComercio.buscaComercio(this);

            lst_verComercio.setAdapter(adpComercio);



        }catch (SQLException ex){ //execulta apenas quando der erro ao conectar ao db
            MsgBox.show(this, "Erro", "Erro ao criar o Banco de Dados" + ex.getMessage());
        }
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, act_cad_comercio.class);
        startActivity(it);
    }

    @Override //só e chamada quando recebe algum retorno da actCadContatos.
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        adpComercio = repositorioComercio.buscaComercio(this);
        lst_verComercio.setAdapter(adpComercio);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Comercio comercio = adpComercio.getItem(position);//recuperando o objeto

        Intent it = new Intent(this,act_cad_comercio.class);

        it.putExtra(PAR_CONTATO,comercio);
        startActivityForResult(it, 0);

    }

}
