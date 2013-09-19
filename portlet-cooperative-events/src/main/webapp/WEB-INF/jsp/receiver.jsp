<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>

<%@ page import="javax.portlet.*"%>
<portlet:defineObjects />
<%
   //Portlet namespace
   String portletNS = renderResponse.getNamespace(); 
%>
<h1>Hola Receiver</h1>
Este portlet tiene el siguiente namespace: <%=portletNS %>

<h4>El siguiente dato en el request event fue enviado al portlet Receiver: <%=request.getParameter("requestEventData") %></h4>
