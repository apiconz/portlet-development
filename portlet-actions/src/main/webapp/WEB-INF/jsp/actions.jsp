<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ page import="javax.portlet.*"%>
<portlet:defineObjects />
<%
	//Portlet namespace
	String portletNS = renderResponse.getNamespace();
%>
<fmt:setBundle basename="example" />

<h1>
	<fmt:message key="example.titulo.dos" />
</h1>

<fmt:message key="example.info.namespace" /><%=portletNS%>


<h2>
	<fmt:message key="example.form.toview" />
</h2>
<form action="<%=renderResponse.createRenderURL()%>" method="post">
	<input type="hidden" name="<%=portletNS%>accion" value="nombre" /> <label><fmt:message
			key="example.form.name" /></label> <input type="text"
		name="<%=portletNS%>txtNombre" /> <input type="submit" value="<fmt:message key="example.form.btnenviar" />">

</form>

<h2>
	<fmt:message key="example.form.toprocessaction" />
</h2>
<form action="<%=renderResponse.createActionURL()%>" method="post">
	<input type="hidden" name="<%=portletNS%>accion" value="palabra" /> <label><fmt:message
			key="example.form.word" /></label> <input type="text"
		name="<%=portletNS%>txtPalabra" /> <input type="submit" value="<fmt:message key="example.form.btnenviar" />">
	
</form>


