<%--
  Created by IntelliJ IDEA.
  User: asoni
  Date: 3-6-16
  Time: 01:10
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<table>
    <tbody >

    <tr class="prop">
        <td >
            <b>Total Open Issues</b>
        </td>
        <td valign="top">
            <g:textField name="abc" value="$openIssues" />
        </td>
    </tr>
    <tr class="prop">
        <td >
            <b>Open Issues in Last 24 hrs</b>
        </td>
        <td valign="top">
            <g:textField name="abc" value="$lastDay" />
        </td>
    </tr>
    <tr class="prop">
        <td >
            <b>Open Issues in Last Week</b>
        </td>
        <td valign="top">
            <g:textField name="abc" value="$lastWeek" />
        </td>
    </tr>
    <tr class="prop">
        <td >
            <b>Open Issues before 7 days</b>
        </td>
        <td valign="top">
            <g:textField name="abc" value="$earlier" />
        </td>
    </tr>
</body>
</html>