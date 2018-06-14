$(document).ready(function(){
var urr = window.location.href;
	
	console.log(typeof(URL));
	var URL2 = new URL(urr);
	var id = URL2.searchParams.get("id");
	console.log(id);	
	
	getProductBatch(id)
	
})

// this part works 
var tempProductBatchID; 
function getProductBatch(productBatchID){ // contains productBatchID, status and recipeID from productBatch table
	
		tempProductBatchID = productBatchID
		
		$.ajax({
			url : '/23_Final/rest/productbatchviews/' + productBatchID,
			type : 'GET',
			dataType : 'json',
			success : function(data){
				productBatch = data;
				console.log(data)
				$('#productBatchNr').append(data.productBatchID)
				$('#recipeNr').append(data.recipeID)

				getRecipeComponents(data.recipeID)
				
				 getProductBatchComponent(data.productBatchID)
				 
				//getProductBatchComponent(productBatchID)
				
			}
		})    
}


//this works too
var recipeComponents;
function getRecipeComponents(value){ // contains recipeID, rawMaterialID, nom_netto and tolerance from recipeComponent table x
	$.ajax({
		url : '/23_Final/rest/recipeComponent/recipes/' + value,
		type : 'GET',
		async:false,
		dataType : 'json',
		success : function(data){
			recipeComponent = data;
			console.log(data)

			$.each(data, function(i, el){
				$('#productionTable').append("<tr><td>Rawmaterial ID: " + el.rawMaterialID + "</td></tr>" +
						"<tr><td id='" + el.rawMaterialID + "name'>Rawmaterial name: </td></tr>" +
						"<tr id='" + el.rawMaterialID +"'><td>Nom netto: " + el.nom_netto + "</td><td>Tolerance: " + el.tolerance + "</td></tr>"
)

				//getRawMaterial(el.rawMaterialID)	
			})
			
			//getRawMaterial(data.rawMaterialID)

		}
	})
}

function getProductBatchComponent(productBatchID){ // contains productBatchID, rawMaterialBatchID, tara, netto and userID from productBatchComponent table  
	$.ajax({
		url : '/23_Final/rest/ProductBatchComponent/' + productBatchID,
		type : 'GET',
		async:false,
		dataType : 'json',
		success : function(data){
			console.log(data)
			$.each(data, function(i, el){
				var temp = getRawMaterialBatch(el.rawMaterialBatchID)
				console.log(temp)
				$("#"+temp+"Table").append = "test"

				$("#"+temp+"").append( "<td>Tara: " + el.tara + "</td><td>Netto: " + el.netto + "</td><td>User ID: " + el.userID +"</td>")
			})
				
			
		}
	})
}

function getRawMaterialBatch(rawMaterialBatchID) {// contains rawMaterialBatchID, rawMaterialID, amount and rawMaterialName from rawMaterialBatchID
	var tempRawMaterialID
	$.ajax({
		url : '/23_Final/rest/rawMaterialBatch/' + rawMaterialBatchID,
		type : 'GET',
		async: false,
		dataType : 'json',
		success : function(data){
			console.log(data)

			tempRawMaterialID = data.rawMaterialID
			console.log(tempRawMaterialID)
			getRawMaterial(data.rawMaterialID)
		}
	})
	return tempRawMaterialID;

}

function getRawMaterial(rawMaterialID){ // contains rawMaterialID, rawMaterialName and supplier from rawMaterial table
	$.ajax({
		url : '/23_Final/rest/rawmaterial/' + rawMaterialID,
		type : 'GET',
		async: false,
		dataType : 'json',
		success : function(data){
			console.log(data)
			$("#"+data.rawMaterialID+"name").append(data.rawMaterialName)
			
			//getRawMaterialBatch(data.rawMaterialID)
		}
	})
}







