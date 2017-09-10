$(function() {
	$("#customerCode").change(function() {
		var customerCode = $("#customerCode").val();
		var param = {
			"customerCode" : customerCode
		};
		$.post("/sales/CustomerVerifyServlet", param, function(data) {
			$("#customerCode").next("span").remove();
			$("#customerCode").after(data);
		}, "html");
	})
})