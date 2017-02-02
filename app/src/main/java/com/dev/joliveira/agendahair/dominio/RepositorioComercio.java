package com.dev.joliveira.agendahair.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.dev.joliveira.agendahair.ComercioArrayAdapter;
import com.dev.joliveira.agendahair.R;
import com.dev.joliveira.agendahair.dominio.entidades.Comercio;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ADM on 31/01/2017.
 */

public class RepositorioComercio implements Serializable {

    private SQLiteDatabase conn;
    //criando conexão
    public RepositorioComercio(SQLiteDatabase conn){
        this.conn = conn;
    }

    private ContentValues preencheContentValues(Comercio comercio){
        ContentValues values = new ContentValues();

        values.put(Comercio.NOME_COMERCIO, comercio.getNomeComercio());
        values.put(Comercio.NOME_PROPRIETARIO, comercio.getNomeProprietario());
        values.put(Comercio.RUA, comercio.getRua());
        values.put(Comercio.NUMERO, comercio.getNumero());
        values.put(Comercio.BAIRRO, comercio.getBairro());
        values.put(Comercio.CIDADE, comercio.getCidade());
        values.put(Comercio.ESTADO, comercio.getEstado());
        values.put(Comercio.TELEFONE, comercio.getTelefone());
        values.put(Comercio.CELULAR, comercio.getCelular());
        values.put(Comercio.EMAIL, comercio.getEmail());

        return values;

    }

    public void inserir(Comercio comercio){ //insere valores para tabela do db
        ContentValues values = preencheContentValues(comercio);
        conn.insertOrThrow(Comercio.TABELA, null, values);
    }

    public ArrayAdapter<Comercio> buscaComercio(Context context){

        ArrayAdapter<Comercio> adpComercio = new ArrayAdapter<Comercio>(context, android.R.layout.simple_list_item_1);
        /*ComercioArrayAdapter adpComercio = new ComercioArrayAdapter(context, R.layout.lista_comercio);*/

        Cursor cursor = conn.query(Comercio.TABELA, null, null, null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();//move o cursor para o primeiro item da tabela
            do {

                Comercio comercio = new Comercio(); // cria um objeto para cada contato;

                comercio.setId(cursor.getLong(cursor.getColumnIndex(Comercio.ID)));
                comercio.setNomeComercio(cursor.getString(cursor.getColumnIndex(Comercio.NOME_COMERCIO)));
                comercio.setNomeProprietario(cursor.getString(cursor.getColumnIndex(Comercio.NOME_PROPRIETARIO)));
                comercio.setRua(cursor.getString(cursor.getColumnIndex(Comercio.RUA)));
                comercio.setNumero(cursor.getString(cursor.getColumnIndex(Comercio.NUMERO)));
                comercio.setBairro(cursor.getString(cursor.getColumnIndex(Comercio.BAIRRO)));
                comercio.setCidade(cursor.getString(cursor.getColumnIndex(Comercio.CIDADE)));
                comercio.setEstado(cursor.getString(cursor.getColumnIndex(Comercio.ESTADO)));
                comercio.setTelefone(cursor.getString(cursor.getColumnIndex(Comercio.TELEFONE)));
                comercio.setCelular(cursor.getString(cursor.getColumnIndex(Comercio.CELULAR)));
                comercio.setEmail(cursor.getString(cursor.getColumnIndex(Comercio.EMAIL)));

                adpComercio.add(comercio); //adicionar o valor recebido no adapter

            }while(cursor.moveToNext()); //move o cursor para o proximo item da tab
        }

        return adpComercio;
    }


}
