var rowlength; //每行多少个单元
var spxxTable; //产品选择表
var rowIndex;
function init() {
	var d = new Date();
	var year = d.getFullYear();
	var month = parseInt(d.getMonth()) + 1 >= 10 ? parseInt(d.getMonth()) + 1 : "0" + (parseInt(d.getMonth()) + 1);
	var date = parseInt(d.getDate()) >= 10 ? parseInt(d.getDate()) : "0" + parseInt(d.getDate());
	var hour = parseInt(d.getHours()) >= 10 ? parseInt(d.getHours()) : "0" + parseInt(d.getHours());
	var minute = parseInt(d.getMinutes()) >= 10 ? parseInt(d.getMinutes()) : "0" + parseInt(d.getMinutes());
	var second = parseInt(d.getSeconds()) >= 10 ? parseInt(d.getSeconds()) : "0" + parseInt(d.getSeconds());
	var soid = "" + year + month + date + hour + minute + second;
	var currentTime = year + "-" + month + "-" + date;
	document.getElementsByName("soid")[0].value = soid;
	document.getElementsByName("createTime")[0].value = currentTime;

	rowlength = document.getElementById("spxxTable").rows[0].cells.length;
	spxxTable = document.getElementById("spxxTable"); //获得产品选择表
}

//逻辑控制
function choiceAnonymous() {
	spxxTable = document.getElementById("spxxTable");
	var len = spxxTable.rows.length;
	var row = document.getElementById("detailTable").childNodes.length - 1;
	var returnValue;
	var i;
	for (i = 1; i < len - 1; i++) {
		if (spxxTable.rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice(i); //获得[产品编号，产品名称，产品单价，数量单位]数组
			setValue();
			hiddenDiv();
			return;
		}
	}
	alert("请先选择商品！");

	function setValue() {
		var detailTable = document.getElementById("detailTable"); //获得产品明细表
		var length = detailTable.rows.length;
		var productCode = document.getElementsByName("productCode");
		var name = document.getElementsByName("name");
		var unitPrice = document.getElementsByName("unitPrice");
		var unitName = document.getElementsByName("unitName");
		var row_index = productCode.length - 1;
		productCode[row_index].value = returnValue[0];
		name[row_index].value = returnValue[1];
		unitPrice[row_index].value = returnValue[2];
		unitName[row_index].value = returnValue[3];
	}
}

function selectItem(tr) {
	clearTable();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
	}
}

function choice(index) {
	rowlength = document.getElementById("spxxTable").rows[0].cells.length;
	var row = document.getElementById("spxxTable").rows[index];
	var result = new Array(rowlength);
	var i;
	for (i = 1; i < rowlength; i++) {
		result[i - 1] = row.cells[i].innerHTML;
	}
	return result;
}

function choiceSpxx(rowIndex_) {
	showDiv();
	rowIndex = rowIndex_; //获得该行索引号
}

//添加一行
function addItem() {
	var detailTable = document.getElementById("detailTable");
	var oRow = detailTable.insertRow(-1); //在表格最后添加一行
	oRow.align = "center";
	oRow.className = "toolbar";
	oCell = oRow.insertCell(0); //添加单元格
	oCell.innerHTML = oRow.rowIndex;
	oCell = oRow.insertCell(1);
	oCell.innerHTML = "<input type='text'  name='productCode' size='10' readonly='readonly' /> <span class='LL'><image src='../images/selectDate.gif' onClick='choiceSpxx(\"" + (oRow.rowIndex - 1) + "\")'></span>";
	oCell = oRow.insertCell(2);
	oCell.innerHTML = "<input type='text' name='name' size='10' readonly='readonly'/>";
	oCell = oRow.insertCell(3);
	oCell.innerHTML = "<input type='text' name='unitPrice' size='10' readonly='readonly' />";
	oCell = oRow.insertCell(4);
	oCell.innerHTML = "<input type='text' name='num' size='10'  onchange='itemPrice_auto(this)' />";
	oCell = oRow.insertCell(5);
	oCell.innerHTML = "<input type='text' name='unitName' size='10' readonly='readonly' />";
	oCell = oRow.insertCell(6);
	oCell.innerHTML = "<input type='text' name='itemPrice' size='10'  readonly='readonly' />";
	oCell = oRow.insertCell(7);
	oCell.innerHTML = "<image style='cursor:pointer' src=\"../images/delete.gif\" class=\"LL\" onclick=\"delItem(" + oRow.rowIndex + ")\"/>";
}

