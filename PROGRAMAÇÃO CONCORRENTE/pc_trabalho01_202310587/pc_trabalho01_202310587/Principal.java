/* ***************************************************************
* Autor............: Kauan Rubem Fausto Matos
* Matricula........: 202310587
* Inicio...........: 20/03/2024
* Ultima alteracao.: 25/03/2024
* Nome.............: Principal.java
* Funcao...........: Aplicacao JavaFX que cria uma interface grafica de usuario(GUI)
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.Controle;

public class Principal extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
/* ***************************************************************
* Metodo: start
* Funcao: inicia a aplicacao JavaFX carregando a interface de usuario
* Parametros: primaryStage (Stage) - palco principal da aplicacao
* Retorno: void
*************************************************************** */
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("view/telas.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.getIcons().add(new Image("assets/tremIcon.png"));
    primaryStage.show();
  }//fim do metodo start
}//fim da classe principal