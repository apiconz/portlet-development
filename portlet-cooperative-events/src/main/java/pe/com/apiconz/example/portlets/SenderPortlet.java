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

public class SenderPortlet extends GenericPortlet {

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		System.out.println("Entro al doView del Portlet Receiver");

		getPortletContext().getRequestDispatcher("/WEB-INF/jsp/sender.jsp")
				.include(request, response);

	}

	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {

		System.out.println("Ingreso al processAction del Portlet Sender");
		String numero = request.getParameter(response.getNamespace() + "txtNumero");
		System.out.println("Se recibió el siguiente valor:" + numero );
		response.setEvent("requestEvent", numero);

	}

	@Override
	public void processEvent(EventRequest request, EventResponse response)
			throws PortletException, IOException {
		System.out.println("Entro al processEvent del portlet Sender");
		Event event = request.getEvent();
		if(event.getName().equals("responseEvent")){
			String responseEventData = event.getValue().toString();
			System.out.println("Portlet A obtuvo la respuesta del Portlet B:" + responseEventData);
			response.setRenderParameter("responseEventData", responseEventData);
		}
		
	}
}
