package lab.aikibo.viewmodel;

import java.io.Serializable;

import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;

public class GlobalController extends SelectorComposer<Component> 
		implements Serializable {

	private static final long serialVersionUID = 8754435502342583134L;
	
	@GlobalCommand
	public void updateView() {
		Clients.showNotification("Nama page-nya : " + getPage().getRequestPath());
		Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
		include.setSrc("/timeout.zul");
		Clients.showNotification("login.zul sudah dipanggil");
	}

}