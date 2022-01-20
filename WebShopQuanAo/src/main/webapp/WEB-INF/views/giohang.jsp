<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Giỏ Hàng</title>
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
	<script>
		function notice() {
		  alert("Cập nhật thành công!");
		}
	</script>
</head>
<body>
	<div class="wrapper cart">
		<jsp:include page="_header.jsp" />
		
        <div class="cart-checkout-area  pt-30">
            <div class="container">
                <div class="row">
                    <div class="product-area">
                        <div class="clearfix"></div>
                        <div class="col-sm-12">
                            <div class="content-tab-product-category pb-70">
                                <!-- cart are start-->
                                <div class="cart-page-area">
                                   <form:form method="POST" modelAttribute="gioHang" action="updateCart">
                                        <div class="table-responsive mb-20">
                                        
                                        <table class="shop_table-2 cart table">
                                            <thead>
                                                <tr>
                                                    <th class="product-thumbnail ">Hình ảnh</th>
                                                    <th class="product-name ">Sản phẩm</th>
                                                    <th class="product-price ">Giá</th>
                                                    <th class="product-quantity">Số lượng</th>
                                                    <th class="product-subtotal ">Tổng</th>
                                                    <th class="product-remove"></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="CTGioHang" items="${gioHang.dsCT}" varStatus="varStatus">
                                                	<tr class="cart_item">
	                                                    <td class="item-img">
	                                                    	<form:hidden path="dsCT[${varStatus.index}].sku.sku_id" />
	                                                        <a><img src="data:image/jpg;base64,${CTGioHang.sku.getBase64Image()}" width="272" height="390" class="primary-image"> </a>
	                                                    </td>
	                                                    <td class="item-title">${CTGioHang.sku.tenSanPham} ${CTGioHang.sku.size}</td>
	                                                    <td class="item-price">${CTGioHang.sku.gia}đ</td>
	                                                    <td class="item-qty">
	                                                        <div class="cart-quantity">
	                                                            <div class="product-qty">
	                                                                <div class="cart-quantity">
	                                                                    <div class="cart-plus-minus">
	                                                                        <div class="dec qtybutton">-</div>
	                                                                        <form:input path="dsCT[${varStatus.index}].soLuong" class="cart-plus-minus-box"/>
	                                                                        <div class="inc qtybutton">+</div>
	                                                                    </div>
	                                                                </div>
	                                                            </div>
	                                                        </div>
	                                                    </td>
	                                                    <td class="total-price"><strong>${CTGioHang.thanhTien}đ</strong></td>
	                                                    <td class="remove-item"><a href="deleteFromCart?id=${CTGioHang.sku.sku_id}" onclick="if (!(confirm('Bạn có chắc muốn xóa khỏi giỏ?'))) return false"><i class="fa fa-trash-o"></i></a></td>
                                                	</tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                       
                                        
                                        </div>


                                        <div class="cart-bottom-area">
                                            <div class="row">
                                                <div class="col-md-7 col-sm-7 col-xs-12">
                                                    <div class="update-coupne-area">
                                                        <div class="update-continue-btn text-right pb-20">
                                                            <a></a><input type="submit" class="btn-info btn2" value="CẬP NHẬT GIỎ HÀNG" onclick="notice()"/></a>
                                                            
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-5 col-sm-5 col-xs-12">
                                                    <div class="cart-total-area">
                                                        <div class="catagory-title cat-tit-5 mb-20 text-right">
                                                                <h3>Thông tin đơn hàng</h3> 
                                                            </div>
                                                            <div class="sub-shipping">
                                                                <p>Tạm tính <span>${tongTien} đ</span></p>
                                                                <p>Phí vận chuyển <span>30000 đ</span></p>
                                                            </div>
                                                            <div class="process-cart-total">
                                                                <p>Tổng cộng <span>${tongTien + 30000} đ</span></p>
                                                            </div>
                                                            <div class="process-checkout-btn text-right">
                                                            	<a href="${pageContext.request.contextPath}/home" class="btn-def btn2">Tiếp tục mua hàng</a>
                                                                <a class="btn-def btn2" href="checkout">Thanh toán</a>
                                                            </div>
                                                    </div>
                                              		<div style="color: red; margin: 10px 0px;">
					 									<p>${thbao}</p>
					          						</div>
                                                </div>
                                            </div>
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
	
	<script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.0.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/slider/jquery.nivo.slider.pack.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/slider/nivo-active.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.countdown.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/plugins.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>