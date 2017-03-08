$( document ).ready(function() {
		
		/* Default update button inactive */
		$('#update-btn').prop('disabled', true);
		
		/*message = "${message}";
	    if(message==""){ 
	    	
	    }else{
	    	alert(message);
	    }  */ 
	        
	    /* Reset Functionality */
	    $("#reset-btn").click(function(){    	
	    	$("#update-btn").prop('disabled', true); 
	    	$("#id").val(""); 
	    	$("#productName").val(""); 
	    	$("#categoryId").val("");
	    	$("#productPrice").val("");
	    	$("#productQuantity").val("");
	    	$("#imageName").val("");	    	
	    });
	    
	    /* Update Product Functionality */
	    /*$("#update-btn").click(function(){
	    	var id = $("#prdId").val();
			var productName = $("#productName").val(); 
			var categoryId = $("#categoryId").val();
			var productPrice = $("#productPrice").val();
			var productQuantity = $("#productQuantity").val();
			var imageName = $("#imageName").val();
			
	    	if(id!="" && productName != "" && categoryId !="" && productPrice != "" && productQuantity != "" && imageName != ""){
	    		$.ajax({
	    			async : false,
	    			url : "./updateProduct",		    		
	    			type : "POST",
	    			data : {
	    				id:id,
	    				productName : productName,
	    				categoryId : categoryId,
	    				productPrice : productPrice,
	    				productQuantity :productQuantity,
	    				imageName : imageName
	    			},
	    			success : function(response) {	    				
	    				alert(JSON.stringify(response));   
	    			},
	    			error : function() {
	    				alert("Errossr"); 
	    			},
	    		});	
	    	}else{
	    		alert("Blank fields not allowed...");
	    	}
	    });*/
	});
	
	 /* Edit Functionality */
	function edit(event,id,prdName,categoryId,prdPrice,prdQty,prdImg){	
		$("#update-btn").prop('disabled', false); 
		$("#id").val(id); 
		$("#productName").val(prdName); 
		$("#categoryId").val(categoryId);
		$("#productPrice").val(prdPrice);
		$("#productQuantity").val(prdQty);
		$("#imageName").val(prdImg);	
	}