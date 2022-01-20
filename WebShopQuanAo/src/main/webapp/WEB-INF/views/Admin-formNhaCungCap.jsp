<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Nhà Cung Cấp</title>
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
	<div class="wrapper shop">
		<jsp:include page="_header.jsp" />
		
        <div class="shop-main-area ptb-70">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-4 col-xs-12">
                        <div class="row">
                            <div class="shop-sidebar">
                              	
                                <aside class="single-aside catagories-aside">
                                    <div class="heading-title aside-title pos-rltv">
                                        <h5 class="uppercase">Quảm lý</h5> 
                                    </div>
                                    <div id="cat-treeview" class="product-cat">
                                        <ul>
                                            <li class="closed"><a href="${pageContext.request.contextPath}/admin/product">Quản lý sản phẩm</a></li>
                                            <li class="closed"><a href="${pageContext.request.contextPath}/admin/user">Quản lý người dùng</a></li>
                                            <li class="closed"><a href="${pageContext.request.contextPath}/admin/order">Quản lý đơn hàng</a></li>
                                            <li class="closed"><a href="${pageContext.request.contextPath}/admin/supplier">Quản lý nhà cung cấp</a></li>
                                        </ul>
                                    </div>
                                </aside>
                               
                            </div>
                        </div>
                    </div>
                   
                    <div class="col-md-9 col-sm-8 col-xs-12">
                        <div class="account-area">
						<div class="container">
							<div class="row">
								<div class="col-sm-1 col-xs-6"></div>
								<div class="col-sm-6 col-xs-12">
									<form action="save" method="post">
										<div class="login-reg">
											<c:if test="${isUpdate}">
												<h3>Cập nhật nhà cung cấp</h3>
											</c:if>
											<c:if test="${not isUpdate}">
												<h3>Thêm nhà cung cấp</h3>
											</c:if>
			
											<input type="hidden" name="id" value="${nhaCungCap.id}" />
			
											<div class="input-box mb-20 ">
												<label class="control-label">Tên nhà cung cấp</label>
												<input type="text" class="info" name="tenNCC" value="${nhaCungCap.tenNCC}">
											</div>
											
											<div class="input-box mb-20">
												<label class="control-label">Địa chỉ</label>
												<textarea name="diaChi" cols="40" rows="4">${nhaCungCap.diaChi}</textarea>
											</div>
											
										</div>
			
										<div class="frm-action">
											<input type="submit" class="btn2 btn-success" value="Lưu" />
										</div>
									</form>
								</div>
			
							</div>
						</div>
					</div>
                        
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