package com.dev.joliveira.agendahair.database;

/**
 * Created by ADM on 31/01/2017.
 */

public class ScriptSql{

    //Script pra criar Tabela

    public static String getCreateDadosComercio() {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS COMERCIO( ");
        sqlBuilder.append("_id                          INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("NOME_COMERCIO                VARCHAR(200), ");
        sqlBuilder.append("NOME_PROPRIETARIO            VARCHAR(200), ");
        sqlBuilder.append("RUA                          VARCHAR(200), ");
        sqlBuilder.append("NUMERO                       VARCHAR(7), ");
        sqlBuilder.append("BAIRRO                       VARCHAR(100), ");
        sqlBuilder.append("CIDADE                       VARCHAR(50), ");
        sqlBuilder.append("ESTADO                       VARCHAR(20), ");
        sqlBuilder.append("TELEFONE                     VARCHAR(20), ");
        sqlBuilder.append("CELULAR                      VARCHAR(20), ");
        sqlBuilder.append("EMAIL                        VARCHAR(50) ");
        sqlBuilder.append(");");
        return sqlBuilder.toString();
    }
}

