<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="sidebar">
    <ul>
        <li id="submenu">
            <h2>About you</h2>
            <c:choose>
                <c:when test='${sessionScope.user==null}'>
                    <h:form>
                        <ul>
                            <li>
                                <h:commandLink action="register">Register</h:commandLink>
                            </li>
                            <li>
                                <label style="font-size: 11px;">Login&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </label>
                                <h:inputText style="font-size: 11px;" value="#{AuthBean.login}"
                                             id="navbar_username" size="10" onfocus="this.value = '';"/>
                            </li><li>
                                <label style="font-size: 11px;">Password</label>
                                <h:inputSecret style="font-size: 11px;" id="pass" size="10"
                                               value="#{AuthBean.password}" />
                                <h:commandButton style="font-size: 11px;" action="#{AuthBean.log}" value="OK" />
                            </li><li>
                                <h:outputText value="#{AuthBean.error}" style="color: red" /></li>
                        </ul>
                    </h:form>
                </c:when>
                <c:otherwise>
                    <ul>
                        <li>
                            <h:form>
                                <h:commandLink action="#{AuthBean.logout}" value="Logout" />
                            </h:form>
                        </li>
                        <li>
                            You are logged as: <b>${sessionScope.user.nick}</b
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </li>
        <li id="submenu">
            <h2>Options</h2>
            <ul>
                <li><a href="#">Find</a></li>
                <li>
                    <h:form>
                        <h:commandLink action="#{SettingsBean.setUser}" value="My admin" />
                    </h:form>
                </li>
            </ul>
        </li>
    </ul>
</div>
<div style="clear: both; height: 1px"></div>