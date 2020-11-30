<div class="container">
	<div class="row">

		<!-- Including the sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Code to list products -->

		<div class="col-md-9">
			<!-- Adding Breadcrumb Comnponent -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts== true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot }/home">Home</a></li>
							<li class="active">/ All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts== true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot }/home">Home</a></li>
							<li class="active">/ Category</li>
							<li class="active">/ ${category.name}</li>
						</ol>
					</c:if>
				</div>
			</div>


			<!-- Adding jquery Datatable -->

			<div class="row">
				<div class="col-xs-12">

					<table class="table table-striped table-bordered"
						id="productListTable">

						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>

							</tr>
						</thead>
					</table>


				</div>

			</div>
		</div>

	</div>