<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	function goRoom(roomNum) {
		//location.href="<c:url value='/enterRoom.do'/>?num="+roomNum;
		location.href = "/omoomo/enterRoom.do?num=" + roomNum;
	}

	function openPopup() {
		window.open("createRoom.do", "방 만들기",
				"width=400, height=550, top=200, left=650");
	}
	
	$(function(){
		$(".roomWrap").on("click", function(){
			var owner = $(this).find("#owner").val();
			console.log(owner);
			
			$.ajax({
				type:"POST",
				url:"roomInfo",
				data:{
					"owner":owner
				},
				success: function(res){
					console.log(res);
				},
				error:function(error){
					console.log(error);
				}
			});
		});
	});
	function joinRoom(){
		console.log("#owner".value());
	}
</script>

<style>
        *{
			margin: 0;
			padding: 0;
			box-sizing: border-box;
		}
        .textCenter{
            display: flex;
            justify-content: center;
            align-items: center;
        }
		/* 전체 페이지 */
		#container{
			display: flex;
			flex-direction: row;
			width: 100%;
			min-width: 1800px;
			height: 100vh;
			min-height: 900px;
            background-image: url('./images/waitingroomimage.jpg');
            background-repeat: no-repeat;
            background-size: cover;
            background-position: 0 -500px;
		}
        /** 유저 정보 및 랭킹 **/
        #userbox{
            width: 20%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #userWhiteBox{
            width: 90%;
            height: 95%;
            background-color: rgba(255, 255, 255, .7);
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
            border-radius: 30px;
        }
        /*** 유저 박스 ***/
        #userInfo{
            width: 90%;
            height: 30%;
            background-color: #C3A69A;
            border: 3px solid #573A2E;
            box-shadow: inset 8px 8px 10px rgba(255, 255, 255, .25), inset -8px -8px 10px rgba(0, 0, 0, .25);
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            padding: 20px;
        }
        #namebox{
            width: 100%;
            height: 30%;
            border: 3px solid #573A2E;
            border-radius: 10px;
            background-color: #f0f0f0;
            box-shadow: inset 8px 8px 10px rgba(0, 0, 0, .25), inset -8px -8px 10px rgba(255, 255, 255, .25);
            font-size: 36px;
            font-weight: bold;
        }
        #record{
            width: 100%;
            height: 30%;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            font-size: 36px;
            font-weight: bold;
        }
        .score{
            width: 45%;
            height: 100%;
            border: 3px solid #573A2E;
            border-radius: 10px;
            background-color: #f0f0f0;
            box-shadow: inset 8px 8px 10px rgba(0, 0, 0, .25), inset -8px -8px 10px rgba(255, 255, 255, .25);
        }
        #rank{
            display: flex;
            flex-direction: row;
            justify-content: center;
        }
        #rankNum{
            margin-left: 20px;
            font-size: 50px;
            color: #fff;
            font-weight:900;
            -webkit-text-stroke: 2px #573A2E;
        }
        /*** 랭킹 박스 ***/
        #ranking{
            width: 90%;
            height: 60%;
            background-color: #C3A69A;
            border: 3px solid #573A2E;
            box-shadow: inset 8px 8px 10px rgba(255, 255, 255, .25), inset -8px -8px 10px rgba(0, 0, 0, .25);
            border-radius: 10px;
        }
        /** 방 정보 **/
        #roombox{
            width: 80%;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        #roomboxWrap{
            width: 90%;
            height: 95%;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            align-items: center;
        }
        /*** 방 목록 ***/
        #roomlist{
            width: 100%;
            height: 80%;
            background-color: rgba(255, 255, 255, .7);
            box-shadow: inset 8px 8px 10px rgba(255, 255, 255, .25), inset -8px -8px 10px rgba(0, 0, 0, .25);
            border-radius: 10px;
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            padding: 20px;
        }
        /**** 방 디자인 ****/
        #room{
            width: 45%;
            height: 20%;
            border: 3px solid #573A2E;
            border-radius: 20px;
            background-color: #916D5E;
            box-shadow: inset 8px 8px 10px rgba(255, 255, 255, .25), inset -8px -8px 10px rgba(0, 0, 0, .25);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        .roomWrap{
            width: 95%;
            height: 90%;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
        }
        #roomInfo{
            width: 420px;
            height: 100%;
            border-radius: 10px;
            border: 3px solid #573A2E;
        }
        #roomname{
            width: 100%;
            height: 65%;
            background-color: #EACABD;
            padding: 15px;
            display: flex;
            flex-direction: row;
            justify-content: start;
            align-items: center;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
        #roomInfoBottom{
            width: 100%;
            height: 35%;
            background-color: #573A2E;
            color: #fff;
            display: flex;
            padding: 0 10px;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
        }
        #roomUserNumber{
            margin: 10px 0;
            width: 15%;
            text-align: center;
            background-color: #EACABD;
            color: #000;
            font-weight: bold;
            border-radius: 10px;
        }
        /*** 버튼 박스 ***/
        #roombuttons{
            width: 100%;
            height: 20%;
            display: flex;
            flex-direction: row;
            justify-content: end;
            align-items: end;
        }
        #roomMakeButton{
            width: 240px;
            height: 80px;
            background-color: #79655C;
            border: 3px solid #573A2E;
            box-shadow: inset 8px 8px 10px rgba(255, 255, 255, .25), inset -8px -8px 10px rgba(0, 0, 0, .25);
            border-radius: 20px;
            font-size: 36px;
            font-weight: 900;
            color: #fff;
            -webkit-text-stroke: 2px #573A2E;
            cursor: pointer;
        }
        #roomMakeButton:hover{
            background-color: #5a483f;
        }
        #roomEnterButton{
            width: 380px;
            height: 120px;
            background-color: #C3A69A;
            border: 3px solid #573A2E;
            box-shadow: inset 8px 8px 10px rgba(255, 255, 255, .25), inset -8px -8px 10px rgba(0, 0, 0, .25);
            border-radius: 20px;
            margin-left: 20px;
            font-size: 48px;
            font-weight: 900;
            color: #fff;
            -webkit-text-stroke: 2px #573A2E;
            cursor: pointer;
        }
        #roomEnterButton:hover{
            background-color: #a08478;
        }
