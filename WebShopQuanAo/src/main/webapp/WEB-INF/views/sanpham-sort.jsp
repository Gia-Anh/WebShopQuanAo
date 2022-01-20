<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Shop Quần Áo</title>
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
		
		<!--shop main area are start-->
        <div class="shop-main-area ptb-70">
            <div class="container">
                <div class="row">
                    <!--shop sidebar start-->
                    <div class="col-md-3 col-sm-4 col-xs-12">
                        <div class="row">
                            <div class="shop-sidebar">
                              	
                                <aside class="single-aside search-aside search-box">
                                    <form action="search?key=${key}&page=${page}">
                                        <div class="input-box">
                                        	<input type="hidden" name="page" value="1">
                                            <input class="single-input" placeholder="Tìm kiếm.." type="text" name="key" value="${keyname}">
                                            <button class="src-btn sb-2"><i class="fa fa-search"></i></button>
                                        </div>
                                    </form>
                                 </aside>
                                
                                <aside class="single-aside catagories-aside">
                                    <div class="heading-title aside-title pos-rltv">
                                        <h5 class="uppercase">categories</h5> 
                                    </div>
                                    <div id="cat-treeview" class="product-cat">
                                        <ul>
                                            <li class="closed"><a href="#">Áo (04)</a>
                                                <ul>
                                                    <li><a href="list?category=1">Áo thun nam</a></li>
                                                    <li><a href="list?category=2">Áo sơ mi nam</a></li>
                                                    <li><a href="list?category=7">Áo thun nữ</a></li>
                                                    <li><a href="list?category=8">Áo sơ mi nữ</a></li>
                                                </ul>
                                             </li>
                                            <li class="closed"><a href="#">Quần (07)</a>
                                                <ul>
                                                    <li><a href="list?category=3">Quần jean nam</a></li>
                                                    <li><a href="list?category=4">Quần tây</a></li>
                                                    <li><a href="list?category=5">Quần short nam</a></li>
                                                    <li><a href="list?category=9">Quần short nữ</a></li>
                                                    <li><a href="list?category=10">Quần jean nữ</a></li>
                                                    <li><a href="list?category=11">Quần jogger</a></li>
                                                    <li><a href="list?category=12">Chân váy</a></li>
                                                </ul>
                                            </li>
                                            <li class="closed"><a href="#">Áo khoác (02)</a>
                                                <ul>
                                                    <li><a href="list?category=6">Áo khoác nam</a></li>
                                                    <li><a href="list?category=13">Áo khoác nữ</a></li>
                                                </ul>
                                            </li>
                                            <li class="closed"><a href="#">Phụ kiện (06)</a>
                                                <ul>
                                                    <li><a href="list?category=14">Ba lô</a></li>
                                                    <li><a href="list?category=15">Túi xách</a></li>
                                                    <li><a href="list?category=16">Nón phớt</a></li>
                                                    <li><a href="list?category=17">Nón lưỡi trai</a></li>
                                                    <li><a href="list?category=18">Nón bucket</a></li>
                                                    <li><a href="list?category=19">Ví</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                </aside>
                               
                                
                            </div>
                        </div>
                    </div>
                    <!--shop sidebar end-->
                    
                    <!--main-shop-product start-->
                    <div class="col-md-9 col-sm-8 col-xs-12">
                        <div class="shop-wraper">
                          <div class="col-xs-12">
                               <div class="shop-area-top">
                                  <div class="row">
                                       <div class="col-lg-6 col-md-9 col-sm-9 col-xs-12">
                                       		<c:if test="${empty keyname}">
			                              		<c:url var="sortUrl" value="sort?type=${type}&page=${page}" />
			                              	</c:if>
			                              	<c:if test="${not empty keyname}">
			                              		<c:url var="sortUrl" value="sort?type=${type}&key=${keyname}&page=${page}" />
			                              	</c:if>
                                      		<form action="${sortUrl}">
                                      			<input type="hidden" name="key" value="${keyname}">
                                      			<input type="hidden" name="page" value="1">
                                      			<div class="sort product-type">
                                      			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	                                                <label>Sắp xếp theo </label>
	                                                <select id="input-sort" name="type">
	                                                    <option value="0" selected>Mặc định</option>
	                                                    <option value="1">Tên (A - Z)</option>
	                                                    <option value="2">Tên (Z - A)</option>
	                                                    <option value="3">Giá (Tăng dần)</option>
	                                                    <option value="4">Giá (Giảm dần)</option>
	                                                </select>
	                                                
                                            	</div>
                                            	<button class="src-btn sb-2"><i class="fa fa-filter"></i></button>
                                      		</form>
                                        </div>

                                   </div>
                               </div>
                           </div>
                       <div class="clearfix"></div>
                       <div class="shop-total-product-area clearfix mt-35">
                        <!-- Tab panes -->
                        <div class="tab-content">
                            <!--tab grid are start-->
                            <div role="tabpanel" class="tab-pane fade in active" id="grid">
                                <div class="total-shop-product-grid">   
                                	<c:forEach var="sanpham" items="${dssp}" >
					               		<c:url var="deleteUrl" value="/SanPham/delete">
									    	<c:param name="id" value="${sanpham.getId()}" />
									    </c:url>
									    <c:url var="editUrl" value="/SanPham/edit">
									    	<c:param name="id" value="${sanpham.getId()}" />
									    </c:url>
									    
									    
									    <div class="col-md-4 col-sm-6 item">
                                        <!-- single product start-->
                                        <div class="single-product">
                                            <div class="product-img">
                                                    <a href="view?id=${sanpham.getId()}"> <img src="data:image/jpg;base64,${sanpham.getBase64Image()}" width="272" height="390" class="primary-image"/></a>
                                            </div>
                                            <div class="product-text">
                                                <div class="prodcut-name"> <a href="view?id=${sanpham.getId()}"><c:out value="${sanpham.getTenSanPham()}" /></a> </div>
                                                <div class="prodcut-ratting-price">
                                                    <div class="prodcut-price">
                                                        <div class="new-price"><c:out value="${sanpham.getGia()}đ" /></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- single product end-->
                                    	</div> 
									    
									 </c:forEach>                       
                                </div>
                            </div>
                            <!--shop grid are end-->
                            
                            
                            <!--pagination start-->
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="pagination-btn text-center">
                                    <ul class="page-numbers">
                                    	<c:if test="${page==1}">
                                    		<c:if test="${totalPage==1 || totalPage==0}">
		                                        <li><span class="page-numbers current">1</span></li>
	                                    	</c:if>
	                                    	<c:if test="${totalPage!=1 && totalPage!=0}">
		                                        <li><span class="page-numbers current">1</span></li>
		                                        <li><a href="sort?type=${type}&key=${keyname}&page=2" class="page-numbers">2</a></li>
		                                        <li><a class="page-numbers">...</a></li>
		                                        <li><a href="sort?type=${type}&key=${keyname}&page=${totalPage}" class="page-numbers">${totalPage}</a></li>
		                                        <li><a href="sort?type=${type}&key=${keyname}&page=${totalPage}" class="next page-numbers">&#8608;</i></a></li>
	                                    	</c:if>
	                                        
                                    	</c:if>
                                    	<c:if test="${page!=1 && page!=totalPage}">
                                    		<li><a href="sort?type=${type}&key=${keyname}&page=1" class="next page-numbers">&#8606;</a></li>
                                    		<li><a href="sort?type=${type}&key=${keyname}&page=${page-1}" class="page-numbers">${page-1}</a></li>
	                                        <li><span class="page-numbers current">${page}</span></li>
	                                        <li><a href="sort?type=${type}&key=${keyname}&page=${page+1}" class="page-numbers">${page+1}</a></li>
	                                        <li><a href="sort?type=${type}&key=${keyname}&page=${totalPage}" class="next page-numbers">&#8608;</i></a></li>
                                    	</c:if>
                                       	<c:if test="${page==totalPage}">
                                       		<c:if test="${page!=1}">
		                                        <li><a href="sort?type=${type}&key=${keyname}&page=1" class="next page-numbers">&#8606;</a></li>
		                                        <li><a href="sort?type=${type}&key=${keyname}&page=1" class="page-numbers">1</a></li>
		                                        <li><a class="page-numbers">...</a></li>
		                                        <li><a href="sort?type=${type}&key=${keyname}&page=${totalPage-1}" class="page-numbers">${totalPage-1}</a></li>
		                                        <li><span class="page-numbers current">${totalPage}</span></li>
	                                    	</c:if>
                                       		
                                    	</c:if>
                                    </ul>
                                </div>
                            </div>
                            <!--pagination end-->
                            </div>
                       </div>
                    </div>
                    </div>
                    <!--main-shop-product end-->
                </div>
            </div>
        </div>
        <!--shop main area are end-->
		
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