
$( document ).ready(function() {
	
		/* Default update button inactive */
		$('#update-btn').prop('disabled', true);
	        
	    /* Reset Functionality */
	    $("#reset-btn").click(function(){    	
	    	$("#update-btn").prop('disabled', true); 
	    	$("#id").val("");
	    	$("#categoryName").val(""); 	    		    	
	    });
	    
	    /* Update Product Functionality */
	   /* $("#update-btn").click(function(){
	    	var id = $("#id").val();
			var categoryName = $("#categoryName").val(); 	
			alert(id +": :"+categoryName);
			
	    	if(id!="" && categoryName != ""){
	    		$.ajax({
	    			async : false,
	    			url : "./updateCategory",		    		
	    			type : "POST",
	    			data : {
	    				id:id,
	    				categoryName : categoryName
	    			},
	    			success : function(response) {	    				
	    				alert(JSON.stringify(response));   
	    			},
	    			error : function() {
	    				alert("Error"); 
	    			},
	    		});	
	    	}else{
	    		alert("Blank fields not allowed...");
	    	}
	    });*/
	});
	
	 /* Edit Functionality */
	function edit(event,id,catName){	
		$("#update-btn").prop('disabled', false); 
		$("#id").val(id);
		$("#categoryName").val(catName);
	}
	function removeCategory(categoryId){		 
		window.location = "./removeCategory?id="+categoryId;		
	}
	