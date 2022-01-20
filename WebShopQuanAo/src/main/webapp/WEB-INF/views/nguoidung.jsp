<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Khách Hàng</title>
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
		
		<div class="idea-area  ptb-80">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-4 col-xs-12">
                        <div class="idea-tab-menu">
                            <ul class="nav idea-tab" role="tablist">
                                <li role="presentation" class="active"><a href="#thongTinCaNhan" aria-controls="thongTinCaNhan" role="tab" data-toggle="tab">Thông tin cá nhân</a></li>
                                <li role="presentation"><a href="#donHang" aria-controls="donHang" role="tab" data-toggle="tab">Đơn hàng của bạn</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-9 col-sm-8 col-xs-12">
                        <div class="idea-tab-content">
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane fade in active" id="thongTinCaNhan">
                                    <form action="updateUser" method="POST">
                                       <div class="col-md-6 col-sm-6 col-xs-12">
                                            <div class="input-box mb-20">
                                                <label>Họ và tên</label>
                                                <input type="text" name="tenKhachHang" class="info" value="${user.tenNguoiDung}">
                                            </div>
                                       </div>
                                       <div class="col-md-6 col-sm-6 col-xs-12">
                                        <div class="input-box mb-20">
                                            <label>Địa chỉ</label>
                                            <input type="text" name="diaChi" class="info" value="${user.diaChi}">
                                        </div>
                                        </div>

                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <div class="input-box mb-20">
                                                <label>Email</label>
                                                <input type="email" name="email" class="info" value="${user.email}" readonly>
                                            </div>
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                            <div class="input-box mb-20">
                                                <label>Số điện thoại </label>
                                                <input type="text" name="soDienThoai" class="info" value="${user.soDienThoai}">
                                            </div>
                                        </div>

                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <div class="input-box mb-20">
                                                <label>Mật khẩu mới</label>
                                                <input type="password" name="matKhauMoi" class="info" >
                                            </div>
                                            </div>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                            <div class="input-box mb-20">
                                                <label>Xác nhận mật khẩu</label>
                                                <input type="password" name="xacNhanMK" class="info" >
                                            </div>
                                        </div>

                                        <div class="col-md-6 col-sm-4 col-xs-12 text-right">
                                            <input type="submit" class="btn2 btn-info" value="Lưu" />
                                        </div>
                                        <div class="col-md-6 col-sm-4 col-xs-12">
                                           	<c:if test="${error == true }">
                                            	<div style="color: red; margin: 10px 0px;">
                                            		Mật khẩu không khớp !!
                                           		</div>
                                           	</c:if>
                                           	<c:if test="${error == false }">
                                           		<div style="color: green; margin: 10px 0px;">
                                           			Cập nhật thành công !!
                                           		</div>
                                           	</c:if>
                                        </div>
                                    </form>
                                </div>
                                
                                <div role="tabpanel" class="tab-pane fade in" id="donHang">
                                    <div class="table-responsive">
                                        <table class="shop_table-2 cart table">
                                            <thead>
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Mã đơn hàng</th>
                                                    <th>Ngày đặt</th>
                                                    <th>Tổng tiền</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="donHang" items="${dsDonHang}" varStatus="varStatus">
                                                	<tr class="cart_item">
	                                                    <td>${varStatus.index + 1}</td>
	                                                    <td>${donHang.id}</td>
	                                                    <td>${donHang.ngayDat}</td>
	                                                    <td><strong>${donHang.tinhDonGia()}</strong></td>
	                                                    <td><a href="order?id=${donHang.id}" data-tooltip="Chi tiết" ><i class="fa fa-eye"></i></a></td>
                                                	</tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
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