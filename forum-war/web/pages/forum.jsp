<%-- 
    Document   : forum
    Created on : 16.4.2010, 12:28:52
    Author     : Dave
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Forum - Place to discuss everithing that is on your mind</title>
            <link href="${facesContext.externalContext.requestContextPath}/css/style.css"
                  rel="stylesheet" type="text/css" />
        </head>
        <body>
            <div id="wrapper">
                <jsp:include page="include/head.jsp" />
                <div id="page">
                    <div id="content">
                        <div id="welcome">
                            <h1>Welcome to Forum!</h1>
                            <h:form>
                                <h:dataTable value="#{TopicBean.topics}" var="item">
                                    <h:column>
                                        <strong><h:commandLink value="#{item.name}" action="#{TopicBean.showTopic}">
                                            <f:setPropertyActionListener target="#{TopicBean.topic}"
                                                                         value="#{item}"/>
                                            </h:commandLink></strong>
                                        <br />
                                        <h:graphicImage rendered="#{item.private1}" alt="Locked" url="http://image.warforum.cz/images/lock.gif"/>
                                        <h:outputText value="#{item.description}"/>
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
