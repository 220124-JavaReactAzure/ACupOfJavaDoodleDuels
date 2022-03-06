login.js

function login(){
    const data = {
        username: document.getElementById("username").value,
    	pass: document.getElementById("pass").value
    }  

    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json',
                   'Access-Control-Allow-Origin': 'http://localhost:6060',
                   'Access-Control-Allow-Methods':'GET, OPTIONS, POST, PUT'},
        body: JSON.stringify(data)
    };
    fetch('http://localhost:6060/login', requestOptions);
    
}