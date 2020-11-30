$(function(){
	//Solving the active menu problem
	switch(menu){
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
		break;
		
	}
	
	//Code for Jquery Data Table
	//create dataset
	var products =[
		['1','ABC'],
		['2','bh'],
		['3','asf'],
		['4','dvca'],
		['5','nsd'],
		['6','sef'],
		['61','dv'],
		['7','qwdcv'],
		['8','evg'],
		['9','efwva'],
		['10','svDZ'],
		['11','fe']
	];
	
	var $table =$('#productListTable');
	if($table.length){
		/*console.log('inside table');*/
		$table.DataTable({
			pageLength: 5,
			data:products
			
		});
		
	}
	
	
	
	
	
});