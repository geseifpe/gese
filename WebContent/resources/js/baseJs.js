onload = function inicio() {
    var mudarFundo;
    if(mudarFundo === document.querySelector(".navbar-brand").onmouseover) {
        mudarFundo.style.backgroundColor = "gray";
        alert("sdakl");
    }
    else if(mudarFundo === document.querySelector("navbar-brand").onmouseout) {
        mudarFundo.style.backgroundColor = "red";
    }
};
