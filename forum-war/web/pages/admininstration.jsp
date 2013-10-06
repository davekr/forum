<%-- 
    Document   : admininstration
    Created on : 20.4.2010, 11:10:40
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
                                <h2><h:commandLink action="#{SettingsBean.clear}" value="User Profile" />
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administrate topics
                                </h2>
                                <table>
                                    <h:dataTable value="#{TopicBean.topics}" var="item">
                                        <h:column>
                                            <h:outputText value="#{item.name}" />
                                        </h:column>
                                        <h:column>
                                            <h:selectOneRadio
                                                value="#{SettingsBean.privat}">
                                                <f:selectItem
                                                    itemValue="1" itemLabel="Private"/>
                                                <f:selectItem
                                                    itemValue="0" itemLabel="Public"/>
                                            </h:selectOneRadio>
                                        </h:column>
                                        <h:column>
                                            <h:commandButton action="#{SettingsBean.updateTopic}"
                                                             value="Set">
                                                <f:setPropertyActionListener target="#{SettingsBean.topic}"
                                                                         value="#{item}"/>
                                            </h:commandButton>
                                        </h:column>
                                    </h:dataTable>
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
