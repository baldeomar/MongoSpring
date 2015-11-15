<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="datatable.page.title"/></title>
    <link type="text/css" rel="stylesheet" href="resources/js/handsontable/dist/handsontable.full.css">
    <script type="text/javascript" src="resources/js/handsontable/dist/handsontable.full.js">
    </script>
</head>
<body>
    <div id="example" class="dataTable"></div>
    <script>
        var data = [
                    ['', 'Kia', 'Nissan', 'Toyota', 'Honda', 'Mazda', 'Ford'],
                    ['2012', 10, 11, 12, 13, 15, 16],
                    ['2013', 10, 11, 12, 13, 15, 16],
                    ['2014', 10, 11, 12, 13, 15, 16],
                    ['2015', 10, 11, 12, 13, 15, 16],
                    ['2016', 10, 11, 12, 13, 15, 16]
                ],
                container = document.getElementById("example"), hot;
        hot = new Handsontable(container, {
            data: data,
            startRows: 5,
            startCols: 5
        });
    </script>
</body>
</html>
