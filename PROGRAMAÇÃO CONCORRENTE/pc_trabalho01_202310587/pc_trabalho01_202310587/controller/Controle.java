/* ***************************************************************
* Autor............: Kauan Rubem Fausto Matos
* Matricula........: 202310587
* Inicio...........: 20/03/2024
* Ultima alteracao.: 25/03/2024
* Nome.............: Controle.java
* Funcao...........: Implementa uma aplicacao em JavaFX que controla o movimento de dois trens
*************************************************************** */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controle implements Initializable {

  @FXML
  private ImageView trem1, trem2, reseBtt;// Imagens dos trens e botão de reset

  @FXML
  private Slider sliderTrem1, sliderTrem2; // Controles deslizantes para ajustar a velocidade dos trens

  @FXML
  private ChoiceBox<String> choicebox;// Caixa de seleção para escolher a configuração dos trens

  String[] escolhas = { "Ambos Superiores", "Ambos Inferiores", "Superior Esquerdo e Inferior Direito",
      "Inferior Esquerdo e Superior Direito" };// Opções disponíveis na caixa de seleção

  AnimationTimer timer = new AnimationTimer() {

    @Override

/* **************************************************************
* Metodo: handle
* Funcao: Atualiza a movimentação dos trens em resposta ao tempo atual
* Parametros: now (long) - tempo atual
* Retorno: void
*************************************************************** */
    public void handle(long now) {// Executa a movimentação dos trens na interface gráfica
      Platform.runLater(() -> {
        movimentarTrens(choicebox.getSelectionModel().getSelectedIndex());
      });
    }

  };

  @Override

/* **************************************************************
* Metodo: initialize
* Funcao: Inicializa a interface gráfica com as opções do ChoiceBox e define a ação ao selecionar uma opção
* Parametros: location (URL) - localização do arquivo FXML, resources (ResourceBundle) - conjunto de recursos
* Retorno: void
*************************************************************** */
  public void initialize(URL location, ResourceBundle resources) {// Adiciona as opções ao ChoiceBox
    choicebox.getItems().addAll(escolhas);// Define a ação a ser executada quando uma opção é selecionada
    choicebox.setOnAction(this::escolheu);
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
    timer.start();//fim do metodo escolheu
  }

/* ***************************************************************
* Metodo: movimentarTrens
* Funcao: movimenta os trens de acordo com a escolha do usuário
* Parametros: escolhaDoUsuario (int) - índice da escolha selecionada pelo usuário
* Retorno: void
*************************************************************** */
  public void movimentarTrens(int escolhaDoUsuario) {
    switch (escolhaDoUsuario) {
      case 0:
      // Movimento dos trens para a escolha 0: Ambos Superiores
        if (trem1.getLayoutY() < 70) {
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 70 && trem1.getLayoutY() < 127) {
          trem1.setRotate(45);
          trem1.setLayoutX(trem1.getLayoutX() + sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 127 && trem1.getLayoutY() < 222) {
          trem1.setRotate(90);
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 222 && trem1.getLayoutY() < 275) {
          trem1.setRotate(135);
          trem1.setLayoutX(trem1.getLayoutX() - sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 275 && trem1.getLayoutY() < 370) {
          trem1.setRotate(90);
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 370 && trem1.getLayoutY() < 425) {
          trem1.setRotate(45);
          trem1.setLayoutX(trem1.getLayoutX() + sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 425 && trem1.getLayoutY() < 520) {
          trem1.setRotate(90);
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 520 && trem1.getLayoutY() < 580) {
          trem1.setRotate(135);
          trem1.setLayoutX(trem1.getLayoutX() - sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 580 && trem1.getLayoutY() < 720) {
          trem1.setRotate(90);
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 720) {
          trem1.setLayoutY(-40);
          trem1.setLayoutX(273);
          trem1.setRotate(90);
        }

        if (trem2.getLayoutY() < 70) {
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 70 && trem2.getLayoutY() < 127) {
          trem2.setRotate(135);
          trem2.setLayoutX(trem2.getLayoutX() - sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 127 && trem2.getLayoutY() < 219) {
          trem2.setRotate(90);
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 219 && trem2.getLayoutY() < 275) {
          trem2.setRotate(45);
          trem2.setLayoutX(trem2.getLayoutX() + sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 275 && trem2.getLayoutY() < 370) {
          trem2.setRotate(90);
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 370 && trem2.getLayoutY() < 425) {
          trem2.setRotate(135);
          trem2.setLayoutX(trem2.getLayoutX() - sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 425 && trem2.getLayoutY() < 520) {
          trem2.setRotate(90);
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 520 && trem2.getLayoutY() < 580) {
          trem2.setRotate(45);
          trem2.setLayoutX(trem2.getLayoutX() + sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 580 && trem2.getLayoutY() < 720) {
          trem2.setRotate(90);
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 720) {
          trem2.setLayoutY(-40);
          trem2.setLayoutX(385);
          trem2.setRotate(90);
        }
        break;

      case 1:
      // Movimento dos trens para a escolha 1: ambos inferiores
        if (trem1.getLayoutY() > 580) {
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 580 && trem1.getLayoutY() > 520) {
          trem1.setRotate(315);
          trem1.setLayoutX(trem1.getLayoutX() + sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 520 && trem1.getLayoutY() > 425) {
          trem1.setRotate(270);
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 425 && trem1.getLayoutY() > 370) {
          trem1.setRotate(225);
          trem1.setLayoutX(trem1.getLayoutX() - sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 370 && trem1.getLayoutY() > 280) {
          trem1.setRotate(270);
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 280 && trem1.getLayoutY() > 225) {
          trem1.setRotate(315);
          trem1.setLayoutX(trem1.getLayoutX() + sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 225 && trem1.getLayoutY() > 120) {
          trem1.setRotate(270);
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 120 && trem1.getLayoutY() > 65) {
          trem1.setRotate(225);
          trem1.setLayoutX(trem1.getLayoutX() - sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 65 && trem1.getLayoutY() > -80) {
          trem1.setRotate(270);
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= -80) {
          trem1.setLayoutY(680);
          trem1.setLayoutX(273);
          trem1.setRotate(270);
        }

        if (trem2.getLayoutY() > 580) {
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 580 && trem2.getLayoutY() > 520) {
          trem2.setRotate(225);
          trem2.setLayoutX(trem2.getLayoutX() - sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 520 && trem2.getLayoutY() > 425) {
          trem2.setRotate(270);
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 425 && trem2.getLayoutY() > 370) {
          trem2.setRotate(315);
          trem2.setLayoutX(trem2.getLayoutX() + sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 370 && trem2.getLayoutY() > 280) {
          trem2.setRotate(270);
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 280 && trem2.getLayoutY() > 225) {
          trem2.setRotate(225);
          trem2.setLayoutX(trem2.getLayoutX() - sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 225 && trem2.getLayoutY() > 120) {
          trem2.setRotate(270);
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 120 && trem2.getLayoutY() > 65) {
          trem2.setRotate(315);
          trem2.setLayoutX(trem2.getLayoutX() + sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 65 && trem2.getLayoutY() > -80) {
          trem2.setRotate(270);
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= -80) {
          trem2.setLayoutY(680);
          trem2.setLayoutX(390);
          trem2.setRotate(270);
        }

        break;

      case 2:
      // Movimento dos trens para a escolha 0: Superior esquerdo e inferior direito
        if (trem1.getLayoutY() < 70) {
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 70 && trem1.getLayoutY() < 127) {
          trem1.setRotate(45);
          trem1.setLayoutX(trem1.getLayoutX() + sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 127 && trem1.getLayoutY() < 222) {
          trem1.setRotate(90);
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 222 && trem1.getLayoutY() < 275) {
          trem1.setRotate(135);
          trem1.setLayoutX(trem1.getLayoutX() - sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 275 && trem1.getLayoutY() < 370) {
          trem1.setRotate(90);
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 370 && trem1.getLayoutY() < 425) {
          trem1.setRotate(45);
          trem1.setLayoutX(trem1.getLayoutX() + sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 425 && trem1.getLayoutY() < 520) {
          trem1.setRotate(90);
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 520 && trem1.getLayoutY() < 580) {
          trem1.setRotate(135);
          trem1.setLayoutX(trem1.getLayoutX() - sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 580 && trem1.getLayoutY() < 720) {
          trem1.setRotate(90);
          trem1.setLayoutY(trem1.getLayoutY() + sliderTrem1.getValue());
        } else if (trem1.getLayoutY() >= 720) {
          trem1.setLayoutY(-40);
          trem1.setLayoutX(273);
          trem1.setRotate(90);
        }

        if (trem2.getLayoutY() > 580) {
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 580 && trem2.getLayoutY() > 520) {
          trem2.setRotate(225);
          trem2.setLayoutX(trem2.getLayoutX() - sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 520 && trem2.getLayoutY() > 425) {
          trem2.setRotate(270);
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 425 && trem2.getLayoutY() > 370) {
          trem2.setRotate(315);
          trem2.setLayoutX(trem2.getLayoutX() + sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 370 && trem2.getLayoutY() > 280) {
          trem2.setRotate(270);
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 280 && trem2.getLayoutY() > 225) {
          trem2.setRotate(225);
          trem2.setLayoutX(trem2.getLayoutX() - sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 225 && trem2.getLayoutY() > 120) {
          trem2.setRotate(270);
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 120 && trem2.getLayoutY() > 65) {
          trem2.setRotate(315);
          trem2.setLayoutX(trem2.getLayoutX() + sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= 65 && trem2.getLayoutY() > -80) {
          trem2.setRotate(270);
          trem2.setLayoutY(trem2.getLayoutY() - sliderTrem2.getValue());
        } else if (trem2.getLayoutY() <= -80) {
          trem2.setLayoutY(680);
          trem2.setLayoutX(390);
          trem2.setRotate(270);
        }
        break;

      case 3:
      // Movimento dos trens para a escolha 0: Superior direito e inferior esquerdo
        if (trem1.getLayoutY() > 580) {
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 580 && trem1.getLayoutY() > 520) {
          trem1.setRotate(315);
          trem1.setLayoutX(trem1.getLayoutX() + sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 520 && trem1.getLayoutY() > 425) {
          trem1.setRotate(270);
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 425 && trem1.getLayoutY() > 370) {
          trem1.setRotate(225);
          trem1.setLayoutX(trem1.getLayoutX() - sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 370 && trem1.getLayoutY() > 280) {
          trem1.setRotate(270);
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 280 && trem1.getLayoutY() > 225) {
          trem1.setRotate(315);
          trem1.setLayoutX(trem1.getLayoutX() + sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 225 && trem1.getLayoutY() > 120) {
          trem1.setRotate(270);
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 120 && trem1.getLayoutY() > 65) {
          trem1.setRotate(225);
          trem1.setLayoutX(trem1.getLayoutX() - sliderTrem1.getValue());
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= 65 && trem1.getLayoutY() > -80) {
          trem1.setRotate(270);
          trem1.setLayoutY(trem1.getLayoutY() - sliderTrem1.getValue());
        } else if (trem1.getLayoutY() <= -80) {
          trem1.setLayoutY(680);
          trem1.setLayoutX(273);
          trem1.setRotate(270);
        }

        if (trem2.getLayoutY() < 70) {
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 70 && trem2.getLayoutY() < 127) {
          trem2.setRotate(135);
          trem2.setLayoutX(trem2.getLayoutX() - sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 127 && trem2.getLayoutY() < 219) {
          trem2.setRotate(90);
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 219 && trem2.getLayoutY() < 275) {
          trem2.setRotate(45);
          trem2.setLayoutX(trem2.getLayoutX() + sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 275 && trem2.getLayoutY() < 370) {
          trem2.setRotate(90);
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 370 && trem2.getLayoutY() < 425) {
          trem2.setRotate(135);
          trem2.setLayoutX(trem2.getLayoutX() - sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 425 && trem2.getLayoutY() < 520) {
          trem2.setRotate(90);
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 520 && trem2.getLayoutY() < 580) {
          trem2.setRotate(45);
          trem2.setLayoutX(trem2.getLayoutX() + sliderTrem2.getValue());
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 580 && trem2.getLayoutY() < 720) {
          trem2.setRotate(90);
          trem2.setLayoutY(trem2.getLayoutY() + sliderTrem2.getValue());
        } else if (trem2.getLayoutY() >= 720) {
          trem2.setLayoutY(-40);
          trem2.setLayoutX(385);
          trem2.setRotate(90);
        }

        break;

      default:
        break;
    }
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
        trem1.setLayoutY(-40);
        trem1.setLayoutX(273);
        trem1.setRotate(90);
        trem2.setLayoutY(-40);
        trem2.setLayoutX(385);
        trem2.setRotate(90);
        break;

      case 1://caso a posicao inicial seja inferior esquerda e direita
        trem1.setLayoutY(680);
        trem1.setLayoutX(273);
        trem1.setRotate(270);
        trem2.setLayoutY(680);
        trem2.setLayoutX(390);
        trem2.setRotate(270);
        break;

      case 2://caso a posicao inicial seja superior esquerda e inferior direita
        trem1.setLayoutY(-40);
        trem1.setLayoutX(273);
        trem1.setRotate(90);
        trem2.setLayoutY(680);
        trem2.setLayoutX(390);
        trem2.setRotate(270);

        break;

      case 3://caso a posicao inicial seja superior direita e inferior esquerda
        trem1.setLayoutY(680);
        trem1.setLayoutX(273);
        trem1.setRotate(270);
        trem2.setLayoutY(-40);
        trem2.setLayoutX(385);
        trem2.setRotate(90);
        break;

      default:
        break;
    }//fim do switch
  }//fim do construtor

}
