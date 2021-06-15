// 显示下拉
(function showModel() {
    var clickDom = document.getElementById("userId");
    var showDom = document.getElementById("showId");
    clickDom.onclick = function (event) {
        event.stopPropagation(); //阻止冒泡
        showDom.style.top = "50px";
        showDom.style.opacity = 1;
    }
})();
//隐藏下拉
(function hideModel() {
    var clickDom = document.getElementById("bodyId");
    var showDom = document.getElementById("showId");
    clickDom.onclick = function () {
        showDom.style.top = "-200px";
        showDom.style.opacity = 0;
    }
})();
//修改弹窗
(function editShowModel() {
    var clickDom = document.getElementsByClassName("edit");
    var maskDom = document.getElementById("editMask");
    var formDom = document.getElementById("editForm");
    for(var i = 0; i < clickDom.length; i++){
        clickDom[i].onclick = function () {
            maskDom.style.display = "block";
            formDom.style.display = "block";
        }
    }
})();
(function editHideModel() {
    var clickDom = document.getElementById("cancel");
    var maskDom = document.getElementById("editMask");
    var formDom = document.getElementById("editForm");
    clickDom.onclick = function () {
        maskDom.style.display = "none";
        formDom.style.display = "none";
    }
})();