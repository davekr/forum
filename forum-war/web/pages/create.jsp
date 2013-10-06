<%-- 
    Document   : create
    Created on : 18.4.2010, 11:00:03
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
            <title>Forum - Create post, <h:outputText value="#{ThreadBean.name}" /></title>
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
                                <a href="topic.jsp">
                                    <h:outputText value="#{TopicBean.name}" />
                                </a> -> <h:outputText value="#{ThreadBean.name}" />
                            </h2>
                            <h3>New post</h3>
                            <table><tr><td>
                                Subject</td><td>
                                <h:inputText id="subject" value="#{PostBean.subject}" /></td>
                                </tr><tr><td>Content</td><td>
                                <h:inputTextarea rows="7" cols="60" id="content"
                                      validator="#{PostBean.validateContent}"
                                      value="#{PostBean.content}" /></td></tr><tr><td></td><td>
                                <h:message for="content" style="color:red" /></td></tr><tr><td></td>
                                <td><h:commandButton value="Create" action="#{PostBean.insert}">
                                    <f:setPropertyActionListener target="#{PostBean.thread}"
                                                                 value="#{ThreadBean.thread}"/>
                                </h:commandButton></td></tr>
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
