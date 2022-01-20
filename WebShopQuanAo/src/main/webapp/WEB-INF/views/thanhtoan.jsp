<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Thanh toán</title>
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
		
		<div class="cart-checkout-area  pt-30">
			<div class="container">
				<div class="checkout-area">
                  <div class="row">
                      <div class="col-md-12 col-sm-12 col-xs-12">
                          <div class="row">
                          	<form action="saveOrder" method="post">
                              <div class="col-md-6 col-xs-12">
                                  <div class="billing-details">
                                      <div class="contact-text right-side">
                                            <h2>Thông tin khách hàng</h2>
                                  
                                    <div class="row">
                                    	 <input type="hidden" name="kh_id" class="info" value="${khachHang.kh_id}">
                                         <div class="col-md-12 col-sm-6 col-xs-12">
                                              <div class="input-box mb-20">
                                                  <label>Họ và tên<em>*</em></label>
                                                  <input type="text" name="tenKhachHang" class="info" value="${khachHang.tenKhachHang}" required="required">
                                              </div>
                                         </div>
                                          <div class="col-md-12 col-sm-12 col-xs-12">
                                              <div class="input-box mb-20">
                                                  <label>Địa chỉ <em>*</em></label>
                                                  <input type="text" name="diaChi" class="info" value="${khachHang.diaChi}" required="required"> 
                                              </div>
                                          </div>

                                          <div class="col-md-6 col-sm-6 col-xs-12">
                                              <div class="input-box mb-20">
                                                  <label>Email</label>
                                                  <input type="email" name="email" class="info" value="${khachHang.email}" readonly="readonly">
                                              </div>
                                          </div>
                                           <div class="col-md-6 col-sm-6 col-xs-12">
                                          <div class="input-box mb-20">
                                              <label>Số điện thoại<em>*</em></label>
                                              <input type="text" name="soDienThoai" class="info" value="${khachHang.soDienThoai}" required="required">
                                          </div>
                                          </div>
                                      </div>
                                  
                                  </div>
                              </div>
                              </div>
                              <div class="col-md-6 col-xs-12">
                                  <div class="checkout-payment-area">
                                      <div class="checkout-total mt20">
                                         <h5>Thông tin giỏ hàng</h5>
                                     
                                     <div class="table-responsive">
                                          <table class="checkout-area table">
                                         <thead>
                                          <tr class="cart_item check-heading">
                                              <td class="ctg-type"> Sản phẩm</td>
                                              <td class="cgt-des"> Giá </td>
                                          </tr>
                                          </thead>
                                          <tbody>
                                             
                                              <c:forEach var="CTGioHang" items="${gioHang.dsCT}">
                                              	  <tr class="cart_item check-item prd-name">
	                                                  <td class="ctg-type">${CTGioHang.sku.tenSanPham} ${CTGioHang.sku.size} × <span>${CTGioHang.soLuong}</span></td>
	                                                  <td class="cgt-des"> ${CTGioHang.thanhTien}</td>
	                                              </tr>
	                                          </c:forEach>  
	                                              <tr class="cart_item">
	                                                  <td class="ctg-type"> Tạm tính </td>
	                                                  <td class="cgt-des">${tongTien} đ</td>
	                                              </tr>
	                                              <tr class="cart_item">
	                                                  <td class="ctg-type">Phí vận chuyển</td>
	                                                  <td class="cgt-des">30000 đ</td>
	                                              </tr>
	                                              <tr class="cart_item">
	                                                  <td class="ctg-type crt-total"> Tổng cộng </td>
	                                                  <td class="cgt-des prc-total">${tongTien + 30000} đ</td>
	                                              </tr>
                                              
                                          </tbody>
                                      </table>
                                     </div>
                                 
                                  </div>
                                      <div class="payment-section mt-20 clearfix">
                                          <div class="pay-toggle">
                                              <input type="submit" class="btn2 btn-info" value="Đặt hàng" style="width:500px" />
                                          </div>

                                      </div>
                                  </div>
                              </div>
                              </form>
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