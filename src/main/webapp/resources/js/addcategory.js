$( document ).ready(function() {
	
	$("#btn-category").click(function(){		
		category = $('#category').val();		
		if(category != null && category != ""){ 	   
		
			 $.ajax({
				async : false, 
				url : "./addCategory", 
				type : "POST",
				data: {
					category : category 
			    }, 			
				success : function(response) {
					alert(JSON.stringify(response));  
					
				},
				error : function() {
					alert("Error");
				},
			}); 
		}else{
			alert("Blank Field not allowed..."); 
		}
	});	
    
});
