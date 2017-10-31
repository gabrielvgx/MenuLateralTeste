/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listnodes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author GVGX_TECNOLOGIA
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    AnchorPane menu;
    JFXButton[] botaoPrincipal = new JFXButton[9];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
         * listaPrincipal -> items sem subMenu e lista2 lista2 -> items com
         * subMenu e a lista3 lista3 -> items de subMenu
         */
        JFXNodesList lista = new JFXNodesList();
        JFXNodesList lista2 = new JFXNodesList();
        JFXNodesList lista3 = new JFXNodesList();
        JFXNodesList listaSubMenuRep = new JFXNodesList();
        JFXNodesList listaSubMenuRel = new JFXNodesList();

        JFXButton[] botaoSubMenuRep = new JFXButton[3];
        JFXButton[] botaoSubMenuRel = new JFXButton[2];
        incializaBotao(botaoPrincipal);
        incializaBotao(botaoSubMenuRep);
        incializaBotao(botaoSubMenuRel);

        botaoPrincipal[0].setText("HOME");
        botaoPrincipal[1].setText("CADASTRO");
        botaoPrincipal[2].setText("DADOS");
        botaoPrincipal[3].setText("CONTROLE LEITEIRO");
        botaoPrincipal[4].setText("CONTROLE REPRODUTIVO");
        botaoPrincipal[5].setText("DIETA");
        botaoPrincipal[6].setText("MEDICAMENTOS");
        botaoPrincipal[7].setText("RELATORIOS");
        botaoPrincipal[7].setOnMouseClicked(new eventoRelatorio());
        botaoPrincipal[8].setText("SAIR");

        botaoSubMenuRep[0].setText("INSEMINAÇÃO/COBRIÇÃO");
        botaoSubMenuRep[1].setText("OUTRO");
        botaoSubMenuRep[2].setText("PARTO");

        botaoSubMenuRel[0].setText("LEITEIRO");
        botaoSubMenuRel[1].setText("RESUMO ANIMAL");

        botaoPrincipal[0].setPrefHeight(73.0);
        botaoPrincipal[0].setPrefWidth(menu.getPrefWidth());
        double y = botaoPrincipal[0].getPrefHeight();
        for (int i = 1; i < botaoPrincipal.length; i++) {
            botaoPrincipal[i].setPrefHeight(69.0);
            botaoPrincipal[i].setLayoutY(y * i);
            botaoPrincipal[i].setPrefWidth(menu.getPrefWidth());
        }
        for (int i = 0; i < botaoPrincipal.length; i++) {
            if (i == 4) {//controleReprodutivo
                lista2.addAnimatedNode(botaoPrincipal[i]);
                for (int j = 0; j < botaoSubMenuRep.length; j++) {
                    listaSubMenuRep.addAnimatedNode(botaoSubMenuRep[j]);
                    botaoSubMenuRep[j].setPrefHeight(69.0);
                }
               // listaSubMenuRep.setTranslateX(150);
                lista2.addAnimatedNode(listaSubMenuRep);
                listaSubMenuRep.animateList();
            //    lista2.setRotate(-90);
                lista.addAnimatedNode(lista2);
            } else {
                if (i == 7) {//Relatorios
                    lista3.addAnimatedNode(botaoPrincipal[i]);
                    for (int j = 0; j < botaoSubMenuRel.length; j++) {
                        listaSubMenuRel.addAnimatedNode(botaoSubMenuRel[j]);
                        botaoSubMenuRel[j].setPrefHeight(69.0);
                    }
                  //  listaSubMenuRel.setTranslateX(100);
                    listaSubMenuRel.animateList();
                    lista3.addAnimatedNode(listaSubMenuRel);
                    lista.addAnimatedNode(lista3);
              //      lista3.setRotate(-90);
                } else {
                    lista.addAnimatedNode(botaoPrincipal[i]);
                }
            }
        }
        
        botaoSubMenuRep[0].setEventDispatcher(null);
        botaoSubMenuRel[0].setEventDispatcher(null);
        lista.setPrefHeight(625.0);
        menu.setTopAnchor(lista, 0.0);
        menu.setBottomAnchor(lista, 0.0);
        menu.getChildren().add(lista);
        lista.animateList();
        botaoPrincipal[0].setEventDispatcher(null);

    }

    public void incializaBotao(JFXButton[] botao) {
        for (int i = 0; i < botao.length; i++) {
            botao[i] = new JFXButton("");
        }
    }
    private class eventoRelatorio implements EventHandler{

        @Override
        public void handle(Event event) {
            System.out.println("clicou em mim!");
            botaoPrincipal[8].setTranslateY(40);
            menu.setPrefHeight(menu.getPrefHeight()+69.0);
        }
        
    }

}
