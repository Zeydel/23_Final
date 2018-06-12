$(document).ready(function(){
	var id = getCookie('id');
	getUser(id);
	$("#productBatchComponentTable").show();
})

function getUser(userID){
	$.ajax({
		url : '/23_Final/rest/users/' + userID,
		type : 'GET',
		dataType : 'json',
		success : function(data){
			for(var i = 0; i < data.roles.length; i++){
				var hej = data.roles[i];
				if(data.roles[i] == "Administrator"){
					$("#userTable").show();
				}if (data.roles[i] == "Pharmacologist"){
					$("#recipeTable").show();
					$("#rawMaterialTable").show();
					$("#productBatchTable").show();
					$("#rawMateriablBatchTable").show();
				}if(data.roles[i] == "Production Manager"){
					$("#productBatchTable").show();
					$("#rawMateriablBatchTable").show();
				}
			}
		}
	})


}