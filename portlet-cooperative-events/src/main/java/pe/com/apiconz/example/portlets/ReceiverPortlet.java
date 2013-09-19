package pe.com.apiconz.example.portlets;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ReceiverPortlet extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		System.out.println("Entro al doView del Portlet Receiver");

		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/receiver.jsp")
				.include(request, response);

	}

	@Override
	public void processAction(ActionRequest arg0, ActionResponse arg1)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.processAction(arg0, arg1);
	}

	@Override
	public void processEvent(EventRequest eventRequest,
			EventResponse eventResponse) throws PortletException, IOException {
		System.out.println("ingresó al processEvent del Portlet Receiver");
		Event event = eventRequest.getEvent();
		if (event.getName().equals("requestEvent")) {
			System.out.println("recibio el evento requestEvent:" + event.getName());
			// El objeto que te retorna la función getValue() es un
			// Serializable, por eso es que el objeto que pasemos de un lado a
			// otro debe implementar la interfaz Serializable
			String requestEventData = event.getValue().toString();
			System.out.println("Portlet A llama a los servicios backend del Portlet B con el messageEvent:" + requestEventData);
			eventResponse.setRenderParameter("requestEventData", requestEventData);
			eventResponse.setEvent("responseEvent", "Portlet B retorna el status OK a los:"+ System.currentTimeMillis());
		}
	}
}
