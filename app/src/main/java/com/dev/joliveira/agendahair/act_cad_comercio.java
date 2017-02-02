package com.dev.joliveira.agendahair;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.dev.joliveira.agendahair.database.DataBase;
import com.dev.joliveira.agendahair.dominio.entidades.Comercio;
import com.dev.joliveira.agendahair.dominio.RepositorioComercio;
import com.dev.joliveira.agendahair.notifica.MsgBox;

public class act_cad_comercio extends AppCompatActivity {

    private EditText edt_nomeComercio;
    private EditText edt_nomeProprietario;
    private EditText edt_rua;
    private EditText edt_numero;
    private EditText edt_bairro;
    private EditText edt_cidade;
    private EditText edt_estado;
    private EditText edt_telefone;
    private EditText edt_celular;
    private EditText edt_email;

    private DataBase dataBase;
    private SQLiteDatabase conn;

    private RepositorioComercio repositorioComercio;
    private Comercio comercio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_cad_comercio);

        //recuperando os valores digitados
        edt_nomeComercio = (EditText)findViewById(R.id.edt_nomeComercio);
        edt_nomeProprietario = (EditText)findViewById(R.id.edt_nomeProprietario);
        edt_rua = (EditText)findViewById(R.id.edt_rua);
        edt_numero = (EditText)findViewById(R.id.edt_numero);
        edt_bairro = (EditText)findViewById(R.id.edt_bairro);
        edt_cidade = (EditText)findViewById(R.id.edt_cidade);
        edt_estado = (EditText)findViewById(R.id.edt_estado);
        edt_telefone = (EditText)findViewById(R.id.edt_telefone);
        edt_celular =(EditText)findViewById(R.id.edt_celular);
        edt_email = (EditText)findViewById(R.id.edt_email);

        try { // tenta uma conexão com o banco de dados
            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();
            repositorioComercio = new RepositorioComercio(conn);

        }catch (SQLException ex){ //execulta apenas quando der erro ao conectar ao db
            MsgBox.show(this, "Erro", "Erro ao criar o Banco de Dados" + ex.getMessage());
        }
        comercio = new Comercio();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater(); // associa menu.xml com a classe
        inflater.inflate(R.menu.menu_cad_comercio,menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override //responsavel pela seleçao dos itens
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mni_acao1:
                salvar();
                finish();
                break;
            case R.id.mni_acao2:
                //por açaõ aqui
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvar(){ //recuperação dos itens da interface;

        try {



            comercio.setNomeComercio(edt_nomeComercio.getText().toString());
            comercio.setNomeProprietario(edt_nomeProprietario.getText().toString());
            comercio.setRua(edt_rua.getText().toString());
            comercio.setNumero(edt_numero.getText().toString());
            comercio.setBairro(edt_bairro.getText().toString());
            comercio.setCidade(edt_cidade.getText().toString());
            comercio.setEstado(edt_estado.getText().toString());
            comercio.setTelefone(edt_telefone.getText().toString());
            comercio.setCelular(edt_celular.getText().toString());
            comercio.setEmail(edt_email.getText().toString());

            repositorioComercio.inserir(comercio);

            MsgBox.show(this, "Erro", "Dados salvos" );//apenas de teste pra informar se teve sucesso em gravar os dados

        }catch (Exception ex){ //execulta apenas quando der erro ao inserir os dados
            MsgBox.showAlert(this, "Erro", "Erro ao salvar os dados" + ex.getMessage());
        }
    }

}
