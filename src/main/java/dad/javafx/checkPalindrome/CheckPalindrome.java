package dad.javafx.checkPalindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindrome extends Application {
	
	private Label saludoLabel;  //es una buena pr�ctica declarar los componentes como variables de la instancia
	private Button saludarButton;
	private TextField nombreText;

	@Override
	public void start(Stage primaryStage) throws Exception {  //si no se implementa este m�todo, me dar� error debido al extends
		// TODO Auto-generated method stub
		
		nombreText = new TextField();

		nombreText.setPromptText("Introduce un nombre");  // > > > esto aqu� como que no est� haciendo nada
		nombreText.setMaxWidth(150);  //establecemos el tope de expansi�n. Hasta 150 p�xeles

		saludarButton = new Button("Comprobar");  // > > de esta forma se establece un bot�n con algo escrito en �l, en este caso ser� "comprobar"
		saludarButton.setDefaultButton(true);
		saludarButton.setOnAction(e -> onSaludarButtonAction(e));  //esto aqu� es una expresi�n lambda
		//aqu� al hacer click, es decir, el evento desencadena la acci�n del bot�n que ser� comprobar si es pal�ndromo

		saludoLabel = new Label(); //aqu� ser� donde se diga si es pal�ndromo o no 

		VBox root = new VBox();  //es un tipo de panel especial que lo que hace es colocar los elementos en vertical 
		root.setSpacing(5);  //aqu� es el espaciado en la vertical
		root.setAlignment(Pos.CENTER);  //con esto centramos el elemento. Puede ser CENTER_LEFT, CENTER_RIGHT, etc.
		root.getChildren().addAll(nombreText, saludarButton, saludoLabel);

		//con VBox generamos la ventana. Sin �l, es decir, si lo quitamos ni siquiera nos saltar� la ventana.
		
		Scene scene = new Scene(root, 320, 200);  //establecemos el ancho y alto de la ventana

		primaryStage.setTitle("Comprobador de pal�ndromos");   //damos un t�tulo a la ventana
		primaryStage.setScene(scene); //se espec�fica la escena que ser� utilizada que en este caso pues es root (la caja vertical que contiene el campo de texto, el bot�n y el saludo label
										//el saludo label ser� decir si es pal�ndromo o no
		primaryStage.show(); //esto permitir� mostrar la escene, es decir, la ventana
		
		
	}
	
	private boolean checkPalindrome(String inputString) {
	      
	      int mitad = inputString.length()/2;
	      
	      for(int i= 0; i < mitad; i++){
	            
	            if(inputString.charAt(i) != inputString.charAt(inputString.length() -1 - i)){
	                  
	                  return false;
	            }

	      }
	                  return true;
	}
	
	
	private void onSaludarButtonAction(ActionEvent e) { //aqu� se recibe el evento del click?
		// TODO Auto-generated method stub
		
		String palabra = nombreText.getText(); //aqu� se guarda el texto introducido por el usuario
		
		if(checkPalindrome(palabra)!=true) {
			
			saludoLabel.setText("�No es pal�ndromo!"); //establecemos el texto que saldr� en la etiqueta y debajo le daremos estilo
			saludoLabel.setStyle("-fx-text-fill: red; -fx-font: italic bold 30 sans-serif;");
			
		}else {
			
			saludoLabel.setText("�Es pal�ndromo!");
			saludoLabel.setStyle("-fx-text-fill: green; -fx-font: italic bold 30 sans-serif;");
			
		}


	}


	public static void main(String[] args) {

		launch(args); 
	}


}
