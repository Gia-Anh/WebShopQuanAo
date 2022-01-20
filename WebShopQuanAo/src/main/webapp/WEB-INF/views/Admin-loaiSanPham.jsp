<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Loại sản phẩm</title>
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
	<div class="wrapper cart">
		<jsp:include page="_header.jsp" />

		<div class="cart-checkout-area  pt-30">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<a href="ShowFormAddCategory" class="btn btn-success" role="button">Thêm loại sản phẩm</a>
					</div>

				</div>
				<div class="row">
					<div class="product-area">
						<div class="clearfix"></div>
						<div class="col-sm-12">
							<div class="content-tab-product-category pb-70">
								<!-- cart are start-->
								<div class="cart-page-area">
									<form:form method="POST" modelAttribute="gioHang"
										action="updateCart">
										<div class="table-responsive mb-20">

											<table class="shop_table-2 cart table">
												<thead>
													<tr>
														<th class="product-thumbnail ">STT</th>
														<th class="product-quantity">Mã loại sản phẩm</th>
														<th class="product-name ">Tên thể loại</th>														
														<th class="product-quantity ">Hành động</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="loaiSanPham" items="${dsTheLoai}"
														varStatus="varStatus">
														<tr class="cart_item">
															<td>${varStatus.index + 1}</td>
															<td class="item-title">${loaiSanPham.id}</td>
															<td class="item-title">${loaiSanPham.tenLoaiSP}</td>
															<td>
																<a href="ShowFormUpdateCategory?id=${loaiSanPham.id}" class="btn btn-primary" role="button">Sửa</a>
																<a href="deleteCategory?id=${loaiSanPham.id}" class="btn btn-danger" role="button">Xoá</a>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</form:form>
								</div>
								<!-- cart are end-->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="_footer.jsp" />
	</div>

	<script type="text/javascript"
		src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/slider/jquery.nivo.slider.pack.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/slider/nivo-active.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.countdown.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/plugins.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>