//删除行,注意这里的行号全部要重新计算 刷新的
function delItem(index) {
	var detailTable = document.getElementById("detailTable");
	var productCodeArray = document.getElementsByName("productCode");
	if (productCodeArray.length > 1) {
		detailTable.deleteRow(index);
	} else {
		alert("至少应保留一条明细信息！");
	}
	var rowNum = detailTable.rows.length;
	var rowlength = detailTable.rows[0].cells.length;
	for (i = index; i < rowNum; i++) {
		detailTable.rows[i].cells[0].innerHTML = i;
		detailTable.rows[i].cells[rowlength - 1].innerHTML = "<image src=\"../images/delete.gif\" class=\"LL\" onclick=\"delItem(" + i + ")\"/>";
	}
}

function hiddenDiv() {
	document.getElementById("productDiv").style.visibility = "hidden";
	clearTable();
}

function showDiv() { //显示产品选择模块
	document.getElementById("productDiv").style.visibility = "visible";

}

function clearTable() {
	var spxxTable = document.getElementById("spxxTable");
	var trs = spxxTable.rows;
	for (var i = 1; i < trs.length - 1; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}
}

function productCode_norepeat() {
	var productCodeArr = document.getElementsByName("productCode");
	for (var i = 0; i < productCodeArr.length - 1; i++) {
		if (productCodeArr[i].value === productCodeArr[productCodeArr.length - 1].value) {
			alert("不可重复产品编号。");
			var row = productCodeArr.length;
			document.getElementById("detailTable").deleteRow(row);
			break;
		}
	}
}

function cancelChooseProduct() {
	var productCode = document.getElementsByName("productCode");
	var row = productCode.length;
	document.getElementById("detailTable").deleteRow(row);
}

function deleteThisRow(obj) {
	var productCodeArray = document.getElementsByName("productCode");
	if (productCodeArray.length > 1) {
		var tr = obj.parentNode.parentNode;
		document.getElementsByName("dsoitem_soid")[0].value = document.getElementsByName("soid")[0].value;
		document.getElementsByName("dsoitem1")[0].value = tr.cells[1].childNodes[0].value;
		document.getElementsByName("dsoitem2")[0].value = tr.cells[4].childNodes[0].value;
		var productTotal = document.getElementsByName("productTotal")[0].value;
		productTotal = parseInt(productTotal) - parseInt(tr.cells[6].childNodes[0].value);
		document.getElementsByName("productTotal_new")[0].value = productTotal;
		var row = tr.rowIndex;
		document.getElementById("detailTable").deleteRow(row);
		var detailTable = document.getElementById("detailTable");
		var rowNum = detailTable.rows.length;
		var rowlength = detailTable.rows[0].cells.length;
		for (i = 1; i < rowNum; i++) {
			detailTable.rows[i].cells[0].innerHTML = i;
		}
		document.getElementById("dsoitem").submit();
	} else {
		alert("至少应保留一条明细信息！");
	}
}

function getVar(obj) {
	document.getElementById("hidden_soid").value = obj.parentNode.parentNode.cells[1].innerHTML;
	document.getElementById("hidden_form").submit();
}

function chooseSale(obj) {
	var ifChosen = obj.parentNode.cells[0];
	var chooses = document.getElementsByClassName("choose");
	if (ifChosen.innerHTML == "") {
		for (var i = 0; i < chooses.length; i++) {
			chooses[i].innerHTML = "";
		}
		ifChosen.innerHTML = "√";
	} else if (ifChosen.innerHTML == "√") {
		for (var i = 0; i < chooses.length; i++) {
			chooses[i].innerHTML = "";
		}
		ifChosen.innerHTML = "";
	}
}

function showSoitem() {
	var chooses = document.getElementsByClassName("choose");
	var flag = false;
	for (var i = 0; i < chooses.length; i++) {
		if (chooses[i].innerHTML === "√") {
			flag = true;
			document.getElementById("soid_checked").value = chooses[i].parentNode.cells[1].innerHTML;
			break;
		}
	}
	if (!flag) {
		alert("请选择要查看明细的主销售单！");
	}
	if (flag) {
		document.getElementById("showSoitem").submit();
	}
}

