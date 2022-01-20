<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<header class="header-area header-wrapper">
	<div class="header-top-bar black-bg clearfix">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="login-register-area">
						
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<a>Xin chào </a>
								<a href="${pageContext.request.contextPath}/user">${pageContext.request.userPrincipal.name}</a>
								<a href="${pageContext.request.contextPath}/logout">| Đăng xuất</a>
							</c:if>
							
							<c:if test="${pageContext.request.userPrincipal.name == null}">
								<a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
							</c:if>
						
					</div>
				</div>
				<div class="col-md-6 col-sm-6 hidden-xs"></div>
				<div class="col-md-3 col-sm-3 col-xs-6">
					<div class="cart-currency-area login-register-area text-right">
						<div class="header-cart">
							<div class="cart-icon">
								<a href="${pageContext.request.contextPath}/cart">Giỏ hàng<i class="zmdi zmdi-shopping-cart"></i></a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="sticky-header" class="header-middle-area">
		<div class="container">
			<div class="full-width-mega-dropdown">
				<div class="row">
					<div class="col-md-2 col-sm-2">
						<div class="logo ptb-20">
							<a href="/WebShopQuanAo/"> <img src="<c:url value="/resources/images/logo/logo.png" />"alt="main logo"></a>
						</div>
					</div>
					<div class="col-md-7 col-sm-10 hidden-xs">
						<nav id="primary-menu">
							<ul class="main-menu">
								<li class="current"><a class="active" href="/WebShopQuanAo/">Trang
										Chủ</a></li>
								<li class="mega-parent pos-rltv"><a>Đồ nam</a>
									<div class="mega-menu-area mma-700">
										<ul class="single-mega-item">
											<li class="menu-title uppercase">Áo</li>
											<li><a href="${pageContext.request.contextPath}/list?category=1&page=1">Áo thun nam</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=2&page=1">Áo sơ mi nam</a></li>
										</ul>
										<ul class="single-mega-item">
											<li class="menu-title uppercase">Quần</li>
											<li><a href="${pageContext.request.contextPath}/list?category=3&page=1">Quần jean nam</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=4&page=1">Quần tây</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=5&page=1">Quần short</a></li>
										</ul>
										<ul class="single-mega-item">
											<li class="menu-title uppercase">Áo khoác</li>
											<li><a href="${pageContext.request.contextPath}/list?category=6&page=1">Áo khoác nam</a></li>
										</ul>
									</div></li>
								<li class="mega-parent pos-rltv"><a>Đồ nữ</a>
									<div class="mega-menu-area mma-700">
										<ul class="single-mega-item">
											<li class="menu-title uppercase">Áo</li>
											<li><a href="${pageContext.request.contextPath}/list?category=7&page=1">Áo thun nữ</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=8&page=1">Áo sơ mi nữ</a></li>
										</ul>
										<ul class="single-mega-item">
											<li class="menu-title uppercase">Quần</li>
											<li><a href="${pageContext.request.contextPath}/list?category=9&page=1">Quần short</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=10&page=1">Quần jean nữ</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=11&page=1">Quần jogger</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=12&page=1">Chân váy</a></li>
										</ul>
										<ul class="single-mega-item">
											<li class="menu-title uppercase">Áo khoác</li>
											<li><a href="${pageContext.request.contextPath}/list?category=13&page=1">Áo khoác nữ</a></li>
										</ul>
									</div></li>
								<li class="mega-parent"><a>Phụ kiện</a>
									<div class="mega-menu-area mma-700">
										<ul class="single-mega-item">
											<li class="menu-title uppercase">Ba lô - Tùi xách</li>
											<li><a href="${pageContext.request.contextPath}/list?category=14&page=1">Ba lô</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=15&page=1">Túi xách</a></li>
										</ul>
										<ul class="single-mega-item">
											<li class="menu-title uppercase">Nón</li>
											<li><a href="${pageContext.request.contextPath}/list?category=16&page=1">Nón phớt</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=17&page=1">Nón lưỡi trai</a></li>
											<li><a href="${pageContext.request.contextPath}/list?category=18&page=1">Nón bucket</a></li>
										</ul>
										<ul class="single-mega-item">
											<li class="menu-title uppercase">Ví</li>
											<li><a href="${pageContext.request.contextPath}/list?category=19&page=1">Ví</a></li>
										</ul>
									</div></li>
								<security:authorize  access="hasRole('ROLE_ADMIN')">
							         <li><a href="${pageContext.request.contextPath}/admin">Quản lý</a></li>
							   </security:authorize>
								
							</ul>
						</nav>
					</div>
					<div class="col-md-3 hidden-sm hidden-xs">
						<div class="search-box global-table">
							<div class="global-row">
								<div class="global-cell">
									<form action="search?key=${key}&page=${page}">
										<div class="input-box">
											<input type="hidden" name="page" value="1">
											<input class="single-input" placeholder="Tìm kiếm sản phẩm" type="text" name="key">
											<button class="src-btn">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>