$(document).ready(function() {		
		/*if ("${cartMessage}" == "") {

		} else {
			alert('${cartMessage}');
		}	*/	
		
		$("#categoryId").on('change', function() {
			categoryId = $('#categoryId').val();
			$.ajax({
				async : false,
				url : "./getProductByCategory",
				mimeType: "text/plain; charset=x-user-defined",
				dataType : "json",
				type : "POST",
				data : {
					categoryId : categoryId
				},
				success : function(response) {
					var tbody = '';
					var tb;
					var insertrow;
					var srno = 1;			
					$.each(response,function(index,product) {					
						
						var img = '<img src="/demo/resources/images/' 
							+ product.imageName
							+'.jpg" width="50"/>';   
						
						insertrow = ' <tr>'
								+ '	<td align="center"><input type = "hidden" name="id">'								
								+ product.productName
								+ '</td>'
								+ "<td align='center'>"
								+ img 
								+ "</td>"
								+ '<td align="center"> Rs.&nbsp;&nbsp;&nbsp;'
								+ product.productPrice
								+ '/-&nbsp;&nbsp;only</td>' 
								+ '<td align="center">&nbsp;&nbsp;&nbsp;'
								+ product.productQuantity 
								+ '</td>'
								+ "<td align='center'><input type=\"button\"  tabindex=\"5\""
								+ "name=\"coursecheckbox\" class=\"checkboxMandatory coursecheckbox\" onclick=\"addToCart("+product.id+")\" value=\"Add To Cart	"
								+ "\" id=\"order\">"								
								+ '</td>'
								+ "<td align='center'><input type=\"button\"  tabindex=\"5\""
								+ "name=\"coursecheckbox\" class=\"checkboxMandatory coursecheckbox\" onclick=\"orderNow("+product.id+")\" value=\"Make Order	"
								+ "\" id=\"order\">"								
								+ '</td>'
								+ '<tr>' 

						if (tbody == '') {
							tbody = insertrow;
						} else {
							tbody = tbody
									+ insertrow;
						}
						srno++;
					});
					$("#tablediv").empty().append(tbody);
					$("#tablediv").show();
					
				},
				error : function() {
					alert("Error");
				},
			});
		});
	});
	
	/** Function to call Add to cart product method*/
	function addToCart(productid){		 
		window.location = "./addToCart?id="+productid;		
	}
	/** Function to call for Order now method  */
	function orderNow(productid){
		window.location = "./addToCart?id="+productid;
	}