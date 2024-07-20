/* ***************************************************************
* Autor............: Kauan Rubem Fausto Matos
* Matricula........: 202310587
* Inicio...........: 23/05/2024
* Ultima alteracao.: 26/05/2024
* Nome.............: Movimento.java
* Funcao...........: Implementa uma aplicacao em JavaFX que controla o movimento de dois trens
*************************************************************** */
package controller;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import model.Train;

/* ***************************************************************
* Classe: Movimento
* Funcao: Controla o movimento de dois trens utilizando JavaFX e 
implementa mecanismos de sincronizacao para evitar condicoes de corrida
*************************************************************** */
public class Movimento extends Thread {
  private Train trem; // Objeto que representa o trem
  private ImageView imageTrem; // Imagem do trem
  private Slider slider; // Controle de velocidade do trem
  private static int controle = 0; // Variavel estatica para controle de IDs dos trens
  private int id; // ID do trem
  private int solucao = 0; // Solucao de sincronizacao utilizada

  private boolean zonacritica1 = false; // Indicador de zona critica 1
  private boolean zonacritica2 = false; // Indicador de zona critica 2

  /* ***************************************************************
  * Construtor: Movimento
  * Funcao: Inicializa os atributos da classe, define o ID do trem e configura a imagem e controle de velocidade do trem
  * Parametros: trem (Train) - objeto que representa o trem
  * Retorno: nenhum
  *************************************************************** */
  public Movimento(Train trem) {
    this.trem = trem;
    imageTrem = trem.getImageView();
    slider = trem.getSpeed();
    if (controle == 0) { // Define o ID do trem com base na variavel controle
      id = 0;
      controle++;
    } else {
      id = 1;
    }
    System.out.println("ID: " + id); // Imprime o ID do trem
  }


