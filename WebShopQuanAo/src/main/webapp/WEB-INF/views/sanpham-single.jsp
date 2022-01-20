<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>${sanPham.getTenSanPham()}</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />"
	type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/core.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/shortcode/shortcodes.css" />"
	type="text/css">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"
	type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/responsive.css" />" type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/custom.css" />" type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/color/skin-default.css" />"
	type="text/css">

<script type="text/javascript"
	src="<c:url value="/resources/js/vendor/modernizr-2.8.3.min.js" />"></script>
</head>
<body>
	<div class="wrapper shop">
		<jsp:include page="_header.jsp" />

		<div class="single-protfolio-area ptb-70">
			<div class="container">
				<div class="row">
					<div class="col-md-5 col-sm-12 col-xs-12">
						<div class="portfolio-thumbnil-area">

							<div class="tab-content active-portfolio-area pos-rltv">

								<div role="tabpanel" class="tab-pane active" id="view11">
									<div class="product-img">
										<img src="data:image/jpg;base64,${sanPham.getBase64Image()}" width="300" height="450"/ class="primary-image">
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="col-md-7 col-sm-12 col-xs-12">
						<div class="single-product-description">
						<form action="addToCart?id=${sanPham.getId()}" method="post">
						
							<div class="sp-top-des">
								<h3>${sanPham.getTenSanPham()}</h3>
								<div class="prodcut-ratting-price">
									<div class="prodcut-price">
										<div class="new-price">${sanPham.getGia()}đ</div>
									</div>
								</div>
							</div>

							<div class="sp-des">
								<p>${sanPham.getMoTa()}</p>
							</div>
							<div class="sp-bottom-des">
								<div class="single-product-option">
									<div class="sort product-type">
										<label>Size: </label> 
										<select id="input-sort-size" name="sizeid">
											<c:forEach items="${dsSize}" var="size">
												<option value="${size.key}">${size.value}</option>
										    </c:forEach>
										</select>
									</div>
								</div>
								<div class="quantity-area">
									<label>Số lượng :</label>
									<div class="cart-quantity">
										
											<div class="product-qty">
												<div class="cart-quantity">
													<div class="cart-plus-minus">
														<div class="dec qtybutton">-</div>
														<input type="text" value="1" name="soLuong"
															class="cart-plus-minus-box">
														<div class="inc qtybutton">+</div>
													</div>
												</div>
											</div>
										
									</div>
								</div>
								<div class="social-icon socile-icon-style-1">
									<input type="submit" value="Thêm vào giỏ" class="btn2 btn-info">
								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- ======================================================================================================================== -->

		<div class="new-arrival-area ptb-70">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 text-center">
						<div
							class="heading-title heading-style pos-rltv mb-50 text-center">
							<h5 class="uppercase">Sản phẩm cùng danh mục</h5>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="total-new-arrival new-arrival-slider-active carsoule-btn">
						<c:forEach var="sanpham" items="${dsDTO}" >
							<div class="col-md-3">
							<!-- single product start-->
							<div class="single-product">
								<div class="product-img">
									<div class="single-prodcut-img ">
										<a href="view?id=${sanpham.getId()}"> <img src="data:image/jpg;base64,${sanpham.getBase64Image()}" width="272" height="390" class="primary-image"></a>
									</div>
								</div>
								<div class="product-text">
									<div class="prodcut-name">
										<a href="view?id=${sanpham.getId()}">${sanpham.getTenSanPham()}</a>
									</div>
									<div class="prodcut-ratting-price">
										<div class="prodcut-price">
											<div class="new-price">${sanpham.getGia()}đ</div>
										</div>
									</div>
								</div>
							</div>
							<!-- single product end-->
						</div>
						</c:forEach>
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