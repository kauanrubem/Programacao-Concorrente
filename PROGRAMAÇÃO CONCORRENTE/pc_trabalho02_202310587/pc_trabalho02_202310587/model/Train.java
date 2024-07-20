/* ***************************************************************
* Autor............: Kauan Rubem Fausto Matos
* Matricula........: 202310587
* Inicio...........: 29/04/2024
* Ultima alteracao.: 02/05/2024
* Nome.............: Train.java
* Funcao...........: Representa e controla um trem na interface gráfica
*************************************************************** */
package model;

import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

/* **************************************************************
* Metodo: Train
* Funcao: Construtor da classe Train
* Parametros: imageView (ImageView) - ImageView para representar a imagem do trem, speed (Slider) - Slider para controlar a velocidade do trem, posicaoInicial (int) - Posição inicial do trem (0 a 3)
* Retorno: void
*************************************************************** */
public class Train {
  private ImageView imageView; // ImageView para representar a imagem do trem
  private Slider speed; // Slider para controlar a velocidade do trem
  private int posicaoInicial; // Posição inicial do trem (0 a 3)

  // Construtor da classe Train
  public Train(ImageView imageView, Slider speed, int posicaoInicial) {
    this.imageView = imageView;
    this.speed = speed;
    this.posicaoInicial = posicaoInicial;

    // Configuração da posição inicial e orientação da imagem do trem com base na posicaoInicial
    switch (posicaoInicial) {
      case 0:
        // Posição superior esquerda, virado para baixo
        imageView.setLayoutY(-40);
        imageView.setLayoutX(273);
        imageView.setRotate(90);
        break;
      case 1:
        // Posição superior direita, virado para baixo
        imageView.setLayoutY(-40);
        imageView.setLayoutX(385);
        imageView.setRotate(90);
        break;
      case 2:
        // Posição inferior esquerda, virado para cima
        imageView.setLayoutY(680);
        imageView.setLayoutX(273);
        imageView.setRotate(270);
        break;
      case 3:
        // Posição inferior direita, virado para cima 
        imageView.setLayoutY(680);
        imageView.setLayoutX(390);
        imageView.setRotate(270);
        break;
      default:
        break;
    }//fim do switch
  }//fim do construtor Train

/* **************************************************************
* Metodo: getImageView
* Funcao: Retorna a ImageView para representar a imagem do trem
* Parametros: imageView (ImageView) - ImageView para representar a imagem do trem
* Retorno: ImageView - ImageView para representar a imagem do trem
*************************************************************** */
  public ImageView getImageView() {
    return imageView;
  }//fim do metodo getImageView

/* **************************************************************
* Metodo: getSpeed
* Funcao: Retorna o Slider de velocidade do trem
* Parametros: Speed (Slider) - Slider para controlar a velocidade do trem
* Retorno: Slider - Slider para controlar a velocidade do trem
*************************************************************** */
  public Slider getSpeed() {
    return speed;
  }//fim do metodo getSpeed

/* **************************************************************
* Metodo: setSpeed
* Funcao: Define o Slider de velocidade do trem
* Parametros: speed (Slider) - Slider para controlar a velocidade do trem
* Retorno: void
*************************************************************** */
  public void setSpeed(Slider speed) {
    this.speed = speed;
  }//fim do metodo setSpeed

/* **************************************************************
* Metodo: getPosicaoInicial
* Funcao: Retorna a posição inicial do trem
* Parametros: posicaoInicial (int) - Posição inicial do trem (0 a 3)
* Retorno: int - Posição inicial do trem
*************************************************************** */
  public int getPosicaoInicial() {
    return posicaoInicial;
  }//fim do metodo getPosicaoInicial
  /* **************************************************************
* Metodo: setPosicaoInicial
* Funcao: Define a posição inicial do trem
* Parametros: posicaoInicial (int) - Posição inicial do trem (0 a 3)
* Retorno: void
*************************************************************** */
  public void setPosicaoInicial(int posicaoInicial) {
    this.posicaoInicial = posicaoInicial;
  }//fim do metodo setPosicaoInicial

}
