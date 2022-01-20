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
                        <div class="cart-checkout-area">
						
							
								<div class="product-area">
									<div class="clearfix"></div>
									
										<div class="content-tab-product-category pb-70">
											
											<div class="cart-page-area">
												
													<div class="table-responsive mb-20">
														<table class="shop_table-2 cart table">
															<thead>
																<tr>
																	<th class="">STT</th>
																	<th class="">Người đặt</th>
																	<th class="">Ngày đặt</th>
																	<th class="">Số điện thoại</th>
																	<th class="">Địa chỉ</th>
																	<th class="">Đơn giá</th>												
																	<th class="">Hành động</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach var="donHang" items="${dsDonHang}"
																	varStatus="varStatus">
																	<tr class="cart_item">
																		<td>${varStatus.index + 1}</td>
																		<td class="item-title">${donHang.nguoiDung.tenNguoiDung}</td>
																		<td class="item-title">${donHang.ngayDat}</td>
																		<td class="item-title">${donHang.nguoiDung.soDienThoai}</td>
																		<td class="item-title">${donHang.nguoiDung.diaChi}</td>
																		<td class="item-price">${donHang.tinhDonGia()+30000}đ</td>
																		<td>
																			<a href="order/view?id=${donHang.id}" class="btn btn-info" role="button">Chi tiết</a>																														
																		</td>
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