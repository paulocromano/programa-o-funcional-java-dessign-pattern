package main;
import util.ExecuteService;
import util.Service;

public class Programa {

	public static void main(String[] args) {
		ExecuteService executeService = Service.MOTO_FACTORY_METHOD.getService();
		
		executeService.execute();
	}
}
