import java.rmi.*;

public interface ServerIntf extends Remote{
	public double add(double d1, double d2) throws RemoteException;
}