function deleteSomain(obj) {
	if (confirm("确认删除销售单主信息及其明细信息？")) {
		var row = obj.parentNode.parentNode.rowIndex;
		document.getElementById("somain_checked").value = obj.parentNode.parentNode.cells[1].innerHTML;
		document.getElementsByClassName("c")[0].deleteRow(row);
		document.getElementById("deleteSomain").submit();
	}
}

function itemPrice_auto(tr) {
	var row = tr.parentNode.parentNode.rowIndex;
	var unitPrice = document.getElementsByName("unitPrice")[row - 1].value;
	var num = document.getElementsByName("num")[row - 1].value;
	document.getElementsByName("itemPrice")[row - 1].value = unitPrice * num;

	var itemPriceArr = document.getElementsByName("itemPrice");
	var productTotal = 0;
	for (var i = 0; i < itemPriceArr.length; i++) {
		productTotal += parseFloat(itemPriceArr[i].value);
	}
	document.getElementsByName("productTotal")[0].value = productTotal.toFixed(2);
}

function chooseCustomer() {
	var chooseCustomer = document.getElementById("chooseCustomer");
	chooseCustomer.style.display = "block";
}

function confirmChooseCustomer() {
	var temp = document.getElementById("customerCode").value.split(" ");
	document.getElementById("i3").value = temp[0];
	document.getElementById("customerCode").value = "";
	document.getElementById("chooseCustomer").style.display = "none";
}

function confirmChooseCustomer1() {
	var temp = document.getElementById("customerCode").value.split(" ");
	document.getElementsByName("customerCode")[0].value = temp[0];
	document.getElementById("customerCode").value = "";
	document.getElementById("chooseCustomer").style.display = "none";
}

function choosePayType() {
	if (document.getElementsByName("payType")[0].value === "预付款发货") {
		document.getElementsByName("prePayFee")[0].readOnly = false;
	} else {
		document.getElementsByName("prePayFee")[0].readOnly = true;
		document.getElementsByName("prePayFee")[0].value = "0";
	}
}

function reset() {
	var d = new Date();
	var year = d.getFullYear();
	var month = parseInt(d.getMonth()) + 1 >= 10 ? parseInt(d.getMonth()) + 1 : "0" + (parseInt(d.getMonth()) + 1);
	var date = parseInt(d.getDate()) >= 10 ? parseInt(d.getDate()) : "0" + parseInt(d.getDate());
	var hour = parseInt(d.getHours()) >= 10 ? parseInt(d.getHours()) : "0" + parseInt(d.getHours());
	var minute = parseInt(d.getMinutes()) >= 10 ? parseInt(d.getMinutes()) : "0" + parseInt(d.getMinutes());
	var second = parseInt(d.getSeconds()) >= 10 ? parseInt(d.getSeconds()) : "0" + parseInt(d.getSeconds());
	var soid = "" + year + month + date + hour + minute + second;
	var currentTime = year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
	document.getElementsByName("soid")[0].value = soid;
	document.getElementsByName("createTime")[0].value = currentTime;
}

function check() {
	var flag = true;
	if (document.getElementsByName("customerCode")[0].value === "") {
		flag = false;
		alert("客户名称不能为空！");
	}
	if (document.getElementsByName("status")[0].value === "") {
		flag = false;
		alert("处理状态不能为空！");
	}
	if (flag) {
		document.getElementById("addSale").submit();
	}
}

function closeWindow() {
	window.close();
}

function cancelChooseCustomer() {
	document.getElementById("customerCode").value = "";
	document.getElementById("chooseCustomer").style.display = "none";
}

function reset() {
	var d = new Date();
	var year = d.getFullYear();
	var month = parseInt(d.getMonth()) + 1 >= 10 ? parseInt(d.getMonth()) + 1 : "0" + (parseInt(d.getMonth()) + 1);
	var date = parseInt(d.getDate()) >= 10 ? parseInt(d.getDate()) : "0" + parseInt(d.getDate());
	var hour = parseInt(d.getHours()) >= 10 ? parseInt(d.getHours()) : "0" + parseInt(d.getHours());
	var minute = parseInt(d.getMinutes()) >= 10 ? parseInt(d.getMinutes()) : "0" + parseInt(d.getMinutes());
	var second = parseInt(d.getSeconds()) >= 10 ? parseInt(d.getSeconds()) : "0" + parseInt(d.getSeconds());
	var soid = "" + year + month + date + hour + minute + second;
	var currentTime = year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
	document.getElementsByName("soid")[0].value = soid;
	document.getElementsByName("createTime")[0].value = currentTime;
}

