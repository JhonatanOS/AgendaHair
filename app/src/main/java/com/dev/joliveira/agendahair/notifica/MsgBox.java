package com.dev.joliveira.agendahair.notifica;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by ADM on 31/01/2017.
 */

public class MsgBox {

    //messagem usando icone
    public static void showInfo(Context ctx, String title, String msg){
        show(ctx, title, msg, android.R.drawable.ic_dialog_info);
    }

    //messagem usando icone
    public static void showAlert(Context ctx, String title, String msg){
        show(ctx, title, msg, android.R.drawable.ic_dialog_alert);
    }

    //mensagem simples
    public static void show(Context ctx, String title, String msg){
        show(ctx, title,msg,0);
    }

    //metodo que recebe os parametros para compor a dialog box
    public static void show(Context ctx, String title, String msg, int iconId){

        AlertDialog.Builder dlg = new AlertDialog.Builder(ctx);
        dlg.setIcon(iconId);
        dlg.setTitle(title);
        dlg.setMessage(msg);
        dlg.setNeutralButton("OK", null);
        dlg.show();
    }
}
