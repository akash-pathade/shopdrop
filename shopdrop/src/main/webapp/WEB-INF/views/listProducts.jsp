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
					<script>
						window.categoryId='';
					</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot }/home">Home</a></li>
							<li class="active">/ All Products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts== true}">
					<script>
						window.categoryId='${category.id}';
					</script>
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
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty</th>
								<th></th>
							</tr>
						</thead>
						
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Qty</th>
								<th></th>
							</tr>
						</tfoot>
					</table>


				</div>

			</div>
		</div>

	</div>