function check() {
	var flag = true;
	var tipFeeReg = /^\d*\.\d{1,2}$/;
	var tipFeeReg1 = /^[1-9]\d*$/;
	var prePayFeeReg = /^\d*\.\d{1,2}$/;
	var prePayFeeReg1 = /^[1-9]\d*$/;
	var unitPriceReg = /^\d*\.\d{1,2}$/;
	var unitPriceReg1 = /^[1-9]\d*$/;
	var numReg = /[1-9]\d*/;
	var tipFee = document.getElementsByName("tipFee")[0].value;
	var prePayFee = document.getElementsByName("prePayFee")[0].value;
	var unitPriceArray = document.getElementsByName("unitPrice");
	var numArray = document.getElementsByName("num");
	if (!tipFeeReg.test(tipFee) && !tipFeeReg1.test(tipFee) && tipFee !== "0") {
		flag = false;
		alert("附加费用格式不正确！");
		return;
	}
	if (!prePayFeeReg.test(prePayFee) && !prePayFeeReg1.test(prePayFee) && prePayFee !== "0") {
		flag = false;
		alert("最低预付款金额格式不正确！");
		return;
	}
	if (document.getElementsByName("customerCode")[0].value === "") {
		flag = false;
		alert("客户名称不能为空！");
		return;
	}
	if (document.getElementsByName("payType")[0].value === "") {
		flag = false;
		alert("付款方式不能为空！");
		return;
	}
	for (var i = 0; i < unitPriceArray.length; i++) {
		if (!unitPriceReg.test(unitPriceArray[i].value) && !unitPriceReg1.test(unitPriceArray[i].value)) {
			alert("第" + (i + 1) + "条产品明细的产品单价格式不正确！");
			flag = false;
			return;
		}
	}
	//	for (var i = 0; i < numArray.length; i++) {
	//		alert((numArray[i]).value);
	//		alert((numArray[i]).value.length);
	//		if (!numReg.test(numArray[i]).value) {
	//			alert("第" + (i + 1) + "条产品明细的产品数量格式不正确！");
	//			flag = false;
	//			return;
	//		}
	//	}
	if (flag) {
		document.getElementById("addSale").submit();
	}
}

function update() {
	document.getElementById("m").style.display = "none";
	document.getElementById("add").style.display = "block";
}

function re() {
	document.getElementById("m").style.display = "block";
	document.getElementById("add").style.display = "none";
}

function chooseCustomer() {
	var chooseCustomer = document.getElementById("chooseCustomer");
	chooseCustomer.style.display = "block";
}

function queryPrecisely() {
	var startTime = document.getElementById("i2").value;
	var endTime = document.getElementById("i6").value;
	var timeReg1 = /[1-2]\d{3}-0[1-9]/;
	var timeReg2 = /[1-2]\d{3}-1[1-2]/;
	if (startTime !== "" && endTime === "") {
		alert("请填入结束时间！");
		return;
	}
	if (endTime !== "" && startTime === "") {
		alert("请填入起始时间！");
		return;
	}
	if (!timeReg1.test(startTime) && !timeReg2.test(startTime)) {
		alert("起始时间格式不正确！")
		startTime = "";
		return;
	}
	if (!timeReg1.test(endTime) && !timeReg2.test(endTime)) {
		alert("结束时间格式不正确！")
		endTime = "";
		return;
	}
	if (document.getElementById("i1").value.length === 0 && document.getElementById("i2").value.length === 0 &&
		document.getElementById("i3").value.length === 0 && document.getElementById("i4").value.length === 0 &&
		document.getElementById("i5").value.length === 0 && document.getElementById("i6").value.length === 0) {
		alert("请输入查询内容！");
	} else {
		document.getElementById("h1").value = document.getElementById("i1").value.trim();
		document.getElementById("h2").value = document.getElementById("i2").value.trim();
		document.getElementById("h3").value = document.getElementById("i3").value.trim();
		document.getElementById("h4").value = document.getElementById("i4").value.trim();
		document.getElementById("h5").value = document.getElementById("i5").value.trim();
		document.getElementById("h6").value = document.getElementById("i6").value.trim();
		document.getElementById("queryPrecisely").submit();
	}
}

function queryAll() {
	document.getElementById("queryAll").submit();
}

