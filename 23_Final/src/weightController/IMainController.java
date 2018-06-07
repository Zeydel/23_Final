package weightController;

import weightSim.socket.ISocketController;
import weightSim.IWeightInterfaceController;

public interface IMainController {
	void init(ISocketController socketHandler, IWeightInterfaceController uiController);
	void start();

}
