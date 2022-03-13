<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="sidenav col-lg-2 d-flex flex-column h-100">
	<h4 id="logo">
		SportyShoes.com
	</h4>

	<c:choose>
		<c:when test="${currentUser.type == 0 }">
			<nav class="nav flex-column">
			<a class="nav-link"
				href="${pageContext.request.contextPath}/homepage/products"><i
				class="fa fa-home fa-lg"></i> Home</a> <a class="nav-link active"
				href="${pageContext.request.contextPath}/homepage/mycart"> <i
				class="fa fa-shopping-cart fa-lg"></i> My Cart
			</a> <a class="nav-link"
				href="${pageContext.request.contextPath}/user/myaccount"><i
				class="fa fa-user fa-lg"></i> My Account</a> <a class="nav-link"
				href="${pageContext.request.contextPath}/login"><i
				class="fa fa-sign-out fa-lg"></i> Log Out</a>

		</nav>
		</c:when>

		<c:otherwise>
			<nav  class="nav flex-column">
			 <a class="nav-link active"
				href="${pageContext.request.contextPath}/admin/products"> <i 
				class="fa fa-shopping-cart fa-lg"></i> <h style="font-size: 15px;">Manage Products</h>
			</a> 
			<a class="nav-link"
				href="${pageContext.request.contextPath}/admin/manageUsers"><i
				class="fa fa-user fa-lg"></i>  <h style="font-size: 15px;">Manage Users</h></a>
			<a class="nav-link"
				href="${pageContext.request.contextPath}/admin/manageOrders"><i
				class="fa fa-shopping-bag fa-lg"></i>  <h style="font-size: 15px;">Manage Orders</h></a> 
			<a class="nav-link"
				href="${pageContext.request.contextPath}/admin/addProdcut"><i
				class="fa fa-plus fa-lg"></i>  <h style="font-size: 15px;"> Add Product</h></a>
				
				<a class="nav-link"
				href="${pageContext.request.contextPath}/login"><i
				class="fa fa-sign-out fa-lg"></i> <h style="font-size: 15px;"> Log Out</h></a>

		</nav>

		</c:otherwise>
		
		</c:choose>

		
</div>

