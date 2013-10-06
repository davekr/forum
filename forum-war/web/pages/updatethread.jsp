<%-- 
    Document   : updatethread
    Created on : 19.4.2010, 18:14:43
    Author     : Dave
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Forum - Update thread, <h:outputText value="#{TopicBean.name}" /></title>
            <link href="${facesContext.externalContext.requestContextPath}/css/style.css"
                  rel="stylesheet" type="text/css" />
        </head>
        <body>
            <div id="wrapper">
                <jsp:include page="include/head.jsp" />
                <div id="page">
                    <div id="content">
                        <div id="welcome">
                            <h:form>
                                <h2>
                                    <h:commandLink action="home" value="Forum" /> ->
                                    <h:outputText value="#{TopicBean.name}" />
                                </h2>
                                <h3>Update thread</h3>
                                <table><tr><td>
                                            Name</td><td>
                                            <h:inputText id="subject" value="#{ThreadBean.subject}"
                                                         validator="#{ThreadBean.validateSubject}"/></td>
                                        <td><h:message for="subject" style="color:red" /></td></tr>
                                    <tr><td>Topic</td><td>
                                            <h:selectOneMenu value="#{ThreadBean.idt}">
                                                <f:selectItems
                                                    value="#{TopicBean.preparedTopics}" />
                                            </h:selectOneMenu>
                                        </td></tr><tr><td></td>
                                        <td><h:commandButton value="Update" action="#{ThreadBean.update}" />
                                        </td></tr>
                                </table>
                            </h:form>
                        </div>
                    </div>
                    <jsp:include page="menu.jsp" />
                </div>
                <jsp:include page="include/footer.html" />
            </div>
        </body>
    </html>
</f:view>