</style>

</script>
</head>
<body>
${roomSet2}
	<div id="container">
		<!-- side -->
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
						<div id="rankNum">354등</div>
					</div>
				</div>
				<div id="ranking">
					${hi}				
				</div>
			</div>
		</div>
		<!-- side -->
		<!-- room -->
		<div id="roombox">
			<div id="roomboxWrap">
				<div id="roomlist">
					<!-- 방 디자인(반복) -->
					<c:forEach var="room" items="${roomSet2}">
						<div id="room">
							<div class="roomWrap">
								<input type="hidden" id="owner" value="${room.owner }">
								<img src="./images/notstart.png">
								<div id="roomInfo">
									<div id="roomname">${room.name }</div>
									<div id="roomInfoBottom">
										<!-- 모드 값에 따라 모드 출력 -->
										<c:if test="${ room.mode =='classic'}">
											<div id="rules">기본 오목</div>
										</c:if>
										<c:if test="${ room.mode =='33'}">
											<div id="rules">33 금지</div>
										</c:if>
										<c:if test="${ room.mode =='44'}">
											<div id="rules">44 금지</div>
										</c:if>
										<!-- 모드 값에 따라 모드 출력 -->

										<!-- 인원수 출력 -->
										<div id="roomUserNumber">2 / 2</div>
										<!-- 인원수 출력 -->
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<!-- /방 디자인(반복) -->
				</div>
				<div id="roombuttons">
					<div id="roomMakeButton" onclick="openPopup();" class="textCenter">방 만들기</div>
					<div id="roomEnterButton" class="textCenter">빠른 시작</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>