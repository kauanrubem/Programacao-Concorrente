/* ***************************************************************
* Autor............: Kauan Rubem Fausto Matos
* Matricula........: 202310587
* Inicio...........: 29/04/2024
* Ultima alteracao.: 02/05/2024
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
  private ChoiceBox<String> choicebox;// Caixa de seleção para escolher a configuração dos trens

  String[] escolhas = { "Ambos Superiores", "Ambos Inferiores", "Superior Esquerdo e Inferior Direito",
      "Inferior Esquerdo e Superior Direito" };// Opções disponíveis na caixa de seleção

  Movimento thread1;
  Movimento thread2;
  Train train1;
  Train train2;

@Override
/* **************************************************************
* Metodo: initialize
* Funcao: Inicializa a interface gráfica com as opções do ChoiceBox e define a ação ao selecionar uma opção
* Parametros: location (URL) - localização do arquivo FXML, resources (ResourceBundle) - conjunto de recursos
* Retorno: void
*************************************************************** */
  public void initialize(URL location, ResourceBundle resources) {// Adiciona as opções ao ChoiceBox
    choicebox.getItems().addAll(escolhas);// Define a ação a ser executada quando uma opção é selecionada
    choicebox.setValue(escolhas[0]);
    choicebox.setOnAction(this::escolheu);

    thread1 = new Movimento(new Train(trem1, sliderTrem1, 0));
    thread2 = new Movimento(new Train(trem2, sliderTrem2, 1));

    thread1.start();
    thread2.start();
  }

/* ***************************************************************
* Metodo: reset
* Funcao: redefine a posição inicial dos trens
* Parametros: event (MouseEvent) - evento de mouse que acionou o método
* Retorno: void
*************************************************************** */
  public void reset(MouseEvent event) {
    posicionarTrens(trem1, trem2);
  }//fim do metodo reset

/* ***************************************************************
* Metodo: escolheu
* Funcao: executa a ação ao selecionar uma opção no ChoiceBox
* Parametros: event (ActionEvent) - evento de ação que acionou o método
* Retorno: void
*************************************************************** */
  public void escolheu(ActionEvent event) {
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
        train1 = new Train(trem1, sliderTrem1, 0);
        train2 = new Train(trem2, sliderTrem2, 1);
        thread1.setTrem(train1);
        thread2.setTrem(train2);
        break;

      case 1://caso a posicao inicial seja inferior esquerda e direita
        train1 = new Train(trem1, sliderTrem1, 2);
        train2 = new Train(trem2, sliderTrem2, 3);
        thread1.setTrem(train1);
        thread2.setTrem(train2);
        break;

      case 2://caso a posicao inicial seja superior esquerda e inferior direita
        train1 = new Train(trem1, sliderTrem1, 0);
        train2 = new Train(trem2, sliderTrem2, 3);
        thread1.setTrem(train1);
        thread2.setTrem(train2);
        break;

      case 3://caso a posicao inicial seja superior direita e inferior esquerda
        train1 = new Train(trem1, sliderTrem1, 2);
        train2 = new Train(trem2, sliderTrem2, 1);
        thread1.setTrem(train1);
        thread2.setTrem(train2);
        break;

      default:
        break;
    }//fim do switch
  }//fim do construtor

}