function dataTest() {
	var flag = true;
	var tipFeeReg = /^\d*\.\d{1,2}$/;
	var tipFeeReg1 = /^[1-9]\d*$/;
	var prePayFeeReg = /^\d*\.\d{1,2}$/;
	var prePayFeeReg1 = /^[1-9]\d*$/;
	var unitPriceReg = /^\d*\.\d{1,2}$/;
	var unitPriceReg1 = /^[1-9]\d*$/;
	var numReg = /^[1-9]\d*$/;
	var tipFee = document.getElementsByName("tipFee")[0].value;
	var prePayFee = document.getElementsByName("prePayFee")[0].value;
	var unitPriceArray = document.getElementsByName("unitPrice");
	var numArray = document.getElementsByName("num");
	if (!tipFeeReg.test(tipFee) && !tipFeeReg1.test(tipFee) && tipFee !== "0") {
		flag = false;
		alert("附加费用格式不正确！");
		return;
	}
	if (!prePayFeeReg.test(prePayFee) && !prePayFeeReg1.test(prePayFee) && prePayFee !== "0") {
		flag = false;
		alert("最低预付款金额格式不正确！");
		return;
	}
	for (var i = 0; i < unitPriceArray.length; i++) {
		if (!unitPriceReg.test(unitPriceArray[i].value) && !unitPriceReg1.test(unitPriceArray[i].value)) {
			alert("第" + (i + 1) + "条产品明细的产品单价格式不正确！");
			flag = false;
			return;
		}
	}
	for (var i = 0; i < numArray.length; i++) {
		if (numReg.test(numArray[i]).value) {
			alert("第" + (i + 1) + "条产品明细的产品数量格式不正确！");
			flag = false;
			return;
		}
	}
	if (flag) {
		document.getElementById("edition").submit();
	}
}

function showQueryCustomer() {
	document.getElementById("queryCustomer").style.display = "block";
}

function queryCustomer() {
	document.getElementById("queryCustomer").action = "/sales/CustomerQueryServlet";
	var i1_value = document.getElementById("i1").value;
	var i2_value = document.getElementById("i2").value;
	var i3_value = document.getElementById("i3").value;
	if (i1_value !== "" && i2_value !== "" && i3_value === "") {
		alert("请选择查询条件！");
	} else if (i1_value === "" && i2_value === "") {
		alert("请添加查询字段！");
	} else {
		i1_value = "";
		i2_value = "";
		i3_value = "";
		document.getElementById("queryCustomer").style.display = "none";
		document.getElementById("queryCustomer").submit();
	}
}

function queryCustomerAll() {
	document.getElementById("queryCustomer").style.display = "none";
	document.getElementById("queryCustomer").action = "/sales/CustomerQueryPageServlet";
	document.getElementById("queryCustomer").submit();

}

function showAddCustomer() {
	var adds = document.getElementsByClassName("add");
	for (var i = 0; i < adds.length; i++) {
		adds[i].value = "";
	}
	document.getElementById("addCustomer").style.display = "block";
}

function cancelAddCustomer() {
	document.getElementById("addCustomer").style.display = "none";
}

function confirmAddCustomer() {
	var flag = true;
	var customerCode = document.getElementsByName("customerCode")[0].value;
	var name = document.getElementsByName("name")[0].value;
	var password = document.getElementsByName("password")[0].value;
	var contactor = document.getElementsByName("contactor")[0].value;
	var tel = document.getElementsByName("tel")[0].value;
	var customerCodeReg = /^[0-9a-zA-Z]{4,20}$/;
	var nameReg = /^\w{1,100}$/;
	var passwordReg = /^\w{4,20}$/;
	if (!customerCodeReg.test(customerCode)) {
		flag = false;
		alert("客户编号格式不正确！")
		return;
	}
	if (!nameReg.test(name)) {
		flag = false;
		alert("客户名称格式不正确！")
		return;
	}
	if (!passwordReg.test(password)) {
		flag = false;
		alert("客户密码格式不正确！")
		return;
	}
	if (contactor === "") {
		flag = false;
		alert("联系人不能为空！")
		return;
	}
	if (tel === "") {
		flag = false;
		alert("电话不能为空！")
		return;
	}
	if (flag) {
		document.getElementById("addCustomer").submit();
		document.getElementById("addCustomer").style.display = "none";
	}
}

