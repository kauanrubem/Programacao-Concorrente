/* ***************************************************************
* Autor............: Kauan Rubem Fausto Matos
* Matricula........: 202310587
* Inicio...........: 29/04/2024
* Ultima alteracao.: 02/05/2024
* Nome.............: Movimento.java
* Funcao...........: Implementa uma aplicacao em JavaFX que controla o movimento de dois trens
*************************************************************** */
package controller;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import model.Train;

public class Movimento extends Thread{
  private Train trem;
  private ImageView imageTrem;
  private Slider slider;

  Movimento(Train trem){
    this.trem = trem;
    imageTrem = trem.getImageView();
    slider = trem.getSpeed();
  }

  @Override
  public void run(){
    while(true){
        Platform.runLater(() ->{
          movimentarTrens();
        });
        try {
          Thread.sleep(12);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

  /* ***************************************************************
* Metodo: movimentarTrens
* Funcao: movimenta os trens de acordo com a escolha do usuário
* Parametros: escolhaDoUsuario (int) - índice da escolha selecionada pelo usuário
* Retorno: void
*************************************************************** */
  public void movimentarTrens() {
    switch (trem.getPosicaoInicial()) {
      case 0:
      // Movimento dos trens para a escolha 0: Ambos Superiores
        if (imageTrem.getLayoutY() < 70) {
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 70 && imageTrem.getLayoutY() < 127) {
          imageTrem.setRotate(45);
          imageTrem.setLayoutX(imageTrem.getLayoutX() + slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 127 && imageTrem.getLayoutY() < 222) {
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 222 && imageTrem.getLayoutY() < 275) {
          imageTrem.setRotate(135);
          imageTrem.setLayoutX(imageTrem.getLayoutX() - slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 275 && imageTrem.getLayoutY() < 370) {
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 370 && imageTrem.getLayoutY() < 425) {
          imageTrem.setRotate(45);
          imageTrem.setLayoutX(imageTrem.getLayoutX() + slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 425 && imageTrem.getLayoutY() < 520) {
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 520 && imageTrem.getLayoutY() < 580) {
          imageTrem.setRotate(135);
          imageTrem.setLayoutX(imageTrem.getLayoutX() - slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 580 && imageTrem.getLayoutY() < 720) {
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 720) {
          imageTrem.setLayoutY(-40);
          imageTrem.setLayoutX(273);
          imageTrem.setRotate(90);
        }

        break;

      case 1:
      
        if (imageTrem.getLayoutY() < 70) {
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 70 && imageTrem.getLayoutY() < 127) {
          imageTrem.setRotate(135);
          imageTrem.setLayoutX(imageTrem.getLayoutX() - slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 127 && imageTrem.getLayoutY() < 219) {
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 219 && imageTrem.getLayoutY() < 275) {
          imageTrem.setRotate(45);
          imageTrem.setLayoutX(imageTrem.getLayoutX() + slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 275 && imageTrem.getLayoutY() < 370) {
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 370 && imageTrem.getLayoutY() < 425) {
          imageTrem.setRotate(135);
          imageTrem.setLayoutX(imageTrem.getLayoutX() - slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 425 && imageTrem.getLayoutY() < 520) {
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 520 && imageTrem.getLayoutY() < 580) {
          imageTrem.setRotate(45);
          imageTrem.setLayoutX(imageTrem.getLayoutX() + slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 580 && imageTrem.getLayoutY() < 720) {
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 720) {
          imageTrem.setLayoutY(-40);
          imageTrem.setLayoutX(385);
          imageTrem.setRotate(90);
        }

        break;

      case 2:
      // Movimento dos trens para a escolha 0: Superior esquerdo e inferior direito
        if (imageTrem.getLayoutY() > 580) {
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 580 && imageTrem.getLayoutY() > 520) {
          imageTrem.setRotate(315);
          imageTrem.setLayoutX(imageTrem.getLayoutX() + slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 520 && imageTrem.getLayoutY() > 425) {
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 425 && imageTrem.getLayoutY() > 370) {
          imageTrem.setRotate(225);
          imageTrem.setLayoutX(imageTrem.getLayoutX() - slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 370 && imageTrem.getLayoutY() > 280) {
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 280 && imageTrem.getLayoutY() > 225) {
          imageTrem.setRotate(315);
          imageTrem.setLayoutX(imageTrem.getLayoutX() + slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 225 && imageTrem.getLayoutY() > 120) {
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 120 && imageTrem.getLayoutY() > 65) {
          imageTrem.setRotate(225);
          imageTrem.setLayoutX(imageTrem.getLayoutX() - slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 65 && imageTrem.getLayoutY() > -80) {
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= -80) {
          imageTrem.setLayoutY(680);
          imageTrem.setLayoutX(273);
          imageTrem.setRotate(270);
        }
        break;

      case 3:
      // Movimento dos trens para a escolha 0: Superior direito e inferior esquerdo
        if (imageTrem.getLayoutY() > 580) {
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 580 && imageTrem.getLayoutY() > 520) {
          imageTrem.setRotate(225);
          imageTrem.setLayoutX(imageTrem.getLayoutX() - slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 520 && imageTrem.getLayoutY() > 425) {
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 425 && imageTrem.getLayoutY() > 370) {
          imageTrem.setRotate(315);
          imageTrem.setLayoutX(imageTrem.getLayoutX() + slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 370 && imageTrem.getLayoutY() > 280) {
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 280 && imageTrem.getLayoutY() > 225) {
          imageTrem.setRotate(225);
          imageTrem.setLayoutX(imageTrem.getLayoutX() - slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 225 && imageTrem.getLayoutY() > 120) {
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 120 && imageTrem.getLayoutY() > 65) {
          imageTrem.setRotate(315);
          imageTrem.setLayoutX(imageTrem.getLayoutX() + slider.getValue());
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 65 && imageTrem.getLayoutY() > -80) {
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= -80) {
          imageTrem.setLayoutY(680);
          imageTrem.setLayoutX(390);
          imageTrem.setRotate(270);
        }

        break;

      default:
        break;
    }
  }

  public Train getTrem(){
    return this.trem;
  }

  public void setTrem(Train trem){
    this.trem = trem;
  }



}
