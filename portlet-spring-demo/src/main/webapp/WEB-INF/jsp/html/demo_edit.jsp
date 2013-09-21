<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects/>

<h3>Pantalla en modo EDIT</h3>
<form id="${renderResponse.namespace}formularioEdit" action='<portlet:renderURL portletMode="view"/>'>
 <input type="submit" value="Regresar">
</form>