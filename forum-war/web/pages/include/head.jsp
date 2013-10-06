<%-- 
    Document   : head
    Created on : 18.4.2010, 18:53:08
    Author     : Dave
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<div id="header">
    <div id="logo">
        <h1><h:form>
                <h:commandLink action="home" value="Forum" />
            </h:form></h1>
        <h2>The best place to share your opinion</h2>
    </div>
    <div id="menu">
        <ul>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </div>
</div>
