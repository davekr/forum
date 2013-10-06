<%-- 
    Document   : settings
    Created on : 20.4.2010, 11:14:35
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
            <title>Forum - My admin</title>
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
                                <h2>User Profile&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <h:commandLink action="administrate" value="Administrate topics"
                                                   rendered="#{SettingsBean.administrateTopic}"/>
                                </h2>
                            </h:form>
                            <h:form>
                                <table>
                                    <tr><td>
                                            Password*</td><td>
                                            <h:inputSecret value="#{SettingsBean.pass}" id="pass"
                                                           validator="#{SettingsBean.validatePass}"/>
                                        </td><td>
                                            <h:message style="color: red" for="pass"/>
                                        </td></tr><tr><td>
                                            Password again*</td><td>
                                            <h:inputSecret value="#{SettingsBean.pass2}"
                                                           validator="#{SettingsBean.validatePass2}"
                                                           id="pass2"/>
                                        </td><td>
                                            <h:message style="color: red" for="pass2"/>
                                        </td></tr><tr><td>
                                            Home</td><td>
                                            <h:inputText value="#{SettingsBean.home}" /></td></tr><tr><td>
                                            Email</td><td>
                                            <h:inputText value="#{SettingsBean.email}" /></td></tr><tr><td>
                                        </td><td>
                                            <h:commandButton action="#{SettingsBean.save}" value="Save" />
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