  @Override
  public void run(){
    while(true){
      Platform.runLater(() -> {
        solucao = Controle.solucao;
        movimentarTrens();
      });
      try {
        Thread.sleep(17);
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
      case 0:{
      // Movimento dos trens para a escolha 0: Ambos Superiores
        if (imageTrem.getLayoutY() < 70) {
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 70 && imageTrem.getLayoutY() < 127) {
          //RC 1
          if(!entrounaRC1(solucao) && !zonacritica1){
            break;
          }
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
          //SAIU da RC 1
          saiuRC1(solucao);
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 370 && imageTrem.getLayoutY() < 425) {
          //RC 2
          if(!entrounaRC2(solucao) && !zonacritica2){
            break;
          }
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
          //SAIU da RC 2
          saiuRC2(solucao);
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 720) {
          imageTrem.setLayoutY(-40);
          imageTrem.setLayoutX(273);
          imageTrem.setRotate(90);
        }

        break;}

      case 1:{
      // Movimento dos trens para a escolha 0: Ambos Inferiores
        if (imageTrem.getLayoutY() < 70) {
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 70 && imageTrem.getLayoutY() < 127) {
          //RC 1
          if (!entrounaRC1(solucao) && !zonacritica1){
            break;
          }
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
          //SAIU da RC 1
          saiuRC1(solucao);
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 370 && imageTrem.getLayoutY() < 425) {
          //RC 2
          if (!entrounaRC2(solucao) && !zonacritica2){
            break;
          }
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
          //SAIU da RC 2
          saiuRC2(solucao);
          imageTrem.setRotate(90);
          imageTrem.setLayoutY(imageTrem.getLayoutY() + slider.getValue());
        } else if (imageTrem.getLayoutY() >= 720) {
          imageTrem.setLayoutY(-40);
          imageTrem.setLayoutX(385);
          imageTrem.setRotate(90);
        }

        break;}

      case 2:{
      // Movimento dos trens para a escolha 0: Superior esquerdo e inferior direito
        if (imageTrem.getLayoutY() > 580) {
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 580 && imageTrem.getLayoutY() > 520) {
          //RC 2 // n tem
            if (!entrounaRC2(solucao) && !zonacritica2){
              break;
            }
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
          //SAIU da RC 2
          saiuRC2(solucao);
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 280 && imageTrem.getLayoutY() > 225) {
          //RC 1
            if (!entrounaRC1(solucao) && !zonacritica1){
              break;
            }
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
          //SAIU da RC 1
          saiuRC1(solucao);
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= -80) {
          imageTrem.setLayoutY(680);
          imageTrem.setLayoutX(273);
          imageTrem.setRotate(270);
        }
          break;}

      case 3:{
      // Movimento dos trens para a escolha 0: Superior direito e inferior esquerdo
        if (imageTrem.getLayoutY() > 580) {
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());
        } else if (imageTrem.getLayoutY() <= 580 && imageTrem.getLayoutY() > 520) {
          //RC 2//tem
          if (!entrounaRC2(solucao) && !zonacritica2){
            break;
          }
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
          //SAIU da RC 2
          saiuRC2(solucao);
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());

        } else if (imageTrem.getLayoutY() <= 280 && imageTrem.getLayoutY() > 225) {
          //RC 1
          if (!entrounaRC1(solucao) && !zonacritica1){
            break;
          }
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
          //SAIU da RC 1
          saiuRC1(solucao);
          imageTrem.setRotate(270);
          imageTrem.setLayoutY(imageTrem.getLayoutY() - slider.getValue());

        } else if (imageTrem.getLayoutY() <= -80) {
          imageTrem.setLayoutY(680);
          imageTrem.setLayoutX(390);
          imageTrem.setRotate(270);
        }

        break;}

        default:
          break;
        }//Fim do switch

    }//Fim do metodo movimentarTrens

      private boolean entrounaRC1(int solucao) {
    switch (solucao) {
      case 0:{ // Variavel de travamento
        if(Controle.varTrava1==1){
          return false;
        }else{
          Controle.varTrava1 = 1;
          zonacritica1 = true;
          return true;
        }//Fim do else
      }//Fim do case 0

      case 1:{//Estrita alternancia
        if(Controle.turno1 !=id){;
          return false;
        }else{
          zonacritica1 = true;
          return true ;
        }
      }//Fim do case 1

      case 2:{//Peterson
        int outro;
        outro = 1 - id;
        Controle.interesse1[id] = true;
        Controle.turnP1 = id;
        if(Controle.turnP1 == id && Controle.interesse1[outro] == true){//turnP1 e interesse sao variaveis estaticas definida na classe de controle
          return false;
        } else {
          zonacritica1 = true;//flag setada como true para indicar que o trem ja acessou a regiao critica e pode continuar acessando 
          return true;
        }//Fim do else
      }//Fim do case 2
      default:
        return true;
    }//Fim do switch

      }//Fim do case 2

  private void saiuRC1(int solucao) {
    switch (solucao) {
       case 0:{//variavel de travamento
        Controle.varTrava1 = 0;//caso o trem saia da zona critica 1 a variavel de travamento da zona critica 1 eh desocupada
        zonacritica1 = false;//flag setada como false para indicar que o trem ja passou pela regiao critica 1
        break;
      }//Fim do case 0
      case 1:{//estrita alternancia
      Controle.turno1 = 1-id;//caso o trem saia da zona critica 1 a variavel de turno eh setada para o outro trem
      zonacritica1 = false;//flag setada como false para indicar que o trem ja passou pela regiao critica 1
        break;
      }//Fim do case 1
      case 2:{//solucao de peterson
        Controle.interesse1[id] = false;//interesse1 eh uma variavel estatica definida na classe de controle
        zonacritica1 = false;//flag setada como false para indicar que o trem ja passou pela regiao critica 1
        break;
      }//Fim do case 2
    }//Fim do switch
  }//Fim do metodo saiuRC1
  
  private boolean entrounaRC2(int solucao) {
      switch (solucao) {
      case 0:{ // Variavel de travamento

        if(Controle.varTrava2==1){
          return false;

        }else{
          Controle.varTrava2 = 1;
          zonacritica2 = true;
          return true;
        }
      }//Fim do case 0

      case 1:{//Estrita alternancia
        if(Controle.turno2 != id){
          return false;

        }else{
          zonacritica2 = true;
          return true;
        }
      }//Fim do case 1

      case 2:{//Peterson
        int outro;
        outro = 1 - id;
        Controle.interesse2[id] = true;
        Controle.turnP2 = id;
        if(Controle.turnP2 == id && Controle.interesse2[outro] == true){
          return false;
        } else {
          zonacritica2 = true;
          return true;
        } 
      

      }//Fim do case 2
    default:
      return true;
    }//Fim do switch
  }// Fim do metodo entrounaRC2

  private void saiuRC2(int solucao) {
      switch (solucao) {
      case 0:{//Variavel de travamento da zona critica 2

        Controle.varTrava2 = 0;
        // caso o trem saia da zona critica 2 a variavel de travamento da zona critica 1 eh desocupada
        zonacritica2 = false;
        break;

      }//Fim do case 0

      case 1:{//estrita alternancia
        Controle.turno2 = 1-id;//caso o trem saia da zona critica 2 a variavel de turno eh setada para o outro trem
        zonacritica2 = false;//flag setada como false para indicar que o trem ja passou pela regiao critica 2
        break;
      }//Fim do case 1
      case 2:{//solucao de peterson
        Controle.interesse2[id] = false;//interesse2 eh uma variavel estatica definida na classe de controle
        zonacritica2 = false;//flag setada como false para indicar que o trem ja passou pela regiao critica 2
        break;
      }//Fim do case 2
    
      default:
        break;
    }//Fim do switch
  }//Fim do metodo saiuRC2

  

  public Train getTrem(){
    return this.trem;
  }//Fim do metodo getTrem

  public void setTrem(Train trem){
    this.trem = trem;
  }//Fim do metodo setTrem

  public int getSolucao(){
    return this.solucao;
  }//Fim do metodo getSolucao

  public int setSolucao(int solucao){
    return this.solucao = solucao;
  }//Fim do metodo setSolucao
  
}//Fim da classe Movimento