function createDate_auto() {
	var d = new Date();
	var year = d.getFullYear();
	var month = parseInt(d.getMonth()) + 1 >= 10 ? parseInt(d.getMonth()) + 1 : "0" + (parseInt(d.getMonth()) + 1);
	var date = parseInt(d.getDate()) >= 10 ? parseInt(d.getDate()) : "0" + parseInt(d.getDate());
	var hour = parseInt(d.getHours()) >= 10 ? parseInt(d.getHours()) : "0" + parseInt(d.getHours());
	var minute = parseInt(d.getMinutes()) >= 10 ? parseInt(d.getMinutes()) : "0" + parseInt(d.getMinutes());
	var second = parseInt(d.getSeconds()) >= 10 ? parseInt(d.getSeconds()) : "0" + parseInt(d.getSeconds());
	var currentTime = year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
	document.getElementsByName("createDate")[0].value = currentTime;
}

function password_auto() {
	document.getElementsByName("password")[0].value = document.getElementsByName("customerCode")[0].value
}

function showUpdateCustomer(obj) {
	document.getElementById("updateCustomer").style.display = "block";
}

function modify(obj) {
	var tr = obj.parentNode.parentNode;
	document.getElementsByName("cc")[0].value = tr.cells[0].innerHTML;
	document.getElementById("modify").submit();
}

function confirmUpdateCustomer() {
	var flag = true;
	var name = document.getElementsByName("nameUpdate")[0].value;
	var password = document.getElementsByName("passwordUpdate")[0].value;
	var contactor = document.getElementsByName("contactorUpdate")[0].value;
	var tel = document.getElementsByName("telUpdate")[0].value;
	var nameReg = /^\w{1,100}$/;
	var passwordReg = /^\w{4,20}$/;
	if (!nameReg.test(name)) {
		flag = false;
		alert("客户名称格式不正确！")
		return;
	}
	if (!passwordReg.test(password)) {
		flag = false;
		alert("客户密码格式不正确！")
		return;
	}
	if (contactor === "") {
		flag = false;
		alert("联系人不能为空！")
		return;
	}
	if (tel === "") {
		flag = false;
		alert("电话不能为空！")
		return;
	}
	if (flag) {
		document.getElementById("updateCustomer").submit();
		document.getElementById("updateCustomer").style.display = "none";
	}
}

function cancelUpdateCustomer() {
	document.getElementById("updateCustomer").style.display = "none";
}

function deleteCustomer(obj) {
	if (confirm("确认删除该条客户记录？")) {
		document.getElementsByName("cc1")[0].value = obj.parentNode.parentNode.cells[0].innerHTML;
		document.getElementById("delete").submit();
	}
}

function toggleChoose(event) {
	if (event.target.className === "ci") {
		var tr = event.target.parentNode;
		if (tr.className === "no") {
			tr.cells[0].style.backgroundColor = "red";
			tr.className = "yes";
		} else {
			tr.cells[0].style.backgroundColor = "#fff7e5";
			tr.className = "no";
		}
	}
}

function deleteCustomers() {
	if (confirm("确认批量删除客户记录？")) {
		var yesArr = document.getElementsByClassName("yes");
		var temp = [];
		for (var i = 0; i < yesArr.length; i++) {
			temp.push(yesArr[i].cells[0].innerHTML);
		}
		var str = temp.join("-");
		document.getElementsByName("cc2")[0].value = str;
		document.getElementById("deletes").submit();
	}
}

function finish(obj) {
	if (confirm("确认了结此销售单？")) {
		document.getElementById("soid_finished").value = obj.parentNode.parentNode.cells[1].innerHTML;
		document.getElementById("finishSoitem").submit();
	}
}

function querySheet() {
	var startTime = document.getElementsByName("start")[0].value;
	var endTime = document.getElementsByName("end")[0].value;
	var timeReg1 = /[1-2]\d{3}-0[1-9]/;
	var timeReg2 = /[1-2]\d{3}-1[1-2]/;
	if (startTime !== "" && endTime === "") {
		alert("请填入结束时间！");
		return;
	}
	if (endTime !== "" && startTime === "") {
		alert("请填入起始时间！");
		return;
	}
	if (!timeReg1.test(startTime) && !timeReg2.test(startTime)) {
		alert("起始时间格式不正确！")
		startTime = "";
		return;
	}
	if (!timeReg1.test(endTime) && !timeReg2.test(endTime)) {
		alert("结束时间格式不正确！")
		endTime = "";
		return;
	}
	document.getElementById("getSheet").submit();
}