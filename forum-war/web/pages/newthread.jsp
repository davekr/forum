<%-- 
    Document   : newthread
    Created on : 19.4.2010, 10:55:23
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
            <title>Forum - Create thread, <h:outputText value="#{TopicBean.name}" /></title>
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
                            <h3>New thread</h3>
                            <table><tr><td>
                                Thread name</td><td>
                                <h:inputText id="subject" value="#{ThreadBean.subject}"
                                             validator="#{ThreadBean.validateSubject}" /></td>
                                    <td><h:message for="subject" style="color:red" /></td>
                                </tr><tr><td>Content</td><td>
                                <h:inputTextarea rows="7" cols="60" id="content"
                                      validator="#{PostBean.validateContent}"
                                      value="#{ThreadBean.content}" /></td></tr><tr><td></td><td>
                                <h:message for="content" style="color:red" /></td></tr><tr><td></td>
                                <td><h:commandButton value="Create" action="#{ThreadBean.insert}">
                                        <f:setPropertyActionListener target="#{ThreadBean.idtopic}"
                                                                     value="#{TopicBean.topic}"/>
                                    </h:commandButton>
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
