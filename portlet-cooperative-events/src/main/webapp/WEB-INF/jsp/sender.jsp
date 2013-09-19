<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<%@ page import="javax.portlet.*"%>
<portlet:defineObjects />
<%
	//Portlet namespace
	String portletNS = renderResponse.getNamespace();
%>
<h1>Hola Sender</h1>

<fmt:setBundle basename="example" />

<span>Este portlet tiene como namespace el siguiente valor: 
	<%=portletNS%></span>

<form action="<portlet:actionURL/>" method="post">
	<label><fmt:message key="example.form.numero" /></label> <input
		type="text" name="<%=portletNS%>txtNumero" /> <input type="submit"
		value="<fmt:message key="example.form.btnenviar" />">

</form>

<h4>El siguiente dato fue recibido por el Portlet Sender: <%=request.getParameter("responseEventData") %></h4>