const emailInp = document.getElementById("email");
const passwordInp = document.getElementById("password");

function verify_acount() {
  emailval = emailInp.value;
  passwordval = passwordInp.value;
  const to_verify = {
    email: emailval,
    password: passwordval,
    id: null,
    name: null,
    adress: null
  };
  console.log(JSON.stringify(to_verify));
  fetch("/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(to_verify)
  })
  .then(response => response.json())
  .then(data => {
    console.log(typeof data);
    if(data != null){
      console.log("Client: ", JSON.stringify(data));
      localStorage.setItem("logged", JSON.stringify(data));
      window.location.href = "/produtos"
    }else{
      document.getElementById("clientDontExist").style.display = 'block';
    }
  }).catch(
    error => console.error("error: ", error),
    document.getElementById("clientDontExist").style.display = 'block'
  );

}
function verify_worker() {
  emailval = emailInp.value;
  passwordval = passwordInp.value;
  const to_verify = {
    email: emailval,
    password: passwordval,
    id: null,
    name: null,
    cpf: null,
    manager: null
  };
  console.log(JSON.stringify(to_verify));
  fetch("/logWorker", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(to_verify)
  })
  .then(response => response.json())
  .then(data => {
    console.log(typeof data);
    if(data != null){
      console.log("Client: ", JSON.stringify(data));
      localStorage.setItem("logged", JSON.stringify(data));
      window.location.href = "/produtos"
    }else{
      document.getElementById("clientDontExist").style.display = 'block';
    }
  }).catch(
    error => console.error("error: ", error),
    document.getElementById("clientDontExist").style.display = 'block'
  );
}