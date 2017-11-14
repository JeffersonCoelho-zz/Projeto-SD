package br.com.sistemasDistribuidos.AdventureWorks;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import br.com.sistemasDistribuidos.Fabrikam.IFabrikam;

public class AdventureWorks extends UnicastRemoteObject implements IAdventureWorks {

	private static final long serialVersionUID = 1L;
	private IFabrikam fabrikam;

	public AdventureWorks() throws RemoteException {
		initServer();
		fabrikam.startCheckAllStatus();
	}

	@Override
	public void sendRequest(Integer id, String phone) throws RemoteException {

		fabrikam.openProcess(id, phone);
	}

	@Override
	public HashMap<Integer, ArrayList> listRequest() throws RemoteException {
		return fabrikam.listProcess();
	}

	private void initServer() throws RemoteException {

		try {
			fabrikam = (IFabrikam) Naming.lookup("rmi://localhost/fb");

		} catch (MalformedURLException | NotBoundException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}
}
