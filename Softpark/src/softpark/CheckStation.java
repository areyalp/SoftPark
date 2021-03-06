package softpark;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class CheckStation {

	public static void main(String[] args) {

		new CheckStation();

	} // END OF main

	public CheckStation() {
		try{
			Db db = new Db();
			String macAddress = GetNetworkAddress.GetAddress("mac");
			if(!(macAddress == null)){
				//if(macAddress.equalsIgnoreCase("00-19-21-20-01-4e")) { //Mac Address antigua
				//if(macAddress.equalsIgnoreCase("00-e0-7d-fc-ea-ad")) {
				if(true) {
					ResultSet rowsMac = db.select("SELECT Id FROM Stations WHERE"
							+ " MacAddress = '" + macAddress + "'");
					if(rowsMac.next()){
						new SoftParkView(rowsMac.getInt("Id"));
					}else{
						new SelectStationView();
					}
				}/*else{
					JOptionPane.showMessageDialog(null, "Instalacion incorrecta");
					System.exit(0);
				}*/
			}else{
				JOptionPane.showMessageDialog(null, "No esta conectado a la red", "Conectese a la red", JOptionPane.ERROR_MESSAGE);
			}
		} //END OF try
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getCause());
		} //END OF catch
	} // END OF CheckStation

}