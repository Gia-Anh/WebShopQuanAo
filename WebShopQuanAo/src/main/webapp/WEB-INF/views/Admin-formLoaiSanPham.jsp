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

		<div class="account-area ptb-80">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-xs-12">

						<form action="saveCategory" method="post">
							<div class="login-reg">
								<c:if test="${isUpdate}">
									<h3>Cập nhật</h3>
								</c:if>
								<c:if test="${not isUpdate}">
									<h3>Thêm</h3>
								</c:if>

								<input type="hidden" name="id" value="${loaiSanPham.id}" />

								<div class="input-box mb-20 ">
									<label class="control-label">Tên loại sản phẩm</label>
									<input type="text" class="info" name="tenLoaiSP" value="${loaiSanPham.tenLoaiSP}">
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