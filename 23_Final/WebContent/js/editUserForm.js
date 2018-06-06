document.addEventListener('DOMContentLoaded',function(){
	var urr = window.location.href;
	
	console.log(typeof(URL));
	var URL2 = new URL(urr);
	var id = URL2.searchParams.get("id");
	console.log(id);
	getUser(id);
})