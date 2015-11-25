<!DOCTYPE html>
<%@ page contentType="text/html; ISO-8859-1" language="java"%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="resources/css/jquery.dataTables.min.css"/>
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/jquery.dataTables.min.js"></script>
        <script>
            $(function(){
                $('#datatable').dataTable({
                    "aaData":[
                            ["Site du zero", "www.siteduzero.com", "8"],
                            ["tutorials point", "www.tutorialspoint.com", "9"],
                            ["stack over flow", "www.stackoverflow.com", "11"]
                    ],
                    "aoColumnDefs":[{
                        "sTitle":"Nom du site",
                        "aTargets":["site_name"]
                    },{
                        "sTitle":"Lien du site",
                        "aTargets":["lien"]
                    },{
                        "aTargets":[1],
                        "bSortable":false,
                        "mRender":function(url){
                            return '<a href="'+ url +'">'+ url +'</a>';
                        }
                    }]
                });
            })
        </script>
    </head>
    <body>
        <div id="mainContent">
            <table id="datatable">
                <thead>
                    <tr>
                        <th class="site_name">site</th><th class="lien">lien</th><th>note (/10)</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </body>
</html>