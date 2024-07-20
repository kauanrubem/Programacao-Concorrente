/* ***************************************************************
* Autor............: Kauan Rubem Fausto Matos
* Matricula........: 202310587
* Inicio...........: 23/05/2024
* Ultima alteracao.: 26/05/2024
* Nome.............: Controle.java
* Funcao...........: Implementa uma aplicacao em JavaFX que controla o movimento de dois trens
*************************************************************** */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Train;

public class Controle implements Initializable {

  @FXML
  private ImageView trem1, trem2, reseBtt;// Imagens dos trens e botão de reset

  @FXML
  private Slider sliderTrem1, sliderTrem2; // Controles deslizantes para ajustar a velocidade dos trens

  @FXML
  private ChoiceBox<String> choicebox, choicebox2;// Caixa de selecao para escolher a configuracao dos trens

  String[] escolhas = { "Ambos Superiores", "Ambos Inferiores", "Superior Esquerdo e Inferior Direito",
      "Inferior Esquerdo e Superior Direito" };// Opções disponíveis na caixa de selecao
  String[] solucoes = { "Variaveis de Travamento", "Estrita Alternancia", "Solucao de Peterson" };// Opções disponiveis na caixa de selecao

  Movimento thread1;
  Movimento thread2;
  Train train1;
  Train train2;
  public static int solucao=0;

  public static volatile int varTrava1 = 0;
  public static volatile int varTrava2 = 0;
  public static volatile int turno1 = 0;
  public static volatile int turno2 = 0;

  public static int turnP1=0;
  public static int turnP2=0;
  public static boolean[] interesse1 = { false, false };
  public static boolean[] interesse2 = { false, false };


@Override
/* **************************************************************
* Metodo: initialize
* Funcao: Inicializa a interface grafica com as opções do ChoiceBox e define a acao ao selecionar uma opcao
* P arametros: location (URL) - localizacao do arquivo FXML, resources (ResourceBundle) - conjunto de recursos
* Retorno: void
*************************************************************** */
  public void initialize(URL location, ResourceBundle resources) {// Adiciona as opcoes ao ChoiceBox
    choicebox.getItems().addAll(escolhas);
    choicebox2.getItems().addAll(solucoes);
    choicebox2.setValue(solucoes[0]);
    choicebox.setValue(escolhas[0]);
    choicebox.setOnAction(this::escolheu); // Define a acao a ser executada quando uma opcao e selecionada
    choicebox2.setOnAction(this::escolheu2);

    train1 = new Train(0, sliderTrem1, trem1);
    train2 = new Train(1, sliderTrem2, trem2);

    thread1 = new Movimento(train1);
    thread1.setSolucao(choicebox2.getSelectionModel().getSelectedIndex());
    thread2 = new Movimento(train2);
    thread2.setSolucao(choicebox2.getSelectionModel().getSelectedIndex());

    thread1.start();
    thread2.start();
  }

/* ***************************************************************
* Metodo: reset
* Funcao: redefine a posicao inicial dos trens
* Parametros: event (MouseEvent) - evento de mouse que acionou o metodo
* Retorno: void
*************************************************************** */
  public void reset(MouseEvent event) {
    varTrava1 = 0;
    varTrava2 = 0;
    turno1 = 0;
    turno2 = 0;
    turnP1=0;
    turnP2=0;
    interesse1[0] = false;
    interesse1[1] = false;
    interesse2[0] = false;
    interesse2[1] = false;
    thread1.setSolucao(choicebox2.getSelectionModel().getSelectedIndex());
    thread2.setSolucao(choicebox2.getSelectionModel().getSelectedIndex());
    posicionarTrens(trem1, trem2);
  }//fim do metodo reset

/* ***************************************************************
* Metodo: escolheu
* Funcao: executa a acao ao selecionar uma opcao no ChoiceBox
* Parametros: event (ActionEvent) - evento de acao que acionou o método
* Retorno: void
*************************************************************** */
  public void escolheu(ActionEvent event) {
    varTrava1 = 0;
    varTrava2 = 0;
    turno1 = 0;
    turno2 = 0;
    turnP1=0;
    turnP2=0;
    interesse1[0] = false;
    interesse1[1] = false;
    interesse2[0] = false;
    interesse2[1] = false;
    posicionarTrens(trem1, trem2);
  }

/* ***************************************************************
* Metodo: escolheu2
* Funcao: Configura a solucao de sincronizacao para os trens e reseta as variaveis de controle das regioes criticas
* Parametros: event (ActionEvent) - evento acionado pela interface
* Retorno: void
*************************************************************** */
  public void escolheu2(ActionEvent event) {
    varTrava1 = 0;
    varTrava2 = 0;
    turno1 = 0;
    turno2 = 0;
    turnP1=0;
    turnP2=0;
    interesse1[0] = false;
    interesse1[1] = false;
    interesse2[0] = false;
    interesse2[1] = false;
    thread1.setSolucao(choicebox2.getSelectionModel().getSelectedIndex());
    thread2.setSolucao(choicebox2.getSelectionModel().getSelectedIndex());
    posicionarTrens(trem1, trem2);
  }

  /* ***************************************************************
* Metodo: posicionarTrens
* Funcao: posiciona os trens de acordo com a escolha do usuário
* Parametros: trem1 (ImageView), trem2 (ImageView) - imagens dos trens a serem posicionados
* Retorno: void
*************************************************************** */
  public void posicionarTrens(ImageView trem1, ImageView trem2) {
    sliderTrem1.setValue(1.0);
    sliderTrem2.setValue(1.0);
    switch (choicebox.getSelectionModel().getSelectedIndex()) {
      case 0://caso a posicao inicial seja superior esquerda e direita
        train1 = new Train(0, sliderTrem1, trem1);
        train2 = new Train(1, sliderTrem2, trem2);
        solucao=choicebox2.getSelectionModel().getSelectedIndex();
        thread1.setTrem(train1);
        thread2.setTrem(train2);
        break;

      case 1://caso a posicao inicial seja inferior esquerda e direita
        train1 = new Train(2, sliderTrem1, trem1);
        train2 = new Train(3, sliderTrem2, trem2);
        solucao=choicebox2.getSelectionModel().getSelectedIndex();
        thread1.setTrem(train1);
        thread2.setTrem(train2);
        break;

      case 2://caso a posicao inicial seja superior esquerda e inferior direita
        train1 = new Train(0, sliderTrem1, trem1);
        train2 = new Train(3, sliderTrem2, trem2);
        solucao=choicebox2.getSelectionModel().getSelectedIndex();
        thread1.setTrem(train1);
        thread2.setTrem(train2);
        break;

      case 3://caso a posicao inicial seja superior direita e inferior esquerda
        train1 = new Train(2, sliderTrem1, trem1);
        train2 = new Train(1, sliderTrem2, trem2);
        solucao=choicebox2.getSelectionModel().getSelectedIndex();
        thread1.setTrem(train1);
        thread2.setTrem(train2);
        break;

      default:
        break;
    }//fim do switch
  }//fim do construtor

}
