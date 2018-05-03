package Controller;

import Model.Comanda;
import Model.Plat;
import NetworkManager.ServerConnect;
import View.PanelEditorComanda;
import View.VistaEditorComanda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerViewComanda implements ActionListener {
    //vista
    private VistaEditorComanda viewComanda;
    //model
    private ServerConnect serverConnect;
    private Comanda comandaActual;
    //variables aux
    private boolean comandaEnviada = false;
    private boolean finestraActiva;

    public ControllerViewComanda(ServerConnect serverConnect, Comanda comandaActual, VistaEditorComanda viewComanda){

        this.serverConnect = serverConnect;
        this.comandaActual = comandaActual;
        this.viewComanda = viewComanda;
        finestraActiva = true;

    }

    public void actionPerformed(ActionEvent event){


        if (event.getActionCommand().equals("ENVIA")){
            //serverConnect.enviaComanda(comandaActual);
            System.out.println("estas");
            JOptionPane.showMessageDialog(viewComanda, "Comanda enviada!");
            comandaEnviada = true;

        }else {
            for (int i = 0; i < viewComanda.getPanels().size(); i++){
                if (event.getActionCommand().equals("ELIMINA-" + viewComanda.getPanels().get(i).getNumPlat())){
                    //.getPlats().remove(i);
                    //viewComanda.setVisible(false);
                    eliminaPlatComanda(viewComanda.getPanels().get(i).getPlat());
                   // viewComanda.registerController(this);
                    //viewComanda.setVisible(true);
                    break;
                }
            }
        }
    }

    private void eliminaPlatComanda(Plat plat){

        this.comandaActual.getPlats().remove(plat);
        //viewComanda.setVisible(false);
        JOptionPane.showMessageDialog(viewComanda, "Plat esborrat");
        viewComanda.actualitzaComanda(comandaActual);
        viewComanda.actualitzaVista(plat);
        viewComanda.registerController(this);
        viewComanda.setVisible(true);

        //viewComanda.actualitzaVista(comandaActual);

    }

    public boolean getIfComandaEnviada(){return comandaEnviada;}

    public boolean getIfFinestraActiva(){return finestraActiva;}




}
