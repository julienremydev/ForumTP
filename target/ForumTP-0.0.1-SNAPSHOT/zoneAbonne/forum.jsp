<%@ page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Forum</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://bootsnipp.com/dist/bootsnipp.min.css?ver=7d23ff901039aef6293954d33d23c066">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/include/style_forum.css"/>" />
</head>
<body style="font-family: Verdana">
<form id="deco" method="get" action="<c:url value="/deco"/>">
<button class="col-lg-3 col-md-3 col-sm-3" name="deco" type="submit" >Déconnexion</button>
</form>
	  <div id="container" class="container">
        <div class="row pad-top pad-bottom">


            <div class=" col-lg-6 col-md-6 col-sm-6">
                <div id="chat-box-div" class="chat-box-div">
                    <div class="chat-box-head">CHAT</div>
                    <div id="chat-box-main" class="panel-body chat-box-main">
                    <c:forEach items="${listeMessages}" var="listeMessages">
                    <div class="chat-box-left">
                    <c:out value="${listeMessages.getCorps()} " />
                    </div>
                    <div class="chat-box-name-left">
                    ${listeMessages.getAbonne().getLogin()}
                    </div>
                    <hr class="hr-clas" />
                    </c:forEach>
                        
                    </div>
                    <div class="chat-box-footer">
                        <div class="input-group">
                            <input id="message" type="text" class="form-control" placeholder="Enter Text Here...">
                            <span class="input-group-btn">
                                <button id="send_message" class="btn btn-info" type="button">SEND</button>
                            </span>
                        </div>
                    </div>

                </div>

            </div>
            
            <!-- 
            <div class="col-lg-3 col-md-3 col-sm-3">
                <div class="chat-box-online-div">
                    <div class="chat-box-online-head">
                        ONLINE USERS (120)
                    </div>
                    <div class="panel-body chat-box-online">

                        <div class="chat-box-online-left">
                             -  Justine Goliyad
                            <br />
                            ( <small>Active from 3 hours</small> )
                        </div>
                        <hr class="hr-clas-low" />

                        <div class="chat-box-online-right">
                             -  Romin Royeelin
                            <br />
                            ( <small>Active from 10 hours</small> )
                        </div>
                        <hr class="hr-clas-low" />
                        <div class="chat-box-online-left">
                             -  Justine Goliyad
                            <br />
                            ( <small>Active from 3 hours</small> )
                        </div>
                        <hr class="hr-clas-low" />

                        <div class="chat-box-online-right">
                            -  Romin Royeelin
                            <br />
                            ( <small>Active from 10 hours</small> )
                        </div>
                        <hr class="hr-clas-low" />
                        <div class="chat-box-online-left">
                             -  Justine Goliyad
                            <br />
                            ( <small>Active from 3 hours</small> )
                        </div>
                        <hr class="hr-clas-low" />

                        <div class="chat-box-online-right">
                            -  Romin Royeelin
                            <br />
                            ( <small>Active from 10 hours</small> )
                        </div>
                        <hr class="hr-clas-low" />
                        <div class="chat-box-online-left">
                             -  Justine Goliyad
                            <br />
                            ( <small>Active from 3 hours</small> )
                        </div>
                        <hr class="hr-clas-low" />

                        <div class="chat-box-online-right">
                             -  Romin Royeelin
                            <br />
                            ( <small>Active from 10 hours</small> )
                        </div>
                        <hr class="hr-clas-low" />
                    </div>

                </div>

            </div>
            <div class="col-lg-3 col-md-3 col-sm-3">
                <div class="chat-box-new-div">
                    <div class="chat-box-new-head">
                        NEW CHATS (4)
                    </div>
                    <div class="panel-body chat-box-new">

                        (@Justine)
                           
                            <hr class="hr-clas-low" />


                        (@Romin)
                              
                            <hr class="hr-clas-low" />
                        (@Justine)
                           
                            <hr class="hr-clas-low" />

(@Romin)
                              
                            <hr class="hr-clas-low" />
                    </div>

                </div>

            </div>--> 
            
            
            
            
            
            
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="<c:url value="/include/forum.js"/>"></script>
</body>

</html>
