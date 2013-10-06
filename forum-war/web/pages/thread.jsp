<%-- 
    Document   : thread
    Created on : 18.4.2010, 10:24:38
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
            <title>Forum - <h:outputText value="#{ThreadBean.name}" /></title>
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
                                <h:commandButton rendered="#{TopicBean.create}" value="New post"
                                                 action="createPost" />
                                <br /><br />
                                <h:dataTable value="#{ThreadBean.posts}" var="item" headerClass="thead"
                                             columnClasses="alt1,tfoot" footerClass="tfoot"
                                             width="100%" border="0" cellpadding="2"
                                             cellspacing="1" styleClass="tborder" rowClasses="tr2">
                                    <h:column>
                                        <table><tr><td>
                                                    <strong><h:outputText value="#{item.iduser.nick}" /></strong>
                                                </td></tr><tr><td>&nbsp;</td></tr><tr><td>Rank: </td><td>
                                                <h:outputText value="#{item.iduser.idrank.name}" />
                                                </td></tr><tr><td>Posts: </td><td>
                                                <h:outputText value="#{item.iduser.posts}" />
                                                </td></tr><tr><td>Role: </td><td>
                                                <h:outputText value="#{item.iduser.idrole.name}" />
                                                </td></tr>
                                        </table>
                                    </h:column>
                                    <h:column>
                                        <table width="100%" cellpadding="0"><tr align="top"><td>
                                            <strong><h:outputText value="#{item.subject}" /></strong>
                                                </td><td>&nbsp;</td></tr>
                                            <tr><td>
                                                    <h:outputText style="font-size: 12px" value="#{item.created}" />
                                                </td><td>&nbsp;</td>
                                            </tr>
                                            <tr><td colspan="2" height="60" style="vertical-align: text-top">
                                                   <h:outputText value="#{item.content}" /> 
                                                </td>
                                            </tr>
                                            <tr style="text-align: right"><td>&nbsp;</td><td>
                                            <h:commandLink rendered="#{TopicBean.update || sessionScope['user'].iduser == item.iduser.iduser}"
                                                           action="#{PostBean.updatePost}">
                                                <h:graphicImage alt="Update"
                                                                url="http://people.mozilla.com/~faaborg/files/20081216-platformIcons/softwareUpdate-256.png"
                                                                height="30px" width="30px" style="border:0" />
                                                <f:setPropertyActionListener target="#{PostBean.thread}"
                                                                             value="#{ThreadBean.thread}"/>
                                                <f:setPropertyActionListener target="#{PostBean.post}"
                                                                         value="#{item}"/>
                                            </h:commandLink>
                                            <h:commandLink rendered="#{TopicBean.delete}"
                                                           action="#{PostBean.delete}">
                                                <h:graphicImage alt="Delete"
                                                                url="http://corporacioncivis.org/imagenes/iconos/Delete.png"
                                                                height="30px" width="30px" style="border:0"/>
                                                <f:setPropertyActionListener target="#{PostBean.thread}"
                                                                         value="#{ThreadBean.thread}"/>
                                                <f:setPropertyActionListener target="#{PostBean.post}"
                                                                         value="#{item}"/>
                                            </h:commandLink>
                                                </td></tr>
                                        </table>
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