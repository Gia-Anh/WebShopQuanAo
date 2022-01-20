<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Admin</title>
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
							<div class="row">
								<div class="col-sm-12 col-xs-12">
			
									<c:if test="${isUpdate}">
										<c:url var="saveUrl" value="update" />
									</c:if>
									<c:if test="${not isUpdate}">
										<c:url var="saveUrl" value="save" />
									</c:if>
			
									<form action="${saveUrl}" method="post" enctype="multipart/form-data">
										<div class="">
											<c:if test="${isUpdate}">
												<h3>Cập nhật sản phẩm</h3>
											</c:if>
											<c:if test="${not isUpdate}">
												<h3>Thêm sản phẩm</h3>
											</c:if>
										
											<div class="col-md-6 col-sm-5 col-xs-12">
												<input type="hidden" name="id" value="${sanPham.getId()}" />
												<div class="input-box mb-20 ">
													<label class="control-label">Tên sản phẩm: </label>
													<input type="text" class="info" name="tenSanPham" value="${sanPham.tenSanPham}">
												</div>
												<div class="input-box mb-20">
													<label class="control-label">Giá: </label>
													<input type="text" class="info" name="gia" value="${sanPham.gia}">
												</div>
												<div class="input-box mb-20">
													<label class="control-label" for="loaiSanPham">Loại sản phẩm:</label>
													<select name="loaiSanPham" class="info">
														<c:forEach items="${dsLoaiSP}" var="loaiSP">
															<c:if
																test="${loaiSP.getId() == sanPham.getLoaiSanPham().getId()}">
																<option value="${loaiSP.getId()}" selected="selected">${loaiSP.getTenLoaiSP()}</option>
															</c:if>
															<c:if
																test="${loaiSP.getId() != sanPham.getLoaiSanPham().getId()}">
																<option value="${loaiSP.getId()}">${loaiSP.getTenLoaiSP()}</option>
															</c:if>
														</c:forEach>
													</select>
												</div>
												<div class="input-box mb-20">
													<label for="nhaCungCap">Nhà cung cấp:</label>
													<select name="nhaCungCap">
														<c:forEach items="${dsNhaCC}" var="ncc">
															<c:if
																test="${ncc.getId() == sanPham.getNhaCungCap().getId()}">
																<option value="${ncc.getId()}" selected="selected">${ncc.getTenNCC()}</option>
															</c:if>
															<c:if
																test="${ncc.getId() != sanPham.getNhaCungCap().getId()}">
																<option value="${ncc.getId()}">${ncc.getTenNCC()}</option>
															</c:if>
														</c:forEach>
													</select>
												</div>
												<div class="input-box mb-20">
													<label class="control-label">Mô tả</label>
													<textarea name="moTa" cols="40" rows="4">${sanPham.moTa}</textarea>
												</div>
												<div class="input-box">
													<label for="image">Image:</label> <input type="file"
														name="image" accept="image/png,image/jpeg" /><br>
												</div>								
											</div>
											<div class="col-md-1 col-sm-1 col-xs-12"></div>						
											<div class="col-md-5 col-sm-6 col-xs-12">
												<div class="input-box mb-20">
													<label class="control-label" for="">Size:</label>
													    <c:forEach items="${dsSize}" var="size" varStatus="loop">									
															<div class="row">
																<div class="col-md-2 col-sm-2 col-xs-3">
																	<c:if test="${empty size.value}">
																		<input type="checkbox" id="${loop.index+1}" name="${size.key}" value="${size.key}" >
																	</c:if>
																	<c:if test="${not empty size.value}">
																		<input type="checkbox" id="${loop.index+1}" name="${size.key}" value="${size.key}" checked>
																	</c:if>
																</div>
																<div class="col-md-1 col-sm-1 col-xs-12">
																<label style="font-size: 16px; margin-top: 13px;" for="${size.key}">${size.key}</label>
																</div>
																<div class="col-md-9 col-sm-12 col-xs-12">
																<input type="text"name="soLuong${size.key}" size="20" value="${size.value}" />
																</div>
															</div>
														</c:forEach>
												</div>					    		
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