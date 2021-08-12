function yesClick() {
    alert("<3");
}
function noHover() {
    var x = Math.floor(Math.random() * window.innerWidth);
    var y = Math.floor(Math.random() * window.innerHeight);
        document.getElementById("no").style.left = x + "px";
        document.getElementById("no").style.top = y + "px";
}
