<div class="container">
	<!-- This row is for breadcrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home"> Home </a></li>
				<li><a href="${contextRoot}/show/all/products"> /Products </a></li>
				<li class="active"><a
					href="${contextRoot}/show/${product.id}/product">/
						${product.name}</a></li>
			</ol>
		</div>
	</div>

	<!-- This row is to show product details -->
	<div class="row">

		<!-- For product Image -->
		<div class="col-xs-12 col-md-4">

			<img src="${images}/${product.code}.jpg" class="img img-responsive singleProdImg" />
			<hr />
		</div>

		<!-- For remaining product description -->
		<div class="col-xs-12 col-md-8">
			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				Price: <strong> &#8377; ${product.unitPrice} /- </strong>
			</h4>
			<hr />

			<h6>Hurry up only ${product.quantity} items left</h6>

			<a href="${contextRoot}/cart/add/${product.id}/product"
				class="btn btn-success">Add to cart</a> <a
				href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>

		</div>

	</div>

</div>