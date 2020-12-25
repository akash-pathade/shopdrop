$(function() {
	//Solving the active menu problem
	switch (menu) {
		case 'About Us':
			$('#about').addClass('active');
			break;

		case 'Contact Us':
			$('#contact').addClass('active');
			break;

		case 'All Products':
			$('#listProducts').addClass('active');
			break;
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break;

		default:
			$('#home').addClass('active');
			$('#a_' + menu).addClass('active');
			break;

	}

	//Code for Jquery Data Table
	var $table = $('#productListTable');
	if ($table.length) {

		/*Preparing Json Url*/
		jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
		}


		$table.DataTable({
			lengthMenu: [[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'All Records']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},

			columns: [

				{
					data: 'code',
					mRender: function(data, type, row) {

						return '<img src="' + window.contextRoot + '/resources/images/' + data + '.jpg"  class="dataTableImg"/>';
					}
				},

				{ data: 'name' },   //These are json obj keys

				{ data: 'brand' },
				{
					data: 'unitPrice',
					mRender: function(data, type, row) {
						return '&#8377 ' + data;
					}
				},

				{
					data: 'quantity',
					mRender: function(data, type, row) {
						if (data < 1) {
							return '<span style="color:red">Out of Stock!</span>';
						}
						return data;
					}
				},

				{
					data: 'id',
					mRender: function(data, type, row) {
						var url = ''
						//show/PRD_ID/product
						url += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"> View</a>&#160;';
						if (row.quantity < 1) {
							url += '<a href="javascript:void(0)" class="btn btn-success disabled"> Add to cart</a>';
						}
						else {
							url += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"> Add to cart</a>';
							
						}
						return url;
					}
				}

			]

		});

	}
	
	//Dismissing the alert box after 3 seconds
	var $alert = $('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		}, 3000)
	}
	
	
	
	
});