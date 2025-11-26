const user = JSON.parse(localStorage.getItem("logged"));
const profile = document.getElementById("user");
profile.textContent = user.name;