package weightController;

import weightSim.socket.ISocketController;
import weightSim.socket.SocketController;
import weightSim.gui.WeightInterfaceControllerGUI;
import weightSim.IWeightInterfaceController;
/**
 * Simple class to fire up application and inject implementations
 * @author Christian
 *
 */
public class Main {

	public static void main(String[] args) {
		ISocketController socketHandler = new SocketController();
		IWeightInterfaceController weightController = new WeightInterfaceControllerGUI();
		//Injecting socket and uiController into mainController - Replace with improved versions...
		IMainController mainCtrl = new MainController(socketHandler, weightController);
		//.init and .start could be merged
		mainCtrl.start();
	}
}
