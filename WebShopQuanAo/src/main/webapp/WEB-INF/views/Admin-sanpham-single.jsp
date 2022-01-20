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
								<p>NHÀ CUNG CẤP: ${nhaCungCap}</p>
								<p>LOẠI SẢN PHẨM: ${loaiSP}</p>
								<div class="table-responsive">
									<table class="shop_table-2 cart table">
										<thead>
											<tr>
												<th class="">STT</th>
												<th class="">Size</th>
												<th class="">Số lượng</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="size" items="${dsSize}" varStatus="varStatus">
												<tr class="cart_item">
													<td>${varStatus.index + 1}</td>
													<td class="">${size.key}</td>
													<td class="">${size.value}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								
								<div class="social-icon socile-icon-style-1">
									<br><br>
									<a href="edit?id=${sanPham.id}" class="btn btn-success" role="button">Cập nhật</a>
									<a href="${pageContext.request.contextPath}/admin/product" class="btn btn-info" role="button">Quay lại</a>
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