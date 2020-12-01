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

		default:
			$('#home').addClass('active');
			$('#a_'+menu).addClass('active');
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
						
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" width="120" height="100"/>';
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

				{ data: 'quantity' },

				{
					data: 'id',
					mRender: function(data, type, row) {
						var url = ''
						//show/PRD_ID/product
						url += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"> View</a>&#160;';
						url += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"> Add to cart</a>';
						return url;
					}
				}

			]

		});

	}





});