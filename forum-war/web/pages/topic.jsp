<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : topic
    Created on : 17.4.2010, 10:43:21
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
            <title>Forum - <h:outputText value="#{TopicBean.name}" /></title>
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
                                    <h:commandLink action="home" value="Forum" /> -> <h:outputText value="#{TopicBean.name}" />
                                </h2>
                                <h:commandButton rendered="#{TopicBean.create}" value="New thread"
                                                 action="createThread" />
                                <br /><br />
                                <h:dataTable value="#{TopicBean.threads}" var="item" headerClass="thead"
                                             columnClasses="alt1,alt2,alt1,alt2,alt1,alt2" footerClass="tfoot"
                                             width="100%" border="0" cellpadding="6"
                                             cellspacing="1" styleClass="tborder" rowClasses="tr">
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Thread"/>
                                        </f:facet>
                                        <h:commandLink value="#{item.name}" action="#{ThreadBean.showThread}">
                                            <f:setPropertyActionListener target="#{ThreadBean.thread}"
                                                                         value="#{item}"/>
                                        </h:commandLink>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Created by"/>
                                        </f:facet>
                                        <h:outputText value="#{item.iduser.nick}" />
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Viewed"/>
                                        </f:facet>
                                        <h:outputText value="#{item.viewed}"/>
                                    </h:column>
                                    <h:column>
                                        <f:facet name="header">
                                            <h:outputText value="Posts"/>
                                        </f:facet>
                                        <h:outputText value="#{item.posts}"/>
                                    </h:column>
                                    <h:column rendered="#{TopicBean.update}">
                                        <f:facet name="header">
                                            <h:outputText value="Update"/>
                                        </f:facet>
                                        <h:commandLink action="#{ThreadBean.updateThread}">
                                            <h:graphicImage alt="Update"
                                            url="http://people.mozilla.com/~faaborg/files/20081216-platformIcons/softwareUpdate-256.png"
                                            height="30px" width="30px" style="border:0" />
                                            <f:setPropertyActionListener target="#{ThreadBean.thread}"
                                                                         value="#{item}"/>
                                            <f:setPropertyActionListener target="#{ThreadBean.idtopic}"
                                                                         value="#{TopicBean.topic}"/>
                                        </h:commandLink>
                                    </h:column>
                                    <h:column rendered="#{TopicBean.delete}">
                                        <f:facet name="header">
                                            <h:outputText value="Delete"/>
                                        </f:facet>
                                        <h:commandLink action="#{ThreadBean.delete}">
                                            <h:graphicImage alt="Delete"
                                            url="http://corporacioncivis.org/imagenes/iconos/Delete.png"
                                            height="30px" width="30px" style="border:0" />
                                            <f:setPropertyActionListener target="#{ThreadBean.thread}"
                                                                         value="#{item}"/>
                                            <f:setPropertyActionListener target="#{ThreadBean.idtopic}"
                                                                         value="#{TopicBean.topic}"/>
                                        </h:commandLink>
                                    </h:column>
                                </h:dataTable>
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
