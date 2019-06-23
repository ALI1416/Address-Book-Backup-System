function showP(s) {
	var show = document.getElementById("show");
	show.innerHTML = s;
}
function getParameter(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
function skip(s) {
	window.location.href = s;
}