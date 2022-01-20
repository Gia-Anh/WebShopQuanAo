<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Đăng Nhập</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />" type="text/css">
	<link rel="stylesheet" href="<c:url value="/resources/css/core.css" />">
	<link rel="stylesheet" href="<c:url value="/resources/css/shortcode/shortcodes.css" />" type="text/css">
	<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" type="text/css">
	<link rel="stylesheet" href="<c:url value="/resources/css/responsive.css" />" type="text/css">
	<link rel="stylesheet" href="<c:url value="/resources/css/custom.css" />" type="text/css">
	<link rel="stylesheet" href="<c:url value="/resources/css/color/skin-default.css" />" type="text/css">

	<script type="text/javascript" src="<c:url value="/resources/js/vendor/modernizr-2.8.3.min.js" />"></script>
</head>
<body>
	<div class="wrapper cart">
		<jsp:include page="_header.jsp" />
	
		<div class="account-area ptb-80">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-12">
                    	<c:if test="${param.error == 'true'}">
				           <div style="color: red; margin: 10px 0px;">
				 
				               Login Failed!!!<br /> Reason :
				               ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				 
				           </div>
				       </c:if>
                        <form action="${pageContext.request.contextPath}/j_spring_security_check" method="post" class="login-side">
                            <div class="login-reg">
                                <h3>Đăng nhập</h3>
                                <div class="input-box mb-20">
                                    <label class="control-label">Email</label>
                                    <input type="email" name="email" class="info" value="${taiKhoan.email}">
                                </div>
                                <div class="input-box">
                                    <label class="control-label">Mật khẩu</label>
                                    <input type="password" name="matKhau" class="info" value="${taiKhoan.matKhau}">
                                </div>
                            </div>
                            <div class="frm-action">
                                <input type="submit" class="btn2 btn-success" value="Đăng nhập" />
                            </div>
                        </form>
                        <span class="error-message">${error }</span>
                    </div>
                    <div class="col-sm-6 col-xs-12 lr2">
                        <form action="register" method="post">
                            <div class="login-reg">
                                <h3>Đăng ký</h3>
                                <div class="input-box mb-20">
                                    <label class="control-label">Họ và tên</label>
                                    <input type="text" class="info" name="tenKhachHangDK">
                                </div>
                                <div class="input-box mb-20">
                                    <label class="control-label">Email</label>
                                    <input type="email" class="info" name="emailDK">
                                </div>
                                <div class="input-box">
                                    <label class="control-label">Mật khẩu</label>
                                    <input type="password" class="info" name="matKhauDK">
                                </div>
                   				<div style="color: red; margin: 10px 0px;">
									${thBao}
								</div>
                            </div>
                            <div class="frm-action">
                                <input type="submit" class="btn2 btn-info" value="Đăng ký" />
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
		
		<jsp:include page="_footer.jsp" />
	</div>
	
	<script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/slider/jquery.nivo.slider.pack.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/slider/nivo-active.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.countdown.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/plugins.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>