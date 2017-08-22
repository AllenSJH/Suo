<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/8/22
  Time: 上午9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>留言板</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.2.1.js" type="text/javascript"></script>
</head>
<body>

<div class="container">
    <div class="input-group">
        <input id="content" type="text" class="form-control" placeholder="请输入...">
        <span class="input-group-btn">
        <button id="btn" class="btn btn-default" type="button">发布</button>
      </span>
    </div>
    <table class="table table-bordered" id="tab">

    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

</div>

</body>

<script>


    function addNewTR(id,content,upCount,downCount,how) {
        var tdleft = $("<td></td>").html("<p>"+content+"</p>")
        var tdright = $("<td></td>")

        tdright.append("顶:")
        $("<a href='#'></a>").html(upCount).appendTo(tdright)
        tdright.append("踩:")
        $("<a href='#'></a>").html(downCount).appendTo(tdright)

        var trOb = $("<tr></tr>").append(tdleft).append(tdright).attr("id","tr"+id)

        if(how == true){
            $("#tab").prepend(trOb)
        } else {
            $("#tab").append(trOb)
        }

    }

    function getAllMessage() {
        $.ajax({
            url:"findAll",
            success:function (result) {
                for(var i=0;i<result.length;i++){
                    var msg = result[i];
                    addNewTR(msg.id,msg.content,msg.up,msg.down,0)
                }
            }
        })

    }
    getAllMessage()

</script>

</html>
