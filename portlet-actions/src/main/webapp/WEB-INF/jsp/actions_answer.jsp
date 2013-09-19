<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ page import="otraprueba.dummies.Cliente"%>
<%@ page import="javax.portlet.PortletSession"%>
<%@ page session="true"%>
<portlet:defineObjects />
<%
	Cliente cliente = (Cliente) renderRequest.getPortletSession()
			.getAttribute("cliente", PortletSession.PORTLET_SCOPE);
	pageContext.setAttribute("cliente", cliente);
%>
<fmt:setBundle basename="example" />

<h1><fmt:message key="example.titulo.dos" /></h1>
<br />
<br />
<fmt:message key="example.nombre" /><%=cliente.getNombre()%><br/>
<fmt:message key="example.palabraelegida"/><%=cliente.getPalabraElegida() %><br />
<fmt:message key="example.numero" /><%=cliente.getNumero() %>

<br />
<a href="<%=renderResponse.createRenderURL()%>"><fmt:message key="example.form.lnkregresar"/></a>
