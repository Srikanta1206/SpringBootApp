
function validator(frm) {
	document.getElementById("enameErr").innerHTML = "";
	document.getElementById("desgErr").innerHTML = "";
	document.getElementById("salErr").innerHTML = "";
	document.getElementById("deptnoErr").innerHTML = "";

	let ename = frm.ename.value;
	let desg = frm.desg.value;
	let sal = frm.sal.value;
	let deptno = frm.deptno.value;
	let validationFlag = true;
	if (ename = "") {
	 	document.getElementById("enameErr").innerHTML = "Name is Required(cs)";
		validationFlag = false;
	}
	else if (ename.length() < 5) {
		document.getElementById("enameErr").innerHTML = "Neme length must be minimum five Character(cs)";
		validationFlag = false;
	}
	else if (desg = "") {
		document.getElementById("desgErr").innerHTML = "Desg is required(cs)";
		validationFlag = false;
	}
	else if (desg.length() < 5) {
		document.getElementById("desgErr").innerHTML = "Desg must be Minimum 5 character(cs)";
		validationFlag = false;
	}
	else if (sal = "") {
		document.getElementById("salErr").innerHTML = "sal is required(cs)"
		validationFlag = false;
	}
	else if (isNaN(sal)) {
		document.getElementById("salErr").innerHTML = "salary is Numeric Only(cs)"
		validationFlag = false;
	}
	return validationFlag;
}