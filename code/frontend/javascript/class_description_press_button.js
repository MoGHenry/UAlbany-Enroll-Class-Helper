// Get the modal
const modal = document.getElementsByClassName("modal")[0];

// Get the button that opens the modal
const btn = document.getElementById("class-1");

// Get the <span> element that closes the modal
const close_btn = document.getElementsByClassName("btn-close")[0];
const close_btn2 = document.getElementsByClassName("btn-secondary")[0];
// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
close_btn.onclick = function() {
    modal.style.display = "none";
}
close_btn2.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
    }
}