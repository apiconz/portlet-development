package pe.com.apiconz.example.portlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;

import pe.com.apiconz.example.dummies.Cliente;
import pe.com.apiconz.example.dummies.Procesador;

public class ActionsPortlet extends GenericPortlet {
	private static final String PARAM_ACCION = "accion";
	private static final String JSP_ACTIONS = "/WEB-INF/jsp/actions.jsp";
	private static final String JSP_ANSWERS = "/WEB-INF/jsp/actions_answer.jsp";
	private static final String ACCION_NOMBRE = "nombre";
	private static final String ACCION_PALABRA = "palabra";

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		String accion = request.getParameter(PARAM_ACCION);

		System.out.println("accion=" + accion);

		if (StringUtils.equals(accion, ACCION_NOMBRE)) {
			String nombre = request.getParameter(response.getNamespace()
					+ "txtNombre");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1>" + "Nunca pasó por el accion" + "</h1>");
			out.print("El nombre ingresado fue " + nombre + "<br /><br />");
			out.print("<a href=\"");
			out.print(response.createRenderURL());
			out.print("\">Regresar</a>");
		} else if (StringUtils.equals(accion, ACCION_PALABRA)) {

			if (request.getAttribute("cliente") == null) {
				System.out.println("no hay cliente");
			}

			getPortletContext().getRequestDispatcher(JSP_ANSWERS).include(
					request, response);
		} else {
			getPortletContext().getRequestDispatcher(JSP_ACTIONS).include(
					request, response);
		}

		System.out.println("Entro al doView del Portlet Actions");

	}

	/**
	 * Una función para obtener el nombre de todos los atributos contenidos en
	 * el objeto request
	 * 
	 * @param request
	 */
	private void getListOfAttributeNames(PortletRequest request) {
		Enumeration e = request.getAttributeNames();

		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			System.out.println("renderRequest-" + key);
		}
	}

	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {

		String accion = request.getParameter(response.getNamespace()
				+ PARAM_ACCION);

		System.out.println("accion=" + accion);

		if (StringUtils.equals(accion, ACCION_PALABRA)) {

			String palabra = request.getParameter(response.getNamespace()
					+ "txtPalabra");

			Cliente cliente = Procesador.getClientePorPalabra(palabra);

			// Creamos una sesión
			PortletSession portletSession;

			if (request.isRequestedSessionIdValid()) {
				portletSession = request.getPortletSession(false);
			} else {
				portletSession = request.getPortletSession(true);
			}

			portletSession.setAttribute("cliente", cliente,
					PortletSession.PORTLET_SCOPE);

			response.setRenderParameter(PARAM_ACCION, accion);
			System.out.println("Se envía: " + accion);

		} else {
			System.out.println("Se fue por el else del processAction");
			getPortletContext().getRequestDispatcher(JSP_ACTIONS).include(
					request, response);
		}

	}
}
