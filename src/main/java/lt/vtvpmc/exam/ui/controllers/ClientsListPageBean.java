package lt.vtvpmc.exam.ui.controllers;

import java.util.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import lt.vtvpmc.exam.entities.Client;
import lt.vtvpmc.exam.entities.repositories.ClientRepository;
import lt.vtvpmc.exam.ui.model.ClientModel;

public class ClientsListPageBean {

	private ClientModel clientModel;
	private ClientRepository clientRepo;

	public ClientModel getClientModel() {
		return clientModel;
	}

	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}

	public ClientRepository getClientRepo() {
		return clientRepo;
	}

	public void setClientRepo(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}

	public List<Client> getClientList() {
		return clientRepo.findAll();
	}

	public String saveNew() {
		Client train = clientModel.getSelectedClient();
		clientRepo.save(train);
		clientModel.setSelectedClient(new Client());
		return "main";
	}

	public String deleteSelected(Client client) {
		if (client == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Client being deleted is null?"));
		} else {
			clientRepo.delete(client);
		}
		return "main";
	}
}