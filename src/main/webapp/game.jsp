<%--
  Created by IntelliJ IDEA.
  User: davic
  Date: 2022-02-25
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="gmt" uri="/WEB-INF/tldl/gametags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <p>
            <gmt:createform action="shot" gameBean="${gameSessionBean}"/>
        </p>
    </div>
    <div>
        <p>
            <gmt:creategamestate gameBean="${gameSessionBean}"/>
        </p>    
    </div>
</body>
</html>
