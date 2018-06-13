$(document).ready(function(){
	
	getProductBatch(1)
	
})

// this part works 
var productBatch; 
function getProductBatch(productBatchID){ // contains productBatchID, status and recipeID from productBatch table
	
		$.ajax({
			url : '/23_Final/rest/productbatchviews/' + productBatchID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				productBatch = data;
				console.log(data)
				getRecipeComponents(data.recipeID)
				getProductBatchComponent(productBatchID)
				
			}
		})    
}


//this works too
var recipeComponents;
function getRecipeComponents(value){ // contains recipeID, rawMaterialID, nom_netto and tolerance from recipeComponent table x
	$.ajax({
		url : '/23_Final/rest/recipeComponent/recipes/' + value,
		type : 'GET',
		dataType : 'json',
		success : function(data){
			recipeComponent = data;
			console.log(data)

			$.each(data, function(i, el){
				getRawMaterial(el.rawMaterialID)
				//$('#rawMaterialTableBody').append(generateRawMaterialHTML(el));
			})
			
			//getRawMaterial(data.rawMaterialID)

		}
	})
}

function getRawMaterial(rawMaterialID){ // contains rawMaterialID, rawMaterialName and supplier from rawMaterial table
	$.ajax({
		url : '/23_Final/rest/rawmaterial/' + rawMaterialID,
		type : 'GET',
		async: false,
		dataType : 'json',
		success : function(data){
			console.log(data)
		}
	})
}

function getProductBatchComponent(productBatchID){ // contains productBatchID, rawMaterialBatchID, tara, netto and userID from productBatchComponent table  
	$.ajax({
		url : '/23_Final/rest/ProductBatchComponent/' + productBatchID,
		type : 'GET',
		dataType : 'json',
		success : function(data){
			$.each(data, function(i, el){
				console.log(el)
				
			})
		}
	})
}


