<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="./images/waitRoom.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
    <style ></style>
    <script>
        function ajaxList(name) {
		$.ajax({
			type : 'post',
			url : "<c:url value='/getMemberList.do'/>",
			dataType:'JSON',
			data : {'name': name},
			success : function(result){
				$("#rakingshow").html("");
				var member = result;
				var html ="";
				member.forEach(function(index){
					console.log(index);
					
					html += "<tr><td>"+index["userName"]+"</td>"
					html += "<td>"+index.rank+"</td></tr>"
					
				})
				$("#members").html(html);
				console.log(html);
			}
			
		});
	}
    $(function(){

        $("#searchInputbox > input").keyup(function(){
        const name = $(this).val();
        ajaxList(name);
    })

    $("#searchInputbox > button").click(function(){
        const name = $("#searchInputbox > input").val();
        ajaxList(name);
    })

    })
   
    </script>
</head>
<body>
    <div id="container">
        <!-- s -->
        <div id="userbox">
            <div id="userWhiteBox">
                <div id="userInfo">
                    <div id="namebox" class="textCenter">GUEST1105</div>
                    <div id="record">
                        <div id="win" class="score textCenter">43</div>
                        <div id="lose" class="score textCenter">12</div>
                    </div>
                    <div id="rank">
                        <img src="./images/rank.png">
                        <div id="rankNum">354ë±</div>
                    </div>
                </div>
                <div id="search">
                    <div class="fonts">
                    ë­í¹ ì°¾ê¸°
                    </div>
                    <div id="searchInputbox">
                        <input type="text" name="user_name" class="inputBox">
                        <button style="display: inline-block;" class="inputB">ë²í¼</button>
                    </div>
                    
                    
                </div>
                <div id="ranking">
                    <table id="rakingshow">
                        
                    </table>
                </div>
            </div>
        </div>
        <div id="roombox">
            <div id="roomboxWrap">
                <div id="roomlist">
                    <!-- ë°© ëìì¸(ë°ë³µ) -->
                    <div id="room">
                        <div id="roomWrap">
                            <img src="./images/notstart.png">
                            <div id="roomInfo">
                                <div id="roomname">ì´ë³´ë§</div>
                                <div id="roomInfoBottom">
                                    <div id="rules">33ê¸ì§ / 44ê¸ì§</div>
                                    <div id="roomUserNumber">2 / 2</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /ë°© ëìì¸(ë°ë³µ) -->
                </div>
                <div id="roombuttons">
                    <div id="roomMakeButton" class="textCenter">ë°© ë§ë¤ê¸°</div>
                    <div id="roomEnterButton" class="textCenter">ë¹ ë¥¸ ìì</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>