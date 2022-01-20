<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Đơn hàng</title>
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
				<div align="left">				
					<h5>Họ tên khách hàng: ${user.tenNguoiDung}</h5>
					<h5>Số điện thoại: ${user.soDienThoai}</h5>
					<h5>Địa chỉ: ${user.diaChi}</h4>
					<br>
					<h5>Mã đơn hàng: ${donHang.id}</h4>
					<h5>Ngày đặt: ${ngayDat}</h4>					
				</div>
				<div class="row">
					<div class="product-area">
						<div class="clearfix"></div>
						<div class="col-sm-12">
							<div class="content-tab-product-category pb-70">
								<!-- cart are start-->
								<div class="cart-page-area">
										<div class="table-responsive mb-20">
											<table class="shop_table-2 cart table">
												<caption>
													<h4>Chi tiết đơn hàng</h4>
												</caption>
												<thead>
													<tr>
														<th>STT</th>
														<th>Mã sản phẩm</th>
														<th>Tên sản phẩm</th>
														<th>Size</th>
														<th>Số lượng</th>
														<th>Đơn giá</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="ctDonHang" items="${dsCT_DonHang}"
														varStatus="varStatus">
														<tr class="cart_item">
															<td>${varStatus.index + 1}</td>
															<td>${ctDonHang.sanPhamSKU.sanPham.id}</td>
															<td>${ctDonHang.sanPhamSKU.sanPham.tenSanPham}</td>
															<td>${ctDonHang.sanPhamSKU.sizeSP.tenSize}</td>
															<td>${ctDonHang.soLuong}</td>
															<td>${ctDonHang.donGia}đ</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>	
								</div>
							</div>
						</div>
						<div class="col-md-7 col-sm-5 col-xs-12"></div>
						<div class="col-md-5 col-sm-5 col-xs-12">
                        <div class="cart-total-area">
                                <div class="sub-shipping">
                                    <p>Tạm tính <span>${donHang.tinhDonGia()} đ</span></p>
                                    <p>Phí vận chuyển <span>30000 đ</span></p>
                                </div>
                                <div class="process-cart-total">
                                    <p>Tổng cộng <span>${donHang.tinhDonGia() + 30000} đ</span></p>
                                </div>
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