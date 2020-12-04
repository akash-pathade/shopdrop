<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<div class="container justify-content-center">


	<div class="row">
		<div class="col-offset-4 col-md-8 justify-content-center">
			<div class="panel panel-primary">
				<!-- Heading -->
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>

				<div class="panel-body">
					<!-- Form ELements -->
					<sf:form class="form-horizontal" modelAttribute="product">


						<div class="form-group">
							<label class="control-label col-md-4" for="name">Product
								Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name"
									placeholder="Product Name" class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Brand
								Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product
								Description </label>
							<div class="col-md-8">
								<sf:textarea rows="4" path="description" id="description"
									placeholer="Enter description"></sf:textarea>

							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="unit price" class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Enter
								quantity: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="quantity" class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select
								Category: </label>
							<div class="col-md-8">
								<sf:select path="categoryId" items="${categories}"
									itemLabel="name" itemValue="id" class="form-control" />

							</div>
						</div>


						<div class="form-group">

							<div class="col-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="submit"
									class="btn btn-primary" />

								<!-- Hidden Elements -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="active" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />

							</div>
						</div>
					</sf:form>


				</div>

			</div>
		</div>
	</div>

</div>